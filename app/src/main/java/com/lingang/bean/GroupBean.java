package com.lingang.bean;

import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/29 0029 11:57
 * @change
 * @chang time
 * @class describe
 */
public class GroupBean {
    /**
     * message :
     * Data : [{"GroupCD":"5FF6FDC5-4957-476C-8DFD-8FB752853CA5","GroupName":"通讯录云平台"},{"GroupCD":"603103CE-46AB-4A19-BB3C-A9B8C305923C","GroupName":"党委通讯录"},{"GroupCD":"8F3CEBE2-94F3-425B-9B8E-D663EAA1FD82","GroupName":"团委通讯录"},{"GroupCD":"DAFC4847-0515-47A4-8984-4A30FF944D02","GroupName":"工会通讯录"}]
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
         * GroupCD : 5FF6FDC5-4957-476C-8DFD-8FB752853CA5
         * GroupName : 通讯录云平台
         */

        private String GroupCD;
        private String GroupName;

        public String getGroupCD() {
            return GroupCD;
        }

        public void setGroupCD(String GroupCD) {
            this.GroupCD = GroupCD;
        }

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }
    }
}
