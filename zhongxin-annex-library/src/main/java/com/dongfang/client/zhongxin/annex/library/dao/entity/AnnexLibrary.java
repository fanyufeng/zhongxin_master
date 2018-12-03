package com.dongfang.client.zhongxin.annex.library.dao.entity;

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
@Table(name = "zhongxin_annex_library")
public class AnnexLibrary implements Serializable{
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;

	public String id;
	
	/**
	  * @Fields userName : 上传人名称
	  */
	public String userName;
	
	/**
	  * @Fields userId: 上传人Id
	  */
	public String userId;
	
	/**
	  * @Fields fileName : 文件名称
	  */
	public String fileName;
	
	
	/**
	  * @Fields filePath : 压缩文件路径
	  */
	public String filePath;
	
	/**
	  * @Fields compressfilePath : 非压缩文件路径
	  */
	public String compressFilePath;
	
	/**
	  * @Fields imagePath : 如果是视频的话为其第一帧图片地址
	  */
	public String imagePath;
	
	/**
	  * @Fields status : 1表示图片，2表示视频
	  */
	public int status;
	
	/**
	  * @Fields customId : 隶属的选项
	  */
	public String personId;
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
	@Column(name = "annex_library_id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="file_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="image_path")
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="file_path")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name="compress_file_path")
	public String getCompressFilePath() {
		return compressFilePath;
	}

	public void setCompressFilePath(String compressFilePath) {
		this.compressFilePath = compressFilePath;
	}

	@Column(name="person_id")
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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
		return "AnnexLibrary [id=" + id + ", userName=" + userName + ", userId=" + userId + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", compressFilePath=" + compressFilePath + ", imagePath=" + imagePath
				+ ", status=" + status + ", personId=" + personId + ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

	

	

	

	

}
