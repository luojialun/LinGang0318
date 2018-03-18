package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.adapter.OppDetailsAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppHistory;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.RlSuccessBean;
import com.lingang.bean.RlTunityPopBean;
import com.lingang.bean.TunityDetailesBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.DialogOnclinck;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwo;
import com.lingang.dialog.GroomDialog;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.vector.update_app.utils.DrawableUtil;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class RlTunityDetailesAc extends BaseAc implements DialogOnclinck, DialogConfirmListion {

    @BindView(R.id.outdate_tv)
    TextView outdateTv;

    @BindView(R.id.tv_perclass)
    TextView tvPerclass;
    @BindView(R.id.tv_per)
    TextView tvPer;
    @BindView(R.id.tv_data)
    TextView tvData;
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
    @BindView(R.id.tv_work_ld)
    TextView tvWorkLd;
    @BindView(R.id.tv_work_mj)
    TextView tvWorkMj;
    @BindView(R.id.tv_work_qw)
    TextView tvWorkQw;
    @BindView(R.id.ll_company)
    LinearLayout llCompany;
    @BindView(R.id.ll_work)
    LinearLayout llWork;
    @BindView(R.id.ll_plan)
    LinearLayout llPlan;
    @BindView(R.id.ll_land)
    LinearLayout llLand;
    @BindView(R.id.ll_zhuc)
    LinearLayout llZhuc;
    @BindView(R.id.btn_rl)
    Button btnRl;
    @BindView(R.id.opp_state_tab)
    TextView oppStateTab;
    @BindView(R.id.state_btn)
    TextView stateBtn;
    @BindView(R.id.flow_details_rv)
    RecyclerView flowDetailsRv;
    @BindView(R.id.guiji_rl)
    RelativeLayout guijiRl;
    @BindView(R.id.ll_lc)
    LinearLayout llLc;
    @BindView(R.id.ll_per)
    LinearLayout llPer;
    private GroomDialog groomDialog;
    private DialogOnclinck linck;
    private DialogTwo dialogTwo;
    private String recommendUserAccount, opportunityId, parkId, keyId;
    private OppDetailsAdapter oppAdapter;
    private List<OppHistory> oppHistoryList;
    private String showState = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_rl_tunity_detailes);
        setTitle("商机详情");

        String isactive = getIntent().getStringExtra("isactive");
        showState = getIntent().getStringExtra("showState");
        if (!TextUtils.isEmpty(isactive) && !isactive.equals("1")) {
            btnRl.setVisibility(View.GONE);
        }

        if ("0".equals(isactive)) {
            outdateTv.setVisibility(View.VISIBLE);
        }

        linck = this;
        opportunityDetail();
    }

    //商机详情
    private void opportunityDetail() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("keyId", getIntent().getStringExtra("id"));
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.opportunity_detail)
                .params(httpParams)
                .execute(new ResCallBack<TunityDetailesBean>(this) {
                    @Override
                    public void onCall(TunityDetailesBean cluster, Call call, Response response) {
                        TunityDetailesBean.DataBean data = cluster.getData();
                        opportunityId = data.getOpportunityId();
                        keyId = data.getKeyId();
                        String userType = LoginManager.getInstance().getUserInfo().getUserType();
                        if (userType.equals("3") || userType.equals("4") || userType.equals("5")) {
                            queryOpportunityHistory(keyId);
                        }

                        if (!TextUtils.isEmpty(data.getOpportunityLevel())) {
                            tvPerclass.setVisibility(View.VISIBLE);
                            tvPerclass.setText(data.getOpportunityLevel() + "类");
                        }

                        if (TextUtils.isEmpty(data.getWorkshopTypeName()))
                            llPlan.setVisibility(View.GONE);//厂房

//                        if (TextUtils.isEmpty(data.getCustomerEnterpriseName()))
//                            llCompany.setVisibility(View.GONE);

                        if (TextUtils.isEmpty(data.getRegisteredEnterpriseMoney()))
                            llZhuc.setVisibility(View.GONE);//注册型企业

                        if (TextUtils.isEmpty(data.getOfficeArea()))
                            llWork.setVisibility(View.GONE);//研发办公

                        if (TextUtils.isEmpty(data.getLandLocation()))
                            llLand.setVisibility(View.GONE);//土地

                        recommendUserAccount = data.getRecommendUserAccount();
                        tvData.setText(DateUtils.getTimes(data.getIntroduceDate(), "yyyy-MM-dd   HH:mm"));

                        fillData(tvPer, data.getRecommendUserName());
                        fillData(tvQystate, data.getCustomerEnterpriseIsregister().equals("0") ? "未注册" : "已注册");
                        tvQyname.setText(TextUtils.isEmpty(data.getCustomerEnterpriseName()) ? "未注册企业" : data.getCustomerEnterpriseName());
                        fillData(tvQykey, data.getCustomerEnterpriseKeywords());
                        fillData(tvPlantld, data.getWorkshopTypeName());

                        String workshopArea = splitPoint(data.getWorkshopArea());
                        tvPlantxq.setText(TextUtils.isEmpty(workshopArea) ? "无" : workshopArea + "平方米");
                        fillData(tvPlantqw, data.getWorkshopLocationName());

                        String landArea = splitPoint(data.getLandArea());
                        tvLandmj.setText(TextUtils.isEmpty(landArea) ? "无" : landArea + "亩");
                        fillData(tvLandqw, data.getLandLocationName());
                        fillData(tvLandxz, data.getLandTypeName());

                        fillData(tvZhucqy, data.getRegisteredEnterpriseTypeName());
                        String money = splitPoint(data.getRegisteredEnterpriseMoney());
                        tvZhuczj.setText(TextUtils.isEmpty(money) ? "无" : money + "万元");

                        fillData(tvWorkLd, data.getOfficeTypeName());
                        String officeArea = splitPoint(data.getOfficeArea());
                        fillData(tvWorkMj, TextUtils.isEmpty(officeArea) ? "" : officeArea + "平方米");
                        fillData(tvWorkQw, data.getOfficeLocationName());

                        fillData(tvZhucsm, data.getSupplementaryNotes());

                        List<TunityDetailesBean.DataBean.OpportunityParksBean> opportunityParks = data.getOpportunityParks();

                        if (opportunityParks.size() == 0) {
                            fillData(tvTjyq, "");
                        }
                        for (int i = 0; i < opportunityParks.size(); i++) {
                            if (i == 0) {
                                tvTjyq.setText(opportunityParks.get(i).getParkName());
                            } else {
                                tvTjyq.setText(tvTjyq.getText() + "、" + opportunityParks.get(i).getParkName());
                            }

                        }
                    }
                });

    }


    /**
     * 获取商机轨迹
     */
    public void queryOpportunityHistory(String keyId) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keyId", keyId);
        OkGo.post(HttpApi.query_opportunity_history)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<List<OppHistory>, Object>>(this, false) {
                    @Override
                    public void onCall(BaseEntity<List<OppHistory>, Object> oppHistoryEntity, Call call, Response response) throws JSONException {
                        List<OppHistory> historyList = oppHistoryEntity.getData();
                        if (historyList != null) {
                            initHistory();
                            oppHistoryList.clear();
                            llLc.setVisibility(View.VISIBLE);

                            if (showState.equals("9")) {
                                stateBtn.setText(Constants.BACK);
                                DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(R.color.c5c5c5));
                            } else if (showState.equals("1") || showState.equals("2")) {
                                stateBtn.setText("待认领");
                                DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(R.color.c_7eb2ec));
                            }


                            oppHistoryList.addAll(historyList);
                            oppAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    private void initHistory() {
        oppHistoryList = new ArrayList<>();
        flowDetailsRv.setNestedScrollingEnabled(false);
        flowDetailsRv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        flowDetailsRv.setLayoutManager(layoutManager);
        oppAdapter = new OppDetailsAdapter(this, oppHistoryList);
        flowDetailsRv.setAdapter(oppAdapter);
    }

    @OnClick({R.id.opp_state_tab})
    public void onViewClicked() {
        oppStateTab.setSelected(!oppStateTab.isSelected());
        guijiRl.setVisibility(oppStateTab.isSelected() ? View.GONE : View.VISIBLE);
    }

    /**
     * 没数据时候替换为无
     */
    private void fillData(TextView tv, String content) {
        tv.setText(TextUtils.isEmpty(content) ? "无" : content);
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

    @OnClick({R.id.btn_rl, R.id.ll_per})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_rl:

                if (dialogTwo == null)
                    dialogTwo = new DialogTwo(this, this);
                dialogTwo.show("认领商机", "认领商机后，该商机将转为由您负责执行的商机，请确认是否认领。", "认领", "取消");

                break;
            case R.id.ll_per:
                startActivity(new Intent(this, PersonInfoActivity.class)
                        .putExtra("userid", recommendUserAccount)
                        .putExtra("tag", "bendi"));
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
                        if (parkUserList.size() > 1) {
                            if (groomDialog == null)
                                groomDialog = new GroomDialog(RlTunityDetailesAc.this, linck);
                            groomDialog.setData(parkUserList);
                            groomDialog.setTitle("鉴于您同时属于以下园区的招商团队，请选择此次商机认领的园区。");
                            groomDialog.show();
                        } else if (parkUserList.size() > 0) {
                            parkId = parkUserList.get(0).getParkId();
                            executeNext();
                        } else {
                            ToastUtils.showToast(RlTunityDetailesAc.this, "无所属园区，请联系管理员");
                        }

                    }
                });

    }

    //认领商机
    private void executeNext() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("chooseParkId", parkId);
        httpParams.put("keyId", keyId);
        httpParams.put("opportunityId", opportunityId);
        httpParams.put("operateState", "6");
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.executeNext)
                .params(httpParams)
                .execute(new ResCallBack<RlSuccessBean>(this) {
                    @Override
                    public void onCall(RlSuccessBean cluster, Call call, Response response) {
                        Intent intent = new Intent(RlTunityDetailesAc.this, TunityResultAc.class);

                        if (llPlan.getVisibility() == View.GONE) {
                            intent.putExtra("plan", "0");
                        } else {
                            intent.putExtra("plan", "1");
                        }

                        if (llZhuc.getVisibility() == View.GONE) {
                            intent.putExtra("zhuc", "0");
                        } else {
                            intent.putExtra("zhuc", "1");
                        }

                        if (llWork.getVisibility() == View.GONE) {
                            intent.putExtra("work", "0");
                        } else {
                            intent.putExtra("work", "1");
                        }

                        if (llLand.getVisibility() == View.GONE) {
                            intent.putExtra("land", "0");
                        } else {
                            intent.putExtra("land", "1");
                        }


                        intent.putExtra(Constants.KEY_ID, cluster.getData().getKeyId());
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(RlTunityDetailesAc.this, "认领商机失败");
                    }
                });
    }

    @Override
    public void dialogOnclicCall(String id, String sign) {
        parkId = id;
        if (!TextUtils.isEmpty(opportunityId))
            executeNext();
    }

    @Override
    public void confirmClick(String sign) {
        String userType = LoginManager.getInstance().getUserInfo().getUserType();
        if (userType.equals("1") || userType.equals("2")) {//招商员  招商负责人
            getOpportunityUserParkList();
        } else {
            if (!TextUtils.isEmpty(opportunityId))
                executeNext();
        }
    }

}
