package com.lingang.fragment.user;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.home.PdfViewerActivity;
import com.lingang.adapter.DownloadExpandableAdapter;
import com.lingang.bean.AllDataResponse;
import com.lingang.common.Constants;
import com.lingang.common.DownloadFileEnum;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.AppUtils;
import com.lingang.utils.OpenFileUtil;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 全部资料
 */
public class DownloadAllFragment extends DownloadBaseFragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    @BindView(R.id.expendlist)
    ExpandableListView mExpendlist;
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refreshLayout;

    private List<AllDataResponse.DataEntity.ListEntity> mItemList = new ArrayList<>();
    private DownloadExpandableAdapter adapter;

    private PagerHelper pagerHelper;
    private DownloadManager downloadManager;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_download_all;
    }


    @Override
    public void finishCreateView(Bundle state) {
        downloadManager = DownloadService.getDownloadManager();
        isPrepared = true;
    }

    @Override
    protected void lazyLoad() {
        if (adapter != null) {
            adapter = null;
            adapter = new DownloadExpandableAdapter(getActivity(), mItemList);
            mExpendlist.setAdapter(adapter);
//            for (int i = 0; i < mItemList.size(); i++) {
//                mExpendlist.expandGroup(i);
//            }
        }
        if (!isPrepared || !isVisible) {
            return;
        }
        //initData();
        initView();
        isPrepared = false;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null && isVisible) {
//            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 初始化view
     */
    private void initView() {
        pagerHelper = new PagerHelper(getContext());
//        refreshLayout.setDelegate(this);
//        refreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(MyApplication.mContext, true));

        //去掉ExpandableListView 自带的指示器
        mExpendlist.setGroupIndicator(null);
        mExpendlist.setOnGroupClickListener(this);
        mExpendlist.setOnChildClickListener(this);
        adapter = new DownloadExpandableAdapter(getActivity(), mItemList);
        mExpendlist.setAdapter(adapter);

        setRefreshHead(refreshLayout);
        refreshLayout.startRefresh();
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
//                mItemList.clear();
                pagerHelper.refreshPage();
                handleMessageListHttp();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                if (pagerHelper.loadMore()) {
                    handleMessageListHttp();
                } else {
                    refreshLayout.finishLoadmore();
                }
            }
        });
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        AllDataResponse.DataEntity.ListEntity.FilesEntity fileItem = adapter.getChild(groupPosition, childPosition);
        DownloadInfo downloadInfo = downloadManager.getDownloadInfo(HttpApi.IMAGE_BASE_SERVER + fileItem.getFileAddress());
        if (downloadInfo != null) {
            switch (downloadInfo.getState()) {
                case DownloadManager.PAUSE:
                case DownloadManager.NONE:
                case DownloadManager.ERROR:
                case DownloadManager.DOWNLOADING:
//                    ToastUtil.showShortToast("文件未下载完成");
                    //文件下载未完成，则用网络资源去查看
                    if (fileItem.getFileType() == DownloadFileEnum.pdf) {
                        Intent pdfIntent = new Intent(getActivity(), PdfViewerActivity.class);
                        pdfIntent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + fileItem.getFileAddress());
                        pdfIntent.putExtra(Constants.PDF_TITLE, fileItem.getFileTitle());
                        pdfIntent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_DOWNLOAD);
                        startActivity(pdfIntent);
                    } else if (fileItem.getFileType() == DownloadFileEnum.mp4) {
                        JCVideoPlayerStandard.startFullscreen(getActivity(), JCVideoPlayerStandard.class,
                                HttpApi.IMAGE_BASE_SERVER + fileItem.getFileAddress(), fileItem.getFileTitle());
                    }
                    break;
                case DownloadManager.FINISH:
                    //本地预览
                    if (fileItem.getFileType() == DownloadFileEnum.pdf) {  //去查看pdf
                        Intent pdfIntent = new Intent(getActivity(), PdfViewerActivity.class);
                        pdfIntent.putExtra(Constants.PDF_ADDRESS, downloadInfo.getUrl());
                        pdfIntent.putExtra(Constants.PDF_TITLE, fileItem.getFileTitle());
                        pdfIntent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
                        startActivity(pdfIntent);
                    } else if (fileItem.getFileType() == DownloadFileEnum.mp4) {  //去播放本地视频
                        JCVideoPlayerStandard.startFullscreen(getActivity(), JCVideoPlayerStandard.class,
                                downloadInfo.getTargetPath(), fileItem.getFileTitle());
                    }else{
                        File file = new File(DownloadManager.getInstance().getTargetFolder(), AppUtils.getFileName(downloadInfo.getUrl()));
                        OpenFileUtil.openFile(getActivity(),file);
                    }

                    break;
            }
        } else {
            //网络预览
            if (fileItem.getFileType() == DownloadFileEnum.pdf) {
                Intent pdfIntent = new Intent(getActivity(), PdfViewerActivity.class);
                pdfIntent.putExtra(Constants.PDF_ADDRESS, HttpApi.IMAGE_BASE_SERVER + fileItem.getFileAddress());
                pdfIntent.putExtra(Constants.PDF_TITLE, fileItem.getFileTitle());
                pdfIntent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_DOWNLOAD);
                startActivity(pdfIntent);
            } else if (fileItem.getFileType() == DownloadFileEnum.mp4) {
                JCVideoPlayerStandard.startFullscreen(getActivity(), JCVideoPlayerStandard.class,
                        HttpApi.IMAGE_BASE_SERVER + fileItem.getFileAddress(), fileItem.getFileTitle());
                //JCVideoPlayerStandard.onAudioFocusChangeListener


            }
        }
        return true;
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return false;
    }

    private void handleMessageListHttp() {

        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("pageIndex", pagerHelper.getPageIndex());
        httpParams.put("pageSize", pagerHelper.getPageSize());
        OkGo.post(HttpApi.All_DATA)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<AllDataResponse>(getActivity(), false) {
                    @Override
                    public void onCall(AllDataResponse responseResult, Call call, Response response) {
                        if (1 == pagerHelper.getPageIndex()) {
                            mItemList.clear();
                        }
                        mItemList.addAll(responseResult.getData().getList());
                        adapter.setItems(mItemList);
                        if (pagerHelper.loadFinish(mItemList.size())) {
//                            for (int i = 0; i < mItemList.size(); i++) {
//                                mExpendlist.expandGroup(i);
//                            }
                            refreshLayout.finishRefreshing();
                        } else {
                            refreshLayout.finishLoadmore();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.showToast(getContext(), "加载失败");
                    }
                });
    }
}
