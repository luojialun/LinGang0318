package com.lingang.bean;

import java.util.ArrayList;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/27 0027 10:52
 * @change
 * @chang time
 * @class describe
 */
public class WeekExpanBean {
    private ArrayList<String> parent;
    private ArrayList<MeetingByWeekBean.DataBean> childen;

    public ArrayList<String> getParent() {
        return parent;
    }

    public void setParent(ArrayList<String> parent) {
        this.parent = parent;
    }

    public ArrayList<MeetingByWeekBean.DataBean> getChilden() {
        return childen;
    }

    public void setChilden(ArrayList<MeetingByWeekBean.DataBean> childen) {
        this.childen = childen;
    }
}
