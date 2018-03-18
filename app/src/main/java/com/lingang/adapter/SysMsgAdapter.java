package com.lingang.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.activity.home.NoticeDetailsAc;
import com.lingang.activity.tunity.OppExamineDetailsAc;
import com.lingang.activity.tunity.RlTunityDetailesAc;
import com.lingang.activity.user.UserCorrectDetailsAc;
import com.lingang.activity.user.UserSuggestDetailsAc;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppBean;
import com.lingang.bean.SysMsgBean;
import com.lingang.common.Constants;
import com.lingang.common.Constants.MessageType;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateHelper;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by luojialun on 2017/9/13.
 */

public class SysMsgAdapter extends RecycleBaseAdapter<SysMsgBean.SysMsg> {

    public SysMsgAdapter(Context context, List<SysMsgBean.SysMsg> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final SysMsgBean.SysMsg item, int position) {
        int messageType = Integer.parseInt(item.getMessageType());
        switch (messageType) {
            case MessageType.Correc:  //信息纠错
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_jiucuo);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            UserCorrectDetailsAc.goToUserCorrectDetailsAc(mContext, Integer.parseInt(item.getMessageId()));
                        } catch (Exception e) {
                            Log.i("TAG", "messageId 异常");
                        }
                    }
                });
                break;
            case MessageType.Message:        //意见反馈
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_fankui);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            UserSuggestDetailsAc.goToUserSuggestDetailsAc(mContext, Integer.parseInt(item.getMessageId()));
                        } catch (Exception e) {
                            Log.i("TAG", "messageId 异常");
                        }
                    }
                });
                break;
            //我的推荐
            case 70: //执行人更新推荐商机的信息
            case 79: //推荐商机发布申请已通过
            case 80: //提交的推荐商机发布申请已被退回
            case 81: //园区认领了推荐的商机
            case 82: //推荐的商机已成功落地
            case 84: //推荐的商机已被撤销。
            case 88: //执行人更新推荐人的商机执行状态
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_shangji);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getOppDetail(item.getMessageId(), Constants.recommend, item.getIsactive(), "", "", item.getShowState());
                    }
                });
                break;
            //我的执行
            case 75: //转移商机
            case 83: //提交的商机落地申请已被退回
            case 85: //科产办新推荐给园区一条商机
            case 86: //执行的商机已成功落地
            case 87: //推荐人更新商机补充说明
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_shangji);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getOppDetail(item.getMessageId(), Constants.exacute, item.getIsactive(), "", "", item.getShowState());
                    }
                });

                break;
            //我的审核
            case 71: //有新的推荐商机发布申请待审核
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_shangji);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getOppDetail(item.getMessageId(), Constants.examine, item.getIsactive(), "1", "1", item.getShowState());
                    }
                });

                break;
            case 74: //有一条新的商机落地申请待审核
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_shangji);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getOppDetail(item.getMessageId(), Constants.examine, item.getIsactive(), "1", "2", item.getShowState());
                    }
                });

                break;
            //认领商机
            default:
                holder.setImageResource(R.id.icon_iv, R.mipmap.sys_shangji);
                if (messageType > 70) {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getOppDetail(item.getMessageId(), Constants.claim, item.getIsactive(), "", "", item.getShowState());
                        }
                    });
                }
                break;
        }

        if (!TextUtils.isEmpty(item.getMessageTypeName())) {
            holder.setText(R.id.title_tv, item.getMessageTypeName());
        }
        holder.setText(R.id.time_tv, DateHelper.getTime(item.getCreateTime()));
        holder.setText(R.id.srcond_title_tv, item.getFirstTitle());
        holder.setText(R.id.reason_tv, item.getContent());

        if ("5".equals(item.getStatus())) {
            holder.setTextColor(R.id.title_tv, mContext.getResources().getColor(R.color.black_30));
            holder.setTextColor(R.id.time_tv, mContext.getResources().getColor(R.color.black_20));
            holder.setTextColor(R.id.srcond_title_tv, mContext.getResources().getColor(R.color.black_40));
            holder.setTextColor(R.id.reason_tv, mContext.getResources().getColor(R.color.black_30));
        } else {
            holder.setTextColor(R.id.title_tv, mContext.getResources().getColor(R.color.black_50));
            holder.setTextColor(R.id.time_tv, mContext.getResources().getColor(R.color.black_30));
            holder.setTextColor(R.id.srcond_title_tv, mContext.getResources().getColor(R.color.black_80));
            holder.setTextColor(R.id.reason_tv, mContext.getResources().getColor(R.color.black_50));
        }

    }

    /**
     * 获取商机详情
     *
     * @param kid      商机id
     * @param code     类型代码
     * @param isActive 1 可操作  其他 不可操作
     */
    public void getOppDetail(String kid, final int code, final String isActive, final String type1, final String type2, final String showState) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keyId", kid);
        OkGo.post(HttpApi.opportunity_detail)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<OppBean, Object>>(mContext) {
                    @Override
                    public void onCall(BaseEntity<OppBean, Object> oppBeanEntity, Call call, Response response) throws JSONException {
                        OppBean oppBean = oppBeanEntity.getData();
                        Constants.ParamLandType paramLandType = new Constants.ParamLandType(
                                TextUtils.isEmpty(oppBean.getWorkshopTypeName()) ? "0" : "1",
                                TextUtils.isEmpty(oppBean.getOfficeTypeName()) ? "0" : "1",
                                TextUtils.isEmpty(oppBean.getLandTypeName()) ? "0" : "1",
                                TextUtils.isEmpty(oppBean.getRegisteredEnterpriseTypeName()) ? "0" : "1");
                        switch (code) {
                            case Constants.recommend:
                                if ("4".equals(showState)) {
                                    Intent intent = new Intent(mContext, OppExamineDetailsAc.class);
                                    intent.putExtra(Constants.isActive, isActive);
                                    intent.putExtra(Constants.DETAILS_TYPE, Constants.RECOMMEND_DETAILS);
                                    intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                                    intent.putExtra(Constants.OPP_SHOW_STATE, showState);
                                    intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                                    intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyClaimAc);
                                    intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                                    intent.putExtra(Constants.OPP_DETAILS_ID, oppBean.getKeyId());//商机详情ID
                                    intent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);//需求类型(厂房,研发办公,土地,注册型企业)
                                    mContext.startActivity(intent);
                                } else {
                                    OpportunityDetailsAc.gotoOpportunityDetailsAc(mContext,
                                            isActive,
                                            oppBean.getKeyId(),
                                            showState,
                                            Constants.OppPageStateType.MyClaimAc,
                                            paramLandType);
                                }
                                break;
                            case Constants.exacute:
                                Intent intent = null;
                                if ("6".equals(showState)) {  //已落地
                                    intent = new Intent(mContext, OppExamineDetailsAc.class);
                                    intent.putExtra(Constants.isActive, isActive);
                                    intent.putExtra(Constants.DETAILS_TYPE, Constants.EXECUTE_DETAILS);
                                    intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                                    intent.putExtra(Constants.OPP_SHOW_STATE, showState);
                                    intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                                    intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExecute);
                                    intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                                } else {                //其他
                                    intent = new Intent(mContext, OpportunityDetailsAc.class);
                                    if (!"1".equals(isActive)) {
                                        intent.putExtra(Constants.JUMP_TYPE, isActive);
                                    }
                                    intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, showState);//状态类型
                                    intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExecute);//页面类型(推荐商机，我的审核，我的执行)
                                }
                                intent.putExtra(Constants.OPP_DETAILS_ID, oppBean.getKeyId());//商机详情ID
                                intent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);//需求类型(厂房,研发办公,土地,注册型企业)
                                ((Activity) mContext).startActivityForResult(intent, Constants.refreshCode);
                                break;
                            case Constants.examine:
                                Intent examineIntent = new Intent(mContext, OppExamineDetailsAc.class);
