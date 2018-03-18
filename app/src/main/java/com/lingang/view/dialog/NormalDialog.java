package com.lingang.view.dialog;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;

import com.lingang.R;


/**
 * Created by jason on 17/4/12.下面是使用方式
 *

 //初始化代码最好在onCreate事件中实现
 NormalDialog loginDialog=new NormalDialog(this);
 //显示弹出框
 loginDialog.showConfirm("是否要确认退出？", "取消", "确认", new DialogCallback<Boolean>() {
 @Override
 public void selectResult(Boolean aBoolean) {
    if (aBoolean) {
        //点击确认
    }else
    {
        //点击取消
    }
  }
});

 */

public class NormalDialog {
    private NormalAlertDialog alertDialog;
    private Context mContext;
    private Boolean isAutoClose=true;
    private int contentTextSize=18;
    private int buttonTextSize=18;
    public NormalDialog(Context mContext) {
        this.mContext = mContext;
    }
    public NormalDialog(Context mContext,int contentSize,int buttonSize) {
        this.mContext = mContext;
        this.contentTextSize=contentSize;
        this.buttonTextSize=buttonSize;
    }
    /**
     * 设置文字大小
     * @param textSize
     */
    public void setContentTextSize(int textSize)
    {
        contentTextSize=textSize;
    }

    /**
     * 设置按钮字体大小
     * @param textSize
     */
    public void setButtonTextSize(int textSize)
    {
        buttonTextSize=textSize;
    }
    /**
     * 显示弹出框
     * @param message 内容
     * @param leftButton 左按钮文字
     * @param rightButton 右按钮文字
     * @param leftButtonTextColor 左边文字颜色
     * @param rightButtonTextColor 右边文字颜色
     * @param callback 按钮回调事件
     */
    public void showConfirm(String message, String leftButton, String rightButton,@ColorRes int leftButtonTextColor, @ColorRes int rightButtonTextColor, final DialogCallback<Boolean> callback) {
        if(alertDialog !=null) {
           alertDialog.dismiss();
            alertDialog=null;
        }
        alertDialog = new NormalAlertDialog.Builder(mContext)
                .setTitleVisible(false)
                .setHeight(0.15f)  //屏幕高度*0.23
                .setWidth(0.65f)  //屏幕宽度*0.65
                .setContentText(message)
                .setContentTextSize(contentTextSize)
                .setContentTextColor(R.color.black_80)
                .setLeftButtonText(leftButton)
                .setRightButtonText(rightButton)
                .setButtonTextSize(buttonTextSize)
                .setRightButtonTextColor(rightButtonTextColor)
                .setLeftButtonTextColor(leftButtonTextColor)
                .setCanceledOnTouchOutside(false)
                .setOnclickListener(new DialogOnClickListener() {
                    @Override
                    public void clickLeftButton(View view) {
                        if(callback !=null)
                        {
                            callback.selectResult(false);
                        }
                        if(isAutoClose) {
                            alertDialog.dismiss();
                        }
                    }

                    @Override
                    public void clickRightButton(View view) {
                        if(callback !=null)
                        {
                            callback.selectResult(true);
                        }
                        if(isAutoClose) {
                            alertDialog.dismiss();
                        }
                    }
                })
                .build();
//        alertDialog.setMessage(message);
//        alertDialog.setLeftBtnText(leftButton);
//        alertDialog.setRightBtnText(rightButton);

        alertDialog.show();
    }
    /**
     * 显示弹出框
     * @param message 内容
     * @param leftButton 左按钮文字
     * @param rightButton 右按钮文字
     * @param callback 按钮回调事件
     */
    public void showConfirm(String message,String leftButton,String rightButton,final DialogCallback<Boolean> callback) {
        showConfirm(message,leftButton,rightButton,R.color.black_40,R.color.black_80,callback);
    }

    /**
     * 是否自动关闭
     * @param isClose
     */
    public void setAutoClose(Boolean isClose)
    {
        isAutoClose=isClose;
    }

    /**
     * 修改提示消息
     */
    public void setMessage(String message)
    {
        if(alertDialog !=null)
        {
            alertDialog.setMessage(message);
        }
    }

    /**
     * 关闭弹出框
     */
    public void dismiss()
    {
        if(alertDialog !=null)
        {
            alertDialog.dismiss();
        }
    }

    /**
     * 显示弹出框
     */
    public void show()
    {
        if(alertDialog !=null)
        {
            alertDialog.show();
        }
    }

    /**
     * 设置左边按钮文本
     * @param leftText
     */
    public void setLeftText(String leftText)
    {
        if(alertDialog !=null)
        {
            alertDialog.setLeftBtnText(leftText);
        }
    }

    /**
     * 设置右边按钮文本
     * @param rightText
     */
    public void setRightText(String rightText)
    {
        if(alertDialog !=null)
        {
            alertDialog.setRightBtnText(rightText);
        }
    }
    /**
     * 设置灰化
     * @param enable
     */
    public void setEnable(boolean enable)
    {
        alertDialog.setEnable(enable);
    }

}
