package com.gpdi.entity.expect;

/**
 * @desc: 记录经度和维度信息
 * <p>
 * 南纬S；北纬N；东经E；西经W
 */
public class Coordinates {


    //经度
    private String longitude;


    //纬度
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Coordinates() {
    }

    public Coordinates(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
