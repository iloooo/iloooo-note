/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp192;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/03/17 16:57
 */
@ApiModel("用户登录结果")
public class UserLoginVo {
    @ApiModelProperty(value = "令牌")
    private String token;

    @ApiModelProperty(value = "昵称")
    private String nickame;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickame() {
        return nickame;
    }

    public void setNickame(String nickame) {
        this.nickame = nickame;
    }
}
