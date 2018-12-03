package com.dongfang.client.zhongxin.idea.dao.entity;

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
@Table(name = "zhongxin_idea")
public class Idea implements Serializable{
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 项目id
	  */
	public String id;
	
	/**
	  * @Fields title : 项目名称
	  */
	public String title;
	
	/**
	  * @Fields content : 项目内容
	  */
	public String content;
	/**
	  * @Fields category : 1 表示帮我取快递2表示帮我办事情
	  */
	public String category;
	
	/**
	  * @Fields contact : 联系方式
	  */
	public String contact;
	
	/**
	  * @Fields pickUp : 取件凭证
	  */
	public String pickUp;
	
	
	/**
	  * @Fields creater : 创建人
	  */
	public String creater;
	
	/**
	  * @Fields createrId : 创建人Id
	  */
	public String createrId;
	
	/**
	  * @Fields status : 抢单标志位1进行中，2抢单完成，3项目完成，4项目关闭
	  */
	public int status;
	
	/**
	  * @Fields recipient : 接单人
	  */
	public String recipient;
	
	/**
	  * @Fields recipientId : 接单人Id
	  */
	public String recipientId;

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
	@Column(name = "idea_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	@Column(name ="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	@Column(name = "contact")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name ="creater")
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Column(name ="creater_id")
	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	
	
	@Column(name = "pick_up")
	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	@Column(name ="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name ="recipient")
	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@Column(name ="recipient_id")
	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
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
		return "Idea [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category + ", contact="
				+ contact + ", pickUp=" + pickUp + ", creater=" + creater + ", createrId=" + createrId + ", status="
				+ status + ", recipient=" + recipient + ", recipientId=" + recipientId + ", createDate=" + createDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	
	

	

	

	
}
