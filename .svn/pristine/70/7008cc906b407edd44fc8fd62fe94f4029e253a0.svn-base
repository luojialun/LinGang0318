package com.lingang.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.login.StartAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.AllDataFileBean;
import com.lingang.bean.AllDataResponse;
import com.lingang.callback.PermissionCallback;
import com.lingang.common.DownloadFileEnum;
import com.lingang.http.HttpApi;
import com.lingang.utils.AppUtils;
import com.lingang.utils.DateHelper;
import com.lingang.utils.PermissionUtils;
import com.lingang.view.CustomCircleProgress;
import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.lzy.okhttpserver.listener.DownloadListener;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.request.GetRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5.
 */

public class DownloadExpandableAdapter extends BaseExpandableListAdapter {


    public Context mContext;
    List<AllDataResponse.DataEntity.ListEntity> datas;
    private final DownloadManager downloadManager;
    private List<DownloadInfo> allTask;

    //private List<>
    public DownloadExpandableAdapter(Context context, List<AllDataResponse.DataEntity.ListEntity> itemList) {
        mContext = context;
        this.datas = itemList;
        downloadManager = DownloadService.getDownloadManager();
        allTask = downloadManager.getAllTask();
    }


    //获取组的个数
    @Override
    public int getGroupCount() {
        return datas.size();
    }

    //获取指定组中的子元素个数
    @Override
    public int getChildrenCount(int groupPosition) {
        if (datas != null) {
            return datas.get(groupPosition).getFiles().size();
        }
        return 0;
    }

    //获取指定组中的数据
    @Override
    public AllDataResponse.DataEntity.ListEntity getGroup(int groupPosition) {
        return datas.get(groupPosition);
    }

    //获取指定组中的指定子元素数据
    @Override
    public AllDataResponse.DataEntity.ListEntity.FilesEntity getChild(int groupPosition, int childPosition) {
        return datas.get(groupPosition).getFiles().get(childPosition);
    }

    //获取指定组的ID，这个组的ID必须是唯一的
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取指定组中的指定子元素ID；
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //组和子元素是否持有稳定的ID，也就是底层数据的改变不会影响他们
    @Override
    public boolean hasStableIds() {
        return true;
    }


