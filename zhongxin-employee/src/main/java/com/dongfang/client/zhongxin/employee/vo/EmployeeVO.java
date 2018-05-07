package com.dongfang.client.zhongxin.employee.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanyufeng
 * @Description 
 * @Email fyf820@163.com 
 * @date 2017年4月25日 下午11:22:44 
 */
public class EmployeeVO implements Serializable {
	
	/**
	  * @Fields serialVersionUID : 序列号
	  */
	private static final long serialVersionUID = 1L;
	
	/**
	  * @Fields id : 项目id
	  */
	public String id;
	
	/**
	  * @Fields name : 用户名称
	  */
	public String name;
	
	/**
	  * @Fields telephone : 电话
	  */
	public String telephone;
	
	/**
	  * @Fields unionId : 微信识别标示
	  */
	public String unionId;
	
	/**
	  * @Fields openid : 用户唯一标识
	  */
	public String openid;
	
	/**
	  * @Fields gender : 性别
	  */
	public String gender;
	
	
	/**
	  * @Fields password : 密码
	  */
	public String password;
	
	public String sessionKey;
	
	/**
	  * @Fields avatarUrl : 头像地址
	  */
	public String avatarUrl;
	
	/**
	  * @Fields nickName : 用户昵称
	  */
	public String nickName;
	
	/**
	  * @Fields college : 学校
	  */
	public String college;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
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
		return "EmployeeVO [id=" + id + ", name=" + name + ", telephone=" + telephone + ", unionId=" + unionId
				+ ", openid=" + openid + ", gender=" + gender + ", password=" + password + ", sessionKey=" + sessionKey
				+ ", avatarUrl=" + avatarUrl + ", nickName=" + nickName + ", college=" + college + ", createDate="
				+ createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
}
