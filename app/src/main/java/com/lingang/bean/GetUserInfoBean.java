package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/23 0023 20:33
 * @change
 * @chang time
 * @class describe
 */
public class GetUserInfoBean
{
    /**
     * message :
     * Data : [{"UserID":"875548A7-24C5-4F33-9960-81735B626D20","UserAccount":"huangshuai","UserPWD":"123456","UserCHName":"黄帅","UserENName":"","UserSex":"1","UserTel":"","UserEmail":"","UserMb":"17612162130","UserMbIsEnabled":"1","UserFax":"","UserJoinDate":"","UserLanguage":"","UserIsOut":"","UserLevel":"","UserBirthday":"","UserLocation":"","UserEducation":"","UserMajor":"","UserActive":"","UserIsDelete":"0","UserPhoto":"http://oatest.shlingang.com/images/Photo/headPhoto.jpg","UserHRID":"","UserAddress":"","UserOU":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","UserADCreateDate":"2017/6/9 0:00:00","UserPoliticalStatus":"群众","UserJoinPartDate":"","UserZip":"","UserDirectTel":"","UserInnerTel":"","UserIsInDomain":"1","UserIsInMobileMemu":"0","UserMobileMemu":"","UserMobileMemuNumber":"","UserMobileMemuStartTime":"","UserMobileMemuEndTime":"","MobileMemuStartOU":"","UserCreater":"0318F338-CA93-45EF-88E8-BECD6EA42663","UserCreateDateTime":"2017/6/9 18:09:32","UserUpdater":"","UserUpdateDateTime":"2017/6/9 18:09:32","UserIsSupportSMS":"0","UserSMSQuota":"0","UserIsAdmin":"0","LastLoginTime":"2017/6/15 21:10:00","UserMobileMemuMemo":"","UserCreaterName":"","UserUpdaterName":"","UserSMSProvisQuota":"","UserIsSystemAccount":"0","LabourRelationCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","LabourRelationName":"集团本部","IsLeader":"False","UserOUName":"集团本部","PrimaryJobName":"","PrimaryGroupName":"","PrimaryCompanyName":""}]
     */

    private String message;
    private List<DataBean> Data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * UserID : 875548A7-24C5-4F33-9960-81735B626D20
         * UserAccount : huangshuai
         * UserPWD : 123456
         * UserCHName : 黄帅
         * UserENName :
         * UserSex : 1
         * UserTel :
         * UserEmail :
         * UserMb : 17612162130
         * UserMbIsEnabled : 1
         * UserFax :
         * UserJoinDate :
         * UserLanguage :
         * UserIsOut :
         * UserLevel :
         * UserBirthday :
         * UserLocation :
         * UserEducation :
         * UserMajor :
         * UserActive :
         * UserIsDelete : 0
         * UserPhoto : http://oatest.shlingang.com/images/Photo/headPhoto.jpg
         * UserHRID :
         * UserAddress :
         * UserOU : 75231AA6-6CBC-4B07-804E-A78CDE9777D6
         * UserADCreateDate : 2017/6/9 0:00:00
         * UserPoliticalStatus : 群众
         * UserJoinPartDate :
         * UserZip :
         * UserDirectTel :
         * UserInnerTel :
         * UserIsInDomain : 1
         * UserIsInMobileMemu : 0
         * UserMobileMemu :
         * UserMobileMemuNumber :
         * UserMobileMemuStartTime :
         * UserMobileMemuEndTime :
         * MobileMemuStartOU :
         * UserCreater : 0318F338-CA93-45EF-88E8-BECD6EA42663
         * UserCreateDateTime : 2017/6/9 18:09:32
         * UserUpdater :
         * UserUpdateDateTime : 2017/6/9 18:09:32
         * UserIsSupportSMS : 0
         * UserSMSQuota : 0
         * UserIsAdmin : 0
         * LastLoginTime : 2017/6/15 21:10:00
         * UserMobileMemuMemo :
         * UserCreaterName :
         * UserUpdaterName :
         * UserSMSProvisQuota :
         * UserIsSystemAccount : 0
         * LabourRelationCD : 75231AA6-6CBC-4B07-804E-A78CDE9777D6
         * LabourRelationName : 集团本部
         * IsLeader : False
         * UserOUName : 集团本部
         * PrimaryJobName :
         * PrimaryGroupName :
         * PrimaryCompanyName :
         */

