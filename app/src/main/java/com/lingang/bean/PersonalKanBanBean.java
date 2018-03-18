package com.lingang.bean;

/**
 * Created by luojialun on 2017/9/14.
 */

public class PersonalKanBanBean {
    private String stateCode;
    private Object message;
    private Object remark;
    private Object dataMap;
    private Data data;

    public String getStateCode() {
        return stateCode;
    }

    public Object getMessage() {
        return message;
    }

    public Object getRemark() {
        return remark;
    }

    public Object getDataMap() {
        return dataMap;
    }

    public Data getData() {
        return data;
    }

    public static class Data{
        private String claimed;
        private String executing;
        private String haveDelete;
        private String haveReturn;
        private String success;
        private String totalNum;
        private String unreview;

        public String getClaimed() {
            return claimed;
        }

        public String getExecuting() {
            return executing;
        }

        public String getHaveDelete() {
            return haveDelete;
        }

        public String getHaveReturn() {
            return haveReturn;
        }

        public String getSuccess() {
            return success;
        }

        public String getTotalNum() {
            return totalNum;
        }

        public String getUnreview() {
            return unreview;
        }
    }

}
