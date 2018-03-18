package com.lingang.adapter;

import android.content.Context;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.GroupConnectionBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by jason on 17/5/24.
 * 通信录-公司adapter
 */
public class ContactsCpAdapter extends RecycleBaseAdapter<GroupConnectionBean.DataBean > {

    private Context mContext;
    public ContactsCpAdapter(Context context,List<GroupConnectionBean.DataBean> data) {
        super(context,data);
        mContext=context;
    }

    @Override
    protected void convert(BaseViewHolder holder, GroupConnectionBean.DataBean item, int position) {

        holder.setText(R.id.contacts_dep_name,item.getGroupName());
    }

    @Override
    protected int getItemViewLayoutId(int position, GroupConnectionBean.DataBean item) {
        return R.layout.item_contacts_dep;
    }
}
