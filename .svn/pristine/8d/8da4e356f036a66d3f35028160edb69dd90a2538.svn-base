package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.bean.ClusterBean;
import com.lingang.bean.ParkDetailsBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;

import java.util.ArrayList;
import java.util.List;

public class ChanyeTeamAdapter extends BaseAdapter {

    private final int width;
    private Context context;
    private LayoutInflater mInflater;
    private List<ParkDetailsBean.DataBean.StationsBean> data;

    public ChanyeTeamAdapter(Context context, List<ParkDetailsBean.DataBean.StationsBean> data) {
        this.context = context;
        this.data = data;
        width = (int) context.getResources().getDimension(R.dimen.margin_80);
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
            convertView = mInflater.inflate(R.layout.itme_team, null);
            holder.rv_team = (RecyclerView) convertView.findViewById(R.id.rv_team);
            holder.img_gs = (ImageView) convertView.findViewById(R.id.img_gs);
            holder.tv_gsName = (TextView) convertView.findViewById(R.id.tv_gsName);
            holder.tv_gsjj = (TextView) convertView.findViewById(R.id.tv_gsjj);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        GlideImgManager.glideLoaderSize(context, HttpApi.IMAGE_BASE_SERVER + data.get(position).getImgPath(),width, holder.img_gs);
        holder.tv_gsName.setText(data.get(position).getStationTitle());

        List<ParkDetailsBean.DataBean.StationsBean.Parks> parks = data.get(position).getParks();
        if (parks.size() > 0)
            holder.tv_gsjj.setText(parks.get(0).getParkName());

        List<ParkDetailsBean.DataBean.StationsBean.LabelsBeanX> labels = data.get(position).getLabels();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rv_team.setLayoutManager(linearLayoutManager);

        ParkTabAdapter listTabAdapter = new ParkTabAdapter(context, labels);
        holder.rv_team.setAdapter(listTabAdapter);

        return convertView;
    }

    private class Holder {
        RecyclerView rv_team;
        ImageView img_gs;
        TextView tv_gsName, tv_gsjj;
    }

}