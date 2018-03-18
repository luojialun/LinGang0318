package com.lingang.common;

import android.content.Context;
import android.widget.TableRow;

import com.lingang.R;
import com.lingang.utils.ToastUtils;

/**
 * Created by jason on 17/6/8.
 * 分页辅助类
 */
public class PagerHelper {
    /**
     * 默认页数
     */
    private int pageIndex = 1;
    /**
     * 默认页面大小
     */
    private int pageSize = Constants.PAGE_SIZE;
    /**
     * 是否是刷新》否是加载更多
     */
    private boolean isRefresh=true;
    /**
     * 是否最后一页
     */
    private boolean lastPageEnd=false;

    private Context mContext;
    public PagerHelper(Context context) {
        mContext=context;
        this.pageIndexBak=this.pageIndex;
    }

    private int pageIndexBak;
    public PagerHelper(Context context,int pageIndex, int pageSize) {
        mContext=context;
        this.pageIndex = pageIndex;
        this.pageIndexBak=pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }

    public boolean isLastPageEnd() {
        return lastPageEnd;
    }

    public void setLastPageEnd(boolean lastPageEnd) {
        this.lastPageEnd = lastPageEnd;
    }

    /**
     *下拉刷新
     */
    public void refreshPage()
    {
        pageIndex=this.pageIndexBak;
        isRefresh=true;
        lastPageEnd=false;
    }
    /**
     * 上拉加载更多》返回是否有更多页
     */
    public boolean loadMore()
    {
        isRefresh=false;
        if(lastPageEnd)
        {
           //提示最后一页
            ToastUtils.showToast(mContext,mContext.getString(R.string.loadedAll));
            return false;
        }
        return true;
    }

    /**
     * 加载完成
     * @param resultCount
     */
    public boolean loadFinish(int resultCount)
    {
        if(resultCount>=pageSize) {
            pageIndex++;
            lastPageEnd=false;
        }else
        {
            lastPageEnd=true;
        }
        return isRefresh;
    }

}