        private String UserID;
        private String UserAccount;
        private String UserPWD;
        private String UserCHName;
        private String UserENName;
        private String UserSex;
        private String UserTel;
        private String UserEmail;
        private String UserMb;
        private String UserMbIsEnabled;
        private String UserFax;
        private String UserJoinDate;
        private String UserLanguage;
        private String UserIsOut;
        private String UserLevel;
        private String UserBirthday;
        private String UserLocation;
        private String UserEducation;
        private String UserMajor;
        private String UserActive;
        private String UserIsDelete;
        private String UserPhoto;
        private String UserHRID;
        private String UserAddress;
        private String UserOU;
        private String UserADCreateDate;
        private String UserPoliticalStatus;
        private String UserJoinPartDate;
        private String UserZip;
        private String UserDirectTel;
        private String UserInnerTel;
        private String UserIsInDomain;
        private String UserIsInMobileMemu;
        private String UserMobileMemu;
        private String UserMobileMemuNumber;
        private String UserMobileMemuStartTime;
        private String UserMobileMemuEndTime;
        private String MobileMemuStartOU;
        private String UserCreater;
        private String UserCreateDateTime;
        private String UserUpdater;
        private String UserUpdateDateTime;
        private String UserIsSupportSMS;
        private String UserSMSQuota;
        private String UserIsAdmin;
        private String LastLoginTime;
        private String UserMobileMemuMemo;
        private String UserCreaterName;
        private String UserUpdaterName;
        private String UserSMSProvisQuota;
        private String UserIsSystemAccount;
        private String LabourRelationCD;
        private String LabourRelationName;
        private String IsLeader;
        private String UserOUName;
        private String PrimaryJobName;
        private String PrimaryGroupName;
        private String PrimaryCompanyName;

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public String getUserAccount() {
            return UserAccount;
        }

        public void setUserAccount(String UserAccount) {
            this.UserAccount = UserAccount;
        }

        public String getUserPWD() {
            return UserPWD;
        }

        public void setUserPWD(String UserPWD) {
            this.UserPWD = UserPWD;
        }

        public String getUserCHName() {
            return UserCHName;
        }

        public void setUserCHName(String UserCHName) {
            this.UserCHName = UserCHName;
        }

        public String getUserENName() {
            return UserENName;
        }

        public void setUserENName(String UserENName) {
            this.UserENName = UserENName;
        }

        public String getUserSex() {
            return UserSex;
        }

        public void setUserSex(String UserSex) {
            this.UserSex = UserSex;
        }

        public String getUserTel() {
            return UserTel;
        }

        public void setUserTel(String UserTel) {
            this.UserTel = UserTel;
        }

        public String getUserEmail() {
            return UserEmail;
        }

        public void setUserEmail(String UserEmail) {
            this.UserEmail = UserEmail;
        }

        public String getUserMb() {
            return UserMb;
        }

        public void setUserMb(String UserMb) {
            this.UserMb = UserMb;
        }

        public String getUserMbIsEnabled() {
            return UserMbIsEnabled;
        }

        public void setUserMbIsEnabled(String UserMbIsEnabled) {
            this.UserMbIsEnabled = UserMbIsEnabled;
        }

        public String getUserFax() {
            return UserFax;
        }

        public void setUserFax(String UserFax) {
            this.UserFax = UserFax;
        }

        public String getUserJoinDate() {
            return UserJoinDate;
        }

        public void setUserJoinDate(String UserJoinDate) {
            this.UserJoinDate = UserJoinDate;
        }

        public String getUserLanguage() {
            return UserLanguage;
        }

        public void setUserLanguage(String UserLanguage) {
            this.UserLanguage = UserLanguage;
        }

        public String getUserIsOut() {
            return UserIsOut;
        }

        public void setUserIsOut(String UserIsOut) {
            this.UserIsOut = UserIsOut;
        }

        public String getUserLevel() {
            return UserLevel;
        }

        public void setUserLevel(String UserLevel) {
            this.UserLevel = UserLevel;
        }

        public String getUserBirthday() {
            return UserBirthday;
        }

