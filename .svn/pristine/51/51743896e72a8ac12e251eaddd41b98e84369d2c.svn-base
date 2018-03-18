package com.lingang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ClusterBean;
import com.lingang.bean.MyExecuteBean;
import com.lingang.bean.ShowStateEnum;
import com.lingang.common.Constants;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.vector.update_app.utils.DrawableUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的执行Adapter
 */
public class MyExecuteAdapter extends RecycleBaseAdapter<MyExecuteBean.Execute> {

    private Context context;
    private String state = "1";

    public MyExecuteAdapter(Context context, List<MyExecuteBean.Execute> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MyExecuteBean.Execute item, int position) {
        if (null != item) {
            holder.setText(R.id.claim_team, TextUtils.isEmpty(item.getCustomerEnterpriseName()) ? "未注册企业" : item.getCustomerEnterpriseName());
            TextView stateTv = holder.getView(R.id.state_btn);
            //商机状态
            if (!TextUtils.isEmpty(state)) {
                ShowStateEnum showStateEnum = Constants.executeShowState.get(Integer.parseInt(state));
                if (null != showStateEnum) {
                    if (!TextUtils.isEmpty(showStateEnum.getState()) && null != stateTv) {
                        stateTv.setText(showStateEnum.getState());
                        DrawableUtil.setTextSolidTheme(stateTv, 6, 30, context.getResources().getColor(showStateEnum.getColor()));
                    }
                }
            }

            TextView SourceTv = holder.getView(R.id.execute_type);
            if (null != SourceTv) {
                SourceTv.setText(item.getOpportunityLevel() + "类");
                DrawableUtil.setTextSolidTheme(SourceTv, 6, 0, context.getResources().getColor(R.color.c_7eb2ec));
            }
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

    }

    @Override
    protected int getItemViewLayoutId(int position, MyExecuteBean.Execute item) {
        return R.layout.itme_my_execute;
    }

    public void setShowState(String state) {
        this.state = state;
    }
}
