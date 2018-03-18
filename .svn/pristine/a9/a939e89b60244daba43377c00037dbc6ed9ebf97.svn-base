package com.lingang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.callback.DialogConfirmListion;

/**
 * 两个按钮的dialog
 */
public class DialogTwo extends Dialog implements View.OnClickListener {
    private TextView tv_content;
    private LinearLayout btn_confirm;
    private LinearLayout btn_cancel,ll_bg_dialog;
    private TextView tv_right, tv_left;
    private DialogConfirmListion listion;
    private TextView title;

    public DialogTwo(Context context, DialogConfirmListion listion) {
        super(context, R.style.dialog_style);
        this.listion = listion;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_two);
        tv_content = (TextView) findViewById(R.id.msg_content);
        title = (TextView) findViewById(R.id.dialog_title);
        btn_confirm = (LinearLayout) findViewById(R.id.msg_positive);
        btn_cancel = (LinearLayout) findViewById(R.id.msg_cancel);
        ll_bg_dialog = (LinearLayout) findViewById(R.id.ll_bg_dialog);
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_right = (TextView) findViewById(R.id.tv_right);
        btn_confirm.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    /**
     * 自定义显示
     *
     * @param titleTv 标题
     * @param content 内容
     * @param right   确定按钮文字
     * @param left    取消按钮文字
     */
    public void show(String titleTv, String content, String right, String left) {
        super.show();

        if (!TextUtils.isEmpty(titleTv)) {
            title.setText(titleTv);
        }

        if (!TextUtils.isEmpty(content)) {
            tv_content.setText(content);
        }

        if (!TextUtils.isEmpty(right)) {
            tv_right.setText(right);
        }
        if (!TextUtils.isEmpty(left)) {
            tv_left.setText(left);
        }
    }


    /**
     * 自定义显示标题 和 内容
     *
     * @param titleTv 标题
     * @param content 内容
     */
    public void show(String titleTv, String content) {
        super.show();

        if (!TextUtils.isEmpty(titleTv)) {
            title.setText(titleTv);
        }

        if (!TextUtils.isEmpty(content)) {
            tv_content.setText(content);
        }
    }

    /**
     * @param content 提示内容
     */
    public void show(String content) {
        super.show();
        if (!TextUtils.isEmpty(content)) {
            tv_content.setText(content);
        }
    }

    /**
     * @param content 按钮内容 内容
     */
    public void show(String left, String right ,String content) {
        super.show();

        if (!TextUtils.isEmpty(left)) {
            tv_left.setText(left);
        }

        if (!TextUtils.isEmpty(right)) {
            tv_right.setText(right);
        }

        if (!TextUtils.isEmpty(content)) {
            tv_content.setText(content);
        }
    }

    public void isVisibleTitle(boolean isVisible){
        if (isVisible){
            title.setVisibility(View.VISIBLE);
        }else {
            title.setVisibility(View.GONE);
        }
    }

    public void setDailogBg(int bg){
        ll_bg_dialog.setBackgroundResource(bg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.msg_positive:
                listion.confirmClick("two_dialog");
                break;
        }
        dismiss();
    }
}