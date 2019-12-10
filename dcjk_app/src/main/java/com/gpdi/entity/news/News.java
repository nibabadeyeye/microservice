package com.gpdi.entity.news;

/**
 * 资讯管理
 */
public class News {

    //自增主键
    private int id;
    //资讯名称
    private String title;
    //资讯内容
    private String content;
    //操作时间
    private String operationTime;
    //文章状态
    private String state;
    //操作人
    private String operator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public News() {
    }

    public News(int id, String title, String content, String operationTime, String state, String operator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.operationTime = operationTime;
        this.state = state;
        this.operator = operator;
    }
}
