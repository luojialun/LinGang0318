package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.YuanQuBean;
import com.lingang.bean.ZoneBean;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class GvChanYAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<ZoneBean.DataBean.ListBean> data;

    public GvChanYAdapter(Context context, List<ZoneBean.DataBean.ListBean> data) {
        this.context = context;
        this.data = data;
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
            convertView = mInflater.inflate(R.layout.itme_gvpop, null);
            holder.tv_gvpop = (TextView) convertView.findViewById(R.id.tv_gvpop);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv_gvpop.setText(data.get(position).getIndustrySimple());
        if (data.get(position).isSelect()) {
            holder.tv_gvpop.setBackgroundResource(R.drawable.grenn_rect_sele);
            holder.tv_gvpop.setTextColor(context.getResources().getColor(R.color.tv_flow_color));
        } else {
            holder.tv_gvpop.setBackgroundResource(R.drawable.grenn_rect);
            holder.tv_gvpop.setTextColor(context.getResources().getColor(R.color.black));
        }
        return convertView;
    }

    private class Holder {
        TextView tv_gvpop;
    }

}