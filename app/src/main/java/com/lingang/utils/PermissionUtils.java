package com.lingang.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.lingang.App;
import com.lingang.callback.PermissionCallback;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

/**
 * Created by jason on 17/8/3.
 * 权限辅助类
 //rxjava 1
 compile 'io.reactivex:rxjava:1.2.9'
 compile 'io.reactivex:rxandroid:1.2.0'
 //权限引导
 compile 'com.tbruyelle.rxpermissions:rxpermissions:0.9.4@aar'
 */
public class PermissionUtils {
    //SD卡读写权限
    public final static String[] SD_PERMISSIONS =new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
    public final static String[] SD_CAMERA_PERMISSIONS=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
    public final static String[] PHONE_PERMISSION =new String[]{Manifest.permission.CALL_PHONE};
    /**
     * 申请权限
     * @param content 上下文
     * @param permissions 申请所需权限
     */
    public static void checkPermission(final Context content, String [] permissions) {
        checkPermission(content,permissions, App.Empty,App.Empty,null);
    }
    /**
     * 申请权限
     * @param content 上下文
     * @param permissions 申请所需权限
     * @param errorMsg 错误提示消息
     */
    public static void checkPermission(final Context content, String [] permissions,final String errorMsg) {
        checkPermission(content,permissions, App.Empty,errorMsg,null);
    }
    /**
     * 申请权限
     * @param content 上下文
     * @param permissions 申请所需权限
     * @param callback 申请后回调
     */
    public static void checkPermission(final Context content, String [] permissions,PermissionCallback callback) {
        checkPermission(content,permissions, App.Empty,App.Empty,callback);
    }
    /**
     * 申请权限
     * @param content 上下文
     * @param permissions 申请所需权限
     * @param errorMsg 错误提示消息
     * @param callback 申请后回调
     */
    public static void checkPermission(final Context content, String [] permissions,final String errorMsg,PermissionCallback callback) {
        checkPermission(content,permissions, App.Empty,errorMsg,callback);
    }
    /**
     * 申请权限
     * @param content 上下文
     * @param permissions 申请所需权限
     * @param okMsg 正确提示消息
     * @param errorMsg 错误提示消息
     * @param callback 申请后回调
     */
    public static void checkPermission(final Context content, String [] permissions,final String okMsg,final String errorMsg,final PermissionCallback callback) {
        RxPermissions rxPermissions = new RxPermissions((Activity) content);
        rxPermissions.request(permissions)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            if(!TextUtils.isEmpty(okMsg)) {
                                Toast.makeText(content, okMsg, Toast.LENGTH_SHORT).show();
                            }
                            if (callback != null) {
                                callback.onRequestCallBack(true);
                            }
                        } else {
                            if(!TextUtils.isEmpty(errorMsg)) {
                                Toast.makeText(content, errorMsg, Toast.LENGTH_LONG).show();
                            }
                            if (callback != null) {
                                callback.onRequestCallBack(false);
                            }
                        }
                    }

                });
    }
}
