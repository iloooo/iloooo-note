/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp203;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/04/04 17:13
 */
@JacksonXmlRootElement(localName = "MESSAGE")
public class InsureXmlReq implements Serializable {


    @JacksonXmlProperty(localName = "Head")
    @ApiModelProperty(value = "头信息")
    private InsureHead head;

    @JacksonXmlProperty(localName = "Body")
    @ApiModelProperty(value = "主信息")
    private InsureBody body;

    public InsureHead getHead() {
        return head;
    }

    public void setHead(InsureHead head) {
        this.head = head;
    }

    public InsureBody getBody() {
        return body;
    }

    public void setBody(InsureBody body) {
        this.body = body;
    }
}
