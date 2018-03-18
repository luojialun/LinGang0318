package com.lingang.fragment.home.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.adapter.HomeSearchNewsListAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.NewsDetailsBean;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.RefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 搜索结果界面==》新闻界面
 */

public class SearchNewsFragment extends BaseFragment implements RecycleBaseAdapter.OnItemClickListener{
    private static final String TAG = "SearchNewsFragment";
    @BindView(R.id.recyclerview)
    RecyclerView recycleview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refreshLayout;

    private ArrayList<NewsDetailsBean.DataBean> newsList;
    private HomeSearchNewsListAdapter homeNewsListAdapter;
    private PagerHelper pagerHelper;
    private int type = -1;//类型(1.新闻 2.招商政策 3.产业园区 4.入驻企业 5.合作伙伴 6.租售物业 7.配套服务
    private String keywords;

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
        newsList=new ArrayList<>();
        pagerHelper=new PagerHelper(getContext());
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
            keywords = bundle.getString("keywords");
        }
    }
    private void initView() {
        setRecycleSimpleStyle(recycleview);
        homeNewsListAdapter = new HomeSearchNewsListAdapter(getContext(),newsList);
        recycleview.setAdapter(homeNewsListAdapter);
        homeNewsListAdapter.setOnItemClickListener(this);
        setRefreshHead(refreshLayout);
        refreshLayout.startRefresh();
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                newsList.clear();
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

    @Override
    public void onItemClick(View view, Object item, int position) {
        if(newsList !=null) {
            NewsDetailsAc.goToNewsDetailsAc(getContext(), newsList.get(position).getNewsId());
        }
    }

    private void handleSearchHttp() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        if(!TextUtils.isEmpty(keywords)) {
            httpParams.put("keywords", keywords);
        }
        httpParams.put("type",String.valueOf(type));
        OkGo.post(HttpApi.HOME_SEARCH)
                .params(httpParams)
                .execute(new ResCallBack<HomeSearchResponse<NewsDetailsBean.DataBean>>(getActivity(),false) {
                    @Override
                    public void onCall(HomeSearchResponse<NewsDetailsBean.DataBean> dataBeanHomeSearchResponse, Call call, Response response) {
                        List<NewsDetailsBean.DataBean> list = dataBeanHomeSearchResponse.getData().getList();
                        newsList.addAll(list);
                        homeNewsListAdapter.notifyDataSetChanged();

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
