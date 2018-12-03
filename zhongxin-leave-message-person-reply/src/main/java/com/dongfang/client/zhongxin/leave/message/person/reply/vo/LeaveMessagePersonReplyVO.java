package com.dongfang.client.zhongxin.leave.message.person.reply.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class LeaveMessagePersonReplyVO implements Serializable {
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;

	public String id;
	
	/**
	  * @Fields leaveMessageId : 留言id
	  */
	public String leaveMessagePersonId;
	
	/**
	  * @Fields replyContent : 回复内容
	  */
	public String replyContent;
	
	/**
	  * @Fields serialNumber : 回复序号
	  */
	public int serialNumber;
	
	/**
	  * @Fields replyId : 回复人id
	  */
	public String replyId;
	
	/**
	  * @Fields replyName : 回复人名称
	  */
	public String replyName;
	
	/**
	  * @Fields senderId : 发送人id
	  */
	public String senderId;
	
	/**
	  * @Fields senderName : 发送人姓名
	  */
	public String senderName;
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

	

	

	public String getLeaveMessagePersonId() {
		return leaveMessagePersonId;
	}

	public void setLeaveMessagePersonId(String leaveMessagePersonId) {
		this.leaveMessagePersonId = leaveMessagePersonId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
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
	
	

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Override
	public String toString() {
		return "LeaveMessagePersonReplyVO [id=" + id + ", leaveMessagePersonId=" + leaveMessagePersonId
				+ ", replyContent=" + replyContent + ", serialNumber=" + serialNumber + ", replyId=" + replyId
				+ ", replyName=" + replyName + ", senderId=" + senderId + ", senderName=" + senderName + ", createDate="
				+ createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	

	

	
	
	
}
