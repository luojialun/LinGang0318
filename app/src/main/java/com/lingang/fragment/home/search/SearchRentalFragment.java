package com.lingang.fragment.home.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.activity.home.PropertyDettailsAc;
import com.lingang.adapter.BusinessAdapter;
import com.lingang.adapter.BusinessSeachAdapter;
import com.lingang.adapter.YuanQuAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BusinessBean;
import com.lingang.bean.HomeSearchResponse;
import com.lingang.bean.YuanQuBean;
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
 * 搜索结果界面==》租售物业
 */
public class SearchRentalFragment extends BaseFragment implements RecycleBaseAdapter.OnItemClickListener{
    private static final String TAG = "SearchRentalFragment";
    @BindView(R.id.recyclerview)
    RecyclerView recycleview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refreshLayout;

    private ArrayList<BusinessBean.DataBean.ListBean> dataList;
    private BusinessSeachAdapter adapter;
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
        dataList=new ArrayList<>();
        pagerHelper=new PagerHelper(getContext());
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
            keywords = bundle.getString("keywords");
        }
    }
    private void initView() {
        setRecycleSimpleStyle(recycleview);
        adapter = new BusinessSeachAdapter(getContext(),dataList);
        recycleview.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(View view, Object item, int position) {
        if(dataList !=null) {
            Intent intent=new Intent(getContext(), PropertyDettailsAc.class);
            intent.putExtra("id", dataList.get(position).getBusinessId());
            intent.putExtra("title",dataList.get(position).getBusinessName());
            startActivity(intent);
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
                .execute(new ResCallBack<HomeSearchResponse<BusinessBean.DataBean.ListBean>>(getActivity(),false) {
                    @Override
                    public void onCall(HomeSearchResponse<BusinessBean.DataBean.ListBean> responseResult, Call call, Response response) {
                        List<BusinessBean.DataBean.ListBean> list = responseResult.getData().getList();
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