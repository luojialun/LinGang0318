package com.lingang.activity.home;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.adapter.LvGroup2Adapter;
import com.lingang.adapter.LvGroupAdapter;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.CollectResultBean;
import com.lingang.bean.FileBean;
import com.lingang.bean.NewsDetailsBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.ShareDialog;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.utils.DateUtils;
import com.lingang.utils.OpenFileUtil;
import com.lingang.utils.ToastUtils;
import com.lingang.view.ExtraListView;
import com.lingang.view.JustifiedWebView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okhttpserver.download.DownloadManager;
import com.sina.weibo.sdk.utils.LogUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.Call;
import okhttp3.Response;

public class NewsDetailsAc extends BaseAc implements AdapterView.OnItemClickListener {

    public String TAG = "NewsDetailsAc";
    //    @BindView(R.id.news_content_tv)
//    TextView newsContentTv;
    @BindView(R.id.wb_details)
    JustifiedWebView wbDetails;
    @BindView(R.id.tv_detai_title)
    TextView tvDetaiTitle;
    @BindView(R.id.tv_team)
    TextView tvTeam;
    @BindView(R.id.tv_details_time)
    TextView tvDateTime;
    @BindView(R.id.iv_watch)
    ImageView ivWatch;

    @BindView(R.id.ll_file)
    LinearLayout llFile;
    @BindView(R.id.lv_cail)
    ExtraListView lvCail;
    //    @BindView(R.id.news_like_ll)
//    LinearLayout newsLikeLl;
//    @BindView(R.id.image_like_iv)
//    ImageView imageLikeIv;
    @BindView(R.id.author_name_iv)
    ImageView authorNameIv;

    private NewsDetailsBean.DataBean data;
    private ShareDialog shareDialog;
    private String newsId = "";
    private String jumpType = "";

    private List<NewsDetailsBean.NewsFileBean> files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_news_details);
        setTitle("新闻详情");
        lvCail.setOnItemClickListener(this);
        newsId = getIntent().getStringExtra("newsId");
        jumpType = getIntent().getStringExtra(Constants.JUMP_TYPE);
        getRightView().setImageResource(R.mipmap.share_white);
        getNewsDetails();
        shareDialog = new ShareDialog(this);
