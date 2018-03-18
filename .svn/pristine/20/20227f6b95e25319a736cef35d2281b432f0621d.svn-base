package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.fragment.home.NeedBusinessFragment;
import com.lingang.fragment.home.NeedCorrectionFragment;
import com.lingang.fragment.home.NeedFeedbackFragment;
import com.lingang.fragment.home.NeedFlowFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 待办流程
 */
public class NeedAc extends BaseAc implements OnTabSelectListener {

    @BindView(R.id.need_category_stl)
    SlidingTabLayout needCategoryStl;
    @BindView(R.id.need_category_viewPager)
    ViewPager needCategoryViewPager;

    private List<Fragment> viewPagerFragement;
    private NeedPagerAdapter pagerAdapter;
    private String [] needTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_need);
        initView();
    }
    /**
     * 初始化
     */
    private void initView() {
        setTitle(getString(R.string.need_title));
        needTitle=getResources().getStringArray(R.array.need_tab_title);

        viewPagerFragement=new ArrayList<>();
        pagerAdapter=new NeedPagerAdapter(getSupportFragmentManager());
        viewPagerFragement.add(NeedFlowFragment.newInstance());
//        viewPagerFragement.add(NeedBusinessFragment.newInstance());
//        viewPagerFragement.add(NeedCorrectionFragment.newInstance());
//        viewPagerFragement.add(NeedFeedbackFragment.newInstance());

        needCategoryViewPager.setAdapter(pagerAdapter);
        needCategoryViewPager.setOffscreenPageLimit(1);
        needCategoryStl.setViewPager(needCategoryViewPager);
        needCategoryStl.setOnTabSelectListener(NeedAc.this);
        needCategoryViewPager.setCurrentItem(0);//设置Fragement页面索引

    }

    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

    /**
     * viewPager Adapter
     */
    public class NeedPagerAdapter extends FragmentStatePagerAdapter {
        public NeedPagerAdapter(FragmentManager fm) {super(fm);}
        @Override
        public Fragment getItem(int position) {
            return viewPagerFragement.get(position);
        }
        @Override
        public int getCount() {
            return viewPagerFragement.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return needTitle[position];
        }
    }
    /**
     * 页面跳转
     * @param content
     */
    public static void goToNeedAc(Context content)
    {
        Intent intent=new Intent(content,NeedAc.class);
        content.startActivity(intent);
    }
}
