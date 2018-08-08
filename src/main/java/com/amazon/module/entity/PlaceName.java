package com.amazon.module.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @describe 地名实体类
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceName {
    private String pnId;//地名id
    private String name;//地名
    private String type;//地名类型（国、省、市）
    private String parentId;//地名父类id

    public String getPnId() {
        return pnId;
    }

    public void setPnId(String pnId) {
        this.pnId = pnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
