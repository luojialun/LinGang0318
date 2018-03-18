package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.flowlayout.FlowLayout;
import com.lingang.view.flowlayout.TagAdapter;
import com.lingang.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ParkAdapter extends RecycleBaseAdapter<String> {
    public ParkAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final String item, int position) {

    }


    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.itme_park;
    }
}
