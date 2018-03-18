package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseListAdapter;
import com.lingang.bean.SearchHistory;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 搜索历史记录Adapter
 */

public class HomeSearchHistoryAdapter extends BaseListAdapter<SearchHistory> {
    public HomeSearchHistoryAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.item_home_search_history, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.searchHistoryText.setText(getItem(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.search_history_left_icon)
        ImageView searchHistoryLeftIcon;
        @BindView(R.id.search_history_text)
        TextView searchHistoryText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
