package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/9 0009 11:58
 * @change
 * @chang time
 * @class describe
 */
public class BusinessBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"countPage":1,"countRecord":1,"currentPage":1,"list":[{"businessId":83,"regionId":null,"minImgId":null,"maxImgId":null,"businessName":"1号招商1","businessAddress":null,"businessFax":null,"businessLink":null,"createTime":null,"updateTime":null,"businessState":null,"detailLink":null,"businessContent":"dasdsakhdl奥斯卡发货撒立刻付款1","sortNumber":null,"basicsId":null,"projectState":1,"parkId":45,"collectState":null,"collectId":null,"imgId":943,"imgPath":"/image/upload/img/20170324/201703241021284255.jpg","businessImgId":null,"businessImgPath":null,"maxImgPath":null,"regionName":null,"wayId":null,"wayTel":null,"parkName":"上海南港","businessCompany":null,"companys":[],"ways":[],"labels":[{"labelId":90,"labelName":"科创企业","labelType":null,"createTime":null,"updateTime":null,"labelState":null}],"files":[]}],"onePageCount":1,"startIndex":1,"pageIndex":{"endIndex":1,"startIndex":1}}
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
         * countRecord : 1
         * currentPage : 1
         * list : [{"businessId":83,"regionId":null,"minImgId":null,"maxImgId":null,"businessName":"1号招商1","businessAddress":null,"businessFax":null,"businessLink":null,"createTime":null,"updateTime":null,"businessState":null,"detailLink":null,"businessContent":"dasdsakhdl奥斯卡发货撒立刻付款1","sortNumber":null,"basicsId":null,"projectState":1,"parkId":45,"collectState":null,"collectId":null,"imgId":943,"imgPath":"/image/upload/img/20170324/201703241021284255.jpg","businessImgId":null,"businessImgPath":null,"maxImgPath":null,"regionName":null,"wayId":null,"wayTel":null,"parkName":"上海南港","businessCompany":null,"companys":[],"ways":[],"labels":[{"labelId":90,"labelName":"科创企业","labelType":null,"createTime":null,"updateTime":null,"labelState":null}],"files":[]}]
         * onePageCount : 1
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
             * businessId : 83
             * regionId : null
             * minImgId : null
             * maxImgId : null
             * businessName : 1号招商1
             * businessAddress : null
             * businessFax : null
             * businessLink : null
             * createTime : null
             * updateTime : null
             * businessState : null
             * detailLink : null
             * businessContent : dasdsakhdl奥斯卡发货撒立刻付款1
             * sortNumber : null
             * basicsId : null
             * projectState : 1
             * parkId : 45
             * collectState : null
             * collectId : null
             * imgId : 943
             * imgPath : /image/upload/img/20170324/201703241021284255.jpg
             * businessImgId : null
             * businessImgPath : null
             * maxImgPath : null
             * regionName : null
             * wayId : null
             * wayTel : null
             * parkName : 上海南港
             * businessCompany : null
             * companys : []
             * ways : []
             * labels : [{"labelId":90,"labelName":"科创企业","labelType":null,"createTime":null,"updateTime":null,"labelState":null}]
             * files : []
             */

            private String businessId;
            private Object regionId;
            private Object minImgId;
            private Object maxImgId;
            private String businessName;
            private Object businessAddress;
            private Object businessFax;
            private Object businessLink;
            private Object createTime;
            private Object updateTime;
            private Object businessState;
            private Object detailLink;
            private String businessContent;
            private Object sortNumber;
            private Object basicsId;
            private String projectState;
            private String parkId;
            private Object collectState;
            private Object collectId;
            private String imgId;
            private String imgPath;
            private Object businessImgId;
            private Object businessImgPath;
            private Object maxImgPath;
            private Object regionName;
            private Object wayId;
            private Object wayTel;
            private String parkName;
            private Object businessCompany;
            private List<?> companys;
            private List<?> ways;
            private List<LabelsBean> labels;
            private List<?> files;

            public String getBusinessId() {
                return businessId;
            }

            public void setBusinessId(String businessId) {
                this.businessId = businessId;
            }

            public Object getRegionId() {
                return regionId;
            }

            public void setRegionId(Object regionId) {
                this.regionId = regionId;
            }

            public Object getMinImgId() {
                return minImgId;
            }

            public void setMinImgId(Object minImgId) {
                this.minImgId = minImgId;
            }

            public Object getMaxImgId() {
                return maxImgId;
            }

            public void setMaxImgId(Object maxImgId) {
                this.maxImgId = maxImgId;
            }

            public String getBusinessName() {
                return businessName;
            }

            public void setBusinessName(String businessName) {
                this.businessName = businessName;
            }

            public Object getBusinessAddress() {
                return businessAddress;
            }

            public void setBusinessAddress(Object businessAddress) {
                this.businessAddress = businessAddress;
            }

            public Object getBusinessFax() {
                return businessFax;
            }

            public void setBusinessFax(Object businessFax) {
                this.businessFax = businessFax;
            }

            public Object getBusinessLink() {
                return businessLink;
            }

            public void setBusinessLink(Object businessLink) {
                this.businessLink = businessLink;
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

            public Object getBusinessState() {
                return businessState;
            }

            public void setBusinessState(Object businessState) {
                this.businessState = businessState;
            }

            public Object getDetailLink() {
                return detailLink;
            }

            public void setDetailLink(Object detailLink) {
                this.detailLink = detailLink;
            }

            public String getBusinessContent() {
                return businessContent;
            }

            public void setBusinessContent(String businessContent) {
                this.businessContent = businessContent;
            }

            public Object getSortNumber() {
                return sortNumber;
            }

            public void setSortNumber(Object sortNumber) {
                this.sortNumber = sortNumber;
            }

            public Object getBasicsId() {
                return basicsId;
            }

            public void setBasicsId(Object basicsId) {
                this.basicsId = basicsId;
            }

            public String getProjectState() {
                return projectState;
            }

            public void setProjectState(String projectState) {
                this.projectState = projectState;
            }

            public String getParkId() {
                return parkId;
            }

            public void setParkId(String parkId) {
                this.parkId = parkId;
            }

            public Object getCollectState() {
                return collectState;
            }

            public void setCollectState(Object collectState) {
                this.collectState = collectState;
            }

            public Object getCollectId() {
                return collectId;
            }

            public void setCollectId(Object collectId) {
                this.collectId = collectId;
            }

            public String getImgId() {
                return imgId;
            }

            public void setImgId(String imgId) {
                this.imgId = imgId;
            }

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public Object getBusinessImgId() {
                return businessImgId;
            }

            public void setBusinessImgId(Object businessImgId) {
                this.businessImgId = businessImgId;
            }

            public Object getBusinessImgPath() {
                return businessImgPath;
            }

            public void setBusinessImgPath(Object businessImgPath) {
                this.businessImgPath = businessImgPath;
            }

            public Object getMaxImgPath() {
                return maxImgPath;
            }

            public void setMaxImgPath(Object maxImgPath) {
                this.maxImgPath = maxImgPath;
            }

            public Object getRegionName() {
                return regionName;
            }

            public void setRegionName(Object regionName) {
                this.regionName = regionName;
            }

            public Object getWayId() {
                return wayId;
            }

            public void setWayId(Object wayId) {
                this.wayId = wayId;
            }

            public Object getWayTel() {
                return wayTel;
            }

            public void setWayTel(Object wayTel) {
                this.wayTel = wayTel;
            }

            public String getParkName() {
                return parkName;
            }

            public void setParkName(String parkName) {
                this.parkName = parkName;
            }

            public Object getBusinessCompany() {
                return businessCompany;
            }

            public void setBusinessCompany(Object businessCompany) {
                this.businessCompany = businessCompany;
            }

            public List<?> getCompanys() {
                return companys;
            }

            public void setCompanys(List<?> companys) {
                this.companys = companys;
            }

            public List<?> getWays() {
                return ways;
            }

            public void setWays(List<?> ways) {
                this.ways = ways;
            }

            public List<LabelsBean> getLabels() {
                return labels;
            }

            public void setLabels(List<LabelsBean> labels) {
                this.labels = labels;
            }

            public List<?> getFiles() {
                return files;
            }

            public void setFiles(List<?> files) {
                this.files = files;
            }

            public static class LabelsBean {
                /**
                 * labelId : 90
                 * labelName : 科创企业
                 * labelType : null
                 * createTime : null
                 * updateTime : null
                 * labelState : null
                 */

                private String labelId;
                private String labelName;
                private Object labelType;
                private Object createTime;
                private Object updateTime;
                private Object labelState;

                public String getLabelId() {
                    return labelId;
                }

                public void setLabelId(String labelId) {
                    this.labelId = labelId;
                }

                public String getLabelName() {
                    return labelName;
                }

                public void setLabelName(String labelName) {
                    this.labelName = labelName;
                }

                public Object getLabelType() {
                    return labelType;
                }

                public void setLabelType(Object labelType) {
                    this.labelType = labelType;
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

                public Object getLabelState() {
                    return labelState;
                }

                public void setLabelState(Object labelState) {
                    this.labelState = labelState;
                }
            }
        }
    }
}
