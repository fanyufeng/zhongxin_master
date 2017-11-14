package com.dongfang.client.zhongxin.controller.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class ControllerVO implements Serializable {
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 项目id
	  */
	public String id;
	
	/**
	  * @Fields controlName : 用户名称
	  */
	public String controlName;
	
	/**
	  * @Fields education : 公司
	  */
	public int education;
	
	/**
	  * @Fields workingExp : 
	  */
	public int workingExp;
	
	/**
	  * @Fields crimeRecord : 
	  */
	public int crimeRecord;
	
	/**
	  * @Fields marriedRecord : 
	  */
	public int marriedRecord;
	
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

	

	

	

	public String getControlName() {
		return controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getWorkingExp() {
		return workingExp;
	}

	public void setWorkingExp(int workingExp) {
		this.workingExp = workingExp;
	}

	public int getCrimeRecord() {
		return crimeRecord;
	}

	public void setCrimeRecord(int crimeRecord) {
		this.crimeRecord = crimeRecord;
	}

	public int getMarriedRecord() {
		return marriedRecord;
	}

	public void setMarriedRecord(int marriedRecord) {
		this.marriedRecord = marriedRecord;
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
		return "ControllerVO [id=" + id + ", controlName=" + controlName + ", education=" + education + ", workingExp="
				+ workingExp + ", crimeRecord=" + crimeRecord + ", marriedRecord=" + marriedRecord + ", createDate="
				+ createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	

	
}
