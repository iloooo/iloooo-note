/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp206;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/19 9:52
 * @since:knife4j-spring-boot-demo 1.0
 */
public class RequestAllDTO {

    @ApiModelProperty(value = "T-名称",required = true,example = "刘备")
    private String name;

    @ApiModelProperty(value = "测试1")
    private PartyDTO partyDTO;

    @ApiModelProperty(value = "测试2")
    private PartyDTO partyDTO2;

    @ApiModelProperty(value = "测试3")
    private PartyDTO partyDTO3;

    @ApiModelProperty(value = "测试4")
    private PartyDTO partyDTO4;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartyDTO getPartyDTO() {
        return partyDTO;
    }

    public void setPartyDTO(PartyDTO partyDTO) {
        this.partyDTO = partyDTO;
    }

    public PartyDTO getPartyDTO2() {
        return partyDTO2;
    }

    public void setPartyDTO2(PartyDTO partyDTO2) {
        this.partyDTO2 = partyDTO2;
    }

    public PartyDTO getPartyDTO3() {
        return partyDTO3;
    }

    public void setPartyDTO3(PartyDTO partyDTO3) {
        this.partyDTO3 = partyDTO3;
    }

    public PartyDTO getPartyDTO4() {
        return partyDTO4;
    }

    public void setPartyDTO4(PartyDTO partyDTO4) {
        this.partyDTO4 = partyDTO4;
    }
}
