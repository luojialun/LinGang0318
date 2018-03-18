package com.lingang.fragment.update;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.UpdateTunityAc;
import com.lingang.activity.tunity.NeedClassAc;
import com.lingang.activity.tunity.NexusAc;
import com.lingang.base.BaseFragment;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.NeedBean;
import com.lingang.bean.TunityDetailesBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MyTextWatcher;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.CashierInputFilter;
import com.lingang.utils.ToastUtils;
import com.lingang.utils.UiUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

public class UpdateTunityTwoFr extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.ll_class)
    LinearLayout llClass;
    @BindView(R.id.et_explan)
    EditText etExplan;
    @BindView(R.id.et_num)
    TextView etNum;
    @BindView(R.id.tv_title)
    TextView titleTv;

    private Unbinder unbinder;
    private UpdateTunityAc mActivity;
    private List<NeedBean> needBack = new ArrayList<>();
    private List<NeedBean> needGo = new ArrayList<>();
    private List<NeedBean> dataList = new ArrayList<>();

    private LayoutInflater layoutInflater;
    private View zhuc, land, work, plant;

    private EditText lad_mj, zhuc_money, work_mj, plan_mj;
    private TextView lad_xz, lad_qw, zhuc_class, work_qw, work_ld, plan_qw, plan_ld;
    private String plan_ld_ID, plan_qw_ID, zhuc_class_ID, lad_qw_Id, lad_xz_Id, work_ld_ID, work_qw_ID;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (UpdateTunityAc) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_tunity_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        titleTv.setText("更新商机信息");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initAddView();
        initView();

        etExplan.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etNum.setText(s.length() + "/300");
            }
        });
    }

    /**
     * 初始化动态view
     */
    private void initAddView() {
        layoutInflater = getActivity().getLayoutInflater();

        plant = layoutInflater.inflate(R.layout.plant_layout, null);
        work = layoutInflater.inflate(R.layout.work_layout, null);
        land = layoutInflater.inflate(R.layout.land_layout, null);
        zhuc = layoutInflater.inflate(R.layout.zhuc_layout, null);

        plant.findViewById(R.id.plan_dele).setOnClickListener(this);
        plan_ld = (TextView) plant.findViewById(R.id.plan_ld);
        plan_mj = (EditText) plant.findViewById(R.id.plan_mj);
        plan_qw = (TextView) plant.findViewById(R.id.plan_qw);
        plan_ld.setOnClickListener(this);
        plan_qw.setOnClickListener(this);

        zhuc.findViewById(R.id.zhuc_dele).setOnClickListener(this);
        zhuc_money = (EditText) zhuc.findViewById(R.id.zhuc_money);
        zhuc_class = (TextView) zhuc.findViewById(R.id.zhuc_class);
        zhuc_class.setOnClickListener(this);

        land.findViewById(R.id.lad_dele).setOnClickListener(this);
        lad_qw = (TextView) land.findViewById(R.id.lad_qw);
        lad_mj = (EditText) land.findViewById(R.id.lad_mj);
        lad_xz = (TextView) land.findViewById(R.id.lad_xz);
        lad_qw.setOnClickListener(this);
        lad_xz.setOnClickListener(this);

        work.findViewById(R.id.work_dele).setOnClickListener(this);
        work_ld = (TextView) work.findViewById(R.id.work_ld);
        work_mj = (EditText) work.findViewById(R.id.work_mj);
        work_qw = (TextView) work.findViewById(R.id.work_qw);
        work_ld.setOnClickListener(this);
        work_qw.setOnClickListener(this);

        //校验 整数和小数2位
        //默认控制输入10位数，小数点前7位，后2位，小数一位，共10位
        InputFilter[] filters={new CashierInputFilter(12),new InputFilter.LengthFilter(12)};
        lad_mj.setFilters(filters);
        work_mj.setFilters(filters);
        zhuc_money.setFilters(filters);
        plan_mj.setFilters(filters);
    }

    private void initView() {
        dataList = new ArrayList<>();
        dataList.add(new NeedBean(Constants.FACTORY, false));
        dataList.add(new NeedBean(Constants.OFFICE, false));
        dataList.add(new NeedBean(Constants.LAND, false));
        dataList.add(new NeedBean(Constants.REGISTERED_ENTERPRISE, false));

        needGo.addAll(dataList);

        if (null != mActivity.getTunityDetailesBean() && null != mActivity.getTunityDetailesBean().getData()) {
            TunityDetailesBean.DataBean dataBean = mActivity.getTunityDetailesBean().getData();
            if (!TextUtils.isEmpty(dataBean.getWorkshopTypeId())) {
                needBack.add(new NeedBean(Constants.FACTORY, true));
            }
            if (!TextUtils.isEmpty(dataBean.getOfficeTypeId())) {
                needBack.add(new NeedBean(Constants.OFFICE, true));
            }
            if (!TextUtils.isEmpty(dataBean.getLandType())) {
                needBack.add(new NeedBean(Constants.LAND, true));
            }
            if (!TextUtils.isEmpty(dataBean.getRegisteredEnterpriseType())) {
                needBack.add(new NeedBean(Constants.REGISTERED_ENTERPRISE, true));
            }

            addSelectView(needBack);

            viewFillData(dataBean.getSupplementaryNotes(), etExplan);
            //厂房
            setChangfang(TextUtils.isEmpty(dataBean.getWorkshopTypeName()) ? "" : dataBean.getWorkshopTypeName(),
                    dataBean.getWorkshopArea(),
                    TextUtils.isEmpty(dataBean.getWorkshopLocationName()) ? "" : dataBean.getWorkshopLocationName());
            //研发办公
            setOffice(TextUtils.isEmpty(dataBean.getOfficeTypeName()) ? "" : dataBean.getOfficeTypeName(),
                    dataBean.getOfficeArea(),
                    TextUtils.isEmpty(dataBean.getOfficeLocationName()) ? "" : dataBean.getOfficeLocationName());
            //土地
            setLand(TextUtils.isEmpty(dataBean.getLandLocationName()) ? "" : dataBean.getLandLocationName(),
                    dataBean.getLandArea(),
                    TextUtils.isEmpty(dataBean.getLandTypeName()) ? "" : dataBean.getLandTypeName());
            //注册型企业
            setCompany(dataBean.getRegisteredEnterpriseMoney(),
                    TextUtils.isEmpty(dataBean.getRegisteredEnterpriseTypeName()) ? "" : dataBean.getRegisteredEnterpriseTypeName());

            plan_ld_ID = dataBean.getWorkshopTypeId();
            plan_qw_ID = dataBean.getWorkshopLocationId();
            zhuc_class_ID = dataBean.getRegisteredEnterpriseType();
            lad_qw_Id = dataBean.getLandLocation();
            lad_xz_Id = dataBean.getLandType();
            work_ld_ID = dataBean.getOfficeTypeId();
            work_qw_ID = dataBean.getOfficeLocationId();

        }
    }

    private void viewFillData(String text, TextView view) {
        if (null != text) {
            view.setText(text);
        }
    }

    /**
     * 填充需求类型
     *
     * @param list
     */
    private void addSelectView(List<NeedBean> list) {
        for (NeedBean bean : list) {
            if (bean.isCheack()) {
                switch (bean.getContent()) {
                    case Constants.FACTORY:
                        llClass.addView(plant);
                        break;
                    case Constants.OFFICE:
                        llClass.addView(work);
                        break;
                    case Constants.LAND:
                        llClass.addView(land);
                        break;
                    case Constants.REGISTERED_ENTERPRISE:
                        llClass.addView(zhuc);
                        break;
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plan_dele:
                setChangfang("", "", "");
                llClass.removeView(plant);
                plan_ld_ID = "";
                plan_qw_ID = "";
                deleBack("厂房");
                break;
            case R.id.work_dele:
                setOffice("", "", "");
                llClass.removeView(work);
                deleBack("研发办公");
                work_ld_ID = "";
                work_qw_ID = "";
                break;
            case R.id.lad_dele:
                setLand("", "", "");
                llClass.removeView(land);
                deleBack("土地");
                lad_qw_Id = "";
                lad_xz_Id = "";
                break;
            case R.id.zhuc_dele:
                setCompany("", "");
                llClass.removeView(zhuc);
                deleBack("注册型企业");
                zhuc_class_ID = "";
                break;

            case R.id.plan_ld:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "落地形式")
                        .putExtra("basicsType", "11"), Constants.Plan_Ld);
                break;
            case R.id.plan_qw:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "区位要求")
                        .putExtra("basicsType", "12"), Constants.Plan_Qw);
                break;
            case R.id.zhuc_class:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "企业类型")
                        .putExtra("basicsType", "17"), Constants.Zhuc_Class);
                break;
            case R.id.lad_qw:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "区位要求")
                        .putExtra("basicsType", "15"), Constants.Lad_Qw);
                break;
            case R.id.lad_xz:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "土地性质")
                        .putExtra("basicsType", "16"), Constants.Lad_Xz);
                break;
            case R.id.work_ld:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "落地形式")
                        .putExtra("basicsType", "13"), Constants.Work_Ld);
                break;
            case R.id.work_qw:
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "区位要求")
                        .putExtra("basicsType", "14"), Constants.Work_Qw);
                break;
        }
    }

    public void setChangfang(String ld, String mj, String qw) {
        viewFillData(ld, plan_ld);
        viewFillData(UiUtils.splitPoint(mj), plan_mj);
        viewFillData(qw, plan_qw);
    }

    public void setOffice(String ld, String mj, String qw) {
        viewFillData(ld, work_ld);
        viewFillData(UiUtils.splitPoint(mj), work_mj);
        viewFillData(qw, work_qw);
    }

    public void setLand(String qw, String mj, String xz) {
        viewFillData(qw, lad_qw);
        viewFillData(UiUtils.splitPoint(mj), lad_mj);
        viewFillData(xz, lad_xz);
    }

    public void setCompany(String money, String clazz) {
        viewFillData(UiUtils.splitPoint(money), zhuc_money);
        viewFillData(clazz, zhuc_class);
    }


    @OnClick({R.id.tv_add, R.id.btn_next_two, R.id.ib_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add: //增加需求类型
                needGo.clear();
                needGo.addAll(dataList);
                Intent data = new Intent(getActivity(), NeedClassAc.class);
                if (needBack.size() == 0) {
                    data.putExtra("data", (Serializable) dataList);
                } else {
                    for (NeedBean beanback : needBack) {
                        for (int i = 0; i < needGo.size(); i++) {
                            if (beanback.getContent().equals(needGo.get(i).getContent())) {
                                needGo.remove(i);
                            }
                        }
                    }
                    data.putExtra("data", (Serializable) needGo);
                }
                startActivityForResult(data, Constants.Need);
                break;
            case R.id.btn_next_two: //保存
                testFullData();
                break;
            case R.id.ib_left:
                mActivity.showFragment(0);
                break;
        }
    }

    private void testFullData() {
        if (needBack.size() > 0) {
            for (NeedBean bean : needBack) {
                switch (bean.getContent()) {
                    case "厂房":
                        if (!isFullPlanData()) {
                            return;
                        }
                        break;
                    case "研发办公":
                        if (!isFullWorkData()) {
                            return;
                        }
                        break;
                    case "土地":
                        if (!isFullLandData()) {
                            return;
                        }
                        break;
                    case "注册型企业":
                        if (!isFullZhucData()) {
                            return;
                        }
                        break;
                }
            }
            updataOpportunity();
        } else {
            ToastUtils.showToast(getActivity(), "请至少选择一种需求类型");
        }
    }

    //土地数据判空
    private boolean isFullLandData() {
        if (TextUtils.isEmpty(lad_mj.getText())) {
            ToastUtils.showToast(getActivity(), "请填写土地面积");
            return false;
        }

        if (TextUtils.isEmpty(lad_qw_Id)) {
            ToastUtils.showToast(getActivity(), "请选择土地区位要求");
            return false;
        }

        if (TextUtils.isEmpty(lad_xz_Id)) {
            ToastUtils.showToast(getActivity(), "请选择土地性质");
            return false;
        }
        return true;
    }

    //研发数据判空
    private boolean isFullWorkData() {
        if (TextUtils.isEmpty(work_ld_ID)) {
            ToastUtils.showToast(getActivity(), "请选择研发办公落地形式");
            return false;
        }

        if (TextUtils.isEmpty(work_mj.getText())) {
            ToastUtils.showToast(getActivity(), "请填写研发办公面积");
            return false;
        }

        if (TextUtils.isEmpty(work_qw_ID)) {
            ToastUtils.showToast(getActivity(), "请选择研发办公区位要求");
            return false;
        }
        return true;
    }

    //注册数据判空
    private boolean isFullZhucData() {
        if (TextUtils.isEmpty(zhuc_class_ID)) {
            ToastUtils.showToast(getActivity(), "请选择企业类型");
            return false;
        }

        if (TextUtils.isEmpty(zhuc_money.getText())) {
            ToastUtils.showToast(getActivity(), "请填写注册型企业资金");
            return false;
        }

        return true;
    }

    //厂房判空
    private boolean isFullPlanData() {
        if (TextUtils.isEmpty(plan_ld_ID)) {
            ToastUtils.showToast(getActivity(), "请选择厂房落地形式");
            return false;
        }

        if (TextUtils.isEmpty(plan_mj.getText())) {
            ToastUtils.showToast(getActivity(), "请填写厂房面积");
            return false;
        }

        if (TextUtils.isEmpty(plan_qw_ID)) {
            ToastUtils.showToast(getActivity(), "请选择厂房区位要求");
            return false;
        }
        return true;
    }

    private void deleBack(String tag) {
        for (int i = 0; i < needBack.size(); i++) {
            if (needBack.get(i).getContent().equals(tag)) {
                needBack.remove(i);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.Need:
                if (resultCode == Constants.Need && data != null) {
                    ArrayList<NeedBean> list = (ArrayList<NeedBean>) data.getSerializableExtra("data");
                    if (list != null && list.size() > 0) {
                        needBack.addAll(list);
                        addSelectView(list);
                    }
                }
                break;
            case Constants.Plan_Ld:
                if (resultCode == Constants.Plan_Ld && data != null) {
                    plan_ld.setText(data.getStringExtra("value"));
                    plan_ld_ID = data.getStringExtra("valueId");
                }
                break;
            case Constants.Plan_Qw:
                if (resultCode == Constants.Plan_Qw && data != null) {
                    plan_qw.setText(data.getStringExtra("value"));
                    plan_qw_ID = data.getStringExtra("valueId");
                }

                break;
            case Constants.Zhuc_Class:
                if (resultCode == Constants.Zhuc_Class && data != null) {
                    zhuc_class.setText(data.getStringExtra("value"));
                    zhuc_class_ID = data.getStringExtra("valueId");
                }
                break;
            case Constants.Lad_Qw:
                if (resultCode == Constants.Lad_Qw && data != null) {
                    lad_qw.setText(data.getStringExtra("value"));
                    lad_qw_Id = data.getStringExtra("valueId");
                }
                break;
            case Constants.Lad_Xz:
                if (resultCode == Constants.Lad_Xz && data != null) {
                    lad_xz.setText(data.getStringExtra("value"));
                    lad_xz_Id = data.getStringExtra("valueId");
                }
                break;
            case Constants.Work_Ld:
                if (resultCode == Constants.Work_Ld && data != null) {
                    work_ld.setText(data.getStringExtra("value"));
                    work_ld_ID = data.getStringExtra("valueId");
                }

                break;
            case Constants.Work_Qw:
                if (resultCode == Constants.Work_Qw && data != null) {
                    work_qw.setText(data.getStringExtra("value"));
                    work_qw_ID = data.getStringExtra("valueId");
                }

                break;
        }
    }

    /**
     * 更新商机信息
     */
    public void updataOpportunity() {
        if (null != mActivity.getTunityDetailesBean() && null != mActivity.getTunityDetailesBean().getData()) {
            TunityDetailesBean.DataBean dataBean = mActivity.getTunityDetailesBean().getData();
            HttpParams params = new HttpParams();
            params.put("token", LoginManager.getInstance().getToken());
            params.put("keyId", mActivity.keyId);
            params.put("opportunityId", mActivity.opportunityId);

            params.put("customerName", dataBean.getCustomerName());//客户名称
            params.put("customerTel", dataBean.getCustomerTel());//客户电话
            params.put("customerCallId", dataBean.getCustomerCallId());//称呼
            params.put("customerRelationshipId", dataBean.getCustomerRelationshipId());//客户关系
            params.put("customerMail", dataBean.getCustomerMail());//客户邮箱
            params.put("customerEnterpriseIsregister", dataBean.getCustomerEnterpriseIsregister());//0、未注册1、已注册
            params.put("customerEnterpriseName", dataBean.getCustomerEnterpriseName());//企业名称
            params.put("customerEnterpriseKeywords", dataBean.getCustomerEnterpriseKeywords());//企业关键字

            params.put("workshopArea", plan_mj.getText().toString());//厂房面积需求
            params.put("workshopTypeId", plan_ld_ID);//厂房落地形式
            params.put("workshopLocationId", plan_qw_ID);//厂房区位要求

            params.put("officeTypeId", work_ld_ID);//研发办公的落地形式
            params.put("officeArea", work_mj.getText().toString());//研发办公的面积需求(平方米)
            params.put("officeLocationId", work_qw_ID);//研发办公的区位要求

            params.put("landArea", lad_mj.getText().toString());//土地面积需求（亩
            params.put("landLocation", lad_qw_Id);//土地区位要求
            params.put("landType", lad_xz_Id);//土地性质

            params.put("registeredEnterpriseType", zhuc_class_ID);//注册型企业类型
            params.put("registeredEnterpriseMoney", zhuc_money.getText().toString());//注册型企业注册资金（万元）

            params.put("supplementaryNotes", etExplan.getText().toString());//需求补充说明

            OkGo.post(HttpApi.UPDATE_OPPORTUNITY).tag(this).params(params).execute(new ResCallBack<BaseEntity<Object, Object>>(getActivity()) {
                @Override
                public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                    if (null != responseBean) {
                        ToastUtils.showToast(getActivity(), "更新商机信息成功");
                        mActivity.setResult(Constants.OppDetailRefreshType.RESPONSE_FINISH);
                        mActivity.finish();
                    }
                }

                @Override
                public void onError(Call call, Response response, Exception e) {
                    super.onError(call, response, e);
                    ToastUtils.showToast(getActivity(), e.getMessage());
                }
            });
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
