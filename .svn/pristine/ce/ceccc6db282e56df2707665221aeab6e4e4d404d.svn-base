package com.lingang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PopConfirmClinck;
import com.lingang.utils.ToastUtils;

/**
 * 两个按钮的dialog
 */
public class DialogError extends Dialog implements View.OnClickListener {
    private EditText msg_ed;
    private LinearLayout btn_confirm;
    private LinearLayout btn_cancel;
    private PopConfirmClinck listion;
    private Context context;

    public DialogError(Context context, PopConfirmClinck listion) {
        super(context, R.style.dialog_style);
        this.context = context;
        this.listion = listion;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_error);
        msg_ed = (EditText) findViewById(R.id.msg_ed);
        btn_confirm = (LinearLayout) findViewById(R.id.msg_positive);
        btn_cancel = (LinearLayout) findViewById(R.id.msg_cancel);
        btn_confirm.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.msg_positive:
                String s = msg_ed.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                    listion.popConfirmClinck("", s);
                    msg_ed.setText("");
                    dismiss();
                } else {
                    ToastUtils.showToast(context, "内容不能为空");
                }
                break;
            case R.id.msg_cancel:
                dismiss();
                break;
        }
    }
}