package com.lingang.bean;

import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/9/21 0021 15:37
 * @change
 * @chang time
 * @class describe
 */
public class HomeSwitchTv {
    /**
     * data : [{"keyId":"1","opportunityId":"7f433687ac604c34a4243f03853b5a05","showContent":"lr2017年09月12日推荐了厂房、研发办公、土地类商机","showState":"3"},{"keyId":"3","opportunityId":"83c6c95a1174426fadbbfcb81edcd388","showContent":" 袁晨2017年09月12日推荐了厂房类商机","showState":"3"},{"keyId":"4","opportunityId":"9ba171529e03483dacc8296eeb65cf19","showContent":" 袁晨2017年09月12日推荐了厂房类商机","showState":"3"},{"keyId":"14","opportunityId":"34858e5cc7424158881a2bd3aeff4cdc","showContent":"lr2017年09月12日推荐了厂房、研发办公、土地、注册型企业类商机","showState":"3"},{"keyId":"20","opportunityId":"429325c7993d477a84df7b1316560d6f","showContent":" 潘嵘嵘2017年09月12日推荐了厂房、研发办公、土地、注册型企业类商机","showState":"3"},{"keyId":"22","opportunityId":"7364d8918ca44084bfd58c4af3334d67","showContent":" 袁晨2017年09月12日推荐了注册型企业类商机","showState":"3"},{"keyId":"23","opportunityId":"3f039f434db844f3b933c2dfe595ee5f","showContent":"师纬2017年09月12日推荐了注册型企业类商机","showState":"3"},{"keyId":"24","opportunityId":"fd358afcaf704ba3a81dfea559f691ee","showContent":"师纬2017年09月12日推荐了注册型企业类商机","showState":"3"},{"keyId":"29","opportunityId":"50edc1b4630f43988ddf762c2a2220ba","showContent":" 袁晨2017年09月12日推荐了厂房类商机","showState":"3"},{"keyId":"34","opportunityId":"7dec2c3888c84dc3a6cacc6c20225054","showContent":"师纬2017年09月12日推荐了注册型企业类商机","showState":"3"}]
     * dataMap : {}
     * message :
     * remark :
     * stateCode : 1000
     */

    private DataMapBean dataMap;
    private String message;
    private String remark;
    private String stateCode;
    private List<DataBean> data;

    public DataMapBean getDataMap() {
        return dataMap;
    }

    public void setDataMap(DataMapBean dataMap) {
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

    public static class DataMapBean {
    }

    public static class DataBean {
        /**
         * keyId : 1
         * opportunityId : 7f433687ac604c34a4243f03853b5a05
         * showContent : lr2017年09月12日推荐了厂房、研发办公、土地类商机
         * showState : 3
         */

        private String keyId;
        private String opportunityId;
        private String showContent;
        private String showState;

        private String haveWorkshop;
        private String haveOffice;
        private String haveLand;
        private String haveEnterpriseType;

        public String getHaveWorkshop() {
            return haveWorkshop;
        }

        public void setHaveWorkshop(String haveWorkshop) {
            this.haveWorkshop = haveWorkshop;
        }

        public String getHaveOffice() {
            return haveOffice;
        }

        public void setHaveOffice(String haveOffice) {
            this.haveOffice = haveOffice;
        }

        public String getHaveLand() {
            return haveLand;
        }

        public void setHaveLand(String haveLand) {
            this.haveLand = haveLand;
        }

        public String getHaveEnterpriseType() {
            return haveEnterpriseType;
        }

        public void setHaveEnterpriseType(String haveEnterpriseType) {
            this.haveEnterpriseType = haveEnterpriseType;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public String getOpportunityId() {
            return opportunityId;
        }

        public void setOpportunityId(String opportunityId) {
            this.opportunityId = opportunityId;
        }

        public String getShowContent() {
            return showContent;
        }

        public void setShowContent(String showContent) {
            this.showContent = showContent;
        }

        public String getShowState() {
            return showState;
        }

        public void setShowState(String showState) {
            this.showState = showState;
        }
    }
}
