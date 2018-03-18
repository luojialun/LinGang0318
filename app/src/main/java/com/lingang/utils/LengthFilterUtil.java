package com.lingang.utils;

import android.text.InputFilter;
import android.text.Spanned;

import com.lingang.App;

/**
 * Created by Administrator on 2017/4/22 0022.
 */

public class LengthFilterUtil implements InputFilter {
    private int mMax;

    public LengthFilterUtil(int max) {
        mMax = max;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        int keep = mMax - (dest.length() - (dend - dstart));

        if (keep <= 0) {
            ToastUtils.showToast(App.getInstance().getApplicationContext(),"内容已超出最大限制...");
            return "";
        } else if (keep >= end - start) {
            return null; // keep original
        } else {
            keep += start;
            ToastUtils.showToast(App.getInstance().getApplicationContext(),"内容已超出最大限制...");
            if (Character.isHighSurrogate(source.charAt(keep - 1))) {
                --keep;
                if (keep == start) {
                    return "";
                }
            }
            return source.subSequence(start, keep);
        }
    }
}
