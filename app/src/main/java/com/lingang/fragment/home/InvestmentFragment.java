package com.lingang.fragment.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.business.BoardAc;
import com.lingang.activity.business.MyClaimAc;
import com.lingang.activity.home.BusinessAc;
import com.lingang.activity.home.ClusterAc;
import com.lingang.activity.home.EntryAc;
import com.lingang.activity.home.GroupAc;
import com.lingang.activity.home.MatingAc;
import com.lingang.activity.home.PartnerAc;
import com.lingang.activity.home.PolicyListAc;
import com.lingang.activity.home.PublicAc;
import com.lingang.activity.home.YuanQuAc;
import com.lingang.activity.tunity.MyExamineAc;
import com.lingang.activity.tunity.RlTunityAc;
import com.lingang.activity.tunity.TjTunityOneAc;
import com.lingang.activity.tunity.execute.MyExecute;
import com.lingang.adapter.HomeGvAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.bean.HomeModeBean;
import com.lingang.bean.KanbanBean;
import com.lingang.callback.RefreshListion;
import com.lingang.common.Constants.Investment;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.view.ExtraGridView;
import com.lingang.view.ProgressWebView;
import com.lingang.view.RefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.vector.update_app.utils.DrawableUtil;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

public class InvestmentFragment extends BaseFragment implements AdapterView.OnItemClickListener, RefreshListion {

