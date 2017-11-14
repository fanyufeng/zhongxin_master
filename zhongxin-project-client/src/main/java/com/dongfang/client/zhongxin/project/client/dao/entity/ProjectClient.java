package com.dongfang.client.zhongxin.project.client.dao.entity;

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
@Table(name = "zhongxin_project_client")
public class ProjectClient implements Serializable{
	
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

	@Id
	@GeneratedValue(generator = "xbntableGenerator")    
	@GenericGenerator(name = "xbntableGenerator", strategy = "uuid")
	@Column(name = "project_client_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name="company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name="legal_person")
	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name="controller")
	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="grade")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name="contact")
	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	@Column(name="credit_line")
	public float getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(float creditLine) {
		this.creditLine = creditLine;
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
		return "ProjectClient [id=" + id + ", companyName=" + companyName + ", companyCode=" + companyCode
				+ ", legalPerson=" + legalPerson + ", controller=" + controller + ", address=" + address + ", grade="
				+ grade + ", contact=" + contact + ", creditLine=" + creditLine + ", createDate=" + createDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	

}
