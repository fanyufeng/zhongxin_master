package com.dongfang.client.zhongxin.web.front.response.idea;

import java.util.Date;

public class IdeaResponse {
	/**
	  * @Fields id : 项目id
	  */
	public String id;
	
	/**
	  * @Fields title : 项目名称
	  */
	public String title;
	
	/**
	  * @Fields college : 学校名称
	  */
	public String college;
	
	/**
	  * @Fields content : 项目内容
	  */
	public String content;
	/**
	  * @Fields category : 1 表示帮我取快递2表示帮我办事情
	  */
	public String category;
	
	public int currentPage;
	
	
	/**
	  * @Fields creater : 创建人
	  */
	public String creater;
	
	/**
	  * @Fields createrId : 创建人Id
	  */
	public String createrId;
	
	public String pickUp;
	public String contact;
	
	
	/**
	  * @Fields createrTelephone : 创建人电话
	  */
	public String createrTelephone;
	
	public String createrEmail;
	
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
	
	public String recipientEmail;	
	
	/**
	  * @Fields recipientId : 接单人Id
	  */
	public String recipientTelephone;
	

	/**
	  * @Fields createDate : 创建时间
	  */
	public Date createDate;
	
	/**
	  * @Fields lastUpdateDate : 最后更新时间
	  */
	public Date lastUpdateDate;
	
	public String gender;
	public String headUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	
	
	
	public String getCreaterEmail() {
		return createrEmail;
	}
	public void setCreaterEmail(String createrEmail) {
		this.createrEmail = createrEmail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPickUp() {
		return pickUp;
	}
	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	
	
	
	public String getRecipientTelephone() {
		return recipientTelephone;
	}
	public void setRecipientTelephone(String recipientTelephone) {
		this.recipientTelephone = recipientTelephone;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getCreaterTelephone() {
		return createrTelephone;
	}
	public void setCreaterTelephone(String createrTelephone) {
		this.createrTelephone = createrTelephone;
	}
	@Override
	public String toString() {
		return "IdeaResponse [id=" + id + ", title=" + title + ", college=" + college + ", content=" + content
				+ ", category=" + category + ", currentPage=" + currentPage + ", creater=" + creater + ", createrId="
				+ createrId + ", pickUp=" + pickUp + ", contact=" + contact + ", createrTelephone=" + createrTelephone
				+ ", createrEmail=" + createrEmail + ", status=" + status + ", recipient=" + recipient
				+ ", recipientId=" + recipientId + ", recipientEmail=" + recipientEmail + ", recipientTelephone="
				+ recipientTelephone + ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + ", gender="
				+ gender + ", headUrl=" + headUrl + "]";
	}
	
	
	
	
	
	
	
	

}
