package com.lingang.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.callback.DialogOnclinck;


/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class BottomDialog extends Dialog implements View.OnClickListener {
    private Activity activity;
    private TextView btn_two, btn_one;
    private TextView btn_cancel, btn_there;
    private DialogOnclinck dialogOnclic;
    private View btn_there_line,btn_two_line;
    private String sign = "BottomDialog";

    public BottomDialog(Activity activity,DialogOnclinck dialogOnclic) {
        super(activity, R.style.ActionSheetDialogStyle);
        this.activity = activity;
        this.dialogOnclic = dialogOnclic;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_bottom);
        btn_one = (TextView) findViewById(R.id.btn_one);
        btn_two = (TextView) findViewById(R.id.btn_two);
        btn_cancel = (TextView) findViewById(R.id.btn_cancel);
        btn_there = (TextView) findViewById(R.id.btn_there);

        btn_two_line = (View) findViewById(R.id.btn_two_line);
        btn_there_line = (View) findViewById(R.id.btn_there_line);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        btn_there.setOnClickListener(this);

        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private void setViewLocation() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }

    /**
     * 全部显示
     *
     * @param one    标题
     * @param two    内容
     * @param there  确定按钮文字
     * @param cancel 取消按钮文字
     */
    public void show(String one, String two, String there, String cancel) {
        super.show();

        if (!TextUtils.isEmpty(one)) {
            btn_one.setText(one);
        }

        if (!TextUtils.isEmpty(two)) {
            btn_two.setText(two);
        }

        if (!TextUtils.isEmpty(there)) {
            btn_there.setText(there);
        }
        if (!TextUtils.isEmpty(cancel)) {
            btn_cancel.setText(cancel);
        }
    }
    /**
     *
     * 显示全部
     *
     */

    public void show(String one, String two, String there) {
        super.show();

        if (!TextUtils.isEmpty(one)) {
            btn_one.setText(one);
        }

        if (!TextUtils.isEmpty(two)) {
            btn_two.setText(two);
        }

        if (!TextUtils.isEmpty(there)) {
            btn_there.setText(there);
        }
    }


    public void show(String one, String two) {
        super.show();

        if (!TextUtils.isEmpty(one)) {
            btn_one.setText(one);
        }

        if (!TextUtils.isEmpty(two)) {
            btn_two.setText(two);
        }
        btn_there.setVisibility(View.GONE);
        btn_there_line.setVisibility(View.GONE);
    }
    /**
     *
     * 只显示两个按钮
     *
     */
    public void show(String one) {
        super.show();

        if (!TextUtils.isEmpty(one)) {
            btn_one.setText(one);
        }
        btn_there.setVisibility(View.GONE);
        btn_there_line.setVisibility(View.GONE);

        btn_two.setVisibility(View.GONE);
        btn_two_line.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                dialogOnclic.dialogOnclicCall("btn_one",sign);
                this.cancel();
                break;
            case R.id.btn_two:
                dialogOnclic.dialogOnclicCall("btn_two",sign);
                this.cancel();
                break;
            case R.id.btn_there:
                dialogOnclic.dialogOnclicCall("btn_there",sign);
                this.cancel();
                break;
            case R.id.btn_cancel:
                this.cancel();
                break;
        }
    }

    public void setSign(String sign){
        this.sign = sign;
    }

}
