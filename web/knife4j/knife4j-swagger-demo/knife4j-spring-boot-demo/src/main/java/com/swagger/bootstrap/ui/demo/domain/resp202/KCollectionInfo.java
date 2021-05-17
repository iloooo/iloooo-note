/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp202;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/08 9:57
 */
public class KCollectionInfo {

    @ApiModelProperty(value = "让对项")
    private List<KCompareCol> compareCols;

    @ApiModelProperty(value = "结束")
    private List<KEndCol> kEndCols;

    @ApiModelProperty(value = "开始")
    private List<KStartCol> kStartCols;

    public List<KCompareCol> getCompareCols() {
        return compareCols;
    }

    public void setCompareCols(List<KCompareCol> compareCols) {
        this.compareCols = compareCols;
    }

    public List<KEndCol> getkEndCols() {
        return kEndCols;
    }

    public void setkEndCols(List<KEndCol> kEndCols) {
        this.kEndCols = kEndCols;
    }

    public List<KStartCol> getkStartCols() {
        return kStartCols;
    }

    public void setkStartCols(List<KStartCol> kStartCols) {
        this.kStartCols = kStartCols;
    }
}
