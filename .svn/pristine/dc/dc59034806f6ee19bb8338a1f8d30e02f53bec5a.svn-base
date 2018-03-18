package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.lingang.App;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.FlowProcessBean;
import com.lingang.common.Constants;
import com.lingang.utils.DateUtils;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jason on 17/7/6.
 */
public class FlowProcessAdapter extends RecycleBaseAdapter<FlowProcessBean.FlowProcess> {
    private Context mContext;
    private List<FlowProcessBean.FlowProcess> mData;

    public FlowProcessAdapter(Context context, List<FlowProcessBean.FlowProcess> data) {
        super(context, data);
        this.mContext = context;
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, FlowProcessBean.FlowProcess item, int position) {
        holder.setText(R.id.flow_name_title, item.getTASKTopic());
        //创建人
        holder.setText(R.id.create_user_tv, item.getCreatUser());
        //创建时间
        holder.setText(R.id.create_time_tv, item.getTASKCreateTime());
        //驻留时间
        holder.setText(R.id.stop_time_tv, getStopTime(item.getPROCRecvTime()));
        //任务状态
        float workTimeHour = Float.parseFloat(item.getWorkTime());
        if (!TextUtils.isEmpty(item.getNodeStandTime())) {
            float nodeStandTime = Float.parseFloat(item.getNodeStandTime());
            //验证是否 已逾期
            holder.setVisible(R.id.flow_state_iv, (workTimeHour > nodeStandTime));
        } else {
            holder.setVisible(R.id.flow_state_iv, true);
        }

    }

    /**
     * 驻留时间
     *
     * @return
     */
    private String getStopTime(String startTime) {
        String resultTime = App.Empty;
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date beginTime = sdr.parse(startTime);
            resultTime = DateUtils.getDiffTimeDayHour(beginTime, new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultTime;
    }

    @Override
    protected int getItemViewLayoutId(int position, FlowProcessBean.FlowProcess item) {
        return R.layout.item_need_flow;
    }
}
