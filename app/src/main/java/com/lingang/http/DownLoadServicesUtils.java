package com.lingang.http;

import android.view.View;
import android.widget.ImageView;

import com.lingang.R;
import com.lingang.common.LoginManager;
import com.lingang.view.CustomCircleProgress;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;

/**
 * @name LinGang
 * @class name：com.lingang.http
 * @class describe
 * @anthor Administrator
 * @time 2017/7/13 0013 20:35
 * @change
 * @chang time
 * @class describe
 */
public class DownLoadServicesUtils {
    private static DownLoadServicesUtils downLoadServicesUtils;

    public static DownLoadServicesUtils getInstance() {
        if (null == downLoadServicesUtils) {
            synchronized (DownLoadServicesUtils.class) {
                if (null == downLoadServicesUtils) {
                    downLoadServicesUtils = new DownLoadServicesUtils();
                }
            }
        }
        return downLoadServicesUtils;
    }

    public void downLoadState(String url, ImageView btn_down, CustomCircleProgress download_progress) {
        DownloadManager downloadManager = DownloadService.getDownloadManager();
        DownloadInfo downloadInfo = downloadManager.getDownloadInfo(HttpApi.IMAGE_BASE_SERVER + url);
        if (downloadInfo != null) {
            switch (downloadInfo.getState()) {
                case DownloadManager.NONE:
                    break;
                case DownloadManager.PAUSE:
                    download_progress.setVisibility(View.VISIBLE);
                    btn_down.setVisibility(View.GONE);
                    download_progress.setMax((int) downloadInfo.getTotalLength());
                    download_progress.setProgress((int) downloadInfo.getDownloadLength());
                case DownloadManager.DOWNLOADING:
                    download_progress.setVisibility(View.VISIBLE);
                    btn_down.setVisibility(View.GONE);
                    download_progress.setStatus(CustomCircleProgress.Status.End);
                    download_progress.setMax((int) downloadInfo.getTotalLength());
                    download_progress.setProgress((int) downloadInfo.getDownloadLength());
                    break;
                case DownloadManager.FINISH:
                    download_progress.setVisibility(View.GONE);
                    btn_down.setVisibility(View.VISIBLE);
                    btn_down.setImageResource(R.mipmap.wancheng_green);
                    break;
            }
        }
    }
}
