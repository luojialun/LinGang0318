package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BusinessBean;
import com.lingang.bean.ParkUserListBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class RvCenterTvAdapter extends RecycleBaseAdapter<ParkUserListBean> {


    public RvCenterTvAdapter(Context context, List<ParkUserListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ParkUserListBean item, int position) {
        TextView view = holder.getView(R.id.tv_rvcenter);
        View vv_line = holder.getView(R.id.vv_line);
        Context context = view.getContext();
        view.setText(item.getParkName());

        if (item.isCheack()) {
            view.setTextColor(context.getResources().getColor(R.color.red));
            vv_line.setBackgroundResource(R.color.red);
        } else {
            view.setTextColor(context.getResources().getColor(R.color.black));
            vv_line.setBackgroundResource(R.color.line);
        }
    }


    @Override
    protected int getItemViewLayoutId(int position, ParkUserListBean item) {
        return R.layout.itme_rvcenter;
    }
}
