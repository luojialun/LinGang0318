package com.lingang.activity.home.search;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.PropertyDettailsAc;
import com.lingang.adapter.BusinessAdapter;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.BusinessBean;
import com.lingang.bean.SelectChanYeBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.dialog.BusinessClassPop;
import com.lingang.dialog.TwoLevelMatPop;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class SeachBusinessAc extends BaseSeachAc implements RefreshListion,
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
    @BindView(R.id.ll_business)
    LinearLayout llBusiness;

    private TwoLevelMatPop twoLevelMatPop;

    private String parkId = "";
    private String basicsId = "";

    private ArrayList<BusinessBean.DataBean.ListBean> clusterData;
    private BusinessAdapter clusterAdapter;
    private BusinessClassPop grideViewPop;
    private String keyWord = "";
    private int[] leftIndices;
    private int rightIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_seach_business);
        init();
        getParkList();
    }

    private void init() {
        tvBtnLeft.setText("园区");
        tvBtnRight.setText("类别");

        Intent intent = getIntent();
        tvBtnLeft.setText(intent.getStringExtra("leftValue"));
        parkId = intent.getStringExtra("leftId");
        leftIndices = intent.getIntArrayExtra("leftIndex");

        tvBtnRight.setText(intent.getStringExtra("rightValue"));
        basicsId = intent.getStringExtra("rightId");
        rightIndex = intent.getIntExtra("rightIndex", 0);

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

    private void getIndustry(final String pageIndex, final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize);
        httpParams.put("basicsId", basicsId);
        httpParams.put("parkId", parkId);
        httpParams.put("keywords", keyWord);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.BusinessPageList)
                .params(httpParams)
                .execute(new ResCallBack<BusinessBean>(this) {
                    @Override
                    public void onCall(BusinessBean cluster, Call call, Response response) {
                        if (isRefresh) {
                            clusterData.clear();
                        }
                        isRefresh(cluster.getData().getCountRecord(), pageIndex, pageSize + "");

                        clusterData.addAll(cluster.getData().getList());
                        clusterAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有" + clusterData.size() + "条查询结果");

                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, String.valueOf(clusterData.size()).length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                        twoLevelMatPop.selectIndex(leftIndices);
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
                        if (rightIndex != 0)
                            grideViewPop.selectIndex(rightIndex);
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
        startActivity(new Intent(this, PropertyDettailsAc.class).putExtra("id", clusterData.get(position).getBusinessId()).putExtra("title", clusterData.get(position).getBusinessName()));
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
        getIndustry(pageIndex + "", true);
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getIndustry(pageIndex + "", false);
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

    @Override
    public void seachCall(String seachContent) {
        super.seachCall(seachContent);
        keyWord = seachContent;
        llBusiness.setVisibility(View.VISIBLE);
        refresh();
    }
}