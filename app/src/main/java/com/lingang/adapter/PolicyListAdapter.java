package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.PolicyListBean;
import com.lingang.bean.YuanQuBean;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class PolicyListAdapter extends RecycleBaseAdapter<PolicyListBean.DataBean.ListBean> {
    private Context context;
    private boolean isSearch = false;

    public PolicyListAdapter(Context context, List<PolicyListBean.DataBean.ListBean> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final PolicyListBean.DataBean.ListBean item, int position) {

        holder.setText(R.id.tv_title_poli, item.getPolicyTitle());
        String createTime = item.getCreateTime();
        if (!TextUtils.isEmpty(createTime)) {
            holder.setText(R.id.tv_title_time, DateUtils.getTimes(createTime, "yyyy-MM-dd"));
        } else {
            holder.setText(R.id.tv_title_time, "");
        }
        holder.setText(R.id.tv_gvpop, item.getAuthorName());

        List<PolicyListBean.DataBean.ListBean.LabelsBean> labels = item.getLabels();

        RecyclerView rv_clu = holder.getView(R.id.rv_lable);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_clu.setLayoutManager(linearLayoutManager);

        PolicyLableAdapter listTabAdapter = new PolicyLableAdapter(context, labels);
        rv_clu.setAdapter(listTabAdapter);

    }

    /**
     * 是否是搜索页
     *
     * @param flag
     */
    public void setIsSearch(boolean flag) {
        isSearch = flag;
    }

    @Override
    protected int getItemViewLayoutId(int position, PolicyListBean.DataBean.ListBean item) {
        return R.layout.itme_policy;
    }
}
