package com.lingang.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.EntryDetailsAc;
import com.lingang.activity.home.PublicDetailsAc;
import com.lingang.activity.user.UserFavoritesAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PublicBean;
import com.lingang.common.Constants;
import com.lingang.dialog.FavoritesDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.AppUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.SwipeMenuLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class FavoritesPublicAdapter extends RecycleBaseAdapter<PublicBean.DataBean.ListBean> {
    private FavoritesDialog dialog;
    private Context mContext;
    private boolean isFavorites=false;
    public FavoritesPublicAdapter(Context context, List<PublicBean.DataBean.ListBean> data,boolean isFavorites) {
        super(context, data);
        mContext=context;
        dialog=new FavoritesDialog(context);
        this.isFavorites=isFavorites;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PublicBean.DataBean.ListBean item, int position) {
        holder.setText(R.id.tv_title_clu, item.getPublicTitle());
        holder.setText(R.id.tv_num,item.getPublicSimple());

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();

        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(),view );
        List<PublicBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        PublicTabAdapter listTabAdapter = new PublicTabAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);

        //删除
        holder.setOnClickListener(R.id.cancel_favorites, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int collectId= AppUtils.ProcessDoubleString(item.getCollectId()!=null?item.getCollectId().toString():App.Empty);
                dialog.show(collectId, new FavoritesDialog.DialogClickCallback() {
                    @Override
                    public void clickCallback(int selectType) {
                        mData.remove(item);
                        notifyDataSetChanged();
                        if(mData.size()==0)
                        {
                            ((UserFavoritesAc)mContext).handleFavoritesHttp();
                        }
                    }
                });
            }
        });

        holder.setOnClickListener(R.id.favorites_details_ll, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).startActivityForResult(new Intent(mContext, PublicDetailsAc.class).putExtra("id", item.getPublicId()), Constants.refreshCode);
            }
        });

        ((SwipeMenuLayout)holder.getView(R.id.swipeMenu_item)).setSwipeEnable(isFavorites);
    }


    @Override
    protected int getItemViewLayoutId(int position, PublicBean.DataBean.ListBean item) {
        return R.layout.item_favorites_public;
    }
}