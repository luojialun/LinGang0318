package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.KanbanOppoBean;
import com.lingang.bean.ShowStateEnum;
import com.lingang.common.Constants;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.vector.update_app.utils.DrawableUtil;

import java.util.List;

/**
 * Created by luojialun on 2017/9/4.
 */

public class KanbanOppoAdapter extends RecycleBaseAdapter<KanbanOppoBean.KanBan> {
    private Context context;

    public KanbanOppoAdapter(Context context, List<KanbanOppoBean.KanBan> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final KanbanOppoBean.KanBan item, int position) {
        if(!TextUtils.isEmpty(item.getCustomerEnterpriseName())) {
            holder.setText(R.id.claim_team, item.getCustomerEnterpriseName());
        }else{
            holder.setText(R.id.claim_team, "未注册企业");
        }
        TextView stateTv = holder.getView(R.id.state_btn);
        String state = item.getShowState();
        //商机状态
        if (!TextUtils.isEmpty(state)) {
            ShowStateEnum showStateEnum = Constants.oppoState.get(Integer.parseInt(state));
            if (state != null) {
                stateTv.setText(showStateEnum.getState());
                DrawableUtil.setTextSolidTheme(stateTv, 6, 30, context.getResources().getColor(showStateEnum.getColor()));
            }
        }

        TextView SourceTv = holder.getView(R.id.execute_type);
        SourceTv.setText(item.getOpportunityLevel() + "类");
        DrawableUtil.setTextSolidTheme(SourceTv, context.getResources().getColor(R.color.c_7eb2ec));

        holder.setText(R.id.claim_name, item.getRecommendUserName());
        holder.setText(R.id.tv_time_claim, item.getCustomerName());

        StringBuilder sb = new StringBuilder();
        if ("1".equals(item.getHaveWorkshop())) {
            sb.append("厂房/");
        }
        if ("1".equals(item.getHaveOffice())) {
            sb.append("研发办公/");
        }
        if ("1".equals(item.getHaveLand())) {
            sb.append("土地/");
        }
        if ("1".equals(item.getHaveEnterpriseType())) {
            sb.append("注册型企业/");
        }
        if (sb.length() > 0) {
            holder.setText(R.id.need_tv, sb.substring(0, sb.length() - 1).toString());
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, KanbanOppoBean.KanBan item) {
        return R.layout.itme_my_execute;
    }
}
