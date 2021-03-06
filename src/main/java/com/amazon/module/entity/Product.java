package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @describe 商品实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private String pid;
    private String name;
    private String describe;
    private double price;
    private int stock;
    private int pc_id;
    private ProductCategory pCate;
    private int pc_child_id;
    private ProductCategory pcCate;
    private String fileName;
    private Store store;


    public ProductCategory getpCate() {
        return pCate;
    }

    public void setpCate(ProductCategory pCate) {
        this.pCate = pCate;
    }

    public ProductCategory getPcCate() {
        return pcCate;
    }

    public void setPcCate(ProductCategory pcCate) {
        this.pcCate = pcCate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPc_id() {
        return pc_id;
    }

    public void setPc_id(int pc_id) {
        this.pc_id = pc_id;
    }

    public int getPc_child_id() {
        return pc_child_id;
    }

    public void setPc_child_id(int pc_child_id) {
        this.pc_child_id = pc_child_id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
