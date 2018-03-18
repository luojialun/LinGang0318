package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class YuanQuAdapter extends RecycleBaseAdapter<YuanQuBean.DataBean.ListBean> {
    public YuanQuAdapter(Context context, List<YuanQuBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final YuanQuBean.DataBean.ListBean item, int position) {
        holder.setText(R.id.tv_title_clu, item.getParkName());

        holder.setText(R.id.tv_num,item.getRegionName());

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();
        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(), view);
        List<YuanQuBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        YuanQuTabAdapter listTabAdapter = new YuanQuTabAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);
    }


    @Override
    protected int getItemViewLayoutId(int position, YuanQuBean.DataBean.ListBean item) {
        return R.layout.itme_cluster;
    }
}
