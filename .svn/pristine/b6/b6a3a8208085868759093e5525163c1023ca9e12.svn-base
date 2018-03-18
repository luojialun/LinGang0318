package com.lingang.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * 通讯录-》顶部标签
 */
public class ContactTabBean implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;
    public int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ContactTabBean(String title, int selectedIcon, int unSelectedIcon, int order) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
        this.order = order;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
