package com.lingang.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * @name LinGang
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/6/21 0021 16:05
 * @change
 * @chang time
 * @class describe
 */
public class ImgBigAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<ImageView> data;

    public ImgBigAdapter(Context context, ArrayList<ImageView> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(data.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = data.get(position);
        container.addView(imageView);
        return imageView;
    }
}
