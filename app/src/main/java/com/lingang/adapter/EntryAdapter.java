package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.EntryBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class EntryAdapter extends RecycleBaseAdapter<EntryBean.DataBean.ListBean> {
    public EntryAdapter(Context context, List<EntryBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final EntryBean.DataBean.ListBean item, int position) {


        holder.setText(R.id.tv_title_clu, item.getStationTitle());
        List<EntryBean.DataBean.ListBean.ParksBean> parks = item.getParks();
        if (parks != null && parks.size() > 0) {
            String yuanq = "";
            for (int i = 0; i < parks.size(); i++) {
                if (TextUtils.isEmpty(yuanq)) {
                    yuanq = parks.get(i).getParkName();
                } else {
                    yuanq = yuanq + "、" + parks.get(i).getParkName();
                }
            }
            holder.setText(R.id.tv_num, yuanq);
        }else {
            holder.setText(R.id.tv_num, "");
        }

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();
        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(), view);

        List<EntryBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        EntryTabAdapter listTabAdapter = new EntryTabAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);
    }


    @Override
    protected int getItemViewLayoutId(int position, EntryBean.DataBean.ListBean item) {
        return R.layout.itme_cluster;
    }
}
