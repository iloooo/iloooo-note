/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp186;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/10/14 19:37
 */
public class Model186 implements Serializable{

    private Long value;

    private BigDecimal total;

    private String name;

    @ApiModelProperty(value = "这个参数很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长")
    private String zhegecanshuhenchanghenchanghenchanghenchang;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getZhegecanshuhenchanghenchanghenchanghenchang() {
        return zhegecanshuhenchanghenchanghenchanghenchang;
    }

    public void setZhegecanshuhenchanghenchanghenchanghenchang(String zhegecanshuhenchanghenchanghenchanghenchang) {
        this.zhegecanshuhenchanghenchanghenchanghenchang = zhegecanshuhenchanghenchanghenchanghenchang;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
