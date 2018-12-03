package com.dongfang.client.zhongxin.mail.message.code.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;






@Entity
@Table(name = "zhongxin_mail_message_code")
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class MailMessageCode implements Serializable{
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 验证码id
	  */
	public String id;
	
	/**
	  * @Fields 发送验证码的邮箱号: email 
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

	
	@Id
	@GeneratedValue(generator = "xbntableGenerator")    
	@GenericGenerator(name = "xbntableGenerator", strategy = "uuid")
	@Column(name = "message_code_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Column(name="is_deal_with")
	public Boolean getIsDealWith() {
		return isDealWith;
	}

	public void setIsDealWith(Boolean isDealWith) {
		this.isDealWith = isDealWith;
	}

	@Column(name ="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", length=19, updatable=false)
	@Index(name="index_createDate")
	public Date getCreateDate() {
		return createDate;
	}

	

	

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update_date", length=19)
	@Index(name="index_lastUpdateDate")
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}


	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return "MailMessageCode [id=" + id + ", email=" + email + ", code=" + code + ", isDealWith=" + isDealWith
				+ ", userId=" + userId + ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	
}

