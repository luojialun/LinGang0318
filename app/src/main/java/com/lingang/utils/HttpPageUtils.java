package com.lingang.utils;

import android.text.TextUtils;

import com.lingang.common.LoginManager;

/**
 * @name LinGang
 * @class name：com.lingang.utils
 * @class describe
 * @anthor Administrator
 * @time 2017/7/27 0027 11:59
 * @change
 * @chang time
 * @class describe
 */
public class HttpPageUtils {
    private int pageIndex = 1;
    private int pageSize = 20;

    private HttpPageUtils() {
    }


    private static HttpPageUtils pageUtilsInstance;

    public static HttpPageUtils getInstance() {
        if (null == pageUtilsInstance) {
            synchronized (LoginManager.class) {
                if (null == pageUtilsInstance) {
                    pageUtilsInstance = new HttpPageUtils();
                }
            }
        }
        return pageUtilsInstance;
    }

    /**
     * 判断是否还存在分页
     */
    public boolean judgeRefresh(String countRecord, String pageIndex, String pageSize) {
        if (TextUtils.isEmpty(countRecord) || TextUtils.isEmpty(pageIndex) || TextUtils.isEmpty(pageSize)) {
            return false;
        }
        Integer count = Integer.valueOf(countRecord);
        Integer index = Integer.valueOf(pageIndex);
        Integer size = Integer.valueOf(pageSize);
        if (index * size < count) {
            return true;
        } else {
            return false;
        }
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }
}
