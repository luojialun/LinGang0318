package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.NewsDetailsBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.ArrayList;

/**
 * 全局搜索adapter
 */
public class HomeSearchNewsListAdapter extends RecycleBaseAdapter<NewsDetailsBean.DataBean> {
    private ArrayList<NewsDetailsBean.DataBean> newsList;
    private Context mContext;
    public HomeSearchNewsListAdapter(Context context,  ArrayList<NewsDetailsBean.DataBean> data) {
        super(context, data);
        mContext=context;
        this.newsList = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsDetailsBean.DataBean item, int position) {
        holder.setText(R.id.home_news_list_item_title_tv,item.getNewsTitle());
        if(!TextUtils.isEmpty(item.getCreateTime())) {
            holder.setText(R.id.home_news_list_item_time_tv, DateUtils.getTimestamp(Long.parseLong(item.getCreateTime()), "yyyy-MM-dd"));
        }
        holder.setText(R.id.home_news_list_item_company_tv,item.getAuthorName());
        if (!TextUtils.isEmpty(item.getImgPath())) {
            //新闻带图片
            ImageView photoIv=holder.getView(R.id.home_news_list_item_iv);
            //加载图片
            GlideImgManager.glideLoaderNormal(mContext,HttpApi.IMAGE_BASE_SERVER + item.getImgPath(),photoIv);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, NewsDetailsBean.DataBean item) {
        if (TextUtils.isEmpty(item.getImgPath())) {
            return R.layout.item_home_news_list_no_image;
        } else {
            return R.layout.item_home_news_list;
        }
    }
}
