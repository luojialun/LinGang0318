package com.lingang.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleLabAdapter;
import com.lingang.bean.ChanYePopBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ChanyListAdapter2 extends RecycleLabAdapter<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> {
    private Context context;
    public ChanyListAdapter2(Context context, List<ChanYePopBean.DataBean.ListBean.IndustryLevelsBean> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ChanYePopBean.DataBean.ListBean.IndustryLevelsBean item, int position) {

        String levelTitle = item.getLevelTitle();
        if (!TextUtils.isEmpty(levelTitle)){
            holder.setText(R.id.tv_chanye2,levelTitle);
        }

        Drawable nav_up = null;
        TextView view = holder.getView(R.id.tv_chanye2);

        if (item.isSelect()) {
            nav_up = context.getResources().getDrawable(R.mipmap.ic_gouxuan_xiala);
            view.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            nav_up = context.getResources().getDrawable(R.drawable.tran_cri);
            view.setTextColor(context.getResources().getColor(R.color.black));
        }
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        view.setCompoundDrawables(null, null, nav_up, null);
    }


    @Override
    protected int getItemViewLayoutId(int position, ChanYePopBean.DataBean.ListBean.IndustryLevelsBean item) {
        return R.layout.itme_chanye2;
    }
}
