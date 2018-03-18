package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.R;
import com.lingang.base.BaseAc;

/**
 * 审核结果
 */
public class NeedBusinessResultAc extends BaseAc implements OnTabSelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_need_business_result);
        initView();
    }
    /**
     * 初始化
     */
    private void initView() {
        setTitle(getString(R.string.need_business_title));
    }

    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

    /**
     * 跳转页面
     * @param context
     */
    public static void goToNeedBusinessResultAc(Context context)
    {
        Intent intent=new Intent(context,NeedBusinessResultAc.class);
        context.startActivity(intent);
    }
}
