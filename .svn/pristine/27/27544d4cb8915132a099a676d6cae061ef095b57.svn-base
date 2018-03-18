package com.lingang.bean;

import java.util.List;

/**
 * Created by jason on 17/6/13.
 * 意见反馈列表
 */
public class MessagePageListBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"countPage":1,"countRecord":2,"currentPage":1,"list":[{"messageId":1,"userId":1,"messageType":1,"createTime":1480952475000,"messageState":1,"linkType":1,"linkId":1,"messageContent":"test.."},{"messageId":3,"userId":2,"messageType":1,"createTime":1480953557000,"messageState":1,"linkType":1,"linkId":1,"messageContent":"test.."}],"onePageCount":10,"startIndex":0,"pageIndex":{"endIndex":1,"startIndex":1}}
     * dataMap : {"count":0,"opinionCount":0,"errorCount":0}
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private DataEntity data;
    private DataMapEntity dataMap;

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

    public DataMapEntity getDataMap() {
        return dataMap;
    }

    public void setDataMap(DataMapEntity dataMap) {
        this.dataMap = dataMap;
    }

    public static class DataEntity {
        /**
         * countPage : 1
         * countRecord : 2
         * currentPage : 1
         * list : [{"messageId":1,"userId":1,"messageType":1,"createTime":1480952475000,"messageState":1,"linkType":1,"linkId":1,"messageContent":"test.."},{"messageId":3,"userId":2,"messageType":1,"createTime":1480953557000,"messageState":1,"linkType":1,"linkId":1,"messageContent":"test.."}]
         * onePageCount : 10
         * startIndex : 0
         * pageIndex : {"endIndex":1,"startIndex":1}
         */

        private int countPage;
        private int countRecord;
        private int currentPage;
        private int onePageCount;
        private int startIndex;
        private PageIndexEntity pageIndex;
        private List<ListEntity> list;

        public int getCountPage() {
            return countPage;
        }

        public void setCountPage(int countPage) {
            this.countPage = countPage;
        }

        public int getCountRecord() {
            return countRecord;
        }

        public void setCountRecord(int countRecord) {
            this.countRecord = countRecord;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getOnePageCount() {
            return onePageCount;
        }

        public void setOnePageCount(int onePageCount) {
            this.onePageCount = onePageCount;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public PageIndexEntity getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(PageIndexEntity pageIndex) {
            this.pageIndex = pageIndex;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class PageIndexEntity {
            /**
             * endIndex : 1
             * startIndex : 1
             */

            private int endIndex;
            private int startIndex;

            public int getEndIndex() {
                return endIndex;
            }

            public void setEndIndex(int endIndex) {
                this.endIndex = endIndex;
            }

            public int getStartIndex() {
                return startIndex;
            }

            public void setStartIndex(int startIndex) {
                this.startIndex = startIndex;
            }
        }

        public static class ListEntity {
            /**
             * messageId : 1
             * userId : 1
             * messageType : 1
             * createTime : 1480952475000
             * messageState : 1
             * linkType : 1
             * linkId : 1
             * messageContent : test..
             */

            private int messageId;
            private int userId;
            private int messageType;
            private long createTime;
            private int messageState;
            private int linkType;
            private int linkId;
            private String messageContent;

            public int getMessageId() {
                return messageId;
            }

            public void setMessageId(int messageId) {
                this.messageId = messageId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getMessageType() {
                return messageType;
            }

            public void setMessageType(int messageType) {
                this.messageType = messageType;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getMessageState() {
                return messageState;
            }

            public void setMessageState(int messageState) {
                this.messageState = messageState;
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
        }
    }

    public static class DataMapEntity {
        /**
         * count : 0
         * opinionCount : 0
         * errorCount : 0
         */

        private int count;
        private int opinionCount;
        private int errorCount;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getOpinionCount() {
            return opinionCount;
        }

        public void setOpinionCount(int opinionCount) {
            this.opinionCount = opinionCount;
        }

        public int getErrorCount() {
            return errorCount;
        }

        public void setErrorCount(int errorCount) {
            this.errorCount = errorCount;
        }
    }
}
