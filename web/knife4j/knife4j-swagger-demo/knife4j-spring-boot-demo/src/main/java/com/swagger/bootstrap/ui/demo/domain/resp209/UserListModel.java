/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp209;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * see https://gitee.com/xiaoym/knife4j/issues/I2D6D4
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/03/13 18:21
 * @since:knife4j-spring-boot-demo 1.0
 */
public class UserListModel {
    @ApiModelProperty(value = "名称",notes = "我是备注信息")
    private String name;
    @ApiModelProperty(value = "工单等级(1:一级，2：二级，3：三级)",example = "[1,2]")
    private List<String> workOrderGradeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWorkOrderGradeList() {
        return workOrderGradeList;
    }

    public void setWorkOrderGradeList(List<String> workOrderGradeList) {
        this.workOrderGradeList = workOrderGradeList;
    }
}