        public void setUserBirthday(String UserBirthday) {
            this.UserBirthday = UserBirthday;
        }

        public String getUserLocation() {
            return UserLocation;
        }

        public void setUserLocation(String UserLocation) {
            this.UserLocation = UserLocation;
        }

        public String getUserEducation() {
            return UserEducation;
        }

        public void setUserEducation(String UserEducation) {
            this.UserEducation = UserEducation;
        }

        public String getUserMajor() {
            return UserMajor;
        }

        public void setUserMajor(String UserMajor) {
            this.UserMajor = UserMajor;
        }

        public String getUserActive() {
            return UserActive;
        }

        public void setUserActive(String UserActive) {
            this.UserActive = UserActive;
        }

        public String getUserIsDelete() {
            return UserIsDelete;
        }

        public void setUserIsDelete(String UserIsDelete) {
            this.UserIsDelete = UserIsDelete;
        }

        public String getUserPhoto() {
            return UserPhoto;
        }

        public void setUserPhoto(String UserPhoto) {
            this.UserPhoto = UserPhoto;
        }

        public String getUserHRID() {
            return UserHRID;
        }

        public void setUserHRID(String UserHRID) {
            this.UserHRID = UserHRID;
        }

        public String getUserAddress() {
            return UserAddress;
        }

        public void setUserAddress(String UserAddress) {
            this.UserAddress = UserAddress;
        }

        public String getUserOU() {
            return UserOU;
        }

        public void setUserOU(String UserOU) {
            this.UserOU = UserOU;
        }

        public String getUserADCreateDate() {
            return UserADCreateDate;
        }

        public void setUserADCreateDate(String UserADCreateDate) {
            this.UserADCreateDate = UserADCreateDate;
        }

        public String getUserPoliticalStatus() {
            return UserPoliticalStatus;
        }

        public void setUserPoliticalStatus(String UserPoliticalStatus) {
            this.UserPoliticalStatus = UserPoliticalStatus;
        }

        public String getUserJoinPartDate() {
            return UserJoinPartDate;
        }

        public void setUserJoinPartDate(String UserJoinPartDate) {
            this.UserJoinPartDate = UserJoinPartDate;
        }

        public String getUserZip() {
            return UserZip;
        }

        public void setUserZip(String UserZip) {
            this.UserZip = UserZip;
        }

        public String getUserDirectTel() {
            return UserDirectTel;
        }

        public void setUserDirectTel(String UserDirectTel) {
            this.UserDirectTel = UserDirectTel;
        }

        public String getUserInnerTel() {
            return UserInnerTel;
        }

        public void setUserInnerTel(String UserInnerTel) {
            this.UserInnerTel = UserInnerTel;
        }

        public String getUserIsInDomain() {
            return UserIsInDomain;
        }

        public void setUserIsInDomain(String UserIsInDomain) {
            this.UserIsInDomain = UserIsInDomain;
        }

        public String getUserIsInMobileMemu() {
            return UserIsInMobileMemu;
        }

        public void setUserIsInMobileMemu(String UserIsInMobileMemu) {
            this.UserIsInMobileMemu = UserIsInMobileMemu;
        }

        public String getUserMobileMemu() {
            return UserMobileMemu;
        }

        public void setUserMobileMemu(String UserMobileMemu) {
            this.UserMobileMemu = UserMobileMemu;
        }

        public String getUserMobileMemuNumber() {
            return UserMobileMemuNumber;
        }

        public void setUserMobileMemuNumber(String UserMobileMemuNumber) {
            this.UserMobileMemuNumber = UserMobileMemuNumber;
        }

        public String getUserMobileMemuStartTime() {
            return UserMobileMemuStartTime;
        }

        public void setUserMobileMemuStartTime(String UserMobileMemuStartTime) {
            this.UserMobileMemuStartTime = UserMobileMemuStartTime;
        }

        public String getUserMobileMemuEndTime() {
            return UserMobileMemuEndTime;
        }

        public void setUserMobileMemuEndTime(String UserMobileMemuEndTime) {
            this.UserMobileMemuEndTime = UserMobileMemuEndTime;
        }

        public String getMobileMemuStartOU() {
            return MobileMemuStartOU;
        }

