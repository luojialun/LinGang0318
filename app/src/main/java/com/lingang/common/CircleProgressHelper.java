package com.lingang.common;

import android.content.Context;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.login.LoginAc;
import com.lingang.activity.user.UserSettingAc;
import com.lingang.base.BaseAc;
import com.lingang.callback.PermissionCallback;
import com.lingang.http.HttpApi;
import com.lingang.utils.AppUtils;
import com.lingang.utils.PermissionUtils;
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.dialog.DialogCallback;
import com.lingang.view.dialog.NormalDialog;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.lzy.okhttpserver.listener.DownloadListener;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.request.GetRequest;

/**
 * Created by jason on 17/7/13.
 */

public class CircleProgressHelper implements View.OnClickListener {
    private DownloadInfo downloadInfo;
    private ImageView downloadCircleImg;
    private DownloadManager downloadManager;
    private CustomCircleProgress downloadCircleProgress;
    private Context mContext;
    private BaseAdapter adapter;
    private int fileType;
    private String fileName;
    private String fileUrl;
    private String fileSize;
    private NormalDialog dialog;

    /**
     * listView
     *
     * @param context
     * @param adapter
     * @param downloadCircleImg
     * @param downloadCircleProgress
     */
    public CircleProgressHelper(Context context, BaseAdapter adapter, ImageView downloadCircleImg, CustomCircleProgress downloadCircleProgress) {
        this.downloadCircleImg = downloadCircleImg;
        this.downloadCircleProgress = downloadCircleProgress;
        this.mContext = context;
        this.adapter = adapter;
        downloadManager = DownloadService.getDownloadManager();
        //downloadManager.setTargetFolder(Environment.getExternalStorageDirectory().getAbsolutePath() + "/lingang/");
    }

    /**
     * 普通view
     *
     * @param context
     * @param downloadCircleImg
     * @param downloadCircleProgress
     */
    public CircleProgressHelper(Context context, ImageView downloadCircleImg, CustomCircleProgress downloadCircleProgress) {
        this.downloadCircleImg = downloadCircleImg;
        this.downloadCircleProgress = downloadCircleProgress;
        this.mContext = context;
        downloadManager = DownloadService.getDownloadManager();
        downloadManager.setTargetFolder(Environment.getExternalStorageDirectory().getAbsolutePath() + "/lingang/");
    }

