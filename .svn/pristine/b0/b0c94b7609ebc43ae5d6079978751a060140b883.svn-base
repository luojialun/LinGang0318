package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ListLableAdapter extends RecycleLabAdapter<ClusterBean.DataBean.ListBean.LabelsBean> {
    public ListLableAdapter(Context context, List<ClusterBean.DataBean.ListBean.LabelsBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ClusterBean.DataBean.ListBean.LabelsBean item, int position) {

        String stepStr=(position ==0)?"":"/";
        holder.setText(R.id.item_tv_tag, stepStr+item.getLabelName());
    }


    @Override
    protected int getItemViewLayoutId(int position, ClusterBean.DataBean.ListBean.LabelsBean item) {
        return R.layout.item_tv_tagflow;
    }
}
