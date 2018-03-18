package com.lingang.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.RankingBean;
import com.lingang.view.CircleImageView;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class HomeLvAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<RankingBean> data;

    public HomeLvAdapter(Context context, List<RankingBean> data) {
        this.context = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public RankingBean getItem(int position) {
        return this.data.get(position);
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
            convertView = mInflater.inflate(R.layout.itme_lv_home, parent, false);
            holder.tv_ranking_name = (TextView) convertView.findViewById(R.id.tv_ranking_name);
            holder.tv_level = (TextView) convertView.findViewById(R.id.tv_level);
            //holder.img_head = (CircleImageView) convertView.findViewById(R.id.img_head);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_integration = (TextView) convertView.findViewById(R.id.tv_integration);
            //holder.tv_branch = (TextView) convertView.findViewById(R.id.tv_branch);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        RankingBean rankingBean=data.get(position);
        if(rankingBean!=null) {
//            Drawable drawable =  this.context.getResources().getDrawable(rankingBean.getCircleImg());
//            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//            holder.tv_ranking_name.setCompoundDrawables(drawable, null, null, null);

            holder.tv_ranking_name.setText(rankingBean.getRankingName());
            holder.tv_level.setText(rankingBean.getLevel());
            //holder.img_head.setImageResource(rankingBean.getHead());
            holder.tv_name.setText(rankingBean.getName());
            holder.tv_integration.setText(rankingBean.getIntegration());
            //holder.tv_branch.setText(rankingBean.getBranch());
        }
        return convertView;
    }

    private class Holder{
        TextView tv_ranking_name;
        TextView tv_level;
        TextView tv_name;
        TextView tv_integration;
        //TextView tv_branch;
        //CircleImageView img_head;
    }

}