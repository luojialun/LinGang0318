package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.IndustryDetailsBean;
import com.lingang.bean.ParkDetailsBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class JiqunTabAdapter extends RecycleLabAdapter<IndustryDetailsBean.DataBean.StationsBean.LabelsBeanXX> {
    public JiqunTabAdapter(Context context, List<IndustryDetailsBean.DataBean.StationsBean.LabelsBeanXX> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final IndustryDetailsBean.DataBean.StationsBean.LabelsBeanXX item, int position) {


        holder.setText(R.id.itme_tv_tag, item.getLabelName());
    }


    @Override
    protected int getItemViewLayoutId(int position, IndustryDetailsBean.DataBean.StationsBean.LabelsBeanXX item) {
        return R.layout.itme_tv_tagflow;
    }
}