    /**
     * 设置数据
     */
    public void setItemData(String fileUrl, String fileName, String fileType, Double fileSize) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileType = Integer.parseInt(fileType);
        this.fileSize = String.valueOf(fileSize);
    }

    public void setItemData(String fileUrl, String fileName, int fileType, String fileSize) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }


    /**
     * 刷新状态
     *
     * @param url
     */
    public void refreshState(String url) {
        DownloadInfo downloadInfo = downloadManager.getDownloadInfo(url);
        if (downloadInfo != null) {
            refresh(downloadInfo);

            if (downloadInfo.getListener() != null) {
                downloadInfo.removeListener();
            }
            MyListener listener = new MyListener();
            //listener.setUserTag(downloadCircleProgress);
            downloadInfo.setListener(listener);
        } else {
            downloadCircleImg.setVisibility(View.VISIBLE);
            downloadCircleImg.setImageResource(R.mipmap.xiazai);
            downloadCircleProgress.setVisibility(View.GONE);
        }

        downloadCircleImg.setOnClickListener(this);
        downloadCircleProgress.setOnClickListener(this);
    }

    public void refresh(DownloadInfo downloadInfo) {
        this.downloadInfo = downloadInfo;
        refresh();
    }

    //对于实时更新的进度ui，放在这里，例如进度的显示，而图片加载等，不要放在这，会不停的重复回调
    //也会导致内存泄漏
    private void refresh() {
//            String downloadLength = Formatter.formatFileSize(mContext, downloadInfo.getDownloadLength());
//            String totalLength = Formatter.formatFileSize(mContext, downloadInfo.getTotalLength());
//            mTvSize.setText(downloadLength + "/" + totalLength);
        if (downloadInfo.getState() == DownloadManager.NONE) {  //无状态 等待下载
            downloadCircleImg.setVisibility(View.VISIBLE);
            downloadCircleImg.setImageResource(R.mipmap.xiazai);
            downloadCircleProgress.setVisibility(View.GONE);
        } else if (downloadInfo.getState() == DownloadManager.PAUSE) {  //暂停状态
            downloadCircleImg.setVisibility(View.INVISIBLE);
            downloadCircleProgress.setVisibility(View.VISIBLE);
            downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
        } else if (downloadInfo.getState() == DownloadManager.ERROR) {  //下载错误或失败界面
            downloadCircleImg.setVisibility(View.VISIBLE);
            downloadCircleImg.setImageDrawable(ContextCompat.getDrawable(mContext, R.mipmap.chongshi));
            downloadCircleProgress.setVisibility(View.GONE);
            downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
        } else if (downloadInfo.getState() == DownloadManager.WAITING) {  //下载队列中等待状态
//                fileStateTv.setVisibility(View.VISIBLE);
//                fileStateTv.setText("等待中");
            downloadCircleImg.setVisibility(View.INVISIBLE);
            downloadCircleProgress.setVisibility(View.VISIBLE);
            downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
        } else if (downloadInfo.getState() == DownloadManager.FINISH) {  //下载完成
            downloadCircleImg.setVisibility(View.VISIBLE);
            downloadCircleImg.setImageDrawable(ContextCompat.getDrawable(mContext, R.mipmap.wancheng_green));
            downloadCircleProgress.setVisibility(View.GONE);
            downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
        } else if (downloadInfo.getState() == DownloadManager.DOWNLOADING) {  //下载中状态
            downloadCircleImg.setVisibility(View.INVISIBLE);
            downloadCircleProgress.setVisibility(View.VISIBLE);
            downloadCircleProgress.setStatus(CustomCircleProgress.Status.Starting);
        }
//            tvProgress.setText((Math.round(downloadInfo.getProgress() * 10000) * 1.0f / 100) + "%");
        downloadCircleProgress.setMax((int) downloadInfo.getTotalLength());
        downloadCircleProgress.setProgress((int) downloadInfo.getDownloadLength());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == downloadCircleImg.getId()) {
            if (downloadInfo != null) {
                switch (downloadInfo.getState()) {
                    case DownloadManager.PAUSE:
                    case DownloadManager.NONE:
                    case DownloadManager.ERROR:
                        dialog = new NormalDialog(mContext, 14, 14);
                        dialog.showConfirm("当前为" + AppUtils.getNetworkName(mContext) + "状态,文件大小为" + fileSize + "M,是否确认下载？", "取消", "确认", new DialogCallback<Boolean>() {
                            @Override
                            public void selectResult(Boolean aBoolean) {
                                if (aBoolean) {
                                    downloadManager.addTask(downloadInfo.getFileType(),
                                            AppUtils.getFileName(downloadInfo.getUrl()), fileName, downloadInfo.getUrl(),
                                            downloadInfo.getRequest(), downloadInfo.getListener());
                                }
                            }
                        });
                        break;
                    case DownloadManager.DOWNLOADING:
                        downloadManager.pauseTask(downloadInfo.getUrl());
                        break;
                    case DownloadManager.FINISH:

                        break;
                }
                refresh();
            } else {
                if (!TextUtils.isEmpty(this.fileUrl)) {
                    dialog = new NormalDialog(mContext, 14, 14);
                    dialog.showConfirm("当前为" + AppUtils.getNetworkName(mContext) + "状态,文件大小为" + fileSize + "M,是否确认下载？", "取消", "确认", new DialogCallback<Boolean>() {
                        @Override
                        public void selectResult(Boolean aBoolean) {
                            if (aBoolean) {
                                //申请SD权限
                                PermissionUtils.checkPermission(mContext, PermissionUtils.SD_PERMISSIONS, mContext.getString(R.string.permission_failed), new PermissionCallback() {
                                    @Override
                                    public void onRequestCallBack(boolean isSuccess) {
                                        if (isSuccess) {//具备SD卡权限
                                            final String downUrl = HttpApi.IMAGE_BASE_SERVER + fileUrl;
                                            GetRequest getRequest = OkHttpUtils.get(downUrl);
                                            downloadManager.addTask(fileType, AppUtils.getFileName(downUrl), fileName, downUrl,
                                                    getRequest, null);
                                            //更新状态
                                            refreshState(downUrl);
                                        }
                                    }
                                });
                            }
                        }
                    });


                }
            }

        } else if (v.getId() == downloadCircleProgress.getId()) {
            switch (downloadInfo.getState()) {
                case DownloadManager.PAUSE:
                case DownloadManager.NONE:
                case DownloadManager.ERROR:
                    dialog = new NormalDialog(mContext, 14, 14);
                    dialog.showConfirm("当前为" + AppUtils.getNetworkName(mContext) + "状态,文件大小为" + fileSize + "M,是否确认下载？", "取消", "确认", new DialogCallback<Boolean>() {
                        @Override
                        public void selectResult(Boolean aBoolean) {
                            if (aBoolean) {
                                PermissionUtils.checkPermission(mContext, PermissionUtils.SD_PERMISSIONS, mContext.getString(R.string.permission_failed), new PermissionCallback() {
                                    @Override
                                    public void onRequestCallBack(boolean isSuccess) {
                                        {//具备SD卡权限
                                            downloadManager.addTask(downloadInfo.getFileType(), AppUtils.getFileName(downloadInfo.getUrl()), fileName,
                                                    downloadInfo.getUrl(), downloadInfo.getRequest(), downloadInfo.getListener());
                                        }
                                    }
                                });
                            }
                        }
                    });
                    break;
                case DownloadManager.DOWNLOADING:
                    downloadManager.pauseTask(downloadInfo.getUrl());
                    break;
                case DownloadManager.FINISH:
                    break;
            }
            refresh();
        }

    }

    //下载过程中的监听
    class MyListener extends DownloadListener {
        @Override
        public void onProgress(DownloadInfo downloadInfo) {
            //if (getUserTag() == null) return;
            //这里不能使用传递进来的 DownloadInfo，否者会出现条目错乱的问题
            //refresh();

            /**
             *☆☆☆☆☆activity是否在存活，显示时在刷新adapter,考虑和测试页面返回执行性能☆☆☆☆
             *测试listView多条数据
             */
//          ((AppCompatActivity)mContext).is
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            } else {
                refresh();
            }
        }

        @Override
        public void onFinish(DownloadInfo downloadInfo) {
        }

        @Override
        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {
        }
    }

}
