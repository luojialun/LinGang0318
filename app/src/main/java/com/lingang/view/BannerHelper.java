package com.lingang.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.bean.BannerBean;
import com.lingang.bean.BannerLocal;
import com.lingang.common.BannerLocalManager;
import com.lingang.common.LoginManager;
import com.lingang.glide.GlideImageLoader;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 17/7/12.
 *  首页Banner辅助类
 */
public class BannerHelper {

    private Banner mBanner;
    private Context mContext;
    private ArrayList<String> bannerId;
    private ArrayList<String> bannerText;
    private ArrayList<String> bannerImg;
    public BannerHelper(Context context,Banner banner) {
        this.mBanner = banner;
        this.mContext=context;
        bannerId=new ArrayList<>();
        bannerText=new ArrayList<>();
        bannerImg=new ArrayList<>();
        initView();
    }

    /**
     * 初始化view
     */
    private void initView()
    {
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(bannerImg);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(bannerText);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        //mBanner.start();
        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                if (bannerId != null && position-1 <= bannerId.size()) {
                    //跳转到新闻页
                    Intent intent = new Intent(mContext, NewsDetailsAc.class);
                    intent.putExtra("newsId", bannerId.get(position-1));
                    mContext.startActivity(intent);
                }
            }
        });
    }

    /**
     * 加载数据
     */
    public void loadData()
    {
        if(AppUtils.isNetworkAvailable(mContext))
        {
            HttpParams httpParams = new HttpParams();
            httpParams.put("pageIndex", "1");
            httpParams.put("pageSize", "4");
            httpParams.put("token", LoginManager.getInstance().getToken());
            OkGo.post(HttpApi.HOME_BANNER)
                    .params(httpParams)
                    .tag(this)
                    .execute(new ResCallBack<BannerBean>(mContext, false) {
                        @Override
                        public void onCall(BannerBean banner, Call call, Response response) {
                            if (banner.getData() != null) {
                                clearList();
                                //清除本地数据
                                BannerLocalManager.getInstance().clearBannerLocal();
                                //删除banner缓存文件夹
                                deleteDir(getBannerDir().getAbsolutePath());
                                for (final BannerBean.DataBean.ListBean listBean : banner.getData().getList()) {
                                    //本地命名图片名称
                                    final String fileName = "banner_" + listBean.getNewsId() + ".jpg";
                                    //保存到本地数据
//                                    BannerLocalManager.getInstance().save(new BannerLocal(
//                                            listBean.getNewsId(),
//                                            listBean.getNewsTitle(),
//                                            listBean.getImgPath(), fileName));
                                    //图片保存到本地
                                    Glide.with(mContext).load(HttpApi.IMAGE_BASE_SERVER + listBean.getImgPath()).asBitmap().placeholder(R.mipmap.bg_moren).into(new SimpleTarget<Bitmap>() {
                                        @Override
                                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                            saveImageFile(resource, fileName);
                                        }

                                        @Override
                                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                                            super.onLoadFailed(e, errorDrawable);
                                            Resources res=mContext.getResources();
                                            Bitmap bitmap= BitmapFactory.decodeResource(res, R.mipmap.bg_moren);
                                            saveImageFile(bitmap, fileName);
                                        }
                                    });
                                    bannerId.add(listBean.getNewsId());
                                    bannerImg.add(getBannerDir().getAbsolutePath() + "/" + fileName);
                                    //bannerImg.add(HttpApi.IMAGE_BASE_SERVER + listBean.getImgPath());
                                    bannerText.add(listBean.getNewsTitle());
                                }
                                //更新数据
                                mBanner.setImages(bannerImg);
                                mBanner.setBannerTitles(bannerText);
                                mBanner.start();
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            ToastUtils.showToast(mContext, mContext.getString(R.string.net_error));
                        }
                    });
        }else
        {
            loadNormalData();
            ToastUtils.showToast(mContext, mContext.getString(R.string.net_error));
        }
    }

    /**
     *加载本地banner
     */
    public void loadLocalData() {
        List<BannerLocal> bannerList = BannerLocalManager.getInstance().getAll();
        if (bannerList != null)
        {
            clearList();
            for (BannerLocal bannerLocal :bannerList)
            {
                bannerId.add(bannerLocal.getNewsId());
                File file = new File(getBannerDir().getAbsolutePath()+"/"+bannerLocal.getLocalImgPath());
                if(file.exists()) {
                    bannerImg.add(getBannerDir().getAbsolutePath() + "/" + bannerLocal.getLocalImgPath());
                }else
                {
                    bannerImg.add(mContext.getString(R.string.home_banner_normal_bg));
                }
                bannerText.add(bannerLocal.getNewsTitle());
            }

            //更新数据
            mBanner.setImages(bannerImg);
            mBanner.setBannerTitles(bannerText);
            mBanner.start();
        }else
        {
            loadNormalData();
        }
    }

    /**
     * 安装之后首次默认数据
     */
    public void loadNormalData()
    {
        clearList();
        bannerId.add("1");
        bannerImg.add(mContext.getString(R.string.home_banner_normal_bg));
        bannerText.add(App.Empty);
        //更新数据
        mBanner.setImages(bannerImg);
        mBanner.setBannerTitles(bannerText);
        mBanner.start();
    }
    /**
     * 清除内存数据列表
     */
    private void clearList()
    {
        bannerId.clear();
        bannerImg.clear();
        bannerText.clear();
    }

    /**
     * 保存图片
     * @param bmp
     * @param fileName
     */
    public void saveImageFile(Bitmap bmp,String fileName) {
        // 首先保存图片
        //File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();//注意小米手机必须这样获得public绝对路径
        File appDir = getBannerDir();
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        File currentFile = new File(appDir, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(currentFile);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //删除文件夹和文件夹里面的文件
    public void deleteDir(String path) {
        try
        {
            File dir = new File(path);
            if (dir == null || !dir.exists() || !dir.isDirectory())
                return;

            for (File file : dir.listFiles()) {
                if (file.isFile())
                    file.delete(); // 删除所有文件
                else if (file.isDirectory())
                    deleteDir(path); // 递规的方式删除文件夹
            }
            dir.delete();// 删除目录本身
        }catch (Exception ex)
        {
             ex.printStackTrace();
        }
    }

    private File getBannerDir()
    {
        return new File(App.getInstance().getCacheDir() + "/lingang_banner");
    }
}
