package com.gpdi.entity.item;
/**
 *
 * 电池管理（温度、电流、电压）
 *
 */
public class Item {

    //条目名称
    private String itemName;
    //条目值
    private  String value;
    //查询时间
    private  String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Item(String itemName, String value) {
        this.itemName = itemName;
        this.value = value;
    }

    public Item() {
    }

    public Item(String itemName, String value, String date) {
        this.itemName = itemName;
        this.value = value;
        this.date = date;
    }
}
