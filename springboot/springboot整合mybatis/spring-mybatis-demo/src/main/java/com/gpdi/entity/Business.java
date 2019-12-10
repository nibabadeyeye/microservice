package com.gpdi.entity;

//存储商家和客户交易的信息类
public class Business {
    private Long id;
    private String transactionDate;
    private String businessplace;
    private String businessCountyPlacess;
    private String businessServicess;
    private String businessGridName;
    private String businessNumber;
    private String businessName;
    private String businessStoreNumber;
    private String businessStoreName;
    private String businessAdress;
    private String businessStoreTel;
    private String customerProvince;
    private String customerPlaceName;
    private String businessTradTime;
    private String businessAmount;
    private String discount;
    private String paymentType;
    private String businessTypes;
    private String one;
    private String two;
    private int number;
    //关联表的字段
    private String customerTel;//客户联系方式，做关联使用
    private String servicesMan;//业务人名称
    private String servicesManNum;//业务人工号
    private String category;//分类名称
    private int countDistinctTel;//揽收预警情况中查询参与消费的号码数
    private long countBusinessNumber;//揽收预警中参与消费的次数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getBusinessplace() {
        return businessplace;
    }

    public void setBusinessplace(String businessplace) {
        this.businessplace = businessplace;
    }

    public String getBusinessCountyPlacess() {
        return businessCountyPlacess;
    }

    public void setBusinessCountyPlacess(String businessCountyPlacess) {
        this.businessCountyPlacess = businessCountyPlacess;
    }

    public String getBusinessServicess() {
        return businessServicess;
    }

    public void setBusinessServicess(String businessServicess) {
        this.businessServicess = businessServicess;
    }

    public String getBusinessGridName() {
        return businessGridName;
    }

    public void setBusinessGridName(String businessGridName) {
        this.businessGridName = businessGridName;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessStoreNumber() {
        return businessStoreNumber;
    }

    public void setBusinessStoreNumber(String businessStoreNumber) {
        this.businessStoreNumber = businessStoreNumber;
    }

    public String getBusinessStoreName() {
        return businessStoreName;
    }

    public void setBusinessStoreName(String businessStoreName) {
        this.businessStoreName = businessStoreName;
    }

    public String getBusinessAdress() {
        return businessAdress;
    }

    public void setBusinessAdress(String businessAdress) {
        this.businessAdress = businessAdress;
    }

    public String getBusinessStoreTel() {
        return businessStoreTel;
    }

    public void setBusinessStoreTel(String businessStoreTel) {
        this.businessStoreTel = businessStoreTel;
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
    }

    public String getCustomerPlaceName() {
        return customerPlaceName;
    }

    public void setCustomerPlaceName(String customerPlaceName) {
        this.customerPlaceName = customerPlaceName;
    }

    public String getBusinessTradTime() {
        return businessTradTime;
    }

    public void setBusinessTradTime(String businessTradTime) {
        this.businessTradTime = businessTradTime;
    }

    public String getBusinessAmount() {
        return businessAmount;
    }

    public void setBusinessAmount(String businessAmount) {
        this.businessAmount = businessAmount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(String businessTypes) {
        this.businessTypes = businessTypes;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }


    private int telNumber;//单个号码交易的数量


    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCustomerTel() {
        return customerTel;
    }


    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getServicesManNum() {
        return servicesManNum;
    }

    public void setServicesManNum(String servicesManNum) {
        this.servicesManNum = servicesManNum;
    }

    public String getServicesMan() {
        return servicesMan;
    }

    public void setServicesMan(String servicesMan) {
        this.servicesMan = servicesMan;
    }


    private int countDisTinctCustomerTel; //统计消费的号码数

    public int getCountDisTinctCustomerTel() {
        return countDisTinctCustomerTel;
    }

    public void setCountDisTinctCustomerTel(int countDisTinctCustomerTel) {
        this.countDisTinctCustomerTel = countDisTinctCustomerTel;
    }


    public int getCountDistinctTel() {
        return countDistinctTel;
    }

    public void setCountDistinctTel(int countDistinctTel) {
        this.countDistinctTel = countDistinctTel;
    }

    public long getCountBusinessNumber() {
        return countBusinessNumber;
    }

    public void setCountBusinessNumber(long countBusinessNumber) {
        this.countBusinessNumber = countBusinessNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
