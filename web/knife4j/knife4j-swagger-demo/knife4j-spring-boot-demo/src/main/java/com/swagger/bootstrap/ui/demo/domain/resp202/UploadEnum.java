/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp202;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/09 22:38
 */
public class UploadEnum {

    @ApiModelProperty(value = "用户类型")
    private Knife4jType knife4jType;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(dataType = "",value = "上传文件")
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Knife4jType getKnife4jType() {
        return knife4jType;
    }

    public void setKnife4jType(Knife4jType knife4jType) {
        this.knife4jType = knife4jType;
    }
}
