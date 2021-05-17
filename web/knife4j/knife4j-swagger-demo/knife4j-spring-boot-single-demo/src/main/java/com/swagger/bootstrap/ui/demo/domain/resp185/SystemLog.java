package com.swagger.bootstrap.ui.demo.domain.resp185;


import java.util.Date;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SystemLog",description="系统操作日志")
public class SystemLog  implements java.io.Serializable {

	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	

     @ApiModelProperty(value="ID")
     private Long logId;

     @ApiModelProperty(value="操作人, 描述：可阅读的操作人信息，一般当前用户的昵称。也可以是用户真是姓名，试系统情况确定。")
     private String operator;

     @ApiModelProperty(value="日志时间")
     private Date logTime;

     @ApiModelProperty(value="操作")
     private String action;

     @ApiModelProperty(value="ip地址")
     private String ip;

     @ApiModelProperty(value="身份信息, 描述：可以是用户名，用户实体id，session id等描述用户的信息，以便核对。\n不和用户表直接外键关联。")
     private String identityInfo;

    public SystemLog() {
    }

	
    public SystemLog(Date logTime, String action, String ip) {
        this.logTime = logTime;
        this.action = action;
        this.ip = ip;
    }
    public SystemLog(String operator, Date logTime, String action, String ip, String identityInfo) {
       this.operator = operator;
       this.logTime = logTime;
       this.action = action;
       this.ip = ip;
       this.identityInfo = identityInfo;
    }
   
	/**
	*字段名称:ID
	*/
    public Long getLogId() {
        return this.logId;
    }
    
	/**
	*字段名称:ID
	*/
    public void setLogId(Long logId) {
        this.logId = logId;
    }
	/**
	*字段名称:操作人
	*字段描述:可阅读的操作人信息，一般当前用户的昵称。也可以是用户真是姓名，试系统情况确定。
	*/
    public String getOperator() {
        return this.operator;
    }
    
	/**
	*字段名称:操作人
	*字段描述:可阅读的操作人信息，一般当前用户的昵称。也可以是用户真是姓名，试系统情况确定。
	*/
    public void setOperator(String operator) {
        this.operator = operator;
    }
	/**
	*字段名称:日志时间
	*/
    public Date getLogTime() {
        return this.logTime;
    }
    
	/**
	*字段名称:日志时间
	*/
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
	/**
	*字段名称:操作
	*/
    public String getAction() {
        return this.action;
    }
    
	/**
	*字段名称:操作
	*/
    public void setAction(String action) {
        this.action = action;
    }
	/**
	*字段名称:ip地址
	*/
    public String getIp() {
        return this.ip;
    }
    
	/**
	*字段名称:ip地址
	*/
    public void setIp(String ip) {
        this.ip = ip;
    }
	/**
	*字段名称:身份信息
	*字段描述:可以是用户名，用户实体id，session id等描述用户的信息，以便核对。
不和用户表直接外键关联。
	*/
    public String getIdentityInfo() {
        return this.identityInfo;
    }
    
	/**
	*字段名称:身份信息
	*字段描述:可以是用户名，用户实体id，session id等描述用户的信息，以便核对。
不和用户表直接外键关联。
	*/
    public void setIdentityInfo(String identityInfo) {
        this.identityInfo = identityInfo;
    }




}


