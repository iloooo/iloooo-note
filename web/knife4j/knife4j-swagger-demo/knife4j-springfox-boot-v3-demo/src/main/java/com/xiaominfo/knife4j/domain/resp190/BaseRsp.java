package com.xiaominfo.knife4j.domain.resp190;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "通用返回对象", description = "微服务之间，或者内部接口通用返回对象")
public class BaseRsp<T> implements Serializable {

    private static final long serialVersionUID = 2638878667534428161L;
    @ApiModelProperty(value = "结果描述", name = "msg", example = "操作成功!")
    String msg;
    @ApiModelProperty(value = "结果码", name = "code", example = "000000")
    String code;
    @ApiModelProperty(value = "扩展数据", name = "data", example = "{}")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;


    @ApiModelProperty(value = "幂等性返回状态 0不是 1是", name = "code", example = "000000")
    int idempotent = 0;

    public BaseRsp(String code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public BaseRsp(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public BaseRsp() {
    }

    public BaseRsp(String code, String msg, int idempotent) {
        this.msg = msg;
        this.code = code;
        this.idempotent = idempotent;
    }

    public BaseRsp(String code, String msg, T data, int idempotent) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.idempotent = idempotent;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getIdempotent() {
        return idempotent;
    }

    public void setIdempotent(int idempotent) {
        this.idempotent = idempotent;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
