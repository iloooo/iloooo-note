package com.xiaominfo.swagger.domain.resp185;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 林宇民 Andy (llade)
 *
 */


@ApiModel(description="通用返回JSON格式")
public class ResponseModel<T> {
	
	@ApiModelProperty(value="成功状态,true表示成功,false表示失败")
	private boolean success;
	@ApiModelProperty(value="状态码,200表示成功，其他看下方“响应信息”描述")
	private int code;
	@ApiModelProperty(value="消息,消息字符描述")
	private String msg;
	@ApiModelProperty(value="业务对象存放业务内容")
	private T data;
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	

}