        public void setMobileMemuStartOU(String MobileMemuStartOU) {
            this.MobileMemuStartOU = MobileMemuStartOU;
        }

        public String getUserCreater() {
            return UserCreater;
        }

        public void setUserCreater(String UserCreater) {
            this.UserCreater = UserCreater;
        }

        public String getUserCreateDateTime() {
            return UserCreateDateTime;
        }

        public void setUserCreateDateTime(String UserCreateDateTime) {
            this.UserCreateDateTime = UserCreateDateTime;
        }

        public String getUserUpdater() {
            return UserUpdater;
        }

        public void setUserUpdater(String UserUpdater) {
            this.UserUpdater = UserUpdater;
        }

        public String getUserUpdateDateTime() {
            return UserUpdateDateTime;
        }

        public void setUserUpdateDateTime(String UserUpdateDateTime) {
            this.UserUpdateDateTime = UserUpdateDateTime;
        }

        public String getUserIsSupportSMS() {
            return UserIsSupportSMS;
        }

        public void setUserIsSupportSMS(String UserIsSupportSMS) {
            this.UserIsSupportSMS = UserIsSupportSMS;
        }

        public String getUserSMSQuota() {
            return UserSMSQuota;
        }

        public void setUserSMSQuota(String UserSMSQuota) {
            this.UserSMSQuota = UserSMSQuota;
        }

        public String getUserIsAdmin() {
            return UserIsAdmin;
        }

        public void setUserIsAdmin(String UserIsAdmin) {
            this.UserIsAdmin = UserIsAdmin;
        }

        public String getLastLoginTime() {
            return LastLoginTime;
        }

        public void setLastLoginTime(String LastLoginTime) {
            this.LastLoginTime = LastLoginTime;
        }

        public String getUserMobileMemuMemo() {
            return UserMobileMemuMemo;
        }

        public void setUserMobileMemuMemo(String UserMobileMemuMemo) {
            this.UserMobileMemuMemo = UserMobileMemuMemo;
        }

        public String getUserCreaterName() {
            return UserCreaterName;
        }

        public void setUserCreaterName(String UserCreaterName) {
            this.UserCreaterName = UserCreaterName;
        }

        public String getUserUpdaterName() {
            return UserUpdaterName;
        }

        public void setUserUpdaterName(String UserUpdaterName) {
            this.UserUpdaterName = UserUpdaterName;
        }

        public String getUserSMSProvisQuota() {
            return UserSMSProvisQuota;
        }

        public void setUserSMSProvisQuota(String UserSMSProvisQuota) {
            this.UserSMSProvisQuota = UserSMSProvisQuota;
        }

        public String getUserIsSystemAccount() {
            return UserIsSystemAccount;
        }

        public void setUserIsSystemAccount(String UserIsSystemAccount) {
            this.UserIsSystemAccount = UserIsSystemAccount;
        }

        public String getLabourRelationCD() {
            return LabourRelationCD;
        }

        public void setLabourRelationCD(String LabourRelationCD) {
            this.LabourRelationCD = LabourRelationCD;
        }

        public String getLabourRelationName() {
            return LabourRelationName;
        }

        public void setLabourRelationName(String LabourRelationName) {
            this.LabourRelationName = LabourRelationName;
        }

        public String getIsLeader() {
            return IsLeader;
        }

        public void setIsLeader(String IsLeader) {
            this.IsLeader = IsLeader;
        }

        public String getUserOUName() {
            return UserOUName;
        }

        public void setUserOUName(String UserOUName) {
            this.UserOUName = UserOUName;
        }

        public String getPrimaryJobName() {
            return PrimaryJobName;
        }

        public void setPrimaryJobName(String PrimaryJobName) {
            this.PrimaryJobName = PrimaryJobName;
        }

        public String getPrimaryGroupName() {
            return PrimaryGroupName;
        }

        public void setPrimaryGroupName(String PrimaryGroupName) {
            this.PrimaryGroupName = PrimaryGroupName;
        }

        public String getPrimaryCompanyName() {
            return PrimaryCompanyName;
        }

        public void setPrimaryCompanyName(String PrimaryCompanyName) {
            this.PrimaryCompanyName = PrimaryCompanyName;
        }
    }
}
