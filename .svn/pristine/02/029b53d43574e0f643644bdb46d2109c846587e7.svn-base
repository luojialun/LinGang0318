package com.lingang.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.common.DownloadFileEnum;
import com.lingang.utils.AppUtils;
import com.lingang.utils.DateHelper;
import com.lingang.view.CustomCircleProgress;
import com.lingang.view.OnItemClickListener;

import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.lzy.okhttpserver.listener.DownloadListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5.
 */

public class DownloadAdapter extends SwipeMenuAdapter<DownloadAdapter.DownloadViewHolder> {


    private List<DownloadInfo> datas;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private final DownloadManager downloadManager;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public DownloadAdapter(List<DownloadInfo> datas, Context context) {
        this.datas = datas;
        mContext = context;
        downloadManager = DownloadService.getDownloadManager();
    }

    /**
     * 更新数据
     *
     * @param datas
     */
    public void update(List<DownloadInfo> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(mContext).inflate(R.layout.item_download, parent, false);
    }

    @Override
    public DownloadViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new DownloadViewHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(DownloadViewHolder holder, int position) {

        DownloadInfo bean = datas.get(position);
        holder.setOnItemClickListener(mOnItemClickListener);
        switch (bean.getFileType()) {
            case DownloadFileEnum.pdf:
                holder.mImageView.setImageResource(R.mipmap.pdf_big);
                break;
            case DownloadFileEnum.mp4:
                holder.mImageView.setImageResource(R.mipmap.mp4);
                break;
            case DownloadFileEnum.img:
                holder.mImageView.setImageResource(R.mipmap.img);
                break;
            case DownloadFileEnum.doc:
                holder.mImageView.setImageResource(R.mipmap.doc);
                break;
            case DownloadFileEnum.excel:
                holder.mImageView.setImageResource(R.mipmap.excel);
                break;
            default:
                holder.mImageView.setImageResource(R.mipmap.doc);
        }
        //设置文件名
        holder.mTvTitle.setText(bean.getShowName());
        //设置时间
        String dateString = DateHelper.getMillon(bean.getDownloadTime());
        String yearTime = dateString.substring(0, 10);
        String millonTime = dateString.substring(11, dateString.length());
        holder.mTvDate.setText(yearTime + "  " + millonTime);

        holder.refresh(bean);

        holder.downloadCircleProgress.setOnClickListener(holder);
        holder.downloadCircleImg.setOnClickListener(holder);

        MyListener listener = new MyListener();
        listener.setUserTag(holder);
        bean.setListener(listener);
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    public class DownloadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView mImageView;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_date)
        TextView mTvDate;
        @BindView(R.id.tv_size)
        TextView mTvSize;
        @BindView(R.id.done_tv)
        TextView doneTv;
        @BindView(R.id.download_circle_status)
        FrameLayout downloadCircleStatus;
        @BindView(R.id.download_circle_img)
        ImageView downloadCircleImg;
        @BindView(R.id.download_circle_progress)
        CustomCircleProgress downloadCircleProgress;

        OnItemClickListener mOnItemClickListener;
        DownloadInfo downloadInfo;

