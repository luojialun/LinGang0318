package com.lingang.activity.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.search.SeachMatingAc;
import com.lingang.adapter.MatingAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.MatingBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.dialog.BusinessClassPop;
import com.lingang.dialog.TwoLevelMatPop;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class MatingAc extends BaseRecycleViewAc implements RefreshListion,
        RecycleBaseAdapter.OnItemClickListener, PopConfirmClinck,
        PopupWindow.OnDismissListener, DialogConfirmListion {
    @BindView(R.id.tv_btn_left)
    TextView tvBtnLeft;
    @BindView(R.id.rl_left)
    RelativeLayout rlLeft;
    @BindView(R.id.tv_btn_right)
    TextView tvBtnRight;
    @BindView(R.id.rl_right)
    RelativeLayout rlRight;
    @BindView(R.id.vv_line)
    View vvLine;
    @BindView(R.id.tv_newsnum)
    TextView tvNewsnum;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ArrayList<MatingBean.DataBean.ListBean> clusterData;
    private MatingAdapter clusterAdapter;
    private String parkId = "";
    private String basicsId = "";
    private TwoLevelMatPop twoLevelMatPop;
    private BusinessClassPop oneClassPop;
    private String keyWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_mating);
        getRightView().setImageResource(R.mipmap.search);
        setTitle("配套服务");
        init();
        getIndustry(pageIndex + "");
        getParkList();
    }

    @Override
    public void ibClickRight() {
        Intent intent = new Intent(this, SeachMatingAc.class);
        intent.putExtra("leftValue",tvBtnLeft.getText().toString());
        intent.putExtra("leftId",parkId);
        intent.putExtra("leftIndex",twoLevelMatPop.getIndex());

        intent.putExtra("rightValue",tvBtnRight.getText().toString());
        intent.putExtra("rightId",basicsId);
        intent.putExtra("rightIndex",oneClassPop.getIndex());
        startActivity(intent);
    }

    private void init() {
        Spannable span = new SpannableString("共有0条查询结果");
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvNewsnum.setText(span);

        tvBtnLeft.setText("园区");
        tvBtnRight.setText("服务类别");
        twoLevelMatPop = new TwoLevelMatPop(this, this);
        twoLevelMatPop.setOnDismissListener(this);

        oneClassPop = new BusinessClassPop(this, this);
        oneClassPop.setOnDismissListener(this);

        clusterData = new ArrayList<>();
        clusterAdapter = new MatingAdapter(this, clusterData);
        recyclerview.setAdapter(clusterAdapter);
        clusterAdapter.setOnItemClickListener(this);

        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRefreshHead(refresh);
        setRefreshLison(refresh, this);

    }

    private void getIndustry(final String pageIndex) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize);
        httpParams.put("parkId", parkId);
        httpParams.put("basicsId", basicsId);
        httpParams.put("keywords", keyWord);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ServicePageList)
                .params(httpParams)
                .execute(new ResCallBack<MatingBean>(this) {
                    @Override
                    public void onCall(MatingBean cluster, Call call, Response response) {
                        if (pageIndex.equals("1")) {
                            clusterData.clear();
                        }
                        String countRecord = cluster.getData().getCountRecord();
                        isRefresh(countRecord, pageIndex, pageSize + "");

                        List<MatingBean.DataBean.ListBean> list = cluster.getData().getList();
                        clusterData.addAll(list);
                        clusterAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有" + countRecord + "条查询结果");

                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNewsnum.setText(span);
                    }
                });

    }

    private void getParkList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ParkList)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String cluster, Call call, Response response) throws JSONException {
                        twoLevelMatPop.setData(cluster);
                        getBasicsList();
                    }
                });

    }

    //类别
    private void getBasicsList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("basicsType", "1");
        OkGo.post(HttpApi.basicsList)
                .params(httpParams)
                .execute(new ResCallBack<AllClassBean>(this, false) {
                    @Override
                    public void onCall(AllClassBean cluster, Call call, Response response) throws JSONException {
                        List<AllClassBean.DataBean> data = cluster.getData();
                        AllClassBean.DataBean dataBean = new AllClassBean.DataBean();
                        dataBean.setBasicsId("");
                        dataBean.setBasicsName("全部");
                        data.add(0, dataBean);
                        oneClassPop.setData(data);
                    }
                });

    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getIndustry(pageIndex + "");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getIndustry(pageIndex + "");
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, MatingDetailesAc.class).putExtra("id", clusterData.get(position).getServiceId()));
    }

    @OnClick({R.id.rl_left, R.id.rl_right})
    public void onViewClicked(View view) {
        Drawable nav_up = getResources().getDrawable(R.mipmap.up);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        switch (view.getId()) {
            case R.id.rl_left:
                tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
                twoLevelMatPop.showPopupWindow(vvLine);
                break;
            case R.id.rl_right:
                tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
                oneClassPop.showPopupWindow(vvLine);
                break;
        }
    }

    @Override
    public void popConfirmClinck(String sign, String value) {
        if (sign.equals("id")) {
            pageIndex = 1;
            parkId = value;
            getIndustry(pageIndex + "");
        } else {
            tvBtnLeft.setText(value);
        }
    }

    @Override
    public void onDismiss() {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
        tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
    }

    @Override
    public void confirmClick(String sign) {
        String[] split = sign.split("\\|");
        tvBtnRight.setText(split[2]);
        basicsId = split[1];
        pageIndex = 1;
        getIndustry(pageIndex + "");
    }
}
