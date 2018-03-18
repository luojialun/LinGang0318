package com.lingang.activity.home;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.lingang.R;
import com.lingang.base.BaseAc;
import com.lingang.common.Constants;
import com.lingang.glide.GlideImgManager;
import com.lingang.utils.AppUtils;
import com.lingang.utils.PermissionUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.request.BaseRequest;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jason on 16/12/8.
 * pdf阅读页面
 * <p>
 * <p>
 * Intent pdfIntent=new Intent(mContext,PdfViewerActivity.class);
 * pdfIntent.putExtra("fileName",downloadInfo.getLocalPath());//
 * pdfIntent.putExtra("isCache",true);//是否缓存中打开，还是在线预览
 * mContext.startActivity(pdfIntent);
 */

public class PdfViewerActivity extends BaseAc implements OnPageChangeListener, OnLoadCompleteListener {
    private static final String TAG = "PdfViewerActivity";
    @BindView(R.id.pdf_name_tv)
    TextView pdfNameTv;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.progress_container_ll)
    LinearLayout progressContainerLl;
    @BindView(R.id.pdf_viewer)
    PDFView pdfViewer;
    @BindView(R.id.pager_index_tv)
    TextView pagerIndexTv;


    /**
     * 文件名称
     */
    private File loadFile;
    private String fileTile;
    private String fileAddress;
    private int type;
    private int state;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_pdf_viewer_activity);

        getRightView().setImageResource(R.mipmap.share_white);

        Intent intent = getIntent();
        type = intent.getIntExtra(Constants.PDF_VIEW_TYPE, 1);
        fileTile = intent.getStringExtra(Constants.PDF_TITLE);
        fileAddress = intent.getStringExtra(Constants.PDF_ADDRESS);
        initData();
        //申请SD卡权限
        PermissionUtils.checkPermission(this, PermissionUtils.SD_PERMISSIONS, getString(R.string.permission_failed));
    }

    /**
     * 调用系统分享
     */
    private void initShareIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        List<ResolveInfo> resInfo = getPackageManager()
                .queryIntentActivities(intent, 0);
        PackageManager pm = getApplication().getPackageManager();
        if (!resInfo.isEmpty()) {
            List<Intent> targetedShareIntents = new ArrayList<>();
            for (ResolveInfo info : resInfo) {
                Intent targeted = new Intent(Intent.ACTION_SEND);
                targeted.putExtra(Intent.EXTRA_STREAM,
                        Uri.fromFile(loadFile));
                targeted.setType("*/*");//此处可发送多种文件
                ActivityInfo activityInfo = info.activityInfo;
                //微信
                String packageName = activityInfo.packageName;
                if (packageName.contains("com.tencent.mm") && activityInfo.name.equals("com.tencent.mm.ui.tools.ShareImgUI")){
                    targeted.setClassName(packageName,activityInfo.name);
                    targetedShareIntents.add(targeted);
                }
                //QQ
                if (packageName.contains("com.tencent.mobileqq") && activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity")){
                    targeted.setClassName(packageName,activityInfo.name);
                    targetedShareIntents.add(targeted);
                }
            }

            if (targetedShareIntents.size() == 0) {
                ToastUtils.showToast(this,"找不到该分享应用组件");
                return;
            }

            Intent chooserIntent = Intent.createChooser(
                    targetedShareIntents.remove(0), "分享到");

            if (chooserIntent == null) {
                return;
            }
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                    targetedShareIntents.toArray(new Parcelable[]{}));
            try {
                startActivity(chooserIntent);
            } catch (Exception ex) {
                ToastUtils.showToast(this,"找不到该分享应用组件");
            }
        }
    }

    @Override
    public void ibClickRight() {
        super.ibClickRight();
        if (loadFile.exists() && state == DownloadManager.FINISH) {
            initShareIntent();
        } else {
            ToastUtils.showToast(this, "正在下载文件，请稍等。。。");
        }

    }

    private void initData() {
        setTitle("附件详情");

        if (type == Constants.PDF_VIEW_PREVIEW) {  //pdf本地预览
            DownloadManager instance = DownloadManager.getInstance();
            DownloadInfo downloadInfo = instance.getDownloadInfo(fileAddress);
            if (downloadInfo != null) {
                state = downloadInfo.getState();

                loadFile = new File(getDownloadFolder(), AppUtils.getFileName(fileAddress));
                if (loadFile.exists() && state == DownloadManager.FINISH) {
                    pdfViewer.setVisibility(View.VISIBLE);
                    progressContainerLl.setVisibility(View.INVISIBLE);
                    diaplayPdfFromFile(loadFile);
                } else {
                    pdfViewer.setVisibility(View.INVISIBLE);
                    progressContainerLl.setVisibility(View.VISIBLE);
                    pdfNameTv.setText(fileTile);
                    fileDownload(fileAddress);
                }
            } else {
                //pdf下载后查看
                pdfViewer.setVisibility(View.INVISIBLE);
                progressContainerLl.setVisibility(View.VISIBLE);
                pdfNameTv.setText(fileTile);
                fileDownload(fileAddress);
            }
        } else if (type == Constants.PDF_VIEW_DOWNLOAD) {  //pdf下载后查看
            //pdf下载后查看
            pdfViewer.setVisibility(View.INVISIBLE);
            progressContainerLl.setVisibility(View.VISIBLE);
            pdfNameTv.setText(fileTile);
            fileDownload(fileAddress);
        }


    }

    //从文件加载pdf
    private void diaplayPdfFromFile(File file) {
        pdfViewer.fromFile(file)
                .defaultPage(0)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(PdfViewerActivity.this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        //当页面改变时
        pagerIndexTv.setText(String.format("%s / %s", page + 1, pageCount));
    }

    //处理pdf文件下载
    public void fileDownload(String url) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new DownloadFileCallBack(getDownloadFolder(), AppUtils.getFileName(fileAddress)));

        loadFile = new File(getDownloadFolder(), AppUtils.getFileName(fileAddress));
    }

    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }

    private class DownloadFileCallBack extends FileCallback {

        public DownloadFileCallBack(String destFileDir, String destFileName) {
            super(destFileDir, destFileName);
        }

        @Override
        public void onBefore(BaseRequest request) {
        }

        @Override
        public void onSuccess(File file, Call call, Response response) {
            //文件下载完成直接查看
            pdfViewer.setVisibility(View.INVISIBLE);
            progressContainerLl.setVisibility(View.INVISIBLE);
            pdfViewer.setVisibility(View.VISIBLE);
            state = DownloadManager.FINISH;
            diaplayPdfFromFile(loadFile);
        }

        @Override
        public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//            System.out.println("downloadProgress -- " + totalSize + "  " + currentSize + "  " + progress + "  " + networkSpeed);
            progressBar.setProgress((int) (progress * 100));
        }

        @Override
        public void onError(Call call, Response response, Exception e) {
            super.onError(call, response, e);
            ToastUtils.showToast(PdfViewerActivity.this, "预览失败");
            loadFile.delete();
        }
    }

    /**
     * 下载目录文档
     *
     * @return
     */
    public String getDownloadFolder() {
        return DownloadManager.getInstance().getTargetFolder();
    }

}
