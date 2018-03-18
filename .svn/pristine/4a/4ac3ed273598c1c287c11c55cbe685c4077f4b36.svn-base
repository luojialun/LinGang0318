package com.lingang.activity.user;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PermissionCallback;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwoCall;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.PermissionUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.OnClick;
import ezy.ui.view.RoundButton;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 添加反馈意见
 */
public class UserSuggestAddAc extends BaseAc {
    @BindView(R.id.suggest_feed_content_et)
    EditText suggestFeedContentEt;
    @BindView(R.id.suggest_submit)
    RoundButton suggestSubmit;
    @BindView(R.id.tv_fank)
    TextView tvFank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_user_suggest_add);
        checkSelfPermission();
        initView();
    }

    /**
     * init
     */
    private void initView() {
        setTitle(getString(R.string.suggest_feed));
        getRightTextView().setText("提交");
        tvFank.setText("如需技术支持，请拨打服务热线38295000。\n\n我们欢迎任何关于i-Lingang的意见、想法和建议，请在这里填写反馈:");

        //去除下划线
        NoUnderlineSpan mNoUnderlineSpan = new NoUnderlineSpan();
        if (tvFank.getText() instanceof Spannable) {
            Spannable s = (Spannable) tvFank.getText();
            s.setSpan(mNoUnderlineSpan, 14, 22, Spanned.SPAN_MARK_MARK);
        }
        suggestFeedContentEt.requestFocus();
    }


    private class NoUnderlineSpan extends ClickableSpan{
        @Override
        public void onClick(View view) {
            ToastUtils.showToast(UserSuggestAddAc.this,"点击了");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(ds.linkColor);
            ds.setUnderlineText(false);
        }
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();

        String suggestContent = suggestFeedContentEt.getText().toString().trim();
        if (!TextUtils.isEmpty(suggestContent)) {
            addSuggestHttp(suggestContent);
        } else {
            ToastUtils.showToast(this, "请输入您要反馈的内容");
        }
    }

    @OnClick(R.id.suggest_submit)
    public void onViewClicked() {
        String suggestContent = suggestFeedContentEt.getText().toString().trim();
        if (!TextUtils.isEmpty(suggestContent)) {
            addSuggestHttp(suggestContent);
        } else {
            ToastUtils.showToast(this, "请输入您要反馈的内容");
        }
    }

    private void addSuggestHttp(String suggestContent) {
        /**
         messageType	int	是	2(参数值固定为2)
         messageContent	String	是	反馈内容
         */
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("messageType", Constants.MessageType_Suggest);
        httpParams.put("messageContent", suggestContent);

        OkGo.post(HttpApi.MessageAdd)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(UserSuggestAddAc.this, false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) throws JSONException {
//                        ToastUtils.showToast(UserSuggestAddAc.this, "提交成功");
//                        setResult(Constants.refreshCode);
                        setResult(Constants.SUGGEST_FEEDBACK);
                        finish();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(UserSuggestAddAc.this, "接口返回失败");
                    }
                });
    }

    public void checkSelfPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPiss();
        }
    }

    private void requestPiss() {
       /* if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            // 返回值：
            //如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
            //如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
            //如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
            // 弹窗需要解释为何需要该权限，再次请求授权

            // 帮跳转到该应用的设置界面，让用户手动授权
//            ToastUtils.showToast(this, "请授权！");
            Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            i.setData(uri);
            startActivity(i);
        } else {
            // 不需要解释为何需要该权限，直接请求授权
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Constants.MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }*/

        PermissionUtils.checkPermission(this, PermissionUtils.PHONE_PERMISSION, getString(R.string.permission_failed), new PermissionCallback() {
            @Override
            public void onRequestCallBack(boolean isSuccess) {
//               ToastUtils.showToast(UserSuggestAddAc.this,"电话授权成功");
            }
        });
    }

    // 处理权限申请的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case Constants.MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 授权成功，继续打电话
                    //ToastUtils.showToast(this, "授权成功！");
                } else {
                    // 授权失败！
                    ToastUtils.showToast(this, "授权失败！");
                }
                break;
            }
        }

    }
}
