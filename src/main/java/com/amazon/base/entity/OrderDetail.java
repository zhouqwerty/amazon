package com.amazon.base.entity;

public class OrderDetail {
    private long od_id;
    private long oid;
    private long pid;
    private int count;
    private double cost;

    public long getOd_id() {
        return od_id;
    }

    public void setOd_id(long od_id) {
        this.od_id = od_id;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
