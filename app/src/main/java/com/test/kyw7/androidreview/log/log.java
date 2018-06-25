package com.test.kyw7.androidreview.log;

public class log {
    int id;
    long createTime;
    String log;


    public void setId(int id) {
        this.id = id;
    }

    public log(int id, long createTime, String log) {
        this.id = id;
        this.createTime = createTime;
        this.log = log;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public log(int id, int createTime, String log) {
        this.id = id;
        this.createTime = createTime;
        this.log = log;

    }
}
