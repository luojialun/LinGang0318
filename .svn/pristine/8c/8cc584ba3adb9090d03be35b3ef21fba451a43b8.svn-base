package com.lingang.activity.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.activity.user.GestureLockEditActivity;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.DataMapLoginBean;
import com.lingang.bean.UserInfo;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppManager;
import com.lingang.utils.AppUtils;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.SystemBarHelper;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import okhttp3.Call;
import okhttp3.Response;

public class LoginAc extends BaseAc {

    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_psw)
    EditText loginPsw;
    @BindView(R.id.login_code)
    EditText loginCode;
    @BindView(R.id.btn_code)
    TextView btnCode;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.root_view)
    LinearLayout rootView;
    @BindView(R.id.content_view)
    LinearLayout contentView;
    @BindView(R.id.logo)
    ImageView logo;

    //是否是手势登录页跳转至登录页面
    private boolean isGestureShipLogin = false;
    private String registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
        SystemBarHelper.setStatusBarDarkMode(this);
    }

    //填充账号密码
    private void init() {
        registration = JPushInterface.getRegistrationID(LoginAc.this);
        isGestureShipLogin = getIntent().getBooleanExtra(Constants.IS_GESTURE_SHIP_LOGIN, false);

        final int screenHeight = ScreenSizeUtils.getInstance(this).getScreenHeight();
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() { //当界面大小变化时，系统就会调用该方法
                        Rect r = new Rect(); //该对象代表一个矩形（rectangle）
                        rootView.getWindowVisibleDisplayFrame(r); //将当前界面的尺寸传给Rect矩形

                        int deltaHeight = screenHeight - r.bottom;  //弹起键盘时的变化高度，在该场景下其实就是键盘高度。

                        int bottom = screenHeight - contentView.getHeight();

                        int scollRang = deltaHeight - bottom;

                        if (deltaHeight > bottom) {  //键盘挡住View
                            contentView.setTranslationY(-scollRang);
                            logo.setVisibility(View.INVISIBLE);
                        } else {
                            contentView.setTranslationY(0);
                            logo.setVisibility(View.VISIBLE);
                        }
                    }
                });

        loginPhone.setText((String) SPUtils.get(LoginAc.this, "account", ""));
    }

    @OnClick({R.id.btn_code, R.id.btn_login})
    public void onViewClicked(View view) {
        String psw = loginPsw.getText().toString().trim();
        String phone = loginPhone.getText().toString().trim();
        switch (view.getId()) {
            case R.id.btn_code:
                if (voliData(phone, psw)) {
                    sendCode(phone, psw);
                }
                break;
            case R.id.btn_login:
                String code = loginCode.getText().toString().trim();

                if (AppUtils.isNetworkAvailable(this)) {
                    if (voliData(phone, psw) && voliLoginCode(code)) {
                        login(psw, phone, code, "1");
                    }
                } else {
                    ToastUtils.showToast(this, Constants.NETWORK_ERROR);
                }
                break;
        }
    }

    private void login(final String psw, final String phone, String code, String terminalType) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("account", phone);
        httpParams.put("pwd", psw);
        httpParams.put("code", code);
        httpParams.put("loginType", Constants.LoginType.loginNormal);
        httpParams.put("terminalType", terminalType);

        OkGo.post(HttpApi.LOGIN_URL)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<UserInfo, DataMapLoginBean>>(this) {
                    @Override
                    public void onCall(BaseEntity<UserInfo, DataMapLoginBean> user, Call call, Response response) {
                        loginCodeTimer.cancel();

                        //储存用户账号密码
                        UserInfo userInfo = user.getData();
                        userInfo.setUserPassword(psw);
                        userInfo.setToken(user.getDataMap().getToken());
                        LoginManager.getInstance().saveUserInfo(userInfo);
                        SPUtils.put(LoginAc.this, "account", phone);

                        //添加推送账号
                        addJpush();
                        checkAlias();
                        if (isGestureShipLogin) {//是否是手势登录页跳转至登录页面
                            AppManager.getAppManager().finishActivity();
                            finish();
                        } else if (TextUtils.isEmpty(LoginManager.getInstance().getUserInfo().getGesturePwd())) {
                            //判断是否是首次安装或卸载安装
                            if (LoginManager.getInstance().getFirstLogin()) {   //首次打开，已登录，未设置手势
                                GestureLockEditActivity.goToGestureLockEditActivity(LoginAc.this, Constants.GestureState.SET_GETSTURE_TYPE_FIRSR_LOGIN);
                            } else { //不是首次打开，已登录，未设置手势
                                MainActivity.goToMainActivity(LoginAc.this);
                            }
                        } else {   //已登录，已设置手势
                            MainActivity.goToMainActivity(LoginAc.this);
                        }
                        LoginManager.getInstance().setFirstLogin(false);
//                        ToastUtils.showToast(LoginAc.this, LoginManager.getInstance().getUserInfo().getMessage());

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(LoginAc.this, e.toString());
                    }
                });
    }

    /**
     * 检测别名是否注册成功,若失败则再次注册
     */
    public void checkAlias() {

        Set<String> set = new HashSet<>();
        set.add("LG_ONLINE");
        JPushInterface.setAliasAndTags(this, JPushInterface.getRegistrationID(this), set, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                Log.i("TAG", "login alias-->" + i + " " + s);
                if (i != 0) {
                    checkAlias();
                }
            }
        });
    }

    /**
     * 添加推送设备
     */
    private void addJpush() {
        if (!TextUtils.isEmpty(registration)) {
            Log.i("TAG", "registration-->" + registration);
            HttpParams httpParams = new HttpParams();
            httpParams.put("token", LoginManager.getInstance().getToken());
            httpParams.put("deviceId", registration);
            httpParams.put("pushType", "1");//代表android
            httpParams.put("userAccount", LoginManager.getInstance().getLoginAccount());//登录账户
            OkGo.post(HttpApi.jpushAdd)
                    .params(httpParams)
                    .execute(new ResCallBack<BaseEntity>(LoginAc.this, false) {
                        @Override
                        public void onCall(BaseEntity entity, Call call, Response response) throws JSONException {
                            Log.i("TAG", "jpush add");
                        }
                    });
        } else {
            ToastUtils.showToast(LoginAc.this, "极光注册设备失败!");
        }
    }

    private boolean voliData(String phone, String psw) {
        if (phone.isEmpty()) {
            ToastUtils.showToast(this, "请输入用户名");
            return false;
        }
        if (psw.isEmpty()) {
            ToastUtils.showToast(this, "请输入密码");
            return false;
        }

        return true;
    }

    private boolean voliLoginCode(String code) {
        if (code.isEmpty()) {
            ToastUtils.showToast(this, "请输入验证码");
            return false;
        }
        return true;
    }

    private void sendCode(final String phone, final String psw) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("account", phone);
        httpParams.put("pwd", psw);
        OkGo.post(HttpApi.LOGIN)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(LoginAc.this, false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) {
                        if (entity != null) {
                            if ("1000".equals(entity.getStateCode())) {
                                loginCodeTimer.start();
                            }
                            ToastUtils.showToast(LoginAc.this, entity.getMessage());
                        }
                    }
                });
    }

    /**
     * 页面跳转
     *
     * @param context
     */
    public static void goToLoginAc(Context context) {
        Intent intent = new Intent(context, LoginAc.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 登录验证码倒计时
     */
    private CountDownTimer loginCodeTimer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            btnCode.setText(millisUntilFinished / 1000 + "秒后可点击");
            btnCode.setBackgroundResource(R.drawable.login_code_bg_enable);
            btnCode.setClickable(false);
        }

        @Override
        public void onFinish() {
            btnCode.setText("获取验证码");
            btnCode.setClickable(true);
            btnCode.setBackgroundResource(R.color.code_bg);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //覆盖baseAc的方法，强制更新处弹窗消失
    }
}