    /**
     * 获取显示指定组的视图对象
     *
     * @param groupPosition 组位置
     * @param isExpanded    该组是展开状态还是伸缩状态
     * @param convertView   重用已有的视图对象
     * @param parent        返回的视图对象始终依附于的视图组
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupHolder groupHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expendlist_group, null);
            groupHolder = new GroupHolder(convertView);
            groupHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            groupHolder.ivPoint = (ImageView) convertView.findViewById(R.id.iv_point);
            convertView.setTag(groupHolder);
        } else {

            groupHolder = (GroupHolder) convertView.getTag();
        }

        if (!isExpanded) {
            groupHolder.ivPoint.setImageResource(R.mipmap.pull);
        } else {
            groupHolder.ivPoint.setImageResource(R.mipmap.up);
        }
        groupHolder.tvTitle.setText(datas.get(groupPosition).getParkName());
        return convertView;
    }

    /**
     * 获取一个视图对象，显示指定组中的指定子元素数据
     *
     * @param groupPosition 组位置
     * @param childPosition 子元素位置
     * @param isLastChild   子元素是否处于组中的最后一个
     * @param convertView   重用已有的视图对象
     * @param parent        返回的视图对象始终依附于视图组
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildHolder itemHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expendlist_child, null);
            itemHolder = new ChildHolder(convertView);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (ChildHolder) convertView.getTag();
        }


        AllDataResponse.DataEntity.ListEntity.FilesEntity data = getChild(groupPosition, childPosition);
        itemHolder.setItemData(data);

        //文件标题
        itemHolder.tvTitle.setText(data.getFileTitle());
        //文件类型
        switch (data.getFileType()) {
            case DownloadFileEnum.pdf:
                itemHolder.imageView.setImageResource(R.mipmap.pdf_big);
                break;
            case DownloadFileEnum.mp4:
                itemHolder.imageView.setImageResource(R.mipmap.mp4);
                break;
            case DownloadFileEnum.img:
                itemHolder.imageView.setImageResource(R.mipmap.img);
                break;
            case DownloadFileEnum.doc:
                itemHolder.imageView.setImageResource(R.mipmap.doc);
                break;
            case DownloadFileEnum.excel:
                itemHolder.imageView.setImageResource(R.mipmap.excel);
                break;
            default:
                itemHolder.imageView.setImageResource(R.mipmap.doc);
        }
        //文件更新状态
        long fileUpdateTime = Long.parseLong(data.getFileUpdateTime() != null ? data.getFileUpdateTime().toString() : "0");  //本地文件下载时间
        long updateTime = Long.parseLong(data.getFileUpdateTime() != null ? data.getFileUpdateTime().toString() : "0");  //服务器时间
        if (fileUpdateTime != 0 && fileUpdateTime != updateTime) {
            itemHolder.fileStateTv.setVisibility(View.VISIBLE);
            itemHolder.fileStateTv.setText("已更新");
        } else {
            itemHolder.fileStateTv.setVisibility(View.INVISIBLE);
            itemHolder.fileStateTv.setText("旧版");
        }
        //设置文件大小
        itemHolder.tvSize.setText(data.getFileSize() + "MB");

        //设置时间
        String time = DateHelper.getMillon(data.getUpdateTime());
        String yearTime = time.substring(0, 10);
        String millonTime = time.substring(11, time.length());
        itemHolder.tvDate.setText(yearTime + "  " + millonTime);

        DownloadInfo downloadInfo = downloadManager.getDownloadInfo(HttpApi.IMAGE_BASE_SERVER + data.getFileAddress());
        if (downloadInfo != null) {
            itemHolder.refresh(downloadInfo);
            MyListener listener = new MyListener();
            listener.setUserTag(itemHolder);
            downloadInfo.setListener(listener);
        } else {
            itemHolder.downloadCircleImg.setVisibility(View.VISIBLE);
            itemHolder.downloadCircleImg.setImageResource(R.mipmap.xiazai);
            itemHolder.downloadCircleProgress.setVisibility(View.GONE);
        }

        itemHolder.downloadCircleImg.setOnClickListener(itemHolder);
        itemHolder.downloadCircleProgress.setOnClickListener(itemHolder);
        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public static class GroupHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_point)
        ImageView ivPoint;


        public GroupHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    public class ChildHolder implements View.OnClickListener {
        DownloadInfo downloadInfo;
        AllDataResponse.DataEntity.ListEntity.FilesEntity itemData;

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_size)
        TextView tvSize;
        @BindView(R.id.file_state_tv)
        TextView fileStateTv;
        @BindView(R.id.download_circle_img)
        ImageView downloadCircleImg;
        @BindView(R.id.download_circle_progress)
        CustomCircleProgress downloadCircleProgress;
        @BindView(R.id.download_circle_status)
        FrameLayout downloadCircleStatus;

        public ChildHolder(View view) {
            ButterKnife.bind(this, view);
        }


        public void refresh(DownloadInfo downloadInfo) {
            this.downloadInfo = downloadInfo;
            refresh();
        }

        public void setItemData(AllDataResponse.DataEntity.ListEntity.FilesEntity itemData) {
            this.itemData = itemData;
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
                downloadCircleImg.setVisibility(View.GONE);
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
                downloadCircleImg.setVisibility(View.GONE);
                downloadCircleProgress.setVisibility(View.VISIBLE);
                downloadCircleProgress.setStatus(CustomCircleProgress.Status.End);
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
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == downloadCircleImg.getId()) {
                if (downloadInfo != null) {
                    switch (downloadInfo.getState()) {
                        case DownloadManager.PAUSE:
                        case DownloadManager.NONE:
                        case DownloadManager.ERROR:
                            PermissionUtils.checkPermission(mContext, PermissionUtils.SD_PERMISSIONS, mContext.getString(R.string.permission_failed), new PermissionCallback() {
                                @Override
                                public void onRequestCallBack(boolean isSuccess) {
                                    if (isSuccess) {//具备SD卡访问权限
                                        downloadManager.addTask(downloadInfo.getFileType(),
                                                AppUtils.getFileName(downloadInfo.getUrl()), downloadInfo.getShowName(), downloadInfo.getUrl(),
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
                    if (itemData != null) {
                        //申请SD权限
                        PermissionUtils.checkPermission(mContext, PermissionUtils.SD_PERMISSIONS, mContext.getString(R.string.permission_failed), new PermissionCallback() {
                            @Override
                            public void onRequestCallBack(boolean isSuccess) {
                                if (isSuccess) {//具备SD卡访问权限
                                    GetRequest getRequest = OkHttpUtils.get(HttpApi.IMAGE_BASE_SERVER + itemData.getFileAddress());
                                    downloadManager.addTask(itemData.getFileType(), AppUtils.getFileName(HttpApi.IMAGE_BASE_SERVER + itemData.getFileAddress()), itemData.getFileTitle(), HttpApi.IMAGE_BASE_SERVER + itemData.getFileAddress(),
                                            getRequest, null);

                                }
                            }
                        });
                        notifyDataSetChanged();
                    }

                }

            } else if (v.getId() == downloadCircleProgress.getId()) {
                switch (downloadInfo.getState()) {
                    case DownloadManager.PAUSE:
                    case DownloadManager.NONE:
                    case DownloadManager.ERROR:
                        //申请SD权限
                        PermissionUtils.checkPermission(mContext, PermissionUtils.SD_PERMISSIONS, mContext.getString(R.string.permission_failed), new PermissionCallback() {
                            @Override
                            public void onRequestCallBack(boolean isSuccess) {
                                if (isSuccess) {//具备SD卡访问权限
                                    downloadManager.addTask(downloadInfo.getFileType(), AppUtils.getFileName(downloadInfo.getUrl()),
                                            downloadInfo.getShowName(), downloadInfo.getUrl(), downloadInfo.getRequest(), downloadInfo.getListener());
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
    }


    //下载过程中的监听
    class MyListener extends DownloadListener {
        @Override
        public void onProgress(DownloadInfo downloadInfo) {
            if (getUserTag() == null) return;
            ChildHolder holder = (ChildHolder) getUserTag();
            holder.refresh();  //这里不能使用传递进来的 DownloadInfo，否者会出现条目错乱的问题
        }

        @Override
        public void onFinish(DownloadInfo downloadInfo) {

        }

        @Override
        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {

        }
    }


    /**
     * 返回所有Items
     *
     * @return
     */
    public List<AllDataResponse.DataEntity.ListEntity> getItems() {
        return datas;
    }


