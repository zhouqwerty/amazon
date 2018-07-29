package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @describe 订单实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private String oid;//订单id
    private String user_id;//用户id
    private String username;//用户名
    private String address;//地址
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    private double cost;//花费
    private int status;//状态
    private int type;//类型
    private User user;

    public Order() {
    }

    public Order(String oid, String user_id, String username, String address, Date createTime, double cost, int status, int type, User user) {
        this.oid = oid;
        this.user_id = user_id;
        this.username = username;
        this.address = address;
        this.createTime = createTime;
        this.cost = cost;
        this.status = status;
        this.type = type;
        this.user = user;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
