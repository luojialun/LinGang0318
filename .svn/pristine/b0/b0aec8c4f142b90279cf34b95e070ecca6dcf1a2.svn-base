package com.lingang.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lingang.R;
import com.lingang.base.BaseAc;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 纠错审核
 */
public class NeedCorrectionReviewAc extends BaseAc implements OnTabSelectListener {
    @BindView(R.id.need_corr_submit_btn)
    Button needCorrSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_need_correction_review);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        setTitle(getString(R.string.need_correction_title));
    }

    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

    @OnClick({R.id.need_corr_submit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.need_corr_submit_btn:
                NeedCorrectionResultAc.goToNeedCorrectionResultAc(this);
                break;
        }
    }

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void goToNeedCorrectionReviewAc(Context context) {
        Intent intent = new Intent(context, NeedCorrectionReviewAc.class);
        context.startActivity(intent);
    }
}
