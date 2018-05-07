package com.dongfang.client.zhongxin.person.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class PersonVO implements Serializable {
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
	  * @Fields creater : 创建人
	  */
	public String creater;
	
	/**
	  * @Fields createrId : 创建人Id
	  */
	public String createrId;
	
	/**
	  * @Fields status : 抢单标志位1进行中,2项目关闭
	  */
	public int status;
	
	

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




	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
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
		return "PersonVO [id=" + id + ", title=" + title + ", content=" + content + ", creater=" + creater
				+ ", createrId=" + createrId + ", status=" + status + ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}
}
