package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/7 0007 11:34
 * @change
 * @chang time
 * @class describe
 */
public class AllAdressBean {

    private String name;
    private boolean isselect;

    public boolean isselect() {
        return isselect;
    }

    public void setIsselect(boolean isselect) {
        this.isselect = isselect;
    }

    private List<AdressBean> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AdressBean> getList() {
        return list;
    }

    public void setList(List<AdressBean> list) {
        this.list = list;
    }
}
