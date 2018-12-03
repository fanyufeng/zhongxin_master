package com.dongfang.client.zhongxin.web.front.response.leaveMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveMessageShowIdeaResponse {
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
	
	List<LeaveMessageReplyResponse> leaveMessageReplyVOList=new ArrayList<LeaveMessageReplyResponse>();
	
	/**
	  * @Fields createDate : 创建时间
	  */
	public Date createDate;
	
	public String headUrl;
	public String college;
	public String gender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
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
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public List<LeaveMessageReplyResponse> getLeaveMessageReplyVOList() {
		return leaveMessageReplyVOList;
	}
	public void setLeaveMessageReplyVOList(List<LeaveMessageReplyResponse> leaveMessageReplyVOList) {
		this.leaveMessageReplyVOList = leaveMessageReplyVOList;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
