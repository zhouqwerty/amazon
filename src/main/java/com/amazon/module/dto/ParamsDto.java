package com.amazon.module.dto;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.27 19:29
 * @describe 用于接收参数的Dto
 * */
public class ParamsDto {
    private String validateCode;//验证码

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
