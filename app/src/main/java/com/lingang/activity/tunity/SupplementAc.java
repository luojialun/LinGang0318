package com.lingang.activity.tunity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.data.BaseEntry;
import com.lingang.R;
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

public class SupplementAc extends BaseAc {
    @BindView(R.id.content_et)
    EditText contentEt;
    @BindView(R.id.num_tv)
    TextView numTv;

    private String opportunityId;
    private String keyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_supplement);
        setTitle("补充需求信息");
        opportunityId = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);
        keyId = getIntent().getStringExtra(Constants.KEY_ID);
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
        if (!TextUtils.isEmpty(opportunityId)) {
            if (!TextUtils.isEmpty(contentEt.getText().toString())) {
                String submitContent = "";
                if (contentEt.getText().length() > 300) {
                    submitContent = contentEt.getText().toString().substring(0, 300);
                } else {
                    submitContent = contentEt.getText().toString();
                }
                submit(submitContent);
            } else {
                ToastUtils.showToast(this, "请输入补充需求信息");
            }
        }
    }

    public void submit(String content) {
        HttpParams params = new HttpParams();
        params.put("opportunityId", opportunityId);
        params.put("explainDetail", content);
        params.put("keyId", keyId);
        params.put("type", "1");
        params.put("token", LoginManager.getInstance().getUserInfo().getToken());
        OkGo.post(HttpApi.ADD_MESSAGE).params(params).tag(this).execute(new ResCallBack<BaseEntity<Object, Object>>(this) {
            @Override
            public void onCall(BaseEntity<Object, Object> responseBean, Call call, Response response) throws JSONException {
                if (null != responseBean) {
                    ToastUtils.showToast(SupplementAc.this, responseBean.getMessage());
                    setResult(Constants.OppDetailRefreshType.BackSupple);
                    finish();
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                ToastUtils.showToast(SupplementAc.this, "提交失败，请重试");
            }
        });
    }
}
