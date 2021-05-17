/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp208;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/11/15 14:05
 * @since:knife4j-spring-boot-demo 1.0
 */
public class RequestValidateModel {
    @ApiModelProperty(value = "订单id",example = "1231313131331313",required = true)
    private String orderId;
    @ApiModelProperty(value = "密码",example = "123456",required = true)
    private String password;
    @ApiModelProperty(value = "类型",example = "0")
    private ValidateType type;

    @ApiModelProperty(value = "用户id",example = "12ko1i3oi31oi31o",required = true)
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ValidateType getType() {
        return type;
    }

    public void setType(ValidateType type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
