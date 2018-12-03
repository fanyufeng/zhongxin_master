package com.dongfang.client.zhongxin.mail.message.code.service.impl;


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
import com.dongfang.client.zhongxin.mail.message.code.converter.MailMessageCodeBeanCopierUtil;
import com.dongfang.client.zhongxin.mail.message.code.dao.MailMessageCodeDAO;
import com.dongfang.client.zhongxin.mail.message.code.dao.entity.MailMessageCode;
import com.dongfang.client.zhongxin.mail.message.code.dao.impl.MailMessageCodeDAOImpl;
import com.dongfang.client.zhongxin.mail.message.code.service.MailMessageCodeService;
import com.dongfang.client.zhongxin.mail.message.code.vo.MailMessageCodeVO;



@Service("mailMessageCodeService")
@Transactional(rollbackFor={Exception.class})
public class MailMessageCodeServiceImpl implements MailMessageCodeService{
	/**
	  * 根据id获取邮件信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public MailMessageCodeVO getById(String id) throws Exception{
		try {
			MailMessageCode mailMessageCode = mailMessageCodeDAO.getById(id);
			if(mailMessageCode != null) {
				return MailMessageCodeBeanCopierUtil.generateVO(mailMessageCode);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("EmployeeServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	public List<MailMessageCodeVO> getByFormId(String belongFormId,String mailMessageCodeId)
			throws Exception{
		try {
			List<MailMessageCode> propertyList = mailMessageCodeDAO.getByFormId(belongFormId,mailMessageCodeId) ;
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MailMessageCodeVO> propertyVOList = new ArrayList<MailMessageCodeVO>();
				for(MailMessageCode property : propertyList) {
					propertyVOList.add(MailMessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					belongFormId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	public MailMessageCodeVO getByEmail(String email)
			throws Exception{
		try {
			List<MailMessageCode> propertyList = mailMessageCodeDAO.getByEmail(email);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				MailMessageCodeVO messageCodeVO=new MailMessageCodeVO();
				List<MailMessageCodeVO> propertyVOList = new ArrayList<MailMessageCodeVO>();
				for(MailMessageCode property : propertyList) {
					propertyVOList.add(MailMessageCodeBeanCopierUtil.generateVO(property));
				}
				for(MailMessageCodeVO e:propertyVOList){
					messageCodeVO=e;
				}
				return messageCodeVO;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					email,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	/**
	  * 根据mailMessageCodeId获取审核人信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public List<MailMessageCodeVO> getByMailMessageCodeId(String mailMessageCodeId)
			throws Exception{
		try {
			List<MailMessageCode> propertyList = mailMessageCodeDAO.getByMailMessageCodeId(mailMessageCodeId) ;
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<MailMessageCodeVO> propertyVOList = new ArrayList<MailMessageCodeVO>();
				for(MailMessageCode property : propertyList) {
					propertyVOList.add(MailMessageCodeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					mailMessageCodeId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	/**
	  * 保存邮件信息
	  * @param mailMessageCodeVO	员工
	  * @throws Exception 
	  */
	public String save(MailMessageCodeVO mailMessageCodeVO) throws Exception{
		try {
			
			mailMessageCodeVO.setId(IDGeneratorUtils.uuid32());
			
			MailMessageCode mailMessageCode = MailMessageCodeBeanCopierUtil.generateEntity(mailMessageCodeVO);
			String u =mailMessageCodeDAO.save(mailMessageCode);
			
            return u;
		} catch (Exception e) {
			LOGGER.error("MailMessageCodeServiceImpl#save({}) : {}",
					mailMessageCodeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	/**
	  * 修改邮件信息
	  * @param mailMessageCodeVO
	  * @throws Exception 
	  */
	public void update(MailMessageCodeVO mailMessageCodeVO) throws Exception{
		try {
			MailMessageCode mailMessageCode = MailMessageCodeBeanCopierUtil.generateEntity(mailMessageCodeVO);
			mailMessageCodeDAO.update(mailMessageCode);
		} catch (Exception e) {
			LOGGER.error("MailMessageCodeServiceImpl#update({}) : {}",
					mailMessageCodeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	private static final Logger LOGGER =LoggerFactory.getLogger(MailMessageCodeServiceImpl.class);
	@Autowired
	private MailMessageCodeDAO mailMessageCodeDAO=new MailMessageCodeDAOImpl();
}
