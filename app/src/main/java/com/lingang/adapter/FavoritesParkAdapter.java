package com.lingang.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.activity.user.UserFavoritesAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.MessagePageListBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.dialog.FavoritesDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.SwipeMenuLayout;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/4/1 d0001.
 *
 */

public class FavoritesParkAdapter extends RecycleBaseAdapter<YuanQuBean.DataBean.ListBean> {
    private FavoritesDialog dialog;
    private DialogTwoCall dialogTwo;
    private Context mContext;
    private List<YuanQuBean.DataBean.ListBean> mList;
    private boolean isFavorites=false;


    public FavoritesParkAdapter(Context context, List<YuanQuBean.DataBean.ListBean> data,boolean isFavorites) {
        super(context, data);
        dialog=new FavoritesDialog(context);
        mContext=context;
        mList=data;
        this.isFavorites=isFavorites;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final YuanQuBean.DataBean.ListBean item, int position) {
        holder.setText(R.id.tv_title_clu, item.getParkName());
        holder.setText(R.id.tv_num,item.getRegionName());

        ImageView view = holder.getView(R.id.img_clu);
        Context context = view.getContext();
        GlideImgManager.glideLoaderNormal(context, HttpApi.IMAGE_BASE_SERVER + item.getImgPath(),view );
        List<YuanQuBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_clu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        YuanQuTabAdapter listTabAdapter = new YuanQuTabAdapter(context, labels);
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
                ((Activity)mContext).startActivityForResult(new Intent(mContext, ChanYeDetailsAc.class).putExtra("id", item.getParkId()),Constants.refreshCode);
            }
        });

        ((SwipeMenuLayout)holder.getView(R.id.swipeMenu_item)).setSwipeEnable(isFavorites);
    }
    @Override
    protected int getItemViewLayoutId(int position, YuanQuBean.DataBean.ListBean item) {
        return R.layout.item_user_favorites;
    }
}