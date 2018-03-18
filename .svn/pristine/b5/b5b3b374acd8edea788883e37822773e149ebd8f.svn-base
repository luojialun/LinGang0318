package com.lingang.adapter;

import android.content.Context;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.VersionBean;
import com.lingang.utils.DateHelper;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2017/9/25.
 */

public class VersionListAdapter extends RecycleBaseAdapter<VersionBean.DataBean> {


    public VersionListAdapter(Context context, List<VersionBean.DataBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, VersionBean.DataBean item, int position) {
        holder.setText(R.id.title_tv, "i-Lingang APP " + item.getVersionId() + " 版本主要更新");
        holder.setText(R.id.time_tv, DateHelper.getDay(item.getUpdateTime(), "yyyy年MM月dd日"));
    }

    @Override
    protected int getItemViewLayoutId(int position, VersionBean.DataBean item) {
        return R.layout.item_version_list;
    }
}
