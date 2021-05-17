/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.LongUser;
import com.swagger.bootstrap.ui.demo.domain.resp206.ClientTime;
import com.swagger.bootstrap.ui.demo.domain.resp206.ReqModelBigDecimal;
import com.swagger.bootstrap.ui.demo.domain.resp206.ReqModelJson;
import com.swagger.bootstrap.ui.demo.domain.resp206.RequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/19 14:47
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
@Api(tags = "2.0.7版本-20201027")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 281)
@RestController
@RequestMapping("/api/nxew207")
public class Api207Controller {
    Logger logger= LoggerFactory.getLogger(Api207Controller.class);

    @ApiOperation(value = "base64类型123303")
    @ApiOperationSupport(order = 1,author = "八一菜刀")
    @PostMapping("/base64")
    public Rest<String> reqJson(HttpServletRequest request){
        try {

            return Rest.data(FileUtil.readString(new File("C:\\Users\\xiaoymin\\Desktop\\image.txt"),"UTF-8"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Rest.data(RandomUtil.randomString(23));
    }


    @ApiImplicitParam(name = "name",value = "名称<br />abc<br />",required = true)
    @PostMapping("/line")
    @ApiOperation(value = "参数换行")
    public Rest<String> line(@RequestParam("name") String name){
        return Rest.data(name);
    }


    @ApiOperation(value = "全部")
    @GetMapping("/all")
    public Rest<String> all(){
        return Rest.data(RandomUtil.randomString(32));
    }
    @ApiOperation(value = "全部,条件查询")
    @GetMapping(value = "/all",params = {"name","id"})
    public Rest<String> all(@RequestParam(value = "name")String name,@RequestParam(value = "id")String id){
        return Rest.data("name:"+name+",id:"+id+","+RandomUtil.randomString(32));
    }

    @ApiOperation(value = "日期类型参数")
    @PostMapping(value = "/clientTime")
    public Rest<ClientTime> clientTimeRest(ClientTime clientTime){
        return Rest.data(clientTime);
    }
}
