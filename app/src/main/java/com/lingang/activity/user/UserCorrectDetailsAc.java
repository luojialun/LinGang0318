package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.business.PersonInfoActivity;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.activity.home.EntryDetailsAc;
import com.lingang.activity.home.JiQunDetailsAc;
import com.lingang.activity.home.MatingDetailesAc;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.activity.home.PolicyDetialesAc;
import com.lingang.activity.home.PropertyDettailsAc;
import com.lingang.activity.home.PublicDetailsAc;
import com.lingang.adapter.PartnerDetailsAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.MessageDetails;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.view.SettingItem;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 纠错信息明细
 */
public class UserCorrectDetailsAc extends BaseAc {

    /*@BindView(R.id.correct_date_tv)
    TextView correctDateTv;*/
    @BindView(R.id.correct_date_si)
    SettingItem correctDateSi;
    @BindView(R.id.reply_date_si)
    SettingItem replyDateSi;
    @BindView(R.id.correct_content_tv)
    TextView correctContentTv;
    @BindView(R.id.correct_reply_content_tv)
    TextView correctReplyContentTv;
    /*@BindView(R.id.correct_reply_date_tv)
    TextView correctReplyDateTv;*/
    @BindView(R.id.correct_plane_ll)
    LinearLayout correctPlaneLl;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
//    @BindView(R.id.relative_page_si)
//    SettingItem relativePageSi;
//    @BindView(R.id.relative_people_si)
//    SettingItem relativePeopleSi;

    private int messageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_correct_details);
        initView();
    }

    /**
     * initView
     */
    private void initView() {
        setTitle(getString(R.string.correct_details));
        messageId = getIntent().getIntExtra("messageId", App.IntNormal);
        loadInfo();
        refresh.setEnableLoadmore(false);
        refresh.setEnableRefresh(false);
    }

    /**
     * 加载信息
     */
    private void loadInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("messageId", messageId);
        OkGo.post(HttpApi.MessageDetails)
                .params(httpParams)
                .tag(UserCorrectDetailsAc.this)
                .execute(new ResCallBack<MessageDetails>(UserCorrectDetailsAc.this, true) {
                    @Override
                    public void onCall(MessageDetails responseBean, Call call, Response response) {
                        if (responseBean != null && responseBean.getData() != null) {
                            final MessageDetails.DataEntity details = responseBean.getData();
                            correctContentTv.setText(details.getMessageContent());
                            correctDateSi.setRightText(DateUtils.getTimestamp(details.getCreateTime(), "yyyy-MM-dd"));
//                            relativePageSi.setRightText(details.getLinkName());
                          /*  relativePageSi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //页面跳转
                                    switch (details.getLinkType())
                                    {
                                        case Constants.CorrectType.NEWS://新闻
                                            NewsDetailsAc.goToNewsDetailsAc(UserCorrectDetailsAc.this,String.valueOf(details.getLinkId()));
                                            break;
                                        case Constants.CorrectType.POLICY://政策列表
                                            startActivity(new Intent(UserCorrectDetailsAc.this, PolicyDetialesAc.class).putExtra("id",String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.PARK: //产业园区
                                            startActivity(new Intent(UserCorrectDetailsAc.this, ChanYeDetailsAc.class).putExtra("id", String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.Partner: //合作伙伴
                                            startActivity(new Intent(UserCorrectDetailsAc.this, PartnerDetailsAc.class).putExtra("id", String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.Industry://产业集群
                                            startActivity(new Intent(UserCorrectDetailsAc.this, JiQunDetailsAc.class).putExtra("id", String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.Mating://配套服务
                                            startActivity(new Intent(UserCorrectDetailsAc.this, MatingDetailesAc.class).putExtra("id", String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.Entry://企业入驻
                                            startActivity(new Intent(UserCorrectDetailsAc.this, EntryDetailsAc.class).putExtra("id", String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.Public://公共平台
                                            startActivity(new Intent(UserCorrectDetailsAc.this,PublicDetailsAc.class).putExtra("id",String.valueOf(details.getLinkId())));
                                            break;
                                        case Constants.CorrectType.Mine: //个人中心
                                            UserInfoAc.goToUserInfoAc(UserCorrectDetailsAc.this,String.valueOf(details.getLinkId()));
                                            break;
                                        case Constants.CorrectType.Business://租售物业
                                            startActivity(new Intent(UserCorrectDetailsAc.this, PropertyDettailsAc.class).putExtra("id", String.valueOf(details.getLinkId())).putExtra("title",details.getLinkName()));
                                            break;
                                    }
                                }
                            });
                            */
                            if (details.getReplyId() != App.IntNormal) {
                                correctPlaneLl.setVisibility(View.VISIBLE);
//                                relativePeopleSi.setRightText(details.getReplyName());
                                correctReplyContentTv.setText(details.getReplyContent());
                                replyDateSi.setRightText(DateUtils.getTimestamp(details.getReplyTime(),"yyyy-MM-dd"));
                              /*  relativePeopleSi.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(UserCorrectDetailsAc.this, PersonInfoActivity.class);
                                        intent.putExtra("userid",String.valueOf(details.getReplyUserId()));
                                        intent.putExtra("tag","bendi");
                                        startActivity(intent);
                                    }
                                });*/
                            }
                        }
                    }
                });
    }

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void goToUserCorrectDetailsAc(Context context, int msgId) {
        Intent intent = new Intent(context, UserCorrectDetailsAc.class);
        intent.putExtra("messageId", msgId);
        context.startActivity(intent);
    }

}
