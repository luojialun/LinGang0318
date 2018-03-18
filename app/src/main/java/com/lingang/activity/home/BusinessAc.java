package com.lingang.activity.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.search.SeachBusinessAc;
import com.lingang.adapter.BusinessAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.BusinessBean;
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

public class BusinessAc extends BaseRecycleViewAc implements RefreshListion,
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
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.tv_newsnum)
    TextView tvNewsnum;

    private TwoLevelMatPop twoLevelMatPop;

    private String parkId = "";
    private String basicsId = "";

    private ArrayList<BusinessBean.DataBean.ListBean> clusterData;
    private BusinessAdapter clusterAdapter;
    private BusinessClassPop grideViewPop;

    private String keyWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_business);
        setTitle("租售物业");
        getRightView().setImageResource(R.mipmap.search);
        init();
        getIndustry(pageIndex + "");
        getParkList();
    }

    @Override
    public void ibClickRight() {
        Intent intent = new Intent(this, SeachBusinessAc.class);
        intent.putExtra("leftValue",tvBtnLeft.getText().toString());
        intent.putExtra("leftId",parkId);
        intent.putExtra("leftIndex",twoLevelMatPop.getIndex());

        intent.putExtra("rightValue",tvBtnRight.getText().toString());
        intent.putExtra("rightId",basicsId);
        intent.putExtra("rightIndex",grideViewPop.getIndex());
        startActivity(intent);
    }

    private void init() {
        Spannable span = new SpannableString("共有0条查询结果");
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvNewsnum.setText(span);

        tvBtnLeft.setText("园区");
        tvBtnRight.setText("类别");
        twoLevelMatPop = new TwoLevelMatPop(this, this);
        twoLevelMatPop.setOnDismissListener(this);

        grideViewPop = new BusinessClassPop(this, this);
        grideViewPop.setOnDismissListener(this);

        clusterData = new ArrayList<>();
        clusterAdapter = new BusinessAdapter(this, clusterData);
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
        httpParams.put("basicsId", basicsId);
        httpParams.put("parkId", parkId);
        httpParams.put("keywords",keyWord);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.BusinessPageList)
                .params(httpParams)
                .execute(new ResCallBack<BusinessBean>(this) {
                    @Override
                    public void onCall(BusinessBean cluster, Call call, Response response) {
                        if (pageIndex.equals("1")) {
                            clusterData.clear();
                        }
                        String countRecord = cluster.getData().getCountRecord();
                        isRefresh(countRecord, pageIndex, pageSize + "");

                        clusterData.addAll(cluster.getData().getList());
                        clusterAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有"+countRecord+"条查询结果");

                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length()+2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNewsnum.setText(span);


                    }
                });

    }

    //园区
    private void getParkList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ParkList)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String cluster, Call call, Response response) throws JSONException {
                        twoLevelMatPop.setData(cluster);
                        getIndustryList();
                    }
                });

    }

    //类别
    private void getIndustryList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("basicsType", "4");
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
                        grideViewPop.setData(data);
                    }
                });
    }

    @Override
    public void onDismiss() {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
        tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, PropertyDettailsAc.class).putExtra("id", clusterData.get(position).getBusinessId()).putExtra("title",clusterData.get(position).getBusinessName()));
    }

    @Override
    public void confirmClick(String sign) {
        String[] split = sign.split("\\|");
        basicsId = split[1];
        tvBtnRight.setText(split[2]);
        refresh();
    }

    @Override
    public void popConfirmClinck(String sign, String value) {
        if (sign.equals("id")) {
            parkId = value;
            refresh();
        } else {
            tvBtnLeft.setText(value);
        }
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
                grideViewPop.showPopupWindow(vvLine);
                break;
        }
    }
}
