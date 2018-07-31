package com.amazon.base.dto;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.31 20:44
 * @describe 分页的Dto
 * */
public class Page {
    private Integer current;
    private Integer size;
    private Integer total;
    private Integer start;
    private Integer end;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return (current-1)*size+1;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return current*size;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
