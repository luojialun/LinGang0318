package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.leftBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class HistoryAdapter extends RecycleBaseAdapter<leftBean> {
    public HistoryAdapter(Context context, List<leftBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final leftBean item, int position) {


        holder.setText(R.id.tv_left, item.getContent());
    }


    @Override
    protected int getItemViewLayoutId(int position, leftBean item) {
        return R.layout.itme_left;
    }
}
