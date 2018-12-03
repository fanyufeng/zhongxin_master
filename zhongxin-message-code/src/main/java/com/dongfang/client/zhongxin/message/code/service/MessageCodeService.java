package com.dongfang.client.zhongxin.message.code.service;

import java.util.List;

import com.dongfang.client.zhongxin.message.code.vo.MessageCodeVO;

/**
  * @ClassName: MessageCodeService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface MessageCodeService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public MessageCodeVO getById(String id) throws Exception;
	
	/**
	  * 根据idNumber获取员工信息
	  * @param idNumber	员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCodeVO> getListMessageCodeReceive(String userId)
			throws Exception;
	
	/**
	  * 根据senderId获取员工信息
	  * @param senderId	员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCodeVO> getListMessageCodeSend(String senderId)
			throws Exception;
	
	/**
	  * 根据commonAttribute获取员工信息
	  * @param commonAttribute	员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCodeVO> getListMessageCodeDetail(String commonAttribute)
			throws Exception;
	/**
	  * 根据userId和senderId获取员工信息
	  * @param userId和senderId	员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCodeVO> getListMessageCodeAll(String userId,String senderId)
			throws Exception;
	
	
	/**
	  * 根据unionId获取员工信息列表
	  * @param unionId 员工微信登陆唯一标识
	  * @return
	  * @throws Exception 
	  */
	public MessageCodeVO getByUnionIdEncryption(String unionIdEncryption) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param messageCodeVO	员工
	  * @throws Exception 
	  */
	public String save(MessageCodeVO messageCodeVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param messageCodeVO
	  * @throws Exception 
	  */
	public void update(MessageCodeVO messageCodeVO) throws Exception;
	/**
	  * 根据telephone获取员工信息列表
	  * @param telephone 员工微信登陆唯一标识
	  * @return
	  * @throws Exception 
	  */
	public List<MessageCodeVO> getByTelephone(String telephone)
			throws Exception;
}
