package com.lingang.callback;

import android.widget.ImageView;

import com.lingang.view.CustomCircleProgress;

/**
 * @name LinGang
 * @class name：com.lingang.callback
 * @class describe
 * @anthor Administrator
 * @time 2017/6/2 0002 11:19
 * @change
 * @chang time
 * @class describe
 */
public interface OnDownLoadClinck {
    void onDownClinck(ImageView btnDown , CustomCircleProgress progress);
}
