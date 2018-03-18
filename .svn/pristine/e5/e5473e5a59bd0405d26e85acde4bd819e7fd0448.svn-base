package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.RecommandBean;
import com.lingang.bean.ShowStateEnum;
import com.lingang.common.Constants;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.vector.update_app.utils.DrawableUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class MyClaimAdapter extends RecycleBaseAdapter<RecommandBean.Recommand> {

    private Context context;

    public MyClaimAdapter(Context context, List<RecommandBean.Recommand> data) {
        super(context, data);
        this.context = context;

    }

    @Override
    protected void convert(final BaseViewHolder holder, final RecommandBean.Recommand item, int position) {
        if (TextUtils.isEmpty(item.getCustomerEnterpriseName())) {
            holder.setText(R.id.claim_team, "未注册企业");
        } else {
            holder.setText(R.id.claim_team, item.getCustomerEnterpriseName());
        }
        String state = item.getShowState();
        TextView stateTv = holder.getView(R.id.state_tv);
        if (!TextUtils.isEmpty(state)) {
            ShowStateEnum showStateEnum = Constants.recShowState.get(Integer.parseInt(state));
            if (state != null) {
                stateTv.setText(showStateEnum.getState());
                DrawableUtil.setTextSolidTheme(stateTv, 6, 30, context.getResources().getColor(showStateEnum.getColor()));
            }
        }

        holder.setText(R.id.claim_name, item.getCustomerName());

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
            holder.setText(R.id.type_tv, sb.substring(0, sb.length() - 1).toString());
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, RecommandBean.Recommand item) {
        return R.layout.itme_my_claim;
    }
}
