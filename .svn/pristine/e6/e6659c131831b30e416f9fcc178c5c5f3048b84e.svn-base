package com.lingang.adapter;

import android.content.Context;
import android.opengl.Visibility;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.lingang.App;
import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.MastFlowTracingBean;
import com.lingang.common.Constants;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by jason on 17/7/7.
 * 待办事项-》流转任务详细
 */
public class NeedFlowAdapter extends RecycleBaseAdapter<MastFlowTracingBean.MastFlowTracing> {
    private Context mContent;
    private List<MastFlowTracingBean.MastFlowTracing> mList;

    public NeedFlowAdapter(Context context, List<MastFlowTracingBean.MastFlowTracing> data) {
        super(context, data);
        mContent=context;
        mList=data;
    }

    @Override
    protected void convert(final BaseViewHolder holder, MastFlowTracingBean.MastFlowTracing item, int position) {
        String PROCProcTime=item.getPROCProcTime();
        holder.setVisible(R.id.process_time,true);

        //中间审批环节
        if(!TextUtils.isEmpty(PROCProcTime) && PROCProcTime.length()>0)
        {
            //已通过
            holder.getView(R.id.flow_state_iv).setSelected(true);//左边状态小icon=》橘黄色
            holder.setText(R.id.process_node_type,Constants.FlowTaskNodeType.nodeTypeReviewText);
            holder.setVisible(R.id.process_time,true);//显示处理时间
            //holder.getView(R.id.process_node_type).setSelected(false);//右边标签状态=》蓝色
            holder.setBackgroundResource(R.id.process_node_type,R.drawable.selector_flow_state_tab_green);//绿色

        }else
        {   //进行中
            holder.getView(R.id.flow_state_iv).setSelected(false);//左边状态小icon=》灰色
            holder.setText(R.id.process_node_type,Constants.FlowTaskNodeType.nodeTypeProcessText);
            holder.setVisible(R.id.process_time,false);//隐藏处理时间
            //holder.getView(R.id.process_node_type).setSelected(true);//右边标签状态=》橘黄色
            holder.setBackgroundResource(R.id.process_node_type,R.drawable.selector_flow_state_tab_orange);//橘黄色
        }
        //开始 和 已完成环节
        switch (Integer.parseInt(item.getNODETYPE()))
        {
            case Constants.FlowTaskNodeType.nodeTypeStart:
                //开始
                holder.setVisible(R.id.need_flow_line,false);//左边连接上下线=》隐藏
                holder.setText(R.id.process_node_type,Constants.FlowTaskNodeType.nodeTypeStartText);//右边标签文本=》开始
                holder.setBackgroundResource(R.id.process_node_type,R.drawable.selector_flow_state_tab_blue);//蓝色
            break;
            case Constants.FlowTaskNodeType.nodeTypeEnd:
                //已完成
                holder.setText(R.id.process_node_type,Constants.FlowTaskNodeType.nodeTypeEndText);//右边标签文本=》结束
                holder.setBackgroundResource(R.id.process_node_type,R.drawable.selector_flow_state_tab_green);//绿色
                break;
        }

        holder.setText(R.id.process_dep_name,item.getNODENAME()+"   "+item.getUserCHName());//部门+名称
        if(!TextUtils.isEmpty(item.getPROCProcTime()))
            holder.setText(R.id.process_time,String.format(mContent.getString(R.string.flow_process_time),item.getPROCProcTime()));//处理时间

        if(!TextUtils.isEmpty(item.getWorkTime()))
            holder.setText(R.id.process_stop_time,String.format(mContent.getString(R.string.flow_stop_time),item.getWorkTime()));//驻留时间

        if(!TextUtils.isEmpty(item.getPROCNote()))
            holder.setText(R.id.process_review,String.format(mContent.getString(R.string.process_review),item.getPROCNote()));//审核意见

        if(!TextUtils.isEmpty(item.getIsSubflow())
                && item.getIsSubflow().equals(Constants.FlowIsSubState.yes)
                && item.getSubFlowList() !=null)
        {
            holder.setVisible(R.id.sub_flow_iv,true);
            //子流程
            RecyclerView sub_rv = holder.getView(R.id.sub_flow_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContent);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            sub_rv.setLayoutManager(linearLayoutManager);

            NeedFlowSubAdapter subAdapter = new NeedFlowSubAdapter(mContent, item.getSubFlowList());
            sub_rv.setAdapter(subAdapter);

            holder.getView(R.id.sub_flow_iv).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.getView(R.id.sub_flow_iv).setSelected(!holder.getView(R.id.sub_flow_iv).isSelected());
                    if(holder.getView(R.id.sub_flow_iv).isSelected()) {
                        holder.setVisible(R.id.sub_flow_rv, true);
                        holder.setText(R.id.sub_flow_iv,mContent.getString(R.string.flow_hide_sub));
                    }else
                    {
                        holder.setVisible(R.id.sub_flow_rv, false);
                        holder.setText(R.id.sub_flow_iv,mContent.getString(R.string.flow_show_sub));
                    }
                }
            });
        }else
        {
            holder.setVisible(R.id.sub_flow_iv,false);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, MastFlowTracingBean.MastFlowTracing item) {
        return R.layout.item_need_flow_task_review;
    }
}
