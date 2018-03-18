package com.lingang.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ChanYePopBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ChanyListAdapter1 extends RecycleLabAdapter<ChanYePopBean.DataBean.ListBean> {
    public ChanyListAdapter1(Context context, List<ChanYePopBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ChanYePopBean.DataBean.ListBean item, int position) {

        TextView view = holder.getView(R.id.tv_chanye1);
        Context context = view.getContext();
        view.setText(item.getIndustryTitle());
        if (item.isSelect()){
            view.setBackgroundResource(R.color.white);
        }else {
            view.setBackgroundResource(R.color.transparent);
        }
        Drawable nav_up = null;
        if (item.isPoint()){
            nav_up=context.getResources().getDrawable(R.mipmap.ic_xuanzhong);
        }else {
            nav_up=context.getResources().getDrawable(R.drawable.tran_cri);
        }
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        view.setCompoundDrawables(nav_up, null, null, null);
    }


    @Override
    protected int getItemViewLayoutId(int position, ChanYePopBean.DataBean.ListBean item) {
        return R.layout.itme_chanye1;
    }
}
