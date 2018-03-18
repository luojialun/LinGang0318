package com.lingang.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jason on 17/7/10.
 * banner 本地缓存数据
 */
@Entity(generateConstructors = false)
public class BannerLocal {
    public BannerLocal(String newsId, String newsTitle, String imgPath, String localImgPath) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.imgPath = imgPath;
        this.localImgPath = localImgPath;
    }

    @Id
    private Long id;
    private String newsId;
    private String newsTitle;
    private String imgPath;
    private String localImgPath;

    private String names;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public BannerLocal() {}

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }


    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getLocalImgPath() {
        return localImgPath;
    }

    public void setLocalImgPath(String localImgPath) {
        this.localImgPath = localImgPath;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }
}