        public DownloadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == downloadCircleProgress.getId()) {
                switch (downloadInfo.getState()) {
                    case DownloadManager.PAUSE:
                    case DownloadManager.NONE:
                    case DownloadManager.ERROR:
                        downloadManager.addTask(downloadInfo.getFileType(),
                                AppUtils.getFileName(downloadInfo.getUrl()), downloadInfo.getShowName(), downloadInfo.getUrl(),
                                downloadInfo.getRequest(), downloadInfo.getListener());
                        break;
                    case DownloadManager.DOWNLOADING:
                        downloadManager.pauseTask(downloadInfo.getUrl());
                        break;
                    case DownloadManager.FINISH:

                        break;
                }
                refresh();
                return;
            } else if (v.getId() == downloadCircleImg.getId()) {
                switch (downloadInfo.getState()) {
                    case DownloadManager.PAUSE:
                    case DownloadManager.NONE:
                    case DownloadManager.ERROR:
                        downloadManager.addTask(downloadInfo.getFileType(),
                                AppUtils.getFileName(downloadInfo.getUrl()), downloadInfo.getShowName(), downloadInfo.getUrl(),
                                downloadInfo.getRequest(), downloadInfo.getListener());
                        break;
                    case DownloadManager.DOWNLOADING:
                        downloadManager.pauseTask(downloadInfo.getUrl());
                        break;
                    case DownloadManager.FINISH:

                        break;
                }
                refresh();
                return;
            }
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(getAdapterPosition());
            }
        }

        public void refresh(DownloadInfo downloadInfo) {
            this.downloadInfo = downloadInfo;
            refresh();
        }


        //对于实时更新的进度ui，放在这里，例如进度的显示，而图片加载等，不要放在这，会不停的重复回调
        //也会导致内存泄漏
        private void refresh() {
            String downloadLength = Formatter.formatFileSize(mContext, downloadInfo.getDownloadLength());
            String totalLength = Formatter.formatFileSize(mContext, downloadInfo.getTotalLength());
            mTvSize.setText(downloadLength + "/" + totalLength);
            if (downloadInfo.getState() == DownloadManager.NONE) {  //无状态 等待下载
                downloadCircleImg.setVisibility(View.VISIBLE);
                downloadCircleImg.setImageResource(R.mipmap.xiazai);
                downloadCircleProgress.setVisibility(View.GONE);
            } else if (downloadInfo.getState() == DownloadManager.PAUSE) {  //暂停状态
                downloadCircleImg.setVisibility(View.GONE);
                downloadCircleProgress.setVisibility(View.VISIBLE);
                downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
            } else if (downloadInfo.getState() == DownloadManager.ERROR) {  //下载错误或失败界面
                mTvSize.setText("下载失败...");
                downloadCircleImg.setVisibility(View.VISIBLE);
                downloadCircleImg.setImageDrawable(ContextCompat.getDrawable(mContext, R.mipmap.chongshi));
                downloadCircleProgress.setVisibility(View.GONE);
                downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
            } else if (downloadInfo.getState() == DownloadManager.WAITING) {  //下载队列中等待状态
                mTvSize.setText("等待中");
                downloadCircleImg.setVisibility(View.GONE);
                downloadCircleProgress.setVisibility(View.VISIBLE);
                downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
                downloadCircleProgress.setVisibility(View.GONE);
            } else if (downloadInfo.getState() == DownloadManager.FINISH) {  //下载完成
                downloadCircleImg.setVisibility(View.VISIBLE);
                downloadCircleImg.setImageDrawable(ContextCompat.getDrawable(mContext, R.mipmap.wancheng_green));
                downloadCircleProgress.setVisibility(View.GONE);
                downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
            } else if (downloadInfo.getState() == DownloadManager.DOWNLOADING) {  //下载中状态
                downloadCircleImg.setVisibility(View.GONE);
                downloadCircleProgress.setVisibility(View.VISIBLE);
                downloadCircleProgress.setStatus(CustomCircleProgress.Status.Starting);
            }
//            tvProgress.setText((Math.round(downloadInfo.getProgress() * 10000) * 1.0f / 100) + "%");
            downloadCircleProgress.setMax((int) downloadInfo.getTotalLength());
            downloadCircleProgress.setProgress((int) downloadInfo.getDownloadLength());

            if ((int) downloadInfo.getTotalLength() == (int) downloadInfo.getDownloadLength()) {
                mTvSize.setText(totalLength);
                doneTv.setVisibility(View.VISIBLE);
            } else {
                doneTv.setVisibility(View.GONE);
            }
        }
    }

    class MyListener extends DownloadListener {
        @Override
        public void onProgress(DownloadInfo downloadInfo) {
            if (getUserTag() == null) return;
            DownloadViewHolder holder = (DownloadViewHolder) getUserTag();
            holder.refresh();  //这里不能使用传递进来的 DownloadInfo，否者会出现条目错乱的问题
        }

        @Override
        public void onFinish(DownloadInfo downloadInfo) {

        }

        @Override
        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {

        }
    }


}
