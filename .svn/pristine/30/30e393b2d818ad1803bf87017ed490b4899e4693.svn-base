package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.activity.tunity.execute.MyExecute;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MyTextWatcher;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.LengthFilterUtil;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * 转移说明和指派说明
 */
public class TransferIllustrationAc extends BaseAc {

    @BindView(R.id.user_tv)
    TextView userTv;
    @BindView(R.id.content_et)
    EditText contentEt;
    @BindView(R.id.num_tv)
    TextView numTv;

    private String type;
    private String keyId;
    private String opportunity;
    private String userId = "";
    private String parkId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_transfer_illustration);
        type = getIntent().getStringExtra(Constants.JUMP_TYPE);
        setTitle(type);
        String name = getIntent().getStringExtra(Constants.USER_NAME);
        if (Constants.TRANSFER_ILL.equals(type)) {
            Spannable span = new SpannableString("当前转移对象" + name);
            span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 6, name.length() + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            userTv.setText(span);
            contentEt.setHint("建议添加商机转移的说明信息");
        } else {
            Spannable span = new SpannableString("当前指派对象" + name);
            span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tv_flow_color)), 6, name.length() + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            userTv.setText(span);
            contentEt.setHint("请添加商机指派的说明信息");
        }
        keyId = getIntent().getStringExtra(Constants.KEY_ID);
        opportunity = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);
        userId = getIntent().getStringExtra(Constants.CHOOSE_USER_ID);
        parkId = getIntent().getStringExtra(Constants.CHOOSE_PARK_ID);
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
        String submitContent = "";
        String content = contentEt.getText().toString();
        if (null != content && content.length() > 300) {
            submitContent.substring(0, 300);
        } else {
            submitContent = content;
        }
        if (Constants.TRANSFER_ILL.equals(type)) { //转移不必填
            if (!TextUtils.isEmpty(keyId) && !TextUtils.isEmpty(opportunity)) {
                executeNext(keyId, opportunity, userId, parkId, submitContent);
            }
        } else {    //指派必填
            if (TextUtils.isEmpty(submitContent)) {
                ToastUtils.showToast(this, "商机补充信息不能为空");
            } else {
                if (!TextUtils.isEmpty(keyId) && !TextUtils.isEmpty(opportunity)) {
                    executeNext(keyId, opportunity, userId, parkId, submitContent);
                }
            }
        }

    }

    /**
     * 执行下一步
     *
     * @param oppId  商机id
     * @param userId 转移用户id
     * @param parkId 认领园区选择
     * @param remark 原因说明
     */
    private void executeNext(String keyId, String oppId, String userId, String parkId, String remark) {

        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("operateState",
                Constants.TRANSFER_ILL.equals(type) ? Constants.OperateState.Move : Constants.OperateState.Agent);//执行类型
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
                .execute(new ResCallBack<BaseEntity<Object, Object>>(this) {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(TransferIllustrationAc.this, e.getMessage());
                    }

                    @Override
                    public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                        ToastUtils.showToast(TransferIllustrationAc.this, responseBean.getMessage());
                        if (Constants.TRANSFER_ILL.equals(type)) {
                           /* Intent intent=new Intent(TransferIllustrationAc.this, MyExecute.class);
                            intent.putExtra("tag", "商机转移");
                            intent.addFlags(FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);*/
                            setResult(Constants.OppDetailRefreshType.RESPONSE_FINISH);
                            finish();

                        } else {
                         /*   Intent intent=new Intent(TransferIllustrationAc.this, MyExecute.class);
                            intent.putExtra("tag", "指派商机");
                            intent.addFlags(FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);*/
                            setResult(Constants.OppDetailRefreshType.RESPONSE_FINISH);
                            finish();
                        }
                    }
                });
    }
}
