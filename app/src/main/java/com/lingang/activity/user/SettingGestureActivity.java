package com.lingang.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.lingang.App;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.LoginBase;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.ToastUtils;
import com.lingang.view.SettingItem;
import com.lingang.view.dialog.DialogCallback;
import com.lingang.view.dialog.NormalAlertDialog;
import com.lingang.view.dialog.NormalDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.HashMap;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 设置手势密码界面
 */
public class SettingGestureActivity extends BaseAc  {

    private static final String TAG = "SettingGestureActivity";

    @BindView(R.id.setting_modify_gesture)
    SettingItem settingModifyGesture;
    @BindView(R.id.switch_cb)
    CheckBox settingGestureSwitch;
    private LoginBase userInfo;
    //弹框
    NormalDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_setting_gesture);
        ButterKnife.bind(this);
        //注册eventbus事件
       //EventBus.getDefault().register(this);
        initView();
        initListener();
        //initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注册eventbus事件
//        if (EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().unregister(this);
//        }
    }

//    private void initData() {
//        userInfo = LoginUtils.getUserInfo();
//    }
//
    private void initView() {
            setTitle(getString(R.string.setting_gesture));
            dialog=new NormalDialog(this);
        if (TextUtils.isEmpty(LoginManager.getInstance().getGesturePwd())){
            settingGestureSwitch.setChecked(false);
            settingModifyGesture.setVisibility(View.INVISIBLE);
        } else if (LoginManager.getInstance().getGestureState().equals(String.valueOf(Constants.GestureSwitch.GESTURE_SWITCH_CLOSE))) {
            settingGestureSwitch.setChecked(false);
        } else if (LoginManager.getInstance().getGestureState().equals(String.valueOf(Constants.GestureSwitch.GESTURE_SWITCH_OPEN))) {
            settingGestureSwitch.setChecked(true);
            settingModifyGesture.setVisibility(View.VISIBLE);
        }
    }

    private void initListener() {
        settingGestureSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                if(isChecked && TextUtils.isEmpty(LoginManager.getInstance().getGesturePwd())) {
                    //显示弹出框
                    dialog.showConfirm("还未设置手势密码,现在是否去设置？", "取消", "去设置", new DialogCallback<Boolean>() {
                        @Override
                        public void selectResult(Boolean aBoolean) {
                            if (aBoolean) {
                                //点击确认
                                GestureLockEditActivity.goToGestureLockEditActivity(SettingGestureActivity.this, Constants.GestureState.SET_GETSTURE_TYPE_SETTING_INTO);
                            } else {
                                //点击取消
                                settingGestureSwitch.setChecked(false);
                            }
                        }
                    });
                }else{
                    if(isChecked)
                    {
                        dialog.showConfirm("确认要打开手势密码？", "取消", "确认", new DialogCallback<Boolean>() {
                            @Override
                            public void selectResult(Boolean aBoolean) {
                                if (aBoolean) {
                                    openOrCloseGesture(isChecked);
                                }else {
                                    //点击取消
                                    settingGestureSwitch.setChecked(false);
                                }
                            }
                        });
                    }else
                    {
                        dialog.showConfirm("确认要关闭手势密码？", "取消", "确认", new DialogCallback<Boolean>() {
                            @Override
                            public void selectResult(Boolean aBoolean) {
                                if (aBoolean) {
                                    openOrCloseGesture(isChecked);
                                }else {
                                    //点击取消
                                    settingGestureSwitch.setChecked(true);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /**
     * 打开好关闭手势
     */
    private void openOrCloseGesture(boolean isChecked)
    {
        //点击确认
        settingModifyGesture.setVisibility(isChecked? View.VISIBLE:View.GONE);
        //更新手势状态
        handleHttp(isChecked?Constants.GestureSwitch.GESTURE_SWITCH_OPEN:Constants.GestureSwitch.GESTURE_SWITCH_CLOSE);
    }


    @OnClick(R.id.setting_modify_gesture)
    public void modifyGesture(View view) {
        GestureLockEditActivity.goToGestureLockEditActivity(SettingGestureActivity.this, Constants.GestureState.SET_GETSTURE_TYPE_MODIFY);
    }



    //通知云端手势密码开关打开
    public void handleHttp(final int gestureState) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token",LoginManager.getInstance().getToken());
        httpParams.put("gestureState", gestureState);
        OkGo.post(HttpApi.GESTUEE_STATE)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity>(SettingGestureActivity.this,false) {
                    @Override
                    public void onCall(BaseEntity entity, Call call, Response response) {
                        if(LoginManager.getInstance().getUserInfo() !=null) {
                            LoginManager.getInstance().setGestureState(String.valueOf(gestureState));
                        }
                        ToastUtils.showToast(SettingGestureActivity.this,"设置成功");
                    }
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(SettingGestureActivity.this,"设置失败");
                    }
                });
    }

    /**
     * 页面跳转
     * @param context
     */
    public static void goToSettingGestureActivity(Context context)
    {
        Intent intent=new Intent(context,SettingGestureActivity.class);
        context.startActivity(intent);
    }
}
