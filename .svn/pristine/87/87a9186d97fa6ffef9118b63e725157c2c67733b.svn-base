package com.lingang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */

public class DownloadTabAdapter extends FragmentPagerAdapter {

    //fragment列表
    private List<Fragment> mList;
    //tab名的列表
    private List<String> list_title;

    public DownloadTabAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.mList=fragments;
        this.list_title=titles;

    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return list_title.get(position % list_title.size());
    }



}
