package com.lingang.fragment.home;

import android.content.Intent;
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
import com.lingang.bean.NewsTabBean;
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
 * 新闻搜索
 */
public class NewsSearchFragment extends Fragment implements RecycleBaseAdapter.OnItemClickListener{

    public static final String WHICH_SEARCH_RESULT = "which_search_result";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private List<BannerBean.DataBean.ListBean> data;
    private NewsAdapter newsAdapter;

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.recycle_view_single, container, false);
        ButterKnife.bind(this, mView);
        initViewData();
        return mView;
    }

    public static NewsSearchFragment newInstance(ArrayList<BannerBean.DataBean.ListBean> mData) {
        Bundle args = new Bundle();
        args.putSerializable(WHICH_SEARCH_RESULT, mData);
        NewsSearchFragment fragment = new NewsSearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initViewData() {
        data = (List<BannerBean.DataBean.ListBean>) getArguments().getSerializable(WHICH_SEARCH_RESULT);
        initView();
    }
    /**
     * 初始化控件
     */
    public void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(R.drawable.main_item_divider));
        recyclerview.addItemDecoration(dividerItemDecoration1);

        if(data !=null && data.size()>0) {
            newsAdapter = new NewsAdapter(getActivity(), data);
            newsAdapter.setOnItemClickListener(this);
            recyclerview.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onItemClick(View view, Object item, int position) {
        NewsDetailsAc.goToNewsDetailsAc(getContext(),data.get(position).getNewsId());
    }
}
