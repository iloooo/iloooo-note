/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp203.UploadBody;
import com.swagger.bootstrap.ui.demo.domain.resp208.RequestValidateModel;
import com.swagger.bootstrap.ui.demo.domain.resp208.ValidateBean;
import com.swagger.bootstrap.ui.demo.grn.HistoricProcessInstanceVo;
import com.swagger.bootstrap.ui.demo.grn.Ret;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/19 14:47
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
@Api(tags = "2.0.8版本-20201111")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 280)
@RestController
@RequestMapping("/api/nxew208")
public class Api208Controller {
    Logger logger= LoggerFactory.getLogger(Api208Controller.class);


    @ApiOperation(value = "表单请求")
    @PostMapping(value = "/req")
    public Rest<RequestValidateModel> req(RequestValidateModel requestValidateModel){
        return Rest.data(requestValidateModel);
    }

    @ApiOperation(value = "String类型响应")
    @GetMapping("/string")
    public String stringRequest(){
        return RandomUtil.randomNumbers(32);
    }

    @ApiOperation(value = "Boolean类型响应")
    @GetMapping("/boolean")
    public Boolean booleanRequest(){
        return Boolean.TRUE;
    }

    @ApiOperation(value = "Int类型响应")
    @GetMapping("/int")
    public Integer intRequest(){
        return RandomUtil.randomInt(999);
    }

    @ApiOperation(value = "增强配置")
    @GetMapping("/enchance")
    @ApiOperationSupport(author = "八一菜刀")
    @DynamicParameters(name = "DynacKsnTest",properties = {
            @DynamicParameter(name = "name",value = "张三"),
            @DynamicParameter(name = "age",value = "年龄")
    })
    public Rest<String> enchance(HttpServletRequest request, @RequestBody Map map){
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String text="name:"+name+",age:"+age+",random:"+RandomUtil.randomString(5);
        return Rest.data(text);
    }

    @ApiOperation(value = "form-data提交中文乱码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "标题",required = true),
            @ApiImplicitParam(name = "file",value = "文件",dataType = "__File",required = true)
    })
    @PostMapping(value = "/multipart")
    public Rest<String> multipart(@RequestParam(value = "title") String title, @RequestParam(value = "file")MultipartFile file){
        return Rest.data("title:"+title+",fileName:"+file.getOriginalFilename());
    }

    @ApiOperation(value = "url-form提交中文乱码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "标题",required = true)
    })
    @PostMapping(value = "/multipart1")
    public Rest<String> multipart1(@RequestParam(value = "title") String title){
        return Rest.data("title:"+title);
    }

    @ApiOperation(value = "jsr303验证")
    @PostMapping(value = "/jsr303")
    public Rest<ValidateBean> jsr303(@Validated ValidateBean validateBean){
        return Rest.data(validateBean);
    }

    @ApiOperation(value = "jsr303验证-body")
    @PostMapping(value = "/jsr303-body")
    public Rest<ValidateBean> jsr303body(@RequestBody @Validated ValidateBean validateBean){
        return Rest.data(validateBean);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "文件",dataType = "__File",required = true,allowMultiple = true),
            @ApiImplicitParam(name = "title",value = "标题",required = true),

    })
    @PostMapping("/testupload")
    public Rest<String> testupload(@RequestParam(value = "file")MultipartFile multipartFile,@RequestParam(value = "title")String title){
        String data="fileName:"+multipartFile.getOriginalFilename()+",title:"+title;
        return Rest.data(data);
    }

    @ApiOperation(value = "下载文件")
    @GetMapping(value = "/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadZip(HttpServletResponse response){
        try{
            File file=new File("F:\\bak\\aaa.xlsx");
            if (file.exists()){
                response.setContentType("multipart/form-data");
                //
                response.addHeader("Content-Disposition","attachement;filename=aaa.xls");
                OutputStream outputStream= response.getOutputStream();
                FileInputStream fileInputStream=new FileInputStream(file);
                int i=-1;
                byte[] b=new byte[1024*1024];
                while ((i=fileInputStream.read(b))!=-1){
                    outputStream.write(b,0,i);
                }
                IoUtil.close(fileInputStream);
                IoUtil.close(outputStream);
            }
        }catch (Exception e){

        }

    }

    @ApiOperation("流程实例明细")
    @GetMapping(value = "/getProcessInstanceById/{processInstanceId}")
    public Ret<HistoricProcessInstanceVo> getProcessInstanceById(@PathVariable @ApiParam(value = "流程实例id") String processInstanceId) {
        return null;
    }
}
