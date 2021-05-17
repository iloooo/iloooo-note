/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp190;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/02/24 16:19
 */
@ApiModel(description = "A信息")
public class AInfoVo {

    @ApiModelProperty(value="A记录主键", required=true)
    private String aId;

    @ApiModelProperty(value="B信息Map, key为BInfoVo的主键pkId", required=true)
    private Map<String, BInfoVo> bList;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public Map<String, BInfoVo> getbList() {
        return bList;
    }

    public void setbList(Map<String, BInfoVo> bList) {
        this.bList = bList;
    }
}
