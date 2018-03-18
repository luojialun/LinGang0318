package com.lingang.activity.tunity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.adapter.RlTunityAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.RlTunityBean;
import com.lingang.bean.RlTunityPopBean;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.dialog.RvCenterTvPop;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class RlTunityAc extends BaseRecycleViewAc implements RefreshListion,
        RecycleBaseAdapter.OnItemClickListener, PopConfirmClinck, PopupWindow.OnDismissListener {
    @BindView(R.id.tv_yaunq)
    TextView tvYaunq;
    @BindView(R.id.tv_laiy)
    TextView tvLaiy;
    @BindView(R.id.tv_class)
    TextView tvClass;
    @BindView(R.id.tv_newsnum)
    TextView tvNewsnum;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.rl_yaunq)
    RelativeLayout rlYaunq;
    private RlTunityAdapter rlTunityAdapter;
    private ArrayList<RlTunityBean.DataBean.ListBean> data;
    private RvCenterTvPop yuanqPop, classPop, laiyPop;
    private String parkId, levelId, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.ac_rl_tunity);
        setTitle("认领商机");

        initView();
    }

    private void initView() {
        Spannable span = new SpannableString("共有0条查询结果");
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvNewsnum.setText(span);

        setRecycleAspect(recyclerview);
        setRefreshHead(refresh);
//        setRefreshViewLine(recyclerview, R.drawable.item_divider_acbg_magin15);
        setRefreshLison(refresh, this);

        data = new ArrayList<>();
        rlTunityAdapter = new RlTunityAdapter(this, data);
        rlTunityAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(rlTunityAdapter);

        yuanqPop = new RvCenterTvPop(this, this, "yuanq");
        yuanqPop.setOnDismissListener(this);

        initPopData();

        String userType = LoginManager.getInstance().getUserInfo().getUserType();
        if (userType.equals("2") || userType.equals("1")) {//1、园区招商员  2、园区招商负责人
            getOpportunityUserParkList();
        } else {
            getOpportunityParkList();
        }

    }

    @Override
    public void clickLeft() {
        if (getIntent().getStringExtra("tag").equals("home")){
            finish();
        }else {
            startActivity(new Intent(this, MainActivity.class),true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getIntent().getStringExtra("tag").equals("home")){
            finish();
        }else {
            startActivity(new Intent(this, MainActivity.class),true);
        }
    }

    private void initPopData() {
        classPop = new RvCenterTvPop(this, this, "class");
        classPop.setOnDismissListener(this);
        ArrayList<ParkUserListBean> classData = new ArrayList<>();
        classData.add(new ParkUserListBean("", "全部类型"));
        classData.add(new ParkUserListBean("1", "厂房"));
        classData.add(new ParkUserListBean("2", "研发办公"));
        classData.add(new ParkUserListBean("3", "土地"));
        classData.add(new ParkUserListBean("4", "注册型企业"));
        classPop.setData(classData);


        laiyPop = new RvCenterTvPop(this, this, "laiy");
        laiyPop.setOnDismissListener(this);
        ArrayList<ParkUserListBean> laiyData = new ArrayList<>();
        laiyData.add(new ParkUserListBean("", "全部来源"));
        laiyData.add(new ParkUserListBean("A", "A类"));
        laiyData.add(new ParkUserListBean("B", "B类"));
        laiyData.add(new ParkUserListBean("C", "C类"));
        laiyPop.setData(laiyData);
    }

    private void getOpportunityUserParkList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getOpportunityUserParkList)
                .params(httpParams)
                .execute(new ResCallBack<RlTunityPopBean>(this, false) {
                    @Override
                    public void onCall(RlTunityPopBean cluster, Call call, Response response) {
                        List<ParkUserListBean> parkUserList = cluster.getDataMap().getParkUserList();
                        parkUserList.add(0, new ParkUserListBean("", "全部园区"));
                        yuanqPop.setData(parkUserList);
                        getOpportunityPoolList(pageIndex + "");
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        getOpportunityPoolList(pageIndex + "");
                    }
                });

    }

    private void getOpportunityParkList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getOpportunityParkList)
                .params(httpParams)
                .execute(new ResCallBack<TjTunityThreeBean>(this, false) {
                    @Override
                    public void onCall(TjTunityThreeBean cluster, Call call, Response response) {
                        List<TjTunityThreeBean.DataMapBean.ParkListBean> parkList = cluster.getDataMap().getParkList();
                        ArrayList<ParkUserListBean> data = new ArrayList<>();
                        if (parkList !=null && parkList.size() > 0) {

                            for (TjTunityThreeBean.DataMapBean.ParkListBean recommendListBean :
                                    parkList) {
                                data.add(new ParkUserListBean(recommendListBean.getParkId(),
                                        recommendListBean.getParkName()));
                            }
//                            Collections.reverse(data);
                        }
                        data.add(0, new ParkUserListBean("", "全部园区"));
                        yuanqPop.setData(data);
                        getOpportunityPoolList(pageIndex + "");
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        getOpportunityPoolList(pageIndex + "");
                    }
                });

    }

    private void getOpportunityPoolList(final String pageIndex) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("parkId", parkId);
        httpParams.put("levelId", levelId);
        httpParams.put("type", type);
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getOpportunityPoolList)
                .params(httpParams)
                .execute(new ResCallBack<RlTunityBean>(this) {
                    @Override
                    public void onCall(RlTunityBean cluster, Call call, Response response) {
                        if (pageIndex.equals("1")) {
                            data.clear();
                        }

                        String countRecord = cluster.getData().getCountRecord();
                        isRefresh(countRecord, pageIndex, pageSize + "");

                        data.addAll(cluster.getData().getList());
                        rlTunityAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有" + countRecord + "条查询结果");
                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNewsnum.setText(span);
                    }
                });

    }

    @OnClick({R.id.rl_yaunq, R.id.rl_laiy, R.id.rl_class})
    public void onViewClicked(View view) {
        Drawable nav_up = getResources().getDrawable(R.mipmap.up);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        switch (view.getId()) {
            case R.id.rl_yaunq:
                tvYaunq.setCompoundDrawables(null, null, nav_up, null);
                yuanqPop.showPopupWindow(rlYaunq);
                break;
            case R.id.rl_laiy:
                tvLaiy.setCompoundDrawables(null, null, nav_up, null);
                laiyPop.showPopupWindow(rlYaunq);
                break;
            case R.id.rl_class:
                tvClass.setCompoundDrawables(null, null, nav_up, null);
                classPop.showPopupWindow(rlYaunq);
                break;
        }
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getOpportunityPoolList(pageIndex + "");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getOpportunityPoolList(pageIndex + "");
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, RlTunityDetailesAc.class).putExtra("id", data.get(position).getKeyId()).putExtra("showState",data.get(position).getShowState()));
    }

    @Override
    public void onDismiss() {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvYaunq.setCompoundDrawables(null, null, nav_up, null);
        tvLaiy.setCompoundDrawables(null, null, nav_up, null);
        tvClass.setCompoundDrawables(null, null, nav_up, null);
    }

    @Override
    public void popConfirmClinck(String sign, String value) {
        if (!TextUtils.isEmpty(sign) && !TextUtils.isEmpty(value)) {
            String[] split = value.split("\\|");
            switch (sign) {
                case "yuanq"://园区
                    parkId = split[0];
                    tvYaunq.setText(split[1]);
                    break;
                case "class"://类型
                    type = split[0];
                    tvClass.setText(split[1]);
                    break;
                case "laiy"://来源
                    levelId = split[0];
                    tvLaiy.setText(split[1]);
                    break;
            }

            refresh();

        }
    }
}
