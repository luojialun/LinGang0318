package com.lingang.bean;

/**
 * Created by jason on 17/7/19.
 */

public class UpdateBean {

    /**
     * sysVersionId : 60
     * versionId : 0.0.1
     * uploadUser : 陈宁康
     * types : 1
     * updateContent : <p>安卓beta版本</p>
     * updateTime : 1491894602127
     * fileTitle : 外网_lingang_20170111.apk
     * fileAddress : /image/upload/version/i-Lingang.html
     * fileSize : 0
     * fileState : 1
     * qRCodeAddress :
     * createTime : 1490673200000
     */

    private int sysVersionId;
    private String versionId;
    private String uploadUser;
    private int types;
    private String updateContent;
    private long updateTime;
    private String fileTitle;
    private String fileAddress;
    private int fileSize;
    private int fileState;
    private String forceUpdate;

    public String getForceUpdate() {
        return forceUpdate;
    }

    private String qRCodeAddress;
    private long createTime;

    public int getSysVersionId() {
        return sysVersionId;
    }

    public void setSysVersionId(int sysVersionId) {
        this.sysVersionId = sysVersionId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
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

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileState() {
        return fileState;
    }

    public void setFileState(int fileState) {
        this.fileState = fileState;
    }

    public String getQRCodeAddress() {
        return qRCodeAddress;
    }

    public void setQRCodeAddress(String qRCodeAddress) {
        this.qRCodeAddress = qRCodeAddress;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
