package com.lingang.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

import com.lingang.common.LoginManager;

/**
 * @name LinGang
 * @class name：com.lingang.utils
 * @class describe
 * @anthor Administrator
 * @time 2017/6/27 0027 17:01
 * @change
 * @chang time
 * @class describe
 */
public class HttpLoading {

    private static HttpLoading loadingInstance;

    public static HttpLoading getInstance() {
        if (null == loadingInstance) {
            synchronized (LoginManager.class) {
                if (null == loadingInstance) {
                    loadingInstance = new HttpLoading();
                }
            }
        }
        return loadingInstance;
    }

    public ProgressDialog initLoading(Context context) {

        ProgressDialog loadingDialog = new ProgressDialog(context);
            loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            loadingDialog.setCanceledOnTouchOutside(false);
            loadingDialog.setMessage("请求中...");

        return loadingDialog;
    }
}
