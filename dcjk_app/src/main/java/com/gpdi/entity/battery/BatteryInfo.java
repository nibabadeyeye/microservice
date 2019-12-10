package com.gpdi.entity.battery;
/**
 *
 * @desc: 电池信息管理
 *
 * @created by whs on 2019/12/05
 *
 */
public class BatteryInfo {

    //自增id
    private int id;

    //记录编号
    private String recordNumber;

    //生产日期
    private String productDate;

    //2、电池容量
    private String capacity;

    //3、电池状态：1 空载（未接负载）、2 充电、3 放电
    private int state;

    //4、电池当前电量值
    private int powerValue;

    //5、电池型号
    private String model;

    //6、电池串号
    private String imei;

    // 7、电池所属设备类型（是否NB设备）
    private String deviceType;
    //  8、电池剩余电量百分比
    private String residualPercentage;

    //9、电池坐标
    private String coordinate;

    //10、工作模式，1告警模式，2正常模式
    private String workPattern;

    // 命令编号
    private int cmd;

    //电池数量
    private int number;

    //  第1组电池电压mV
    private int voltageValue1;

    // 第2组电池电压mV
    private int voltageValue2;

    //第3组电池电压mV
    private int voltageValue3;

    //第4组电池电压mV
    private int voltageValue4;

    // 第5组电池电压m
    private int voltageValue5;

    // 第6组电池电压mV
    private int voltageValue6;

    //第7组电池电压mV
    private int voltageValue7;

    //第8组电池电压mV
    private int voltageValue8;

    //第9组电池电压mV
    private int voltageValue9;

    // 第10组电池电压mV
    private int voltageValue10;
    //第11组电池电压mV

    private int voltageValue11;

    // 第12组电池电压mV
    private int voltageValue12;

    //    第13组电池电压mV
    private int voltageValue13;


    // 终端电流值mA
    private String current;

    // 热敏电阻1温度值℃
    private int resistanceTemperature1;

    //热敏电阻2温度值℃
    private int resistanceTemperature2;


    //热敏电阻3温度值℃
    private int resistanceTemperature3;

    //服务端唯一标记
    private String serverTag;

    //唯一标记
    private String tag;

    //服务器信息(未使用)
    private String hostInfo;


    // 回应信息(未使用)
    private String response;

    //上报时间
    private String uploadTime;

