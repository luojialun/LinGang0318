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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luojialun on 2017/9/13.
 */

public class RecExamineFragment extends BaseFragment {

    @BindView(R.id.workshop_ll)
    LinearLayout workshopLl;
    @BindView(R.id.workshopTypeName_tv)
    TextView workshopTypeNameTv;
    @BindView(R.id.workshopArea_tv)
    TextView workshopAreaTv;
    @BindView(R.id.workshopLocation_tv)
    TextView workshopLocationTv;

    @BindView(R.id.office_ll)
    LinearLayout officeLl;
    @BindView(R.id.officeTypeName_tv)
    TextView officeTypeNameTv;
    @BindView(R.id.officeArea_tv)
    TextView officeAreaTv;
    @BindView(R.id.officeLocation_tv)
    TextView officeLocationTv;

    @BindView(R.id.land_ll)
    LinearLayout landLl;
    @BindView(R.id.landArea_tv)
    TextView landAreaTv;
    @BindView(R.id.landLocation_tv)
    TextView landLocationTv;
    @BindView(R.id.landType_tv)
    TextView landTypeTv;

    @BindView(R.id.register_ll)
    LinearLayout registerLl;
    @BindView(R.id.registeredEnterpriseType_tv)
    TextView registeredEnterpriseTypeTv;
    @BindView(R.id.registeredEnterpriseMoney_tv)
    TextView registeredEnterpriseMoneyTv;

    private Unbinder unbinder;
    //需求类型
    public Constants.ParamLandType paramLandType;
    //商机信息bean
    public OppBean oppBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rec_examine, container, false);
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
                workshopLl.setVisibility(View.VISIBLE);
                workshopTypeNameTv.setText(oppBean.getWorkshopTypeName());
                String workshopArea = splitPoint(oppBean.getWorkshopArea());
                workshopAreaTv.setText(workshopArea + "平房米");
                workshopLocationTv.setText(oppBean.getWorkshopLocationName());
            }
            if (paramLandType.hasHaveOffice()) {
                officeLl.setVisibility(View.VISIBLE);
                officeTypeNameTv.setText(oppBean.getOfficeTypeName());
                String officeArea = splitPoint(oppBean.getOfficeArea());
                officeAreaTv.setText(officeArea+"平方米");
                officeLocationTv.setText(oppBean.getOfficeLocationName());
            }
            if (paramLandType.hasHaveLand()) {
                landLl.setVisibility(View.VISIBLE);
                String landArea = splitPoint(oppBean.getLandArea());
                landAreaTv.setText(landArea+"亩");
                landLocationTv.setText(oppBean.getLandLocationName());
                landTypeTv.setText(oppBean.getLandTypeName());
            }
            if (paramLandType.hasHaveEnterpriseType()) {
                registerLl.setVisibility(View.VISIBLE);
                registeredEnterpriseTypeTv.setText(oppBean.getRegisteredEnterpriseTypeName());
                String money = splitPoint(oppBean.getRegisteredEnterpriseMoney());
                registeredEnterpriseMoneyTv.setText(money+"万元");
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
