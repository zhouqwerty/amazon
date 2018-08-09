package com.amazon.module.dto;

import com.amazon.base.dto.Page;
import com.amazon.module.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.27 19:29
 * @describe 用于接收参数的Dto
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParamsDto {
    private String validateCode;//验证码
    private User user;
    private ProductPageParamsDto ppDto;
    private Page page;
    private String pid;
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public ProductPageParamsDto getPpDto() {
        return ppDto;
    }

    public void setPpDto(ProductPageParamsDto ppDto) {
        this.ppDto = ppDto;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
