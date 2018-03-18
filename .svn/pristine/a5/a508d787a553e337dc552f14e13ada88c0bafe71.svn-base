package com.lingang.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.utils.KeyBoardUtils;
import com.lingang.view.ClearEditText;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;


public class BaseSeachAc extends BaseRecycleViewAc implements View.OnClickListener, TextView.OnEditorActionListener {


    private TextView seach_canle;
    private ClearEditText et_seach;
    private LinearLayout llSeachContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_seach);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    private void initView() {
        seach_canle = (TextView) findViewById(R.id.seach_canle);
        et_seach = (ClearEditText) findViewById(R.id.et_seach);
        llSeachContent = (LinearLayout) findViewById(R.id.ll_seach_content);

        seach_canle.setOnClickListener(this);

        et_seach.setOnEditorActionListener(this);
    }

    /**
     * 加入页面内容布局
     *
     * @param layoutId
     */
    protected void contentView(int layoutId) {
        contentView = getLayoutInflater().inflate(layoutId, null);
        scollCloseAc();
        if (llSeachContent.getChildCount() > 0) {
            llSeachContent.removeAllViews();
        }
        if (contentView != null) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            llSeachContent.addView(contentView, params);
        }
        ButterKnife.bind(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.seach_canle:
                KeyBoardUtils.closeKeybord(et_seach, this);
                finish();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            KeyBoardUtils.closeKeybord(et_seach, this);
            seachCall(textView.getText().toString());
            return true;
        }
        return false;
    }

    public void seachCall(String keyWord) {

    }
}
