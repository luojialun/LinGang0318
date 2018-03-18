package com.vector.update_app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.vector.update_app.service.DownloadService;
import com.vector.update_app.utils.Utils;

import java.net.CookieStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * 版本更新管理器
 */
public class UpdateAppManager {
    final static String INTENT_KEY = "update_dialog_values";
    final static String THEME_KEY = "theme_color";
    final static String TOP_IMAGE_KEY = "top_resId";
    private final static String UPDATE_APP_KEY = "UPDATE_APP_KEY";
    private static final String TAG = UpdateAppManager.class.getSimpleName();
    private Map<String, String> mParams;
    private Activity mActivity;
    private HttpManager mHttpManager;
    private String mUpdateUrl;
    private int mThemeColor;
    private
    @DrawableRes
    int mTopPic;
    private String mAppKey;
    private UpdateAppBean mUpdateApp;
    private String mTargetPath;
    private boolean isPost;
    private boolean mHideDialog;
    public static int resultCloseCode = 99;//关闭状态

    private static UpdateAppManager updateAppManager;


    private UpdateAppManager(Builder builder) {
        mActivity = builder.getActivity();
        mHttpManager = builder.getHttpManager();
        mUpdateUrl = builder.getUpdateUrl();

        mThemeColor = builder.getThemeColor();
        mTopPic = builder.getTopPic();

        mAppKey = builder.getAppKey();
        mTargetPath = builder.getTargetPath();
        isPost = builder.isPost();
        mParams = builder.getParams();
        mHideDialog = builder.isHideDialog();
    }

    /**
     * 跳转到更新页面
     */
    public void showDialog() {

        String preSuffix = "/storage/emulated";

        if (TextUtils.isEmpty(mTargetPath) || !mTargetPath.startsWith(preSuffix)) {
            Log.e(TAG, "下载路径错误:" + mTargetPath);
            return;
        }
        if (mUpdateApp == null) {
            return;
        }

        if (mActivity != null && !mActivity.isFinishing()) {
            Intent updateIntent = new Intent(mActivity, DialogActivity.class);
            mUpdateApp.setTargetPath(mTargetPath);
            mUpdateApp.setHttpManager(mHttpManager);
            mUpdateApp.setHideDialog(mHideDialog);
            updateIntent.putExtra(INTENT_KEY, mUpdateApp);
            if (mThemeColor != 0) {
                updateIntent.putExtra(THEME_KEY, mThemeColor);
            }

            if (mTopPic != 0) {
                updateIntent.putExtra(TOP_IMAGE_KEY, mTopPic);
            }
            //mActivity.startActivity(updateIntent);
            String name = getCurrentActivityName(mActivity);
            Log.i("TAG", "name-->" + name);
            if (!getCurrentActivityName(mActivity).equals("com.vector.update_app.DialogActivity")) {
                mActivity.startActivityForResult(updateIntent, UpdateAppManager.resultCloseCode);
            }
        }
    }

