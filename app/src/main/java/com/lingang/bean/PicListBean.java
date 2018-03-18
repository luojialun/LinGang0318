package com.lingang.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/21 0021 13:28
 * @change
 * @chang time
 * @class describe
 */
public class PicListBean {

    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : [{"picId":396,"picPath":"/image/upload/pic/20170406/201704062314528560.jpg","picRemark":"","picState":1,"picOrder":1,"createTime":1491491692290,"updateTime":null,"picBasicsId":89},{"picId":398,"picPath":"/image/upload/pic/20170406/201704062314582308.jpg","picRemark":"","picState":1,"picOrder":1,"createTime":1491491698707,"updateTime":null,"picBasicsId":89},{"picId":400,"picPath":"/image/upload/pic/20170406/201704062315057623.jpg","picRemark":"","picState":1,"picOrder":1,"createTime":1491491705247,"updateTime":null,"picBasicsId":89},{"picId":401,"picPath":"/image/upload/pic/20170406/201704062315106321.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491710107,"updateTime":null,"picBasicsId":89},{"picId":404,"picPath":"/image/upload/pic/20170406/201704062315211646.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491721340,"updateTime":null,"picBasicsId":89},{"picId":407,"picPath":"/image/upload/pic/20170406/201704062315398716.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491739983,"updateTime":null,"picBasicsId":89},{"picId":408,"picPath":"/image/upload/pic/20170406/201704062315478266.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491747147,"updateTime":null,"picBasicsId":89},{"picId":409,"picPath":"/image/upload/pic/20170406/201704062316022299.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491762340,"updateTime":null,"picBasicsId":89},{"picId":411,"picPath":"/image/upload/pic/20170406/201704062316106773.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491770560,"updateTime":null,"picBasicsId":89},{"picId":414,"picPath":"/image/upload/pic/20170406/201704062316241343.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491784747,"updateTime":null,"picBasicsId":89},{"picId":416,"picPath":"/image/upload/pic/20170406/201704062316332904.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491793897,"updateTime":null,"picBasicsId":89},{"picId":418,"picPath":"/image/upload/pic/20170406/201704062316398530.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491799940,"updateTime":null,"picBasicsId":89},{"picId":421,"picPath":"/image/upload/pic/20170406/201704062316487870.png","picRemark":"","picState":1,"picOrder":1,"createTime":1491491808733,"updateTime":null,"picBasicsId":89}]
     * dataMap : null
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private Object dataMap;
    private List<DataBean> data;

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

    public Object getDataMap() {
        return dataMap;
    }

    public void setDataMap(Object dataMap) {
        this.dataMap = dataMap;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * picId : 396
         * picPath : /image/upload/pic/20170406/201704062314528560.jpg
         * picRemark :
         * picState : 1
         * picOrder : 1
         * createTime : 1491491692290
         * updateTime : null
         * picBasicsId : 89
         */

        private String picId;
        private String picPath;
        private String picRemark;
        private String picState;
        private String picOrder;
        private String createTime;
        private Object updateTime;
        private String picBasicsId;

        public String getPicId() {
            return picId;
        }

        public void setPicId(String picId) {
            this.picId = picId;
        }

        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getPicRemark() {
            return picRemark;
        }

        public void setPicRemark(String picRemark) {
            this.picRemark = picRemark;
        }

        public String getPicState() {
            return picState;
        }

        public void setPicState(String picState) {
            this.picState = picState;
        }

        public String getPicOrder() {
            return picOrder;
        }

        public void setPicOrder(String picOrder) {
            this.picOrder = picOrder;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getPicBasicsId() {
            return picBasicsId;
        }

        public void setPicBasicsId(String picBasicsId) {
            this.picBasicsId = picBasicsId;
        }
    }
}
