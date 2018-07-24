package com.amazon.base.dto;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 18:58
 * @describe 实体类 请求包装类
 * */
public class BaseRequestDto<T> {
    private Long time;
    private T data;

    public BaseRequestDto() {
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
