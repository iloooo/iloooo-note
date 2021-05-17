/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.x200;

import cn.hutool.core.date.DateTime;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp189.ModelMoreField;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/12/16 19:42
 */
@Api(tags = "2.0.1版本-20191216",position = 287)
@RestController
@RequestMapping("/api/nxew201")
public class Api201Controller {



    @ApiOperation(value = "json渲染性能问题")
    @PostMapping("/transformJson")
    public Rest<List<ModelMoreField>> findAll(@RequestParam(value = "size",defaultValue = "10") Integer size) {
        Rest<List<ModelMoreField>> r=new Rest<>();
        List<ModelMoreField> modelMoreFields=new ArrayList<>();
        for (int i=0;i<size;i++){
            ModelMoreField m=new ModelMoreField();
            m.setAddress("浙江省杭州市文一西路22号杭州大厦18幢393-"+i);
            m.setAge(i);
            m.setCompany("代码无敌-"+i);
            m.setDes("Java无敌-"+i);
            m.setEmail("jwd@test.com");
            m.setId("2333");
            m.setJoinTime(DateTime.now().toJdkDate());
            m.setNickName("萧峰-"+i);
            m.setTel("1888888888");
            m.setWorker("架构师"+i);
            modelMoreFields.add(m);
        }
        r.setData(modelMoreFields);
        return r;
    }


}