//        tv.setText(Html.fromHtml(getString(R.string.html_text)));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 999) {
            share();
        }
    }

    @Override
    public void clickLeft() {
        if (!TextUtils.isEmpty(jumpType) && "MainActivity".equals(jumpType)) {
            Intent intent = new Intent(this, NewsAc.class);
            startActivity(intent, true);
            finish();
        } else {
            super.clickLeft();
        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayerStandard.backPress()) {
            return;
        }
        if (!TextUtils.isEmpty(jumpType) && "MainActivity".equals(jumpType)) {
            Intent intent = new Intent(this, NewsAc.class);
            startActivity(intent, true);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                    , Manifest.permission.ACCESS_FINE_LOCATION
                    , Manifest.permission.CALL_PHONE
                    , Manifest.permission.READ_LOGS
                    , Manifest.permission.READ_PHONE_STATE
                    , Manifest.permission.READ_EXTERNAL_STORAGE
                    , Manifest.permission.SET_DEBUG_APP
                    , Manifest.permission.SYSTEM_ALERT_WINDOW
                    , Manifest.permission.GET_ACCOUNTS
                    , Manifest.permission.WRITE_APN_SETTINGS};

            ActivityCompat.requestPermissions(this, mPermissionList, 999);
        } else {
            share();
        }

    }

    private void share() {
        if (data != null) {
            UMWeb web = new UMWeb(HttpApi.IMAGE_BASE_SERVER + "/" + data.getShareUrl());
            web.setThumb(new UMImage(NewsDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + data.getImgPath()));
            web.setTitle(data.getNewsTitle());
            web.setDescription(data.getNewsTitle());
            shareDialog.share(new ShareAction(this).withMedia(web),
                    new ShareDialog.OnshareResultListener() {
                        @Override
                        public void onResult(int shareType) {
                            LogUtil.d(TAG, "分享成功");
                        }

                        @Override
                        public void onError(int shareType) {
                            LogUtil.d(TAG, "分享失败");
                        }

                        @Override
                        public void onCancle(int shareType) {
                            LogUtil.d(TAG, "分享取消");
                        }
                    });
            shareDialog.show();


        }
    }

    //获取新闻详情
    private void getNewsDetails() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("newsId", newsId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.newsDetails)
                .params(httpParams)
                .execute(new ResCallBack<NewsDetailsBean>(this) {
                    @Override
                    public void onCall(NewsDetailsBean newsDetails, Call call, Response response) {
                        data = newsDetails.getData();
                        tvDetaiTitle.setText(data.getNewsTitle());
                        tvTeam.setText(TextUtils.isEmpty(data.getAuthorName()) ? App.Empty : data.getAuthorName());
                        if (!TextUtils.isEmpty(data.getCreateTime())) {
                            tvDateTime.setText(DateUtils.getTimestamp(Long.valueOf(data.getCreateTime())));
                        }

                        files = newsDetails.getData().getFiles();
                        if (files.size() > 0) {
                            llFile.setVisibility(View.VISIBLE);
                            LvGroup2Adapter adapter=new LvGroup2Adapter(NewsDetailsAc.this, files);
                            lvCail.setAdapter(adapter);
                        }

                        GlideImgManager.glideLoaderNormal(NewsDetailsAc.this, HttpApi.IMAGE_BASE_SERVER + data.getLogoPath(), authorNameIv, R.mipmap.ic_morenlogo);

                        refreshLike();

                        wbDetails.setText(data.getNewsContent());
//                        RichText.fromHtml(data.getNewsContent())
//                                .autoFix(true)
//                                .resetSize(true)
//                                .cache(CacheType.NONE)
//                                .bind(this)
//                                .into(newsContentTv);
                    }
                });
    }

    //收藏
    private void addUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectType", Constants.FavoritesType.NEWS);
        httpParams.put("objId", newsId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.addUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<BaseEntity<CollectResultBean, Object>>(NewsDetailsAc.this, false) {
                    @Override
                    public void onCall(BaseEntity<CollectResultBean, Object> collectBean, Call call, Response response) {
                        ToastUtils.showToast(NewsDetailsAc.this, getString(R.string.add_like));
                        if (data != null && collectBean != null) {
                            //更新收藏ID
                            data.setCollectId(String.valueOf(collectBean.getData().getCollectId()));
                            data.setCollectState(Constants.CollectState.collected);
                            refreshLike();
                        }
                    }
                });
    }

    //取消收藏
    private void delUserCollect() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("collectId", data.getCollectId());
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.delUserCollect)
                .params(httpParams)
                .execute(new ResCallBack<String>(NewsDetailsAc.this, false) {
                    @Override
                    public void onCall(String addressBean, Call call, Response response) {
                        ToastUtils.showToast(NewsDetailsAc.this, getString(R.string.cancel_like));
                        data.setCollectState(Constants.CollectState.collect);
                        data.setCollectId(null);
                        refreshLike();
                    }
                });
    }

    /**
     * 刷新收藏
     */
    private void refreshLike() {
        if (data != null) {
            // imageLikeIv.setSelected(!TextUtils.isEmpty(data.getCollectId()) ? true : false);
            ivWatch.setSelected(TextUtils.isEmpty(data.getCollectId()) ? false : true);
        }
    }

    public static void goToNewsDetailsAc(Context content, String newsId) {
        Intent intent = new Intent(content, NewsDetailsAc.class);
        intent.putExtra("newsId", newsId);
        ((Activity) content).startActivityForResult(intent, Constants.refreshCode);
    }

    public static void goToNewsDetailsAc(Context content, String newsId, String jumpType) {
        Intent intent = new Intent(content, NewsDetailsAc.class);
        intent.putExtra("newsId", newsId);
        intent.putExtra(Constants.JUMP_TYPE, jumpType);
        ((Activity) content).startActivityForResult(intent, Constants.refreshCode);
    }

    @OnClick({R.id.iv_watch})
    public void onViewClicked(View e) {
        switch (e.getId()) {
            case R.id.iv_watch: //添加或取消收藏
                if (data != null) {
                    if (TextUtils.isEmpty(data.getCollectId())) {
                        addUserCollect();
                    } else {
                        delUserCollect();
                    }
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        int fileType = files.get(i).getFileType();
        switch (fileType) {
            case 1:
                Intent intent = new Intent(this, PdfViewerActivity.class);
                intent.putExtra(Constants.PDF_TITLE, files.get(i).getFileTitle());
                intent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + files.get(i).getFileAddress());
                intent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
                startActivity(intent);
                break;
            case 2:
                JCVideoPlayerStandard.startFullscreen(this, JCVideoPlayerStandard.class,
                        HttpApi.IMAGE_BASE_SERVER + files.get(i).getFileAddress(), files.get(i).getFileTitle());
                break;
            default:
                File file = new File(DownloadManager.getInstance().getTargetFolder(), AppUtils.getFileName(HttpApi.IMAGE_BASE_SERVER + files.get(i).getFileAddress()));
                if (file.exists()) {
                    OpenFileUtil.openFile(this, file);
                } else {
                    ToastUtils.showToast(this, "请先下载文件");
                }

                break;
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }


}
