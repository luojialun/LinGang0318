package com.lingang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.FileBean;
import com.lingang.common.CircleProgressHelper;
import com.lingang.common.DownloadFileEnum;
import com.lingang.http.DownLoadServicesUtils;
import com.lingang.http.HttpApi;
import com.lingang.utils.AppUtils;
import com.lingang.view.CustomCircleProgress;

import java.util.List;

/**
 * 主页-评论列表adapter
 */
public class LvGroupAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<FileBean> data;
    private final DownLoadServicesUtils instance;

    public LvGroupAdapter(Context context, List<FileBean> data) {
        this.context = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
        instance = DownLoadServicesUtils.getInstance();
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.itme_res, null);
            holder.icon_iv = (ImageView) convertView.findViewById(R.id.icon_iv);
            holder.tv_zil_name = (TextView) convertView.findViewById(R.id.tv_zil_name);
            holder.btn_down = (ImageView) convertView.findViewById(R.id.btn_down);
            holder.download_progress = (CustomCircleProgress) convertView.findViewById(R.id.download_progress);

            int type = Integer.parseInt(data.get(position).getFileType());
            switch (type) {
                case DownloadFileEnum.pdf:
                    holder.icon_iv.setImageResource(R.mipmap.group_11);
                    break;
                case DownloadFileEnum.mp4:
                    holder.icon_iv.setImageResource(R.mipmap.mp4);
                    break;
                case DownloadFileEnum.img:
                    holder.icon_iv.setImageResource(R.mipmap.img);
                    break;
                case DownloadFileEnum.doc:
                    holder.icon_iv.setImageResource(R.mipmap.doc);
                    break;
                case DownloadFileEnum.excel:
                    holder.icon_iv.setImageResource(R.mipmap.excel);
                    break;
                default:
                    holder.icon_iv.setImageResource(R.mipmap.doc);
                    break;
            }
            //创建下载
            holder.createDownload(data.get(position), this);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        //刷新下载
        holder.refresh();
        holder.tv_zil_name.setText(data.get(position).getFileTitle());

        return convertView;
    }

    private class Holder {
        private CircleProgressHelper circleProgress;
        private ImageView icon_iv;
        private TextView tv_zil_name;
        private ImageView btn_down;
        private CustomCircleProgress download_progress;
        private FileBean fileBean;

        /**
         * 创建下载
         */
        public void createDownload(FileBean fileBean, BaseAdapter apdater) {
            this.fileBean = fileBean;
            circleProgress = new CircleProgressHelper(context, apdater, btn_down, download_progress);
            circleProgress.setItemData(fileBean.getFileAddress(), fileBean.getFileTitle(), fileBean.getFileType(), fileBean.getFileSize());
        }

        /**
         * 刷新
         */
        public void refresh() {
            circleProgress.refreshState(HttpApi.IMAGE_BASE_SERVER + fileBean.getFileAddress());
        }
    }

}