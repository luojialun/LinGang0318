package com.lingang.fragment.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.activity.home.PolicyDetialesAc;
import com.lingang.adapter.FavoritesBusinessAdapter;
import com.lingang.adapter.FavoritesPolicyAdapter;
import com.lingang.adapter.PolicyListAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BusinessBean;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.PolicyListBean;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 用户收藏==》招商政策
 */
public class FavoritesPolicyFragment extends BaseFragment{
    private static final String TAG = "FavoritesPublicFragment";
    @BindView(R.id.recyclerview)
    RecyclerView recycleview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refreshLayout;

    private ArrayList<PolicyListBean.DataBean.ListBean> dataList;
    private FavoritesPolicyAdapter adapter;
    private PagerHelper pagerHelper;
    private int collectType = -1;//类型(1.集团园区 2.合作伙伴 3.配套服务 4.入驻企业 5.公共平台6.租售物业 7.新闻）
    private boolean isFavorites=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycleview, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initView();
    }
    public void init() {
        dataList=new ArrayList<>();
        pagerHelper=new PagerHelper(getContext());
        Bundle bundle = getArguments();
        if (bundle != null) {
            collectType = bundle.getInt("collectType");
            isFavorites=bundle.getBoolean("isFavorites");
        }
    }
    private void initView() {
        setRecycleSimpleStyle(recycleview);
        adapter = new FavoritesPolicyAdapter(getContext(),dataList,isFavorites);
        recycleview.setAdapter(adapter);
        setRefreshHead(refreshLayout);
        refreshLayout.startRefresh();
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                dataList.clear();
                pagerHelper.refreshPage();
                handleSearchHttp();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                if(pagerHelper.loadMore()) {
                    handleSearchHttp();
                }else
                {
                    refreshLayout.finishLoadmore();
                }
            }
        });
    }

    private void handleSearchHttp() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("collectType",collectType);
        OkGo.post(HttpApi.UserCollect)
                .params(httpParams)
                .tag(getContext())
                .execute(new ResCallBack<HomeSearchResponse<PolicyListBean.DataBean.ListBean>>(getActivity(),false) {
                    @Override
                    public void onCall(HomeSearchResponse<PolicyListBean.DataBean.ListBean> responseResult, Call call, Response response) {
                    List<PolicyListBean.DataBean.ListBean> list = responseResult.getData().getList();
                    dataList.addAll(list);
                    adapter.notifyDataSetChanged();

                    if(pagerHelper.loadFinish(list.size()))
                    {
                        refreshLayout.finishRefreshing();
                    }else
                    {
                        refreshLayout.finishLoadmore();
                    }
                }
        });
    }
}
