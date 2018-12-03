package com.dongfang.client.zhongxin.leave.message.reply.dao.entity;

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
@Table(name = "zhongxin_leave_message_reply")
public class LeaveMessageReply implements Serializable{
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;

	public String id;
	
	/**
	  * @Fields leaveMessageId : 留言id
	  */
	public String leaveMessageId;
	
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

	@Id
	@GeneratedValue(generator = "xbntableGenerator")    
	@GenericGenerator(name = "xbntableGenerator", strategy = "uuid")
	@Column(name = "leave_message_reply_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	@Column(name="leave_message_id")
	public String getLeaveMessageId() {
		return leaveMessageId;
	}

	public void setLeaveMessageId(String leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	@Column(name="reply_content")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name="serial_number")
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name="reply_id")
	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	
	
	@Column(name="sender_id")
	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@Column(name="sender_name")
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Column(name="reply_name")
	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
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
		return "LeaveMessageReply [id=" + id + ", leaveMessageId=" + leaveMessageId + ", replyContent=" + replyContent
				+ ", serialNumber=" + serialNumber + ", replyId=" + replyId + ", replyName=" + replyName + ", senderId="
				+ senderId + ", senderName=" + senderName + ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

	

}
