package com.lingang.activity.count;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.base.BaseAc;

import butterknife.BindView;

public class CompanyQueryAc extends BaseAc {

    @BindView(R.id.img_test)
    ImageView imgTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_tj_tunity);
        setTitle("企业查询");
        imgTest.setImageResource(R.mipmap.tun_comqu);
    }
}
