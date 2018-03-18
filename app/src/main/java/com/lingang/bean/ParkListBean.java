package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/8 0008 16:57
 * @change
 * @chang time
 * @class describe
 */
public class ParkListBean {
    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : null
     * dataMap : {"全部":[{"parkId":70,"parkName":"临港产业区","regionType":1},{"parkId":86,"parkName":"漕河泾开发区","regionType":1},{"parkId":69,"parkName":"自贸区洋山保税区","regionType":1},{"parkId":94,"parkName":"临港新业坊","regionType":1},{"parkId":90,"parkName":"临港海外创新中心","regionType":2},{"parkId":71,"parkName":"临港松江科技城","regionType":1},{"parkId":89,"parkName":"临港浦江科技城","regionType":1},{"parkId":68,"parkName":"临港奉贤园区","regionType":1},{"parkId":85,"parkName":"漕河泾南桥园区","regionType":1},{"parkId":92,"parkName":"漕河泾康桥商务绿洲","regionType":1},{"parkId":72,"parkName":"临港科技城","regionType":1},{"parkId":74,"parkName":"枫泾新兴产业区","regionType":1},{"parkId":75,"parkName":"临港再制造园区","regionType":1},{"parkId":91,"parkName":"沪苏大丰产业联动集聚区","regionType":2},{"parkId":45,"parkName":"现代物流平台","regionType":1},{"parkId":84,"parkName":"产城平台公司","regionType":1}],"上海":[{"parkId":70,"parkName":"临港产业区","regionType":1},{"parkId":86,"parkName":"漕河泾开发区","regionType":1},{"parkId":69,"parkName":"自贸区洋山保税区","regionType":1},{"parkId":94,"parkName":"临港新业坊","regionType":1},{"parkId":71,"parkName":"临港松江科技城","regionType":1},{"parkId":89,"parkName":"临港浦江科技城","regionType":1},{"parkId":68,"parkName":"临港奉贤园区","regionType":1},{"parkId":85,"parkName":"漕河泾南桥园区","regionType":1},{"parkId":92,"parkName":"漕河泾康桥商务绿洲","regionType":1},{"parkId":72,"parkName":"临港科技城","regionType":1},{"parkId":74,"parkName":"枫泾新兴产业区","regionType":1},{"parkId":75,"parkName":"临港再制造园区","regionType":1},{"parkId":45,"parkName":"现代物流平台","regionType":1},{"parkId":84,"parkName":"产城平台公司","regionType":1}],"域外":[{"parkId":90,"parkName":"临港海外创新中心","regionType":2},{"parkId":91,"parkName":"沪苏大丰产业联动集聚区","regionType":2}]}
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private Object data;
    private DataMapBean dataMap;

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

    public static class DataMapBean {
        private List<全部Bean> 全部;
        private List<上海Bean> 上海;
        private List<域外Bean> 域外;

        public List<全部Bean> get全部() {
            return 全部;
        }

        public void set全部(List<全部Bean> 全部) {
            this.全部 = 全部;
        }

        public List<上海Bean> get上海() {
            return 上海;
        }

        public void set上海(List<上海Bean> 上海) {
            this.上海 = 上海;
        }

        public List<域外Bean> get域外() {
            return 域外;
        }

        public void set域外(List<域外Bean> 域外) {
            this.域外 = 域外;
        }

        public static class 全部Bean {
            /**
             * parkId : 70
             * parkName : 临港产业区
             * regionType : 1
             */

            private String parkId;
            private String parkName;
            private String regionType;

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

            public String getRegionType() {
                return regionType;
            }

            public void setRegionType(String regionType) {
                this.regionType = regionType;
            }
        }

        public static class 上海Bean {
            /**
             * parkId : 70
             * parkName : 临港产业区
             * regionType : 1
             */

            private String parkId;
            private String parkName;
            private String regionType;

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

            public String getRegionType() {
                return regionType;
            }

            public void setRegionType(String regionType) {
                this.regionType = regionType;
            }
        }

        public static class 域外Bean {
            /**
             * parkId : 90
             * parkName : 临港海外创新中心
             * regionType : 2
             */

            private String parkId;
            private String parkName;
            private String regionType;

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

            public String getRegionType() {
                return regionType;
            }

            public void setRegionType(String regionType) {
                this.regionType = regionType;
            }
        }
    }
}
