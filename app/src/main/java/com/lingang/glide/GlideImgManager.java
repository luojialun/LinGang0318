package com.lingang.glide;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.lingang.R;
import com.lingang.http.HttpApi;

/**
 * Created by QLY on 2016/6/22.
 */
public class GlideImgManager {

    /**
     * load normal  for img
     *
     * @param url
     * @param erroImg
     * @param emptyImg
     * @param iv
     */
    public static void glideLoader(Context context,String url, int erroImg, int emptyImg, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).centerCrop().placeholder(emptyImg).error(erroImg).into(iv);
    }
    //加载本地图片
    public static void glideLoader(Context context,int url, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).into(iv);
    }

    //加载本地图片
    public static void glideLoader(Context context,int url, ImageView iv,int radio) {
        //原生 API
        Glide.with(context).load(url).transform(new CenterCrop(context),new GlideRoundTransform(context,radio)).into(iv);
    }

    public static void glideLoader(Context context,String url, ImageView iv,int erroImg) {
        glideLoader(context,url,iv,1f,erroImg);
    }
    //加载网络图片
    public static void glideLoader(Context context,String url, ImageView iv) {
        //原生 API
        glideLoader(context,url,iv,1f,R.mipmap.normal_img);
    }
    //加载网络图片+缩略图透明值
    public static void glideLoader(Context context,String url, ImageView iv,float thumbnail,int erroImg) {
        //原生 API
        Glide.with(context).load(url).placeholder(R.mipmap.normal_img).centerCrop().error(erroImg).thumbnail(thumbnail).into(iv);
    }
    //加载网络图片
    public static void glideLoaderNoScan(Context context,String url, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).placeholder(R.mipmap.normal_img).error(R.mipmap.normal_img).into(iv);
    }

    /**
     * 默认图片加载
     */
    public static void glideLoaderNormal(Context context,String url, final ImageView iv)
    {
        Glide.with(context).load(url).placeholder(R.mipmap.normal_img).error(R.mipmap.normal_img).into(iv);

    }
    public static void glideLoaderNormal(Context context,String url,final ImageView iv,int erroImg)
    {
        Glide.with(context).load(url).placeholder(R.mipmap.normal_img).error(erroImg).into(iv);
    }
    /**
     * 加载图片
     * @param context 上下文
     * @param url 地址
     * @param iv 图片空间
     * @param listener 加载是否成功回调
     */
    public static void glideLoader(Context context,String url, final ImageView iv,final LoadImageListener listener)
    {
        Glide.with(context).load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                //加载失败
                if(listener !=null)
                {
                    listener.onError(model+e.toString());
                }
                return false;
            }
            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                //加载成功
                if(listener !=null)
                {
                    listener.onSuccess();
                }
                return false;
            }

        }).into(iv);
    }

    //加载网络图片(正方形)
    public static void glideLoaderSize(Context context,String url,int size, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).placeholder(R.mipmap.normal_img).error(R.mipmap.normal_img).override(size,size).into(iv);
    }

    //加载头像
    public static void glideLoaderHead(Context context,String url, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).placeholder(R.mipmap.user_pic).error(R.mipmap.user_pic).transform(new GlideCircleImage(context)).into(iv);
    }

    //发布方
    public static void glideLoaderFabu(Context context,String url, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).placeholder(R.mipmap.ic_fabu).error(R.mipmap.ic_fabu).into(iv);
    }

    /**
     * load normal  for  circle or round img
     *
     * @param url
     * @param erroImg
     * @param emptyImg
     * @param iv
     * @param tag
     */
    public static void glideLoader(Context context, String url, int erroImg, int emptyImg, ImageView iv, int tag) {
        if (0 == tag) {
            Glide.with(context).load(url).centerCrop().placeholder(emptyImg).error(erroImg).transform(new GlideCircleTransform(context)).into(iv);
        } else if (1 == tag) {//侧滑头像
            Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new CenterCrop(context),new GlideRoundTransform(context,10)).into(iv);
        }else if (2 == tag) {//列表头像圆角
            Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new CenterCrop(context),new GlideRoundTransform(context,5)).into(iv);
        }
    }

    /**
     *简化图片加载事件
     */
    public interface LoadImageListener {
        void onSuccess();
        void onError(String errorInfo);
    }
}