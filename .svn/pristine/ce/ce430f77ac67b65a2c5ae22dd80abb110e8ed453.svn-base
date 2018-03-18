package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */
public class NewsAdapter extends RecycleBaseAdapter<BannerBean.DataBean.ListBean> {

    public NewsAdapter(Context context, List<BannerBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final BannerBean.DataBean.ListBean item, int position) {

        holder.setText(R.id.tv_title_news, item.getNewsTitle());
        String timestamp = DateUtils.getTimestamp(item.getCreateTime(), "yyyy-MM-dd");
        holder.setText(R.id.tv_data_news, TextUtils.isEmpty(item.getAuthorName()) ? App.Empty : item.getAuthorName());
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
    }


    @Override
    protected int getItemViewLayoutId(int position, BannerBean.DataBean.ListBean item) {
        return R.layout.item_news;
    }
}
