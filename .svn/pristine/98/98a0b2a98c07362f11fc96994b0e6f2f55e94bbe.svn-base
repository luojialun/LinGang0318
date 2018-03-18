package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.EntryBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class EntryTabAdapter extends RecycleLabAdapter<EntryBean.DataBean.ListBean.LabelsBean> {
    public EntryTabAdapter(Context context, List<EntryBean.DataBean.ListBean.LabelsBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final EntryBean.DataBean.ListBean.LabelsBean item, int position) {


        holder.setText(R.id.itme_tv_tag, item.getLabelName());
    }


    @Override
    protected int getItemViewLayoutId(int position, EntryBean.DataBean.ListBean.LabelsBean item) {
        return R.layout.itme_tv_tagflow;
    }
}
