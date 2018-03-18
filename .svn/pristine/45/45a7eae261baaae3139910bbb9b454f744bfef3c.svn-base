package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.R;
import com.lingang.base.BaseAc;

/**
 * 纠错审核结果页面
 */
public class NeedCorrectionResultAc extends BaseAc implements OnTabSelectListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_need_correction_result);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        setTitle(getString(R.string.need_correction_result_title));
    }

    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void goToNeedCorrectionResultAc(Context context) {
        Intent intent = new Intent(context, NeedCorrectionResultAc.class);
        context.startActivity(intent);
    }
}
