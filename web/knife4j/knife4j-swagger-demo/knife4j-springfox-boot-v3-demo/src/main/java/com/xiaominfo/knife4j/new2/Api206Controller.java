/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp196.LongUser;
import com.xiaominfo.knife4j.domain.resp205.CommonPay;
import com.xiaominfo.knife4j.domain.resp205.CommonRequestPay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/19 14:47
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
@Api(tags = "2.0.6版本-20200919")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 282)
@RestController
@RequestMapping("/api/nxew206")
public class Api206Controller {
    Logger logger= LoggerFactory.getLogger(Api206Controller.class);

    @ApiOperationSupport(order = 2,author = "八一菜刀")
    @ApiOperation(value = "body+parameter类型")
    @PostMapping("/reqbody")
    public Rest<LongUser> reqJson(@RequestBody LongUser longUser, @RequestParam(value = "code",required = false) String code, HttpServletRequest request){
        logger.info("code:{}",code);
        return Rest.data(longUser);
    }
    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "body+parameter类型-arry")
    @PostMapping("/reqbodyarry")
    public Rest< List<LongUser>> reqJsoarryn(@RequestBody List<LongUser> longUsers, @RequestParam(value = "code",required = false) String code){
        logger.info("code:{}",code);
        return Rest.data(longUsers);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "枚举请求")
    @PostMapping("/pay")
    public Rest<CommonRequestPay> pay(CommonRequestPay commonRequestPay){
        return Rest.data(commonRequestPay);
    }
}
