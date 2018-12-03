package com.dongfang.client.zhongxin.message.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongfang.client.zhongxin.commons.utils.IDGeneratorUtils;
import com.dongfang.client.zhongxin.message.code.converter.MessageCodeBeanCopierUtil;
import com.dongfang.client.zhongxin.message.code.dao.MessageCodeDAO;
import com.dongfang.client.zhongxin.message.code.dao.entity.MessageCode;
import com.dongfang.client.zhongxin.message.code.service.MessageCodeService;
import com.dongfang.client.zhongxin.message.code.vo.MessageCodeVO;


@Service("messageCodeService")
@Transactional(rollbackFor={Exception.class})
public class MessageCodeServiceImpl implements MessageCodeService {

	public MessageCodeVO getById(String id) throws Exception {
		try {
			MessageCode messageCode = messageCodeDAO.getById(id);
			if(messageCode != null) {
				return MessageCodeBeanCopierUtil.generateVO(messageCode);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("MessageCodeServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<MessageCodeVO> getListMessageCodeReceive(String userId)
			throws Exception {
		try {
			List<MessageCode> propertyList = messageCodeDAO.getListMessageCodeReceive(userId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MessageCodeVO> propertyVOList = new ArrayList<MessageCodeVO>();
				for(MessageCode property : propertyList) {
					propertyVOList.add(MessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					userId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<MessageCodeVO> getListMessageCodeSend(String senderId)
			throws Exception {
		try {
			List<MessageCode> propertyList = messageCodeDAO.getListMessageCodeSend(senderId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MessageCodeVO> propertyVOList = new ArrayList<MessageCodeVO>();
				for(MessageCode property : propertyList) {
					propertyVOList.add(MessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					senderId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<MessageCodeVO> getByTelephone(String telephone)
			throws Exception {
		try {
			List<MessageCode> propertyList = messageCodeDAO.getByTelephone(telephone);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MessageCodeVO> propertyVOList = new ArrayList<MessageCodeVO>();
				for(MessageCode property : propertyList) {
					propertyVOList.add(MessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					telephone,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<MessageCodeVO> getListMessageCodeDetail(String commonAttribute)
			throws Exception {
		try {
			List<MessageCode> propertyList = messageCodeDAO.getListMessageCodeDetail(commonAttribute);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MessageCodeVO> propertyVOList = new ArrayList<MessageCodeVO>();
				for(MessageCode property : propertyList) {
					propertyVOList.add(MessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					commonAttribute,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	public List<MessageCodeVO> getListMessageCodeAll(String userId,String senderId)
			throws Exception {
		try {
			List<MessageCode> propertyList = messageCodeDAO.getListMessageCodeAll(userId, senderId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MessageCodeVO> propertyVOList = new ArrayList<MessageCodeVO>();
				for(MessageCode property : propertyList) {
					propertyVOList.add(MessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					userId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	public MessageCodeVO getByUnionIdEncryption(String unionIdEncryption) throws Exception{
		try {
			MessageCodeVO userTelephone=null;
			List<MessageCode> propertyList = messageCodeDAO.getByUinonIdEncryption(unionIdEncryption);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MessageCodeVO> propertyVOList = new ArrayList<MessageCodeVO>();
				for(MessageCode property : propertyList) {
					propertyVOList.add(MessageCodeBeanCopierUtil.generateVO(property));
				}
				for(MessageCodeVO u:propertyVOList){
					 userTelephone=u;
				}
				return userTelephone;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					unionIdEncryption,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	

	
	
	public String save(MessageCodeVO messageCodeVO) throws Exception {
		try {
			messageCodeVO.setId(IDGeneratorUtils.uuid32());
			MessageCode messageCode = MessageCodeBeanCopierUtil.generateEntity(messageCodeVO);
			String u=messageCodeDAO.save(messageCode);
			return u;
		} catch (Exception e) {
			LOGGER.error("MessageCodeServiceImpl#save({}) : {}",
					messageCodeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(MessageCodeVO messageCodeVO) throws Exception {
		try {
			MessageCode messageCode = MessageCodeBeanCopierUtil.generateEntity(messageCodeVO);
			messageCodeDAO.update(messageCode);
		} catch (Exception e) {
			LOGGER.error("MessageCodeServiceImpl#update({}) : {}",
					messageCodeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageCodeServiceImpl.class);
	@Autowired
	private MessageCodeDAO messageCodeDAO;
}
