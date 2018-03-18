package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.TjTunityThreeBean;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class SelectYqAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<TjTunityThreeBean.DataMapBean.RecommendListBean> data;
    private CompoundButton.OnCheckedChangeListener changeListener;

    public SelectYqAdapter(Context context, List<TjTunityThreeBean.DataMapBean.RecommendListBean> data, CompoundButton.OnCheckedChangeListener changeListener) {
        this.context = context;
        this.data = data;
        this.changeListener = changeListener;
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
            convertView = mInflater.inflate(R.layout.itme_yuanqu, null);
            holder.cb_yuanq = (CheckBox) convertView.findViewById(R.id.cb_yuanq);
            holder.yq_content = (TextView) convertView.findViewById(R.id.yq_content);
            holder.vv_sele = (View) convertView.findViewById(R.id.vv_sele);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.cb_yuanq.setChecked(data.get(position).isChe());
        holder.cb_yuanq.setTag("yq|"+position);
        holder.cb_yuanq.setOnCheckedChangeListener(changeListener);
        holder.yq_content.setText(data.get(position).getParkName());
        if (position == data.size() - 1) {
            holder.vv_sele.setVisibility(View.GONE);
        }else {
            holder.vv_sele.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    private class Holder {
        CheckBox cb_yuanq;
        TextView yq_content;
        View vv_sele;
    }

}