    @BindView(R.id.busi_gv)
    ExtraGridView busiGv;
    @BindView(R.id.query_gv)
    ExtraGridView queryGv;
    //    @BindView(R.id.other_gv)
//    ExtraGridView otherGv;
    Unbinder unbinder;
    @BindView(R.id.ib_left)
    ImageView ibLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.unit_tv)
    TextView unitTv;
    @BindView(R.id.chart_wv)
    ProgressWebView webView;
    @BindView(R.id.total_tv)
    TextView totalTv;
    @BindView(R.id.add_tv)
    TextView addTv;
    @BindView(R.id.error_ll)
    LinearLayout errorLl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_investment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initWebView();
        getKanBanData();
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            refresh();
        }
    }

    private void initView() {
        ibLeft.setVisibility(View.GONE);
        tvTitle.setText("招商");
        DrawableUtil.setTextSolidTheme(unitTv, 6, 30, getResources().getColor(R.color.d8d8d8));
        RefreshView headerView = new RefreshView(getContext());
        refresh.setHeaderView(headerView);
        refresh.setEnableLoadmore(false);
        setRefreshLison(refresh, this);
    }

    String[] busiTv = null;

    private void initData() {
        ArrayList<HomeModeBean> busiData = new ArrayList<>();
        HomeGvAdapter busiAdapter = new HomeGvAdapter(getActivity(), busiData);
        busiGv.setAdapter(busiAdapter);

        ArrayList<HomeModeBean> queryData = new ArrayList<>();
        HomeGvAdapter queryAdapter = new HomeGvAdapter(getActivity(), queryData);
        queryGv.setAdapter(queryAdapter);

//        ArrayList<HomeModeBean> otherData = new ArrayList<>();
//        HomeGvAdapter otherAdapter = new HomeGvAdapter(getActivity(), otherData);
//        otherGv.setAdapter(otherAdapter);

        String userType = LoginManager.getInstance().getUserInfo().getUserType();
        int[] busiImg = null;
        switch (userType) {
            case "0": //普通用户
                busiTv = new String[]{Investment.TjTunityOne, Investment.MyClaim, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_wodeshangji, R.mipmap.ic_shangjikanban};
                break;
            case "1": //招商园区用户
                busiTv = new String[]{Investment.TjTunityOne, Investment.RlTunity, Investment.MyClaim, Investment.EXECUTE, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_shangjirenling, R.mipmap.ic_wodeshangji, R.mipmap.wodezhixing, R.mipmap.ic_shangjikanban};
                break;
            case "2": //招商负责人
                busiTv = new String[]{Investment.TjTunityOne, Investment.RlTunity, Investment.MyClaim, Investment.EXECUTE, Investment.EXAMINE, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_shangjirenling, R.mipmap.ic_wodeshangji, R.mipmap.wodezhixing, R.mipmap.wodeshenhe, R.mipmap.ic_shangjikanban};
                break;
            case "3": //科产办普通用户
                busiTv = new String[]{Investment.TjTunityOne, Investment.RlTunity, Investment.MyClaim, Investment.EXECUTE, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_shangjirenling, R.mipmap.ic_wodeshangji, R.mipmap.wodezhixing, R.mipmap.ic_shangjikanban};
                break;
            case "4": //科产办关键用户
                busiTv = new String[]{Investment.TjTunityOne, Investment.RlTunity, Investment.MyClaim, Investment.EXECUTE, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_shangjirenling, R.mipmap.ic_wodeshangji, R.mipmap.wodezhixing, R.mipmap.ic_shangjikanban};
                break;
            case "5": //科产办负责人
                busiTv = new String[]{Investment.TjTunityOne, Investment.RlTunity, Investment.MyClaim, Investment.EXECUTE, Investment.EXAMINE, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_shangjirenling, R.mipmap.ic_wodeshangji, R.mipmap.wodezhixing, R.mipmap.wodeshenhe, R.mipmap.ic_shangjikanban};
                break;
            case "6": //集团领导
                busiTv = new String[]{Investment.TjTunityOne, Investment.MyClaim, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_wodeshangji, R.mipmap.ic_shangjikanban};
                break;
            case "7": //园区领导
                busiTv = new String[]{Investment.TjTunityOne, Investment.MyClaim, Investment.KANBAN};
                busiImg = new int[]{R.mipmap.ic_shangjituijian, R.mipmap.ic_wodeshangji, R.mipmap.ic_shangjikanban};
                break;
        }

        String[] queryTv = {"集团介绍", "产业园区", "产业集群", "存量客户", "租售物业", "配套服务", "公共平台", "合作伙伴", "招商政策"};
        String[] otherTv = {"统计", "企业查询", "企业动态"};

        int[] queryImg = {R.mipmap.query_1, R.mipmap.query_2, R.mipmap.query_3, R.mipmap.query_4, R.mipmap.query_5, R.mipmap.query_6, R.mipmap.query_7, R.mipmap.query_8, R.mipmap.query_9};
//        int[] otherImg = {R.mipmap.ic_tongji, R.mipmap.ic_qiyedongtai, R.mipmap.ic_zs_chacun};
        fillData(busiData, busiTv, busiImg, busiAdapter);
        fillData(queryData, queryTv, queryImg, queryAdapter);
//        fillData(otherData, otherTv, otherImg, otherAdapter);

        busiGv.setOnItemClickListener(this);
        queryGv.setOnItemClickListener(this);
//        otherGv.setOnItemClickListener(this);
    }

    /**
     * 商机看板数据
     */
    private void getKanBanData() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.KANBAN).params(params).execute(new ResCallBack<KanbanBean>(getActivity()) {
            @Override
            public void onCall(KanbanBean responseBean, Call call, Response response) throws JSONException {
                totalTv.setText(responseBean.getData().getTotalNum());
                addTv.setText(responseBean.getData().getRecentlyAdded());
            }
        });
    }

    /**
     * 填充数据
     */
    private void fillData(ArrayList<HomeModeBean> list, String[] tvs, int[] imgs, HomeGvAdapter adapter) {
        for (int i = 0; i < tvs.length; i++) {
            HomeModeBean homeModeBean = new HomeModeBean();
            homeModeBean.setTitle(tvs[i]);
            homeModeBean.setImg(imgs[i]);
            list.add(homeModeBean);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
        if (adapterView.getId() == R.id.busi_gv) {
            String investment = busiTv[i];
            switch (investment) {
                case Investment.TjTunityOne://推荐商机
                    intent.setClass(getActivity(), TjTunityOneAc.class);//GroomAc
                    intent.putExtra("tag", "home");
                    break;
                case Investment.RlTunity://认领商机
                    intent.setClass(getActivity(), RlTunityAc.class);//ClaimAc
                    intent.putExtra("tag", "home");
                    break;
                case Investment.MyClaim://我的推荐
                    //intent.setClass(getActivity(), MyTunity.class);// MyClaimAc
                    intent.setClass(getActivity(), MyClaimAc.class);
                    break;
                case Investment.EXECUTE://我的执行
                    intent.setClass(getActivity(), MyExecute.class);
                    break;
                case Investment.EXAMINE: //我的审核
                    intent.setClass(getActivity(), MyExamineAc.class);
                    break;
                case Investment.KANBAN://商机看板
                    //intent.setClass(getActivity(), KbTunity.class);//BoardAc
                    intent.setClass(getActivity(), BoardAc.class);
                    break;
            }
        } else if (adapterView.getId() == R.id.query_gv) {
            switch (i) {
                case 0://集团简介
                    intent.setClass(getActivity(), GroupAc.class);
                    break;
                case 1://产业园区
                    intent.setClass(getActivity(), YuanQuAc.class);
                    break;
                case 2://产业集群
                    intent.setClass(getActivity(), ClusterAc.class);
                    break;
                case 3://存量客户
                    intent.setClass(getActivity(), EntryAc.class);
                    break;
                case 4://租售物业
                    intent.setClass(getActivity(), BusinessAc.class);
                    break;
                case 5://配套服务
                    intent.setClass(getActivity(), MatingAc.class);
                    break;
                case 6://公共平台
                    intent.setClass(getActivity(), PublicAc.class);
                    break;
                case 7://合作伙伴
                    intent.setClass(getActivity(), PartnerAc.class);
                    break;
                case 8://政策列表
                    intent.setClass(getActivity(), PolicyListAc.class);
                    break;
            }

        } /*else if (adapterView.getId() == R.id.other_gv) {
            switch (i) {
                case 0://统计
                    intent.setClass(getActivity(), CountAc.class);
                    break;
                case 1://企业动态
                    intent.setClass(getActivity(), CompanyAc.class);
                    break;
                case 2://企业查询
                    intent.setClass(getActivity(), CompanyQueryAc.class);
                    break;
            }
        }*/
        startActivity(intent);
    }

    /**
     * 初始化webview
     */
    private void initWebView() {
        if (AppUtils.isNetworkAvailable(getActivity())) {
            errorLl.setVisibility(View.GONE);
            final String url = HttpApi.CHART + LoginManager.getInstance().getToken();

            if (url != null) {
                webView.loadUrl(url);
            }
        }
    }

    @Override
    public void refresh() {
//        initWebView();
        webView.reload();
        getKanBanData();
    }

    @Override
    public void loadMore() {

    }
}
