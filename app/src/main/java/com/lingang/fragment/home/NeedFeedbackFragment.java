package com.lingang.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.NeedFeedbackReviewAc;
import com.lingang.base.BaseFragment;
import com.lingang.view.RefreshView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 意见反馈
 */
public class NeedFeedbackFragment extends BaseFragment {
    @BindView(R.id.need_feedback_refresh)
    TwinklingRefreshLayout needFeedbackRefresh;
    @BindView(R.id.testClick)
    RelativeLayout testClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_need_feedback, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        RefreshView headerView = new RefreshView(getActivity());
        needFeedbackRefresh.setHeaderView(headerView);
        needFeedbackRefresh.setAutoLoadMore(true);
        needFeedbackRefresh.startRefresh();
        needFeedbackRefresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                needFeedbackRefresh.finishRefreshing();
            }
            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                needFeedbackRefresh.finishLoadmore();
            }
        });
    }


    @OnClick({R.id.testClick,R.id.testClick2})
    public void onViewClicked() {
        NeedFeedbackReviewAc.goToNeedFeedbackReviewAc(getContext());
    }
    /*
     *创建实例
     */
    public static NeedFeedbackFragment newInstance()
    {
        NeedFeedbackFragment fragment=new NeedFeedbackFragment();
        return fragment;
    }
}
