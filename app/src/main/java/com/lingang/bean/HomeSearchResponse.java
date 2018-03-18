package com.lingang.bean;

import java.util.List;

/**
 * 搜索结果
 */
public class HomeSearchResponse<T> {


    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"countPage":1,"countRecord":3,"currentPage":1,"list":[{"newsId":99,"imgId":409,"newsTitle":"临港集团和中国移动上海分公司达成战略合作","newsAuthor":null,"lookNumber":null,"createTime":1482118210543,"updateTime":null,"newsState":null,"shareNumber":null,"newsContent":null,"imgPath":"/image/upload/img/20161221/20161221110409496.jpg"},{"newsId":37,"imgId":174,"newsTitle":"临港集团和中国移动上海分公司达成战略合作","newsAuthor":null,"lookNumber":null,"createTime":1481524077897,"updateTime":null,"newsState":null,"shareNumber":null,"newsContent":null,"imgPath":"/image/upload/img/20161214/201612141223423744.jpg"},{"newsId":33,"imgId":175,"newsTitle":"临港集团兑现承诺 上海临港获注园区资产","newsAuthor":null,"lookNumber":null,"createTime":1481362727943,"updateTime":null,"newsState":null,"shareNumber":null,"newsContent":null,"imgPath":"/image/upload/img/20161214/201612141226208949.jpg"}],"onePageCount":10,"startIndex":1,"pageIndex":{"endIndex":1,"startIndex":1}}
     * dataMap : {"list":[{"id":1,"namne":"新闻"},{"id":2,"namne":"政策"},{"id":3,"namne":"产业园区"},{"id":4,"namne":"合作伙伴"},{"id":5,"namne":"服务机构"},{"id":6,"namne":"入驻企业"},{"id":7,"namne":"公共平台"}]}
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private DataBean<T> data;
    private DataMapBean dataMap;

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

    public DataMapBean getDataMap() {
        return dataMap;
    }

    public void setDataMap(DataMapBean dataMap) {
        this.dataMap = dataMap;
    }

    public static class DataBean<T> {
        /**
         * countPage : 1
         * countRecord : 3
         * currentPage : 1
         * list : [{"newsId":99,"imgId":409,"newsTitle":"临港集团和中国移动上海分公司达成战略合作","newsAuthor":null,"lookNumber":null,"createTime":1482118210543,"updateTime":null,"newsState":null,"shareNumber":null,"newsContent":null,"imgPath":"/image/upload/img/20161221/20161221110409496.jpg"},{"newsId":37,"imgId":174,"newsTitle":"临港集团和中国移动上海分公司达成战略合作","newsAuthor":null,"lookNumber":null,"createTime":1481524077897,"updateTime":null,"newsState":null,"shareNumber":null,"newsContent":null,"imgPath":"/image/upload/img/20161214/201612141223423744.jpg"},{"newsId":33,"imgId":175,"newsTitle":"临港集团兑现承诺 上海临港获注园区资产","newsAuthor":null,"lookNumber":null,"createTime":1481362727943,"updateTime":null,"newsState":null,"shareNumber":null,"newsContent":null,"imgPath":"/image/upload/img/20161214/201612141226208949.jpg"}]
         * onePageCount : 10
         * startIndex : 1
         * pageIndex : {"endIndex":1,"startIndex":1}
         */

        private int countPage;
        private int countRecord;
        private int currentPage;
        private int onePageCount;
        private int startIndex;
        private PageIndexBean pageIndex;
        private List<T> list;

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

        public PageIndexBean getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(PageIndexBean pageIndex) {
            this.pageIndex = pageIndex;
        }

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

        public static class PageIndexBean {
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

    }

    public static class DataMapBean {
        private List<TypeBean> list;

        public List<TypeBean> getList() {
            return list;
        }

        public void setList(List<TypeBean> list) {
            this.list = list;
        }


    }
    public static class TypeBean {
        /**
         * id : 1
         * namne : 新闻
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
