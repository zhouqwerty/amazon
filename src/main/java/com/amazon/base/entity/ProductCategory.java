package com.amazon.base.entity;

public class ProductCategory {
    private long pc_id;
    private String name;
    private long pc_parent_id;

    public long getPc_id() {
        return pc_id;
    }

    public void setPc_id(long pc_id) {
        this.pc_id = pc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPc_parent_id() {
        return pc_parent_id;
    }

    public void setPc_parent_id(long pc_parent_id) {
        this.pc_parent_id = pc_parent_id;
    }
}
