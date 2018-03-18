package com.lingang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.bean.MeetingByWeekBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.adapter
 * @class describe
 * @anthor Administrator
 * @time 2017/6/27 0027 9:48
 * @change
 * @chang time
 * @class describe
 */
public class WeekExpanAdapter extends BaseExpandableListAdapter {
    private final LayoutInflater inflater;
    private ArrayList<String> parent;
    private ArrayList<List<MeetingByWeekBean.DataBean.MeetingValueBean>> children;

    public WeekExpanAdapter(Context context, ArrayList<String> parent, ArrayList<List<MeetingByWeekBean.DataBean.MeetingValueBean>> children) {
        this.parent = parent;
        this.children = children;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return children.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return parent.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return children.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int position, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.itme_week, null);
        }
        TextView tv_week = (TextView) view.findViewById(R.id.tv_week);
        tv_week.setText(parent.get(position));
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.itme_contnet_week, null);
        }
        TextView tv_titl_week = (TextView) view.findViewById(R.id.tv_titl_week);
        TextView tv_titl_time = (TextView) view.findViewById(R.id.tv_titl_time);
        TextView tv_apptend = (TextView) view.findViewById(R.id.tv_apptend);
        TextView tv_adress = (TextView) view.findViewById(R.id.tv_adress);

        MeetingByWeekBean.DataBean.MeetingValueBean meetingValueBean = children.get(groupPosition).get(childPosition);
        String linkUserName = TextUtils.isEmpty(meetingValueBean.getLinkUserName()) ? "" : ("【联系人:" + meetingValueBean.getLinkUserName()+"】");
        tv_titl_week.setText(meetingValueBean.getTheme() + linkUserName);
        String[] split = meetingValueBean.getStartTime().split(" ")[1].split(":");
        String startTime;
        if (split[0].length() < 2) {
            startTime = "0" + split[0] + "  :  " + split[1];
        } else {
            startTime = split[0] + "  :  " + split[1];
        }

        tv_titl_time.setText(startTime);
        tv_apptend.setText(meetingValueBean.getJoinPersionName());
        tv_adress.setText(meetingValueBean.getRoomName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
