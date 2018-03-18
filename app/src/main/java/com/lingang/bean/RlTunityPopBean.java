package com.lingang.bean;

import java.util.List;

/**
 * @name LG
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/8/21 0021 16:08
 * @change
 * @chang time
 * @class describe
 */
public class RlTunityPopBean {

    /**
     * data : null
     * dataMap : {"parkUserList":[{"parkId":70,"parkName":"临港产业区","parkUserId":68,"userAccount":"yjguo"},{"parkId":89,"parkName":"临港浦江科技城","parkUserId":69,"userAccount":"yjguo"}]}
     * message : 成功
     * remark :
     * stateCode : 1000
     */

    private Object data;
    private DataMapBean dataMap;
    private String message;
    private String remark;
    private String stateCode;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DataMapBean getDataMap() {
        return dataMap;
    }

    public void setDataMap(DataMapBean dataMap) {
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

    public static class DataMapBean {
        private List<ParkUserListBean> parkUserList;

        public List<ParkUserListBean> getParkUserList() {
            return parkUserList;
        }

        public void setParkUserList(List<ParkUserListBean> parkUserList) {
            this.parkUserList = parkUserList;
        }

    }
}
