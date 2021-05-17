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
 * 2020/10/19 9:55
 * @since:knife4j-spring-boot-demo 1.0
 */
public class RequestDTO {

    @ApiModelProperty(value = "明细")
    private ClientDTO clientDTO;
    @ApiModelProperty(value = "body")
    private RequestAllDTO requestAllDTO;

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public RequestAllDTO getRequestAllDTO() {
        return requestAllDTO;
    }

    public void setRequestAllDTO(RequestAllDTO requestAllDTO) {
        this.requestAllDTO = requestAllDTO;
    }
}
