package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/6 0006 15:51
 * @change
 * @chang time
 * @class describe
 */
public class PartnerBean {

    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"countPage":1,"countRecord":4,"currentPage":1,"list":[{"partnerId":129,"typeId":1,"imgId":1147,"logoImgId":null,"basicsId":null,"partnerName":"中国国旅集团有限公司","partnerSimple":"中国国旅","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071746271008.jpg","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[{"labelId":37,"labelName":"科技园区","labelType":null,"createTime":null,"updateTime":null,"labelState":null},{"labelId":8,"labelName":"绿地","labelType":null,"createTime":null,"updateTime":null,"labelState":null}],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]},{"partnerId":128,"typeId":1,"imgId":1146,"logoImgId":null,"basicsId":null,"partnerName":"天亿投资集团","partnerSimple":"天亿投资","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071745195850.png","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[{"labelId":97,"labelName":"战略合作","labelType":null,"createTime":null,"updateTime":null,"labelState":null}],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]},{"partnerId":127,"typeId":1,"imgId":1143,"logoImgId":null,"basicsId":null,"partnerName":"招商局地产控股股份有限公司","partnerSimple":"招商局地产","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071743092915.jpg","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]},{"partnerId":126,"typeId":1,"imgId":1142,"logoImgId":null,"basicsId":null,"partnerName":"上海中外运船务代理有限公司","partnerSimple":"中外运","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071736336838.jpg","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]}],"onePageCount":10,"startIndex":1,"pageIndex":{"endIndex":1,"startIndex":1}}
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
         * countRecord : 4
         * currentPage : 1
         * list : [{"partnerId":129,"typeId":1,"imgId":1147,"logoImgId":null,"basicsId":null,"partnerName":"中国国旅集团有限公司","partnerSimple":"中国国旅","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071746271008.jpg","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[{"labelId":37,"labelName":"科技园区","labelType":null,"createTime":null,"updateTime":null,"labelState":null},{"labelId":8,"labelName":"绿地","labelType":null,"createTime":null,"updateTime":null,"labelState":null}],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]},{"partnerId":128,"typeId":1,"imgId":1146,"logoImgId":null,"basicsId":null,"partnerName":"天亿投资集团","partnerSimple":"天亿投资","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071745195850.png","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[{"labelId":97,"labelName":"战略合作","labelType":null,"createTime":null,"updateTime":null,"labelState":null}],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]},{"partnerId":127,"typeId":1,"imgId":1143,"logoImgId":null,"basicsId":null,"partnerName":"招商局地产控股股份有限公司","partnerSimple":"招商局地产","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071743092915.jpg","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]},{"partnerId":126,"typeId":1,"imgId":1142,"logoImgId":null,"basicsId":null,"partnerName":"上海中外运船务代理有限公司","partnerSimple":"中外运","partnerCompany":null,"createTime":null,"updateTime":null,"partnerState":null,"partnerContent":null,"topState":null,"topTime":null,"signTime":null,"collectState":null,"collectId":null,"imgPath":"/image/upload/img/20170407/201704071736336838.jpg","basicsName":null,"minImgId":null,"typeName":"产业集团","parks":[],"labels":[],"pumans":[],"umanagers":[],"companys":[],"signCompanys":[]}]
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
             * partnerId : 129
             * typeId : 1
             * imgId : 1147
             * logoImgId : null
             * basicsId : null
             * partnerName : 中国国旅集团有限公司
             * partnerSimple : 中国国旅
             * partnerCompany : null
             * createTime : null
             * updateTime : null
             * partnerState : null
             * partnerContent : null
             * topState : null
             * topTime : null
             * signTime : null
             * collectState : null
             * collectId : null
             * imgPath : /image/upload/img/20170407/201704071746271008.jpg
             * basicsName : null
             * minImgId : null
             * typeName : 产业集团
             * parks : []
             * labels : [{"labelId":37,"labelName":"科技园区","labelType":null,"createTime":null,"updateTime":null,"labelState":null},{"labelId":8,"labelName":"绿地","labelType":null,"createTime":null,"updateTime":null,"labelState":null}]
             * pumans : []
             * umanagers : []
             * companys : []
             * signCompanys : []
             */

            private String partnerId;
            private String typeId;
            private String imgId;
            private Object logoImgId;
            private Object basicsId;
            private String partnerName;
            private String partnerSimple;
            private Object partnerCompany;
            private Object createTime;
            private Object updateTime;
            private Object partnerState;
            private Object partnerContent;
            private Object topState;
            private Object topTime;
            private Object signTime;
            private Object collectState;
            private Object collectId;
            private String imgPath;
            private Object basicsName;
            private Object minImgId;
            private String typeName;
            private List<?> parks;
            private List<LabelsBean> labels;
            private List<?> pumans;
            private List<?> umanagers;
            private List<?> companys;
            private List<?> signCompanys;

            public String getPartnerId() {
                return partnerId;
            }

            public void setPartnerId(String partnerId) {
                this.partnerId = partnerId;
            }

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }

            public String getImgId() {
                return imgId;
            }

            public void setImgId(String imgId) {
                this.imgId = imgId;
            }

            public Object getLogoImgId() {
                return logoImgId;
            }

            public void setLogoImgId(Object logoImgId) {
                this.logoImgId = logoImgId;
            }

            public Object getBasicsId() {
                return basicsId;
            }

            public void setBasicsId(Object basicsId) {
                this.basicsId = basicsId;
            }

            public String getPartnerName() {
                return partnerName;
            }

            public void setPartnerName(String partnerName) {
                this.partnerName = partnerName;
            }

            public String getPartnerSimple() {
                return partnerSimple;
            }

            public void setPartnerSimple(String partnerSimple) {
                this.partnerSimple = partnerSimple;
            }

            public Object getPartnerCompany() {
                return partnerCompany;
            }

            public void setPartnerCompany(Object partnerCompany) {
                this.partnerCompany = partnerCompany;
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

            public Object getPartnerState() {
                return partnerState;
            }

            public void setPartnerState(Object partnerState) {
                this.partnerState = partnerState;
            }

            public Object getPartnerContent() {
                return partnerContent;
            }

            public void setPartnerContent(Object partnerContent) {
                this.partnerContent = partnerContent;
            }

            public Object getTopState() {
                return topState;
            }

            public void setTopState(Object topState) {
                this.topState = topState;
            }

            public Object getTopTime() {
                return topTime;
            }

            public void setTopTime(Object topTime) {
                this.topTime = topTime;
            }

            public Object getSignTime() {
                return signTime;
            }

            public void setSignTime(Object signTime) {
                this.signTime = signTime;
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

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public Object getBasicsName() {
                return basicsName;
            }

            public void setBasicsName(Object basicsName) {
                this.basicsName = basicsName;
            }

            public Object getMinImgId() {
                return minImgId;
            }

            public void setMinImgId(Object minImgId) {
                this.minImgId = minImgId;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public List<?> getParks() {
                return parks;
            }

            public void setParks(List<?> parks) {
                this.parks = parks;
            }

            public List<LabelsBean> getLabels() {
                return labels;
            }

            public void setLabels(List<LabelsBean> labels) {
                this.labels = labels;
            }

            public List<?> getPumans() {
                return pumans;
            }

            public void setPumans(List<?> pumans) {
                this.pumans = pumans;
            }

            public List<?> getUmanagers() {
                return umanagers;
            }

            public void setUmanagers(List<?> umanagers) {
                this.umanagers = umanagers;
            }

            public List<?> getCompanys() {
                return companys;
            }

            public void setCompanys(List<?> companys) {
                this.companys = companys;
            }

            public List<?> getSignCompanys() {
                return signCompanys;
            }

            public void setSignCompanys(List<?> signCompanys) {
                this.signCompanys = signCompanys;
            }

            public static class LabelsBean {
                /**
                 * labelId : 37
                 * labelName : 科技园区
                 * labelType : null
                 * createTime : null
                 * updateTime : null
                 * labelState : null
                 */

                private int labelId;
                private String labelName;
                private Object labelType;
                private Object createTime;
                private Object updateTime;
                private Object labelState;

                public int getLabelId() {
                    return labelId;
                }

                public void setLabelId(int labelId) {
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
