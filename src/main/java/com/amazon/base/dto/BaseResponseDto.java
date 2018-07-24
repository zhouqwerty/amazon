package com.amazon.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 18:58
 * @describe 实体类 响应包装类
 * */
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@ApiModel(
        description = "接口返回外层参数"
)
public class BaseResponseDto<T> {
    @ApiModelProperty("返回时间，毫秒值")
    private Long time;
    @ApiModelProperty("返回状态代码 0：操作失败，1：操作成功")
    private boolean success = true;
    @ApiModelProperty("返回业务代码")
    private int code;
    @ApiModelProperty("返回业务消息")
    private String msg;
    @ApiModelProperty("返回业务数据体")
    private T data;

    public BaseResponseDto() {
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static BaseResponseDto success() {
        return getResult(true, 0, "成功", (Object)null);
    }

    public static BaseResponseDto exception(Exception e) {
        return getResult(false, -1, "系统异常" + e.getMessage(), (Object)null);
    }

    public static BaseResponseDto fail(String errorMsg) {
        return getResult(false, -1, errorMsg, (Object)null);
    }

    public static BaseResponseDto successtData(Object data) {
        return getResult(true, 0, "成功", data);
    }

    private static BaseResponseDto getResult(boolean success, int errorCode, String errorMsg, Object data) {
        BaseResponseDto result = new BaseResponseDto();
        result.setTime(System.currentTimeMillis());
        result.setSuccess(success);
        result.setCode(errorCode);
        result.setMsg(errorMsg);
        result.setData(data);
        return result;
    }
}
