package com.lingang.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/8/24 0024 9:56
 * @change
 * @chang time
 * @class describe
 */
public class TunityDetailesBean implements Serializable{


    private static final long serialVersionUID = 7703555558006876738L;
    /**
     * data : {"approvalDate":null,"cancelDate":null,"chooseParkId":85,"chooseParkName":"漕河泾南桥园区","chooseUserAccount":"zhangsan","chooseUserId":16,"chooseUserName":"zs","confirmDate":null,"createDate":1503543659913,"customerCallId":null,"customerCallName":"","customerEnterpriseIsregister":0,"customerEnterpriseKeywords":"","customerEnterpriseName":"","customerMail":"","customerName":"科技的","customerRelationshipId":104,"customerRelationshipName":"同学","customerTel":"8293","historyUserId":16,"isactive":1,"keyId":267,"landArea":136,"landLocation":93,"landLocationName":"中环外","landType":97,"landTypeName":"商业","leaderParkId":null,"needType":[],"officeArea":null,"officeLocationId":null,"officeLocationName":"","officeTypeId":null,"officeTypeName":"","opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityLevel":"B","opportunityParks":[{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":141,"parkId":70,"parkName":"临港产业区"},{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":142,"parkId":97,"parkName":"q"},{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":143,"parkId":99,"parkName":"临港再制造园区"},{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":144,"parkId":98,"parkName":"临港新业坊"}],"opportunityRemark":"","opportunityState":"6","parkName":"","recommendUserAccount":"zhangsan","recommendUserId":16,"recommendUserName":"zs","registeredEnterpriseMoney":null,"registeredEnterpriseType":null,"registeredEnterpriseTypeName":"","saveEnterpriseMoney":null,"saveLandArea":null,"saveLandDay":null,"saveLandGetId":null,"saveLandGetName":"","saveLandNatureId":null,"saveLandNatureName":"","saveLandPeice":null,"saveOfficeArea":null,"saveOfficeDay":null,"saveOfficePrice":null,"saveOfficeTypeId":null,"saveOfficeTypeName":"","saveWorkshopArea":null,"saveWorkshopDay":null,"saveWorkshopPrice":null,"saveWorkshopTypeId":null,"saveWorkshopTypeName":"","showState":"5","submitDate":null,"supplementaryNotes":"","updateDate":1503471283787,"workshopArea":null,"workshopLocationId":null,"workshopLocationName":"","workshopTypeId":null,"workshopTypeName":""}
     * dataMap : null
     * message : 成功
     * remark :
     * stateCode : 1000
     */

