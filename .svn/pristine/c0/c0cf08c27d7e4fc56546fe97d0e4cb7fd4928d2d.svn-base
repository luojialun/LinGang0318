package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.activity.login.LoginAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.LoginBase;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.MD5Util;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.CircleImageView;
import com.lingang.view.dialog.NormalAlertDialog;
import com.lingang.view.dialog.NormalDialog;
import com.lingang.view.gesturelock.ACache;
import com.lingang.view.gesturelock.GestureSetSuccess;
import com.lingang.view.gesturelock.LockPatternView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 手势编辑页面
 */
public class GestureLockEditActivity extends BaseAc {
    @BindView(R.id.gesture_lock_edit_tip_tv)
    TextView gestureLockEditTipTv;
    @BindView(R.id.gesture_lock_edit_lockpatternview)
    LockPatternView lockPatternView;
    //    @BindView(R.id.setting_gesture_edit_title_bar)
//    TitleBar settingGestureEditTitleBar;
    @BindView(R.id.gesture_lock_edit_user_icon)
    CircleImageView gestureLockEditUserIcon;
    @BindView(R.id.login_gesture_edit_skip_tv)
    TextView loginGestureEditSkipTv;

    private List<LockPatternView.Cell> mChosenPattern = null;
    private ACache aCache;
    private static final long DELAYTIME = 600L;
    private static final String TAG = "GestureLockEditActivity";
    //private LoginResponse.UserInfo userInfo;

    private NormalAlertDialog alertDialog;

