package com.lingang.activity.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.GetUserInfoBean;
import com.lingang.bean.GroupbyUserBean;
import com.lingang.common.LoginManager;
import com.lingang.fragment.other.WeekFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class WeekPlanAc extends BaseRecycleViewAc implements RadioGroup.OnCheckedChangeListener,
        OnDismissListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.left_btn)
    ImageView leftBtn;
    @BindView(R.id.title_rbleft)
    RadioButton titleRbleft;
    @BindView(R.id.title_rbright)
    RadioButton titleRbright;
    @BindView(R.id.title_rg)
    RadioGroup titleRg;
    @BindView(R.id.tv_tag_week)
    TextView tvTagWeek;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.tb_week)
    TabLayout tabWeek;
    @BindView(R.id.fm_week)
    FrameLayout fmWeek;

    private OptionsPickerView pickerView;
    private ArrayList<String> weekList;
    private SimpleDateFormat sdf; //设置时间格式
    private GetUserInfoBean userInfo;
    private String groupCD = "";
    private ArrayList<Integer> integers, integers2;
    private Calendar c;
    private WeekFragment weekFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_plan);
        ButterKnife.bind(this);
        init();
        getData();
        getUserInfo();
    }

    private void init() {
        titleRbleft.setText("组织日程");
        titleRbright.setText("个人日程");
        titleRg.check(R.id.title_rbleft);
        titleRg.setOnCheckedChangeListener(this);
    }

    //获取日期数据
    private void getData() {
        weekList = new ArrayList<>();
        if (integers == null) {
            integers = new ArrayList<>();
        }

        integers.add(-2);
        integers.add(-1);
        integers.add(0);
        integers.add(1);
        integers.add(2);

        sdf = new SimpleDateFormat("yyyy年MM月dd日"); //设置时间格式
        for (int i = 0; i < 5; i++) {//1);//上周 2);//上上周 0);//当前周 -1);//下周 -2);//下下周
            weekList.add(getLastTimeInterval(integers.get(i)));
        }

        c = Calendar.getInstance();
        initTab();
        tabWeek.addOnTabSelectedListener(this);
    }

    private void initTab() {
        Collections.reverse(weekList);//倒序
        for (String week :
                weekList) {
            tabWeek.addTab(tabWeek.newTab().setText(week.replace(c.get(Calendar.YEAR) + "年", "")));
        }
        //被选中的tab在屏幕中间显示
        tabWeek.post(new Runnable() {
            @Override
            public void run() {
                tabWeek.setScrollPosition(2,0,true);
            }
        });
    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        weekFragment = new WeekFragment();
        Bundle bundle = new Bundle();
        bundle.putString("time", weekList.get(2));
        bundle.putString("GroupCD", groupCD);
        weekFragment.setArguments(bundle);
        transaction.add(R.id.fm_week, weekFragment);
        transaction.commit();
    }

    //获取用户信息
    private void getUserInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("Userid", LoginManager.getInstance().getUserInfo().getUserAccount());//
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GetUserInfo)
                .tag(WeekPlanAc.this)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<String,Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> addressBean, Call call, Response response) throws JSONException {
                        String result = addressBean.getData();
                        Gson gson = new Gson();
                        userInfo = gson.fromJson(result.replaceAll("\\\\", ""), GetUserInfoBean.class);
                        if (userInfo != null && userInfo.getData().size() != 0) {
                            tvTagWeek.setText(userInfo.getData().get(0).getUserOUName());//getLabourRelationName()
                            groupCD = userInfo.getData().get(0).getUserOU();//getLabourRelationCD()
                        }
                        groupbyUser();
                    }
                });

    }

    //获取常用组织
    private void groupbyUser() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("useraccount", LoginManager.getInstance().getUserInfo().getUserAccount());//huangshuai
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.GroupbyUser)
                .params(httpParams)
                .tag(WeekPlanAc.this)
                .execute(new ResCallBack<BaseEntity<String, Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<String, Object> addressBean, Call call, Response response) throws JSONException {
                        if(addressBean !=null && !TextUtils.isEmpty(addressBean.getData())) {
                            String result = addressBean.getData();
                            Gson gson = new Gson();
                            GroupbyUserBean Group = gson.fromJson(result.replaceAll("\\\\", ""), GroupbyUserBean.class);
                            if(Group !=null && Group.getData() !=null) {
                                if(userInfo.getData() !=null && userInfo.getData().size()>0) {
                                    List<GroupbyUserBean.DataBean> data = Group.getData();
                                    GroupbyUserBean.DataBean dataBean = new GroupbyUserBean.DataBean();
                                    dataBean.setGroupName(userInfo.getData().get(0).getUserOUName());//getLabourRelationName
                                    dataBean.setGroupCD(userInfo.getData().get(0).getUserOU());//getLabourRelationCD
                                    data.add(0, dataBean);
                                    initPv(data);
                                }
                            }
                            initFragment();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        initFragment();
                    }
                });

    }

    private void initPv(final List<GroupbyUserBean.DataBean> data) {
        final ArrayList<String> strings = new ArrayList<>();
        for (GroupbyUserBean.DataBean dataBean :
                data) {
            strings.add(dataBean.getGroupName());
        }
        pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = strings.get(options1);
                groupCD = data.get(options1).getGroupCD();
                tvTagWeek.setText(tx);
                //刷新数据
                weekFragment.setTime(weekList.get(2));
                weekFragment.setGroupCD(groupCD);
                weekFragment.refresh();
            }
        }).setTextColorCenter(getResources().getColor(R.color.black))
                .setTextColorOut(getResources().getColor(R.color.grenn))
                .setContentTextSize(16)//滚轮文字大小
                .setSubCalSize(16)
                .setSubmitColor(getResources().getColor(R.color.black))//确定按钮文字颜色
                .setCancelColor(getResources().getColor(R.color.black))//取消按钮文字颜色
                .setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .build();
        pickerView.setPicker(strings);
        pickerView.setOnDismissListener(this);
    }

    @OnClick({R.id.left_btn, R.id.ll_tag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.ll_tag:
                Drawable nav_up = getResources().getDrawable(R.mipmap.up);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvTagWeek.setCompoundDrawables(null, null, nav_up, null);
                if (pickerView != null)
                    pickerView.show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.title_rbleft:
                changeSign(View.VISIBLE, "left");
                break;
            case R.id.title_rbright:
                changeSign(View.GONE, "right");
                break;
        }
    }

    //改变sign状态
    private void changeSign(int gone, String right) {
        llTag.setVisibility(gone);
        if (weekFragment != null) {
            weekFragment.tabOnclick(right, groupCD);
        }
    }

    @Override
    public void onDismiss(Object o) {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvTagWeek.setCompoundDrawables(null, null, nav_up, null);
    }

    /**
     * 根据当前日期获得上周的日期区间（上周周一和周日日期）
     *
     * @return
     * @author zhaoxuepu
     */
    public String getLastTimeInterval(int offset) {
        int i = 7 * offset;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - i);
        calendar2.add(Calendar.DATE, offset2 - i);
