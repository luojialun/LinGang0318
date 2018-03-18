package com.lingang.bean;

/**
 * 信息纠错/意见反馈 回复详情
 */
public class MessageDetails {

    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"messageId":2,"createTime":1480952506000,"linkType":1,"linkId":1,"messageContent":"test..新闻列表","replyId":2,"replyTime":1480837938000,"replyName":"陈宁康","replyUserId":106,"replyContent":"那里的名字写错了"}
     * dataMap : null
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private DataEntity data;
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

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public Object getDataMap() {
        return dataMap;
    }

    public void setDataMap(Object dataMap) {
        this.dataMap = dataMap;
    }

    public static class DataEntity {
        /**
         * messageId : 2
         * createTime : 1480952506000
         * linkType : 1
         * linkId : 1
         * messageContent : test..新闻列表
         * replyId : 2
         * replyTime : 1480837938000
         * replyName : 陈宁康
         * replyUserId : 106
         * replyContent : 那里的名字写错了
         */

        private int messageId;
        private long createTime;
        private int linkType;
        private int linkId;
        private String linkName;
        private String messageContent;
        private int replyId;
        private long replyTime;
        private String replyName;
        private int replyUserId;
        private String replyContent;

        public int getMessageId() {
            return messageId;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        public int getLinkId() {
            return linkId;
        }

        public void setLinkId(int linkId) {
            this.linkId = linkId;
        }

        public String getMessageContent() {
            return messageContent;
        }

        public void setMessageContent(String messageContent) {
            this.messageContent = messageContent;
        }

        public int getReplyId() {
            return replyId;
        }

        public void setReplyId(int replyId) {
            this.replyId = replyId;
        }

        public long getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(long replyTime) {
            this.replyTime = replyTime;
        }

        public String getReplyName() {
            return replyName;
        }

        public void setReplyName(String replyName) {
            this.replyName = replyName;
        }

        public int getReplyUserId() {
            return replyUserId;
        }

        public void setReplyUserId(int replyUserId) {
            this.replyUserId = replyUserId;
        }

        public String getReplyContent() {
            return replyContent;
        }

        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        public String getLinkName() {
            return linkName;
        }

        public void setLinkName(String linkName) {
            this.linkName = linkName;
        }
    }
}
