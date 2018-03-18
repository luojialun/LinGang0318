package com.lingang.fragment.examine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.tunity.OppExamineDetailsAc;
import com.lingang.base.BaseFragment;
import com.lingang.bean.OppBean;
import com.lingang.common.Constants;
import com.lingang.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luojialun on 2017/9/13.
 */

public class LandExamineFragment extends BaseFragment {
    private Unbinder unbinder;

    @BindView(R.id.workshop_ll)
    LinearLayout workshopLl;
    @BindView(R.id.workshopArea_tv)
    TextView workshopAreaTv;
    @BindView(R.id.workshopPrice_tv)
    TextView workshopPriceTv;
    @BindView(R.id.workshopTime_tv)
    TextView workshopTimeTv;

    @BindView(R.id.workshop_buy_ll)
    LinearLayout workshopBuyLl;
    @BindView(R.id.workshopArea_buy_tv)
    TextView workshopAreaBuyTv;
    @BindView(R.id.workshopPrice_buy_tv)
    TextView workshopPriceBuyTv;

    @BindView(R.id.office_ll)
    LinearLayout officeLl;
    @BindView(R.id.officeArea_tv)
    TextView officeAreaTv;
    @BindView(R.id.officePrice_tv)
    TextView officePriceTv;
    @BindView(R.id.officeTime_tv)
    TextView officeTimeTv;

    @BindView(R.id.office_buy_ll)
    LinearLayout officeBuyLl;
    @BindView(R.id.officeArea_buy_tv)
    TextView officeAreaBuyTv;
    @BindView(R.id.officePrice_buy_tv)
    TextView officePriceBuyTv;

    @BindView(R.id.land_ll)
    LinearLayout landLl;
    @BindView(R.id.landArea_tv)
    TextView landAreaTv;
    @BindView(R.id.landPrice_tv)
    TextView landPriceTv;
    @BindView(R.id.landTime_tv)
    TextView landTimeTv;
    @BindView(R.id.landNature_tv)
    TextView landNatureTv;
    @BindView(R.id.landGet_tv)
    TextView landGetTv;

    @BindView(R.id.register_ll)
    LinearLayout registerLl;
    @BindView(R.id.registerPrice_tv)
    TextView registerPriceTv;

    //需求类型
    public Constants.ParamLandType paramLandType;
    //商机信息bean
    public OppBean oppBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_land_examine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        paramLandType = ((OppExamineDetailsAc) getActivity()).paramLandType;
        oppBean = ((OppExamineDetailsAc) getActivity()).oppBean;

        renderLandType();
    }

    public void renderLandType() {
        if (paramLandType != null && oppBean != null) {
            if (paramLandType.hasHaveWorkshop()) {
                if (oppBean.getSaveWorkshopTypeName().equals("租赁")) {
                    workshopLl.setVisibility(View.VISIBLE);
                    workshopAreaTv.setText(splitPoint(oppBean.getSaveWorkshopArea()));
                    workshopPriceTv.setText(splitPoint(oppBean.getSaveWorkshopPrice()));
                    workshopTimeTv.setText(splitPoint(oppBean.getSaveWorkshopDay()));
                } else {
                    workshopBuyLl.setVisibility(View.VISIBLE);
                    workshopAreaBuyTv.setText(splitPoint(oppBean.getSaveWorkshopArea()));
                    workshopPriceBuyTv.setText(splitPoint(oppBean.getSaveWorkshopPrice()));
                }
            }
            if (paramLandType.hasHaveOffice()) {
                if (oppBean.getSaveOfficeTypeName().equals("租赁")) {
                    officeLl.setVisibility(View.VISIBLE);
                    officeAreaTv.setText(splitPoint(oppBean.getSaveOfficeArea()));
                    officePriceTv.setText(splitPoint(oppBean.getSaveOfficePrice()));
                    officeTimeTv.setText(splitPoint(oppBean.getSaveOfficeDay()));
                } else {
                    officeBuyLl.setVisibility(View.VISIBLE);
                    officeAreaBuyTv.setText(splitPoint(oppBean.getSaveOfficeArea()));
                    officePriceBuyTv.setText(splitPoint(oppBean.getSaveOfficePrice()));
                }
            }
            if (paramLandType.hasHaveLand()) {
                landLl.setVisibility(View.VISIBLE);
                landAreaTv.setText(splitPoint(oppBean.getSaveLandArea()));
                landPriceTv.setText(splitPoint(oppBean.getSaveLandPeice()));
                landTimeTv.setText(splitPoint(oppBean.getSaveLandDay()));
                landNatureTv.setText(oppBean.getSaveLandNatureName());
                landGetTv.setText(oppBean.getSaveLandGetName());
            }
            if (paramLandType.hasHaveEnterpriseType()) {
                registerLl.setVisibility(View.VISIBLE);
                registerPriceTv.setText(splitPoint(oppBean.getSaveEnterpriseMoney()));
            }
        }
    }

    /**
     * 小数点处理
     */
    private String splitPoint(String content) {
        if (!TextUtils.isEmpty(content)){
            String[] split = content.split("\\.");
            if (split.length > 1) {
                if ((split[1].equals("0") || split[1].equals("00"))){
                    return split[0];
                }else {
                    return content;
                }
            }
            return split[0];
        }
        return "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
