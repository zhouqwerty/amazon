package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @describe 用户实体类
 * */
public class User {
    private String user_id;//用户id
    private String username;//用户名
    private String password;//密码
    private String sex;//性别
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;//生日
    private String id_code;//身份证号
    private String email;//电子邮件
    private String mobile;//电话
    private String address;//地址
    private int status;//状态

    public User() {
    }

    public User(String user_id, String username, String password, String sex, Date birthday, String id_code, String email, String mobile, String address, int status) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.id_code = id_code;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
