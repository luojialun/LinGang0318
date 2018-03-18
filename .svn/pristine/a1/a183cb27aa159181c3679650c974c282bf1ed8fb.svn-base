package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.bean.HomeModeBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.view.CircleImageView;

import java.util.List;

/**
 * 主页-消息列表adapter
 */
public class HomeMsgLvAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<HomeModeBean> data;

    public HomeMsgLvAdapter(Context context, List<HomeModeBean> data) {
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
            convertView = mInflater.inflate(R.layout.itme_meg_home, null);
            holder.img_msg = (ImageView) convertView.findViewById(R.id.img_msg);
            holder.tv_title_msg = (TextView) convertView.findViewById(R.id.tv_title_msg);
            holder.tv_content_msg = (TextView) convertView.findViewById(R.id.tv_content_msg);
            holder.tv_red = (TextView) convertView.findViewById(R.id.tv_red);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        HomeModeBean homeModeBean = data.get(position);
        holder.img_msg.setImageResource(homeModeBean.getImg());
        holder.tv_title_msg.setText(homeModeBean.getTitle());
        holder.tv_content_msg.setText(homeModeBean.getName().replaceAll("@num", String.valueOf(homeModeBean.getCount())));

        if (homeModeBean.getCount() != App.IntNormal) {//显示图标右上角红色数字
//            holder.tv_red.setText(String.valueOf(homeModeBean.getCount()));
            holder.tv_red.setVisibility(View.VISIBLE);
        } else {
            holder.tv_red.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    private class Holder {
        ImageView img_msg;
        TextView tv_title_msg;
        TextView tv_content_msg, tv_red;
    }

}