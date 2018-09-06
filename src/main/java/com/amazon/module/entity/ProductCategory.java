package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @describe 商品分类实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCategory {
    private String pc_id;
    private String name;
    private String pc_parent_id;

    public String getPc_id() {
        return pc_id;
    }

    public void setPc_id(String pc_id) {
        this.pc_id = pc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPc_parent_id() {
        return pc_parent_id;
    }

    public void setPc_parent_id(String pc_parent_id) {
        this.pc_parent_id = pc_parent_id;
    }


}
