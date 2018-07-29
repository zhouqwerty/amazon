package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @describe 购物车实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cart {
    private String cid;
    private String pid;
    private int count;
    private String user_id;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
