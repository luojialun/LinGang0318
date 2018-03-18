package com.lingang.activity.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.tunity.NexusAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.CashierInputFilter;
import com.lingang.utils.ToastUtils;
import com.lingang.view.SettingItem;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.vector.update_app.utils.DrawableUtil;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 17/8/28.
 * 提交落地审核页面
 */
public class SubmitLandReview extends BaseAc {

    @BindView(R.id.business_name)
    SettingItem businessName;
    @BindView(R.id.business_land_park)
    SettingItem businessLandPark;
    @BindView(R.id.workshopTypeName_txt)
    TextView workshopTypeNameTxt;
    @BindView(R.id.workshopArea_txt)
    EditText workshopAreaTxt;
    @BindView(R.id.workshopPrice_txt)
    EditText workshopPriceTxt;
    @BindView(R.id.workshop_ll)
    LinearLayout workshopLl;
    @BindView(R.id.officeTypeName_txt)
    TextView officeTypeNameTxt;
    @BindView(R.id.officeArea_txt)
    EditText officeAreaTxt;
    @BindView(R.id.officePrice_txt)
    EditText officePriceTxt;
    @BindView(R.id.officeTime_txt)
    EditText officeTimeTxt;
    @BindView(R.id.office_ll)
    LinearLayout officeLl;
    @BindView(R.id.landArea_txt)
    EditText landAreaTxt;
    @BindView(R.id.landPrice_txt)
    EditText landPriceTxt;
    @BindView(R.id.landTime_txt)
    EditText landTimeTxt;
    @BindView(R.id.landTypeName)
    LinearLayout landTypeName;
    @BindView(R.id.landGetType)
    LinearLayout landGetType;
    @BindView(R.id.land_ll)
    LinearLayout landLl;
    @BindView(R.id.registerPrice_txt)
    EditText registerPriceTxt;
    @BindView(R.id.register_ll)
    LinearLayout registerLl;
    @BindView(R.id.update_execute_submit)
    TextView updateExecuteSubmit;
    @BindView(R.id.landNature_txt)
    TextView landNatureTxt;
    @BindView(R.id.landGet_txt)
    TextView landGetTxt;
    @BindView(R.id.workshopTime_txt)
    EditText workshopTimeTxt;
    @BindView(R.id.workshopTypeName_buy_txt)
    TextView workshopTypeNameBuyTxt;
    @BindView(R.id.workshopArea_buy_txt)
    EditText workshopAreaBuyTxt;
    @BindView(R.id.workshopPrice_buy_txt)
    EditText workshopPriceBuyTxt;
    @BindView(R.id.workshop_buy_ll)
    LinearLayout workshopBuyLl;
    @BindView(R.id.officeTypeName_buy_txt)
    TextView officeTypeNameBuyTxt;
    @BindView(R.id.officeArea_buy_txt)
    EditText officeAreaBuyTxt;
    @BindView(R.id.officePrice_buy_txt)
    EditText officePriceBuyTxt;
    @BindView(R.id.office_by_ll)
    LinearLayout officeByLl;

    //需求类型
    private Constants.ParamLandType paramLandType;
    //商机详情实体
    private OppBean oppBean;

