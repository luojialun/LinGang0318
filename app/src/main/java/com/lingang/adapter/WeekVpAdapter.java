package com.lingang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.lingang.fragment.other.WeekFragment;

import java.util.ArrayList;

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
public class WeekVpAdapter extends FragmentPagerAdapter {
    private ArrayList<String> list;
    private ArrayList<Fragment> frangments;

    public WeekVpAdapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> frangments) {
        super(fm);
        this.list = list;
        this.frangments = frangments;
    }

    @Override
    public Fragment getItem(int position) {
        return frangments.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
