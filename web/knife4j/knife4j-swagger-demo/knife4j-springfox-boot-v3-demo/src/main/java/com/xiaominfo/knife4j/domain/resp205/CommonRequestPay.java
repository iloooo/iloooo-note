/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp205;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/13 17:01
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
public class CommonRequestPay {

    private String name;
    @ApiModelProperty(value = "支付类型",example = "WxPay")
    private CommonPay commonPay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonPay getCommonPay() {
        return commonPay;
    }

    public void setCommonPay(CommonPay commonPay) {
        this.commonPay = commonPay;
    }
}
