package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.EntryDetailesBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.view.CircleImageView;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class LvEntryPerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<EntryDetailesBean.DataBean.User> data;

    public LvEntryPerAdapter(Context context, List<EntryDetailesBean.DataBean.User> data) {
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
            convertView = mInflater.inflate(R.layout.itme_entry_per, null);
            holder.img_per_entry = (CircleImageView) convertView.findViewById(R.id.img_per_entry);
            holder.tv_per_name = (TextView) convertView.findViewById(R.id.tv_per_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        GlideImgManager.glideLoaderHead(context, HttpApi.IMAGE_BASE_SERVER+data.get(position).getImgPath(),holder.img_per_entry);
        holder.tv_per_name.setText(data.get(position).getUserName());
        return convertView;
    }

    private class Holder {
        CircleImageView img_per_entry;
        TextView tv_per_name;
    }

}