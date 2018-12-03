package com.dongfang.client.zhongxin.mail.message.code.service;

import java.util.List;

import com.dongfang.client.zhongxin.mail.message.code.vo.MailMessageCodeVO;




public interface MailMessageCodeService {
	/**
	  * 根据id获取邮件信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public MailMessageCodeVO getById(String id) throws Exception;
	
	/**
	  * 根据belongFormId,mailMessageCodeId获取邮件信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public List<MailMessageCodeVO> getByFormId(String belongFormId,String mailMessageCodeId) throws Exception;
	
	/**
	  * 根据telephone获取邮件信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public MailMessageCodeVO getByEmail(String email) throws Exception;
	/**
	  * 根据mailMessageCodeId获取审核人信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public List<MailMessageCodeVO> getByMailMessageCodeId(String mailMessageCodeId) throws Exception;
	/**
	  * 保存邮件信息
	  * @param mailMessageCodeVO	员工
	  * @throws Exception 
	  */
	public String save(MailMessageCodeVO employeeVO) throws Exception;
	
	/**
	  * 修改邮件信息
	  * @param mailMessageCodeVO
	  * @throws Exception 
	  */
	public void update(MailMessageCodeVO employeeVO) throws Exception;

}
