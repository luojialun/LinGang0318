package com.lingang.bean;

import java.util.List;

/**
 * Created by luojialun on 2017/9/13.
 */

public class SysMsgBean {

    private String stateCode;
    private Object message;
    private Object remark;
    private Data data;
    private Object dataMap;

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

    public static class Data {
        private String countPage;
        private String countRecord;
        private String currentPage;
        private List<SysMsg> list;

        public String getCountPage() {
            return countPage;
        }

        public String getCountRecord() {
            return countRecord;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public List<SysMsg> getList() {
            return list;
        }
    }

    public static class SysMsg {
        private String content;
        private long createTime;
        private String firstTitle;
        private String messageId;
        private String messageType;
        private long readTime;
        private String secondTitle;
        private String smsId;
        private String status;
        private String userId;
        private String messageTypeName;
        private String isactive;   //  "0" 无效  "1" 有效
        private String opportunityId;
        private String showState;


        public String getOpportunityId() {
            return opportunityId;
        }

        public String getShowState() {
            return showState;
        }

        public String getIsactive() {
            return isactive;
        }

        public String getMessageTypeName() {
            return messageTypeName;
        }

        public String getContent() {
            return content;
        }


        public String getFirstTitle() {
            return firstTitle;
        }

        public String getMessageId() {
            return messageId;
        }

        public String getMessageType() {
            return messageType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public long getReadTime() {
            return readTime;
        }

        public String getSecondTitle() {
            return secondTitle;
        }

        public String getSmsId() {
            return smsId;
        }

        public String getStatus() {
            return status;
        }

        public String getUserId() {
            return userId;
        }
    }
}
