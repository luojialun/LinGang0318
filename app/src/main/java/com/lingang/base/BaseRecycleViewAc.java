package com.lingang.base;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.callback.RefreshListion;
import com.lingang.utils.HttpPageUtils;
import com.lingang.view.RefreshView;
import com.umeng.analytics.MobclickAgent;

/**
 * @name LinGang
 * @class name：com.lingang.base
 * @class describe
 * @anthor Administrator
 * @time 2017/7/27 0027 10:08
 * @change
 * @chang time
 * @class describe
 */
public class BaseRecycleViewAc extends BaseAc {
    public int pageIndex;
    public int pageSize;
    private TwinklingRefreshLayout refresh;
    private HttpPageUtils instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    protected void isRefresh(String countRecord, String index, String size) {
        refresh.setEnableLoadmore(instance.judgeRefresh(countRecord, index, size));
    }

    //设置recycleview的分割线
    public void setRefreshViewLine(RecyclerView recyclerview, int id) {
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(id));//R.drawable.main_item_divider
        recyclerview.addItemDecoration(dividerItemDecoration1);
    }


    //设置下拉刷新的头控件
    public void setRefreshHead(TwinklingRefreshLayout refresh) {
        RefreshView headerView = new RefreshView(this);
        refresh.setHeaderView(headerView);
    }

    //设置recycleview LinearLayoutManager
    public void setRecycleAspect(RecyclerView recyclerview) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
    }

    //设置recycleview LinearLayoutManager
    public void setRecycleHorizontal(RecyclerView recyclerview) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);
    }

    //设置recycleview GrideviewManager
    public void setRecycleGride(RecyclerView recyclerview, int spanCount) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);
        recyclerview.setLayoutManager(gridLayoutManager);
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

    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview)
    {
        setRecycleSimpleStyle(recyclerview,LinearLayoutManager.VERTICAL, R.drawable.main_item_divider);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(orientation);
        recyclerview.setLayoutManager(layoutManager);
        /**
         *分割线
         */
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(dividerId));
        recyclerview.addItemDecoration(dividerItemDecoration1);
    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