    //土地取得方式ID
    private String landGetId = App.Empty;
    //土地性质ID
    private String landNatureId = App.Empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_submit_land);
        setTitle("提交落地审核");
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        paramLandType = (Constants.ParamLandType) getIntent().getSerializableExtra(Constants.OPP_LAND_TYPE);
        oppBean = (OppBean) getIntent().getSerializableExtra(Constants.OPP_OPP_BEAN);
        DrawableUtil.setTextSolidTheme(updateExecuteSubmit, 6, 10, getResources().getColor(R.color.f57725));
        //注册校验整数和小数2位,过滤器
        registerFilters(workshopAreaTxt, workshopPriceTxt, workshopAreaBuyTxt,
                workshopPriceBuyTxt, officeAreaTxt, officePriceTxt, officePriceBuyTxt,
                officeAreaBuyTxt, landAreaTxt, landPriceTxt, registerPriceTxt);
        workshopAreaTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        workshopPriceTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        workshopTimeTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        workshopAreaBuyTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        workshopPriceBuyTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        officeAreaTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        officePriceTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        officeTimeTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        officeAreaBuyTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        officePriceBuyTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        landAreaTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        landPriceTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        landTimeTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        registerPriceTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
        //渲染页面数据
        renderView();
    }

    /**
     * 注册校验整数和小数2位,过滤器
     *
     * @param editText
     */
    private void registerFilters(EditText... editText) {
        if (editText != null && editText.length > 0) {
            for (EditText txt : editText) {
                txt.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                InputFilter[] filters = {new CashierInputFilter(12), new InputFilter.LengthFilter(12)};
                txt.setFilters(filters);
            }
        }
    }

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void gotoSubmitLandReview(Context context, OppBean bean, Constants.ParamLandType landType) {
        Intent intent = new Intent(context, SubmitLandReview.class);
        intent.putExtra(Constants.OPP_LAND_TYPE, landType);//需求类型(厂房,研发办公,土地,注册型企业)
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(Constants.OPP_OPP_BEAN, bean);
        intent.putExtras(mBundle);//商机信息
        ((Activity) context).startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
    }

    @OnClick({R.id.update_execute_submit, R.id.landTypeName, R.id.landGetType})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.update_execute_submit:
                executeNext();
                break;
            case R.id.landTypeName:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "土地性质")
                        .putExtra("basicsType", "16"), Constants.Lad_Xz);
                break;
            case R.id.landGetType:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "土地取得方式")
                        .putExtra("basicsType", "20"), Constants.LandGetBack);
                break;
        }
    }


    /**
     * 数据填充
     */
    private void renderView() {
        if (oppBean != null) {
            businessName.setRightText(TextUtils.isEmpty(oppBean.getCustomerEnterpriseName()) ? "未注册企业" : oppBean.getCustomerEnterpriseName());
            businessLandPark.setRightText(oppBean.getChooseParkName());
            //厂房
            if (paramLandType.hasHaveWorkshop()) {
                if (oppBean.getWorkshopTypeName().equals("租赁")) {
                    workshopLl.setVisibility(View.VISIBLE);
//                    workshopTypeNameTxt.setText(oppBean.getWorkshopTypeName());
                    workshopAreaTxt.setText(formatNum(oppBean.getWorkshopArea()));
//                    workshopPriceTxt.setText(oppBean.getSaveWorkshopPrice());
//                    workshopTimeTxt.setText(oppBean.getSaveWorkshopDay());
                } else {
                    workshopBuyLl.setVisibility(View.VISIBLE);
//                    workshopTypeNameBuyTxt.setText(oppBean.getWorkshopTypeName());
                    workshopAreaBuyTxt.setText(formatNum(oppBean.getWorkshopArea()));
//                    workshopPriceBuyTxt.setText(oppBean.getSaveWorkshopPrice());
                }
            }
            //办公
            if (paramLandType.hasHaveOffice()) {
                if (oppBean.getOfficeTypeName().equals("租赁")) {
                    officeLl.setVisibility(View.VISIBLE);
//                    officeTypeNameTxt.setText(oppBean.getOfficeTypeName());
                    officeAreaTxt.setText(formatNum(oppBean.getOfficeArea()));
//                    officePriceTxt.setText(oppBean.getSaveOfficePrice());
//                    officeTimeTxt.setText(oppBean.getSaveOfficeDay());
                } else {
                    officeByLl.setVisibility(View.VISIBLE);
//                    officeTypeNameBuyTxt.setText(oppBean.getOfficeTypeName());
                    officeAreaBuyTxt.setText(formatNum(oppBean.getOfficeArea()));
//                    officePriceBuyTxt.setText(oppBean.getSaveOfficePrice());
                }
            }
            //土地
            if (paramLandType.hasHaveLand()) {
                landLl.setVisibility(View.VISIBLE);
                landAreaTxt.setText(formatNum(oppBean.getLandArea()));
                landPriceTxt.setText(oppBean.getSaveLandPeice());
                landTimeTxt.setText(oppBean.getSaveLandDay());
                landNatureTxt.setText(oppBean.getLandTypeName());
//                landGetTxt.setText(oppBean.getSaveLandGetName());
                landGetId = oppBean.getSaveLandGetId();
                landNatureId = oppBean.getLandType();
            }
            //企业注册
            if (paramLandType.hasHaveEnterpriseType()) {
                registerLl.setVisibility(View.VISIBLE);
                registerPriceTxt.setText(formatNum(oppBean.getRegisteredEnterpriseMoney()));
            }
        }
    }

    /**
     * 提交落地审核
     */
    private void executeNext() {

        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keyId",oppBean.getKeyId());
        httpParams.put("opportunityId", oppBean.getOpportunityId());
        if ("2".equals(LoginManager.getInstance().getUserInfo().getUserType())) {//科产办负责人
            httpParams.put("operateState", Constants.OperateState.Landed);//落地
        } else {
            httpParams.put("operateState", Constants.OperateState.LandedReview);//提交落地审核
        }
        //厂房
        if (paramLandType.hasHaveWorkshop()) {

            if (oppBean.getWorkshopTypeName().equals("租赁")) {
                if (TextUtils.isEmpty(workshopAreaTxt.getText().toString())) {
                    workshopAreaTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入厂房租赁面积数量");
                    return;
                }
                if (TextUtils.isEmpty(workshopPriceTxt.getText().toString())) {
                    workshopPriceTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入厂房租赁价格");
                    return;
                }
                if (TextUtils.isEmpty(workshopTimeTxt.getText().toString())) {
                    workshopTimeTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入厂房租赁使用年限");
                    return;
                }
                httpParams.put("saveWorkshopDay", workshopTimeTxt.getText().toString().trim());
                httpParams.put("saveWorkshopArea", workshopAreaTxt.getText().toString().trim());
                httpParams.put("saveWorkshopPrice", workshopPriceTxt.getText().toString().trim());
            } else {//购买
                if (TextUtils.isEmpty(workshopAreaBuyTxt.getText().toString())) {
                    workshopAreaBuyTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入厂房购买面积数量");
                    return;
                }
                if (TextUtils.isEmpty(workshopPriceBuyTxt.getText().toString())) {
                    workshopPriceBuyTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入厂房购买价格");
                    return;
                }
                httpParams.put("saveWorkshopArea", workshopAreaBuyTxt.getText().toString().trim());
                httpParams.put("saveWorkshopPrice", workshopPriceBuyTxt.getText().toString().trim());
            }
            httpParams.put("saveWorkshopTypeId", oppBean.getWorkshopTypeId());
        }
        //办公
        if (paramLandType.hasHaveOffice()) {
            if (oppBean.getOfficeTypeName().equals("租赁")) {
                if (TextUtils.isEmpty(officeAreaTxt.getText().toString())) {
                    officeAreaTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入研发办公租赁面积数量");
                    return;
                }
                if (TextUtils.isEmpty(officePriceTxt.getText().toString())) {
                    officePriceTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入研发办公租赁价格");
                    return;
                }

                if (TextUtils.isEmpty(officeTimeTxt.getText().toString())) {
                    officeTimeTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入研发办公租赁使用年限");
                    return;
                }
                httpParams.put("saveOfficeDay", officeTimeTxt.getText().toString().trim());
                httpParams.put("saveOfficeArea", officeAreaTxt.getText().toString().trim());
                httpParams.put("saveOfficePrice", officePriceTxt.getText().toString().trim());
            } else {//购买
                if (TextUtils.isEmpty(officePriceBuyTxt.getText().toString())) {
                    officePriceBuyTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入研发办公购买面积数量");
                    return;
                }
                if (TextUtils.isEmpty(officeAreaBuyTxt.getText().toString())) {
                    officeAreaBuyTxt.setFocusable(true);
                    ToastUtils.showToast(SubmitLandReview.this, "请输入研发办公购买价格");
                    return;
                }
                httpParams.put("saveOfficeArea", officeAreaBuyTxt.getText().toString().trim());
                httpParams.put("saveOfficePrice", officePriceBuyTxt.getText().toString().trim());
            }
            httpParams.put("saveOfficeTypeId", oppBean.getOfficeTypeId());
        }
        //土地
        if (paramLandType.hasHaveLand()) {
            if (TextUtils.isEmpty(landAreaTxt.getText().toString().trim())) {
                landAreaTxt.setFocusable(true);
                ToastUtils.showToast(SubmitLandReview.this, "请输入购买土地面积");
                return;
            }
            if (TextUtils.isEmpty(landPriceTxt.getText().toString().trim())) {
                landPriceTxt.setFocusable(true);
                ToastUtils.showToast(SubmitLandReview.this, "请输入购买土地总价格");
                return;
            }
            if (TextUtils.isEmpty(landTimeTxt.getText().toString().trim())) {
                landTimeTxt.setFocusable(true);
                ToastUtils.showToast(SubmitLandReview.this, "请输入土地使用年限");
                return;
            }
            if (TextUtils.isEmpty(landGetId)) {
                ToastUtils.showToast(SubmitLandReview.this, "请选择土地取得方式");
                return;
            }
            if (TextUtils.isEmpty(landNatureId)) {
                ToastUtils.showToast(SubmitLandReview.this, "请选择土地性质");
                return;
            }
            httpParams.put("saveLandArea", landAreaTxt.getText().toString().trim());
            httpParams.put("saveLandPeice", landPriceTxt.getText().toString().trim());
            httpParams.put("saveLandDay", landTimeTxt.getText().toString().trim());
            httpParams.put("saveLandGetId", landGetId);
            httpParams.put("saveLandNatureId", landNatureId);
        }
        //企业注册
        if (paramLandType.hasHaveEnterpriseType()) {
            if (TextUtils.isEmpty(registerPriceTxt.getText().toString().trim())) {
                registerPriceTxt.setFocusable(true);
                ToastUtils.showToast(SubmitLandReview.this, "请输入注册资金");
                return;
            }
            httpParams.put("saveEnterpriseMoney", registerPriceTxt.getText().toString().trim());
        }
        OkGo.post(HttpApi.executeNext)
                .tag(this)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(this) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) {
                        if (entity.getStateSuccess()) {
                            ToastUtils.showToast(SubmitLandReview.this, "提交落地审核成功!");
                            setResult(Constants.OppDetailRefreshType.SubmitLanded);
                        } else {
                            ToastUtils.showToast(SubmitLandReview.this, entity.getMessage());
                        }
                        finish();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(SubmitLandReview.this, e.getMessage());
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && data.getStringExtra("valueId") != null) {
            String valueId = data.getStringExtra("valueId");
            String value = data.getStringExtra("value");
            switch (resultCode) {
                case Constants.Lad_Xz:
                    landNatureId = valueId;
                    landNatureTxt.setText(value);
                    break;
                case Constants.LandGetBack:
                    landGetId = valueId;
                    landGetTxt.setText(value);
                    break;
            }
        }
    }

    /**
     * 整数加小数点，就转换一下；
     *
     * @param dNum
     * @return
     */
    private String formatNum(String dNum) {
        String result = App.Empty;
        if (!TextUtils.isEmpty(dNum)) {
            if ((double) ((int) Double.parseDouble(dNum)) == Double.parseDouble(dNum)) {
                result = String.valueOf((int) Double.parseDouble(dNum));
            } else {
                result = dNum;
            }
        }
        return result;
    }
}
