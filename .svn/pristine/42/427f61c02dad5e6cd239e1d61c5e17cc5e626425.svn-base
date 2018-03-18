package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ParkDetailsBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ParkTabAdapter extends RecycleLabAdapter<ParkDetailsBean.DataBean.StationsBean.LabelsBeanX> {
    public ParkTabAdapter(Context context, List<ParkDetailsBean.DataBean.StationsBean.LabelsBeanX> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ParkDetailsBean.DataBean.StationsBean.LabelsBeanX item, int position) {


        holder.setText(R.id.itme_tv_tag, item.getLabelName());
    }


    @Override
    protected int getItemViewLayoutId(int position, ParkDetailsBean.DataBean.StationsBean.LabelsBeanX item) {
        return R.layout.itme_tv_tagflow;
    }
}
