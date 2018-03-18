package com.lingang.activity.business;

import android.os.Bundle;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseAc;

import butterknife.BindView;
import butterknife.OnClick;

public class SuccessAc extends BaseAc {

    @BindView(R.id.submit)
    TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_success);
        setTitle("推荐成功");
    }

    @OnClick(R.id.submit)
    public void onViewClicked() {
        finish();
    }
}
