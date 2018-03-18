package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.adapter.SelectOtherAdapter;
import com.lingang.adapter.SelectYqAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.ParkUserListBean;
import com.lingang.bean.RlTunityPopBean;
import com.lingang.bean.TjTunityOneBean;
import com.lingang.bean.TjTunityThreeBean;
import com.lingang.bean.TjtunityTwoBean;
import com.lingang.callback.DialogOnclinck;
import com.lingang.common.LoginManager;
import com.lingang.dialog.GroomDialog;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.JsonUtil;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.ExtraListView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class TjTunityThreeAc extends BaseAc implements AdapterView.OnItemClickListener,
        DialogOnclinck, CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.img_yq)
    ImageView imgYq;
    @BindView(R.id.vv_line2)
    View vvLine2;
    @BindView(R.id.tv_yuanq)
    TextView tvYuanq;
    @BindView(R.id.lv_power)
    ExtraListView lvPower;
    @BindView(R.id.lv_other)
    ExtraListView lvOther;
    @BindView(R.id.img_xq_info)
    ImageView imgXqInfo;
    @BindView(R.id.tv_xuq)
    TextView tvXuq;
    @BindView(R.id.tv_power)
    TextView tvPower;
    @BindView(R.id.tv_other)
    TextView tvOther;
    @BindView(R.id.btn_comit)
    Button btnComit;
    @BindView(R.id.ll_power)
    LinearLayout llPower;
    @BindView(R.id.ll_other)
    LinearLayout llOther;
    @BindView(R.id.tv_power_all)
    TextView tvPowerAll;
    @BindView(R.id.tv_other_all)
    TextView tvOtherAll;
    private SelectYqAdapter powerYqAdapter;
    private SelectOtherAdapter otherYqAdapter;
    private ArrayList<TjTunityThreeBean.DataMapBean.RecommendListBean> recommendList;
    private ArrayList<TjTunityThreeBean.DataMapBean.ParkListBean> parkList;
    private ArrayList<TjTunityThreeBean.DataMapBean.ParkListBean> tuijEdList;
    private GroomDialog groomDialog;
    private DialogOnclinck linck;
    private String opportunityId, keyId, tagState, parkId;
    private boolean powerTag = false;
    private boolean otherTag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_tj_tunity_three);
        setTitle("推荐商机");
        setRightTv("规则");
        linck = this;
        keyId = getIntent().getStringExtra("keyId");
        opportunityId = getIntent().getStringExtra("opportunityId");
        tagState = getIntent().getStringExtra("tagState");
        initView();
    }

    private void initView() {
        imgYq.setImageResource(R.mipmap.ic_xuanzeyuanqu1);
        vvLine2.setBackgroundColor(getResources().getColor(R.color.line_sj));
        tvYuanq.setTextColor(getResources().getColor(R.color.black));

        imgXqInfo.setImageResource(R.mipmap.ic_xuqiuxinxi1);
        tvXuq.setTextColor(getResources().getColor(R.color.black));

        recommendList = new ArrayList<>();
        powerYqAdapter = new SelectYqAdapter(this, recommendList, this);
        lvPower.setAdapter(powerYqAdapter);
        lvPower.setOnItemClickListener(this);

        parkList = new ArrayList<>();
        otherYqAdapter = new SelectOtherAdapter(this, parkList, this);
        lvOther.setAdapter(otherYqAdapter);
        lvOther.setOnItemClickListener(this);

        selectAIParkRecommendsList();
    }

    private void selectAIParkRecommendsList() {
        String tjtunitytwo = (String) SPUtils.get(this, "tjtunityTwoBean", "");

        TjtunityTwoBean tjtunityTwoBean = JsonUtil.getGson().fromJson(tjtunitytwo, TjtunityTwoBean.class);

        ArrayList<String> ids = new ArrayList<>();

        if (!TextUtils.isEmpty(tjtunityTwoBean.getWork_qw_ID())) {
            ids.add(tjtunityTwoBean.getWork_qw_ID());
        }

        if (!TextUtils.isEmpty(tjtunityTwoBean.getPlan_qw_ID())) {
            ids.add(tjtunityTwoBean.getPlan_qw_ID());
        }

        if (!TextUtils.isEmpty(tjtunityTwoBean.getLad_qw_Id())) {
            ids.add(tjtunityTwoBean.getLad_qw_Id());
        }

        StringBuffer locationIds = new StringBuffer();
        for (int i = 0; i < ids.size(); i++) {
            if (locationIds.length() == 0) {
                locationIds.append(ids.get(i));
            } else {
                locationIds.append("," + ids.get(i));
            }
        }


        HttpParams httpParams = new HttpParams();
        httpParams.put("locationIds", locationIds.toString());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.selectAIParkRecommendsList)
                .params(httpParams)
                .execute(new ResCallBack<TjTunityThreeBean>(this) {
                    @Override
                    public void onCall(TjTunityThreeBean cluster, Call call, Response response) {

                        TjTunityThreeBean.DataMapBean dataMap = cluster.getDataMap();
                        if (dataMap.getRecommendList() != null)
                            recommendList.addAll(dataMap.getRecommendList());
                        if (dataMap.getParkList() != null)
                            parkList.addAll(dataMap.getParkList());
                        if (recommendList.size() > 0) {
                            changeState(true);
                            llPower.setVisibility(View.VISIBLE);
                            lvPower.setVisibility(View.VISIBLE);
                        } else {
                            llPower.setVisibility(View.GONE);
                            lvPower.setVisibility(View.GONE);
                        }

                        if (parkList.size() > 0) {
                            otherYqAdapter.notifyDataSetChanged();
                            llOther.setVisibility(View.VISIBLE);
                            lvOther.setVisibility(View.VISIBLE);
                        } else {
                            llOther.setVisibility(View.GONE);
                            lvOther.setVisibility(View.GONE);
                        }
                    }
                });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ChanYeDetailsAc.class);
        switch (parent.getId()) {
            case R.id.lv_power:
                intent.putExtra("id", recommendList.get(position).getParkId());
                break;
            case R.id.lv_other:
                intent.putExtra("id", parkList.get(position).getParkId());
                break;
        }
        startActivity(intent);
    }

    @OnClick({R.id.btn_look, R.id.btn_comit, R.id.tv_power_all, R.id.tv_other_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_look:
                if (isSelectYuanQ()) {
                    Intent intent = new Intent(this, PreviewAc.class);
                    intent.putExtra("keyId", keyId);
                    intent.putExtra("opportunityId", opportunityId);
                    intent.putExtra("tagState", tagState);
                    startActivity(intent);
                } else {
                    ToastUtils.showToast(this, "请至少选择一个园区");
                }
                break;
            case R.id.btn_comit:
                if (isSelectYuanQ()) {
                    btnComit.setEnabled(false);
                    String userType = LoginManager.getInstance().getUserInfo().getUserType();
                    if (userType.equals("1")) {//1、园区招商员
                        getOpportunityUserParkList();
                    } else {
                        addOpportunity();
                    }
                } else {
                    ToastUtils.showToast(this, "请至少选择一个园区");
                }
                break;
            case R.id.tv_power_all:
                if (recommendList.size() > 0) {
                    if (powerTag) {
                        tvPowerAll.setText("取消全选");
                        changeState(true);
                    } else {
                        tvPowerAll.setText("全选");
                        changeState(false);
                    }
                    powerTag = !powerTag;

                }
                break;
            case R.id.tv_other_all:

                if (parkList.size() > 0) {
                    if (otherTag) {
                        tvOtherAll.setText("取消全选");
                        for (TjTunityThreeBean.DataMapBean.ParkListBean power :
                                parkList) {
                            power.setChe(true);
                        }
                        otherYqAdapter.notifyDataSetChanged();
                    } else {
                        tvOtherAll.setText("全选");
                        for (TjTunityThreeBean.DataMapBean.ParkListBean power :
                                parkList) {
                            power.setChe(false);
                        }
                        otherYqAdapter.notifyDataSetChanged();
                    }
                    otherTag = !otherTag;
                }
                break;
        }
    }

    private void changeState(boolean che) {
        for (TjTunityThreeBean.DataMapBean.RecommendListBean power :
                recommendList) {
            power.setChe(che);
        }

        powerYqAdapter.notifyDataSetChanged();
    }

    private boolean isSelectYuanQ() {
        int isSelect = 0;
        for (TjTunityThreeBean.DataMapBean.RecommendListBean recommendListBean :
                recommendList) {
            if (recommendListBean.isChe()) {
                isSelect++;
            }
        }

        for (TjTunityThreeBean.DataMapBean.ParkListBean parkListBean :
                parkList) {
            if (parkListBean.isChe()) {
                isSelect++;
            }
        }
        if (isSelect > 0) {
            return true;
        } else {
            return false;
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
                        btnComit.setEnabled(true);
                        List<ParkUserListBean> parkUserList = cluster.getDataMap().getParkUserList();
                        if (parkUserList.size() > 0) {
                            if (groomDialog == null)
                                groomDialog = new GroomDialog(TjTunityThreeAc.this, linck);
                            groomDialog.setData(parkUserList);
                            groomDialog.setTitle("鉴于您同时属于以下园区的招商团队，请选择待发布审核的园区");
                            groomDialog.show();
                        }
//                        else if (parkUserList.size() > 0) {
//                            parkId = parkUserList.get(0).getParkId();
//                            addOpportunity();
//                        }
                        else {
                            ToastUtils.showToast(TjTunityThreeAc.this, "无所属园区，请联系管理员");
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        btnComit.setEnabled(true);
                    }
                });

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
        if (tagState.equals("edit")){
            httpParams.put("opportunityId", opportunityId);
            httpParams.put("keyId", keyId);
        }
        httpParams.put("opportunityState", tagState.equals("edit") ? "19" : "0");//0、新增 19、撤回重发

        if (tuijEdList == null) {
            tuijEdList = new ArrayList<>();
        } else {
            tuijEdList.clear();
        }

        StringBuffer parkIds = new StringBuffer();
        for (int i = 0; i < recommendList.size(); i++) {
            TjTunityThreeBean.DataMapBean.RecommendListBean recommendListBean = recommendList.get(i);
            if (recommendListBean.isChe()) {
                if (tuijEdList != null) {
                    TjTunityThreeBean.DataMapBean.ParkListBean parkListBean = new TjTunityThreeBean.DataMapBean.ParkListBean();
                    parkListBean.setParkId(recommendListBean.getParkId());
                    parkListBean.setParkName(recommendListBean.getParkName());
                    tuijEdList.add(parkListBean);
                }

                if (parkIds.length() == 0) {
                    parkIds.append(recommendListBean.getParkId());
                } else {
                    parkIds.append("," + recommendListBean.getParkId());
                }
            }
        }

        for (int i = 0; i < parkList.size(); i++) {
            TjTunityThreeBean.DataMapBean.ParkListBean parkListBean = parkList.get(i);
            if (parkListBean.isChe()) {
                if (tuijEdList != null) {
                    tuijEdList.add(parkListBean);
                }

                if (parkIds.length() == 0) {
                    parkIds.append(parkListBean.getParkId());
                } else {
                    parkIds.append("," + parkListBean.getParkId());
                }

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
//                            startActivity(new Intent(TjTunityThreeAc.this, SendSuccessAc.class));
                        startActivity(new Intent(TjTunityThreeAc.this, SendSuccessParkAc.class)
                                .putExtra("list", tuijEdList));
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        btnComit.setEnabled(true);
                    }
                });

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

    @Override
    public void dialogOnclicCall(String id, String value) {
        parkId = id;
        addOpportunity();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String tag = (String) buttonView.getTag();
        String[] split = tag.split("\\|");
        if (split[0].equals("Other")) {
            parkList.get(Integer.valueOf(split[1])).setChe(isChecked);

            boolean isAllTag = true;
            for (TjTunityThreeBean.DataMapBean.ParkListBean parkListBean : parkList) {
                if (!parkListBean.isChe()) {
                    isAllTag = false;
                    break;
                }
            }
            if (isAllTag) {
                tvOtherAll.setText("取消全选");
                otherTag = false;
            } else {
                tvOtherAll.setText("全选");
                otherTag = true;
            }

        } else if (split[0].equals("yq")) {
            recommendList.get(Integer.valueOf(split[1])).setChe(isChecked);

            boolean isAllTag = true;
            for (TjTunityThreeBean.DataMapBean.RecommendListBean recommendListBean : recommendList) {
                if (!recommendListBean.isChe()) {
                    isAllTag = false;
                    break;
                }
            }
            if (isAllTag) {
                tvPowerAll.setText("取消全选");
                powerTag = false;
            } else {
                tvPowerAll.setText("全选");
                powerTag = true;
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        //缓存用户选择的园区
        if (tuijEdList == null) {
            tuijEdList = new ArrayList<>();
        } else {
            tuijEdList.clear();
        }

        for (int i = 0; i < recommendList.size(); i++) {
            TjTunityThreeBean.DataMapBean.RecommendListBean recommendListBean = recommendList.get(i);
            if (recommendListBean.isChe()) {
                TjTunityThreeBean.DataMapBean.ParkListBean parkListBean = new TjTunityThreeBean.DataMapBean.ParkListBean();
                parkListBean.setParkId(recommendListBean.getParkId());
                parkListBean.setParkName(recommendListBean.getParkName());
                tuijEdList.add(parkListBean);
            }
        }

        for (int i = 0; i < parkList.size(); i++) {
            TjTunityThreeBean.DataMapBean.ParkListBean parkListBean = parkList.get(i);
            if (parkListBean.isChe()) {
                tuijEdList.add(parkListBean);
            }
        }
        if (tuijEdList.size() > 0)
            SPUtils.put(this, "TjTunityThree", JsonUtil.getGson().toJson(tuijEdList));
    }
}
