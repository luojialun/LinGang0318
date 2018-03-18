package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/9 0009 14:23
 * @change
 * @chang time
 * @class describe
 */
public class AllClassBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : [{"basicsId":40,"basicsType":4,"basicsName":"标准厂房","createTime":1490079018610,"updateTime":1491876359290,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":41,"basicsType":4,"basicsName":"综合体","createTime":1490079036290,"updateTime":1491876426730,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":42,"basicsType":4,"basicsName":"定制厂房","createTime":1490079068550,"updateTime":1491876437800,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":66,"basicsType":4,"basicsName":"写字楼","createTime":1491876465250,"updateTime":null,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":67,"basicsType":4,"basicsName":"仓库","createTime":1491876488593,"updateTime":null,"basicsState":2,"createYear":null,"createMonth":null,"countType":null}]
     * dataMap : null
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private Object dataMap;
    private List<DataBean> data;

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

    public Object getDataMap() {
        return dataMap;
    }

    public void setDataMap(Object dataMap) {
        this.dataMap = dataMap;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * basicsId : 40
         * basicsType : 4
         * basicsName : 标准厂房
         * createTime : 1490079018610
         * updateTime : 1491876359290
         * basicsState : 2
         * createYear : null
         * createMonth : null
         * countType : null
         */

        private String basicsId;
        private String basicsType;
        private String basicsName;
        private String createTime;
        private String updateTime;
        private String basicsState;
        private Object createYear;
        private Object createMonth;
        private Object countType;
        private boolean isselect;

        public boolean isselect() {
            return isselect;
        }

        public void setIsselect(boolean isselect) {
            this.isselect = isselect;
        }

        public String getBasicsId() {
            return basicsId;
        }

        public void setBasicsId(String basicsId) {
            this.basicsId = basicsId;
        }

        public String getBasicsType() {
            return basicsType;
        }

        public void setBasicsType(String basicsType) {
            this.basicsType = basicsType;
        }

        public String getBasicsName() {
            return basicsName;
        }

        public void setBasicsName(String basicsName) {
            this.basicsName = basicsName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getBasicsState() {
            return basicsState;
        }

        public void setBasicsState(String basicsState) {
            this.basicsState = basicsState;
        }

        public Object getCreateYear() {
            return createYear;
        }

        public void setCreateYear(Object createYear) {
            this.createYear = createYear;
        }

        public Object getCreateMonth() {
            return createMonth;
        }

        public void setCreateMonth(Object createMonth) {
            this.createMonth = createMonth;
        }

        public Object getCountType() {
            return countType;
        }

        public void setCountType(Object countType) {
            this.countType = countType;
        }
    }
}
