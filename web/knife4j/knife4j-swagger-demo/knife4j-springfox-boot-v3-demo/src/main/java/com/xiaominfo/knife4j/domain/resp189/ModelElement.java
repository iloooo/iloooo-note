/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp189;

import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/01/10 12:26
 */
public class ModelElement {

    @ApiModelProperty(value = "元素名称")
    private String elementName;

    @ApiModelProperty(value = "元素值")
    private String value;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ModelElement() {
    }

    public ModelElement(String elementName, String value) {
        this.elementName = elementName;
        this.value = value;
    }
}
