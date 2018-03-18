package com.lingang.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @name LG
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/10/30 0030 14:26
 * @change
 * @chang time
 * @class describe
 */
public class SelectChanYeBean implements Serializable{
    private int leftIndex;
    private String rightIndex;

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public String getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(String rightIndex) {
        this.rightIndex = rightIndex;
    }
}
