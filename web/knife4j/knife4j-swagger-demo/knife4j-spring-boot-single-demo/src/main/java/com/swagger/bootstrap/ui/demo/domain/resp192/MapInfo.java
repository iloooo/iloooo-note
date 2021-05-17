/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp192;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/03/23 15:39
 */
public class MapInfo {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "map")
    private Map<Integer,UserLoginVo> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, UserLoginVo> getMap() {
        return map;
    }

    public void setMap(Map<Integer, UserLoginVo> map) {
        this.map = map;
    }
}
