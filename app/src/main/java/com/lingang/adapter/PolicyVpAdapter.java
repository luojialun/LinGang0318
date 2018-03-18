package com.lingang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lingang.bean.AllClassBean;
import com.lingang.bean.PolicyListBean;
import com.lingang.fragment.other.PolicyFragment;

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
public class PolicyVpAdapter extends FragmentPagerAdapter {
    private List<PolicyListBean.DataMapBean.ListBeanX> list;
    private ArrayList<Fragment> fragments;
    public PolicyVpAdapter(FragmentManager fm,ArrayList<Fragment> fragments, List<PolicyListBean.DataMapBean.ListBeanX> list) {
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
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
