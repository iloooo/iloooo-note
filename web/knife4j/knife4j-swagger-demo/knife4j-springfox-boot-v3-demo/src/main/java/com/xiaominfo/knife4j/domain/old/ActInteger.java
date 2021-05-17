/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.old;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/04 21:41
 */
public class ActInteger {
    private String name;
    @ApiModelProperty(value = "Long类型")
    private Long number;
    @ApiModelProperty(value = "BigDecimal类型属性")
    private BigDecimal price;
    @ApiModelProperty(value = "float类型属性")
    private float float1;
    @ApiModelProperty(value = "double类型属性")
    private double doub1;
    @ApiModelProperty(value = "int类型")
    private int sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getFloat1() {
        return float1;
    }

    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    public double getDoub1() {
        return doub1;
    }

    public void setDoub1(double doub1) {
        this.doub1 = doub1;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
