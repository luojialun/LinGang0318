package com.lingang.activity.tunity;

import android.content.Intent;
import android.os.Bundle;

import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.base.BaseAc;

import butterknife.OnClick;

public class SendSuccessAc extends BaseAc {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_send_success);
        setTitle("推荐结果");
    }

    @OnClick(R.id.btn_succ)
    public void onViewClicked() {
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void clickLeft() {
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
    }
}
