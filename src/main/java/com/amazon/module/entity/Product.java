package com.amazon.module.entity;

public class Product {
    private long pid;
    private String name;
    private String desc;
    private double price;
    private int stock;
    private long pc_id;
    private long pc_child_id;
    private String fileName;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public long getPc_id() {
        return pc_id;
    }

    public void setPc_id(long pc_id) {
        this.pc_id = pc_id;
    }

    public long getPc_child_id() {
        return pc_child_id;
    }

    public void setPc_child_id(long pc_child_id) {
        this.pc_child_id = pc_child_id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
