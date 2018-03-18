package com.lingang.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.activity.user.GestureLockLoginActivity;
import com.lingang.base.BaseAc;
import com.lingang.bean.UpdateBean;
import com.lingang.callback.PermissionCallback;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.http.HttpApi;
import com.lingang.http.manager.UpdateAppHttpUtil;
import com.lingang.utils.AppUtils;
import com.lingang.utils.PermissionUtils;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StartAc extends BaseAc {

    private UpdateAppHttpUtil updateHttpUtil;
    /**
     * 等待加载
     */
    private Handler waitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
    }

    private void initView() {
        waitHandler.postDelayed(gotoRunable, 8000);
        //申请SD卡权限
        PermissionUtils.checkPermission(this, PermissionUtils.SD_PERMISSIONS, getString(R.string.permission_failed), new PermissionCallback() {
            @Override
            public void onRequestCallBack(boolean isSuccess) {
                if (isNetwork()) {
                    checkUpdate();
                } else {
                    waitHandler.removeCallbacks(gotoRunable);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            checkLogin();
                        }
                    }, 3000);
                }
            }
        });
    }

    /**
     * 检查登录
     */
    private void checkLogin() {
        if (LoginManager.getInstance().isLogin()
                && LoginManager.getInstance().getGestureState().equals(String.valueOf(Constants.GestureSwitch.GESTURE_SWITCH_OPEN))) {//手势密码登录
            Intent intent = new Intent(StartAc.this, GestureLockLoginActivity.class);
            intent.putExtra("fromLogin", Constants.LoginType.loginPwdGesture);
            startActivity(intent);
        } else if (LoginManager.getInstance().isLogin()) {
            //已登录》默认打开
            MainActivity.goToMainActivity(StartAc.this);
        } else {
            //登录页面
            LoginAc.goToLoginAc(StartAc.this);
        }
    }

    /**
     * 检查更新
     */
    private void checkUpdate() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("type", Constants.UpdateType.ANDROID);
        updateHttpUtil = new UpdateAppHttpUtil();
        new UpdateAppManager
                .Builder()
                .setActivity(this) //当前Activity
                .setHttpManager(updateHttpUtil)  //实现httpManager接口的对象
                .setPost(false)//设置请求方式 默认get,
                .setUpdateUrl(HttpApi.GetLastestVersion) //更新地址
                .setParams(params)//添加自定义参数
                .setTopPic(R.mipmap.top_8)//设置头部
                .setThemeColor(0xff7EB2EC)//设置主题色
                .build()
                .checkNewApp(new UpdateCallback() { //检测是否有新版本
                    @Override
                    protected UpdateAppBean parseJson(String json) {//解析json,自定义协议

                        waitHandler.removeCallbacks(gotoRunable);
                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            UpdateBean updateBean = new Gson().fromJson(jsonObject.optString("data"), UpdateBean.class);
                            boolean isForceUpdate = false;
                            if ("1".equals(updateBean.getForceUpdate())) {
                                isForceUpdate = true;
                            }
                            if (updateBean != null) {
                                if (AppUtils.isUpdate(updateBean.getVersionId())) {
                                    updateAppBean
                                            .setUpdate("Yes") //是否更新Yes,No
                                            .setNewVersion(updateBean.getVersionId()) //新版本号
                                            .setApkFileUrl(HttpApi.IMAGE_BASE_SERVER + updateBean.getFileAddress()) //下载地址
                                            .setTargetSize(String.valueOf(updateBean.getFileSize())) //大小
                                            .setUpdateLog(updateBean.getUpdateContent()) //更新内容 测试更新内容过多
                                            .setConstraint(isForceUpdate); //是否强制更新
//                                      .setNewMd5(jsonObject.optString("new_md5ddfdfdf")); //设置md5
                                } else {//版本小于等于当前版本
                                    updateAppBean.setUpdate("No");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return updateAppBean;
                    }

                    /**
                     * 有新版本
                     * @param updateApp        新版本信息
                     * @param updateAppManager app更新管理器
                     */
                    @Override
                    public void hasNewApp(UpdateAppBean updateApp, UpdateAppManager updateAppManager) {
                        waitHandler.removeCallbacks(gotoRunable);
                        updateAppManager.showDialog();
                        PermissionUtils.checkPermission(StartAc.this, PermissionUtils.SD_PERMISSIONS, getString(R.string.permission_failed));

                    }

                    @Override
                    public void onBefore() { //网络请求之前
                    }

                    @Override
                    public void onAfter() { //网路请求之后
                    }

                    @Override
                    public void noNewApp() {//没有新版本
                        waitHandler.removeCallbacks(gotoRunable);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                checkLogin();
                            }
                        }, 1500);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UpdateAppManager.resultCloseCode) {//监听更新界面的关闭事件
            boolean isForceUpdate = data.getBooleanExtra("isForceUpdate", false);
            if (isForceUpdate) {
                Intent intent = new Intent(this, LoginAc.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                checkLogin();
            }
        }
    }

    private Runnable gotoRunable = new Runnable() {
        @Override
        public void run() {
            updateHttpUtil.cancelTag();
            checkLogin();
        }
    };
}
