package com.lingang.activity.tunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.base.BaseAc;

import butterknife.BindView;

public class MyTunity extends BaseAc {

    @BindView(R.id.img_test)
    ImageView imgTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_tj_tunity);
        setTitle("我的商机");
        imgTest.setImageResource(R.mipmap.tun_my);
    }
}
