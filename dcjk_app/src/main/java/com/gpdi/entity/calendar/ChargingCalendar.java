package com.gpdi.entity.calendar;

/**
 * @desc: 充电日历管理
 *
 *
 */
public class ChargingCalendar {
    //充电日期
    private String date;
    //充电次数
    private int times;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public ChargingCalendar() {
    }

    public ChargingCalendar(String date, int times) {
        this.date = date;
        this.times = times;
    }
}
