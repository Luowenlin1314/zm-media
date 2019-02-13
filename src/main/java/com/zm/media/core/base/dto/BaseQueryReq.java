package com.zm.media.core.base.dto;

import com.google.gson.annotations.Expose;

/**
 * 基本查询条件封装
 *
 */
public class BaseQueryReq {

    @Expose
    protected String sort; //排序字段
    @Expose
    protected String search; // 查询输入字段
    @Expose
    protected Integer offset; // 当前从第几条开始
    @Expose
    protected Integer limit; // 一页显示条数

    public BaseQueryReq(){}

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
