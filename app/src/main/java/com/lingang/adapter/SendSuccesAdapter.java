package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/8/17 0017 17:35
 * @change
 * @chang time
 * @class describe
 */
public class SendSuccesAdapter extends RecycleLabAdapter<TjTunityThreeBean.DataMapBean.ParkListBean> {
    public SendSuccesAdapter(Context context, List<TjTunityThreeBean.DataMapBean.ParkListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, TjTunityThreeBean.DataMapBean.ParkListBean item, int position) {
        holder.setText(R.id.tv_pack_suc,item.getParkName());
    }

    @Override
    protected int getItemViewLayoutId(int position, TjTunityThreeBean.DataMapBean.ParkListBean item) {
        return R.layout.itme_park;
    }
}
