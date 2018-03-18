package com.lingang.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.ChanYDetailesBean;
import com.lingang.bean.ParkDetailsBean;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class ChanyeDetailAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<ChanYDetailesBean> data;
    private int itmeNum = 6;

    public ChanyeDetailAdapter(Context context, List<ChanYDetailesBean> data) {
        this.context = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        if (data.size() < 6){
            itmeNum = data.size();
        }
        return itmeNum;
    }

    public void setItmeNum(int itmeNum){
        this.itmeNum = itmeNum;
        notifyDataSetChanged();
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
        final Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.itme_lv_zone, null);
            holder.tv_zone_lv = (TextView) convertView.findViewById(R.id.tv_zone_lv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv_zone_lv.setText(data.get(position).getTitle());
        return convertView;
    }

    private class Holder {
        TextView tv_zone_lv;
    }

}