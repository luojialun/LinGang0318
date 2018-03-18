package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/2 0002 10:22
 * @change
 * @chang time
 * @class describe
 */
public class NoticeDetaiBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"enterpriseId":1,"imgId":null,"enterpriseTitle":"首脑风暴","createTime":1494988770000,"updateTime":null,"enterpriseState":2,"basicsId":68,"lookNumber":1000,"enterpriseContent":"<p>全国的省级以上的领导开会<\/p>","basicsName":"行政公告","basicsType":9,"files":[{"fileId":272,"fileTitle":"aa","imgId":null,"imgPath":null,"fileAddress":"/image/upload/enterprise/20170519/201705191653134306.docx","fileType":1,"fileUpdateTime":null,"updateTime":null,"fileSize":0.2,"downloadSpeed":null,"downloadState":null},{"fileId":276,"fileTitle":"新建文本文档 (2).txt","imgId":null,"imgPath":null,"fileAddress":"/image/upload/enterprise/20170522/201705221454381595.txt","fileType":1,"fileUpdateTime":null,"updateTime":null,"fileSize":0,"downloadSpeed":null,"downloadState":null}]}
     * dataMap : null
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private DataBean data;
    private Object dataMap;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getDataMap() {
        return dataMap;
    }

    public void setDataMap(Object dataMap) {
        this.dataMap = dataMap;
    }

    public static class DataBean {
        /**
         * enterpriseId : 1
         * imgId : null
         * enterpriseTitle : 首脑风暴
         * createTime : 1494988770000
         * updateTime : null
         * enterpriseState : 2
         * basicsId : 68
         * lookNumber : 1000
         * enterpriseContent : <p>全国的省级以上的领导开会</p>
         * basicsName : 行政公告
         * basicsType : 9
         * files : [{"fileId":272,"fileTitle":"aa","imgId":null,"imgPath":null,"fileAddress":"/image/upload/enterprise/20170519/201705191653134306.docx","fileType":1,"fileUpdateTime":null,"updateTime":null,"fileSize":0.2,"downloadSpeed":null,"downloadState":null},{"fileId":276,"fileTitle":"新建文本文档 (2).txt","imgId":null,"imgPath":null,"fileAddress":"/image/upload/enterprise/20170522/201705221454381595.txt","fileType":1,"fileUpdateTime":null,"updateTime":null,"fileSize":0,"downloadSpeed":null,"downloadState":null}]
         */

        private String enterpriseId;
        private Object imgId;
        private String enterpriseTitle;
        private String createTime;
        private Object updateTime;
        private String enterpriseState;
        private String basicsId;
        private String lookNumber;
        private String enterpriseContent;
        private String basicsName;
        private String basicsType;
        private List<FileBean> files;

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public Object getImgId() {
            return imgId;
        }

        public void setImgId(Object imgId) {
            this.imgId = imgId;
        }

        public String getEnterpriseTitle() {
            return enterpriseTitle;
        }

        public void setEnterpriseTitle(String enterpriseTitle) {
            this.enterpriseTitle = enterpriseTitle;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getEnterpriseState() {
            return enterpriseState;
        }

        public void setEnterpriseState(String enterpriseState) {
            this.enterpriseState = enterpriseState;
        }

        public String getBasicsId() {
            return basicsId;
        }

        public void setBasicsId(String basicsId) {
            this.basicsId = basicsId;
        }

        public String getLookNumber() {
            return lookNumber;
        }

        public void setLookNumber(String lookNumber) {
            this.lookNumber = lookNumber;
        }

        public String getEnterpriseContent() {
            return enterpriseContent;
        }

        public void setEnterpriseContent(String enterpriseContent) {
            this.enterpriseContent = enterpriseContent;
        }

        public String getBasicsName() {
            return basicsName;
        }

        public void setBasicsName(String basicsName) {
            this.basicsName = basicsName;
        }

        public String getBasicsType() {
            return basicsType;
        }

        public void setBasicsType(String basicsType) {
            this.basicsType = basicsType;
        }

        public List<FileBean> getFiles() {
            return files;
        }

        public void setFiles(List<FileBean> files) {
            this.files = files;
        }


    }
}
