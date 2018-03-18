package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.RankingAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.dialog.RankingRulesDialog;
import com.lingang.view.RefreshView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 排行榜
 */
public class ListAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener {

    @BindView(R.id.ranking_recycler_view)
    RecyclerView rankingRecyclerView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ib_right)
    ImageView ibRight;
    @BindView(R.id.ib_left)
    ImageView ibLeft;
    @BindView(R.id.ranking_about_iv)
    ImageView rankingAboutIv;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    private RankingAdapter rankingAdapter;
    private ArrayList<BannerBean.DataBean.ListBean> data;

    private RankingRulesDialog dialog;

    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        initView();
    }

    //初始化
    private void initView() {
        RefreshView headerView = new RefreshView(ListAc.this);
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 600);
            }
        });


        dialog = new RankingRulesDialog(this);
        ibLeft.setImageResource(R.mipmap.backwhite);
        //ibRight.setVisibility(View.VISIBLE);
        //ibRight.setImageResource(R.mipmap.share_white);
        position=getIntent().getIntExtra("position",1);
        switch (position)
        {
            case 0:
                tvTitle.setText(getString(R.string.ranking_title));
                break;
            case 1:
                tvTitle.setText(getString(R.string.ranking_title_personal));
                break;
            case 2:
                tvTitle.setText(getString(R.string.ranking_title_fall));
                break;
        }


        rankingRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankingRecyclerView.setLayoutManager(mLayoutManager);
        rankingRecyclerView.setNestedScrollingEnabled(false);


        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(R.drawable.main_item_divider));
        rankingRecyclerView.addItemDecoration(dividerItemDecoration1);

        data = new ArrayList<>();
        rankingAdapter = new RankingAdapter(this, data);
        rankingAdapter.setOnItemClickListener(this);
        rankingRecyclerView.setAdapter(rankingAdapter);

        //模拟10条数据
        for (int i = 0; i < 10; i++) {
            data.add(new BannerBean.DataBean.ListBean());
        }
        rankingAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.ib_left, R.id.ranking_about_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_left:
                onBackPressed();
                finish();
                break;
            case R.id.ranking_about_iv:
                dialog.show();
                break;
        }
    }

    @Override
    public void onItemClick(View view, Object item, int position) {

    }

    //页面跳转
    public static void goToListAc(Context context,int position) {
        Intent intent = new Intent(context, ListAc.class);
        intent.putExtra("position",position);
        context.startActivity(intent);
    }
}
