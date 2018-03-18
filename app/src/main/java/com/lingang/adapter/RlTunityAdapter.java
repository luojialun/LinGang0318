package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.RlTunityBean;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class RlTunityAdapter extends RecycleBaseAdapter<RlTunityBean.DataBean.ListBean> {
    private final int screenWidth;
    private Context context;

    public RlTunityAdapter(Context context, List<RlTunityBean.DataBean.ListBean> data) {
        super(context, data);
        this.context = context;
        screenWidth = ScreenSizeUtils.getInstance(context).getScreenWidth();
    }

    @Override
    protected void convert(final BaseViewHolder holder, final RlTunityBean.DataBean.ListBean item, int position) {

        String customerEnterpriseName = item.getCustomerEnterpriseName();
        holder.setText(R.id.tv_conname, TextUtils.isEmpty(customerEnterpriseName) ? "未注册企业" : customerEnterpriseName);
        holder.setText(R.id.tv_perclass, item.getOpportunityLevel() + "类");
        holder.setText(R.id.tv_pername, item.getRecommendUserName());

        if (item.getShowState().equals("9")) {
            holder.setImageResource(R.id.tunity_state, R.mipmap.ic_tuihui);
            holder.setVisible(R.id.tunity_state, true);
        } else if (item.getShowState().equals("2")) {
            holder.setVisible(R.id.tunity_state, true);
            holder.setImageResource(R.id.tunity_state, R.mipmap.yiyuqi);
        } else {
            holder.setVisible(R.id.tunity_state, false);
        }

        holder.setVisible(R.id.ll_plan, false);
        holder.setVisible(R.id.ll_work, false);
        holder.setVisible(R.id.ll_land, false);
        holder.setVisible(R.id.ll_zhuc, false);

        List<RlTunityBean.DataBean.ListBean.NeedTypeBean> needType = item.getNeedType();

        for (RlTunityBean.DataBean.ListBean.NeedTypeBean needTypeBean : needType) {
            List<String> typeList =new ArrayList<>();
            typeList.clear();
            typeList.addAll(needTypeBean.getTypeList());
            Collections.reverse(typeList);

            switch (needTypeBean.getTypeName()) {
                case "厂房":
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder.setVisible(R.id.ll_plan, true);
                    RecyclerView rv_plan = holder.getView(R.id.rv_plan);

                    setTagWidth(rv_plan, typeList);

                    rv_plan.setLayoutManager(linearLayoutManager);
                    rv_plan.setAdapter(new RlTunityTabAdapter(context, typeList));

                    break;
                case "研发办公":
                    LinearLayoutManager workLayoutManager = new LinearLayoutManager(context);
                    workLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder.setVisible(R.id.ll_work, true);
                    RecyclerView rv_work = holder.getView(R.id.rv_work);

                    setTagWidth(rv_work, typeList);

                    rv_work.setLayoutManager(workLayoutManager);
                    rv_work.setAdapter(new RlTunityTabAdapter(context, typeList));
                    break;
                case "土地":
                    LinearLayoutManager landLayoutManager = new LinearLayoutManager(context);
                    landLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder.setVisible(R.id.ll_land, true);
                    RecyclerView rv_land = holder.getView(R.id.rv_land);

                    setTagWidth(rv_land, typeList);

                    rv_land.setLayoutManager(landLayoutManager);
                    rv_land.setAdapter(new RlTunityTabAdapter(context, typeList));

                    break;
                default://注册型企业企业类型
                    LinearLayoutManager zhucLayoutManager = new LinearLayoutManager(context);
                    zhucLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    holder.setVisible(R.id.ll_zhuc, true);
                    RecyclerView rv_zhuc = holder.getView(R.id.rv_zhuc);

                    setTagWidth(rv_zhuc, typeList);

                    rv_zhuc.setLayoutManager(zhucLayoutManager);
                    rv_zhuc.setAdapter(new RlTunityTabAdapter(context, typeList));

                    break;
            }
        }
    }

    private void setTagWidth(RecyclerView rv_plan, List<String> typeList) {
        int tagNum = 0;
        for (String tag : typeList) {
            tagNum += tag.length();
        }
        if (tagNum > 16) {
            ViewGroup.LayoutParams layoutParams = rv_plan.getLayoutParams();
            layoutParams.width = screenWidth / 3 * 2;
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            rv_plan.setLayoutParams(layoutParams);
        }
    }


    @Override
    protected int getItemViewLayoutId(int position, RlTunityBean.DataBean.ListBean item) {
        return R.layout.itme_rltunity;
    }
}
