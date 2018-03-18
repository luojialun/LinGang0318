package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.event.UpdateSysmsgEvent;
import com.lingang.fragment.examine.LandExamineFragment;
import com.lingang.fragment.examine.RecExamineFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AlignTextView;
import com.lingang.view.SettingItem;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.vector.update_app.utils.DrawableUtil;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 商机审核详情
 */
public class OppExamineDetailsAc extends BaseAc {

    @BindView(R.id.outdate_tv)
    TextView outdateTv;

    @BindView(R.id.opp_state_tab)
    TextView oppStateTab;
    @BindView(R.id.reason_tv)
    TextView reasonTv;
    @BindView(R.id.opp_timed_content)
    LinearLayout oppTimedContent;
    @BindView(R.id.state_btn)
    TextView stateBtn;
    @BindView(R.id.rec_man_si)
    SettingItem recManSi;
    @BindView(R.id.rec_time_si)
    SettingItem recTimeSi;
    @BindView(R.id.exa_time_si)
    SettingItem exaTimeSi;
    @BindView(R.id.customerEnterpriseIsregister_txt)
    SettingItem customerEnterpriseIsregisterTxt;
    @BindView(R.id.customerEnterpriseName_txt)
    TextView customerEnterpriseNameTxt;
    @BindView(R.id.customerEnterpriseKeywords_txt)
    TextView customerEnterpriseKeywordsTxt;

    @BindView(R.id.supplementaryNotes_txt)
    TextView supplementaryNotesTxt;
    @BindView(R.id.parkName_txt)
    AlignTextView parkNameTxt;

    @BindView(R.id.message_ll)
    LinearLayout messageLl;
    @BindView(R.id.message2_ll)
    LinearLayout message2Ll;
    @BindView(R.id.opp_details_tv)
    TextView oppDetailsTv;
    @BindView(R.id.suggest_ll)
    LinearLayout suggestLl;
    @BindView(R.id.company_name_si)
    TextView companyNameSi;
    @BindView(R.id.yuanqu_si)
    SettingItem yuanquSi;

    @BindView(R.id.disagree_tv)
    TextView disagreeTv;
    @BindView(R.id.agree_tv)
    TextView agreeTv;

    @BindView(R.id.supply_park_ll)
    LinearLayout supplyParkLl;

