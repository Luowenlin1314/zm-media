package com.zm.media.core.base.dto;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class BaseQueryResp<T> {

    @Expose
    private Integer total; // 总条数
    @Expose
    private List<T> rows = new ArrayList<>(); // 当前页记录列表

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
