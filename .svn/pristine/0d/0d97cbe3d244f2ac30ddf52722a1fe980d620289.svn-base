package com.lingang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.lingang.callback.ScollviewChange;

/**
 * @name LinGang
 * @class name：com.lingang.view
 * @class describe
 * @anthor Administrator
 * @time 2017/7/27 0027 15:43
 * @change
 * @chang time
 * @class describe
 */
public class ObservableScrollView extends ScrollView {
    private ScollviewChange scrollViewListener = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollViewListener(ScollviewChange scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.scollChange( x, y, oldx, oldy);
        }
    }

}
