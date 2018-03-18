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
import com.lingang.activity.home.NeedCorrectionReviewAc;
import com.lingang.base.BaseFragment;
import com.lingang.view.RefreshView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jason on 17/5/24.
 * 纠错审核
 */
public class NeedCorrectionFragment extends BaseFragment {
    @BindView(R.id.need_correction_refresh)
    TwinklingRefreshLayout needCorrectionRefresh;
    @BindView(R.id.testClick)
    RelativeLayout testClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_need_correction, null);
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
        needCorrectionRefresh.setHeaderView(headerView);
        needCorrectionRefresh.setAutoLoadMore(true);
        needCorrectionRefresh.startRefresh();
        needCorrectionRefresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                needCorrectionRefresh.finishRefreshing();
            }
            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                needCorrectionRefresh.finishLoadmore();
            }
        });
    }


    @OnClick({R.id.testClick,R.id.testClick2})
    public void onViewClicked() {
        NeedCorrectionReviewAc.goToNeedCorrectionReviewAc(getContext());
    }
    /*
     *创建实例
     */
    public static NeedCorrectionFragment newInstance()
    {
        NeedCorrectionFragment fragment=new NeedCorrectionFragment();
        return fragment;
    }
}
