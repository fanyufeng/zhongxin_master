package com.dongfang.client.zhongxin.message.code.dao;

import java.util.List;

import com.dongfang.client.zhongxin.message.code.dao.entity.MessageCode;

/**
  * @ClassName: MessageCodeDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface MessageCodeDAO {
	/**
	  * @Fields ignoreProperties : 不可编辑属性
	  */
	public static final String[] ignoreProperties = new String[]{"createDate"};
	
	
	
	/**
	  * 根据id获取员工信息
	  * @param id
	  * @return
	  * @throws Exception 
	  */
	public MessageCode getById(String id) throws Exception;
	
	/**
	  * 根据idNumber和密码获取员工信息
	  * @param idNumber  员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getListMessageCodeReceive(String userId) throws Exception;
	
	/**
	  * 根据senderId和密码获取员工信息
	  * @param senderId  员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getListMessageCodeSend(String senderId) throws Exception;
	
	/**
	  * 根据userId和senderId密码获取员工信息
	  * @param userId和senderId  员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getListMessageCodeAll(String userId,String senderId) throws Exception;
	
	/**
	  * 根据commonAttribute密码获取员工信息
	  * @param commonAttribute  员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getListMessageCodeDetail(String commonAttribute) throws Exception;
	
	
	/**
	  * 根据unionId获取员工信息
	  * @param unionId  微信登陆标识
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getByUinonIdEncryption(String unionIdEncryption) throws Exception;
	
	/**
	  * 根据获取标签信息
	  * @param 
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getByMessageCodeList() throws Exception;
	/**
	  * 根据departmentId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getByDepartment(String departmentId) throws Exception;
	
	/**
	  * 根据departmentId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getByDepartmentId(String departmentId) throws Exception;
	
	/**
	  * 根据companyId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCode> getByCompanyId(String companyId) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param messageCode
	  * @throws Exception 
	  */
	
	public String save(MessageCode messageCode) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param messageCode
	  * @throws Exception 
	  */
	public void update(MessageCode messageCode) throws Exception;
	/**
	  * 获取公司员工列表
	  * @param messageCode
	  * @throws Exception 
	  */
	public List<MessageCode> getByTelephone(String telephone) throws Exception;
	
}
