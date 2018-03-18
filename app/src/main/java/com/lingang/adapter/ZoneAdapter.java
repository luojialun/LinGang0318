package com.lingang.adapter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.activity.home.PropertyDettailsAc;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ParkDetailsBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ZoneAdapter extends RecycleLabAdapter<ParkDetailsBean.DataBean.BusinessBean> {
    private Context mContext;
    public ZoneAdapter(Context context, List<ParkDetailsBean.DataBean.BusinessBean> data) {
        super(context, data);
        mContext=context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ParkDetailsBean.DataBean.BusinessBean item, int position) {

        ImageView view = holder.getView(R.id.img_zone);
        GlideImgManager.glideLoader(view.getContext(),HttpApi.IMAGE_BASE_SERVER +item.getBusinessImgPath(),view);
        holder.setText(R.id.tv_zushou,item.getBusinessName());


    }


    @Override
    protected int getItemViewLayoutId(int position, ParkDetailsBean.DataBean.BusinessBean item) {
        return R.layout.itme_zone;
    }
}
