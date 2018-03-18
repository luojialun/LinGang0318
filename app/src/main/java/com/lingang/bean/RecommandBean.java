package com.lingang.bean;

import java.util.List;

/**
 * Created by luojialun on 2017/8/21.
 */

public class RecommandBean {
/**
 * stateCode : 1000
 * message : ""
 * remark : ""
 * data : {"countPage":1,"countRecord":1,"currentPage":1,"list":[{"customerEnterpriseIsregister":"1","customerEnterpriseKeywords":"","customerEnterpriseName":"中国人民民银行","customerName":"袁国华","haveEnterpriseType":"1","haveLand":"0","haveOffice":"0","haveWorkshop":"0","keyId":"111","opportunityId":"f1d185aac0c74c46985e8ee465cdb932","opportunityLevel":"B","recommendUserId":"7","showState":"2","userName":"zj"}],"onePageCount":20,"pageIndex":{"endIndex":1,"startIndex":1},"startIndex":1}
 * dataMap : []
 */

    private int stateCode;
    private String message;
    private String remark;
    private Object dataMap;
    private Data data;

    public int getStateCode() {
        return stateCode;
    }

    public String getMessage() {
        return message;
    }

    public String getRemark() {
        return remark;
    }

    public Object getDataMap() {
        return dataMap;
    }

    public Data getData() {
        return data;
    }

    public static class Data{
        private int countPage;
        private int countRecord;
        private int currentPage;
        private List<Recommand> list;
        private int onePageCount;
        private PageIndex pageIndex;
        private int startIndex;

        public int getCountPage() {
            return countPage;
        }

        public int getCountRecord() {
            return countRecord;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public List<Recommand> getList() {
            return list;
        }

        public int getOnePageCount() {
            return onePageCount;
        }

        public PageIndex getPageIndex() {
            return pageIndex;
        }

        public int getStartIndex() {
            return startIndex;
        }
    }

    public static class Recommand{
        private String customerEnterpriseIsregister;
        private String customerEnterpriseKeywords;
        private String customerEnterpriseName;
        private String customerName;
        private String haveEnterpriseType;
        private String haveLand;
        private String haveOffice;
        private String haveWorkshop;
        private String keyId;
        private String opportunityId;
        private String opportunityLevel;
        private String recommendUserId;
        private String showState;
        private String userName;

        public String getCustomerEnterpriseIsregister() {
            return customerEnterpriseIsregister;
        }

        public String getCustomerEnterpriseKeywords() {
            return customerEnterpriseKeywords;
        }

        public String getCustomerEnterpriseName() {
            return customerEnterpriseName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getHaveEnterpriseType() {
            return haveEnterpriseType;
        }

        public String getHaveLand() {
            return haveLand;
        }

        public String getHaveOffice() {
            return haveOffice;
        }

        public String getHaveWorkshop() {
            return haveWorkshop;
        }

        public String getKeyId() {
            return keyId;
        }

        public String getOpportunityId() {
            return opportunityId;
        }

        public String getOpportunityLevel() {
            return opportunityLevel;
        }

        public String getRecommendUserId() {
            return recommendUserId;
        }

        public String getShowState() {
            return showState;
        }

        public String getUserName() {
            return userName;
        }
    }

    private static class PageIndex{
        private int endIndex;
        private int startIndex;

        public int getEndIndex() {
            return endIndex;
        }

        public int getStartIndex() {
            return startIndex;
        }
    }




}
