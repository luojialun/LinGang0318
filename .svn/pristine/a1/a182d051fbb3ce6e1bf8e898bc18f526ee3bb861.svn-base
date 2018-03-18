package com.lingang.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Nathen
 * On 2016/04/27 10:49
 */
public class JCVPlayerTitleAfterFull extends JCVideoPlayerStandard {
    public JCVPlayerTitleAfterFull(Context context) {
        super(context);
    }

    public JCVPlayerTitleAfterFull(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setUp(String url, int screen, Object... objects) {
        super.setUp(url, screen, objects);
//        fullscreenButton.setVisibility(GONE);
        thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (currentScreen == SCREEN_WINDOW_FULLSCREEN) {
            titleTextView.setVisibility(View.VISIBLE);
        } else {
            titleTextView.setVisibility(View.INVISIBLE);
        }
    }
}
