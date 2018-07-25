package com.amazon.module.entity;

/**
 * @describe 商品分类实体类
 * */
public class ProductCategory {
    private int pc_id;
    private String name;
    private int pc_parent_id;

    public int getPc_id() {
        return pc_id;
    }

    public void setPc_id(int pc_id) {
        this.pc_id = pc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPc_parent_id() {
        return pc_parent_id;
    }

    public void setPc_parent_id(int pc_parent_id) {
        this.pc_parent_id = pc_parent_id;
    }
}