//        System.out.println("last Monday" + sdf.format(calendar1.getTime()));// last Monday
        String lastBeginDate = sdf.format(calendar1.getTime());
//        System.out.println("last Sunday" + sdf.format(calendar2.getTime()));// last Sunday
        String lastEndDate = sdf.format(calendar2.getTime());
        return lastBeginDate + "-" + lastEndDate;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        if (integers2 == null) {//tab状态改变后   存放新得到的5个时间段集合
            integers2 = new ArrayList<>();
        }

        int newTime = integers.get(tabWeek.getSelectedTabPosition()) - integers.get(2);//获取选择完后的时间差值

        integers2.clear();
        weekList.clear();

        for (int i = 0; i < 5; i++) {
            integers2.add(integers.get(i) - newTime);//通过时间差值  计算新的时间段  并且添加到集合中
            weekList.add(getLastTimeInterval(integers2.get(i)));//通过新的时间  获取时间确切值
        }

        integers.clear();
        for (int i = 0; i < integers2.size(); i++) {
            integers.add(integers2.get(i));//把最新的时间加入到时间集合 （方便下次计算时间）
        }

        tabWeek.removeAllTabs();
        tabWeek.removeOnTabSelectedListener(this);
        initTab();
        if (weekFragment != null) {
            String time = weekList.get(2);
            weekFragment.setTime(time);
            weekFragment.setGroupCD(groupCD);
            weekFragment.refresh();
        }
        tabWeek.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}