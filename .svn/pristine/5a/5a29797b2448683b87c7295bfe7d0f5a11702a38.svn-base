package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.ParkAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.callback.RefreshListion;

import java.util.ArrayList;

import butterknife.BindView;

public class ParkAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener,RefreshListion {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_park);

        setTitle("所属园区");
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            strings.add("");
        }

        ParkAdapter parkAdapter = new ParkAdapter(this, strings);
        parkAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(parkAdapter);

        setRefreshHead(refresh);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);

        setRefreshLison(refresh,this);
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        startActivity(new Intent(this,SelectPersonAc.class));
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }
}
