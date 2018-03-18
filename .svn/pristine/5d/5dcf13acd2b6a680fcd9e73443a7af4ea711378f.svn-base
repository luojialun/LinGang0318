package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PopWindowBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2017/11/3.
 */

public class PopupWindowAdapter extends RecycleBaseAdapter<PopWindowBean> {

    public PopupWindowAdapter(Context context, List<PopWindowBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, PopWindowBean item, int position) {
        holder.setImageResource(R.id.icon_iv, item.getImageview());
        holder.setText(R.id.content_tv, item.getContent());

        if(position==mData.size()-1){
            holder.setVisible(R.id.view,false);
        }else{
            holder.setVisible(R.id.view,true);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, PopWindowBean item) {
        return R.layout.item_popupwindow;
    }
}
