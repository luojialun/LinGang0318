package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.PolicyListBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PolicyLableAdapter extends RecycleLabAdapter<PolicyListBean.DataBean.ListBean.LabelsBean> {
    public PolicyLableAdapter(Context context, List<PolicyListBean.DataBean.ListBean.LabelsBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PolicyListBean.DataBean.ListBean.LabelsBean item, int position) {


        holder.setText(R.id.itme_tv_tag, item.getLabelName());
    }


    @Override
    protected int getItemViewLayoutId(int position, PolicyListBean.DataBean.ListBean.LabelsBean item) {
        return R.layout.itme_tv_tagflow;
    }
}
