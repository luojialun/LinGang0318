package com.lingang.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.glide.GlideImgManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class UserBigHeadAc extends BaseAc implements PhotoViewAttacher.OnViewTapListener{

    @BindView(R.id.img_big)
    PhotoView imgBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_big_head);
        ButterKnife.bind(this);

        String pic = getIntent().getStringExtra("pic");
        imgBig.setOnViewTapListener(this);

        GlideImgManager.glideLoaderHead(this, pic, imgBig);
    }

    @Override
    public void onViewTap(View view, float x, float y) {
        finish();
    }
}
