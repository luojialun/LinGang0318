package com.lingang.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;
import java.util.Random;


/**
 * Created by jason on 17/5/24.
 * 排行榜
 */
public class RankingAdapter extends RecycleBaseAdapter<BannerBean.DataBean.ListBean> {

    private List<BannerBean.DataBean> mData;
    private Context mContext;
    public RankingAdapter(Context context, List<BannerBean.DataBean.ListBean> data) {
        super(context, data);
        mContext=context;
    }

    @Override
    protected void convert(BaseViewHolder holder, BannerBean.DataBean.ListBean item, int position) {
        holder.setText(R.id.ranking_name_tv,"翻翻"+position);
        holder.setText(R.id.ranking_score_lv,String.valueOf(new Random().nextInt(100)));

        TextView levelTxt=holder.getView(R.id.ranking_level_tv);
        Drawable drawable=null;
        switch (position)
        {
            case 0:
                drawable=mContext.getResources().getDrawable(R.mipmap.one);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                levelTxt.setCompoundDrawables(drawable,null,null,null);
                break;
            case 1:
                drawable=mContext.getResources().getDrawable(R.mipmap.two);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                levelTxt.setCompoundDrawables(drawable,null,null,null);
                break;
            case 2:
                drawable=mContext.getResources().getDrawable(R.mipmap.three);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                levelTxt.setCompoundDrawables(drawable,null,null,null);
                break;
            default:
                levelTxt.setText(String.valueOf(position+1));
                break;
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, BannerBean.DataBean.ListBean item) {
        return R.layout.item_ranking;
    }
    private void processImage(BaseViewHolder holder,int position)
    {

    }
}
