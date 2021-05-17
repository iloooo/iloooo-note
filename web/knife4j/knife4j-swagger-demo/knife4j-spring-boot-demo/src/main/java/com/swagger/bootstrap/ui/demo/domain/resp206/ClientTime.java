/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp206;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;

import java.util.Date;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/11/01 15:48
 * @since:knife4j-spring-boot-demo 1.0
 */
public class ClientTime {

    @ApiModelProperty(value = "名称",example = "test",required = true)
    private String name;

    @ApiModelProperty(value = "开始日期",required = true,extensions = @Extension(name = "x-format",properties = @ExtensionProperty(name = "x-format", value = "yyyy-MM-dd")))
    private Date startTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
