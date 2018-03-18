package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.tunity.execute.MyExecute;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.common.Constants;
import com.lingang.common.Constants.OperateState;
import com.lingang.common.LoginManager;
import com.lingang.common.MyTextWatcher;
import com.lingang.dialog.DialogTwo;
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

/**
 * 退回商机 /  科产办撤销商机
 */
public class ReturnBusinessAc extends BaseAc implements DialogConfirmListion {
    @BindView(R.id.content_et)
    EditText contentEt;
    @BindView(R.id.num_tv)
    TextView numTv;
    @BindView(R.id.tip_tv)
    TextView tipTv;

    private String keyId;
    private String opportunityId;
    private DialogTwo dialogTwo;
    private String jump_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_return_business);
        jump_type = getIntent().getStringExtra(Constants.JUMP_TYPE);
        if (Constants.RETURN_BUSINESS.equals(jump_type)) {
            setTitle("退回说明");
            contentEt.setHint("请添加商机退回说明信息");
            tipTv.setText("退回商机后，商机将转移至科产办处理。");
        } else {
            setTitle("撤销商机说明");
            contentEt.setHint("请添加商机撤销说明信息");
            tipTv.setText("撤销商机后，商机将结束执行。");
        }
        keyId=getIntent().getStringExtra(Constants.KEY_ID);
        opportunityId = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);
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
        if (!TextUtils.isEmpty(contentEt.getText().toString())) {
            if (!TextUtils.isEmpty(opportunityId)) {
                if (dialogTwo == null)
                    dialogTwo = new DialogTwo(this, this);
                if (Constants.RETURN_BUSINESS.equals(jump_type)) {
                    dialogTwo.show("取消", "确定", "退回商机后，商机将转交至科产办处理，请确认是否退回商机？");
                } else {
                    dialogTwo.show("取消", "确定", "撤销商机后，该商机将结束执行，请确认是否撤销商机？");
                }
            }
        } else {
            if (Constants.RETURN_BUSINESS.equals(jump_type)) {
                ToastUtils.showToast(this, "请添加商机退回说明信息");
            } else {
                ToastUtils.showToast(this, "请添加商机撤销说明信息");
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
                .execute(new ResCallBack<BaseEntity<Object, Object>>(this) {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(ReturnBusinessAc.this, e.getMessage());
                    }

                    @Override
                    public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                        ToastUtils.showToast(ReturnBusinessAc.this, responseBean.getMessage());
                        Intent intent = new Intent(ReturnBusinessAc.this, MyExecute.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });

    }

    @Override
    public void confirmClick(String sign) {
        String submitContent = "";
        if (contentEt.getText().toString().length() > 300) {
            submitContent = contentEt.getText().toString().substring(0, 300);
        } else {
            submitContent = contentEt.getText().toString();
        }
        if (Constants.RETURN_BUSINESS.equals(jump_type)) {
            executeNext(keyId,opportunityId, OperateState.Returned + "", "", "", submitContent);
        } else {
            executeNext(keyId,opportunityId, OperateState.ExecutionFailed + "", "", "", submitContent);
        }
    }
}
