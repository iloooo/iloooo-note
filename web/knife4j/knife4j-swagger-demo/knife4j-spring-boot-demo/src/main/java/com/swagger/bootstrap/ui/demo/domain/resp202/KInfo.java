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
 * 2020/03/08 9:56
 */
public class KInfo {

    @ApiModelProperty(value = "模板校验字段,如需多个字段配置多个规则来实现")
    private String checkTplField;
    @ApiModelProperty(value = "检查类型")
    private String checkType;


    @ApiModelProperty(value = "视图模板")
    private KCollectionInfo kCollectionInfo=new KCollectionInfo();

    public String getCheckTplField() {
        return checkTplField;
    }

    public void setCheckTplField(String checkTplField) {
        this.checkTplField = checkTplField;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public KCollectionInfo getkCollectionInfo() {
        return kCollectionInfo;
    }

    public void setkCollectionInfo(KCollectionInfo kCollectionInfo) {
        this.kCollectionInfo = kCollectionInfo;
    }
}
