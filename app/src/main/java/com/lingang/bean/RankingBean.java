package com.lingang.bean;

/**
 * Created by jason on 17/7/25.
 */

public class RankingBean {

    private int circleImg;
    private String rankingName;
    private String level;
    private int head;
    private String name;
    private String integration;
    private String branch;

    public RankingBean(int circleImg,String rankingName, String level, int head, String name, String integration, String branch) {
        this.circleImg=circleImg;
        this.rankingName = rankingName;
        this.level = level;
        this.head = head;
        this.name = name;
        this.integration = integration;
        this.branch = branch;
    }

    public int getCircleImg() {
        return circleImg;
    }

    public void setCircleImg(int circleImg) {
        this.circleImg = circleImg;
    }

    public String getRankingName() {
        return rankingName;
    }

    public void setRankingName(String rankingName) {
        this.rankingName = rankingName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
