package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lingang.R;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class LvClaimJiluAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<String> data;

    public LvClaimJiluAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
//        return data.size();
        return 2;
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
            convertView = mInflater.inflate(R.layout.itme_explain, null);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
//        GlideImgManager.glideLoader(context,homeModeBean.getImg(),holder.img_msg);
//        holder.img.setImageResource(homeModeBean.getImg());
        return convertView;
    }

    private class Holder {
        ImageView img;
    }

}