/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.grn;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/12/22 16:51
 * @since:knife4j-spring-boot-demo 1.0
 */
public class Ret<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编码,0:成功，非0:失败")
    private int code = 8200;

    @ApiModelProperty(value = "返回的消息")
    private String msg;

    @ApiModelProperty(value = "返回的数据主体")
    private T data;

    public Ret() {

    }

    public Ret(T data) {
        this.data = data;
    }

    public Ret(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Ret(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = 8300;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
