package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/5/11 0011 17:37
 * @change
 * @chang time
 * @class describe
 */
public class NewsTabBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : [{"basicsId":55,"basicsType":6,"basicsName":"推荐","createTime":1491476309217,"updateTime":1491535936110,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":56,"basicsType":6,"basicsName":"集团新闻","createTime":1491476329923,"updateTime":null,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":57,"basicsType":6,"basicsName":"招商新闻","createTime":1491476345987,"updateTime":null,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":58,"basicsType":6,"basicsName":"园区动态","createTime":1491476354727,"updateTime":null,"basicsState":2,"createYear":null,"createMonth":null,"countType":null},{"basicsId":64,"basicsType":6,"basicsName":"服务动态","createTime":1491396376587,"updateTime":1491396376587,"basicsState":2,"createYear":null,"createMonth":null,"countType":null}]
     * dataMap : null
     */

    private String stateCode;
    private String message;
    private String remark;
    private Object dataMap;
    private List<DataBean> data;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
         * basicsId : 55
         * basicsType : 6
         * basicsName : 推荐
         * createTime : 1491476309217
         * updateTime : 1491535936110
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
