package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BusinessBean;
import com.lingang.bean.PicListBean;
import com.lingang.bean.PolicyListBean;
import com.lingang.glide.GlideImageLoader;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PicAdapter extends RecycleBaseAdapter<PicListBean.DataBean > {
    private Context context;
    public PicAdapter(Context context, List<PicListBean.DataBean > data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PicListBean.DataBean  item, int position) {

        ImageView view = holder.getView(R.id.img_pic);
        GlideImgManager.glideLoader(view.getContext(),HttpApi.IMAGE_BASE_SERVER+item.getPicPath(),view);


    }


    @Override
    protected int getItemViewLayoutId(int position, PicListBean.DataBean  item) {
        return R.layout.itme_pic;
    }
}
