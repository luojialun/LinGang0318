package com.lingang.bean;

import java.io.Serializable;

/**
 * Created by luojialun on 2017/9/4.
 */

public class ParkBean implements Serializable {
    private static final long serialVersionUID = 2751504075917857724L;
    public String parkName;
    public String parkId;

    public ParkBean(String parkName, String parkId) {
        this.parkName = parkName;
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public String getParkId() {
        return parkId;
    }
}
