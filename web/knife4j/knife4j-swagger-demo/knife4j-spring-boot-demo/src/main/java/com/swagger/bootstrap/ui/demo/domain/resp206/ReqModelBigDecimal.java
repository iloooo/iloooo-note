/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp206;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/24 20:37
 * @since:knife4j-spring-boot-demo 1.0
 */
public class ReqModelBigDecimal {

    @ApiModelProperty(value = "奖金名称,记住:<br /><span style=\"color:red\">我很重要</span>",example = "MVP奖杯")
    private String name;

    @ApiModelProperty(value = "主键id", example="1293385365155090452")
    private Long id;

    @ApiModelProperty(value = "标签",example = "200")
    private String label;

    @Override
    public String toString() {
        return "ReqModelBigDecimal{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", label='" + label + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
