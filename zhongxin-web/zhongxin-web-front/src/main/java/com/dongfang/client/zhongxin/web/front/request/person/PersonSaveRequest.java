package com.dongfang.client.zhongxin.web.front.request.person;

import java.util.ArrayList;
import java.util.List;

/** 
 * 
 * @author  fyf820@163.com: 
 * @date 创建时间：2017年4月26日 上午8:31:14 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class PersonSaveRequest {
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
	  * @Fields category : 1表示失物招领，2表示跳蚤市场，3个人心情
	  */
	public String category;
	
	
	
	/**
	  * @Fields filePathElemList : 文件上传路径
	  */
	List<FilePathElem> filePathElemList=new ArrayList<FilePathElem>();
	
	
	
	

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<FilePathElem> getFilePathElemList() {
		return filePathElemList;
	}

	public void setFilePathElemList(List<FilePathElem> filePathElemList) {
		this.filePathElemList = filePathElemList;
	}

	
	

	
	
}
