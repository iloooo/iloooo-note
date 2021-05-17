/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp190;

import io.swagger.annotations.ApiModelProperty;


/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/02/14 20:20
 */
public class PageResultLocal<T> {

    @ApiModelProperty(value = "总页数")
    private Integer pageCount;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

    @ApiModelProperty(value = "总记录数")
    private Integer recordCount;

    @ApiModelProperty(value = "列表")
    private T resultList;

    @ApiModelProperty(value = "当前页码")
    private Integer targetPage;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public T getResultList() {
        return resultList;
    }

    public void setResultList(T resultList) {
        this.resultList = resultList;
    }

    public Integer getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(Integer targetPage) {
        this.targetPage = targetPage;
    }
}
