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
public class DialogTwoCall extends Dialog implements View.OnClickListener {
    private TextView tv_content;
    private LinearLayout btn_confirm;
    private LinearLayout btn_cancel,ll_bg_dialog;
    private TextView tv_right, tv_left;
    private DialogConfirmListion listion;

    public DialogTwoCall(Context context) {
        super(context, R.style.dialog_style);
    }
    public DialogTwoCall(Context context, DialogConfirmListion listion) {
        super(context, R.style.dialog_style);
        this.listion = listion;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_two_call);
        tv_content = (TextView) findViewById(R.id.msg_content);
        btn_confirm = (LinearLayout) findViewById(R.id.msg_positive);
        btn_cancel = (LinearLayout) findViewById(R.id.msg_cancel);
        ll_bg_dialog = (LinearLayout) findViewById(R.id.ll_bg_dialog);
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_right = (TextView) findViewById(R.id.tv_right);
        btn_confirm.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
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

    public void setDailogBg(int bg){
        ll_bg_dialog.setBackgroundResource(bg);
    }

    public void setDialogListener(DialogConfirmListion listener)
    {
        this.listion = listener;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.msg_positive:
                listion.confirmClick(tv_content.getText().toString());
                break;
        }
        dismiss();
    }
}