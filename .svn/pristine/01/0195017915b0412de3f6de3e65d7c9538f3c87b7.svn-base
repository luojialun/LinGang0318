package com.lingang.base;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.callback.RefreshListion;
import com.lingang.utils.AppUtils;
import com.lingang.utils.HttpLoading;
import com.lingang.utils.HttpPageUtils;
import com.lingang.view.RefreshView;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;
    public int pageIndex = 1;
    public int pageSize = 20;
    private TwinklingRefreshLayout refresh;
    private HttpPageUtils instance;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (instance == null) {
            instance = HttpPageUtils.getInstance();
        }
        pageIndex = instance.getPageIndex();
        pageSize = instance.getPageSize();
    }

    /**
     * 判断是否还存在分页
     */
    public void isRefresh(String countRecord, String index, String size) {
        refresh.setEnableLoadmore(instance.judgeRefresh(countRecord, index, size));
    }

    //设置recycleview的分割线
    public void setRefreshViewLine(RecyclerView recyclerview, int id) {
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(id));//R.drawable.main_item_divider
        recyclerview.addItemDecoration(dividerItemDecoration1);
    }


    //设置下拉刷新的头控件
    public void setRefreshHead(TwinklingRefreshLayout refresh) {
        RefreshView headerView = new RefreshView(getActivity());
        refresh.setHeaderView(headerView);
    }

    //设置recycleview LinearLayoutManager
    public void setRecycleAspect(RecyclerView recyclerview) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
    }

    //设置recycleview LinearLayoutManager
    public void setRecycleGvAspect(RecyclerView recyclerview) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerview.setLayoutManager(layoutManager);
    }

    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview)
    {
        setRecycleSimpleStyle(recyclerview,LinearLayoutManager.VERTICAL,R.drawable.main_item_divider);
    }

    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     * @param dividerId 分割线
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview, int dividerId)
    {
        setRecycleSimpleStyle(recyclerview,LinearLayoutManager.VERTICAL,dividerId);
    }
    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     * @param orientation 方向
     * @param dividerId 分割线
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview, int orientation,int dividerId)
    {
        /**
         *列表方向
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(orientation);
        recyclerview.setLayoutManager(layoutManager);
        /**
         *分割线
         */
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(dividerId));
        recyclerview.addItemDecoration(dividerItemDecoration1);
    }


    //设置刷新回调
    public void setRefreshLison(final TwinklingRefreshLayout refresh, final RefreshListion listion) {
        this.refresh = refresh;
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {

                refresh.finishRefreshing();
                listion.refresh();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                refresh.finishLoadmore();
                listion.loadMore();
            }
        });
    }

    public void showLoading(){
        if (progressDialog == null){
            progressDialog = HttpLoading.getInstance().initLoading(getActivity());
        }
        if (!progressDialog.isShowing()){
            progressDialog.show();
        }

    }

    public void hideLoading(){
        if (progressDialog == null ){
            progressDialog = HttpLoading.getInstance().initLoading(getActivity());
        }
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        progressDialog = null;

    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @return
     */
    protected boolean isNetwork()
    {
        return AppUtils.isNetworkAvailable(getContext());
    }
}
