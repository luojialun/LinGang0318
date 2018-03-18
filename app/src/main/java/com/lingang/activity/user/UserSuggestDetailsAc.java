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
import com.lingang.base.BaseAc;
import com.lingang.bean.MessageDetails;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.DateUtils;
import com.lingang.view.SettingItem;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 反馈详情
 */
public class UserSuggestDetailsAc extends BaseAc {

    @BindView(R.id.feedback_content_si)
    SettingItem feedbackContentSi;
    @BindView(R.id.admin_reply_si)
    SettingItem adminReplySi;
    @BindView(R.id.suggest_content_tv)
    TextView suggestContentTv;
    @BindView(R.id.suggest_reply_content_tv)
    TextView suggestReplyContentTv;
    @BindView(R.id.suggest_plane_ll)
    LinearLayout suggestPlaneLl;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    private int messageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_suggest_details);
        initView();
    }

    private void initView() {
        setTitle(getString(R.string.suggest_details));
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
                .execute(new ResCallBack<MessageDetails>(UserSuggestDetailsAc.this, true) {
                    @Override
                    public void onCall(MessageDetails responseBean, Call call, Response response) {
                        if (responseBean != null && responseBean.getData() != null) {
                            MessageDetails.DataEntity details = responseBean.getData();
                            suggestContentTv.setText(details.getMessageContent());
                            feedbackContentSi.setRightText(DateUtils.getTimestamp(details.getCreateTime(), "yyyy-MM-dd"));

                            if (details.getReplyId() != App.IntNormal) {
                                suggestPlaneLl.setVisibility(View.VISIBLE);
                                suggestReplyContentTv.setText(details.getReplyContent());
                                adminReplySi.setRightText(DateUtils.getTimestamp(details.getReplyTime(), "yyyy-MM-dd"));
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
    public static void goToUserSuggestDetailsAc(Context context, int msgId) {
        Intent intent = new Intent(context, UserSuggestDetailsAc.class);
        intent.putExtra("messageId", msgId);
        context.startActivity(intent);
    }
}
