package com.lingang.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.BannerBean;
import com.lingang.bean.ClusterBean;
import com.lingang.http.HttpApi;
import com.lingang.utils.DateUtils;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;
import com.lingang.view.flowlayout.FlowLayout;
import com.lingang.view.flowlayout.TagAdapter;
import com.lingang.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class ClaimAdapter extends RecycleBaseAdapter<String> {
    private Context context;
    private final int screenWidth;

    public ClaimAdapter(Context context, List<String> data) {
        super(context, data);
        this.context = context;
        screenWidth = ScreenSizeUtils.getInstance(context).getScreenWidth() / 2;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final String item, int position) {


//        holder.setText(R.id.tv_title_news, item.getNewsTitle());
//
//        String timestamp = DateUtils.getTimestamp(item.getCreateTime());
//
//        holder.setText(R.id.tv_data_news, timestamp);
//        ImageView view = holder.getView(R.id.img_news);
////        GlideImgManager.glideLoader(view.getContext(),HttpApi.IMAGE_BASE_SERVER + item.getImgPath(),view);
        final RecyclerView view = holder.getView(R.id.tf_recy);
        ArrayList<ClusterBean.DataBean.ListBean.LabelsBean> labels = new ArrayList<>();
        ClusterBean.DataBean.ListBean.LabelsBean labelsBean = new ClusterBean.DataBean.ListBean.LabelsBean();
        labelsBean.setLabelName("租住场地");
        ClusterBean.DataBean.ListBean.LabelsBean labelsBean1 = new ClusterBean.DataBean.ListBean.LabelsBean();
        labelsBean1.setLabelName("新兴技术");
        ClusterBean.DataBean.ListBean.LabelsBean labelsBean2 = new ClusterBean.DataBean.ListBean.LabelsBean();
        labelsBean2.setLabelName("新兴技术术新兴技术术");
        labels.add(labelsBean);
        labels.add(labelsBean1);
        labels.add(labelsBean2);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(linearLayoutManager);

        ListTabAdapter listTabAdapter = new ListTabAdapter(context, labels);
        view.setAdapter(listTabAdapter);

        int whith = 0;
        for (ClusterBean.DataBean.ListBean.LabelsBean tab : labels) {
            whith = tab.getLabelName().length() + whith;
            if (whith > 12) {//如果tab 数组的字节总数大于12 recycleview 的宽度就为屏幕的一般否则不处理
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = layoutParams.WRAP_CONTENT;
                view.setLayoutParams(layoutParams);
                Log.e("width ", whith + "");
                return;
            }
        }


    }


    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.itme_claim;
    }
}
