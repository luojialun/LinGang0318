package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.HomeModeBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.utils.ScreenSizeUtils;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class HomeGvAdapter extends BaseAdapter {

//    private final int itme_weight;
    private Context context;
    private LayoutInflater mInflater;
    private List<HomeModeBean> data;

    public HomeGvAdapter(Context context, List<HomeModeBean> data) {
        this.context = context;
        this.data = data;
//        ScreenSizeUtils instance = ScreenSizeUtils.getInstance(context);
//        itme_weight = (int) ((instance.getScreenWidth() - 3 * context.getResources().getDimension(R.dimen.margin_10)) / 4);

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
            convertView = mInflater.inflate(R.layout.itme_gv_home, null);
            holder.img_gv_home = (ImageView) convertView.findViewById(R.id.img_gv_home);
            holder.tv_gv_home = (TextView) convertView.findViewById(R.id.tv_gv_home);
//            ViewGroup.LayoutParams layoutParams = holder.img_gv_home.getLayoutParams();
//            layoutParams.height = itme_weight;
//            layoutParams.width = itme_weight;
//            holder.img_gv_home.setLayoutParams(layoutParams);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        HomeModeBean homeModeBean = data.get(position);
//        GlideImgManager.glideLoader(context,homeModeBean.getImg(),holder.img_gv_home);
        holder.img_gv_home.setImageResource(homeModeBean.getImg());
        holder.tv_gv_home.setText(homeModeBean.getTitle());

        return convertView;
    }

    private class Holder {
        ImageView img_gv_home;
        TextView tv_gv_home;
    }

}