package com.dongfang.client.zhongxin.mail.message.code.vo;

import java.io.Serializable;
import java.util.Date;

public class MailMessageCodeVO implements Serializable{
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 验证码id
	  */
	public String id;
	
	/**
	  * @Fields 发送验证码的邮箱 : email 
	  */
	public String email;
	
	/**
	  * @Fields 发送验证码 : code
	  */
	
	public String code;
	
	/**
	  * @Fields 是否处理 : isDealWith
	  */
	
	public Boolean isDealWith;
	/**
	  * @Fields 用户Id : userId
	  */
	
	public String userId;
	
	/**
	  * @Fields createDate : 创建时间
	  */
	public Date createDate;
	
	/**
	  * @Fields lastUpdateDate : 最后更新时间
	  */
	public Date lastUpdateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	

	public Boolean getIsDealWith() {
		return isDealWith;
	}

	public void setIsDealWith(Boolean isDealWith) {
		this.isDealWith = isDealWith;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return "MailMessageCodeVO [id=" + id + ", email=" + email + ", code=" + code + ", isDealWith=" + isDealWith
				+ ", userId=" + userId + ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	
}
