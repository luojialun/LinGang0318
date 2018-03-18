package com.lingang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.callback.DialogConfirmListion;

/**
 * 两个按钮的dialog
 */
public class CancelDialog extends Dialog implements View.OnClickListener {
    private TextView btn_left,btn_right,tv_hint,tv_title;
    private ImageView btn_top;
    private DialogConfirmListion listion;

    public CancelDialog(Context context, DialogConfirmListion listion) {
        super(context, R.style.dialog_style);
        this.listion = listion;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_cancel);
        btn_top = (ImageView) findViewById(R.id.btn_top);
        btn_left = (TextView) findViewById(R.id.btn_left);
        btn_right = (TextView) findViewById(R.id.btn_right);

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_hint = (TextView) findViewById(R.id.tv_hint);

        btn_top.setOnClickListener(this);
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
    }

    /**
     * 自定义显示
     *
     * @param titleTv 标题
     * @param content 内容
     */
    public void show(String titleTv, String content) {
        super.show();

        if (!TextUtils.isEmpty(titleTv)) {
            tv_title.setText(titleTv);
        }

        if (!TextUtils.isEmpty(content)) {
            tv_hint.setText(content);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                listion.confirmClick("cancel_dialog");
                break;
        }
        dismiss();
    }
}