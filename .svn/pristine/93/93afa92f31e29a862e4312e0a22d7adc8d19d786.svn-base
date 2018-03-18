package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ListTabAdapter extends RecycleLabAdapter<ClusterBean.DataBean.ListBean.LabelsBean> {
    public ListTabAdapter(Context context, List<ClusterBean.DataBean.ListBean.LabelsBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ClusterBean.DataBean.ListBean.LabelsBean item, int position) {

        if (null != item && !TextUtils.isEmpty(item.getLabelName())) {
            holder.setText(R.id.itme_tv_tag, item.getLabelName());
        }
    }


    @Override
    protected int getItemViewLayoutId(int position, ClusterBean.DataBean.ListBean.LabelsBean item) {
        return R.layout.itme_tv_tagflow;
    }
}
