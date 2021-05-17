/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp203;

import com.swagger.bootstrap.ui.demo.domain.resp189.ModelNumberInvalid;
import com.swagger.bootstrap.ui.demo.domain.resp190.AccountDetail;
import com.swagger.bootstrap.ui.demo.domain.resp196.AllInfomationWebVo;
import com.swagger.bootstrap.ui.demo.domain.resp196.AllInfomationWebVo1;
import com.swagger.bootstrap.ui.demo.domain.resp196.TaskOrEventWebVo;
import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/05/10 14:24
 */
public class TechModel {

    @ApiModelProperty(name = "姓名",example = "张飞")
    private String name;

    @ApiModelProperty(name = "年龄",example = "4401140001002000000000000005342")
    private String age;

    @ApiModelProperty(name = "对象1")
    private AllInfomationWebVo allInfomationWebVo=new AllInfomationWebVo();
    @ApiModelProperty(name = "对象2")
    private AllInfomationWebVo1 allInfomationWebVo1=new AllInfomationWebVo1();
    @ApiModelProperty(name = "对象3")
    private TaskOrEventWebVo taskOrEventWebVo=new TaskOrEventWebVo();
    @ApiModelProperty(name = "对象4")
    private AccountDetail accountDetail=new AccountDetail();
    @ApiModelProperty(name = "对象5")
    private ModelNumberInvalid modelNumberInvalid=new ModelNumberInvalid();

    public AllInfomationWebVo getAllInfomationWebVo() {
        return allInfomationWebVo;
    }

    public void setAllInfomationWebVo(AllInfomationWebVo allInfomationWebVo) {
        this.allInfomationWebVo = allInfomationWebVo;
    }

    public AllInfomationWebVo1 getAllInfomationWebVo1() {
        return allInfomationWebVo1;
    }

    public void setAllInfomationWebVo1(AllInfomationWebVo1 allInfomationWebVo1) {
        this.allInfomationWebVo1 = allInfomationWebVo1;
    }

    public TaskOrEventWebVo getTaskOrEventWebVo() {
        return taskOrEventWebVo;
    }

    public void setTaskOrEventWebVo(TaskOrEventWebVo taskOrEventWebVo) {
        this.taskOrEventWebVo = taskOrEventWebVo;
    }

    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }

    public ModelNumberInvalid getModelNumberInvalid() {
        return modelNumberInvalid;
    }

    public void setModelNumberInvalid(ModelNumberInvalid modelNumberInvalid) {
        this.modelNumberInvalid = modelNumberInvalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
