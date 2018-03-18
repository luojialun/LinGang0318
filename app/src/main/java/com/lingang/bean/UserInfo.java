package com.lingang.bean;

/**
 * Created by jason on 17/6/20.
 */

public class UserInfo extends BaseEntity {
    /**
     * userId : 111
     * imgId : 1208
     * userAccount : aiyi
     * userPassword : null
     * userDepartment :
     * userPost :
     * userTel :
     * userMobile : 13651710687
     * userEmail :
     * userName : 艾艺
     * userCompany :
     * userState : 1
     * managerId : null
     * createTime : null
     * gestureState : 2
     * gesturePwd : 4ebe7c58bc215459085a6bb82be271c0
     * imgPath : /image/upload/img/20170418/201704181334229187.jpg
     */
    //扩展token
    private String token;

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
    private String userType;
    private Object userTypeVo;
    private Object parkId;
    private Object createTime;
    private String gestureState;
    private String gesturePwd;
    private String imgPath;
    private String userNickname;
    private String qrcodeSharePath;


    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Object getUserTypeVo() {
        return userTypeVo;
    }

    public void setUserTypeVo(Object userTypeVo) {
        this.userTypeVo = userTypeVo;
    }

    public Object getParkId() {
        return parkId;
    }

    public void setParkId(Object parkId) {
        this.parkId = parkId;
    }

    public String getToken() {return token;}

    public void setToken(String token) {this.token = token;}

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getQrcodeSharePath() {
        return qrcodeSharePath;
    }

    public void setQrcodeSharePath(String qrcodeSharePath) {
        this.qrcodeSharePath = qrcodeSharePath;
    }
}
