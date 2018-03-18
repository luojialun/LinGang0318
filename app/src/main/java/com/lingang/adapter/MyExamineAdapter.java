package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.MyExamineBean;
import com.lingang.bean.ShowStateEnum;
import com.lingang.common.Constants;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.SettingItem;
import com.vector.update_app.utils.DrawableUtil;

import java.util.List;

/**
 * Created by luojialun on 2017/8/22.
 */

public class MyExamineAdapter extends RecycleBaseAdapter<MyExamineBean.Examine> {

    private Context context;
    private String state = "1";

    public MyExamineAdapter(Context context, List<MyExamineBean.Examine> mList) {
        super(context, mList);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, MyExamineBean.Examine item, int position) {
        SettingItem examineSi = holder.getView(R.id.examine_si);
        if ("1".equals(item.getShowState())) {
            holder.setText(R.id.examine_tv, item.getRecommendUserName() + "的推荐审核申请");
            examineSi.setRightText("推荐审核");
        } else {
            holder.setText(R.id.examine_tv, item.getSaveCheckApplyUserName() + "的落地审核申请");
            examineSi.setRightText("落地审核");
        }

        SettingItem nameSi = holder.getView(R.id.name_si);
        if (TextUtils.isEmpty(item.getCustomerEnterpriseName())) {
            nameSi.setRightText("未注册企业");
        }else{
            nameSi.setRightText(item.getCustomerEnterpriseName());
        }
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
            SettingItem needSi = holder.getView(R.id.need_si);
            needSi.setRightText(sb.substring(0, sb.length() - 1).toString());
        }

        TextView stateTv = holder.getView(R.id.state_tv);
        if(!TextUtils.isEmpty(state))
        {
            ShowStateEnum showStateEnum= Constants.exaShowState.get(Integer.parseInt(state));
            if(state !=null) {
                stateTv.setText(showStateEnum.getState());
                DrawableUtil.setTextSolidTheme(stateTv, 6, 30, context.getResources().getColor(showStateEnum.getColor()));
            }
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, MyExamineBean.Examine item) {
        return R.layout.item_examine;
    }

    public void setState(String state) {
        this.state = state;
    }

}
