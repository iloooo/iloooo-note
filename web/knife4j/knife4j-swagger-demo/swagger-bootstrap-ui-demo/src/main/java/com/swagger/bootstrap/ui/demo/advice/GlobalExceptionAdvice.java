/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.advice;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.exception.UserNotLoginException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/***
 *
 * @since:datacenter-parent 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/14 19:22
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionAdvice{

    @ExceptionHandler({Exception.class, UserNotLoginException.class})
    @ResponseStatus(value = HttpStatus.OK)
    public void globalException(Exception e, HttpServletResponse response){
        Rest restfulMessage=new Rest();
        //参数校验未通过异常 @RequestBody参数校验失败
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            StringBuffer sb = new StringBuffer();
            List<String> errorArr= Lists.newArrayList();
            for (ObjectError error : errors) {
                if (error instanceof FieldError){
                    FieldError fieldError=(FieldError)error;
                    errorArr.add(fieldError.getField()+fieldError.getDefaultMessage());
                }else{
                    errorArr.add(error.getObjectName()+error.getDefaultMessage());
                }
            }
            String errMsg=StrUtil.join(";",errorArr.toArray(new String[]{}));
            restfulMessage.setErrCode(10400);
            restfulMessage.setMessage(errMsg);
        } else if (e instanceof ConstraintViolationException) {
            //@RequestParam 参数校验失败
            ConstraintViolationException exception = (ConstraintViolationException) e;
            StringBuffer sb = new StringBuffer();
            List<String> errorArr = Lists.newArrayList();
            for (ConstraintViolation constraint : exception.getConstraintViolations()) {
                errorArr.add(constraint.getInvalidValue() + "非法" + constraint.getMessage());
                //sb.append(constraint.getInvalidValue()).append("值不正确,").append(constraint.getMessage()).append(";");
            }
            restfulMessage.setErrCode(10400);
            restfulMessage.setMessage(StrUtil.join(";", errorArr.toArray(new String[]{})));
        }else{
            restfulMessage.setErrCode(10500);
            restfulMessage.setMessage(e.getMessage());
        }
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter= null;
        try {
            printWriter = response.getWriter();
            printWriter.write(JSON.toJSONString(restfulMessage));
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            printWriter.close();
        }


    }
}
