package com.lingang.http;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.common.DownloadFileEnum;
import com.lingang.utils.AppUtils;
import com.lingang.view.CustomCircleProgress;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.lzy.okhttpserver.listener.DownloadListener;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.request.GetRequest;

/**
 * @name LinGang
 * @class name：com.lingang.http
 * @class describe
 * @anthor Administrator
 * @time 2017/6/2 0002 11:04
 * @change
 * @chang time
 * @class describe
 */
public class DownLoadServices {

    private ImageView btnDown;

    private CustomCircleProgress downloadProgress;

    private DownLoadServices downLoadServices;

    private DownloadManager downloadManager;

    public DownLoadServices() {
    }

    public DownLoadServices getInstance() {

        return downLoadServices = new DownLoadServices();
    }

    public void downRes(String url, String fileName, ImageView btnDown, CustomCircleProgress downloadProgress) {
        this.btnDown = btnDown;
        this.downloadProgress = downloadProgress;
        //        App.getInstance().getDownServices()
        downloadManager = DownloadService.getDownloadManager();
        DownloadInfo downloadInfo = downloadManager.getDownloadInfo(url);

        if (downloadInfo == null) {

            btnDown.setVisibility(View.INVISIBLE);
            downloadProgress.setVisibility(View.VISIBLE);
            downloadProgress.setStatus(CustomCircleProgress.Status.Starting);

            GetRequest request = OkHttpUtils.get(url);
            String[] split = url.split("/");
            String[] cla = split[split.length - 1].split("\\.");
            if (cla[cla.length - 1].equals("mp4")) {
                downloadManager.addTask(DownloadFileEnum.mp4, AppUtils.getFileName(url),fileName, url, request, listion);
            } else {
                downloadManager.addTask(DownloadFileEnum.pdf,AppUtils.getFileName(url), fileName, url, request, listion);
            }

        } else {
            switch (downloadInfo.getState()) {
                case DownloadManager.PAUSE:
                case DownloadManager.NONE:
                case DownloadManager.ERROR:
                    downloadProgress.setStatus(CustomCircleProgress.Status.Starting);
                    downloadManager.addTask(downloadInfo.getFileType(), AppUtils.getFileName(downloadInfo.getUrl()),
                            downloadInfo.getShowName(), downloadInfo.getUrl(),
                            downloadInfo.getRequest(), downloadInfo.getListener());
                    break;
                case DownloadManager.DOWNLOADING:
                    downloadProgress.setStatus(CustomCircleProgress.Status.End);
                    downloadManager.pauseTask(downloadInfo.getUrl());
                    break;
                case DownloadManager.FINISH:
                    break;
            }
        }
    }

    private DownloadListener listion = new DownloadListener() {

        @Override
        public void onProgress(DownloadInfo downloadInfo) {
            Log.e("onProgress", downloadInfo.getProgress() + "");
            downloadProgress.setMax((int) downloadInfo.getTotalLength());
            downloadProgress.setProgress((int) downloadInfo.getDownloadLength());
        }

        @Override
        public void onFinish(DownloadInfo downloadInfo) {
            Log.e("onFinish", "完成");
            downloadProgress.setVisibility(View.GONE);
            btnDown.setVisibility(View.VISIBLE);
            btnDown.setImageResource(R.mipmap.wancheng_green);
        }

        @Override
        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {
            Log.e("onError", "失败");
            btnDown.setVisibility(View.VISIBLE);
            btnDown.setEnabled(true);
            downloadProgress.setVisibility(View.GONE);
        }
    };

}
