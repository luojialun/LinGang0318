package com.lingang.activity.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.adapter.ImgBigAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.PicListBean;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.ScreenRotateUtil;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.download.DownloadInfo;
import com.lzy.okserver.download.DownloadManager;
import com.lzy.okserver.listener.DownloadListener;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ImgBigAc extends BaseAc implements ViewPager.OnPageChangeListener, PhotoViewAttacher.OnViewTapListener {

    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.vp_pci)
    ViewPager vpPci;
    @BindView(R.id.btn_down)
    ImageView btnDown;
    private ArrayList<ImageView> imageViews;
    private ImgBigAdapter imgBigAdapter;
    private ArrayList<PicListBean.DataBean> imgList;
    private int nowPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenRotateUtil.getInstance(this).start(this);//通过重力感应切换横竖屏
        setContentView(R.layout.activity_img_big);
        ButterKnife.bind(this);
        initView();
        Log.i("TAG","oncreate()");
    }

    private void initView() {
        int position = getIntent().getIntExtra("position", 0);
        imgList = (ArrayList<PicListBean.DataBean>) getIntent().getSerializableExtra("imgList");
        tvNum.setText((position + 1) + "/" + imgList.size());

        vpPci.setOnPageChangeListener(this);
        imageViews = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {

            PhotoView imageView = new PhotoView(this);
            imageView.setOnViewTapListener(this);
            imageViews.add(imageView);

        }
        //每次只加载一张图片
        GlideImgManager.glideLoaderNoScan(this, HttpApi.IMAGE_BASE_SERVER + imgList.get(position).getPicPath(), imageViews.get(position));
        imgBigAdapter = new ImgBigAdapter(this, imageViews);
        vpPci.setAdapter(imgBigAdapter);

        vpPci.setCurrentItem(position);
    }

    @OnClick({R.id.btn_left, R.id.btn_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                finish();
                break;
            case R.id.btn_down:
                downImg();
                break;
        }
    }

    private void downImg() {
        String url = HttpApi.IMAGE_BASE_SERVER + imgList.get(nowPosition).getPicPath();
        GetRequest getRequest = OkGo.get(url);

        DownloadManager downServices = App.getInstance().getDownServices();
        downServices.setTargetFolder(Environment.getExternalStorageDirectory().getAbsolutePath() + "/lingang/img/");
        ToastUtils.showToast(ImgBigAc.this, "保存图片中...");
        downServices.addTask(url, getRequest, new DownloadListener() {
            @Override
            public void onProgress(DownloadInfo downloadInfo) {
                Log.e("onProgress", downloadInfo.getProgress() + "");

            }

            @Override
            public void onFinish(DownloadInfo downloadInfo) {
                Log.e("onFinish", "完成");
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(new File(downloadInfo.getTargetFolder() + downloadInfo.getFileName()));
                intent.setData(uri);
                sendBroadcast(intent);
                ToastUtils.showToast(ImgBigAc.this, "图片已经保存到相册");
            }

            @Override
            public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {
                Log.e("onError", "失败");
                ToastUtils.showToast(ImgBigAc.this, "图片下载失败");
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        nowPosition = position;
        tvNum.setText((position + 1) + "/" + imageViews.size());
        GlideImgManager.glideLoaderNoScan(this, HttpApi.IMAGE_BASE_SERVER + imgList.get(position).getPicPath(), imageViews.get(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onViewTap(View view, float x, float y) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ScreenRotateUtil.getInstance(this).stop();
    }
}
