package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.bean.PartnerBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PartnerAdapter extends RecycleBaseAdapter<PartnerBean.DataBean.ListBean> {
    public PartnerAdapter(Context context, List<PartnerBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PartnerBean.DataBean.ListBean item, int position) {


        holder.setText(R.id.tv_title_clu, item.getPartnerName());

        holder.setText(R.id.tv_num,item.getTypeName());

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();

        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(), view);
        List<PartnerBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        PartnerTabAdapter listTabAdapter = new PartnerTabAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);
    }


    @Override
    protected int getItemViewLayoutId(int position, PartnerBean.DataBean.ListBean item) {
        return R.layout.itme_cluster;
    }
}
