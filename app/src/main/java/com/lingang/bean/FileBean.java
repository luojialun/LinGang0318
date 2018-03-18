package com.lingang.bean;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/7/13 0013 19:20
 * @change
 * @chang time
 * @class describe
 */
public class FileBean {
    private String fileId;
    private Object parkId;
    private Object imgId;
    private String fileTitle;
    private String fileAddress;
    private String fileType;
    private Object createTime;
    private Object updateTime;
    private double fileSize;
    private Object shareNumber;
    private Object fileRemark;
    private Object fatherId;
    private String imgIdVideo;
    private String imgPathVideo;
    private String shareUrl;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Object getParkId() {
        return parkId;
    }

    public void setParkId(Object parkId) {
        this.parkId = parkId;
    }

    public Object getImgId() {
        return imgId;
    }

    public void setImgId(Object imgId) {
        this.imgId = imgId;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getFileRemark() {
        return fileRemark;
    }

    public void setFileRemark(Object fileRemark) {
        this.fileRemark = fileRemark;
    }

    public Object getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(Object shareNumber) {
        this.shareNumber = shareNumber;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public Object getFatherId() {
        return fatherId;
    }

    public void setFatherId(Object fatherId) {
        this.fatherId = fatherId;
    }

    public String getImgIdVideo() {
        return imgIdVideo;
    }

    public void setImgIdVideo(String imgIdVideo) {
        this.imgIdVideo = imgIdVideo;
    }

    public String getImgPathVideo() {
        return imgPathVideo;
    }

    public void setImgPathVideo(String imgPathVideo) {
        this.imgPathVideo = imgPathVideo;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}
