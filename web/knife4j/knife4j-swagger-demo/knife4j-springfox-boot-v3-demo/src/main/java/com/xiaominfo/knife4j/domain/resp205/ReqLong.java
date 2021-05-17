/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp205;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/14 18:58
 * @since:knife4j-spring-boot-demo 1.0
 */
public class ReqLong {

    @ApiModelProperty(value = "主键id",example = "1293385365155090452")
    private Long value;
    @ApiModelProperty(value = "名称",example = "测试")
    private String name;

    @Override
    public String toString() {
        return "ReqLong{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
