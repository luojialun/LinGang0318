package com.lingang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.R;

/**
 * 两个按钮的dialog
 */
public class DialogOne2 extends Dialog implements View.OnClickListener {
    private TextView tv_content;
    private TextView tv_cim;

    public DialogOne2(Context context) {
        super(context, R.style.dialog_style);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_one2);
        tv_content = (TextView) findViewById(R.id.msg_content);
        tv_cim = (TextView) findViewById(R.id.tv_cim);
        tv_cim.setOnClickListener(this);

        setCanceledOnTouchOutside(false);
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

    @Override
    public void onClick(View view) {
        dismiss();
        if (null != onSureClickListener) {
            onSureClickListener.sureClick();
        }
    }

    public interface OnSureClickListener {
        void sureClick();
    }

    public OnSureClickListener onSureClickListener;

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }
}