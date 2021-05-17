/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.swagger.bootstrap.ui.demo.domain.resp208;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/11/15 14:15
 * @since:knife4j-spring-boot-demo 1.0
 */
public enum ValidateType {
    SUCCESS(0,"AA"),FAIL(1,"CC");
    private int code;
    private String message;
    ValidateType(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
