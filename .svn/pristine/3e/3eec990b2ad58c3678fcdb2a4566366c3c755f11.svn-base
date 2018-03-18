package com.lingang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllAdressBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PopZoneAdapter extends RecycleBaseAdapter<AllAdressBean> {
    public PopZoneAdapter(Context context, List<AllAdressBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final AllAdressBean item, int position) {
        TextView view = holder.getView(R.id.tv_adre);
        view.setText(item.getName());
        if (item.isselect()){
            view.setBackgroundResource(R.color.white);
        }else {
            view.setBackgroundResource(R.color.transparent);
        }

    }


    @Override
    protected int getItemViewLayoutId(int position, AllAdressBean item) {
        return R.layout.pop_zone;
    }
}
