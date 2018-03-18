package com.lingang.activity.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.tunity.RlTunityAc;
import com.lingang.activity.tunity.SupplementAc;
import com.lingang.activity.tunity.TjTunityOneAc;
import com.lingang.activity.tunity.execute.UpdateExecute;
import com.lingang.adapter.OppDetailsAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppBean;
import com.lingang.bean.OppHistory;
import com.lingang.bean.ShowStateEnum;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.BottomDialog2;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.MyRecyclerView;
import com.lingang.view.SettingItem;
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

import static com.lingang.common.Constants.OppPageStateType.MyExecute;

/**
 * 商机详情
 */
public class OpportunityDetailsAc extends BaseAc implements BottomDialog2.OnItemClickListener {

    @BindView(R.id.outdate_tv)
    TextView outdateTv;

    @BindView(R.id.opp_state_tab)
    TextView oppStateTab;
    @BindView(R.id.state_btn)
    TextView stateBtn;
    @BindView(R.id.flow_details_rv)
    MyRecyclerView flowDetailsRv;
    @BindView(R.id.customerName_txt)
    SettingItem customerNameTxt;
    @BindView(R.id.customerTel_txt)
    SettingItem customerTelTxt;
    @BindView(R.id.customerRelationshipName_txt)
    SettingItem customerRelationshipNameTxt;
    @BindView(R.id.customerCallId_txt)
    SettingItem customerCallIdTxt;
    @BindView(R.id.customerMail_txt)
    SettingItem customerMailTxt;
    @BindView(R.id.customerEnterpriseIsregister_txt)
    SettingItem customerEnterpriseIsregisterTxt;
    @BindView(R.id.customerEnterpriseName_txt)
    TextView customerEnterpriseNameTxt;
    @BindView(R.id.customerEnterpriseKeywords_txt)
    TextView customerEnterpriseKeywordsTxt;
    @BindView(R.id.workshopTypeId_txt)
    SettingItem workshopTypeIdTxt;
    @BindView(R.id.workshopArea_txt)
    SettingItem workshopAreaTxt;
    @BindView(R.id.workshopLocationId_txt)
    SettingItem workshopLocationIdTxt;
    @BindView(R.id.officeTypeId_txt)
    SettingItem officeTypeIdTxt;
    @BindView(R.id.officeArea_txt)
    SettingItem officeAreaTxt;
    @BindView(R.id.officeLocationId_txt)
    SettingItem officeLocationIdTxt;
    @BindView(R.id.supplementary_txt)
    TextView supplementaryTxt;
    @BindView(R.id.parkName_txt)
    AlignTextView parkNameTxt;
    @BindView(R.id.workshop_ll)
    LinearLayout workshopLl;
    @BindView(R.id.office_ll)
    LinearLayout officeLl;
    @BindView(R.id.landArea_txt)
    SettingItem landAreaTxt;
    @BindView(R.id.landLocation_txt)
    SettingItem landLocationTxt;
    @BindView(R.id.landType_txt)
    SettingItem landTypeTxt;
    @BindView(R.id.land_ll)
    LinearLayout landLl;
    @BindView(R.id.registeredEnterpriseType_txt)
    SettingItem registeredEnterpriseTypeTxt;
    @BindView(R.id.registeredEnterpriseMoney_txt)
    SettingItem registeredEnterpriseMoneyTxt;
    @BindView(R.id.register_ll)
    LinearLayout registerLl;