    private String kid = "";//  keyId
    private String showState = "";
    private String state = "";  //1 待审核  2 已审核
    private String type = "";       //1 推荐审核  2 落地审核
    private Constants.OppPageStateType pageStateType;//页面类型
    public Constants.ParamLandType paramLandType;//需求类型
    public OppBean oppBean; //商机信息bean
    public String isActive;  //消息跳转过来是否可操作的标记
    private String landed;//我的推荐  我的执行 已落地跳转过来
    private String details_type; //默认不需要，当标签需要改变的时候添加

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_opp_examine_details);
        setTitle("商机审核详情");
        landed = getIntent().getStringExtra(Constants.OppState.Landed);
        kid = getIntent().getStringExtra(Constants.OPP_DETAILS_ID);
        showState = getIntent().getStringExtra(Constants.OPP_SHOW_STATE);
        state = getIntent().getStringExtra(Constants.OPP_DETAILS_SHOW_STATE);
        type = getIntent().getStringExtra(Constants.ALL_TYPE);
        pageStateType = (Constants.OppPageStateType) getIntent().getSerializableExtra(Constants.OPP_PAGE_STATE_TYPE);
        paramLandType = (Constants.ParamLandType) getIntent().getSerializableExtra(Constants.OPP_LAND_TYPE);
        isActive = getIntent().getStringExtra(Constants.isActive);
        details_type = getIntent().getStringExtra(Constants.DETAILS_TYPE);
        renderShowState();
        getOppDetail();
    }

    /**
     * 初始化页面数和UI
     */
    private void renderShowState() {
        if ("0".equals(isActive)) {
            outdateTv.setVisibility(View.VISIBLE);
        }

        //显示状态和颜色
        if (TextUtils.isEmpty(landed)) {
            if ("1".equals(state)) {
                stateBtn.setText(Constants.exaShowState.get(1).getState());
                DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState.get(1).getColor()));
            }
        } else {
            stateBtn.setText("已落地");
            DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(R.color.c_52d68e));
        }

        if ("1".equals(state) && "1".equals(type)) {  //待审核 推荐审核
            messageLl.setVisibility(View.VISIBLE);  //客户企业信息
            message2Ll.setVisibility(View.GONE);    //企业名称
            suggestLl.setVisibility(View.VISIBLE);  //同意  不同意
            oppDetailsTv.setVisibility(View.GONE);  //查看商机详情
            exaTimeSi.setVisibility(View.GONE);     //审核时间
            supplyParkLl.setVisibility(View.VISIBLE); //落地审核时  该视图隐藏
        } else if ("1".equals(state) && "2".equals(type)) { //待审核 落地审核
            messageLl.setVisibility(View.GONE);
            message2Ll.setVisibility(View.VISIBLE);
            suggestLl.setVisibility(View.VISIBLE);
            oppDetailsTv.setVisibility(View.VISIBLE);
            exaTimeSi.setVisibility(View.GONE);
            supplyParkLl.setVisibility(View.GONE);
        } else if ("2".equals(state) && "1".equals(type)) {//已审核 推荐审核
            messageLl.setVisibility(View.VISIBLE);
            message2Ll.setVisibility(View.GONE);
            suggestLl.setVisibility(View.GONE);
            oppDetailsTv.setVisibility(View.GONE);
            exaTimeSi.setVisibility(View.VISIBLE);
            supplyParkLl.setVisibility(View.VISIBLE);
        } else if ("2".equals(state) && "2".equals(type)) {  //已审核 落地审核
            messageLl.setVisibility(View.GONE);
            message2Ll.setVisibility(View.VISIBLE);
            suggestLl.setVisibility(View.GONE);
            oppDetailsTv.setVisibility(View.VISIBLE);
            exaTimeSi.setVisibility(View.VISIBLE);
            supplyParkLl.setVisibility(View.GONE);
        }

        if (suggestLl.getVisibility() == View.VISIBLE && !TextUtils.isEmpty(isActive) && "0".equals(isActive)) {  //消息跳转后是否可操作
            suggestLl.setVisibility(View.GONE);
        }
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
     * 填充基本信息
     */
    private void renderOpp(OppBean oppBean) {
        if (oppBean != null) {
            if ("1".equals(state) && "1".equals(type)) {  //待审核 推荐审核
                recManSi.setItemText("商机推荐人");
                recManSi.setRightText(TextUtils.isEmpty(oppBean.getRecommendUserName()) ? "无" : oppBean.getRecommendUserName());
                recTimeSi.setItemText("提交时间");
                recTimeSi.setRightText(DateUtils.getTimes(oppBean.getIntroduceDate(), "yyyy.MM.dd HH:mm"));
            } else if ("1".equals(state) && "2".equals(type)) { //待审核 落地审核
                recManSi.setItemText("落地申请人");
                recManSi.setRightText(TextUtils.isEmpty(oppBean.getSaveCheckApplyUserName()) ? "无" : oppBean.getSaveCheckApplyUserName());
                recTimeSi.setItemText("落地申请提交时间");
                recTimeSi.setRightText(DateUtils.getTimes(oppBean.getAgreeingDate(), "yyyy.MM.dd HH:mm"));
            } else if ("2".equals(state) && "1".equals(type)) {//已审核 推荐审核
                recManSi.setItemText("商机推荐人");
                recManSi.setRightText(TextUtils.isEmpty(oppBean.getRecommendUserName()) ? "无" : oppBean.getRecommendUserName());
                recTimeSi.setItemText("推荐时间");
                recTimeSi.setRightText(DateUtils.getTimes(oppBean.getIntroduceDate(), "yyyy.MM.dd HH:mm"));
                exaTimeSi.setItemText("审核时间");
                exaTimeSi.setRightText(DateUtils.getTimes(oppBean.getIntroduceCheckDate(), "yyyy.MM.dd HH:mm"));
                reasonTv.setText(oppBean.getOpportunityRemark());
            } else if ("2".equals(state) && "2".equals(type)) {  //已审核 落地审核
                recManSi.setItemText("落地申请人");
                recManSi.setRightText(TextUtils.isEmpty(oppBean.getSaveCheckApplyUserName()) ? "无" : oppBean.getSaveCheckApplyUserName());
                recTimeSi.setItemText("落地申请提交时间");
                recTimeSi.setRightText(DateUtils.getTimes(oppBean.getAgreeingDate(), "yyyy.MM.dd HH:mm"));
                exaTimeSi.setItemText("落地申请审核时间");
                exaTimeSi.setRightText(DateUtils.getTimes(oppBean.getSaveCheckDate(), "yyyy.MM.dd HH:mm"));
            }

            if (TextUtils.isEmpty(oppBean.getCustomerEnterpriseName())) {
                companyNameSi.setText("未注册企业");
            } else {
                companyNameSi.setText(oppBean.getCustomerEnterpriseName());
            }
            yuanquSi.setRightText(oppBean.getChooseParkName());

            if (!TextUtils.isEmpty(type)) {
                if (TextUtils.isEmpty(landed)) {
                    if ("1".equals(type)) {       //推荐审核
                        if ("3".equals(oppBean.getOpportunityState())) {//审核成功
                            stateBtn.setText(Constants.exaShowState2.get(1).getState());
                            DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(1).getColor()));
                        } else if ("4".equals(oppBean.getOpportunityState())) {//审核失败
                            stateBtn.setText(Constants.exaShowState2.get(2).getState());
                            DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(2).getColor()));
                            reasonTv.setVisibility(View.VISIBLE);
                            reasonTv.setText(oppBean.getOpportunityRemark());
                        }
                    } else if ("2".equals(type)) {   //落地审核
                        if ("12".equals(oppBean.getOpportunityState())) {  //审核成功
                            stateBtn.setText(Constants.exaShowState2.get(1).getState());
                            DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(1).getColor()));
                        } else if ("13".equals(oppBean.getOpportunityState())) {  //审核失败
                            stateBtn.setText(Constants.exaShowState2.get(2).getState());
                            DrawableUtil.setTextSolidTheme(stateBtn, 6, 30, getResources().getColor(Constants.exaShowState2.get(2).getColor()));
                            reasonTv.setVisibility(View.VISIBLE);
                            reasonTv.setText(oppBean.getOpportunityRemark());
                        }
                    }
                }
            }

            customerEnterpriseIsregisterTxt.setRightText(Constants.regBusinessType.get(oppBean.getCustomerEnterpriseIsregister()));

            String customerEnterpriseName = oppBean.getCustomerEnterpriseName();
            customerEnterpriseNameTxt.setText(TextUtils.isEmpty(customerEnterpriseName) ? "未注册企业" : customerEnterpriseName);

            String customerEnterpriseKeywords = oppBean.getCustomerEnterpriseKeywords();
            customerEnterpriseKeywordsTxt.setText(TextUtils.isEmpty(customerEnterpriseKeywords) ? "无" : customerEnterpriseKeywords);

            supplementaryNotesTxt.setText(TextUtils.isEmpty(oppBean.getSupplementaryNotes()) ? "无" : oppBean.getSupplementaryNotes());
            if (oppBean.getOpportunityParks() != null) {
                StringBuilder strApp = new StringBuilder();
                for (int i = 0; i < oppBean.getOpportunityParks().size(); i++) {
                    strApp.append("、" + oppBean.getOpportunityParks().get(i).getParkName());
                }
                parkNameTxt.setContent(strApp.toString().length() > 0 ? strApp.substring(1) : "无");
            }
        }
    }

    /**
     * 需求类型
     */
    private void renderLandType() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if ("1".equals(type)) {
            transaction.add(R.id.needs_fl, new RecExamineFragment());  //推荐
        } else {
            transaction.add(R.id.needs_fl, new LandExamineFragment());//落地
        }
        transaction.commit();
    }

    @OnClick({R.id.opp_state_tab, R.id.opp_details_tv, R.id.disagree_tv, R.id.agree_tv, R.id.rec_man_si})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.opp_state_tab:    // 折叠栏
                oppStateTab.setSelected(!oppStateTab.isSelected());
                oppTimedContent.setVisibility(oppStateTab.isSelected() ? View.GONE : View.VISIBLE);
                break;
            case R.id.opp_details_tv:   //商机详情
                if (!TextUtils.isEmpty(details_type)) {
                    if (TextUtils.isEmpty(landed)) {
                        OpportunityDetailsAc.gotoOpportunityDetailsAc(this, kid, state, pageStateType, paramLandType, details_type);
                    } else {
                        if (pageStateType == Constants.OppPageStateType.MyExamine) {
                            OpportunityDetailsAc.gotoOpportunityDetailsAc(this, kid, state, pageStateType, paramLandType, details_type);
                        } else {
                            OpportunityDetailsAc.gotoOpportunityDetailsAc(this, kid, showState, pageStateType, paramLandType, details_type);
                        }
                    }
                } else {
                    if (TextUtils.isEmpty(landed)) {
                        OpportunityDetailsAc.gotoOpportunityDetailsAc(this, kid, state, pageStateType, paramLandType);
                    } else {
                        if (pageStateType == Constants.OppPageStateType.MyExamine) {
                            OpportunityDetailsAc.gotoOpportunityDetailsAc(this, kid, state, pageStateType, paramLandType);
                        } else {
                            OpportunityDetailsAc.gotoOpportunityDetailsAc(this, kid, showState, pageStateType, paramLandType);
                        }
                    }
                }
                break;
            case R.id.rec_man_si:       //人员信息跳转
                if ("1".equals(type)) {
                    startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", oppBean.getRecommendUserAccount()).putExtra("tag", "bendi"));
                } else {
                    startActivity(new Intent(this, PersonInfoActivity.class).putExtra("userid", oppBean.getSaveCheckApplyUserAccount()).putExtra("tag", "bendi"));
                }
                break;
            case R.id.agree_tv:         //同意
                DialogTwoCall dialog = new DialogTwoCall(this);
                if ("1".equals(type)) {  //推荐
                    dialog.show("通过审核后，该商机将被推荐至选中的园区，请确认是否同意?");
                } else {                  //落地
                    dialog.show("通过审核后，该商机将计入园区已落地商机，请确认是否同意?");
                }
                dialog.setDialogListener(new DialogConfirmListion() {
                    @Override
                    public void confirmClick(String sign) {
                        if ("1".equals(type)) {  //推荐
                            executeNext(oppBean.getKeyId(), oppBean.getOpportunityId(), Constants.OperateState.RecomReviewPassed + "", "", "", "");
                        } else {                 //落地
                            executeNext(oppBean.getKeyId(), oppBean.getOpportunityId(), Constants.OperateState.LandedReviewPassed + "", "", "", "");
                        }
                    }
                });
                break;
            case R.id.disagree_tv:      //不同意
                Intent intent = new Intent(this, OppoReturnReasonAc.class);
                intent.putExtra(Constants.KEY_ID, oppBean.getKeyId());
                intent.putExtra(Constants.OPPORTUNITY_ID, oppBean.getOpportunityId());
                intent.putExtra(Constants.ALL_TYPE, type);
                startActivityForResult(intent, Constants.OppDetailRefreshType.RequestCode);
                break;
        }
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
                        EventBus.getDefault().post(new UpdateSysmsgEvent());
                        setResult(Constants.refreshCode);
                        finish();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(OppExamineDetailsAc.this, e.getMessage());
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Constants.OppDetailRefreshType.RESPONSE_FINISH:
                setResult(Constants.refreshCode);
                finish();
                break;
        }
    }
}
