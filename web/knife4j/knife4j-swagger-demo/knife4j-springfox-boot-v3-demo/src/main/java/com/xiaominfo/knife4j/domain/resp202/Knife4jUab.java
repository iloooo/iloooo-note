/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp202;

import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/02/29 21:26
 */
public class Knife4jUab {

    @ApiModelProperty(value = "主键id",example = "12")
    private Long id;


    @ApiModelProperty(value = "姓名",example = "ABBB")
    private String name;

    @ApiModelProperty(value = "用户类型")
    private Knife4jUTypes knife4jUTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Knife4jUTypes getKnife4jUTypes() {
        return knife4jUTypes;
    }

    public void setKnife4jUTypes(Knife4jUTypes knife4jUTypes) {
        this.knife4jUTypes = knife4jUTypes;
    }
}
