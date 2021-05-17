/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp196;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/08/28 14:40
 */
@ApiModel(value = "网站端-所有推送信息展示类")
public class AllInfomationWebVo {

    @ApiModelProperty(value = "用户")
    private LongUser longUser;

    @ApiModelProperty(value = "主键编号")
    private String id;

    @ApiModelProperty(value = "事件")
    private TaskOrEventWebVo taskOrEventWebVo;

    public LongUser getLongUser() {
        return longUser;
    }

    public void setLongUser(LongUser longUser) {
        this.longUser = longUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaskOrEventWebVo getTaskOrEventWebVo() {
        return taskOrEventWebVo;
    }

    public void setTaskOrEventWebVo(TaskOrEventWebVo taskOrEventWebVo) {
        this.taskOrEventWebVo = taskOrEventWebVo;
    }
}
