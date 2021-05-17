/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp196;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/02/28 20:37
 */
public class IgnoreP1 {
    @ApiModelProperty(value = "姓名a啊",example = "你好")
    private String name;

    @ApiModelProperty(value = "用户列表")
    private LongUser longUser;

    @ApiModelProperty(value = "标签集合")
    private List<IgnoreLabel> ignoreLabels;

    public List<IgnoreLabel> getIgnoreLabels() {
        return ignoreLabels;
    }

    public void setIgnoreLabels(List<IgnoreLabel> ignoreLabels) {
        this.ignoreLabels = ignoreLabels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LongUser getLongUser() {
        return longUser;
    }

    public void setLongUser(LongUser longUser) {
        this.longUser = longUser;
    }
}
