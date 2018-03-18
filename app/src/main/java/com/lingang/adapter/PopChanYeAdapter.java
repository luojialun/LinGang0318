package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AdressBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PopChanYeAdapter extends RecycleBaseAdapter<AdressBean> {
    public PopChanYeAdapter(Context context, List<AdressBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final AdressBean item, int position) {
        TextView view = holder.getView(R.id.tv_value);
        Context context = view.getContext();
        view.setText(item.getRegionName());
        if (position == 0){
            View vieww = holder.getView(R.id.v_line);
            vieww.setVisibility(View.GONE);
        }
        if (item.isselect()) {
            view.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            view.setTextColor(context.getResources().getColor(R.color.black));
        }
    }


    @Override
    protected int getItemViewLayoutId(int position, AdressBean item) {
        return R.layout.pop_chanye;
    }
}
