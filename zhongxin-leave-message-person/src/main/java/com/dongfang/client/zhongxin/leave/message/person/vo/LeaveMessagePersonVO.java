package com.dongfang.client.zhongxin.leave.message.person.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class LeaveMessagePersonVO implements Serializable {
	
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
	public String personId;
	
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
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentator() {
		return commentator;
	}

	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}

	public String getCommentatorId() {
		return commentatorId;
	}

	public void setCommentatorId(String commentatorId) {
		this.commentatorId = commentatorId;
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
		return "LeaveMessagePersonVO [id=" + id + ", personId=" + personId + ", commentContent=" + commentContent
				+ ", commentator=" + commentator + ", commentatorId=" + commentatorId + ", createDate=" + createDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	
}
