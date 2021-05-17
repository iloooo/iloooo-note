/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp187;

import java.math.BigDecimal;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/11/08 19:03
 */
public class ModelRef187 {

    private String refName;

    private BigDecimal refValue;

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public BigDecimal getRefValue() {
        return refValue;
    }

    public void setRefValue(BigDecimal refValue) {
        this.refValue = refValue;
    }
}
