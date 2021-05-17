/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp202;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/01 13:41
 */
public class Knife4jTime {

    @ApiModelProperty(value = "主键id",example = "12")
    private Long id;


    @ApiModelProperty(value = "姓名",example = "ABBB")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private List<Timestamp> createTimes;

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

    public List<Timestamp> getCreateTimes() {
        return createTimes;
    }

    public void setCreateTimes(List<Timestamp> createTimes) {
        this.createTimes = createTimes;
    }
}
