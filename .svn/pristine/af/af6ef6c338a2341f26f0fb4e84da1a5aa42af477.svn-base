package com.lingang.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.EntryDetailsAc;
import com.lingang.activity.home.PolicyDetialesAc;
import com.lingang.activity.user.UserFavoritesAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PolicyListBean;
import com.lingang.common.Constants;
import com.lingang.dialog.FavoritesDialog;
import com.lingang.utils.AppUtils;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.SwipeMenuLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class FavoritesPolicyAdapter extends RecycleBaseAdapter<PolicyListBean.DataBean.ListBean> {
    private Context context;
    private boolean isSearch = false;
    private FavoritesDialog dialog;
    private boolean isFavorites = false;

    public FavoritesPolicyAdapter(Context context, List<PolicyListBean.DataBean.ListBean> data, boolean isFavorites) {
        super(context, data);
        this.context = context;
        dialog = new FavoritesDialog(context);
        this.isFavorites = isFavorites;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PolicyListBean.DataBean.ListBean item, int position) {

        holder.setText(R.id.tv_title_poli, item.getPolicyTitle());
        String createTime = item.getCreateTime();
        if (!TextUtils.isEmpty(createTime)) {
            holder.setText(R.id.tv_title_time, DateUtils.getTimes(createTime, "yyyy-MM-dd"));
        }
        holder.setText(R.id.tv_gvpop, item.getAuthorName());
        List<PolicyListBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();
        RecyclerView rv_clu = holder.getView(R.id.rv_lable);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        PolicyLableAdapter listTabAdapter = new PolicyLableAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);

        if (isSearch)
            holder.getView(R.id.tv_gvpop).setVisibility(View.GONE);
        else
            holder.getView(R.id.tv_gvpop).setVisibility(View.VISIBLE);


        //删除
        holder.setOnClickListener(R.id.cancel_favorites, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int collectId = AppUtils.ProcessDoubleString(item.getCollectId() != null ? item.getCollectId().toString() : App.Empty);
                dialog.show(collectId, new FavoritesDialog.DialogClickCallback() {
                    @Override
                    public void clickCallback(int selectType) {
                        mData.remove(item);
                        notifyDataSetChanged();
                        if (mData.size() == 0) {
                            ((UserFavoritesAc) context).handleFavoritesHttp();
                        }
                    }
                });
            }
        });

        holder.setOnClickListener(R.id.favorites_details_ll, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).startActivityForResult(new Intent(context, PolicyDetialesAc.class).putExtra("id", item.getPolicyId()), Constants.refreshCode);
            }
        });

        ((SwipeMenuLayout) holder.getView(R.id.swipeMenu_item)).setSwipeEnable(isFavorites);
    }

    /**
     * 是否是搜索页
     *
     * @param flag
     */
    public void setIsSearch(boolean flag) {
        isSearch = flag;
    }

    @Override
    protected int getItemViewLayoutId(int position, PolicyListBean.DataBean.ListBean item) {
        return R.layout.item_favorites_policy;
    }
}
