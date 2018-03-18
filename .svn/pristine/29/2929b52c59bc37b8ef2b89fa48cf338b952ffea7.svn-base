package com.lingang.bean;

import com.lingang.App;

/**
 * 实体基类
 */
public class BaseEntity<T,M> {
    /**
     * stateCode
     * message
     * remark
     * data
     * dataMap
     */
    String stateCode;
    String message;
    String remark;
    T data;
    M dataMap;
    @Override
    public String toString() {
        return "BaseEntity{" +
                "stateCode='" + stateCode + '\'' +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                ", data=" + data +
                ", dataMap=" + dataMap +
                '}';
    }
    public M getDataMap() {
        return dataMap;
    }

    public void setDataMap(M dataMap) {
        this.dataMap = dataMap;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStateCode() {
        return stateCode;
    }
    public boolean getStateSuccess() {
        return stateCode.equals(App.stateCode);
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
