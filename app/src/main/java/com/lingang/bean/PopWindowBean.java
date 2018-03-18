package com.lingang.bean;

/**
 * Created by luojialun on 2017/11/3.
 */

public class PopWindowBean {
    private int imageview;
    private String content;

    public PopWindowBean(int imageview, String content) {
        this.imageview = imageview;
        this.content = content;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
