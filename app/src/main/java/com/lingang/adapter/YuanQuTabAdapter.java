package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.YuanQuBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class YuanQuTabAdapter extends RecycleLabAdapter<YuanQuBean.DataBean.ListBean.LabelsBean> {
    public YuanQuTabAdapter(Context context, List<YuanQuBean.DataBean.ListBean.LabelsBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final YuanQuBean.DataBean.ListBean.LabelsBean item, int position) {


        holder.setText(R.id.itme_tv_tag, item.getLabelName());
    }


    @Override
    protected int getItemViewLayoutId(int position, YuanQuBean.DataBean.ListBean.LabelsBean item) {
        return R.layout.itme_tv_tagflow;
    }
}
