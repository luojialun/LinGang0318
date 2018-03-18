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

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class LvEntryYuQuAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean> data;
    private int itmeNum = 6;

    public LvEntryYuQuAdapter(Context context, List<EntryDetailesBean.DataBean.IndustrysBean.IndustryLevelsBean> data) {
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
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.itme_entry, null);
            holder.tv_yauqu = (TextView) convertView.findViewById(R.id.tv_yauqu);
            holder.vv_line = (View) convertView.findViewById(R.id.vv_line);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (position == 0){
            holder.vv_line.setVisibility(View.INVISIBLE);
        }else {
            holder.vv_line.setVisibility(View.VISIBLE);
        }
        holder.tv_yauqu.setText(data.get(position).getLevelTitle());
        return convertView;
    }

    private class Holder {
        TextView tv_yauqu;
        View vv_line;
    }

}