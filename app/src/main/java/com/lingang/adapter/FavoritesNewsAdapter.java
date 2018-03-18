package com.lingang.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.EntryDetailsAc;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.activity.user.UserFavoritesAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.bean.BusinessBean;
import com.lingang.dialog.FavoritesDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.AppUtils;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.SwipeMenuLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class FavoritesNewsAdapter extends RecycleBaseAdapter<BannerBean.DataBean.ListBean> {
    private FavoritesDialog dialog;
    private Context mContext;
    private List<BannerBean.DataBean.ListBean> mList;
    private boolean isFavorites=false;
    public FavoritesNewsAdapter(Context context, List<BannerBean.DataBean.ListBean> data,boolean isFavorites) {
        super(context, data);
        dialog=new FavoritesDialog(context);
        mContext=context;
        mList=data;
        this.isFavorites=isFavorites;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final BannerBean.DataBean.ListBean item, int position) {

        holder.setText(R.id.tv_title_news, item.getNewsTitle());
        String timestamp = DateUtils.getTimestamp(item.getCreateTime(),"yyyy-MM-dd");
        holder.setText(R.id.tv_data_news, String.valueOf(item.getAuthorName()));
        holder.setText(R.id.tv_data_date, timestamp);

        ImageView view = holder.getView(R.id.img_news);
        TextView titleTv = holder.getView(R.id.tv_title_news);
        if (null != view) {
            if (TextUtils.isEmpty(item.getImgPath())) {
                view.setVisibility(View.GONE);
                titleTv.setMaxLines(3);
            } else {
                view.setVisibility(View.VISIBLE);
                titleTv.setMaxLines(2);
                GlideImgManager.glideLoaderNormal(mContext, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(), view);
            }
        }
        //删除
        holder.setOnClickListener(R.id.cancel_favorites, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int collectId= AppUtils.ProcessDoubleString(item.getCollectId());
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
                NewsDetailsAc.goToNewsDetailsAc(mContext, item.getNewsId());
            }
        });
        ((SwipeMenuLayout)holder.getView(R.id.swipeMenu_item)).setSwipeEnable(isFavorites);
    }


    @Override
    protected int getItemViewLayoutId(int position, BannerBean.DataBean.ListBean item) {
        return R.layout.item_favorites_news;
    }
}
