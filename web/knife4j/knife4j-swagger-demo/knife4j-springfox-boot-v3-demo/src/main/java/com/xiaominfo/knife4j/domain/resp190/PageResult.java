/**
 * Project Name:youyuer-information-proj
 * Package Name:com.youyuer.information.utils
 * Date:2018/10/911:10
 * Copyright (c) 2018, www.youyuer.com All Rights Reserved
 */
package com.xiaominfo.knife4j.domain.resp190;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    @ApiModelProperty(
            value = "列表",
            name = "resultList",
            example = "[]"
    )
    List<T> resultList;
    @ApiModelProperty(value="每页记录数",name="pageSize")
    private int pageSize ;

    @ApiModelProperty(value="总页数",name="pageCount")
    private int pageCount;

    @ApiModelProperty(value="总记录数",name="recordCount")
    private int recordCount;

    @ApiModelProperty(value="当前页码，从1开始",name="targetPage")
    private int targetPage;

    public PageResult(List<T> resultList, int pageSize, int pageCount, int recordCount, int targetPage) {
        this.resultList = resultList;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.targetPage = targetPage;
    }

    public PageResult() {

    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(int targetPage) {
        this.targetPage = targetPage;
    }
}