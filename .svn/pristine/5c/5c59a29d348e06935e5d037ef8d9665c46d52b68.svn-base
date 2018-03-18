package com.lingang.activity.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.search.SeachEntryAc;
import com.lingang.adapter.EntryAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ChanYePopBean;
import com.lingang.bean.EntryBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.dialog.ChanYePop;
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

public class EntryAc extends BaseRecycleViewAc implements RefreshListion,
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
    private String parkId = "-1";
    private String industryLevelIds = "";
    private ArrayList<EntryBean.DataBean.ListBean> clusterData;
    private EntryAdapter clusterAdapter;
    private ChanYePop chanYePop;
    private String keyWord = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_entry2);
        setTitle("存量客户");
        getRightView().setImageResource(R.mipmap.search);
        init();
    }

    @Override
    public void ibClickRight() {
        Intent intent = new Intent(this, SeachEntryAc.class);
        intent.putExtra("leftValue",tvBtnLeft.getText().toString());
        intent.putExtra("leftId",parkId);
        intent.putExtra("leftIndex",twoLevelMatPop.getIndex());

        intent.putExtra("rightValue",tvBtnRight.getText().toString());
        intent.putExtra("rightId",industryLevelIds);
        intent.putExtra("rightIndex",chanYePop.getIndex());
        startActivity(intent);
    }

    private void init() {
        Spannable span = new SpannableString("共有0条查询结果");
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvNewsnum.setText(span);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");
        if (!TextUtils.isEmpty(tag)){
            String id = intent.getStringExtra("id");
            String name = intent.getStringExtra("name");
            if (tag.equals("yuanqu")){//从园区详情进入
                tvBtnLeft.setText(name);
                parkId = id;
                rlLeft.setEnabled(false);
            }else {//产业集群进入
                tvBtnLeft.setText("园区");
                industryLevelIds = id;
                tvBtnRight.setText(name);
                rlRight.setEnabled(false);
            }
        }else {
            tvBtnLeft.setText("园区");
            tvBtnRight.setText("产业");
        }

        twoLevelMatPop = new TwoLevelMatPop(this, this);
        twoLevelMatPop.setOnDismissListener(this);

        chanYePop = new ChanYePop(this, this);
        chanYePop.setOnDismissListener(this);

        clusterData = new ArrayList<>();
        clusterAdapter = new EntryAdapter(this, clusterData);
        recyclerview.setAdapter(clusterAdapter);
        clusterAdapter.setOnItemClickListener(this);

        setRecycleAspect(recyclerview);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRefreshHead(refresh);
        setRefreshLison(refresh, this);

        getIndustry(pageIndex+"");
        getParkList();
    }

    private void getIndustry(final String pageIndex) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pageIndex);
        httpParams.put("pageSize", pageSize);
        httpParams.put("parkId", parkId);
        httpParams.put("keywords",keyWord);
        httpParams.put("industryLevelIds", industryLevelIds);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.StationPageList)
                .params(httpParams)
                .execute(new ResCallBack<EntryBean>(this) {
                    @Override
                    public void onCall(EntryBean cluster, Call call, Response response) {
                        if (pageIndex.equals("1")) {
                            clusterData.clear();
                        }
                        String countRecord = cluster.getData().getCountRecord();
                        isRefresh(countRecord, pageIndex, pageSize + "");

                        List<EntryBean.DataBean.ListBean> list = cluster.getData().getList();
                        clusterData.addAll(list);
                        clusterAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有"+countRecord+"条查询结果");
                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, countRecord.length()+2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                        getIndustryList();
                    }
                });

    }

    private void getIndustryList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.IndustryList)
                .params(httpParams)
                .execute(new ResCallBack<ChanYePopBean>(this, false) {
                    @Override
                    public void onCall(ChanYePopBean zoneBean, Call call, Response response) {
                        chanYePop.setData(zoneBean);
                    }
                });
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
                chanYePop.showPopupWindow(vvLine);
                break;
        }
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        getIndustry(pageIndex+"");
    }

    @Override
    public void loadMore() {
        pageIndex++;
        getIndustry(pageIndex+"");
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this, EntryDetailsAc.class).putExtra("id", clusterData.get(position).getStationId()));
    }

    @Override
    public void onDismiss() {
        Drawable nav_up = getResources().getDrawable(R.mipmap.pull);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
        tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
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
    public void confirmClick(String sign) {
        if (sign.equals("") || TextUtils.isEmpty(sign)) {
            tvBtnRight.setText("产业");
            industryLevelIds = "";
        } else {
            String[] split = sign.split("\\|");
            tvBtnRight.setText(split[1]);
            industryLevelIds = split[0];
        }

        pageIndex = 1;
        getIndustry(pageIndex+"");
    }
}
