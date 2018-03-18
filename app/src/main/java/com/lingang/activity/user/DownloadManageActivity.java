package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lingang.R;
import com.lingang.adapter.DownloadTabAdapter;
import com.lingang.base.BaseAc;
import com.lingang.fragment.user.DownloadAllFragment;
import com.lingang.fragment.user.DownloadMyFragment;
import com.lingang.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 下载管理
 */
public class DownloadManageActivity extends BaseAc implements ViewPager.OnPageChangeListener{
//    @BindView(R.id.download_manage_title_bar)
//    TitleBar downloadManageTitleBar;
    @BindView(R.id.sliding_tabs)
    TabLayout mSlidingTabs;
    @BindView(R.id.viewpager)
    NoScrollViewPager mViewpager;

    DownloadMyFragment mDownloadFragment;
    DownloadAllFragment mAllDatasFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_download_manage);
        ButterKnife.bind(this);
        initListener();
        initDatas();
    }

    //初始化数据
    private void initDatas() {
        setTitle("下载管理");
        mDownloadFragment=new DownloadMyFragment();
        mAllDatasFragment=new DownloadAllFragment();
        //将fragment装进列表
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(mDownloadFragment);
        fragments.add(mAllDatasFragment);

        //将名称加载tab名字列表
        List<String> titles=new ArrayList<>();
        titles.add(getString(R.string.download_my));
        titles.add(getString(R.string.download_all));

        mSlidingTabs.addTab(mSlidingTabs.newTab().setText(titles.get(0)));
        mSlidingTabs.addTab(mSlidingTabs.newTab().setText(titles.get(1)));

        DownloadTabAdapter adapter=new DownloadTabAdapter(getSupportFragmentManager(),fragments,titles);
        mViewpager.setAdapter(adapter);
        mSlidingTabs.setupWithViewPager(mViewpager);
        mViewpager.addOnPageChangeListener(this);
    }

    /****************** viewpager event ***********************/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /*****************************************/
    private void initListener() {
        //downloadManageTitleBar.setOnClickTitleBarListener(this);
    }


    /**
     * 页面跳转
     * @param context
     */
    public static void goToDownloadManageActivity(Context context)
    {
        Intent intent=new Intent(context,DownloadManageActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}
