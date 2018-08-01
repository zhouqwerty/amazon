package com.amazon.module.dto;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.31 20:44
 * @describe 接收分类参数的Dto
 * */
public class PCateParamsDto {
    private String pcid;//一级id
    private String pcname;//一级name
    private String cpcid;//二级id
    private String cpcname;//二级name

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public String getCpcid() {
        return cpcid;
    }

    public void setCpcid(String cpcid) {
        this.cpcid = cpcid;
    }

    public String getCpcname() {
        return cpcname;
    }

    public void setCpcname(String cpcname) {
        this.cpcname = cpcname;
    }
}
