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
 * 意见反馈
 */
public class NeedFeedbackReviewAc extends BaseAc implements OnTabSelectListener {
    @BindView(R.id.need_feedback_submit_btn)
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_need_feedback_review);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        setTitle(getString(R.string.need_feedback_title));
    }

    @Override
    public void onTabSelect(int position) {}

    @Override
    public void onTabReselect(int position) {}

    @OnClick({R.id.need_feedback_submit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.need_feedback_submit_btn:
                NeedFeedbackResultAc.goToNeedFeedbackResultAc(this);
                break;
        }
    }

    /**
     * 跳转页面
     *
     * @param context
     */
    public static void goToNeedFeedbackReviewAc(Context context) {
        Intent intent = new Intent(context, NeedFeedbackReviewAc.class);
        context.startActivity(intent);
    }
}
