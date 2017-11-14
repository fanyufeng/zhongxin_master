package com.dongfang.client.zhongxin.project.client.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class ProjectClientVO implements Serializable {
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 项目id
	  */
	public String id;
	
	/**
	  * @Fields companyName : 公司名称
	  */
	public String companyName;
	
	/**
	  * @Fields companyCode : 公司编号
	  */
	public String companyCode;
	
	/**
	  * @Fields legalPerson : 
	  */
	public String legalPerson;
	
	/**
	  * @Fields controller : 控制人
	  */
	public String controller;
	
	/**
	  * @Fields address : 地址
	  */
	public String address;
	
	/**
	  * @Fields grade : 地址
	  */
	public String grade;
	
	/**
	  * @Fields contact : 
	  */
	public int contact;
	
	/**
	  * @Fields creditLine : 
	  */
	public float creditLine;
	
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

	
	
	

	

	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public float getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(float creditLine) {
		this.creditLine = creditLine;
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
		return "ProjectClientVO [id=" + id + ", companyName=" + companyName + ", companyCode=" + companyCode
				+ ", legalPerson=" + legalPerson + ", controller=" + controller + ", address=" + address + ", grade="
				+ grade + ", contact=" + contact + ", creditLine=" + creditLine + ", createDate=" + createDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	

	
}
