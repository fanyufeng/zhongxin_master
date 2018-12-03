package com.dongfang.client.zhongxin.college.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class CollegeVO implements Serializable {
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
	public String college;
	
	
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




	




	public String getCollege() {
		return college;
	}




	public void setCollege(String college) {
		this.college = college;
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
		return "CollegeVO [id=" + id + ", college=" + college + ", status=" + status + ", createDate=" + createDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}




	



	
}
