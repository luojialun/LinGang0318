package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AdressBean;
import com.lingang.bean.TypeListBean;
import com.lingang.http.ResCallBack;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PopLevelAdapter extends RecycleBaseAdapter<TypeListBean.DataBean.ListBean> {
    public PopLevelAdapter(Context context, List<TypeListBean.DataBean.ListBean> data) {
        super(context, data);
    }



    @Override
    protected void convert(final BaseViewHolder holder, final TypeListBean.DataBean.ListBean item, int position) {
        TextView view = holder.getView(R.id.one_level);
        Context context = view.getContext();
        view.setText(item.getTypeName());

        if (item.isselect()) {
            view.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            view.setTextColor(context.getResources().getColor(R.color.black));
        }
    }


    @Override
    protected int getItemViewLayoutId(int position, TypeListBean.DataBean.ListBean item) {
        return R.layout.itme_onelevel;
    }
}