    private DataBean data;
    private Object dataMap;
    private String message;
    private String remark;
    private String stateCode;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public static class DataBean implements Serializable{
        private static final long serialVersionUID = -7818704797370236649L;
        /**
         * approvalDate : null
         * cancelDate : null
         * chooseParkId : 85
         * chooseParkName : 漕河泾南桥园区
         * chooseUserAccount : zhangsan
         * chooseUserId : 16
         * chooseUserName : zs
         * confirmDate : null
         * createDate : 1503543659913
         * customerCallId : null
         * customerCallName :
         * customerEnterpriseIsregister : 0
         * customerEnterpriseKeywords :
         * customerEnterpriseName :
         * customerMail :
         * customerName : 科技的
         * customerRelationshipId : 104
         * customerRelationshipName : 同学
         * customerTel : 8293
         * historyUserId : 16
         * isactive : 1
         * keyId : 267
         * landArea : 136
         * landLocation : 93
         * landLocationName : 中环外
         * landType : 97
         * landTypeName : 商业
         * leaderParkId : null
         * needType : []
         * officeArea : null
         * officeLocationId : null
         * officeLocationName :
         * officeTypeId : null
         * officeTypeName :
         * opportunityId : d004149acb8f43c58c5c45d8d9b2a1c0
         * opportunityLevel : B
         * opportunityParks : [{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":141,"parkId":70,"parkName":"临港产业区"},{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":142,"parkId":97,"parkName":"q"},{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":143,"parkId":99,"parkName":"临港再制造园区"},{"opportunityId":"d004149acb8f43c58c5c45d8d9b2a1c0","opportunityParkId":144,"parkId":98,"parkName":"临港新业坊"}]
         * opportunityRemark :
         * opportunityState : 6
         * parkName :
         * recommendUserAccount : zhangsan
         * recommendUserId : 16
         * recommendUserName : zs
         * registeredEnterpriseMoney : null
         * registeredEnterpriseType : null
         * registeredEnterpriseTypeName :
         * saveEnterpriseMoney : null
         * saveLandArea : null
         * saveLandDay : null
         * saveLandGetId : null
         * saveLandGetName :
         * saveLandNatureId : null
         * saveLandNatureName :
         * saveLandPeice : null
         * saveOfficeArea : null
         * saveOfficeDay : null
         * saveOfficePrice : null
         * saveOfficeTypeId : null
         * saveOfficeTypeName :
         * saveWorkshopArea : null
         * saveWorkshopDay : null
         * saveWorkshopPrice : null
         * saveWorkshopTypeId : null
         * saveWorkshopTypeName :
         * showState : 5
         * submitDate : null
         * supplementaryNotes :
         * updateDate : 1503471283787
         * workshopArea : null
         * workshopLocationId : null
         * workshopLocationName :
         * workshopTypeId : null
         * workshopTypeName :
         */

        private Object approvalDate;
        private Object cancelDate;
        private String chooseParkId;
        private String chooseParkName;
        private String chooseUserAccount;
        private String chooseUserId;
        private String chooseUserName;
        private Object confirmDate;
        private String createDate;
        private String customerCallId;
        private String customerCallName;
        private String customerEnterpriseIsregister;
        private String customerEnterpriseKeywords;
        private String customerEnterpriseName;
        private String customerMail;
        private String customerName;
        private String customerRelationshipId;
        private String customerRelationshipName;
        private String customerTel;
        private String historyUserId;
        private String isactive;
        private String keyId;
        private String landArea;
        private String landLocation;
        private String landLocationName;
        private String landType;
        private String landTypeName;
        private Object leaderParkId;
        private String officeArea;
        private String officeLocationId;
        private String officeLocationName;
        private String officeTypeId;
        private String officeTypeName;
        private String opportunityId;
        private String opportunityLevel;
        private String opportunityRemark;
        private String opportunityState;
        private String parkName;
        private String recommendUserAccount;
        private String recommendUserId;
        private String recommendUserName;
        private String registeredEnterpriseMoney;
        private String registeredEnterpriseType;
        private String registeredEnterpriseTypeName;
        private Object saveEnterpriseMoney;
        private Object saveLandArea;
        private Object saveLandDay;
        private Object saveLandGetId;
        private String saveLandGetName;
        private Object saveLandNatureId;
        private String saveLandNatureName;
        private Object saveLandPeice;
        private Object saveOfficeArea;
        private Object saveOfficeDay;
        private Object saveOfficePrice;
        private Object saveOfficeTypeId;
        private String saveOfficeTypeName;
        private Object saveWorkshopArea;
        private Object saveWorkshopDay;
        private Object saveWorkshopPrice;
        private Object saveWorkshopTypeId;
        private String saveWorkshopTypeName;
        private String showState;
        private Object submitDate;
        private String supplementaryNotes;
        private String updateDate;
        private String workshopArea;
        private String workshopLocationId;
        private String workshopLocationName;
        private String workshopTypeId;
        private String workshopTypeName;
        private String introduceDate;
        private List<?> needType;
        private List<OpportunityParksBean> opportunityParks;

        public String getIntroduceDate() {
            return introduceDate;
        }

        public void setIntroduceDate(String introduceDate) {
            this.introduceDate = introduceDate;
        }

        public Object getApprovalDate() {
            return approvalDate;
        }

        public void setApprovalDate(Object approvalDate) {
            this.approvalDate = approvalDate;
        }

        public Object getCancelDate() {
            return cancelDate;
        }

        public void setCancelDate(Object cancelDate) {
            this.cancelDate = cancelDate;
        }

        public String getChooseParkId() {
            return chooseParkId;
        }

        public void setChooseParkId(String chooseParkId) {
            this.chooseParkId = chooseParkId;
        }

        public String getChooseParkName() {
            return chooseParkName;
        }

        public void setChooseParkName(String chooseParkName) {
            this.chooseParkName = chooseParkName;
        }

        public String getChooseUserAccount() {
            return chooseUserAccount;
        }

        public void setChooseUserAccount(String chooseUserAccount) {
            this.chooseUserAccount = chooseUserAccount;
        }

        public String getChooseUserId() {
            return chooseUserId;
        }

        public void setChooseUserId(String chooseUserId) {
            this.chooseUserId = chooseUserId;
        }

        public String getChooseUserName() {
            return chooseUserName;
        }

        public void setChooseUserName(String chooseUserName) {
            this.chooseUserName = chooseUserName;
        }

        public Object getConfirmDate() {
            return confirmDate;
        }

        public void setConfirmDate(Object confirmDate) {
            this.confirmDate = confirmDate;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getCustomerCallId() {
            return customerCallId;
        }

        public void setCustomerCallId(String customerCallId) {
            this.customerCallId = customerCallId;
        }

        public String getCustomerCallName() {
            return customerCallName;
        }

        public void setCustomerCallName(String customerCallName) {
            this.customerCallName = customerCallName;
        }

        public String getCustomerEnterpriseIsregister() {
            return customerEnterpriseIsregister;
        }

        public void setCustomerEnterpriseIsregister(String customerEnterpriseIsregister) {
            this.customerEnterpriseIsregister = customerEnterpriseIsregister;
        }

        public String getCustomerEnterpriseKeywords() {
            return customerEnterpriseKeywords;
        }

        public void setCustomerEnterpriseKeywords(String customerEnterpriseKeywords) {
            this.customerEnterpriseKeywords = customerEnterpriseKeywords;
        }

        public String getCustomerEnterpriseName() {
            return customerEnterpriseName;
        }

        public void setCustomerEnterpriseName(String customerEnterpriseName) {
            this.customerEnterpriseName = customerEnterpriseName;
        }

        public String getCustomerMail() {
            return customerMail;
        }

        public void setCustomerMail(String customerMail) {
            this.customerMail = customerMail;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerRelationshipId() {
            return customerRelationshipId;
        }

        public void setCustomerRelationshipId(String customerRelationshipId) {
            this.customerRelationshipId = customerRelationshipId;
        }

        public String getCustomerRelationshipName() {
            return customerRelationshipName;
        }

        public void setCustomerRelationshipName(String customerRelationshipName) {
            this.customerRelationshipName = customerRelationshipName;
        }

        public String getCustomerTel() {
            return customerTel;
        }

        public void setCustomerTel(String customerTel) {
            this.customerTel = customerTel;
        }

        public String getHistoryUserId() {
            return historyUserId;
        }

        public void setHistoryUserId(String historyUserId) {
            this.historyUserId = historyUserId;
        }

        public String getIsactive() {
            return isactive;
        }

        public void setIsactive(String isactive) {
            this.isactive = isactive;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public String getLandArea() {
            return landArea;
        }

        public void setLandArea(String landArea) {
            this.landArea = landArea;
        }

        public String getLandLocation() {
            return landLocation;
        }

        public void setLandLocation(String landLocation) {
            this.landLocation = landLocation;
        }

        public String getLandLocationName() {
            return landLocationName;
        }

        public void setLandLocationName(String landLocationName) {
            this.landLocationName = landLocationName;
        }

        public String getLandType() {
            return landType;
        }

        public void setLandType(String landType) {
            this.landType = landType;
        }

        public String getLandTypeName() {
            return landTypeName;
        }

        public void setLandTypeName(String landTypeName) {
            this.landTypeName = landTypeName;
        }

        public Object getLeaderParkId() {
            return leaderParkId;
        }

        public void setLeaderParkId(Object leaderParkId) {
            this.leaderParkId = leaderParkId;
        }

        public String getOfficeArea() {
            return officeArea;
        }

        public void setOfficeArea(String officeArea) {
            this.officeArea = officeArea;
        }

        public String getOfficeLocationId() {
            return officeLocationId;
        }

        public void setOfficeLocationId(String officeLocationId) {
            this.officeLocationId = officeLocationId;
        }

        public String getOfficeLocationName() {
            return officeLocationName;
        }

        public void setOfficeLocationName(String officeLocationName) {
            this.officeLocationName = officeLocationName;
        }

        public String getOfficeTypeId() {
            return officeTypeId;
        }

        public void setOfficeTypeId(String officeTypeId) {
            this.officeTypeId = officeTypeId;
        }

        public String getOfficeTypeName() {
            return officeTypeName;
        }

        public void setOfficeTypeName(String officeTypeName) {
            this.officeTypeName = officeTypeName;
        }

        public String getOpportunityId() {
            return opportunityId;
        }

        public void setOpportunityId(String opportunityId) {
            this.opportunityId = opportunityId;
        }

        public String getOpportunityLevel() {
            return opportunityLevel;
        }

        public void setOpportunityLevel(String opportunityLevel) {
            this.opportunityLevel = opportunityLevel;
        }

        public String getOpportunityRemark() {
            return opportunityRemark;
        }

        public void setOpportunityRemark(String opportunityRemark) {
            this.opportunityRemark = opportunityRemark;
        }

        public String getOpportunityState() {
            return opportunityState;
        }

        public void setOpportunityState(String opportunityState) {
            this.opportunityState = opportunityState;
        }

        public String getParkName() {
            return parkName;
        }

        public void setParkName(String parkName) {
            this.parkName = parkName;
        }

        public String getRecommendUserAccount() {
            return recommendUserAccount;
        }

        public void setRecommendUserAccount(String recommendUserAccount) {
            this.recommendUserAccount = recommendUserAccount;
        }

        public String getRecommendUserId() {
            return recommendUserId;
        }

        public void setRecommendUserId(String recommendUserId) {
            this.recommendUserId = recommendUserId;
        }

        public String getRecommendUserName() {
            return recommendUserName;
        }

        public void setRecommendUserName(String recommendUserName) {
            this.recommendUserName = recommendUserName;
        }

        public String getRegisteredEnterpriseMoney() {
            return registeredEnterpriseMoney;
        }

        public void setRegisteredEnterpriseMoney(String registeredEnterpriseMoney) {
            this.registeredEnterpriseMoney = registeredEnterpriseMoney;
        }

        public String getRegisteredEnterpriseType() {
            return registeredEnterpriseType;
        }

        public void setRegisteredEnterpriseType(String registeredEnterpriseType) {
            this.registeredEnterpriseType = registeredEnterpriseType;
        }

        public String getRegisteredEnterpriseTypeName() {
            return registeredEnterpriseTypeName;
        }

        public void setRegisteredEnterpriseTypeName(String registeredEnterpriseTypeName) {
            this.registeredEnterpriseTypeName = registeredEnterpriseTypeName;
        }

        public Object getSaveEnterpriseMoney() {
            return saveEnterpriseMoney;
        }

        public void setSaveEnterpriseMoney(Object saveEnterpriseMoney) {
            this.saveEnterpriseMoney = saveEnterpriseMoney;
        }

        public Object getSaveLandArea() {
            return saveLandArea;
        }

        public void setSaveLandArea(Object saveLandArea) {
            this.saveLandArea = saveLandArea;
        }

        public Object getSaveLandDay() {
            return saveLandDay;
        }

        public void setSaveLandDay(Object saveLandDay) {
            this.saveLandDay = saveLandDay;
        }

        public Object getSaveLandGetId() {
            return saveLandGetId;
        }

        public void setSaveLandGetId(Object saveLandGetId) {
            this.saveLandGetId = saveLandGetId;
        }

        public String getSaveLandGetName() {
            return saveLandGetName;
        }

        public void setSaveLandGetName(String saveLandGetName) {
            this.saveLandGetName = saveLandGetName;
        }

        public Object getSaveLandNatureId() {
            return saveLandNatureId;
        }

        public void setSaveLandNatureId(Object saveLandNatureId) {
            this.saveLandNatureId = saveLandNatureId;
        }

        public String getSaveLandNatureName() {
            return saveLandNatureName;
        }

        public void setSaveLandNatureName(String saveLandNatureName) {
            this.saveLandNatureName = saveLandNatureName;
        }

        public Object getSaveLandPeice() {
            return saveLandPeice;
        }

        public void setSaveLandPeice(Object saveLandPeice) {
            this.saveLandPeice = saveLandPeice;
        }

        public Object getSaveOfficeArea() {
            return saveOfficeArea;
        }

        public void setSaveOfficeArea(Object saveOfficeArea) {
            this.saveOfficeArea = saveOfficeArea;
        }

        public Object getSaveOfficeDay() {
            return saveOfficeDay;
        }

        public void setSaveOfficeDay(Object saveOfficeDay) {
            this.saveOfficeDay = saveOfficeDay;
        }

        public Object getSaveOfficePrice() {
            return saveOfficePrice;
        }

        public void setSaveOfficePrice(Object saveOfficePrice) {
            this.saveOfficePrice = saveOfficePrice;
        }

        public Object getSaveOfficeTypeId() {
            return saveOfficeTypeId;
        }

        public void setSaveOfficeTypeId(Object saveOfficeTypeId) {
            this.saveOfficeTypeId = saveOfficeTypeId;
        }

        public String getSaveOfficeTypeName() {
            return saveOfficeTypeName;
        }

        public void setSaveOfficeTypeName(String saveOfficeTypeName) {
            this.saveOfficeTypeName = saveOfficeTypeName;
        }

        public Object getSaveWorkshopArea() {
            return saveWorkshopArea;
        }

        public void setSaveWorkshopArea(Object saveWorkshopArea) {
            this.saveWorkshopArea = saveWorkshopArea;
        }

        public Object getSaveWorkshopDay() {
            return saveWorkshopDay;
        }

        public void setSaveWorkshopDay(Object saveWorkshopDay) {
            this.saveWorkshopDay = saveWorkshopDay;
        }

        public Object getSaveWorkshopPrice() {
            return saveWorkshopPrice;
        }

        public void setSaveWorkshopPrice(Object saveWorkshopPrice) {
            this.saveWorkshopPrice = saveWorkshopPrice;
        }

        public Object getSaveWorkshopTypeId() {
            return saveWorkshopTypeId;
        }

        public void setSaveWorkshopTypeId(Object saveWorkshopTypeId) {
            this.saveWorkshopTypeId = saveWorkshopTypeId;
        }

        public String getSaveWorkshopTypeName() {
            return saveWorkshopTypeName;
        }

        public void setSaveWorkshopTypeName(String saveWorkshopTypeName) {
            this.saveWorkshopTypeName = saveWorkshopTypeName;
        }

        public String getShowState() {
            return showState;
        }

        public void setShowState(String showState) {
            this.showState = showState;
        }

        public Object getSubmitDate() {
            return submitDate;
        }

        public void setSubmitDate(Object submitDate) {
            this.submitDate = submitDate;
        }

        public String getSupplementaryNotes() {
            return supplementaryNotes;
        }

        public void setSupplementaryNotes(String supplementaryNotes) {
            this.supplementaryNotes = supplementaryNotes;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getWorkshopArea() {
            return workshopArea;
        }

        public void setWorkshopArea(String workshopArea) {
            this.workshopArea = workshopArea;
        }

        public String getWorkshopLocationId() {
            return workshopLocationId;
        }

        public void setWorkshopLocationId(String workshopLocationId) {
            this.workshopLocationId = workshopLocationId;
        }

        public String getWorkshopLocationName() {
            return workshopLocationName;
        }

        public void setWorkshopLocationName(String workshopLocationName) {
            this.workshopLocationName = workshopLocationName;
        }

        public String getWorkshopTypeId() {
            return workshopTypeId;
        }

        public void setWorkshopTypeId(String workshopTypeId) {
            this.workshopTypeId = workshopTypeId;
        }

        public String getWorkshopTypeName() {
            return workshopTypeName;
        }

        public void setWorkshopTypeName(String workshopTypeName) {
            this.workshopTypeName = workshopTypeName;
        }

        public List<?> getNeedType() {
            return needType;
        }

        public void setNeedType(List<?> needType) {
            this.needType = needType;
        }

        public List<OpportunityParksBean> getOpportunityParks() {
            return opportunityParks;
        }

        public void setOpportunityParks(List<OpportunityParksBean> opportunityParks) {
            this.opportunityParks = opportunityParks;
        }

        public static class OpportunityParksBean implements Serializable{
            private static final long serialVersionUID = 1009228124932809711L;
            /**
             * opportunityId : d004149acb8f43c58c5c45d8d9b2a1c0
             * opportunityParkId : 141
             * parkId : 70
             * parkName : 临港产业区
             */

            private String opportunityId;
            private String opportunityParkId;
            private String parkId;
            private String parkName;

            public String getOpportunityId() {
                return opportunityId;
            }

            public void setOpportunityId(String opportunityId) {
                this.opportunityId = opportunityId;
            }

            public String getOpportunityParkId() {
                return opportunityParkId;
            }

            public void setOpportunityParkId(String opportunityParkId) {
                this.opportunityParkId = opportunityParkId;
            }

            public String getParkId() {
                return parkId;
            }

            public void setParkId(String parkId) {
                this.parkId = parkId;
            }

            public String getParkName() {
                return parkName;
            }

            public void setParkName(String parkName) {
                this.parkName = parkName;
            }
        }
    }
}
