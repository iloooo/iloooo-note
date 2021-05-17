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
public class ReqModelJson {

    @ApiModelProperty(value = "奖金名称",example = "MVP奖杯")
    private String name;

    @ApiModelProperty(value = "奖金值",example = "{\"第一名\":1000,\"第二名\":2000}")
    private String value;

    @ApiModelProperty(value = "标签",example = "200")
    private String label;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
