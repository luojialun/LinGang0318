package com.lingang.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.IndustryDetailsBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class JiqunZoneAdapter extends RecycleLabAdapter<IndustryDetailsBean.DataBean.ParksBean> {
    public JiqunZoneAdapter(Context context, List<IndustryDetailsBean.DataBean.ParksBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final IndustryDetailsBean.DataBean.ParksBean item, int position) {

        ImageView view = holder.getView(R.id.img_zone);
        GlideImgManager.glideLoader(view.getContext(),HttpApi.IMAGE_BASE_SERVER +item.getParkImgPath(),view);
        holder.setText(R.id.tv_zushou,item.getParkName());
    }


    @Override
    protected int getItemViewLayoutId(int position, IndustryDetailsBean.DataBean.ParksBean item) {
        return R.layout.itme_zone;
    }
}
