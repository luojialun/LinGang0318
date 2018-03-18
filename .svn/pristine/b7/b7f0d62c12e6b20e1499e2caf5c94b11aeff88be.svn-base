package com.lingang.fragment.user;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.lingang.R;
import com.lingang.activity.home.PdfViewerActivity;
import com.lingang.adapter.DownloadAdapter;
import com.lingang.common.Constants;
import com.lingang.common.DownloadFileEnum;
import com.lingang.utils.AppUtils;
import com.lingang.utils.OpenFileUtil;
import com.lingang.utils.ToastUtils;
import com.lingang.view.ListViewDecoration;
import com.lingang.view.OnItemClickListener;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 我的下载
 */
public class DownloadMyFragment extends DownloadBaseFragment {
    private static final String TAG = "DownloadMyFragment";
    @BindView(R.id.swipe_rv)
    SwipeMenuRecyclerView mSwipeRv;

    private List<DownloadInfo> mDownloadInfos;
    private DownloadAdapter adapter;
    private DownloadManager downloadManager;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_download_my;
    }


    @Override
    public void finishCreateView(Bundle state) {
        downloadManager = DownloadService.getDownloadManager();
        mDownloadInfos = downloadManager.getAllTask();
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        if (!isPrepared || !isVisible) {
            return;
        }
        initView();
        isPrepared = false;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null && isVisible) {
//            adapter.notifyDataSetChanged();  //
        }
    }


    /**
     * 初始化View
     */
    private void initView() {
        //绑定数据
        mSwipeRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRv.setHasFixedSize(true); //如果item够简单，高度是确定的，打开fixSize将提高性能
        mSwipeRv.addItemDecoration(new ListViewDecoration());// 添加分割线。

        adapter = new DownloadAdapter(mDownloadInfos, getActivity());
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (mDownloadInfos != null && mDownloadInfos.size() > position) {
                    //下载状态
                    DownloadInfo downloadInfo = mDownloadInfos.get(position);
                    switch (downloadInfo.getState()) {
                        case DownloadManager.PAUSE:
                        case DownloadManager.NONE:
                        case DownloadManager.ERROR:
                            ToastUtils.showToast(getContext(), "文件未下载完成");
                            break;
                        case DownloadManager.DOWNLOADING:
                            ToastUtils.showToast(getContext(), "文件正在下载");
//                            if (downloadInfo.getFileType() == DownloadFileEnum.mp4) {
//                                FullScreenActivity.toActivity(getActivity(),downloadInfo.getUrl(),
//                                        null,downloadInfo.getFileName());
//                            }
                            break;
                        case DownloadManager.FINISH:
                            switch (downloadInfo.getFileType()) {
                                case DownloadFileEnum.pdf:

                                    Intent pdfIntent = new Intent(getActivity(), PdfViewerActivity.class);
                                    pdfIntent.putExtra(Constants.PDF_ADDRESS, downloadInfo.getUrl());
                                    pdfIntent.putExtra(Constants.PDF_TITLE, downloadInfo.getShowName());
                                    pdfIntent.putExtra(Constants.PDF_VIEW_TYPE, Constants.PDF_VIEW_PREVIEW);
                                    startActivity(pdfIntent);
                                    break;
                                case DownloadFileEnum.mp4:
                                    JCVideoPlayerStandard.startFullscreen(getContext(), JCVideoPlayerStandard.class,
                                            downloadInfo.getTargetPath(), downloadInfo.getShowName());
                                    break;
                                default:
                                    File file = new File(DownloadManager.getInstance().getTargetFolder(), AppUtils.getFileName(downloadInfo.getUrl()));
                                    OpenFileUtil.openFile(getActivity(),file);
                                    break;

                            }
                            break;
                    }
                }
            }

        });
        mSwipeRv.setAdapter(adapter);
        mSwipeRv.setSwipeMenuCreator(swipeMenuCreator);
        mSwipeRv.setSwipeMenuItemClickListener(menuItemClickListener);

    }


    //创建条目的侧滑菜单
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {

        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int wrap = ViewGroup.LayoutParams.WRAP_CONTENT;
            int match = ViewGroup.LayoutParams.MATCH_PARENT;

            SwipeMenuItem collect = new SwipeMenuItem(getActivity())
                    .setText("删除")
                    .setWidth(200)
                    .setHeight(match)
                    .setTextColor(Color.rgb(255, 255, 255))
                    .setBackgroundColor(Color.rgb(244, 88, 82))
                    .setTextSize(14);
            swipeRightMenu.addMenuItem(collect);
        }
    };

    /**
     * recycleview的菜单点击监听。
     */
    private OnSwipeMenuItemClickListener menuItemClickListener = new OnSwipeMenuItemClickListener() {
        /**
         * Item的菜单被点击的时候调用。
         * @param closeable       closeable. 用来关闭菜单。
         * @param adapterPosition adapterPosition. 这个菜单所在的item在Adapter中position。
         * @param menuPosition    menuPosition. 这个菜单的position。比如你为某个Item创建了2个MenuItem，那么这个position可能是是 0、1，
         * @param direction       如果是左侧菜单，值是：SwipeMenuRecyclerView#LEFT_DIRECTION，如果是右侧菜单，值是：SwipeMenuRecyclerView#RIGHT_DIRECTION.
         */
        @Override
        public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
            downloadManager.removeTask(mDownloadInfos.get(adapterPosition).getUrl());
            adapter.notifyDataSetChanged();
            closeable.smoothCloseMenu();// 关闭被点击的菜单。
        }
    };


}
