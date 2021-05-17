/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp187;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/10/14 19:37
 */
public class Model1871 implements Serializable{

    @ApiModelProperty(value = "可用Long值")
    private Long value;

    @ApiModelProperty(value = "总value值")
    private BigDecimal total;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(hidden = true)
    private LocalDate startDate;

    @ApiModelProperty(hidden = true)
    private LocalDate endDate;

    @ApiModelProperty(hidden = true)
    private YearMonth startMonth;

    @ApiModelProperty(hidden = true)
    private YearMonth endMonth;
    private String testName;

    @ApiParam(hidden = true)
    @ApiModelProperty(hidden = true)
    private ModelRef187 modelRef187;

    @ApiModelProperty(hidden = true,readOnly = true)
    public ModelRef187 getModelRef187() {
        return modelRef187;
    }

    public void setModelRef187(ModelRef187 modelRef187) {
        this.modelRef187 = modelRef187;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public YearMonth getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(YearMonth startMonth) {
        this.startMonth = startMonth;
    }

    public YearMonth getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(YearMonth endMonth) {
        this.endMonth = endMonth;
    }
}