    /**
     * 增加单个Item
     *
     * @param newItem
     */
    public void additem(AllDataResponse.DataEntity.ListEntity newItem) {
        if (null == datas) {
            datas = new ArrayList<>();
        }
        datas.add(newItem);
        notifyDataSetChanged();
    }

    /**
     * 增加多个Item
     *
     * @param newItems
     */
    public void addItems(List<AllDataResponse.DataEntity.ListEntity> newItems) {
        if (null == datas) {
            datas = new ArrayList<>();
        }
        datas.addAll(newItems);
        notifyDataSetChanged();
    }

    /**
     * 设置Items
     * 将原有集合内的所有元素删除
     *
     * @param newItems
     */
    public void setItems(List<AllDataResponse.DataEntity.ListEntity> newItems) {
        /*if (null == datas) {
            datas = new ArrayList<>();
        } else {
            datas.clear();
        }
        datas.addAll(newItems);*/
        this.datas = newItems;

        notifyDataSetChanged();
    }

    /**
     * 删除所有Items
     */
    public void removeItems() {
        removeItems(true);
    }

    public void removeItems(boolean isNotifyDataSetChanged) {
        if (null == datas) {
            return;
        }
        datas.clear();
        if (isNotifyDataSetChanged) {
            notifyDataSetChanged();
        }
    }


    public AllDataResponse.DataEntity.ListEntity getItem(int position) {
        if (datas == null || datas.isEmpty()) {
            return null;
        }
        return datas.get(position);
    }


}
