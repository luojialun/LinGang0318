package com.lingang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lingang.bean.NewAddBean;
import com.lingang.bean.PolicyListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/5/31 0031 11:11
 * @change
 * @chang time
 * @class describe
 */
public class NewAddVpAdapter extends FragmentPagerAdapter {
    private List<NewAddBean.DataMapBean.ListBeanX> list;
    private ArrayList<Fragment> fragments;

    public NewAddVpAdapter(FragmentManager fm, ArrayList<Fragment> fragments, List<NewAddBean.DataMapBean.ListBeanX> list) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
