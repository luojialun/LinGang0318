package com.lingang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ExamineBean;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by jason on 17/7/5.
 */

public class NeedBusinessAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<ExamineBean> datas;

    public NeedBusinessAdapter(Context mContext, List<ExamineBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }
    //获取组的个数
    @Override
    public int getGroupCount() {
        return this.datas.size();
    }

    //获取指定组中的子元素个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return this.datas.get(groupPosition).getExamines().size();
    }
    //获取指定组中的数据
    @Override
    public Object getGroup(int groupPosition) {
        return this.datas.get(groupPosition);
    }
    //获取指定组中的指定子元素数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.datas.get(groupPosition).getExamines().get(childPosition);
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
        return false;
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
        return null;
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
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
