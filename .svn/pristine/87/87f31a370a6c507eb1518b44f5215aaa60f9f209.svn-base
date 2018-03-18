package com.lingang.activity.business;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.SelectPerAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.TypeBean;
import com.lingang.callback.RefreshListion;

import java.util.ArrayList;

import butterknife.BindView;

public class SelectPersonAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener,RefreshListion{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private SelectPerAdapter selectPerAdapter;
    private ArrayList<TypeBean> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_select_person);
        setTitle("选择招商人员");
        initView();
    }

    private void initView() {
        setRefreshHead(refresh);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);

        strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            TypeBean typeBean = new TypeBean();
            typeBean.setCheck(false);
            strings.add(typeBean);
        }


        selectPerAdapter = new SelectPerAdapter(this, strings);
        recyclerview.setAdapter(selectPerAdapter);
        selectPerAdapter.setOnItemClickListener(this);

        setRefreshLison(refresh,this);
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        TypeBean typeBean = strings.get(position);
        typeBean.setCheck(!typeBean.isCheck());
        selectPerAdapter.notifyDataSetChanged();
    }

    //下拉刷新
    @Override
    public void refresh() {

    }

    //加载更多
    @Override
    public void loadMore() {

    }
}
