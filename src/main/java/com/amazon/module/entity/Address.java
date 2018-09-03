package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @describe 地址实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    private String aid;//地址id
    private String country;//国家
    private String province;//省
    private String city;//市
    private String detail;//具体地址
    private String userId;//用户id
    private String phone;//收货人联系方式
    private String receiver;//收货人姓名
    private String zipCode;//地址邮编
    private String status;//是否是默认地址（1默认）
    private Date createTime;//创建日期

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
