package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.RlTunityPopBean;
import com.lingang.bean.TjTunityOneBean;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.bean.TjtunityTwoBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.DialogOnclinck;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwo;
import com.lingang.dialog.GroomDialog;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.JsonUtil;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class PreviewAc extends BaseAc implements DialogOnclinck {

    @BindView(R.id.tv_khname)
    TextView tvKhname;
    @BindView(R.id.tv_khcall)
    TextView tvKhcall;
    @BindView(R.id.tv_khnexus)
    TextView tvKhnexus;
    @BindView(R.id.tv_khch)
    TextView tvKhch;
    @BindView(R.id.tv_khmails)
    TextView tvKhmails;
    @BindView(R.id.tv_qystate)
    TextView tvQystate;
    @BindView(R.id.tv_qyname)
    TextView tvQyname;
    @BindView(R.id.tv_qykey)
    TextView tvQykey;
    @BindView(R.id.tv_plantld)
    TextView tvPlantld;
    @BindView(R.id.tv_plantxq)
    TextView tvPlantxq;
    @BindView(R.id.tv_plantqw)
    TextView tvPlantqw;
    @BindView(R.id.tv_landmj)
    TextView tvLandmj;
    @BindView(R.id.tv_landqw)
    TextView tvLandqw;
    @BindView(R.id.tv_landxz)
    TextView tvLandxz;
    @BindView(R.id.tv_zhucqy)
    TextView tvZhucqy;
    @BindView(R.id.tv_zhuczj)
    TextView tvZhuczj;
    @BindView(R.id.tv_zhucsm)
    TextView tvZhucsm;
    @BindView(R.id.tv_tjyq)
    TextView tvTjyq;
    @BindView(R.id.btn_comit)
    Button btnComit;
    @BindView(R.id.ll_company)
    LinearLayout llCompany;
    @BindView(R.id.ll_plan)
    LinearLayout llPlan;
    @BindView(R.id.tv_work_ld)
    TextView tvWorkLd;
    @BindView(R.id.tv_work_mj)
    TextView tvWorkMj;
    @BindView(R.id.tv_work_qw)
    TextView tvWorkQw;
    @BindView(R.id.ll_work)
    LinearLayout llWork;
    @BindView(R.id.ll_land)
    LinearLayout llLand;
    @BindView(R.id.ll_zhuc)
    LinearLayout llZhuc;
    private ArrayList<TjTunityThreeBean.DataMapBean.ParkListBean> tjTunityThreeList;
    private String parkId;
    private GroomDialog groomDialog;
    private DialogOnclinck linck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_preview);
        linck = this;
        setTitle("预览商机");
        setData();
    }

    private void setData() {
        String tjTunityone = (String) SPUtils.get(this, "TjTunityOneBean", "");
        if (!TextUtils.isEmpty(tjTunityone)) {
            TjTunityOneBean tjTunityOneBean = JsonUtil.getGson().fromJson(tjTunityone, TjTunityOneBean.class);

            if (TextUtils.isEmpty(tjTunityOneBean.getCompanyName()))
                llCompany.setVisibility(View.GONE);

            fillData(tvKhname, tjTunityOneBean.getName());
            fillData(tvKhcall, tjTunityOneBean.getPhone());
            fillData(tvKhnexus, tjTunityOneBean.getNexus());
            fillData(tvKhch, tjTunityOneBean.getCall());
            fillData(tvKhmails, tjTunityOneBean.getMailBox());

            fillData(tvQystate, tjTunityOneBean.isZhuc() ? "已注册" : "未注册");
            fillData(tvQyname, tjTunityOneBean.getCompanyName());
            fillData(tvQykey, tjTunityOneBean.getCompanyLable());

            fillData(tvKhch, tjTunityOneBean.getCall());
            fillData(tvKhmails, tjTunityOneBean.getMailBox());
        }

        String tjTunitytwo = (String) SPUtils.get(this, "tjtunityTwoBean", "");
        if (!TextUtils.isEmpty(tjTunitytwo)) {
            TjtunityTwoBean tjtunityTwoBean = JsonUtil.getGson().fromJson(tjTunitytwo, TjtunityTwoBean.class);

            if (TextUtils.isEmpty(tjtunityTwoBean.getPlan_ld()))
                llPlan.setVisibility(View.GONE);

            if (TextUtils.isEmpty(tjtunityTwoBean.getZhuc_money()))
                llZhuc.setVisibility(View.GONE);

            if (TextUtils.isEmpty(tjtunityTwoBean.getWork_mj()))
                llWork.setVisibility(View.GONE);

            if (TextUtils.isEmpty(tjtunityTwoBean.getLad_mj()))
                llLand.setVisibility(View.GONE);

            String plan_Mj = splitPoint(tjtunityTwoBean.getPlan_mj());
            tvPlantxq.setText(plan_Mj + "平方米");
            fillData(tvPlantld, tjtunityTwoBean.getPlan_ld());
            fillData(tvPlantqw, tjtunityTwoBean.getPlan_qw());

            String LandMj = splitPoint(tjtunityTwoBean.getLad_mj());
            tvLandmj.setText(LandMj + "亩");
            fillData(tvLandqw, tjtunityTwoBean.getLad_qw());
            fillData(tvLandxz, tjtunityTwoBean.getLad_xz());

            fillData(tvZhucqy, tjtunityTwoBean.getZhuc_class());
            fillData(tvZhucsm, tjtunityTwoBean.getEtExplan());
            String Zhucmoney = splitPoint(tjtunityTwoBean.getZhuc_money());
            tvZhuczj.setText(Zhucmoney + "万元");

            fillData(tvWorkLd, tjtunityTwoBean.getWork_ld());
            String WorkMj = splitPoint(tjtunityTwoBean.getWork_mj());
            fillData(tvWorkQw, tjtunityTwoBean.getWork_qw());
            tvWorkMj.setText(WorkMj + "平方米");
        }

        String tjTunityThree = (String) SPUtils.get(this, "TjTunityThree", "");
        if (!TextUtils.isEmpty(tjTunityThree)) {
            tjTunityThreeList = JsonUtil.getGson().fromJson(tjTunityThree, new TypeToken<ArrayList<TjTunityThreeBean.DataMapBean.ParkListBean>>() {
            }.getType());

            for (int i = 0; i < tjTunityThreeList.size(); i++) {
                TjTunityThreeBean.DataMapBean.ParkListBean parkListBean = tjTunityThreeList.get(i);
                if (i == 0) {
                    tvTjyq.setText(parkListBean.getParkName());
                } else {
                    tvTjyq.setText(tvTjyq.getText() + "、" + parkListBean.getParkName());
                }
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

    private void fillData(TextView tv, String content) {
        tv.setText(TextUtils.isEmpty(content) ? "无" : content);
    }

    @OnClick({R.id.btn_et, R.id.btn_comit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_et:
                startActivity(new Intent(this, TjTunityOneAc.class)
                        .putExtra("tag", "preview"));
                break;
            case R.id.btn_comit:
                btnComit.setEnabled(false);
                String userType = LoginManager.getInstance().getUserInfo().getUserType();
                if (userType.equals("1")) {//1、园区招商员
                    getOpportunityUserParkList();
                } else {
                    addOpportunity();
                }
                break;
        }
    }

    //获取招商员 园区
    private void getOpportunityUserParkList() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.getOpportunityUserParkList)
                .params(httpParams)
                .execute(new ResCallBack<RlTunityPopBean>(this) {
                    @Override
                    public void onCall(RlTunityPopBean cluster, Call call, Response response) {
                        List<ParkUserListBean> parkUserList = cluster.getDataMap().getParkUserList();
                        if (parkUserList.size() > 0) {
                            if (groomDialog == null)
                                groomDialog = new GroomDialog(PreviewAc.this, linck);
                            groomDialog.setData(parkUserList);
                            groomDialog.setTitle("鉴于您同时属于以下园区的招商团队，请选择待发布审核的园区");
                            groomDialog.show();
                        }
//                        else if (parkUserList.size() > 0) {
//                            parkId = parkUserList.get(0).getParkId();
//                            addOpportunity();
//                        }
                        else {
                            ToastUtils.showToast(PreviewAc.this, "无所属园区，请联系管理员");
                        }
                        btnComit.setEnabled(true);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        btnComit.setEnabled(true);
                    }
                });

    }

    @Override
    public void dialogOnclicCall(String id, String value) {
        parkId = id;
        addOpportunity();
    }


    //推荐商机
    private void addOpportunity() {
        String tjTunityone = (String) SPUtils.get(this, "TjTunityOneBean", "");
        String tjtunitytwo = (String) SPUtils.get(this, "tjtunityTwoBean", "");

        Gson gson = JsonUtil.getGson();
        TjTunityOneBean tjTunityOneBean = gson.fromJson(tjTunityone, TjTunityOneBean.class);
        TjtunityTwoBean tjtunityTwoBean = gson.fromJson(tjtunitytwo, TjtunityTwoBean.class);


        HttpParams httpParams = new HttpParams();
        httpParams.put("customerName", tjTunityOneBean.getName());//客户名称
        httpParams.put("customerTel", tjTunityOneBean.getPhone());//客户电话
        httpParams.put("customerCallId", tjTunityOneBean.getCallId());//称呼
        httpParams.put("customerRelationshipId", tjTunityOneBean.getNexusId());//客户关系
        httpParams.put("customerMail", tjTunityOneBean.getMailBox());//客户邮箱
        httpParams.put("customerEnterpriseIsregister", tjTunityOneBean.isZhuc() ? "1" : "0");//0、未注册1、已注册
        httpParams.put("customerEnterpriseName", tjTunityOneBean.getCompanyName());//企业名称
        httpParams.put("customerEnterpriseKeywords", tjTunityOneBean.getCompanyLable());//企业关键字

        String planMj = splitPoint(tjtunityTwoBean.getPlan_mj());
        httpParams.put("workshopArea", planMj);//厂房面积需求
        httpParams.put("workshopTypeId", tjtunityTwoBean.getPlan_ld_ID());//厂房落地形式
        httpParams.put("workshopLocationId", tjtunityTwoBean.getPlan_qw_ID());//厂房区位要求

        httpParams.put("officeTypeId", tjtunityTwoBean.getWork_ld_ID());//研发办公的落地形式
        String workMj = splitPoint(tjtunityTwoBean.getWork_mj());
        httpParams.put("officeArea", workMj);//研发办公的面积需求(平方米)
        httpParams.put("officeLocationId", tjtunityTwoBean.getWork_qw_ID());//研发办公的区位要求

        String landMj = splitPoint(tjtunityTwoBean.getLad_mj());
        httpParams.put("landArea", landMj);//土地面积需求（亩
        httpParams.put("landLocation", tjtunityTwoBean.getLad_qw_Id());//土地区位要求
        httpParams.put("landType", tjtunityTwoBean.getLad_xz_Id());//土地性质

        httpParams.put("registeredEnterpriseType", tjtunityTwoBean.getZhuc_class_ID());//注册型企业类型
        String zhucMoney = splitPoint(tjtunityTwoBean.getZhuc_money());
        httpParams.put("registeredEnterpriseMoney", zhucMoney);//注册型企业注册资金（万元）

        httpParams.put("supplementaryNotes", tjtunityTwoBean.getEtExplan());//需求补充说明
        httpParams.put("parkId", parkId);//招商员所属园区id

        if (getIntent().getStringExtra("tagState").equals("edit")){
            httpParams.put("opportunityId", getIntent().getStringExtra("opportunityId"));
            httpParams.put("keyId", getIntent().getStringExtra("keyId"));
        }

        httpParams.put("opportunityState", getIntent().getStringExtra("tagState").equals("edit") ? "19" : "0");//0、新增 19、撤回重发


        StringBuffer parkIds = new StringBuffer();
        for (int i = 0; i < tjTunityThreeList.size(); i++) {
            TjTunityThreeBean.DataMapBean.ParkListBean parkListBean = tjTunityThreeList.get(i);
            if (parkIds.length() == 0) {
                parkIds.append(parkListBean.getParkId());
            } else {
                parkIds.append("," + parkListBean.getParkId());
            }
        }
        httpParams.put("parkIds", parkIds.toString());//选择园区（例：parkId,parkId,parkId）
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addOpportunity)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String cluster, Call call, Response response) {
                        btnComit.setEnabled(true);
//                        String userType = LoginManager.getInstance().getUserInfo().getUserType();
//                        if (userType.equals("1") || userType.equals("3") || userType.equals("4")) {
//                            startActivity(new Intent(PreviewAc.this, SendSuccessAc.class));
//                        } else {
                            startActivity(new Intent(PreviewAc.this, SendSuccessParkAc.class).putExtra("list", tjTunityThreeList));
//                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        btnComit.setEnabled(true);
                    }
                });

    }
}
