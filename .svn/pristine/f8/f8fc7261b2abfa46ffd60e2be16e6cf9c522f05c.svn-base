package com.lingang.activity.business;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.view.SettingItem;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class ContractSummaryAc extends BaseAc {

    @BindView(R.id.company_name_si)
    SettingItem companyNameSi;
    @BindView(R.id.yuanqu_si)
    SettingItem yuanquSi;

    @BindView(R.id.workshop_ll)
    LinearLayout workshopLl;
    @BindView(R.id.office_ll)
    LinearLayout officeLl;
    @BindView(R.id.land_ll)
    LinearLayout landLl;
    @BindView(R.id.register_ll)
    LinearLayout registerLl;

    @BindView(R.id.changfang1_si)
    SettingItem changfang1Si;
    @BindView(R.id.changfang2_si)
    SettingItem changfang2Si;
    @BindView(R.id.changfang3_si)
    SettingItem changfang3Si;
    @BindView(R.id.changfang4_si)
    SettingItem changfang4Si;

    @BindView(R.id.yanfa1_si)
    SettingItem yanfa1Si;
    @BindView(R.id.yanfa2_si)
    SettingItem yanfa2Si;
    @BindView(R.id.yanfa3_si)
    SettingItem yanfa3Si;
    @BindView(R.id.yanfa4_si)
    SettingItem yanfa4Si;

    @BindView(R.id.buy_land_si)
    SettingItem buyLandSi;
    @BindView(R.id.land_price_si)
    SettingItem landPriceSi;
    @BindView(R.id.land_years_si)
    SettingItem landYearsSi;
    @BindView(R.id.land_property_si)
    SettingItem landPropertySi;
    @BindView(R.id.land_get_si)
    SettingItem landGetSi;

    @BindView(R.id.registeredEnterpriseMoney_txt)
    SettingItem registeredEnterpriseMoneyTxt;

    //获取商机详情ID
    private String kid = "";
    //页面类型
    private Constants.OppPageStateType pageStateType;
    //需求类型
    private Constants.ParamLandType paramLandType;
    //商机信息bean
    private OppBean oppBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_contract_summary);
        setTitle("合同摘要");
        kid = getIntent().getStringExtra(Constants.OPP_DETAILS_ID);
        pageStateType = (Constants.OppPageStateType) getIntent().getSerializableExtra(Constants.OPP_PAGE_STATE_TYPE);
        paramLandType = (Constants.ParamLandType) getIntent().getSerializableExtra(Constants.OPP_LAND_TYPE);
        getOppDetail();
    }

    /**
     * 获取商机详情
     */
    public void getOppDetail() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keyId", kid);
        OkGo.post(HttpApi.opportunity_detail)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<OppBean, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<OppBean, Object> oppBeanEntity, Call call, Response response) throws JSONException {
                        oppBean = oppBeanEntity.getData();
                        renderOpp(oppBean);
                        //土地需求类型
                        renderLandType(oppBean);
                    }
                });
    }

    /**
     * 填充基本信息
     */
    private void renderOpp(OppBean oppBean) {
        if (null != oppBean) {
            companyNameSi.setRightText(TextUtils.isEmpty(oppBean.getCustomerEnterpriseName()) ? "未注册企业" : oppBean.getCustomerEnterpriseName());
            yuanquSi.setRightText(oppBean.getChooseParkName());
        }
    }

    /**
     * 土地需求类型
     */
    private void renderLandType(OppBean oppBean) {
        if (paramLandType != null && oppBean != null) {
            if (paramLandType.hasHaveWorkshop()) {
                workshopLl.setVisibility(View.VISIBLE);
                changfang1Si.setRightText(oppBean.getSaveWorkshopTypeName());
                if (Constants.RENT.equals(oppBean.getSaveWorkshopTypeName())) {
                    changfang2Si.setItemText("租赁面积");
                    changfang3Si.setItemText("租赁价格");
                    changfang4Si.setItemText("租期");

                } else {
                    changfang2Si.setItemText("购买面积");
                    changfang3Si.setItemText("购买价格");
                    changfang4Si.setVisibility(View.GONE);
                }
                changfang2Si.setRightText(splitPoint(oppBean.getSaveWorkshopArea()) + getString(R.string.workAreaUnit));
                changfang3Si.setRightText(splitPoint(oppBean.getSaveWorkshopPrice()) + "元/平方米/天");
                changfang4Si.setRightText(splitPoint(oppBean.getSaveWorkshopDay()) + "年");
            }
            if (paramLandType.hasHaveOffice()) {
                officeLl.setVisibility(View.VISIBLE);
                yanfa1Si.setRightText(oppBean.getSaveOfficeTypeName());
                if (Constants.RENT.equals(oppBean.getSaveOfficeTypeName())) {
                    yanfa2Si.setItemText("租赁面积");
                    yanfa3Si.setItemText("租赁价格");
                    yanfa4Si.setItemText("租期");
                } else {
                    yanfa2Si.setItemText("购买面积");
                    yanfa3Si.setItemText("购买价格");
                    yanfa4Si.setVisibility(View.GONE);
                }
                yanfa2Si.setRightText(splitPoint(splitPoint(oppBean.getSaveOfficeArea())) + "平方米");
                yanfa3Si.setRightText(splitPoint(splitPoint(oppBean.getSaveOfficePrice())) + "元/平方米/天");
                yanfa4Si.setRightText(splitPoint(oppBean.getSaveOfficeDay()) + "年");
            }
            if (paramLandType.hasHaveLand()) {
                landLl.setVisibility(View.VISIBLE);
                buyLandSi.setRightText(splitPoint(oppBean.getSaveLandArea()) + "亩");
                landPriceSi.setRightText(splitPoint(oppBean.getSaveLandPeice()) + "万元");
                landYearsSi.setRightText(splitPoint(oppBean.getSaveLandDay()) + "年");
                landPropertySi.setRightText(oppBean.getSaveLandNatureName());
                landGetSi.setRightText(oppBean.getSaveLandGetName());
            }
            if (paramLandType.hasHaveEnterpriseType()) {
                registerLl.setVisibility(View.VISIBLE);
                registeredEnterpriseMoneyTxt.setRightText(splitPoint(oppBean.getRegisteredEnterpriseMoney()) + "万元");
            }
        }
    }

    /**
     * 小数点处理
     */
    private String splitPoint(String content) {
        if (!TextUtils.isEmpty(content)) {
            String[] split = content.split("\\.");
            if (split.length > 1) {
                if ((split[1].equals("0") || split[1].equals("00"))) {
                    return split[0];
                } else {
                    return content;
                }
            }
            return split[0];
        }
        return "";
    }

}
