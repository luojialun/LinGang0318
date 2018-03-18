package com.lingang.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.lingang.activity.home.BusinessAc;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.activity.home.ClusterAc;
import com.lingang.activity.home.EntryAc;
import com.lingang.activity.home.EntryDetailsAc;
import com.lingang.activity.home.GroupAc;
import com.lingang.activity.home.JiQunDetailsAc;
import com.lingang.activity.home.MatingAc;
import com.lingang.activity.home.MatingDetailesAc;
import com.lingang.activity.home.PartnerAc;
import com.lingang.activity.home.PolicyDetialesAc;
import com.lingang.activity.home.PolicyListAc;
import com.lingang.activity.home.PublicAc;
import com.lingang.activity.home.PublicDetailsAc;
import com.lingang.activity.home.YuanQuAc;
import com.lingang.adapter.PartnerDetailsAc;
import com.lingang.bean.HomeBanner;
import com.lingang.common.LoginManager;

/**
 * @name LG
 * @class name：com.lingang.utils
 * @class describe
 * @anthor Administrator
 * @time 2017/10/27 0027 14:19
 * @change
 * @chang time
 * @class describe
 */
public class BannerJumpUtils {

    private BannerJumpUtils() {
    }

    private static BannerJumpUtils bannerJumpUtils;

    public static BannerJumpUtils getInstance() {
        if (null == bannerJumpUtils) {
            synchronized (LoginManager.class) {
                if (null == bannerJumpUtils) {
                    bannerJumpUtils = new BannerJumpUtils();
                }
            }
        }
        return bannerJumpUtils;
    }

    @NonNull
    public Intent getTypeIntent(Context mContext, HomeBanner.DataBean dataBean) {
        String modelDetailId = dataBean.getModelDetailId();
        Intent inten = new Intent();
        switch (dataBean.getModelType()) {
            case "0"://集团介绍
                inten.setClass(mContext, GroupAc.class);
                break;
            case "1"://产业园区

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, YuanQuAc.class);//产业园区
                } else {
                    inten.setClass(mContext, ChanYeDetailsAc.class);//产业园区详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "2"://产业集群

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, ClusterAc.class);//产业集群
                } else {
                    inten.setClass(mContext, JiQunDetailsAc.class);//产业集群详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "3"://存量客户

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, EntryAc.class);//存量客户
                } else {
                    inten.setClass(mContext, EntryDetailsAc.class);//存量客户详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "4"://租售物业

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, BusinessAc.class);//租售物业
                } else {
                    inten.setClass(mContext, EntryDetailsAc.class);//租售物业详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "5"://配套服务

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, MatingAc.class);//配套服务
                } else {
                    inten.setClass(mContext, MatingDetailesAc.class);//配套服务详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "6"://公共平台

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, PublicAc.class);//公共平台
                } else {
                    inten.setClass(mContext, PublicDetailsAc.class);//公共平台详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "7"://合作伙伴

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, PartnerAc.class);//合作伙伴
                } else {
                    inten.setClass(mContext, PartnerDetailsAc.class);//合作伙伴详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
            case "8"://招商政策

                if (TextUtils.isEmpty(modelDetailId)) {
                    inten.setClass(mContext, PolicyListAc.class);//招商政策
                } else {
                    inten.setClass(mContext, PolicyDetialesAc.class);//招商政策详情
                    inten.putExtra("id", modelDetailId);
                }

                break;
        }
        return inten;
    }
}
