package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ParkUserListBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/8/17 0017 15:15
 * @change
 * @chang time
 * @class describe
 */
public class GroomDgAdapter extends RecycleBaseAdapter<ParkUserListBean>{
    private List<ParkUserListBean> data;
    public GroomDgAdapter(Context context, List<ParkUserListBean> data) {
        super(context, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, ParkUserListBean item, int position) {
        holder.setText(R.id.tv_groom,item.getParkName());
        if (data.size() - 1== position){
            holder.setVisible(R.id.groom_line,false);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, ParkUserListBean item) {
        return R.layout.itme_groom;
    }
}
