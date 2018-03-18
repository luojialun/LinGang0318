package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.TypeBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.flowlayout.FlowLayout;
import com.lingang.view.flowlayout.TagAdapter;
import com.lingang.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class InvestmentAdapter extends RecycleBaseAdapter<TypeBean> {
    public InvestmentAdapter(Context context, List<TypeBean> data) {

        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final TypeBean item, int position) {

        CheckBox view = holder.getView(R.id.cb_itme);
        view.setChecked(item.isCheck());

    }

    @Override
    protected int getItemViewLayoutId(int position, TypeBean item) {
        return R.layout.itme_cb;
    }
}
