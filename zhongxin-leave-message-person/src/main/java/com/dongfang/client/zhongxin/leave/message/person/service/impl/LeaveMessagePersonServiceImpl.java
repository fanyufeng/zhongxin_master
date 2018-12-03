package com.dongfang.client.zhongxin.leave.message.person.service.impl;

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
import com.dongfang.client.zhongxin.leave.message.person.converter.LeaveMessagePersonBeanCopierUtil;
import com.dongfang.client.zhongxin.leave.message.person.dao.LeaveMessagePersonDAO;
import com.dongfang.client.zhongxin.leave.message.person.dao.entity.LeaveMessagePerson;
import com.dongfang.client.zhongxin.leave.message.person.service.LeaveMessagePersonService;
import com.dongfang.client.zhongxin.leave.message.person.vo.LeaveMessagePersonVO;





@Service("leaveMessagePersonService")
@Transactional(rollbackFor={Exception.class})
public class LeaveMessagePersonServiceImpl implements LeaveMessagePersonService {

	public LeaveMessagePersonVO getById(String id) throws Exception {
		try {
			LeaveMessagePerson leaveMessagePerson = leaveMessagePersonDAO.getById(id);
			if(leaveMessagePerson != null) {
				return LeaveMessagePersonBeanCopierUtil.generateVO(leaveMessagePerson);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("LeaveMessageServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<LeaveMessagePersonVO> getByPersonId(String personId)
			throws Exception {
		try {
			List<LeaveMessagePerson> propertyList = leaveMessagePersonDAO.getByPersonId(personId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<LeaveMessagePersonVO> propertyVOList = new ArrayList<LeaveMessagePersonVO>();
				for(LeaveMessagePerson property : propertyList) {
					propertyVOList.add(LeaveMessagePersonBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					personId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public String save(LeaveMessagePersonVO leaveMessagePersonVO) throws Exception {
		try {
			leaveMessagePersonVO.setId(IDGeneratorUtils.uuid32());
			LeaveMessagePerson leaveMessagePerson = LeaveMessagePersonBeanCopierUtil.generateEntity(leaveMessagePersonVO);
			String u=leaveMessagePersonDAO.save(leaveMessagePerson);
			return u;
		} catch (Exception e) {
			LOGGER.error("LeaveMessageServiceImpl#save({}) : {}",
					leaveMessagePersonVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(LeaveMessagePersonVO leaveMessagePersonVO) throws Exception {
		try {
			LeaveMessagePerson leaveMessagePerson = LeaveMessagePersonBeanCopierUtil.generateEntity(leaveMessagePersonVO);
			leaveMessagePersonDAO.update(leaveMessagePerson);
		} catch (Exception e) {
			LOGGER.error("LeaveMessageServiceImpl#update({}) : {}",
					leaveMessagePersonVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void delete(LeaveMessagePersonVO leaveMessagePersonVO) throws Exception {
		try {
			LeaveMessagePerson customProperty = LeaveMessagePersonBeanCopierUtil.generateEntity(leaveMessagePersonVO);
			leaveMessagePersonDAO.delete(customProperty);
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#save({}) : {}",
					leaveMessagePersonVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessagePersonServiceImpl.class);
	@Autowired
	private LeaveMessagePersonDAO leaveMessagePersonDAO;

}
