package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.NeedBean;
import com.lingang.bean.TjtunityTwoBean;
import com.lingang.common.Constants;
import com.lingang.utils.CashierInputFilter;
import com.lingang.utils.JsonUtil;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TjTunityTwoAc extends BaseAc implements View.OnClickListener, TextWatcher {
    @BindView(R.id.img_xq_info)
    ImageView imgXqInfo;
    @BindView(R.id.tv_xuq)
    TextView tvXuq;
    @BindView(R.id.ll_class)
    LinearLayout llClass;
    @BindView(R.id.et_explan)
    EditText etExplan;
    @BindView(R.id.et_num)
    TextView etNum;
    private ArrayList<NeedBean> dataList;
    private LayoutInflater layoutInflater;

    private View zhuc, land, work, plant;
    private ArrayList<NeedBean> needBack;
    private ArrayList<NeedBean> needGo;
    private EditText lad_mj, zhuc_money, work_mj, plan_mj;
    private TextView lad_xz, lad_qw, zhuc_class, work_qw, work_ld, plan_qw, plan_ld;
    private String plan_ld_ID, plan_qw_ID, zhuc_class_ID, lad_qw_Id, lad_xz_Id, work_ld_ID, work_qw_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_tj_tunity_two);
        setTitle("推荐商机");
        setRightTv("规则");
        Log.e("sss", "OneAc_onCreate");
        imgXqInfo.setImageResource(R.mipmap.ic_xuqiuxinxi1);
        tvXuq.setTextColor(getResources().getColor(R.color.black));

        etExplan.addTextChangedListener(this);

        initAddView();
        initView();


    }

    /**
     * 初始化
     */
    private void initView() {
        dataList = new ArrayList<>();
        dataList.add(new NeedBean("厂房", false));
        dataList.add(new NeedBean("研发办公", false));
        dataList.add(new NeedBean("土地", false));
        dataList.add(new NeedBean("注册型企业", false));

        needBack = new ArrayList<>();
        needGo = new ArrayList<>();
        needGo.addAll(dataList);

        String tjTunityTwoAc = (String) SPUtils.get(this, "TjTunityTwoAc", "");
        if (!TextUtils.isEmpty(tjTunityTwoAc)) {
            ArrayList<NeedBean> data = JsonUtil.getGson().fromJson(tjTunityTwoAc, new TypeToken<List<NeedBean>>() {
            }.getType());
            needBack.addAll(data);
            addSelectView(needBack);
        }

        String tjtunity = (String) SPUtils.get(this, "tjtunityTwoBean", "");
        if (!TextUtils.isEmpty(tjtunity)) {
            TjtunityTwoBean tjtunityTwoBean = JsonUtil.getGson().fromJson(tjtunity, TjtunityTwoBean.class);

            viewFillData(tjtunityTwoBean.getEtExplan(), etExplan);

            viewFillData(tjtunityTwoBean.getPlan_ld(), plan_ld);
            viewFillData(tjtunityTwoBean.getPlan_mj(), plan_mj);
            viewFillData(tjtunityTwoBean.getPlan_qw(), plan_qw);

            viewFillData(tjtunityTwoBean.getZhuc_money(), zhuc_money);
            viewFillData(tjtunityTwoBean.getZhuc_class(), zhuc_class);

            viewFillData(tjtunityTwoBean.getLad_qw(), lad_qw);
            viewFillData(tjtunityTwoBean.getLad_mj(), lad_mj);
            viewFillData(tjtunityTwoBean.getLad_xz(), lad_xz);

            viewFillData(tjtunityTwoBean.getWork_ld(), work_ld);
            viewFillData(tjtunityTwoBean.getWork_mj(), work_mj);
            viewFillData(tjtunityTwoBean.getWork_qw(), work_qw);

            plan_ld_ID = tjtunityTwoBean.getPlan_ld_ID();
            plan_qw_ID = tjtunityTwoBean.getPlan_qw_ID();
            zhuc_class_ID = tjtunityTwoBean.getZhuc_class_ID();
            lad_qw_Id = tjtunityTwoBean.getLad_qw_Id();
            lad_xz_Id = tjtunityTwoBean.getLad_xz_Id();
            work_ld_ID = tjtunityTwoBean.getWork_ld_ID();
            work_qw_ID = tjtunityTwoBean.getWork_qw_ID();
        }
    }

    private void viewFillData(String text, TextView view) {
        if (!TextUtils.isEmpty(text)) {
            view.setText(text);
            view.setTextColor(getResources().getColor(R.color.black));
        }
    }

    /**
     * 初始化动态view
     */
    private void initAddView() {
        layoutInflater = getLayoutInflater();

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

        //校验 整数和小数2位
        //默认控制输入10位数，小数点前7位，后2位，小数一位，共10位
        InputFilter[] filters = {new CashierInputFilter(12), new InputFilter.LengthFilter(12)};
        lad_mj.setFilters(filters);
        work_mj.setFilters(filters);
        zhuc_money.setFilters(filters);
        plan_mj.setFilters(filters);

        work_ld.setOnClickListener(this);
        work_qw.setOnClickListener(this);
    }

    @OnClick({R.id.tv_add, R.id.btn_next_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                needGo.clear();
                needGo.addAll(dataList);
                Intent data = new Intent(this, NeedClassAc.class);
                if (needBack.size() == 0) {
                    data.putExtra("data", dataList);
                } else {
                    for (NeedBean beanback : needBack) {
                        for (int i = 0; i < needGo.size(); i++) {
                            if (beanback.getContent().equals(needGo.get(i).getContent())) {
                                needGo.remove(i);
                            }
                        }
                    }
                    data.putExtra("data", needGo);
                }
                startActivityForResult(data, Constants.Need);
                break;
            case R.id.btn_next_two:
                testFullData();
                break;
        }
    }

    //验证数据是否填充完成
    private void testFullData() {
        TjtunityTwoBean tjtunityTwoBean = seveData();
        if (needBack.size() > 0) {
            boolean fullPlanData = false;
            for (NeedBean bean : needBack) {
                switch (bean.getContent()) {
                    case "厂房":
                        fullPlanData = isFullPlanData(tjtunityTwoBean);
                        break;
                    case "研发办公":
                        fullPlanData = isFullWorkData(tjtunityTwoBean);
                        break;
                    case "土地":
                        fullPlanData = isFullLandData(tjtunityTwoBean);
                        break;
                    case "注册型企业":
                        fullPlanData = isFullZhucData(tjtunityTwoBean);
                        break;
                }
                if (!fullPlanData) {
                    return;
                }
            }
            if (fullPlanData) {
                dataSave();
                Intent intent = new Intent(this, TjTunityThreeAc.class);
                intent.putExtra("keyId", getIntent().getStringExtra("keyId"));
                intent.putExtra("opportunityId", getIntent().getStringExtra("opportunityId"));
                intent.putExtra("tagState", getIntent().getStringExtra("tagState"));
                startActivity(intent);
            }
        } else {
            ToastUtils.showToast(this, "请选择至少一种需求类型");
        }
    }

    //是否填充土地数据
    private boolean isFullLandData(TjtunityTwoBean tjtunityTwoBean) {
        if (TextUtils.isEmpty(tjtunityTwoBean.getLad_mj())) {
            ToastUtils.showToast(this, "请填写土地面积");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getLad_qw_Id())) {
            ToastUtils.showToast(this, "请选择土地区位要求");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getLad_xz_Id())) {
            ToastUtils.showToast(this, "请选择土地性质");
            return false;
        }
        return true;
    }

    //是否填充研发数据
    private boolean isFullWorkData(TjtunityTwoBean tjtunityTwoBean) {
        if (TextUtils.isEmpty(tjtunityTwoBean.getWork_ld_ID())) {
            ToastUtils.showToast(this, "请选择研发办公落地形式");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getWork_mj())) {
            ToastUtils.showToast(this, "请填写研发办公面积");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getWork_qw_ID())) {
            ToastUtils.showToast(this, "请选择研发办公区位要求");
            return false;
        }
        return true;
    }

    //是否填充注册数据
    private boolean isFullZhucData(TjtunityTwoBean tjtunityTwoBean) {
        if (TextUtils.isEmpty(tjtunityTwoBean.getZhuc_class_ID())) {
            ToastUtils.showToast(this, "请选择企业类型");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getZhuc_money())) {
            ToastUtils.showToast(this, "请填写注册型企业资金");
            return false;
        }

        return true;
    }

    //是否填充土地数据
    private boolean isFullPlanData(TjtunityTwoBean tjtunityTwoBean) {
        if (TextUtils.isEmpty(tjtunityTwoBean.getPlan_ld_ID())) {
            ToastUtils.showToast(this, "请选择厂房落地形式");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getPlan_mj())) {
            ToastUtils.showToast(this, "请填写厂房面积");
            return false;
        }

        if (TextUtils.isEmpty(tjtunityTwoBean.getPlan_qw_ID())) {
            ToastUtils.showToast(this, "请选择厂房区位要求");
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                    plan_ld.setTextColor(getResources().getColor(R.color.black));
                    plan_ld.setText(data.getStringExtra("value"));
                    plan_ld_ID = data.getStringExtra("valueId");
                }
                break;
            case Constants.Plan_Qw:
                if (resultCode == Constants.Plan_Qw && data != null) {
                    plan_qw.setTextColor(getResources().getColor(R.color.black));
                    plan_qw.setText(data.getStringExtra("value"));
                    plan_qw_ID = data.getStringExtra("valueId");
                }

                break;
            case Constants.Zhuc_Class:
                if (resultCode == Constants.Zhuc_Class && data != null) {
                    zhuc_class.setTextColor(getResources().getColor(R.color.black));

                    zhuc_class.setText(data.getStringExtra("value"));
                    zhuc_class_ID = data.getStringExtra("valueId");
                }
                break;
            case Constants.Lad_Qw:
                if (resultCode == Constants.Lad_Qw && data != null) {
                    lad_qw.setTextColor(getResources().getColor(R.color.black));

                    lad_qw.setText(data.getStringExtra("value"));
                    lad_qw_Id = data.getStringExtra("valueId");
                }
                break;
            case Constants.Lad_Xz:
                if (resultCode == Constants.Lad_Xz && data != null) {
                    lad_xz.setTextColor(getResources().getColor(R.color.black));

                    lad_xz.setText(data.getStringExtra("value"));
                    lad_xz_Id = data.getStringExtra("valueId");
                }
                break;
            case Constants.Work_Ld:
                if (resultCode == Constants.Work_Ld && data != null) {
                    work_ld.setTextColor(getResources().getColor(R.color.black));

                    work_ld.setText(data.getStringExtra("value"));
                    work_ld_ID = data.getStringExtra("valueId");
                }

                break;
            case Constants.Work_Qw:
                if (resultCode == Constants.Work_Qw && data != null) {
                    work_qw.setTextColor(getResources().getColor(R.color.black));

                    work_qw.setText(data.getStringExtra("value"));
                    work_qw_ID = data.getStringExtra("valueId");
                }

                break;
        }
    }

    private void addSelectView(ArrayList<NeedBean> list) {
        for (NeedBean bean : list) {
            if (bean.isCheack()) {
                switch (bean.getContent()) {
                    case "厂房":
                        //清楚view
                        llClass.addView(plant);
                        break;
                    case "研发办公":
                        llClass.addView(work);
                        break;
                    case "土地":
                        llClass.addView(land);
                        break;
                    case "注册型企业":
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
                llClass.removeView(plant);

                deleBack("厂房");
                break;
            case R.id.work_dele:
                llClass.removeView(work);
                deleBack("研发办公");
                break;
            case R.id.lad_dele:
                llClass.removeView(land);
                deleBack("土地");
                break;
            case R.id.zhuc_dele:
                llClass.removeView(zhuc);
                deleBack("注册型企业");
                break;

            case R.id.plan_ld:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "落地形式")
                        .putExtra("basicsType", "11"), Constants.Plan_Ld);
                break;
            case R.id.plan_qw:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "区位要求")
                        .putExtra("basicsType", "12"), Constants.Plan_Qw);
                break;
            case R.id.zhuc_class:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "企业类型")
                        .putExtra("basicsType", "17"), Constants.Zhuc_Class);
                break;
            case R.id.lad_qw:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "区位要求")
                        .putExtra("basicsType", "15"), Constants.Lad_Qw);//15
                break;
            case R.id.lad_xz:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "土地性质")
                        .putExtra("basicsType", "16"), Constants.Lad_Xz);
                break;
            case R.id.work_ld:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "落地形式")
                        .putExtra("basicsType", "13"), Constants.Work_Ld);
                break;
            case R.id.work_qw:
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "区位要求")
                        .putExtra("basicsType", "14"), Constants.Work_Qw);//14
                break;
        }
    }

    private void deleBack(String tag) {
        for (int i = 0; i < needBack.size(); i++) {
            if (needBack.get(i).getContent().equals(tag)) {
                needBack.remove(i);
            }
        }

        switch (tag) {
            case "厂房":
                //清楚view 缓存的数据
                plan_ld.setText("选择落地形式");
                plan_ld_ID = plan_qw_ID = "";
                plan_mj.setText("");
                plan_qw.setText("选择区位");

                plan_ld.setTextColor(getResources().getColor(R.color.grenn));
                plan_qw.setTextColor(getResources().getColor(R.color.grenn));
                break;
            case "研发办公":
                //清楚view 缓存的数据
                work_ld.setText("选择落地形式");
                work_ld_ID = work_qw_ID = "";
                work_mj.setText("");
                work_qw.setText("选择区位");

                work_ld.setTextColor(getResources().getColor(R.color.grenn));
                work_qw.setTextColor(getResources().getColor(R.color.grenn));
                break;
            case "土地":
                //清楚view 缓存的数据
                lad_qw.setText("选择区位");
                lad_qw_Id = lad_xz_Id = "";
                lad_mj.setText("");
                lad_xz.setText("选择土地");

                lad_qw.setTextColor(getResources().getColor(R.color.grenn));
                lad_xz.setTextColor(getResources().getColor(R.color.grenn));
                break;
            case "注册型企业":
                //清楚view 缓存的数据
                zhuc_class.setText("选择企业类型");
                zhuc_class_ID = "";
                zhuc_money.setText("");

                zhuc_class.setTextColor(getResources().getColor(R.color.grenn));
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSave();

    }

    private void dataSave() {
        //View缓存
        if (needBack.size() > 0) {
            SPUtils.put(this, "TjTunityTwoAc", JsonUtil.getGson().toJson(needBack));
        } else {
            SPUtils.remove(this, "TjTunityTwoAc");
        }

        //数据缓存
        if (needBack.size() > 0 || !TextUtils.isEmpty(etExplan.getText().toString())) {
            SPUtils.put(this, "tjtunityTwoBean", JsonUtil.getGson().toJson(seveData(), TjtunityTwoBean.class));
        }
    }


    @NonNull
    private TjtunityTwoBean seveData() {
        TjtunityTwoBean tjtunityTwoBean = new TjtunityTwoBean();

        tjtunityTwoBean.setPlan_ld(TextUtils.isEmpty(plan_ld_ID) ? "" : plan_ld.getText().toString());
        tjtunityTwoBean.setPlan_ld_ID(plan_ld_ID);
        tjtunityTwoBean.setPlan_qw(TextUtils.isEmpty(plan_qw_ID) ? "" : plan_qw.getText().toString());
        tjtunityTwoBean.setPlan_qw_ID(plan_qw_ID);
        tjtunityTwoBean.setPlan_mj(plan_mj.getText().toString());
        tjtunityTwoBean.setZhuc_money(zhuc_money.getText().toString());
        tjtunityTwoBean.setZhuc_class(TextUtils.isEmpty(zhuc_class_ID) ? "" : zhuc_class.getText().toString());
        tjtunityTwoBean.setZhuc_class_ID(zhuc_class_ID);
        tjtunityTwoBean.setLad_qw(TextUtils.isEmpty(lad_qw_Id) ? "" : lad_qw.getText().toString());
        tjtunityTwoBean.setLad_qw_Id(lad_qw_Id);
        tjtunityTwoBean.setLad_xz(TextUtils.isEmpty(lad_xz_Id) ? "" : lad_xz.getText().toString());
        tjtunityTwoBean.setLad_xz_Id(lad_xz_Id);
        tjtunityTwoBean.setLad_mj(lad_mj.getText().toString());
        tjtunityTwoBean.setWork_ld(TextUtils.isEmpty(work_ld_ID) ? "" : work_ld.getText().toString());
        tjtunityTwoBean.setWork_ld_ID(work_ld_ID);
        tjtunityTwoBean.setWork_qw(TextUtils.isEmpty(work_qw_ID) ? "" : work_qw.getText().toString());
        tjtunityTwoBean.setWork_qw_ID(work_qw_ID);
        tjtunityTwoBean.setWork_mj(work_mj.getText().toString());
        tjtunityTwoBean.setEtExplan(etExplan.getText().toString());
        return tjtunityTwoBean;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        etNum.setText(s.length() + "/300");
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
