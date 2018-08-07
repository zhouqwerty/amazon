package com.amazon.module.entity;

/**
 * @describe 用户类型实体类
 * */
public class UserType {
    private int tid;//用户id
    private String name;//类型名称

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
