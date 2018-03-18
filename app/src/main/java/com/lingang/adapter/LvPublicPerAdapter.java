package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.MatingDetailesBean;
import com.lingang.bean.PublicDetailsBean;
import com.lingang.bean.Users;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.view.CircleImageView;

import java.util.List;

public class LvPublicPerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<Users> data;

    public LvPublicPerAdapter(Context context, List<Users> data) {
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
            convertView = mInflater.inflate(R.layout.itme_zone_per, null);
            holder.img_per_entry = (ImageView) convertView.findViewById(R.id.img_zone);
            holder.tv_per_name = (TextView) convertView.findViewById(R.id.name_per);
            holder.vv_line = (View) convertView.findViewById(R.id.vv_line);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (position == 0) {
            holder.vv_line.setVisibility(View.INVISIBLE);
        }
        GlideImgManager.glideLoaderHead(context, HttpApi.IMAGE_BASE_SERVER + data.get(position).getImgPath(),holder.img_per_entry);
        holder.tv_per_name.setText(data.get(position).getUserName());
        return convertView;
    }

    private class Holder {
        ImageView img_per_entry;
        TextView tv_per_name;
        View vv_line;
    }
}