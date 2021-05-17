/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp187;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
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
public class ModeValidl187 implements Serializable{

    @ApiModelProperty(value = "可用Long值")
    private Long value;

    @ApiModelProperty(value = "总value值")
    @DecimalMin(value = "0.0",inclusive = false,message = "资金必须>0")
    @DecimalMax(value = "9999999999999999999999999999",message = "资金必须小于9999999999999999999999999999")
    private BigDecimal total;

    @NotNull
    @ApiModelProperty(value = "名称",example = "dx")
    @Length(min = 0,max = 255,message = "长度必须在0-255之间")
    private String name;

    @Size(min = 5,max = 50)
    private String validateSize;

    @Pattern(regexp = ".*?测试.*")
    private String patternStr;

    @Pattern(regexp = ".*?测试.*")
    @Min(100)
    @Max(300)
    private String patternStr1;

    @Min(10)
    @Max(100)
    @Digits(integer = 110,fraction = 200)
    private Integer num;

    @Range(min = 15L,max = 50L)
    private Integer rangeNum;

    private String email;

    @ApiModelProperty(hidden = true)
    private LocalDate startDate;

    @ApiModelProperty(hidden = true)
    private LocalDate endDate;

    @ApiModelProperty(hidden = true)
    private YearMonth startMonth;

    @ApiModelProperty(hidden = true)
    private YearMonth endMonth;
    @ApiModelProperty(hidden = true)
    private String testName;



    @ApiModelProperty(hidden = true)
    private ModelRef187 modelRef187;

    public String getPatternStr1() {
        return patternStr1;
    }

    public void setPatternStr1(String patternStr1) {
        this.patternStr1 = patternStr1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRangeNum() {
        return rangeNum;
    }

    public void setRangeNum(Integer rangeNum) {
        this.rangeNum = rangeNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPatternStr() {
        return patternStr;
    }

    public void setPatternStr(String patternStr) {
        this.patternStr = patternStr;
    }

    public String getValidateSize() {
        return validateSize;
    }

    public void setValidateSize(String validateSize) {
        this.validateSize = validateSize;
    }

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
