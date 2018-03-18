package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.bean.ClusterBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.DateUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.flowlayout.FlowLayout;
import com.lingang.view.flowlayout.TagAdapter;
import com.lingang.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ClusterAdapter extends RecycleBaseAdapter<ClusterBean.DataBean.ListBean> {
    public ClusterAdapter(Context context, List<ClusterBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ClusterBean.DataBean.ListBean item, int position) {


        holder.setText(R.id.tv_title_clu, item.getIndustryTitle());

        holder.setText(R.id.tv_num,item.getParkCount()+"个园区  "+item.getStationCount()+"家企业");

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();

        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(), view);
        List<ClusterBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();
        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        ListTabAdapter listTabAdapter = new ListTabAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);
    }


    @Override
    protected int getItemViewLayoutId(int position, ClusterBean.DataBean.ListBean item) {
        return R.layout.itme_cluster;
    }
}
