package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2017/8/24.
 */

public class BottomDialog2Adapter extends RecycleBaseAdapter<String> {

    public BottomDialog2Adapter(Context context, List<String> mList) {
        super(context, mList);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item, int position) {
        holder.setText(R.id.pop_tv, item);
    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.item_dialog_bottom2;
    }
}
