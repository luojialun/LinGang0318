package com.lingang.bean;

/**
 * @name LG
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/7/28 0028 16:18
 * @change
 * @chang time
 * @class describe
 */
public class UserInfoBenBean {
    /**
     * stateCode : 1000
     * message : 登录成功
     * remark : null
     * data : {"userId":107,"imgId":1205,"userAccount":"lixia","userPassword":null,"userDepartment":"信息管理部","userPost":"信息应用推进","userTel":"38295277","userMobile":"13817894677","userEmail":"lixia@shlingang.com","userName":"李霞","userCompany":"集团本部","userState":1,"managerId":null,"createTime":null,"gestureState":2,"gesturePwd":"c86038fe04bc7097e218b4fd6b767f4b","userType":2,"parkId":86,"userNickname":"雪","ipphone":"5277","imgPath":"/image/upload/img/20170417/201704171734063123.jpg","userTypeVo":"招商人员（领导）","haveSetGesturePwd":null,"userManagerId":null,"qrcodeSharePath":"/image/upload/version/qrcode-share.png"}
     * dataMap : {"homeLink":{"homeId":44,"userId":107,"imgId":null,"homeOrder":null,"homeName":"3,2,1,4,8,5,6,9,7"}}
     */

    private String stateCode;
    private String message;
    private Object remark;
    private DataBean data;
    private DataMapBean dataMap;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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

    public static class DataBean {
        /**
         * userId : 107
         * imgId : 1205
         * userAccount : lixia
         * userPassword : null
         * userDepartment : 信息管理部
         * userPost : 信息应用推进
         * userTel : 38295277
         * userMobile : 13817894677
         * userEmail : lixia@shlingang.com
         * userName : 李霞
         * userCompany : 集团本部
         * userState : 1
         * managerId : null
         * createTime : null
         * gestureState : 2
         * gesturePwd : c86038fe04bc7097e218b4fd6b767f4b
         * userType : 2
         * parkId : 86
         * userNickname : 雪
         * ipphone : 5277
         * imgPath : /image/upload/img/20170417/201704171734063123.jpg
         * userTypeVo : 招商人员（领导）
         * haveSetGesturePwd : null
         * userManagerId : null
         * qrcodeSharePath : /image/upload/version/qrcode-share.png
         */

        private String userId;
        private String imgId;
        private String userAccount;
        private Object userPassword;
        private String userDepartment;
        private String userPost;
        private String userTel;
        private String userMobile;
        private String userEmail;
        private String userName;
        private String userCompany;
        private String userState;
        private Object managerId;
        private Object createTime;
        private String gestureState;
        private String gesturePwd;
        private String userType;
        private String parkId;
        private String userNickname;
        private String ipphone;
        private String imgPath;
        private String userTypeVo;
        private Object haveSetGesturePwd;
        private Object userManagerId;
        private String qrcodeSharePath;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getImgId() {
            return imgId;
        }

        public void setImgId(String imgId) {
            this.imgId = imgId;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(String userAccount) {
            this.userAccount = userAccount;
        }

        public Object getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(Object userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserDepartment() {
            return userDepartment;
        }

        public void setUserDepartment(String userDepartment) {
            this.userDepartment = userDepartment;
        }

        public String getUserPost() {
            return userPost;
        }

        public void setUserPost(String userPost) {
            this.userPost = userPost;
        }

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public String getUserMobile() {
            return userMobile;
        }

        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserCompany() {
            return userCompany;
        }

        public void setUserCompany(String userCompany) {
            this.userCompany = userCompany;
        }

        public String getUserState() {
            return userState;
        }

        public void setUserState(String userState) {
            this.userState = userState;
        }

        public Object getManagerId() {
            return managerId;
        }

        public void setManagerId(Object managerId) {
            this.managerId = managerId;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getGestureState() {
            return gestureState;
        }

        public void setGestureState(String gestureState) {
            this.gestureState = gestureState;
        }

        public String getGesturePwd() {
            return gesturePwd;
        }

        public void setGesturePwd(String gesturePwd) {
            this.gesturePwd = gesturePwd;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getParkId() {
            return parkId;
        }

        public void setParkId(String parkId) {
            this.parkId = parkId;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public String getIpphone() {
            return ipphone;
        }

        public void setIpphone(String ipphone) {
            this.ipphone = ipphone;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public String getUserTypeVo() {
            return userTypeVo;
        }

        public void setUserTypeVo(String userTypeVo) {
            this.userTypeVo = userTypeVo;
        }

        public Object getHaveSetGesturePwd() {
            return haveSetGesturePwd;
        }

        public void setHaveSetGesturePwd(Object haveSetGesturePwd) {
            this.haveSetGesturePwd = haveSetGesturePwd;
        }

        public Object getUserManagerId() {
            return userManagerId;
        }

        public void setUserManagerId(Object userManagerId) {
            this.userManagerId = userManagerId;
        }

        public String getQrcodeSharePath() {
            return qrcodeSharePath;
        }

        public void setQrcodeSharePath(String qrcodeSharePath) {
            this.qrcodeSharePath = qrcodeSharePath;
        }
    }

    public static class DataMapBean {
        /**
         * homeLink : {"homeId":44,"userId":107,"imgId":null,"homeOrder":null,"homeName":"3,2,1,4,8,5,6,9,7"}
         */

        private HomeLinkBean homeLink;

        public HomeLinkBean getHomeLink() {
            return homeLink;
        }

        public void setHomeLink(HomeLinkBean homeLink) {
            this.homeLink = homeLink;
        }

        public static class HomeLinkBean {
            /**
             * homeId : 44
             * userId : 107
             * imgId : null
             * homeOrder : null
             * homeName : 3,2,1,4,8,5,6,9,7
             */

            private String homeId;
            private String userId;
            private Object imgId;
            private Object homeOrder;
            private String homeName;

            public String getHomeId() {
                return homeId;
            }

            public void setHomeId(String homeId) {
                this.homeId = homeId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public Object getImgId() {
                return imgId;
            }

            public void setImgId(Object imgId) {
                this.imgId = imgId;
            }

            public Object getHomeOrder() {
                return homeOrder;
            }

            public void setHomeOrder(Object homeOrder) {
                this.homeOrder = homeOrder;
            }

            public String getHomeName() {
                return homeName;
            }

            public void setHomeName(String homeName) {
                this.homeName = homeName;
            }
        }
    }
}
