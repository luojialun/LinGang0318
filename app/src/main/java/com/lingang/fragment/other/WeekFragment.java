package com.lingang.fragment.other;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.WeekAc;
import com.lingang.adapter.WeekExpanAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.MeetingByWeekBean;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.utils.HttpLoading;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @name LinGang
 * @class name：com.lingang.fragment.other
 * @class describe
 * @anthor Administrator
 * @time 2017/5/31 0031 11:21
 * @change
 * @chang time
 * @class describe
 */
public class WeekFragment extends BaseFragment implements RefreshListion, ExpandableListView.OnGroupClickListener {
    @BindView(R.id.lv_week)
    ExpandableListView lvWeek;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    Unbinder unbinder;
    private View entryView;
    private String groupCD;
    private WeekExpanAdapter weekExpanAdapter, rightWeekExpanAdapter;
    private ArrayList<String> parent, rightParent;
    private ArrayList<List<MeetingByWeekBean.DataBean.MeetingValueBean>> children, rightChildren;
    private String sign = "left";
    protected boolean isInit = false;
    protected boolean isLoad = false;//防止fragment 预加载
    private String startTime;
    private String endTime;
    private String todayDateTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_week, null);
        unbinder = ButterKnife.bind(this, inflate);
        entryView = inflater.inflate(R.layout.entry_layout, null);
        isInit = true;
        isCanLoadData();
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
//        int num = (int) getArguments().get("num");
        String time = (String) getArguments().get("time");
        groupCD = (String) getArguments().get("GroupCD");
        //获取当前时间
        todayDateTime = DateUtils.getTodayDateTime("yyyy-MM-dd");

        String[] split = time.split("-");

        startTime = getReplace(split[0]);
        endTime = getReplace(split[1]);
        getServicesData(isLoad);//不可见状态不加载数据  防止预加载数据错乱

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    private void isCanLoadData() {
        if (isInit && getUserVisibleHint()) {
            isLoad = true;
        } else {
            isLoad = false;
        }
    }

    private void initView() {
        parent = new ArrayList<>();
        children = new ArrayList<>();

        rightParent = new ArrayList<>();
        rightChildren = new ArrayList<>();

        setRefreshHead(refresh);
        refresh.setEnableLoadmore(false);
        refresh.setOverScrollBottomShow(false);
        setRefreshLison(refresh, this);

        entryView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ((ViewGroup) lvWeek.getParent()).addView(entryView);
        lvWeek.setEmptyView(entryView);
        lvWeek.setOnGroupClickListener(this);
    }

    //获取组织日程
    private void getMeetingbyWeek() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("useraccount", LoginManager.getInstance().getUserInfo().getUserAccount());
        httpParams.put("startdate", startTime);
        httpParams.put("GroupCD", groupCD);
        httpParams.put("enddate", endTime);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.MeetingbyWeek)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<String, Object>>(getActivity(), false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        if (adressBean !=null && !adressBean.getData().equals("")) {
                            analysisData(adressBean, HttpApi.MeetingbyWeek);
                        } else {
                            hideLoading();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        hideLoading();
                    }
                });

    }

    private void analysisData(BaseEntity<String, Object> adressBean, String tag) {
        if(adressBean !=null && adressBean.getData() !=null) {
            String result = adressBean.getData();

            Gson gson = new Gson();
            MeetingByWeekBean meetingByWeekBean = gson.fromJson(result.replaceAll("\\\\", ""), MeetingByWeekBean.class);
            List<MeetingByWeekBean.DataBean> data = meetingByWeekBean.getData();
            if (data != null && data.size() != 0) {
                if (tag.equals(HttpApi.MeetingbyWeek)) {
                    setData(parent, children, data);
                } else {
                    setData(rightParent, rightChildren, data);
                }
            }


            if (tag.equals(HttpApi.MeetingbyWeek)) {
                for (int i = 0; i < weekExpanAdapter.getGroupCount(); i++) {//默认打开二级菜单
                    lvWeek.expandGroup(i);
                }
            } else {
                for (int i = 0; i < rightWeekExpanAdapter.getGroupCount(); i++) {
                    lvWeek.expandGroup(i);
                }
            }

            String s = todayDateTime + "  " + DateUtils.changeweek(String.valueOf(DateUtils.dataOne(todayDateTime, "yyyy-MM-dd")));
            for (int i = 0; i < parent.size(); i++) {//判断是否存在当前日期  存在则滚动到当前日期
                if (parent.get(i).equals(s)) {
                    lvWeek.setSelectedGroup(i);
                }
            }
        }
        hideLoading();
    }

    private void setData(ArrayList<String> parent, ArrayList<List<MeetingByWeekBean.DataBean.MeetingValueBean>> children, List<MeetingByWeekBean.DataBean> data) {

        for (MeetingByWeekBean.DataBean dataBean : data) {
            List<MeetingByWeekBean.DataBean.MeetingValueBean> meetingValue = dataBean.getMeetingValue();
            if (meetingValue.size() > 0) {
                String meetingDate = dataBean.getMeetingDate();
                parent.add(meetingDate + "  " + DateUtils.changeweek(String.valueOf(DateUtils.dataOne(meetingDate, "yyyy-MM-dd"))));
                children.add(meetingValue);
            }
        }
    }

    //获取个人日程
    private void getPersionMeetingbyWeek() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("useraccount", LoginManager.getInstance().getUserInfo().getUserAccount());
        httpParams.put("startdate", startTime);
        httpParams.put("enddate", endTime);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.PersionMeetingbyWeek)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String, Object>>(getActivity(), false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> adressBean, Call call, Response response) {
                        if(adressBean.getData() !=null) {
                            String data = adressBean.getData();
                            if (!TextUtils.isEmpty(data)) {
                                analysisData(adressBean, HttpApi.PersionMeetingbyWeek);
                            } else {
                                hideLoading();
                            }
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        hideLoading();
                    }
                });

    }

    //点击tab 事件
    public void tabOnclick(String sign, String groupCD) {
        this.sign = sign;
        this.groupCD = groupCD;
        getServicesData(isLoad);
    }

    //请求网络数据
    private void getServicesData(boolean load) {
        if (isInit) {//防止数据重复
            if (sign.equals("left")) {
                parent.clear();
                children.clear();
            } else {
                rightParent.clear();
                rightChildren.clear();
            }
        }
        if (load) {
            showLoading();
            if (sign.equals("left")) {
                weekExpanAdapter = new WeekExpanAdapter(getActivity(), parent, children);
                lvWeek.setAdapter(weekExpanAdapter);
                getMeetingbyWeek();
            } else {
                rightWeekExpanAdapter = new WeekExpanAdapter(getActivity(), rightParent, rightChildren);
                lvWeek.setAdapter(rightWeekExpanAdapter);
                getPersionMeetingbyWeek();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        OkGo.getInstance().cancelTag(this);
    }

    @Override
    public void refresh() {
        getServicesData(isInit);//只要初始化才加载数据
    }

    @Override
    public void loadMore() {

    }

    //获取指点时间段内的日期
    public List<String> getBetweenDate(String begin, String end) {
        begin = getReplace(begin);
        end = getReplace(end);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<String> betweenList = new ArrayList<String>();

        try {
            Calendar startDay = Calendar.getInstance();
            startDay.setTime(format.parse(begin));
            startDay.add(Calendar.DATE, -1);

            while (true) {
                startDay.add(Calendar.DATE, 1);
                Date newDate = startDay.getTime();
                String newend = format.format(newDate);
                betweenList.add(newend);
                if (end.equals(newend)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return betweenList;
    }

    //替换数据
    private String getReplace(String begin) {
        return begin.replace("年", "-").replace("月", "-").replace("日", "");
    }

    @Override
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
        return true;
    }

    /**
     * 设置时间段
     */
    public void setTime(String time) {
        String[] split = time.split("-");
        startTime = getReplace(split[0]);
        endTime = getReplace(split[1]);
    }

    /**
     * id
     *
     */
    public void setGroupCD(String groupCD) {
        this.groupCD = groupCD;
    }
}
