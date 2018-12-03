package com.dongfang.client.zhongxin.leave.message.dao.entity;

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
@Table(name = "zhongxin_leave_message")
public class LeaveMessage implements Serializable{
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 项目id
	  */
	public String id;
	
	/**
	  * @Fields ideaId : idea名称
	  */
	public String ideaId;
	
	/**
	  * @Fields commentContent : 评论内容
	  */
	public String commentContent;
	
	
	/**
	  * @Fields commentator : 评论人
	  */
	public String commentator;
	
	/**
	  * @Fields commentatorId : 评论人Id
	  */
	public String commentatorId;
	
	
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
	@Column(name = "leave_message_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name="idea_id")
	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

	@Column(name="comment_content")
	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Column(name="commentator")
	public String getCommentator() {
		return commentator;
	}

	

	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}

	@Column(name="commentator_id")
	public String getCommentatorId() {
		return commentatorId;
	}

	public void setCommentatorId(String commentatorId) {
		this.commentatorId = commentatorId;
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
		return "LeaveMessage [id=" + id + ", ideaId=" + ideaId + ", commentContent=" + commentContent + ", commentator="
				+ commentator + ", commentatorId=" + commentatorId + ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

	
}
