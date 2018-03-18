package com.lingang.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
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
import com.lingang.adapter.NewsAdapter;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
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
 * Created by jason on 16/11/1.
 *
 */
public class NewsCategoryFragment extends Fragment implements RecycleBaseAdapter.OnItemClickListener{

    public static final String WHICH_CATEGORY = "which_category_id";
    public static final String WHICH_KEYWORDS_NAME = "which_keywords";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;

    //分页
    private PagerHelper pagerHelper;
    private ArrayList<BannerBean.DataBean.ListBean> data;
    private NewsAdapter newsAdapter;
    //private ArrayList<NewsTabBean.DataBean> tabList;

    private View mView;
    private String basicsId;
    private String keywords;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.recycleview, container, false);
        ButterKnife.bind(this, mView);
        initViewData();
        return mView;
    }

    public static NewsCategoryFragment newInstance(String whichCategory, String keywords) {
        Bundle args = new Bundle();
        args.putString(WHICH_CATEGORY, whichCategory);
        args.putString(WHICH_KEYWORDS_NAME, keywords);
        NewsCategoryFragment fragment = new NewsCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initViewData() {
        basicsId = getArguments().getString(WHICH_CATEGORY, App.Empty);
        keywords = getArguments().getString(WHICH_KEYWORDS_NAME, App.Empty);
        initView();

    }
    /**
     * 初始化控件
     */
    private void initView() {
        pagerHelper=new PagerHelper(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(R.drawable.main_item_divider));
        recyclerview.addItemDecoration(dividerItemDecoration1);

        data = new ArrayList<>();
        newsAdapter = new NewsAdapter(getActivity(), data);
        newsAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(newsAdapter);

        RefreshView headerView = new RefreshView(getActivity());
        refresh.setHeaderView(headerView);
        refresh.setAutoLoadMore(true);
        //refresh.startRefresh();
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                //data.clear();
                pagerHelper.refreshPage();
                getBanner(basicsId);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                if(pagerHelper.loadMore()) {
                    getBanner(basicsId);
                }else
                {
                    refreshLayout.finishLoadmore();
                }
            }
        });
    }
    /**
     * 搜索
     * @param mKeywords
     */
    public void search(String mKeywords)
    {
        keywords=mKeywords;
        //refresh.setAutoLoadMore(true);
        refresh.startRefresh();
    }

    /**
     * 设置查询关键字
     * @param mKeywords
     */
    public void setKeywords(String mKeywords)
    {
        keywords=mKeywords;
    }
    /**
     * 清除关键字
     */
    public void clearKeywords()
    {
        keywords=App.Empty;
    }

    private void getBanner(String basicsId) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        httpParams.put("basicsId", basicsId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        if(!TextUtils.isEmpty(keywords)) {
            httpParams.put("keywords", keywords);
        }
        OkGo.post(HttpApi.HOME_BANNER)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BannerBean>(getActivity(),false) {
                    @Override
                    public void onCall(BannerBean banner, Call call, Response response) {
                        List<BannerBean.DataBean.ListBean> list = banner.getData().getList();
                        if(pagerHelper.isRefresh())
                        {
                            data.clear();
                        }
                        data.addAll(list);
                        newsAdapter.notifyDataSetChanged();
                        pagerHelper.loadFinish(list.size());
                        finishRefresh();
                    }
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        if(pagerHelper.isRefresh())
                        {
                            data.clear();
                        }
                        finishRefresh();
                    }
                });
    }

    /**
     *完成刷新
     */
    private void finishRefresh()
    {
        if(pagerHelper.isRefresh())
        {
            refresh.finishRefreshing();
        }else
        {
            refresh.finishLoadmore();
        }
    }
//    //获取tab表情
//    private void getTab() {
//        HttpParams httpParams = new HttpParams();
//        httpParams.put("basicsType", "6");
//        httpParams.put("token", LoginManager.getInstance().getToken());
//        OkGo.post(HttpApi.basicsList)
//                .params(httpParams)
//                .execute(new ResCallBack<NewsTabBean>(getActivity()) {
//                    @Override
//                    public void onCall(NewsTabBean newstab, Call call, Response response) {
//                        if (tabList == null) {
//                            tabList = new ArrayList<>();
//                        }
//                        tabList.addAll(newstab.getData());
////                        for (NewsTabBean.DataBean dataBean : tabList) {
////                            tabLayout.addTab(tabLayout.newTab().setText(dataBean.getBasicsName()));
////                        }
////                        tabLayout.addOnTabSelectedListener(NewsAc.this);
//                        basicsId = tabList.get(0).getBasicsId();
//                        getBanner(pageIndex + "", pageSize + "", true, basicsId);
//                    }
//                });
//    }

//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        basicsId = tabList.get(tab.getPosition()).getBasicsId();
//        getBanner(pageIndex + "", pageSize + "", true, basicsId);
//    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        NewsDetailsAc.goToNewsDetailsAc(getContext(),data.get(position).getNewsId());
    }
}