    private boolean setSuccess;
    private int setGestureType;  //根据该字段来判断是否需要显示跳过按钮

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_gesture_lock_edit);
        setTitle("修改密码设置");
        ButterKnife.bind(this);
        Intent intent = getIntent();
        setGestureType = intent.getIntExtra(Constants.SET_GETSTURE_TYPE, Constants.GestureSwitch.GESTURE_SWITCH_OPEN);
        initData();
        initListener();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void initListener() {
//        settingGestureEditTitleBar.setOnClickTitleBarListener(this);
    }

    private void initData() {
        aCache = ACache.get(this);
        //userInfo = LoginUtils.getUserInfo();
        byte[] gesturePasswords = aCache.getAsBinary("GesturePassword");


    }

    private void initView() {
        if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_FIRSR_LOGIN) {
            loginGestureEditSkipTv.setVisibility(View.VISIBLE);
            //settingGestureEditTitleBar.showLeftTextView();
        } else if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_SETTING_INTO) {
            loginGestureEditSkipTv.setVisibility(View.INVISIBLE);
            //settingGestureEditTitleBar.showLeftTextView();
        } else if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_MODIFY) {
            loginGestureEditSkipTv.setVisibility(View.INVISIBLE);
            //settingGestureEditTitleBar.showLeftTextView();
            //settingGestureEditTitleBar.setTitleText("修改手势密码");
        }
        lockPatternView.setOnPatternListener(patternListener);
        gestureLockEditUserIcon.setImageResource(R.mipmap.user_pic);

        initDialog();
    }

    public void onClickLeft(View v) {
        //通知设置界面刷新
        EventBus.getDefault().post(new GestureSetSuccess(2));
        finish();
    }

    //点击跳过按钮
    @OnClick(R.id.login_gesture_edit_skip_tv)
    public void skipSetting(View view) {
        if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_FIRSR_LOGIN) {
            //SPUtils.put(GestureLockEditActivity.this, Constants.IS_FIRST_LOGIN, false);
            MainActivity.goToMainActivity(GestureLockEditActivity.this);
        }
    }


    /**
     * 手势监听
     */
    private LockPatternView.OnPatternListener patternListener = new LockPatternView.OnPatternListener() {

        @Override
        public void onPatternStart() {
            lockPatternView.removePostClearPatternRunnable();
            //updateStatus(Status.DEFAULT, null);
            lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
        }

        @Override
        public void onPatternComplete(List<LockPatternView.Cell> pattern) {
            //Log.e(TAG, "--onPatternDetected--");
            if (mChosenPattern == null && pattern.size() >= 4) {
                mChosenPattern = new ArrayList<LockPatternView.Cell>(pattern);
                updateStatus(Status.CORRECT, pattern);
            } else if (mChosenPattern == null && pattern.size() < 4) {
                updateStatus(Status.LESSERROR, pattern);
            } else if (mChosenPattern != null) {
                if (mChosenPattern.equals(pattern)) {
                    updateStatus(Status.CONFIRMCORRECT, pattern);
                } else {
                    updateStatus(Status.CONFIRMERROR, pattern);
                    setRightTv("重设");

                }
            }
        }
    };

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        getRightTextView().setVisibility(View.GONE);
        mChosenPattern=null;
        lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
        gestureLockEditTipTv.setTextColor(getResources().getColor(Status.DEFAULT.colorId));
        gestureLockEditTipTv.setText(Status.DEFAULT.strId);
    }

    /**
     * 更新状态
     *
     * @param status
     * @param pattern
     */
    private void updateStatus(Status status, List<LockPatternView.Cell> pattern) {
        gestureLockEditTipTv.setTextColor(getResources().getColor(status.colorId));
        gestureLockEditTipTv.setText(status.strId);
        switch (status) {
            case DEFAULT:
                lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
                break;
            case CORRECT:
                updateLockPatternIndicator();
                lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
                break;
            case LESSERROR:
                // 左右移动动画
                Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
                gestureLockEditTipTv.startAnimation(shakeAnimation);
                lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
                break;
            case CONFIRMERROR:
                lockPatternView.setPattern(LockPatternView.DisplayMode.ERROR);
                lockPatternView.postClearPatternRunnable(DELAYTIME);
                break;
            case CONFIRMCORRECT:
                saveChosenPattern(pattern);
                lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
                break;
        }
    }

    /**
     * 更新 Indicator
     */
    private void updateLockPatternIndicator() {
        if (mChosenPattern == null)
            return;
    }


    /**
     * 保存手势密码
     */
    private void saveChosenPattern(List<LockPatternView.Cell> cells) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cells.size(); i++) {
            builder.append(cells.get(i).getIndex());
        }
        String gesturePassword = builder.toString();
        Log.d(TAG, gesturePassword);
        aCache.put("GesturePassword", gesturePassword.getBytes());
        String md5Password = MD5Util.byteMD5(gesturePassword.getBytes());

        Log.e("gesture", gesturePassword);
        if (gesturePassword == null) {
            throw new RuntimeException("手势密码设置为空");
        }
        saveService(md5Password);   //把手势密码保存到网络
    }


    /**
     * 将手势密码
     * 保存到服务器
     */
    private void saveService(final String gesturePwd) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("newPwd", gesturePwd);
        OkGo.post(HttpApi.GESTURE_PWD)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(GestureLockEditActivity.this, false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) {
                        if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_MODIFY) {
                            if (App.stateCode.equals(entity.getStateCode())) {
                                alertDialog.setMessage("手势密码修改成功");
                                setSuccess = true;
                                LoginManager.getInstance().setGesturePwd(gesturePwd);

                            } else {
                                alertDialog.setMessage("手势密码修改失败，请重新设置");
                                setSuccess = false;
                                mChosenPattern = null;
                            }
                        } else if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_FIRSR_LOGIN) {
                            if (App.stateCode.equals(entity.getStateCode())) {
                                alertDialog.setMessage("手势密码设置成功");
                                setSuccess = true;
                                LoginManager.getInstance().setGesturePwd(gesturePwd);
                                handleSetGestureState();

                            } else {
                                alertDialog.setMessage("手势密码设置失败，请重新设置");
                                setSuccess = false;
                                mChosenPattern = null;
                            }
                        } else if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_SETTING_INTO) {
                            if (App.stateCode.equals(entity.getStateCode())) {
                                alertDialog.setMessage("手势密码设置成功");
                                setSuccess = true;
                                LoginManager.getInstance().setGesturePwd(gesturePwd);
                                handleSetGestureState();

                            } else {
                                alertDialog.setMessage("手势密码设置失败，请重新设置");
                                setSuccess = false;
                                mChosenPattern = null;
                            }
                        }

                        alertDialog.show();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);

                    }
                });

        /*HashMap<String, String> params = new HashMap<>();
        params.put("token", (String) SPUtils.get(MyApplication.mContext, Constants.TOKEN, ""));
        params.put("newPwd", gesturePwd);
        OkHttpUtils.post(Api.GESTURE_PWD)//
                .tag(this)//
                .params(params)
                .execute(new DialogCallback<BaseEntity>(this, BaseEntity.class) {
                    @Override
                    public void onResponse(boolean isFromCache, BaseEntity baseEntity, Request request, @Nullable Response response) {
                        if (alertDialog == null) {
                            initDialog();
                        }
                        if (setGestureType == Constants.SET_GETSTURE_TYPE_MODIFY) {
                            if ("1000".equals(baseEntity.getStateCode())) {
                                alertDialog.setMessage("手势密码修改成功");
                                setSuccess = true;
                                LoginResponse.UserInfo userInfo = LoginUtils.getUserInfo();
                                userInfo.setGesturePwd(gesturePwd);
                                LoginUtils.saveUserInfo(userInfo);

                            } else {
                                alertDialog.setMessage("手势密码修改失败，请重新设置");
                                setSuccess = false;
                                mChosenPattern = null;
                            }
                        } else if (setGestureType == Constants.SET_GETSTURE_TYPE_FIRSR_LOGIN) {
                            if ("1000".equals(baseEntity.getStateCode())) {
                                alertDialog.setMessage("手势密码设置成功");
                                setSuccess = true;
                                LoginResponse.UserInfo userInfo = LoginUtils.getUserInfo();
                                userInfo.setGesturePwd(gesturePwd);
                                LoginUtils.saveUserInfo(userInfo);

                            } else {
                                alertDialog.setMessage("手势密码设置失败，请重新设置");
                                setSuccess = false;
                                mChosenPattern = null;
                            }
                        } else if (setGestureType == Constants.SET_GETSTURE_TYPE_SETTING_INTO) {
                            if ("1000".equals(baseEntity.getStateCode())) {
                                alertDialog.setMessage("手势密码设置成功");
                                setSuccess = true;
                                LoginResponse.UserInfo userInfo = LoginUtils.getUserInfo();
                                userInfo.setGesturePwd(gesturePwd);
                                LoginUtils.saveUserInfo(userInfo);
                                handleSetGestureState();

                            } else {
                                alertDialog.setMessage("手势密码设置失败，请重新设置");
                                setSuccess = false;
                                mChosenPattern = null;
                            }
                        }

                        alertDialog.show();


                    }

                    @Override
                    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
                        super.onError(isFromCache, call, response, e);
                        if (alertDialog == null) {
                            initDialog();
                        }
                        mChosenPattern = null;
                        alertDialog.setMessage("手势密码设置失败，请重新设置");
                        gestureLockEditTipTv.setText("设置失败");
                        setSuccess = false;
                        alertDialog.show();
                    }
                });*/

    }

    /**
     * 设置手势密码开关接口
     */
    private void handleSetGestureState() {

        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("gestureState", Constants.GestureSwitch.GESTURE_SWITCH_OPEN);
        OkGo.post(HttpApi.GESTUEE_STATE)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(GestureLockEditActivity.this, false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) {
                        if (LoginManager.getInstance().getUserInfo() != null) {
                            LoginManager.getInstance().setGestureState(String.valueOf(Constants.GestureSwitch.GESTURE_SWITCH_OPEN));
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(GestureLockEditActivity.this, "通知云端手势密码开关打开，接口返回失败");
                    }
                });


        /*HashMap<String, String> params = new HashMap<>();
        params.put("token", (String) SPUtils.get(MyApplication.mContext, Constants.TOKEN, ""));
        params.put("gestureState", Constants.GESTURE_SWITCH_OPEN + "");
        OkHttpUtils.post(Api.GESTUEE_STATE)//
                .tag(this)//
                .params(params)
                .execute(new JsonCallback<BaseEntity>(BaseEntity.class) {
                    @Override
                    public void onResponse(boolean isFromCache, BaseEntity baseEntity, Request request, @Nullable Response response) {
                        LogUtils.d(TAG, "通知云端手势密码开关打开，接口返回成功");
                        LoginResponse.UserInfo userInfo = LoginUtils.getUserInfo();
                        userInfo.setGestureState(Constants.GESTURE_SWITCH_OPEN);
                        LoginUtils.saveUserInfo(userInfo);

                    }

                    @Override
                    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
                        super.onError(isFromCache, call, response, e);
                        LogUtils.d(TAG, "通知云端手势密码开关打开，接口返回失败");
                    }
                });*/
    }

    //初始化弹窗
    private void initDialog() {
        alertDialog = new NormalAlertDialog.Builder(this)
                .setTitleVisible(false)
                .setHeight(0.15f)  //屏幕高度*0.23
                .setWidth(0.65f)  //屏幕宽度*0.65
                .setContentText("手势密码设置成功")
                .setContentTextSize(16)
                .setContentTextColor(R.color.black_80)
                .setSingleMode(true)
                .setSingleButtonText("确定")
                .setSingleButtonTextColor(R.color.c_0076ff)
                .setButtonTextSize(18)
                .setCanceledOnTouchOutside(false)
                .setSingleListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (setSuccess) {
                            if (setGestureType == Constants.GestureState.SET_GETSTURE_TYPE_FIRSR_LOGIN) {
                                MainActivity.goToMainActivity(GestureLockEditActivity.this);
                            } else {
                                //通知设置界面刷新
                                EventBus.getDefault().post(new GestureSetSuccess(2));
                            }
                            finish();
                        }
                        alertDialog.dismiss();

                    }
                })
                .build();
    }

    /**
     * 保存手势状态
     * @param gestureState
     */
