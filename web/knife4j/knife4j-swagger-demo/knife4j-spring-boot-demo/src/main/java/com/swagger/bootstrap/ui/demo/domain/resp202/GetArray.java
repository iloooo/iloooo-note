/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp202;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/01 15:47
 */
public class GetArray {

    @ApiModelProperty(value = "用户")
    private Knife4jUser[] knife4jUsers;

    @ApiModelProperty(value = "姓名")
    private String name;

    public Knife4jUser[] getKnife4jUsers() {
        return knife4jUsers;
    }

    public void setKnife4jUsers(Knife4jUser[] knife4jUsers) {
        this.knife4jUsers = knife4jUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
