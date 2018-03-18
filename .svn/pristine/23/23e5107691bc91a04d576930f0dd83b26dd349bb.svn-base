package com.lingang.utils;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtils
 */
public class ToastUtils {
    private static Toast toast = null; //Toast的对象！

    public static void showToast(Context mContext, String content) {
        if (toast == null) {
            toast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
