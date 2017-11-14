package com.dongfang.client.zhongxin.controller.dao.entity;

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
@Table(name = "zhongxin_controller")
public class Controller implements Serializable{
	
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

	@Id
	@GeneratedValue(generator = "xbntableGenerator")    
	@GenericGenerator(name = "xbntableGenerator", strategy = "uuid")
	@Column(name = "controller_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	@Column(name="control_name")
	public String getControlName() {
		return controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	@Column(name="education")
	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	@Column(name="working_exp")
	public int getWorkingExp() {
		return workingExp;
	}

	public void setWorkingExp(int workingExp) {
		this.workingExp = workingExp;
	}

	@Column(name="crime_record")
	public int getCrimeRecord() {
		return crimeRecord;
	}

	public void setCrimeRecord(int crimeRecord) {
		this.crimeRecord = crimeRecord;
	}

	@Column(name="married_record")
	public int getMarriedRecord() {
		return marriedRecord;
	}

	public void setMarriedRecord(int marriedRecord) {
		this.marriedRecord = marriedRecord;
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
		return "Controller [id=" + id + ", controlName=" + controlName + ", education=" + education + ", workingExp="
				+ workingExp + ", crimeRecord=" + crimeRecord + ", marriedRecord=" + marriedRecord + ", createDate="
				+ createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

}
