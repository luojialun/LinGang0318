package com.lingang.bean;

/**
 * Created by jason on 17/8/23.
 * 商机状态类型
 */
public class ShowStateEnum {
    private String state;
    private int color;

    public ShowStateEnum(String state, int color) {
        this.state = state;
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