//                                examineIntent.putExtra(Constants.EXAMINE_DETAILS, Constants.EXAMINE_DETAILS);
                                examineIntent.putExtra(Constants.OPP_DETAILS_ID, oppBean.getKeyId());//商机详情ID
                                examineIntent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, type1);//1 待审核    2 已审核
                                examineIntent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
                                examineIntent.putExtra(Constants.ALL_TYPE, type2);  // 1 推荐审核 2 落地审核
                                examineIntent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);//需求类型(厂房,研发办公,土地,注册型企业)
                                examineIntent.putExtra(Constants.isActive, isActive);
                                ((Activity) mContext).startActivityForResult(examineIntent, Constants.refreshCode);
                                break;
                            case Constants.claim:
                                Intent claimIntent = new Intent(mContext, RlTunityDetailesAc.class);
                                claimIntent.putExtra("id", oppBean.getKeyId());
                                claimIntent.putExtra(Constants.isActive, isActive);
                                claimIntent.putExtra("showState", showState);
                                ((Activity) mContext).startActivityForResult(claimIntent, Constants.refreshCode);
                                break;
                        }
                    }
                });
    }

    @Override
    protected int getItemViewLayoutId(int position, SysMsgBean.SysMsg item) {
        return R.layout.item_sys_msg;
    }
}
