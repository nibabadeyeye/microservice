package com.example.AddDemo.domain;

import java.io.Serializable;


public class BusinessExceptionPara  implements Serializable {
    private int id;//数据库id
    private String servicesMan;//揽收人
    private String businessStoreTel;//电话号码
    private String transactionDate;//交易时间
    private int sumBusinessAmount;//总的交易金额
    private int sumDiscount;//总的优惠金额
    private int countMoreTenNumber;//周五超过10的次数
    private int businessTimes;
    private int fridayTimes;
    private int fridayScore;
    private int numberScore;
    private int allScore;//危险得分
    private int bill; //套餐金额、
    private String status;//是否为电信活跃账户
    private int key;//优惠金额-套餐金额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicesMan() {
        return servicesMan;
    }

    public void setServicesMan(String servicesMan) {
        this.servicesMan = servicesMan;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getBusinessTimes() {
        return businessTimes;
    }

    public void setBusinessTimes(int businessTimes) {
        this.businessTimes = businessTimes;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFridayTimes() {
        return fridayTimes;
    }

    public void setFridayTimes(int fridayTimes) {
        this.fridayTimes = fridayTimes;
    }

    public int getFridayScore() {
        return fridayScore;
    }

    public void setFridayScore(int fridayScore) {
        this.fridayScore = fridayScore;
    }

    public int getNumberScore() {
        return numberScore;
    }

    public void setNumberScore(int numberScore) {
        this.numberScore = numberScore;
    }

    public int getAllScore() {
        return allScore;
    }

    public void setAllScore(int allScore) {
        this.allScore = allScore;
    }

    public String getBusinessStoreTel() {
        return businessStoreTel;
    }

    public void setBusinessStoreTel(String businessStoreTel) {
        this.businessStoreTel = businessStoreTel;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getSumBusinessAmount() {
        return sumBusinessAmount;
    }

   // public void setSumBusinessAmount(double sumBusinessAmount) {
//        this.sumBusinessAmount = sumBusinessAmount;
//    }

    public double getSumDiscount() {
        return sumDiscount;
    }

//    public void setSumDiscount(double sumDiscount) {
//        this.sumDiscount = sumDiscount;
//    }

    public int getCountMoreTenNumber() {
        return countMoreTenNumber;
    }

    public void setCountMoreTenNumber(int countMoreTenNumber) {
        this.countMoreTenNumber = countMoreTenNumber;
    }

    public int getAllbusinessCount() {
        return allbusinessCount;
    }

    public void setAllbusinessCount(int allbusinessCount) {
        this.allbusinessCount = allbusinessCount;
    }

    private int allbusinessCount;//每月总的消费次数

    public void setSumBusinessAmount(int sumBusinessAmount) {
        this.sumBusinessAmount = sumBusinessAmount;
    }

    public void setSumDiscount(int sumDiscount) {
        this.sumDiscount = sumDiscount;
    }

}
