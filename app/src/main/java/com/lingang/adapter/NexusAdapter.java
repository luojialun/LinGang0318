package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.NexusBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/8/14 0014 16:35
 * @change
 * @chang time
 * @class describe
 */
public class NexusAdapter extends RecycleBaseAdapter<NexusBean.DataMapBean.ListBean> {
    private List<NexusBean.DataMapBean.ListBean> data;
    public NexusAdapter(Context context, List<NexusBean.DataMapBean.ListBean> data) {
        super(context, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, NexusBean.DataMapBean.ListBean item, int position) {
        holder.setText(R.id.tv_nexus,item.getBasicsName());
        if (position == data.size() - 1){
            holder.setVisible(R.id.vv_nexuc,false);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, NexusBean.DataMapBean.ListBean item) {
        return R.layout.itme_nexus;
    }
}
