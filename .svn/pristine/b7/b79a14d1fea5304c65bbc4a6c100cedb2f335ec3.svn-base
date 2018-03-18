package com.lingang.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.IndustryDetailsBean;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class JiQunDetailAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<IndustryDetailsBean.DataBean.IndustryLevelsBean> data;
    private View.OnClickListener listener;

    public JiQunDetailAdapter(Context context, List<IndustryDetailsBean.DataBean.IndustryLevelsBean> data, View.OnClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.itme_two_zone, null);
            holder.tv_zone_lv = (TextView) convertView.findViewById(R.id.tv_zone_lv);
            holder.vv_ll = (View) convertView.findViewById(R.id.vv_ll);
            holder.tv_level = (TextView) convertView.findViewById(R.id.tv_level);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (position == 0) {
            holder.vv_ll.setVisibility(View.INVISIBLE);
        }
        holder.tv_zone_lv.setText(data.get(position).getLevelTitle());
        holder.tv_level.setText(data.get(position).getLevelContent());

        holder.tv_zone_lv.setOnClickListener(listener);
        holder.tv_zone_lv.setTag(position);

        if (data.get(position).isSelect()) {
            setDrawableLeft(holder.tv_zone_lv,R.mipmap.up);
            if (!TextUtils.isEmpty(data.get(position).getLevelContent()))
                holder.tv_level.setVisibility(View.VISIBLE);

        } else {
            setDrawableLeft(holder.tv_zone_lv,R.mipmap.pull);
            holder.tv_level.setVisibility(View.GONE);
        }
        return convertView;
    }

    private class Holder {
        TextView tv_zone_lv, tv_level;
        View vv_ll;
    }
    private void setDrawableLeft(TextView attention, int drawableId) {
        Drawable drawable = context.getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        attention.setCompoundDrawables(null, null, drawable, null);
    }
}