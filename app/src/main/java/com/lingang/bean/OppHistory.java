package com.lingang.bean;

import java.util.List;

/**
 * Created by jason on 17/8/22.
 * 商机详情历史记录
 */
public class OppHistory {
    /**
     * content :
     * time : 1503331200000
     * title : [{"postUserName":"撤回","preUserName":"","userAccount":"fqh","userId":"104","userName":"付其浩"}]
     */
    private String content;
    private long time;
    private List<TitleEntity> title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<TitleEntity> getTitle() {
        return title;
    }

    public void setTitle(List<TitleEntity> title) {
        this.title = title;
    }

    public static class TitleEntity {
        /**
         * postUserName : 撤回
         * preUserName :
         * userAccount : fqh
         * userId : 104
         * userName : 付其浩
         */

        private String postUserName;
        private String preUserName;
        private String userAccount;
        private String userId;
        private String userName;

        public String getPostUserName() {
            return postUserName;
        }

        public void setPostUserName(String postUserName) {
            this.postUserName = postUserName;
        }

        public String getPreUserName() {
            return preUserName;
        }

        public void setPreUserName(String preUserName) {
            this.preUserName = preUserName;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(String userAccount) {
            this.userAccount = userAccount;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
