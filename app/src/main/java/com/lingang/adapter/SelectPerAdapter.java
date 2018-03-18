package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.TypeBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class SelectPerAdapter extends RecycleBaseAdapter<TypeBean> {
    public SelectPerAdapter(Context context, List<TypeBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final TypeBean item, int position) {
        CheckBox view = holder.getView(R.id.cb_per_itme);
        view.setChecked(item.isCheck());
    }


    @Override
    protected int getItemViewLayoutId(int position, TypeBean item) {
        return R.layout.itme_selectper;
    }
}
