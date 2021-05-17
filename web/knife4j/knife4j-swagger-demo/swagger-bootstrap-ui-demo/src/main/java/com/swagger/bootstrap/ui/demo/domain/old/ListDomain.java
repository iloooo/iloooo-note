/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.old;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/10 21:14
 */
@ApiModel(value = "ListDomain" ,description = "列表属性中带集合")
public class ListDomain {

    @ApiModelProperty(value = "name",example = "'abd-name'")
    private String name;

    //@ApiModelProperty(value = "params",example = "['abc','456']")
    @ApiModelProperty(value = "params")
    private List<String> params;

//    @ApiModelProperty(value = "params1",example = "[\"abc\",\"456\"]")
    @ApiModelProperty(value = "params1")
    private List<String> params1;


    public List<String> getParams1() {
        return params1;
    }

    public void setParams1(List<String> params1) {
        this.params1 = params1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
