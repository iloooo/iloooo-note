/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp202;

import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/08 9:55
 */
public class KDescrption {

    @ApiModelProperty(value = "响应结果码")
    private String code;

    @ApiModelProperty(value = "返回信息")
    private KInfo info=new KInfo();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public KInfo getInfo() {
        return info;
    }

    public void setInfo(KInfo info) {
        this.info = info;
    }
}
