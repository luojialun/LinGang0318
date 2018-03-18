package com.lingang.common;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.lingang.App;
import com.lingang.bean.UserInfo;
import com.lingang.utils.SPUtils;

/**
 * 登录管理
 */
public class LoginManager {
    //登录信息
    public final String LOGIN_USER_INFO = "LOGIN_USER_INFO";
    //是否第一次登陆
    public final String IS_FIRST_LOGIN = "IS_FIRST_LOGIN";
    //登录实例
    private static LoginManager loginManager;
    public static LoginManager getInstance() {
        if (null == loginManager) {
            synchronized (LoginManager.class) {
                if (null == loginManager) {
                    loginManager = new LoginManager();
                }
            }
        }
        return loginManager;
    }
    /**
     * 返回token
     * @return
     */
    public String getToken()
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            return userInfo.getToken();
        }
        return App.Empty;
    }
    /**
     * 设置token
     * @param token
     */
    public void setToken(String token)
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            userInfo.setToken(token);
            saveUserInfo(userInfo);
        }
    }

    /**
     * 设置昵称
     * @param nickName
     */
    public void setNickName(String nickName)
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            userInfo.setUserNickname(nickName);
            saveUserInfo(userInfo);
        }
    }



    /**
     * 获取手势状态
     * @return
     */
    public String getGestureState()
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null && userInfo.getGestureState() !=null)
        {
            return userInfo.getGestureState();
        }
        return App.Empty;
    }

    /**
     * 设置手势密码
     * @return
     */
    public void setGestureState(String State)
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            userInfo.setGestureState(State);
            saveUserInfo(userInfo);
        }
    }

    /**
     * 获取手势密码
     * @return
     */
    public String getGesturePwd()
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            return userInfo.getGesturePwd();
        }
        return App.Empty;
    }

    /**
     * 设置手势密码
     * @return
     */
    public void setGesturePwd(String gesturePwd)
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            userInfo.setGesturePwd(gesturePwd);
            saveUserInfo(userInfo);
        }
    }

    /**
     * 返回登录账号
     * @return
     */
    public String getLoginAccount()
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            return userInfo.getUserAccount();
        }
        return App.Empty;
    }

    /**
     *更新用户头像
     */
    public void updateUserImage(String imgPath)
    {
        UserInfo userInfo=getUserInfo();
        if(userInfo !=null)
        {
            userInfo.setImgPath(imgPath);
            saveUserInfo(userInfo);
        }
    }
    /**
     * 是否已登录
     * @return
     */
    public boolean isLogin()
    {
        UserInfo userInfo=getUserInfo();
        return userInfo !=null?true:false;
    }
    /**
     * 清除登录
     */
    public void clearLogin()
    {
        saveUserInfo(null);
    }


    /**
     * 写入用户信息
     * @param user
     */
    public void saveUserInfo(UserInfo user) {
        String loginStr=App.Empty;
        if(user !=null)
        {
            loginStr= new Gson().toJson(user);
        }
        SPUtils.put(App.getInstance().getApplicationContext(), LOGIN_USER_INFO,loginStr);
    }
    /**
     * 读取用户信息
     * @return
     */
    public UserInfo getUserInfo() {
        String loginStr=(String)SPUtils.get(App.getInstance().getApplicationContext(), LOGIN_USER_INFO, App.Empty);
        return TextUtils.isEmpty(loginStr) ?null:new Gson().fromJson(loginStr, UserInfo.class);
    }

    /*******************扩展
     *是否第一次登陆
     */
    public boolean getFirstLogin()
    {
        return  (boolean)SPUtils.get(App.getInstance().getApplicationContext(), IS_FIRST_LOGIN, true);
    }

    /**
     * 设置是否是第一次登陆
     * @param isFirstLogin
     */
    public void  setFirstLogin(boolean isFirstLogin)
    {
        SPUtils.put(App.getInstance().getApplicationContext(), IS_FIRST_LOGIN, isFirstLogin);
    }
}