    private String kid;//获取商机详情ID
    private String showState;
    private Constants.OppPageStateType pageStateType; //页面类型
    private Constants.ParamLandType paramLandType; //需求类型
    private OppDetailsAdapter oppAdapter;//时间戳Adapter
    private List<OppHistory> oppHistoryList;
    private List<String> bottomList = new ArrayList<>();
    private BottomDialog2 bottomDialog2;
    private OppBean oppBean;//商机信息bean
    private ShowStateEnum state = null;  //商机状态
    private String tag;  //首页轮播文字跳转标记  可否操作右上角 ；  系统消息处传过来的值需判断是否为0来显示操作过期view
    private String details_type; //用于显示审核详情到详情页的显示标记不同

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_opportunity_detailes);
        setTitle("商机详情");

        tag = getIntent().getStringExtra(Constants.JUMP_TYPE);
        if (TextUtils.isEmpty(tag) || "1".equals(tag)) {
            getRightView().setImageResource(R.mipmap.home_more);
        }/* else {
            getRightView().setVisibility(View.GONE);
        }*/
        if ("0".equals(tag)) {
            outdateTv.setVisibility(View.VISIBLE);
        }
        details_type = getIntent().getStringExtra(Constants.DETAILS_TYPE);
        initView();
        initBottomDialog2();
    }

    /**
     * 初始化底部弹窗
     */
    public void initBottomDialog2() {
        if (null == pageStateType || TextUtils.isEmpty(showState)) {
            return;
        }
        switch (pageStateType) {
            case MyExecute: //我的执行
                switch (Integer.parseInt(showState)) {
                    case Constants.ExecuteState.ExecutionState:   //执行中
                        if ("1".equals(LoginManager.getInstance().getUserInfo().getUserType())
                                || "2".equals(LoginManager.getInstance().getUserInfo().getUserType())) {  //园区招商负责人 园区负责人
                            bottomList.clear();
                            bottomList.add("更新执行状态");
                            bottomList.add("更新商机信息");
                            bottomList.add("提交落地审核");
                            bottomList.add("转移商机");
                            bottomList.add("退回商机");
                        } else {//科产办负责人、关键用户、普通用户
                            bottomList.clear();
                            bottomList.add("更新执行状态");
                            bottomList.add("更新商机信息");
                            bottomList.add("转移商机");
                            bottomList.add("指派商机");
                            bottomList.add("撤销商机");
                        }
                        break;
                    case Constants.ExecuteState.PendingState://待审核
                        bottomList.clear();
                        bottomList.add("查看合同摘要");
                        break;
                    case Constants.ExecuteState.LandedState://已落地
                        bottomList.clear();
                        bottomList.add("查看合同摘要");
                        break;
                    default:   //隐藏右上角按钮
                        ib_right.setVisibility(View.GONE);
                        break;
                }
                break;
            case MyClaimAc:     //我的推荐
                switch (Integer.parseInt(showState)) {
                    case Constants.OppState.PendingState://待审核
                        bottomList.clear();
                        bottomList.add("撤销商机");
//                        bottomList.add("撤回商机");
                        break;
                    case Constants.OppState.ClaimedState://待认领
                        bottomList.clear();
                        bottomList.add("添加商机补充说明");
                        bottomList.add("撤销商机");
//                        bottomList.add("撤回商机");
                        break;
                    case Constants.OppState.ExecutionState://执行中
                        bottomList.clear();
                        bottomList.add("添加商机补充说明");
                        break;
                    case Constants.OppState.RevokedState://已撤销
                        bottomList.clear();
                        bottomList.add("重新发布");
                        break;
                    case Constants.OppState.ReturnedState://已退回
                        bottomList.clear();
                        bottomList.add("编辑商机");
                        bottomList.add("撤销商机");
                        break;
//                    case Constants.OppState.WithdrawnState://已撤回
//                        bottomList.clear();
//                        bottomList.add("编辑商机");
//                        break;
                    default:    //隐藏右上角按钮
                        ib_right.setVisibility(View.GONE);
                        break;
                }
                break;
            default:    //隐藏右上角按钮
                ib_right.setVisibility(View.GONE);
                break;

        }

        bottomDialog2 = new BottomDialog2(this, bottomList);
        bottomDialog2.setOnItemClickListener(this);
    }

    private void initView() {
        getRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != bottomDialog2) {
                    bottomDialog2.show();
                }
            }
        });

        kid = getIntent().getStringExtra(Constants.OPP_DETAILS_ID);
        showState = getIntent().getStringExtra(Constants.OPP_DETAILS_SHOW_STATE);
        pageStateType = (Constants.OppPageStateType) getIntent().getSerializableExtra(Constants.OPP_PAGE_STATE_TYPE);
        paramLandType = (Constants.ParamLandType) getIntent().getSerializableExtra(Constants.OPP_LAND_TYPE);

        oppHistoryList = new ArrayList<>();
        //ScrollView嵌套RecyclerView 滑动问题和显示不全
        flowDetailsRv.setNestedScrollingEnabled(false);
        flowDetailsRv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        flowDetailsRv.setLayoutManager(layoutManager);
        //商机详情数据适配
        oppAdapter = new OppDetailsAdapter(this, oppHistoryList);
        flowDetailsRv.setAdapter(oppAdapter);

        //获取商机详情数据
        getOppDetail();
        //商机状态
        renderShowState();

        if (paramLandType != null) {
            workshopLl.setVisibility(paramLandType.hasHaveWorkshop() ? View.VISIBLE : View.GONE);
            officeLl.setVisibility(paramLandType.hasHaveOffice() ? View.VISIBLE : View.GONE);
            landLl.setVisibility(paramLandType.hasHaveLand() ? View.VISIBLE : View.GONE);
            registerLl.setVisibility(paramLandType.hasHaveEnterpriseType() ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void clickLeft() {
        setResult(Constants.refreshCode);
        String tag = getIntent().getStringExtra("tag");
        if (!TextUtils.isEmpty(tag) && tag.equals("TunityResultAc")) {
            startActivity(new Intent(this, RlTunityAc.class).putExtra("tag", "MyExecute"), true);
        } else {
            super.clickLeft();
        }
    }

    @Override
    public void onBackPressed() {
        String tag = getIntent().getStringExtra("tag");
        if (!TextUtils.isEmpty(tag) && tag.equals("TunityResultAc")) {
            startActivity(new Intent(this, RlTunityAc.class).putExtra("tag", "MyExecute"), true);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 渲染状态
     */
    private void renderShowState() {
        if (!TextUtils.isEmpty(showState)) {
            //页面showState类型
            if (pageStateType == MyExecute) {
                state = Constants.executeShowState.get(Integer.parseInt(showState));
            } else if (pageStateType == Constants.OppPageStateType.MyExamine) {
                state = Constants.exaShowState.get(Integer.parseInt(showState));
            } else if (pageStateType == Constants.OppPageStateType.MyClaimAc) {
                state = Constants.recShowState.get(Integer.parseInt(showState));
            } else if (pageStateType == Constants.OppPageStateType.KanbanOppo) {
                state = Constants.oppoState.get(Integer.parseInt(showState));
            }
            //显示状态和颜色
            if (state != null) {
                stateBtn.setText(state.getState());
                DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(state.getColor()));
            }
        }
    }

    /**
     * 土地需求类型
     */
    private void renderLandType() {
        if (paramLandType != null && oppBean != null) {
            if (paramLandType.hasHaveWorkshop()) {
                workshopTypeIdTxt.setRightText(oppBean.getWorkshopTypeName());
                String workshopArea = splitPoint(oppBean.getWorkshopArea());
                workshopAreaTxt.setRightText(workshopArea + getString(R.string.workAreaUnit));
                workshopLocationIdTxt.setRightText(oppBean.getWorkshopLocationName());
            }
            if (paramLandType.hasHaveOffice()) {
                officeTypeIdTxt.setRightText(oppBean.getOfficeTypeName());
                if (oppBean.getOfficeArea() != null) {
                    String officeArea = splitPoint(oppBean.getOfficeArea());
                    officeAreaTxt.setRightText(officeArea + getString(R.string.workAreaUnit));
                }
                officeLocationIdTxt.setRightText(oppBean.getOfficeLocationName());
            }
            if (paramLandType.hasHaveLand()) {
                String landArea = splitPoint(oppBean.getLandArea());
                landAreaTxt.setRightText(landArea + "亩");
                landLocationTxt.setRightText(oppBean.getLandLocationName());
                landTypeTxt.setRightText(oppBean.getLandTypeName());
            }
            if (paramLandType.hasHaveEnterpriseType()) {
                String money = splitPoint(oppBean.getRegisteredEnterpriseMoney());
                registeredEnterpriseMoneyTxt.setRightText(money + "万元");
                registeredEnterpriseTypeTxt.setRightText(oppBean.getRegisteredEnterpriseTypeName());
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
                        //其它详情
                        renderOpp(oppBean);
                        //土地需求类型
                        renderLandType();
                    }
                });
    }

    /**
     * 渲染基本信息
     */
    private void renderOpp(OppBean oppBean) {
        if (oppBean != null) {
            //商机轨迹
            queryOpportunityHistory(oppBean.getKeyId());
            //基本信息
            customerNameTxt.setRightText(oppBean.getCustomerName());
            customerTelTxt.setRightText(oppBean.getCustomerTel());
            customerRelationshipNameTxt.setRightText(TextUtils.isEmpty(oppBean.getCustomerRelationshipName()) ? "无" : oppBean.getCustomerRelationshipName());
            customerCallIdTxt.setRightText(TextUtils.isEmpty(oppBean.getCustomerCallName()) ? "无" : oppBean.getCustomerCallName());
            customerMailTxt.setRightText(TextUtils.isEmpty(oppBean.getCustomerMail()) ? "无" : oppBean.getCustomerMail());
            customerEnterpriseIsregisterTxt.setRightText(Constants.regBusinessType.get(oppBean.getCustomerEnterpriseIsregister()));
            customerEnterpriseNameTxt.setText(TextUtils.isEmpty(oppBean.getCustomerEnterpriseName()) ? "未注册企业" : oppBean.getCustomerEnterpriseName());
            customerEnterpriseKeywordsTxt.setText(TextUtils.isEmpty(oppBean.getCustomerEnterpriseKeywords()) ? "无" : oppBean.getCustomerEnterpriseKeywords());

            supplementaryTxt.setText(TextUtils.isEmpty(oppBean.getSupplementaryNotes()) ? "无" : oppBean.getSupplementaryNotes());
            if (oppBean.getOpportunityParks() != null) {
                StringBuilder strApp = new StringBuilder();
                for (int i = 0; i < oppBean.getOpportunityParks().size(); i++) {
                    strApp.append("、" + oppBean.getOpportunityParks().get(i).getParkName());
                }
                parkNameTxt.setContent(strApp.toString().length() > 0 ? strApp.substring(1) : strApp.toString());
            } else {
                parkNameTxt.setContent("无");
            }

            //商机当前状态 补充
            if (!TextUtils.isEmpty(details_type) && Constants.EXAMINE_DETAILS.equals(details_type)) {
                if ("3".equals(oppBean.getOpportunityState())) {
                    stateBtn.setText("审核已通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(1).getColor()));
                } else if ("4".equals(oppBean.getOpportunityState())) {
                    stateBtn.setText("审核未通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(2).getColor()));
                } else if ("12".equals(oppBean.getOpportunityState())) {
                    stateBtn.setText("审核已通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(1).getColor()));
                } else if ("13".equals(oppBean.getOpportunityState())) {
                    stateBtn.setText("审核未通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(2).getColor()));
                }
                return;
            }
            if (!TextUtils.isEmpty(details_type) && Constants.RECOMMEND_DETAILS.equals(details_type)) {
                if ("1".equals(oppBean.getShowState())) {
                    stateBtn.setText("审核已通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(1).getColor()));
                } else if ("4".equals(oppBean.getShowState())) {
                    stateBtn.setText("审核未通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(2).getColor()));
                } else if ("8".equals(oppBean.getShowState())) {
                    stateBtn.setText("审核已通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(1).getColor()));
                } else if ("10".equals(oppBean.getShowState())) {
                    stateBtn.setText("审核未通过");
                    DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(2).getColor()));
                }
                return;
            }

        }
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
                .execute(new ResCallBack<BaseEntity<List<OppHistory>, Object>>(this) {
                    @Override
                    public void onCall(BaseEntity<List<OppHistory>, Object> oppHistoryEntity, Call call, Response response) throws JSONException {
                        List<OppHistory> historyList = oppHistoryEntity.getData();
                        if (historyList != null) {
                            oppHistoryList.clear();
                            oppHistoryList.addAll(historyList);
                            oppAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @OnClick({R.id.opp_state_tab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.opp_state_tab:
                oppStateTab.setSelected(!oppStateTab.isSelected());
                flowDetailsRv.setVisibility(oppStateTab.isSelected() ? View.GONE : View.VISIBLE);
                break;
        }
    }

    /**
     * 跳转到商机详情
     */
    public static void gotoOpportunityDetailsAc(Context context, String kid, String showState, Constants.OppPageStateType pageStateType, Constants.ParamLandType landType) {
        Intent intent = new Intent(context, OpportunityDetailsAc.class);
        intent.putExtra(Constants.OPP_DETAILS_ID, kid);//商机详情ID
        intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, showState);//状态类型
        intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, pageStateType);//页面类型(推荐商机，我的审核，我的执行)
        intent.putExtra(Constants.OPP_LAND_TYPE, landType);//需求类型(厂房,研发办公,土地,注册型企业)
        ((Activity) context).startActivityForResult(intent, Constants.refreshCode);
    }


    /**
     * 跳转到商机详情
     */
    public static void gotoOpportunityDetailsAc(Context context, String type, String kid, String showState, Constants.OppPageStateType pageStateType, Constants.ParamLandType landType) {
        Intent intent = new Intent(context, OpportunityDetailsAc.class);
        intent.putExtra(Constants.JUMP_TYPE, type);
        intent.putExtra(Constants.OPP_DETAILS_ID, kid);//商机详情ID
        intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, showState);//状态类型
        intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, pageStateType);//页面类型(推荐商机，我的审核，我的执行)
        intent.putExtra(Constants.OPP_LAND_TYPE, landType);//需求类型(厂房,研发办公,土地,注册型企业)
        ((Activity) context).startActivityForResult(intent, Constants.refreshCode);
    }

    /**
     * 审核详情跳转到商机详情
     */
    public static void gotoOpportunityDetailsAc(Context context, String kid, String showState, Constants.OppPageStateType pageStateType, Constants.ParamLandType landType, String details_type) {
        Intent intent = new Intent(context, OpportunityDetailsAc.class);
        intent.putExtra(Constants.OPP_DETAILS_ID, kid);//商机详情ID
        intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, showState);//状态类型
        intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, pageStateType);//页面类型(推荐商机，我的审核，我的执行)
        intent.putExtra(Constants.OPP_LAND_TYPE, landType);//需求类型(厂房,研发办公,土地,注册型企业)
        intent.putExtra(Constants.DETAILS_TYPE, details_type);
        ((Activity) context).startActivityForResult(intent, Constants.refreshCode);
    }


    /**
     * 弹出框点击事件
     *
     * @param view
     * @param item
     * @param position
     */
    @Override
    public void onItemClick(View view, String item, int position) {
        switch (pageStateType) {
            case MyExecute: //我的执行
                switch (Integer.parseInt(showState)) {
                    case Constants.ExecuteState.ExecutionState:   //执行中
                        if ("1".equals(LoginManager.getInstance().getUserInfo().getUserType())
                                || "2".equals(LoginManager.getInstance().getUserInfo().getUserType())) {  //园区招商负责人 园区负责人
                            switch (position) {
                                case 0:  //更新执行动态
                                    UpdateExecute.gotoUpdateExecute(OpportunityDetailsAc.this, oppBean.getOpportunityId(), oppBean.getKeyId());
                                    break;
                                case 1://更新商机信息
                                    updateOpportunity();
                                    break;
                                case 2://提交落地审核
                                    SubmitLandReview.gotoSubmitLandReview(OpportunityDetailsAc.this, oppBean, paramLandType);
                                    break;
                                case 3://转移商机
                                    //choolsParkI,oppID =>14.7   第二个页面 转移说明 operate 15=转移用户
                                    transferOpportunity(Constants.TRANSFER_OPP);
                                    break;
                                case 4://退回商机
                                    //executeNext(oppBean.getOpportunityId(),"",App.Empty,App.Empty,App.Empty);
                                    returnBusiness();
                                    break;
                            }
                        } else {   //科产办负责人、关键用户、普通用户
                            switch (position) {
                                case 0:  //更新执行动态
                                    UpdateExecute.gotoUpdateExecute(OpportunityDetailsAc.this, oppBean.getOpportunityId(), oppBean.getKeyId());
                                    break;
                                case 1:  //更新商机信息
                                    updateOpportunity();
                                    break;
                                case 2:  //转移商机
                                    transferOpportunity(Constants.TRANSFER_OPP);
                                    break;
                                case 3:  //指派商机
                                    transferOpportunity(Constants.ASSIGN_OPP);
                                    break;
                                case 4:  //撤销商机
                                    unDoOpportunityKeChanBan();
                                    break;
                            }
                        }
                        break;
                    case Constants.ExecuteState.PendingState://待审核
                        //查看合同摘要
                        contractSummary();
                        break;
                    case Constants.ExecuteState.LandedState://已落地
                        //查看合同摘要
                        contractSummary();
                        break;
                }
                break;
            case MyClaimAc://我的推荐
                switch (Integer.parseInt(showState)) {
                    case Constants.OppState.PendingState://待审核

                        switch (position) {
                            case 0: //撤销商机
                                undoOpportunity();
                                break;
//                            case 1://撤回商机
//                                withDrawOpportunity();
//                                break;
                        }
                        break;
                    case Constants.OppState.ClaimedState://待认领
                        switch (position) {
                            case 0:  //补充需求信息
                                if (null != oppBean) {
                                    Intent suppleIntent = new Intent(this, SupplementAc.class);
                                    suppleIntent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
                                    suppleIntent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
                                    startActivityForResult(suppleIntent, Constants.OppDetailRefreshType.RequestCode);
                                }
                                break;
                            case 1:  //撤销商机
                                undoOpportunity();
                                break;
//                            case 2:  //撤回商机
//                                withDrawOpportunity();
//                                break;
                        }
                        break;
                    case Constants.OppState.ExecutionState://执行中
                        //补充需求信息
                        Intent suppleIntent = new Intent(this, SupplementAc.class);
                        suppleIntent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
                        suppleIntent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
                        startActivityForResult(suppleIntent, Constants.OppDetailRefreshType.RequestCode);
                        break;
                    case Constants.OppState.RevokedState://已撤销
                        //重新发布
                        editOppOneAc(Constants.REDISTRIBUTE);
                        break;
                    case Constants.OppState.ReturnedState: //已退回
                        switch (position) {
                            case 0:
                                editOppOneAc(Constants.EDIT_OPPORTUNITY); //编辑商机
                                break;
                            case 1:
                                undoOpportunity();//撤销商机
                                break;
                        }

                        break;
//                    case Constants.OppState.WithdrawnState: //已撤销
//                        //编辑商机
//                        editOppOneAc(Constants.EDIT_OPPORTUNITY);
//                        break;

                }
                break;
        }
        bottomDialog2.dismiss();
    }

    /**
     * 查看合同摘要
     */
    public void contractSummary() {
        Intent intent = new Intent(this, ContractSummaryAc.class);
        intent.putExtra(Constants.OPP_DETAILS_ID, kid);//商机详情ID
        intent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);
        startActivity(intent);
    }

    /**
     * 撤销商机  我的推荐  个人撤销 OperateState 18
     */
    public void undoOpportunity() {
        DialogTwoCall dialogTwoCall = new DialogTwoCall(this);
        dialogTwoCall.show("撤销商机后，商机将结束推荐，确认是否撤销？");
        dialogTwoCall.setDialogListener(new DialogConfirmListion() {
            @Override
            public void confirmClick(String sign) {
                executeNext(oppBean.getKeyId(), oppBean.getOpportunityId(), Constants.OperateState.Revoked + "", LoginManager.getInstance().getUserInfo().getUserId(), "", "");
            }
        });
    }

    /**
     * 撤销商机 我的执行  科产办撤销 OperateState 14
     */
    public void unDoOpportunityKeChanBan() {
        Intent intent = new Intent(this, ReturnBusinessAc.class);
        intent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
        intent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
        intent.putExtra(Constants.JUMP_TYPE, Constants.UNDO);
        startActivity(intent);
    }

    /**
     * 撤回商机
     */
    public void withDrawOpportunity() {
        DialogTwoCall dialogTwoCall = new DialogTwoCall(this);
        dialogTwoCall.show("确定撤回此商机？");
        dialogTwoCall.setDialogListener(new DialogConfirmListion() {
            @Override
            public void confirmClick(String sign) {
                executeNext(oppBean.getKeyId(), oppBean.getOpportunityId(), Constants.OperateState.Withdraw + "", LoginManager.getInstance().getUserInfo().getUserId(), "", "");
            }
        });
    }

    /**
     * 重新发布、编辑商机
     */
    public void editOppOneAc(String type) {
        Intent intent = new Intent(this, TjTunityOneAc.class);
        intent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
        intent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
        if (type.equals(Constants.REDISTRIBUTE)) {
            intent.putExtra("tag", "repeat");
        } else {
            intent.putExtra("tag", "edit");
        }
        startActivity(intent);
    }

    /**
     * 退回商机
     */
    public void returnBusiness() {
        Intent intent = new Intent(this, ReturnBusinessAc.class);
        intent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
        intent.putExtra(Constants.JUMP_TYPE, Constants.RETURN_BUSINESS);
        intent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
        startActivity(intent);
    }

    /**
     * 转移商机/指派商机 TRANSFER_OPP / ASSIGN_OPP
     */
    public void transferOpportunity(String type) {
        Intent intent = new Intent(this, TransferAc.class);
        intent.putExtra(Constants.JUMP_TYPE, type);
        intent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
        intent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
        intent.putExtra(Constants.CHOOSE_PARK_ID, oppBean.getChooseParkId());
        startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
    }

    /**
     * 更新商机信息
     */
    public void updateOpportunity() {
        Intent intent = new Intent(this, UpdateTunityAc.class);
        intent.putExtra(Constants.KEY_ID, oppBean.getKeyId() + "");
        intent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
        startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
    }

    /**
     * 执行下一步
     *
     * @param oppId        商机id
     * @param operateState 执行类型
     * @param userId       转移用户id
     * @param parkId       认领园区选择
     * @param remark       原因说明
     */
    private void executeNext(String keyId, String oppId, String operateState, String userId, String parkId, String remark) {

        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("operateState", operateState);//执行类型
        if (!TextUtils.isEmpty(keyId)) {
            httpParams.put("keyId", keyId);
        }
        if (!TextUtils.isEmpty(oppId)) {
            httpParams.put("opportunityId", oppId);//商机id
        }
        if (!TextUtils.isEmpty(userId)) {
            httpParams.put("chooseUserId", userId);//转移用户id
        }
        if (!TextUtils.isEmpty(parkId)) {
            httpParams.put("chooseParkId", parkId);//认领园区选择
        }
        if (!TextUtils.isEmpty(remark)) {
            httpParams.put("opportunityRemark", remark);//原因说明
        }
        OkGo.post(HttpApi.executeNext)
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String cluster, Call call, Response response) {
                        setResult(Constants.refreshCode);
                        finish();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(OpportunityDetailsAc.this, e.getMessage());
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Constants.OppDetailRefreshType.UpdateExecute://更新执行页面返回
                //获取商机详情数据
                getOppDetail();
                setResult(Constants.refreshCode);
                break;

            case Constants.OppDetailRefreshType.RESPONSE_FINISH://更新商机信息返回结束页面
                setResult(Constants.refreshCode);
                finish();
                break;

            case Constants.OppDetailRefreshType.BackSupple:  //添加补充信息
                getOppDetail();
                break;

            case Constants.OppDetailRefreshType.SubmitLanded:
                setResult(Constants.refreshCode);
                finish();
                break;

        }
    }
}
