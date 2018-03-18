package com.lingang.dialog;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.callback.DialogConfirmListion;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @name LinGang
 * @class name：com.lingang.dialog
 * @class describe
 * @anthor Administrator
 * @time 2017/5/22 0022 14:37
 * @change
 * @chang time
 * @class describe
 */
public class CustomerPop extends PopupWindow {
    @BindView(R.id.pop_all)
    TextView popAll;
    @BindView(R.id.pop_rl)
    TextView popRl;
    @BindView(R.id.pop_zx)
    TextView popZx;
    @BindView(R.id.pop_ld)
    TextView popLd;
    @BindView(R.id.pop_ch)
    TextView popCh;
    private DialogConfirmListion listion;

    public CustomerPop(Context context,DialogConfirmListion listion) {
        super(context);
        this.listion = listion;
        init(context);

    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View conentView = inflater.inflate(R.layout.pop_customer, null);
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
//        this.update();
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(new BitmapDrawable());
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

    @OnClick({R.id.pop_all, R.id.pop_rl, R.id.pop_zx, R.id.pop_ld, R.id.pop_ch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pop_all:
                listion.confirmClick("pop_all");
                break;
            case R.id.pop_rl:
                listion.confirmClick("pop_rl");
                break;
            case R.id.pop_zx:
                listion.confirmClick("pop_zx");
                break;
            case R.id.pop_ld:
                listion.confirmClick("pop_ld");
                break;
            case R.id.pop_ch:
                listion.confirmClick("pop_ch");
                break;
        }
    }
}
