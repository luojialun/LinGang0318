package com.lingang.activity.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.lingang.R;
import com.lingang.adapter.HistoryAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.leftBean;

import java.util.ArrayList;

import butterknife.BindView;

public class Left2Activity extends BaseAc {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ArrayList<leftBean> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_left);
        setTitle("left2");
        initData();
        initRrfresh();
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            leftBean leftBean = new leftBean();
            leftBean.setContent(""+i);
            data.add(leftBean);
        }
    }

    private void initRrfresh() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        final HistoryAdapter historyAdapter = new HistoryAdapter(this, data);
        recyclerview.setAdapter(historyAdapter);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(R.drawable.main_item_divider));
        recyclerview.addItemDecoration(dividerItemDecoration1);

        BezierLayout headerView = new BezierLayout(this);
        refresh.setHeaderView(headerView);
        refresh.setAutoLoadMore(true);

//        refresh.setPureScrollModeOn();//回弹效果
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        historyAdapter.notifyDataSetChanged();
                        refresh.finishLoadmore();
                    }
                }, 2000);
            }

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.clear();
                        initData();
                        historyAdapter.notifyDataSetChanged();
                        refresh.finishRefreshing();
                    }
                }, 2000);
            }
        });
    }
}
