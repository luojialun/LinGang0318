package com.lingang.activity.tunity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MyTextWatcher;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.LengthFilterUtil;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class OppoReturnReasonAc extends BaseAc {

    @BindView(R.id.content_et)
    EditText contentEt;
    @BindView(R.id.num_tv)
    TextView numTv;

    private String keyId;
    private String opportunityId;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_oppo_return_reason);
        setTitle("审核不通过原因");
        keyId = getIntent().getStringExtra(Constants.KEY_ID);
        opportunityId = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);
        type = getIntent().getStringExtra(Constants.ALL_TYPE);
        if ("1".equals(type)) {
            contentEt.setHint("请添加商机推荐审核不通过的原因");
        } else {
            contentEt.setHint("请添加商机落地审核不通过的原因");
        }
        contentEt.setFilters(new InputFilter[]{new LengthFilterUtil(300)});
        contentEt.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                numTv.setText(s.length() + "/300");
            }
        });
    }

    @OnClick(R.id.submit_tv)
    public void onClick() {
        if (!TextUtils.isEmpty(contentEt.getText())) {
            String submitContent = "";
            String content = contentEt.getText().toString();
            if (content.length() > 300) {
                submitContent = content.substring(0, 300);
            } else {
                submitContent = content;
            }
            if (!TextUtils.isEmpty(opportunityId) && !TextUtils.isEmpty(type)) {
                if ("1".equals(type)) {//推荐
                    executeNext(keyId,opportunityId, Constants.OperateState.RecomReviewNot + "", "", "", submitContent);
                } else {              //落地
                    executeNext(keyId,opportunityId, Constants.OperateState.LandedReviewNot + "", "", "", submitContent);
                }
            }
        } else {
            if ("1".equals(type)) {
                ToastUtils.showToast(this, "请添加商机推荐审核不通过的原因");
            } else {
                ToastUtils.showToast(this, "请添加商机落地审核不通过的原因");
            }
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
    private void executeNext(String keyId,String oppId, String operateState, String userId, String parkId, String remark) {

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
                        setResult(Constants.OppDetailRefreshType.RESPONSE_FINISH);
                        finish();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(OppoReturnReasonAc.this, e.getMessage());
                    }
                });

    }

}
