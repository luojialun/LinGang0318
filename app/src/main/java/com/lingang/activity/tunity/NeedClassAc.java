package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.adapter.NeedClassAdapter;
import com.lingang.base.BaseRecycleViewAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.NeedBean;
import com.lingang.common.Constants;

import java.util.ArrayList;

import butterknife.BindView;

public class NeedClassAc extends BaseRecycleViewAc implements RecycleBaseAdapter.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;

    private NeedClassAdapter needClassAdapter;
    private ArrayList<NeedBean> data;
//    private ArrayList<NeedBean> needData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_need_class);
        setTitle("需求类型");
        setRightTv("确定");

        refresh.setEnableRefresh(false);
        refresh.setEnableLoadmore(false);

        data = (ArrayList<NeedBean>) getIntent().getSerializableExtra("data");
//        needData = new ArrayList<>();
        setRecycleAspect(recyclerview);
        needClassAdapter = new NeedClassAdapter(this, data);
        needClassAdapter.setOnItemClickListener(this);
        recyclerview.setAdapter(needClassAdapter);
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        ArrayList<NeedBean> needBeen = new ArrayList<>();
        Intent intent = new Intent();
        for (NeedBean bean : data) {
            if (bean.isCheack()) {
                needBeen.add(bean);
            }
        }
        intent.putExtra("data", needBeen);
        setResult(Constants.Need, intent);
        finish();
    }

    @Override
    public void onItemClick(View view, Object item, int position) {
        data.get(position).setCheack(!data.get(position).isCheack());
        needClassAdapter.notifyDataSetChanged();

        int num = 0;
        for (NeedBean bean : data) {
            if (bean.isCheack()) {
                num++;
            }
        }

        if (num != 0) {
            setRightTv("确定" + "(" + num + ")");
        } else {
            setRightTv("确定");
        }

        //排序 选择的顺序 是动态添加view的顺序
//        int tag = 1;
//        for (int i = 0; i < needData.size(); i++) {
//            if (!needData.get(i).getContent().equals(needBean.getContent())) {
//                tag++;
//            } else {
//                if (needBean.isCheack()) {
//                    needData.remove(i);
//                }
//            }
//        }
//        if (tag == needData.size() || needData.size() == 0) {//说明之前是没有选择的
//            needData.add(needBean);
//        }
    }
}
