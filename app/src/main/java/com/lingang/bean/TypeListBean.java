package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/8 0008 14:25
 * @change
 * @chang time
 * @class describe
 */
public class TypeListBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"countPage":1,"countRecord":7,"currentPage":1,"list":[{"typeId":1,"typeName":"产业集团","createTime":null,"updateTime":null,"countType":null},{"typeId":2,"typeName":"高等院校","createTime":null,"updateTime":null,"countType":null},{"typeId":3,"typeName":"科研院所","createTime":null,"updateTime":null,"countType":null},{"typeId":4,"typeName":"金融机构","createTime":null,"updateTime":null,"countType":null},{"typeId":6,"typeName":"政府及社团","createTime":null,"updateTime":null,"countType":null},{"typeId":7,"typeName":"文创产业","createTime":null,"updateTime":null,"countType":null},{"typeId":8,"typeName":"入驻企业","createTime":null,"updateTime":null,"countType":null}],"onePageCount":10,"startIndex":1,"pageIndex":{"endIndex":1,"startIndex":1}}
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
         * countPage : 1
         * countRecord : 7
         * currentPage : 1
         * list : [{"typeId":1,"typeName":"产业集团","createTime":null,"updateTime":null,"countType":null},{"typeId":2,"typeName":"高等院校","createTime":null,"updateTime":null,"countType":null},{"typeId":3,"typeName":"科研院所","createTime":null,"updateTime":null,"countType":null},{"typeId":4,"typeName":"金融机构","createTime":null,"updateTime":null,"countType":null},{"typeId":6,"typeName":"政府及社团","createTime":null,"updateTime":null,"countType":null},{"typeId":7,"typeName":"文创产业","createTime":null,"updateTime":null,"countType":null},{"typeId":8,"typeName":"入驻企业","createTime":null,"updateTime":null,"countType":null}]
         * onePageCount : 10
         * startIndex : 1
         * pageIndex : {"endIndex":1,"startIndex":1}
         */

        private String countPage;
        private String countRecord;
        private String currentPage;
        private String onePageCount;
        private String startIndex;
        private PageIndexBean pageIndex;
        private List<ListBean> list;

        public String getCountPage() {
            return countPage;
        }

        public void setCountPage(String countPage) {
            this.countPage = countPage;
        }

        public String getCountRecord() {
            return countRecord;
        }

        public void setCountRecord(String countRecord) {
            this.countRecord = countRecord;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getOnePageCount() {
            return onePageCount;
        }

        public void setOnePageCount(String onePageCount) {
            this.onePageCount = onePageCount;
        }

        public String getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(String startIndex) {
            this.startIndex = startIndex;
        }

        public PageIndexBean getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(PageIndexBean pageIndex) {
            this.pageIndex = pageIndex;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class PageIndexBean {
            /**
             * endIndex : 1
             * startIndex : 1
             */

            private String endIndex;
            private String startIndex;

            public String getEndIndex() {
                return endIndex;
            }

            public void setEndIndex(String endIndex) {
                this.endIndex = endIndex;
            }

            public String getStartIndex() {
                return startIndex;
            }

            public void setStartIndex(String startIndex) {
                this.startIndex = startIndex;
            }
        }

        public static class ListBean {
            /**
             * typeId : 1
             * typeName : 产业集团
             * createTime : null
             * updateTime : null
             * countType : null
             */

            private String typeId;
            private String typeName;
            private Object createTime;
            private Object updateTime;
            private Object countType;
            private boolean isselect;

            public boolean isselect() {
                return isselect;
            }

            public void setIsselect(boolean isselect) {
                this.isselect = isselect;
            }

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getCountType() {
                return countType;
            }

            public void setCountType(Object countType) {
                this.countType = countType;
            }
        }
    }
}
