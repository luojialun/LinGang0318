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
import com.lingang.adapter.PartnerAdapter;
import com.lingang.adapter.PartnerDetailsAc;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.PartnerBean;
import com.lingang.bean.TypeListBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.dialog.BusinessClassPop;
import com.lingang.dialog.OneLevelPop;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class SeachPartnerAc extends BaseSeachAc implements RefreshListion,
        RecycleBaseAdapter.OnItemClickListener, PopupWindow.OnDismissListener, DialogConfirmListion {
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
    @BindView(R.id.ll_parten)
    LinearLayout llParten;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ArrayList<PartnerBean.DataBean.ListBean> clusterData;
    private PartnerAdapter partnerAdapter;
    private OneLevelPop oneLevelPop;

    private String basicsid = "";
    private String typeid = "";
    private BusinessClassPop oneClassPop;
    private String keyWord = "";
    private int leftIndex;
    private int rightIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_seach_partner);
        ButterKnife.bind(this);
        init();
        getTypeList();
    }

    private void init() {

        tvBtnRight.setText("合作层级");
        tvBtnLeft.setText("类别");

        Intent intent = getIntent();
        tvBtnLeft.setText(intent.getStringExtra("leftValue"));
        basicsid = intent.getStringExtra("leftId");
        leftIndex = intent.getIntExtra("leftIndex", 0);

        tvBtnRight.setText(intent.getStringExtra("rightValue"));
        typeid = intent.getStringExtra("rightId");
        rightIndex = intent.getIntExtra("rightIndex", 0);


        oneLevelPop = new OneLevelPop(this, this);
        oneClassPop = new BusinessClassPop(this, this);

        oneLevelPop.setOnDismissListener(this);
        oneClassPop.setOnDismissListener(this);

        clusterData = new ArrayList<>();
        partnerAdapter = new PartnerAdapter(this, clusterData);
        recyclerview.setAdapter(partnerAdapter);
        partnerAdapter.setOnItemClickListener(this);

        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRefreshHead(refresh);
        setRefreshLison(refresh, this);
    }

    private void getTypeList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.PartnerTypeList)
                .params(httpParams)
                .execute(new ResCallBack<TypeListBean>(this, false) {
                    @Override
                    public void onCall(TypeListBean listBean, Call call, Response response) {
                        TypeListBean.DataBean.ListBean listBean1 = new TypeListBean.DataBean.ListBean();
                        listBean1.setTypeName("全部");
                        listBean1.setTypeId("");
                        List<TypeListBean.DataBean.ListBean> list = listBean.getData().getList();
                        list.add(0, listBean1);
                        oneLevelPop.setData(list);

                        if (leftIndex != 0)
                            oneLevelPop.selectIndex(leftIndex);
                        getBasicsList();
                    }
                });

    }

    //类别
    private void getBasicsList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("basicsType", "2");
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
                        if (rightIndex != 0)
                            oneClassPop.selectIndex(rightIndex);
                    }
                });

    }

    private void getIndustry(final String pageIndex, final boolean isRefresh) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize);
        httpParams.put("typeId", typeid);
        httpParams.put("basicsId", basicsid);
        httpParams.put("keywords", keyWord);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.PartnerPageList)
                .params(httpParams)
                .execute(new ResCallBack<PartnerBean>(this) {
                    @Override
                    public void onCall(PartnerBean cluster, Call call, Response response) {
                        if (isRefresh) {
                            clusterData.clear();
                        }
                        isRefresh(cluster.getData().getCountRecord(), pageIndex, pageSize + "");

                        List<PartnerBean.DataBean.ListBean> list = cluster.getData().getList();
                        clusterData.addAll(list);
                        partnerAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有" + clusterData.size() + "条查询结果");

                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, String.valueOf(clusterData.size()).length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNewsnum.setText(span);
                    }
                });

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

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, PartnerDetailsAc.class).putExtra("id", clusterData.get(position).getPartnerId()));
    }

    @OnClick({R.id.rl_left, R.id.rl_right})
    public void onViewClicked(View view) {
        Drawable nav_up = getResources().getDrawable(R.mipmap.up);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        switch (view.getId()) {
            case R.id.rl_left:
                oneLevelPop.showPopupWindow(vvLine);
                tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
                break;
            case R.id.rl_right:
                oneClassPop.showPopupWindow(vvLine);
                tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
                break;
        }
    }

    @Override
    public void confirmClick(String sign) {
        String[] split = sign.split("\\|");

        if (split[0].equals("type")) {
            tvBtnLeft.setText(split[2]);
            typeid = split[1];
        } else {
            tvBtnRight.setText(split[2]);
            basicsid = split[1];
        }
        pageIndex = 1;
        getIndustry(pageIndex + "", true);
    }

    @Override
    public void onDismiss() {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
        tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
    }

    @Override
    public void seachCall(String seachContent) {
        super.seachCall(seachContent);
        keyWord = seachContent;
        llParten.setVisibility(View.VISIBLE);
        refresh();
    }
}