    //写入时间
    private String writeTime;

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(int powerValue) {
        this.powerValue = powerValue;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getResidualPercentage() {
        return residualPercentage;
    }

    public void setResidualPercentage(String residualPercentage) {
        this.residualPercentage = residualPercentage;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getWorkPattern() {
        return workPattern;
    }

    public void setWorkPattern(String workPattern) {
        this.workPattern = workPattern;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getVoltageValue1() {
        return voltageValue1;
    }

    public void setVoltageValue1(int voltageValue1) {
        this.voltageValue1 = voltageValue1;
    }

    public int getVoltageValue2() {
        return voltageValue2;
    }

    public void setVoltageValue2(int voltageValue2) {
        this.voltageValue2 = voltageValue2;
    }

    public int getVoltageValue3() {
        return voltageValue3;
    }

    public void setVoltageValue3(int voltageValue3) {
        this.voltageValue3 = voltageValue3;
    }

    public int getVoltageValue4() {
        return voltageValue4;
    }

    public void setVoltageValue4(int voltageValue4) {
        this.voltageValue4 = voltageValue4;
    }

    public int getVoltageValue5() {
        return voltageValue5;
    }

    public void setVoltageValue5(int voltageValue5) {
        this.voltageValue5 = voltageValue5;
    }

    public int getVoltageValue6() {
        return voltageValue6;
    }

    public void setVoltageValue6(int voltageValue6) {
        this.voltageValue6 = voltageValue6;
    }

    public int getVoltageValue7() {
        return voltageValue7;
    }

    public void setVoltageValue7(int voltageValue7) {
        this.voltageValue7 = voltageValue7;
    }

    public int getVoltageValue8() {
        return voltageValue8;
    }

    public void setVoltageValue8(int voltageValue8) {
        this.voltageValue8 = voltageValue8;
    }

    public int getVoltageValue9() {
        return voltageValue9;
    }

    public void setVoltageValue9(int voltageValue9) {
        this.voltageValue9 = voltageValue9;
    }

    public int getVoltageValue10() {
        return voltageValue10;
    }

    public void setVoltageValue10(int voltageValue10) {
        this.voltageValue10 = voltageValue10;
    }

    public int getVoltageValue11() {
        return voltageValue11;
    }

    public void setVoltageValue11(int voltageValue11) {
        this.voltageValue11 = voltageValue11;
    }

    public int getVoltageValue12() {
        return voltageValue12;
    }

    public void setVoltageValue12(int voltageValue12) {
        this.voltageValue12 = voltageValue12;
    }

    public int getVoltageValue13() {
        return voltageValue13;
    }

    public void setVoltageValue13(int voltageValue13) {
        this.voltageValue13 = voltageValue13;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public int getResistanceTemperature1() {
        return resistanceTemperature1;
    }

    public void setResistanceTemperature1(int resistanceTemperature1) {
        this.resistanceTemperature1 = resistanceTemperature1;
    }

    public int getResistanceTemperature2() {
        return resistanceTemperature2;
    }

    public void setResistanceTemperature2(int resistanceTemperature2) {
        this.resistanceTemperature2 = resistanceTemperature2;
    }

    public int getResistanceTemperature3() {
        return resistanceTemperature3;
    }

    public void setResistanceTemperature3(int resistanceTemperature3) {
        this.resistanceTemperature3 = resistanceTemperature3;
    }

    public String getServerTag() {
        return serverTag;
    }

    public void setServerTag(String serverTag) {
        this.serverTag = serverTag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(String hostInfo) {
        this.hostInfo = hostInfo;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }


    public BatteryInfo(int id, String recordNumber, String productDate, String capacity, int state, int powerValue, String model, String imei, String deviceType, String residualPercentage, String coordinate, String workPattern, int cmd, int number, int voltageValue1, int voltageValue2, int voltageValue3, int voltageValue4, int voltageValue5, int voltageValue6, int voltageValue7, int voltageValue8, int voltageValue9, int voltageValue10, int voltageValue11, int voltageValue12, int voltageValue13, String current, int resistanceTemperature1, int resistanceTemperature2, int resistanceTemperature3, String serverTag, String tag, String hostInfo, String response, String uploadTime, String writeTime) {
        this.id = id;
        this.recordNumber = recordNumber;
        this.productDate = productDate;
        this.capacity = capacity;
        this.state = state;
        this.powerValue = powerValue;
        this.model = model;
        this.imei = imei;
        this.deviceType = deviceType;
        this.residualPercentage = residualPercentage;
        this.coordinate = coordinate;
        this.workPattern = workPattern;
        this.cmd = cmd;
        this.number = number;
        this.voltageValue1 = voltageValue1;
        this.voltageValue2 = voltageValue2;
        this.voltageValue3 = voltageValue3;
        this.voltageValue4 = voltageValue4;
        this.voltageValue5 = voltageValue5;
        this.voltageValue6 = voltageValue6;
        this.voltageValue7 = voltageValue7;
        this.voltageValue8 = voltageValue8;
        this.voltageValue9 = voltageValue9;
        this.voltageValue10 = voltageValue10;
        this.voltageValue11 = voltageValue11;
        this.voltageValue12 = voltageValue12;
        this.voltageValue13 = voltageValue13;
        this.current = current;
        this.resistanceTemperature1 = resistanceTemperature1;
        this.resistanceTemperature2 = resistanceTemperature2;
        this.resistanceTemperature3 = resistanceTemperature3;
        this.serverTag = serverTag;
        this.tag = tag;
        this.hostInfo = hostInfo;
        this.response = response;
        this.uploadTime = uploadTime;
        this.writeTime = writeTime;
    }

    public BatteryInfo() {
    }
}
