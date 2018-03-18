package com.lingang.activity.home.search;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.adapter.YuanQuAdapter;
import com.lingang.base.BaseSeachAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ChanYePopBean;
import com.lingang.bean.SelectChanYeBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.callback.RefreshListion;
import com.lingang.common.LoginManager;
import com.lingang.dialog.ChanYePop;
import com.lingang.dialog.TwoLevelPop;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class SeachYuanQuAc extends BaseSeachAc implements RefreshListion
        , RecycleBaseAdapter.OnItemClickListener, PopConfirmClinck
        , PopupWindow.OnDismissListener, DialogConfirmListion {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.rl_left)
    RelativeLayout rlLeft;
    @BindView(R.id.rl_right)
    RelativeLayout rlRight;
    @BindView(R.id.vv_line)
    View vvLine;
    @BindView(R.id.tv_btn_left)
    TextView tvBtnLeft;
    @BindView(R.id.tv_btn_right)
    TextView tvBtnRight;
    @BindView(R.id.tv_newsnum)
    TextView tvNewsnum;
    @BindView(R.id.ac_yuan_qu)
    LinearLayout acYuanQu;
    private String regionId = "";
    private String industryLevelIds = "";
    private ArrayList<YuanQuBean.DataBean.ListBean> clusterData;
    private YuanQuAdapter clusterAdapter;
    private TwoLevelPop twoLevelPop;
    private ChanYePop chanYePop;
    private String keyWord = "";
    private int[] leftIndex;
    private ArrayList<SelectChanYeBean> rightIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_seach_yuan_qu);
        ButterKnife.bind(this);
        init();
        getRegionList();
    }

    private void init() {
        Intent intent = getIntent();
        tvBtnLeft.setText(intent.getStringExtra("leftValue"));
        regionId = intent.getStringExtra("leftId");
        leftIndex = intent.getIntArrayExtra("leftIndex");

        tvBtnRight.setText(intent.getStringExtra("rightValue"));
        industryLevelIds = intent.getStringExtra("rightId");
        rightIndex = (ArrayList<SelectChanYeBean>) intent.getSerializableExtra("rightIndex");


        twoLevelPop = new TwoLevelPop(this, this);
        twoLevelPop.setOnDismissListener(this);

        chanYePop = new ChanYePop(this, this);
        chanYePop.setOnDismissListener(this);

        clusterData = new ArrayList<>();
        clusterAdapter = new YuanQuAdapter(this, clusterData);
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
        httpParams.put("regionId", regionId);
        httpParams.put("keywords", keyWord);
        httpParams.put("industryLevelIds", industryLevelIds);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.ParkPageList)
                .params(httpParams)
                .execute(new ResCallBack<YuanQuBean>(this) {
                    @Override
                    public void onCall(YuanQuBean cluster, Call call, Response response) {
                        if (isRefresh) {
                            clusterData.clear();
                        }
                        isRefresh(cluster.getData().getCountRecord(), pageIndex, pageSize + "");

                        List<YuanQuBean.DataBean.ListBean> list = cluster.getData().getList();
                        clusterData.addAll(list);
                        clusterAdapter.notifyDataSetChanged();

                        Spannable span = new SpannableString("共有" + clusterData.size() + "条查询结果");

                        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 2, String.valueOf(clusterData.size()).length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tvNewsnum.setText(span);
                    }
                });

    }

    //获取地区的数据
    private void getRegionList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.RegionList)
                .params(httpParams)
                .execute(new ResCallBack<String>(this, false) {
                    @Override
                    public void onCall(String adressBean, Call call, Response response) throws JSONException {
                        twoLevelPop.setData(adressBean);
                        twoLevelPop.selectIndex(leftIndex);
                        getIndustryList();
                    }
                });

    }

    //产业
    private void getIndustryList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.IndustryList)
                .params(httpParams)
                .execute(new ResCallBack<ChanYePopBean>(this, false) {
                    @Override
                    public void onCall(ChanYePopBean zoneBean, Call call, Response response) {
                        chanYePop.setData(zoneBean);

                        int rightIndexNum = 0;
                        for (SelectChanYeBean selectChanYeBean :
                                rightIndex) {
                            String rightIndex = selectChanYeBean.getRightIndex();
                            String[] split = rightIndex.split(",");
                            rightIndexNum = split.length + rightIndexNum;
                        }

                        if (rightIndexNum != 0)
                            chanYePop.selectIndex(rightIndex);
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
        startActivity(new Intent(this, ChanYeDetailsAc.class).putExtra("id", clusterData.get(position).getParkId()));
    }

    @OnClick({R.id.rl_left, R.id.rl_right})
    public void onViewClicked(View view) {
        Drawable nav_up = getResources().getDrawable(R.mipmap.up);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        switch (view.getId()) {
            case R.id.rl_left:
                tvBtnLeft.setCompoundDrawables(null, null, nav_up, null);
                twoLevelPop.showPopupWindow(vvLine);
                break;
            case R.id.rl_right:
                tvBtnRight.setCompoundDrawables(null, null, nav_up, null);
                chanYePop.showPopupWindow(vvLine);
                break;
        }
    }

    @Override
    public void popConfirmClinck(String sign, String value) {
        if (sign.equals("id")) {
            pageIndex = 1;
            regionId = value;
            getIndustry(pageIndex + "", true);
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
        if (sign.equals("") || TextUtils.isEmpty(sign)) {
            tvBtnRight.setText("产业");
            industryLevelIds = "";
        } else {
            String[] split = sign.split("\\|");
            tvBtnRight.setText(split[1]);
            industryLevelIds = split[0];
        }

        pageIndex = 1;
        getIndustry(pageIndex + "", true);
    }

    @Override
    public void seachCall(String keyWord) {
        super.seachCall(keyWord);
        acYuanQu.setVisibility(View.VISIBLE);
        this.keyWord = keyWord;
        refresh();
    }
}
