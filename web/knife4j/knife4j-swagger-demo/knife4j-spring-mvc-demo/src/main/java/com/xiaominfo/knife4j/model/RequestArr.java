/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/13 15:24
 * @since:knife4j-spring-boot-demo 1.0
 */
public class RequestArr {

    @ApiModelProperty(value = "货物StrArr")
    private String[] goodsString;

    private Integer storeId;

    public String[] getGoodsString() {
        return goodsString;
    }

    public void setGoodsString(String[] goodsString) {
        this.goodsString = goodsString;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
