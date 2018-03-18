package com.lingang.bean;

import java.io.Serializable;

/**
 * Created by luojialun on 2017/8/22.
 */

public class KanbanBean implements Serializable{

    private static final long serialVersionUID = -6106693965166801462L;
    /**
     * stateCode : 1000
     * message : ""
     * remark : ""
     * data :{"avgSuccessTime":"0","claimed":"1","executing":"0","parkId":"","parkName":"集团商机统计数据","recentlyAdded":"2","success":"0","totalNum":"2"}
     * dataMap : {}
     */

    private String stateCode;
    private String remark;
    private String message;
    private Object dataMap;
    private Data data;

    public String getStateCode() {
        return stateCode;
    }

    public String getRemark() {
        return remark;
    }

    public String getMessage() {
        return message;
    }

    public Object getDataMap() {
        return dataMap;
    }

    public Data getData() {
        return data;
    }

    public static class Data{
        private String avgSuccessTime;
        private String claimed;
        private String executing;
        private String parkId;
        private String parkName;
        private String recentlyAdded;
        private String success;
        private String totalNum;

        public String getAvgSuccessTime() {
            return avgSuccessTime;
        }

        public String getClaimed() {
            return claimed;
        }

        public String getExecuting() {
            return executing;
        }

        public String getParkId() {
            return parkId;
        }

        public String getParkName() {
            return parkName;
        }

        public String getRecentlyAdded() {
            return recentlyAdded;
        }

        public String getSuccess() {
            return success;
        }

        public String getTotalNum() {
            return totalNum;
        }
    }
}