    private String getCurrentActivityName(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Activity.ACTIVITY_SERVICE);
        // get the info from the currently running task
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        ComponentName componentInfo = taskInfo.get(0).topActivity;
        return componentInfo.getClassName();
    }

    /**
     * 检测是否有新版本
     *
     * @param callback 更新回调
     */
    public void checkNewApp(final UpdateCallback callback) {
        if (callback == null) {
            return;
        }
        callback.onBefore();

        if (DialogActivity.isShow || DownloadService.isRunning) {
            callback.onAfter();
//            Toast.makeText(mActivity, "app正在更新", Toast.LENGTH_SHORT).show();
            return;
        }
        //拼接参数

        Map<String, String> params = new HashMap<String, String>();

        params.put("appKey", mAppKey);
        String versionName = Utils.getVersionName(mActivity);
        if (versionName.endsWith("-debug")) {
            versionName = versionName.substring(0, versionName.lastIndexOf('-'));
        }
        params.put("version", versionName);


        //添加自定义参数，其实可以实现HttManager中添加
        if (mParams != null && !mParams.isEmpty()) {
            params.putAll(mParams);
        }

        //网络请求
        if (isPost) {
            mHttpManager.asyncPost(mUpdateUrl, params, new HttpManager.Callback() {

                @Override
                public void onResponse(String result) {
                    callback.onAfter();
                    if (!TextUtils.isEmpty(result)) {
                        Log.i("TAG", "更新包请求结果-->" + result);
                        processData(result, callback);
                    }
                }

                @Override
                public void onError(String error) {
                    callback.onAfter();
                    callback.noNewApp();
                }
            });
        } else {
            mHttpManager.asyncGet(mUpdateUrl, params, new HttpManager.Callback() {
                @Override
                public void onResponse(String result) {
                    callback.onAfter();
                    if (result != null) {
                        processData(result, callback);
                    }
                }

                @Override
                public void onError(String error) {
                    callback.onAfter();
                    callback.noNewApp();
                }
            });
        }
    }

    /**
     * 解析
     *
     * @param result
     * @param callback
     */
    private void processData(String result, @NonNull UpdateCallback callback) {
        try {
            mUpdateApp = callback.parseJson(result);
            if (mUpdateApp.isUpdate()) {
                callback.hasNewApp(mUpdateApp, this);
            } else {
                callback.noNewApp();
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
            callback.noNewApp();
        }
    }

    public static class Builder {
        //必须有
        private Activity mActivity;
        //必须有
        private HttpManager mHttpManager;
        //必须有
        private String mUpdateUrl;

        private int mThemeColor = 0;
        private
        @DrawableRes
        int mTopPic = 0;
        private String mAppKey;
        private String mTargetPath;
        private boolean isPost;

        //自定义参数
        private Map<String, String> params;
        //是否隐藏对话框下载进度条
        private boolean mHideDialog;

        public Map<String, String> getParams() {
            return params;
        }

        public Builder setParams(Map<String, String> params) {
            this.params = params;
            return this;
        }

        public boolean isPost() {
            return isPost;
        }

        public Builder setPost(boolean post) {
            isPost = post;
            return this;
        }

        public String getTargetPath() {
            return mTargetPath;
        }

        public Builder setTargetPath(String targetPath) {
            mTargetPath = targetPath;
            return this;
        }

        public String getAppKey() {
            return mAppKey;
        }

        public Builder setAppKey(String appKey) {
            mAppKey = appKey;
            return this;
        }

        public Activity getActivity() {
            return mActivity;
        }

        public Builder setActivity(Activity activity) {
            mActivity = activity;
            return this;
        }

        public HttpManager getHttpManager() {
            return mHttpManager;
        }

        public Builder setHttpManager(HttpManager httpManager) {
            mHttpManager = httpManager;
            return this;
        }

        public String getUpdateUrl() {
            return mUpdateUrl;
        }

        public Builder setUpdateUrl(String updateUrl) {
            mUpdateUrl = updateUrl;
            return this;
        }

        public int getThemeColor() {
            return mThemeColor;
        }

        public Builder setThemeColor(int themeColor) {
            mThemeColor = themeColor;
            return this;
        }

        public int getTopPic() {
            return mTopPic;
        }

        public Builder setTopPic(int topPic) {
            mTopPic = topPic;
            return this;
        }

        /**
         * @return 生成app管理器
         */
        public UpdateAppManager build() {
            //校验
            if (getActivity() == null || getHttpManager() == null || TextUtils.isEmpty(getUpdateUrl())) {
                throw new NullPointerException("必要参数不能为空");
            }
            if (TextUtils.isEmpty(getTargetPath())) {
                String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
                setTargetPath(path);
            }
            if (TextUtils.isEmpty(getAppKey())) {
                String appKey = Utils.getManifestString(getActivity(), UPDATE_APP_KEY);
                if (TextUtils.isEmpty(appKey)) {
//                    throw new NullPointerException("appKey 为空");
                } else {
                    setAppKey(appKey);
                }
            }

            return new UpdateAppManager(this);
        }

        public Builder hideDialogOnDownloading(boolean b) {
            mHideDialog = b;
            return this;
        }

        public boolean isHideDialog() {
            return mHideDialog;
        }
    }
}