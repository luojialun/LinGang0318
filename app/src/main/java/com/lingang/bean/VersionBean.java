package com.lingang.bean;

import java.util.List;

/**
 * Created by luojialun on 2017/9/25.
 */

public class VersionBean {

    /**
     * data : [{"createTime":1501556080327,"fileAddress":"/image/upload/version//201708011054328574.apk","fileSize":null,"fileState":2,"fileTitle":"app-release.apk","qRCodeAddress":"","sysVersionId":105,"types":1,"updateContent":"<p>版本测试<\/p>","updateTime":1501756956513,"uploadUser":"刘森","versionId":"0.0.7"},{"createTime":1501212675220,"fileAddress":"/image/upload/version//201707281130316340.apk","fileSize":null,"fileState":2,"fileTitle":"app-release.apk","qRCodeAddress":"","sysVersionId":104,"types":1,"updateContent":"<p>tracup 列表问题修改<\/p>","updateTime":1501556010103,"uploadUser":"刘森","versionId":"0.0.6"},{"createTime":1501150347587,"fileAddress":"/image/upload/version//201707271812135545.apk","fileSize":null,"fileState":2,"fileTitle":"app-release.apk","qRCodeAddress":"","sysVersionId":103,"types":1,"updateContent":"<p>1.版本更新；<\/p>","updateTime":1501212540800,"uploadUser":"刘森","versionId":"0.0.5"},{"createTime":1500962392627,"fileAddress":"/image/upload/version//201707251359418955.apk","fileSize":null,"fileState":2,"fileTitle":"app-release.apk","qRCodeAddress":"","sysVersionId":100,"types":1,"updateContent":"<p>1.测试版本；<\/p><p>2.内容更新<\/p>","updateTime":1501150254200,"uploadUser":"刘森","versionId":"0.0.4"},{"createTime":1500464248757,"fileAddress":"/image/upload/version//201707191937176375.apk","fileSize":null,"fileState":2,"fileTitle":"app-release.apk","qRCodeAddress":"","sysVersionId":98,"types":1,"updateContent":"","updateTime":1500532747693,"uploadUser":"刘森","versionId":"0.0.2"},{"createTime":1490673200000,"fileAddress":"/image/upload/version/20170309/201703091533282496.apk","fileSize":null,"fileState":2,"fileTitle":"外网_lingang_20170111.apk","qRCodeAddress":"","sysVersionId":60,"types":1,"updateContent":"<p>安卓beta版本<\/p>","updateTime":1500464096740,"uploadUser":"陈宁康","versionId":"0.0.1"}]
     * dataMap : null
     * message : 查询成功
     * remark :
     * stateCode : 1000
     */

    private Object dataMap;
    private String message;
    private String remark;
    private String stateCode;
    private List<DataBean> data;

    public Object getDataMap() {
        return dataMap;
    }

    public void setDataMap(Object dataMap) {
        this.dataMap = dataMap;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 1501556080327
         * fileAddress : /image/upload/version//201708011054328574.apk
         * fileSize : null
         * fileState : 2
         * fileTitle : app-release.apk
         * qRCodeAddress :
         * sysVersionId : 105
         * types : 1
         * updateContent : <p>版本测试</p>
         * updateTime : 1501756956513
         * uploadUser : 刘森
         * versionId : 0.0.7
         */

        private long createTime;
        private String fileAddress;
        private Object fileSize;
        private int fileState;
        private String fileTitle;
        private String qRCodeAddress;
        private int sysVersionId;
        private int types;
        private String updateContent;
        private long updateTime;
        private String uploadUser;
        private String versionId;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getFileAddress() {
            return fileAddress;
        }

        public void setFileAddress(String fileAddress) {
            this.fileAddress = fileAddress;
        }

        public Object getFileSize() {
            return fileSize;
        }

        public void setFileSize(Object fileSize) {
            this.fileSize = fileSize;
        }

        public int getFileState() {
            return fileState;
        }

        public void setFileState(int fileState) {
            this.fileState = fileState;
        }

        public String getFileTitle() {
            return fileTitle;
        }

        public void setFileTitle(String fileTitle) {
            this.fileTitle = fileTitle;
        }

        public String getQRCodeAddress() {
            return qRCodeAddress;
        }

        public void setQRCodeAddress(String qRCodeAddress) {
            this.qRCodeAddress = qRCodeAddress;
        }

        public int getSysVersionId() {
            return sysVersionId;
        }

        public void setSysVersionId(int sysVersionId) {
            this.sysVersionId = sysVersionId;
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

        public String getUploadUser() {
            return uploadUser;
        }

        public void setUploadUser(String uploadUser) {
            this.uploadUser = uploadUser;
        }

        public String getVersionId() {
            return versionId;
        }

        public void setVersionId(String versionId) {
            this.versionId = versionId;
        }
    }
}
