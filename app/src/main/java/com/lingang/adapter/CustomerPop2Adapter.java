package com.lingang.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2017/8/21.
 */

public class CustomerPop2Adapter extends RecycleBaseAdapter<String> {
    private String str;
    private Context context;

    public CustomerPop2Adapter(Context context, List<String> mList) {
        super(context, mList);
        this.context = context;
        str = mList.get(0);
    }

    public void setmList(List<String> mList) {
        mData = mList;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder holder, String item, int position) {
        holder.setText(R.id.pop_tv, item);
        if (str.equals(item)) {
            holder.setTextColor(R.id.pop_tv, context.getResources().getColor(R.color.word_orange_color_F57725));
            holder.setBackgroundColor(R.id.line, context.getResources().getColor(R.color.word_orange_color_F57725));
        } else {
            holder.setTextColor(R.id.pop_tv, context.getResources().getColor(R.color.black_80));
            holder.setBackgroundColor(R.id.line, context.getResources().getColor(R.color.black_10));
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.item_customer_pop2;
    }

    public void setItemSelected(String str) {
        this.str = str;
        notifyDataSetChanged();
    }
}
