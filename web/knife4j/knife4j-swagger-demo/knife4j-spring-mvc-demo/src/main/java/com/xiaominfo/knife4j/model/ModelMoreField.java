/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/01/10 9:52
 */
public class ModelMoreField {

    @ApiModelProperty(value = "姓名-昵称啦")
    private String aname;

    @ApiModelProperty(value = "人物id",hidden = true)
    private String id;

    @ApiModelProperty(value = "姓名",example = "张三",readOnly = true)
    private String name;

    @ApiModelProperty(value = "邮箱地址",example = "zhangsan@qq.com")
    private String email;

    @ApiModelProperty(value = "描述信息")
    private String des;

    @ApiModelProperty(value = "联系方式",example = "1388888888",accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String tel;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "居住地址")
    private String address;

    @ApiModelProperty(value = "任职单位")
    private String company;

    @ApiModelProperty(value = "工作性质")
    private String worker;

    @ApiModelProperty(value = "参加工作时间")
    private Date joinTime;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    private List<String> jobs;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
