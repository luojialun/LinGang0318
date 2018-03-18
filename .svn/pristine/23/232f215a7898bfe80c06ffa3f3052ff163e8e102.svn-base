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

public class RlTunityTabAdapter extends RecycleLabAdapter<String> {
    public RlTunityTabAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final String item, int position) {


        holder.setText(R.id.itme_tv_tag, item);

    }


    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.itme_tagflow_tunity;
    }
}
