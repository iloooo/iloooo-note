package com.xiaominfo.knife4j.domain.resp184;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 作者：宋禹
 * 时间：2018/6/26
 * 邮箱：244713812@qq.com
 *
 * 响应类
 */
@ApiModel(description="响应类")
public class  RestJson<T> extends BaseEntity {

    /**响应码*/
    @ApiModelProperty(value="响应码(200成功 500失败)",example="响应码(200成功 500失败)",required=true)
    private Integer code;
    /**消息*/
    @ApiModelProperty(value="消息",example="消息(分页查询时结构为pageInfo<展示类>)",required=true)
    private String message;
    /**响应内容*/
    @ApiModelProperty(value="分页查询时结构为pageInfo<展示类>",required=true)
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
