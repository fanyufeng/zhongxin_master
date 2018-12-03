package com.dongfang.client.zhongxin.mail.message.code.dao;

import java.util.List;

import com.dongfang.client.zhongxin.mail.message.code.dao.entity.MailMessageCode;





public interface MailMessageCodeDAO {
	/**
	  * @Fields ignoreProperties : 不可编辑属性
	  */
	public static final String[] ignoreProperties = new String[]{"createDate"};
	
	/**
	  * 根据id获取自定义属性信息
	  * @param id
	  * @return
	  * @throws Exception 
	  */
	public MailMessageCode getById(String id) throws Exception;
	
	/**
	  * 根据belongFormId,mailMessageCodeId获取表单信息
	  * @param belongFormId
	  * @return
	  * @throws Exception 
	  */
	public List<MailMessageCode> getByFormId(String belongFormId,String mailMessageCodeId) throws Exception;

	/**
	  * 根据telephone获取表单信息
	  * @param belongFormId
	  * @return
	  * @throws Exception 
	  */
	public List<MailMessageCode> getByEmail(String email) throws Exception;
	/**
	  * 根据mailMessageCodeIdId获取表单信息
	  * @param mailMessageCodeIdId
	  * @return
	  * @throws Exception 
	  */
	public List<MailMessageCode> getByMailMessageCodeId(String mailMessageCodeId) throws Exception;
	/**
	  * 修改邮件信息
	  * @param communication
	  * @throws Exception 
	  */
	public String save(MailMessageCode customProperty) throws Exception;
	
	/**
	  * 修改邮件信息
	  * @param communication
	  * @throws Exception 
	  */
	public void update(MailMessageCode customProperty) throws Exception;
}

