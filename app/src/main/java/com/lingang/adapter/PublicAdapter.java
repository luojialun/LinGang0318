package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PublicBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.dialog.FavoritesDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PublicAdapter extends RecycleBaseAdapter<PublicBean.DataBean.ListBean> {
    private FavoritesDialog dialog;
    public PublicAdapter(Context context, List<PublicBean.DataBean.ListBean> data) {
        super(context, data);
        dialog=new FavoritesDialog(context);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PublicBean.DataBean.ListBean item, int position) {


        holder.setText(R.id.tv_title_clu, item.getPublicTitle());

        holder.setText(R.id.tv_num,item.getPublicSimple());

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();
        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(), view);

        List<PublicBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        PublicTabAdapter listTabAdapter = new PublicTabAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);
    }


    @Override
    protected int getItemViewLayoutId(int position, PublicBean.DataBean.ListBean item) {
        return R.layout.itme_cluster;
    }
}
