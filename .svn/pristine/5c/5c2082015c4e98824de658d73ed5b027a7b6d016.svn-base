package com.lingang.adapter;

import android.content.Context;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.AllClassBean;
import com.lingang.bean.TypeListBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class BusinessPopAdapter extends RecycleBaseAdapter<AllClassBean.DataBean> {
    public BusinessPopAdapter(Context context, List<AllClassBean.DataBean> data) {
        super(context, data);
    }


    @Override
    protected void convert(final BaseViewHolder holder, final AllClassBean.DataBean item, int position) {
        TextView view = holder.getView(R.id.one_level);
        Context context = view.getContext();
        view.setText(item.getBasicsName());

        if (item.isselect()) {
            view.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            view.setTextColor(context.getResources().getColor(R.color.black));
        }
    }


    @Override
    protected int getItemViewLayoutId(int position, AllClassBean.DataBean item) {
        return R.layout.itme_onelevel;
    }
}