//    private void saveGestureState(int gestureState)
//    {
//        LoginBase loginBase = App.getInstance().getUserInfo();
//        if(loginBase !=null)
//        {
//            LoginBase.DataBean userInfo=loginBase.getData();
//            userInfo.setGestureState(String.valueOf(gestureState));
//        }
//        App.getInstance().writeUserInfo(loginBase);
//    }

    /**
     * 保存手势密码
     * @param gesturePwd
     */
//    private void saveGesturePwd(final String gesturePwd)
//    {
//        LoginBase loginBase = App.getInstance().getUserInfo();
//        if(loginBase !=null)
//        {
//            LoginBase.DataBean userInfo=loginBase.getData();
//            userInfo.setGesturePwd(gesturePwd);
//        }
//        App.getInstance().writeUserInfo(loginBase);
//    }

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void goToGestureLockEditActivity(Context context, int gestureType) {
        Intent intent = new Intent(context, GestureLockEditActivity.class);
        intent.putExtra(Constants.SET_GETSTURE_TYPE, gestureType);
        context.startActivity(intent);
    }

    private enum Status {
        //默认的状态，刚开始的时候（初始化状态）
        DEFAULT(R.string.create_gesture_default, R.color.a5a5a5),
        //第一次记录成功
        CORRECT(R.string.create_gesture_correct, R.color.a5a5a5),
        //连接的点数小于4（二次确认的时候就不再提示连接的点数小于4，而是提示确认错误）
        LESSERROR(R.string.create_gesture_less_error, R.color.f4333c),
        //二次确认错误
        CONFIRMERROR(R.string.create_gesture_confirm_error, R.color.f4333c),
        //二次确认正确
        CONFIRMCORRECT(R.string.create_gesture_confirm_correct, R.color.a5a5a5);


        private Status(int strId, int colorId) {
            this.strId = strId;
            this.colorId = colorId;
        }

        private int strId;
        private int colorId;
    }
}
