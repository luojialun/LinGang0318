package com.lingang.adapter;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.NoticeBean;
import com.lingang.utils.DateUtils;
import com.lingang.utils.NewsUtil;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;


/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class NoticeAdapter extends RecycleBaseAdapter<NoticeBean.DataBean.ListBean> {
    public NoticeAdapter(Context context, List<NoticeBean.DataBean.ListBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final NoticeBean.DataBean.ListBean item, int position) {


        holder.setText(R.id.tv_notice_title, item.getEnterpriseTitle());
        String timestamp = DateUtils.getDetTimes(item.getCreateTime());
        holder.setText(R.id.tv_notice_data, timestamp);
        TextView view = holder.getView(R.id.tv_notice_det);
        view.setText(NewsUtil.delHTMLTag(item.getEnterpriseContent()));//Html.fromHtml(item.getEnterpriseContent())
//        ImageView view = holder.getView(R.id.img_news);
//        GlideImgManager.glideLoader(view.getContext(),HttpApi.IMAGE_BASE_SERVER + item.getImgPath(),view);

        holder.setText(R.id.img_state,item.getBasicsName());
    }


    @Override
    protected int getItemViewLayoutId(int position, NoticeBean.DataBean.ListBean item) {
        return R.layout.itme_notice;
    }
}
