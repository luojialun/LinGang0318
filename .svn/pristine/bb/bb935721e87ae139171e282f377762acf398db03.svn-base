package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.NeedBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/8/15 0015 10:49
 * @change
 * @chang time
 * @class describe
 */
public class NeedClassAdapter extends RecycleBaseAdapter<NeedBean>{
    private List<NeedBean> data;
    public NeedClassAdapter(Context context, List<NeedBean> data) {
        super(context, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, NeedBean item, int position) {
        holder.setText(R.id.tv_need,item.getContent());
        ImageView view = holder.getView(R.id.img_gou);
        if (item.isCheack()){
            view.setVisibility(View.VISIBLE);
            view.setImageResource(R.mipmap.ic_gouxuan_xiala);
        }else {
            view.setVisibility(View.INVISIBLE);
        }
        if (position == data.size() - 1){
            holder.setVisible(R.id.vv_need,false);
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, NeedBean item) {
        return R.layout.itme_need;
    }
}
