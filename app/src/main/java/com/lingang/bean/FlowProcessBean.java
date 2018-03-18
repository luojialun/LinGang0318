package com.lingang.bean;

import java.util.List;

/**
 * Created by jason on 17/7/6.
 * 代办任务
 */
public class FlowProcessBean {

    /**
     * message :
     * datecount : 2
     * Data : [{"TASKID":"FB963C33-7F2A-44E1-ADEF-6A86733F7EB6","TASKPriority":"正常","TASKSN":"01102170005","TASKTopic":"拟新增规划设计管理相关电子流程","CATNAME":"业务联系","TASKCreateTime":"2017/2/3 13:08:05","PROCRecvTime":"2017/7/7 10:13:08","CreatUser":"顾瑞笠","UserId":"56","Url":"http://3gtest.shlingang.com/FlowManage/FlowView.aspx?procid=9F302D93-4D81-4543-8AB1-8BB89D8C3E9E","nodeStandTime":"24","workTime":"6.7"},{"TASKID":"9CAADE5F-035A-42B3-A413-D89A23714172","TASKPriority":"正常","TASKSN":"01102170051","TASKTopic":"关于建行委派人员至集团财务金融部挂职交流的请示","CATNAME":"业务联系","TASKCreateTime":"2017/7/3 10:21:24","PROCRecvTime":"2017/7/6 15:14:44","CreatUser":"傅冷红","UserId":"106","Url":"http://3gtest.shlingang.com/FlowManage/FlowView.aspx?procid=AFD3D7D4-BC2A-40F9-AC90-661677D0D794","nodeStandTime":"24","workTime":"9.7"}]
     */

    private String message;
    private String datecount;
    private List<FlowProcess> Data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatecount() {
        return datecount;
    }

    public void setDatecount(String datecount) {
        this.datecount = datecount;
    }

    public List<FlowProcess> getData() {
        return Data;
    }

    public void setData(List<FlowProcess> Data) {
        this.Data = Data;
    }

    public static class FlowProcess {
        /**
         * TASKID : FB963C33-7F2A-44E1-ADEF-6A86733F7EB6
         * TASKPriority : 正常
         * TASKSN : 01102170005
         * TASKTopic : 拟新增规划设计管理相关电子流程
         * CATNAME : 业务联系
         * TASKCreateTime : 2017/2/3 13:08:05
         * PROCRecvTime : 2017/7/7 10:13:08
         * CreatUser : 顾瑞笠
         * UserId : 56
         * Url : http://3gtest.shlingang.com/FlowManage/FlowView.aspx?procid=9F302D93-4D81-4543-8AB1-8BB89D8C3E9E
         * nodeStandTime : 24
         * workTime : 6.7
         */

        private String TASKID;
        private String TASKPriority;
        private String TASKSN;
        private String TASKTopic;
        private String CATNAME;
        private String TASKCreateTime;
        private String PROCRecvTime;
        private String CreatUser;
        private String UserId;
        private String Url;
        private String nodeStandTime;
        private String workTime;

        private String newTest;

        public String getNewTest() {
            return newTest;
        }

        public void setNewTest(String newTest) {
            this.newTest = newTest;
        }

        public String getTASKID() {
            return TASKID;
        }

        public void setTASKID(String TASKID) {
            this.TASKID = TASKID;
        }

        public String getTASKPriority() {
            return TASKPriority;
        }

        public void setTASKPriority(String TASKPriority) {
            this.TASKPriority = TASKPriority;
        }

        public String getTASKSN() {
            return TASKSN;
        }

        public void setTASKSN(String TASKSN) {
            this.TASKSN = TASKSN;
        }

        public String getTASKTopic() {
            return TASKTopic;
        }

        public void setTASKTopic(String TASKTopic) {
            this.TASKTopic = TASKTopic;
        }

        public String getCATNAME() {
            return CATNAME;
        }

        public void setCATNAME(String CATNAME) {
            this.CATNAME = CATNAME;
        }

        public String getTASKCreateTime() {
            return TASKCreateTime;
        }

        public void setTASKCreateTime(String TASKCreateTime) {
            this.TASKCreateTime = TASKCreateTime;
        }

        public String getPROCRecvTime() {
            return PROCRecvTime;
        }

        public void setPROCRecvTime(String PROCRecvTime) {
            this.PROCRecvTime = PROCRecvTime;
        }

        public String getCreatUser() {
            return CreatUser;
        }

        public void setCreatUser(String CreatUser) {
            this.CreatUser = CreatUser;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getNodeStandTime() {
            return nodeStandTime;
        }

        public void setNodeStandTime(String nodeStandTime) {
            this.nodeStandTime = nodeStandTime;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }
    }
}
