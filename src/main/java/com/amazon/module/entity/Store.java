package com.amazon.module.entity;

/**
 * @describe 店铺实体类
 * */
public class Store {
    private String sid;//商铺id
    private String sName;//商铺名字
    private String managerId;//商铺店长用户id
    private int sLevel;//商铺等级
    private double rate;//商铺评分
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public int getsLevel() {
        return sLevel;
    }

    public void setsLevel(int sLevel) {
        this.sLevel = sLevel;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
