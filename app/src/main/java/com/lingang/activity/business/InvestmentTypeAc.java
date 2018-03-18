package com.lingang.activity.business;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.InvestmentAdapter;
import com.lingang.base.BaseAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.TypeBean;
import com.lingang.callback.RefreshListion;

import java.util.ArrayList;

import butterknife.BindView;

public class InvestmentTypeAc extends BaseAc implements RecycleBaseAdapter.OnItemClickListener,RefreshListion {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private ArrayList<TypeBean> typeBeen;
    private InvestmentAdapter investmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_investment_type);
        String tag = getIntent().getStringExtra("tag");
        if (tag.equals("type")) {
            setTitle("招商类型");
        } else {
            setTitle("选择园区");
        }
        setRightTv("确定");
        initView();
    }

    private void initView() {
        setRefreshHead(refresh);
        setRefreshViewLine(recyclerview, R.drawable.main_item_divider);
        setRecycleAspect(recyclerview);

        typeBeen = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TypeBean typeBean = new TypeBean();
            typeBean.setCheck(false);
            typeBeen.add(typeBean);
        }


        investmentAdapter = new InvestmentAdapter(this, typeBeen);
        investmentAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(investmentAdapter);

        setRefreshLison(refresh,this);
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        TypeBean typeBean = typeBeen.get(position);
        typeBean.setCheck(!typeBean.isCheck());
        int num = 0;
        for (int i = 0; i < typeBeen.size(); i++) {
            if (typeBeen.get(i).isCheck()) {
                num++;
            }
        }

        if (num == 0) {
            setRightTv("确定");
        } else {
            setRightTv("确定(" + num + ")");
        }
        investmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }
}
