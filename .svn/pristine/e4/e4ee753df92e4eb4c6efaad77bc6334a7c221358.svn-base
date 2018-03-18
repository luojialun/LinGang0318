package com.lingang.adapter;

import android.content.Context;
import android.view.View;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by jason on 17/8/25.
 * 更新执行
 */
public class UpdateExecuteAdapter extends RecycleBaseAdapter<String> {

    private int selectIndex = -1;

    public UpdateExecuteAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item, int position) {
        holder.setText(R.id.item_update_execute_name, item);
        holder.setVisible(R.id.item_update_execute_right, selectIndex == position ? true : false);
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
        notifyDataSetChanged();
    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.item_update_execute;
    }
}
