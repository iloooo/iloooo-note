/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp209;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/05/05 15:54
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
public class ModelInteger {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "请求id")
    private Long requestId;

    @ApiModelProperty(value = "姓名")
    private String name;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
