package com.dongfang.client.zhongxin.annex.library.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class AnnexLibraryVO implements Serializable {
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCompressFilePath() {
		return compressFilePath;
	}

	public void setCompressFilePath(String compressFilePath) {
		this.compressFilePath = compressFilePath;
	}

	
	
	

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
		return "AnnexLibraryVO [id=" + id + ", userName=" + userName + ", userId=" + userId + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", compressFilePath=" + compressFilePath + ", imagePath=" + imagePath
				+ ", status=" + status + ", personId=" + personId + ", createDate=" + createDate + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

	
	
	
	
}
