package com.lingang.callback;

/**
 * Created by jason on 17/7/28.
 * 申请权限回调
 */
public interface PermissionCallback {
    /**
     * 申请权限回调
     * @param isSuccess
     */
    void onRequestCallBack(boolean isSuccess);
}
