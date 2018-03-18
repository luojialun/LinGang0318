package com.lingang.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 描述	      1.不希望ViewPager滚动
 * 描述	      2.不能影响孩子的事件处理
 *
 * 更新者     $Author: admin $
 * 更新时间   $Date: 2016-06-19 10:53:08 +0800 (星期日, 19 六月 2016) $
 * 更新描述   ${TODO}
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 是否派发
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 是否拦截
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //          return super.onInterceptTouchEvent(ev);
        return false;//传递给孩子
        //        return true;//走到自身的onTouevent中-->影响:孩子无法接收到事件
    }

    /**
     * 是否消费
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //        return super.onTouchEvent(ev);
        return true;//事件消费-->事件结束
        //                return false;//事件未消费-->往上传递
    }
}
