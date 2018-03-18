package com.lingang.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.EntryDetailesBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class EntryZoneAdapter extends RecycleLabAdapter<EntryDetailesBean.DataBean.ParksvoBean> {
    public EntryZoneAdapter(Context context, List<EntryDetailesBean.DataBean.ParksvoBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final EntryDetailesBean.DataBean.ParksvoBean item, int position) {

        ImageView view = holder.getView(R.id.img_zone);
        GlideImgManager.glideLoader(view.getContext(),HttpApi.IMAGE_BASE_SERVER +item.getParkImgPath(),view);
        holder.setText(R.id.tv_zushou,item.getParkName());
    }


    @Override
    protected int getItemViewLayoutId(int position, EntryDetailesBean.DataBean.ParksvoBean item) {
        return R.layout.itme_zone;
    }
}
