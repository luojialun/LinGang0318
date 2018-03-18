package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ContactsSeachBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.CircleImageView;

import java.util.List;

/**
 * Created by jason on 17/5/24.
 * 通信录-搜索adapter
 */
public class ContactsSearchAdapter extends RecycleBaseAdapter<ContactsSeachBean.DataBean> {

    private Context mContext;
    public ContactsSearchAdapter(Context context, List<ContactsSeachBean.DataBean> data) {
        super(context,data);
        mContext=context;
    }

    @Override
    protected void convert(BaseViewHolder holder, ContactsSeachBean.DataBean item, int position) {
        holder.setText(R.id.contacts_emp_name,item.getUserCHName());
        holder.setText(R.id.tv_job,item.getJobName());
        if (item.getJobInnerTel().equals("")){
            holder.setText(R.id.tv_phone,item.getUserMb());
        }else {
            holder.setText(R.id.tv_phone,item.getJobInnerTel()+"   "+item.getUserMb());
        }

        ImageView view = holder.getView(R.id.img_head);
        GlideImgManager.glideLoaderHead(mContext,item.getUserPhoto(),view);
    }

    @Override
    protected int getItemViewLayoutId(int position, ContactsSeachBean.DataBean item) {
        return R.layout.item_contacts_emp_details;
    }
}