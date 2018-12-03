package com.dongfang.client.zhongxin.leave.message.service.impl;

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
import com.dongfang.client.zhongxin.leave.message.converter.LeaveMessageBeanCopierUtil;
import com.dongfang.client.zhongxin.leave.message.dao.LeaveMessageDAO;
import com.dongfang.client.zhongxin.leave.message.dao.entity.LeaveMessage;
import com.dongfang.client.zhongxin.leave.message.service.LeaveMessageService;
import com.dongfang.client.zhongxin.leave.message.vo.LeaveMessageVO;




@Service("leaveMessageService")
@Transactional(rollbackFor={Exception.class})
public class LeaveMessageServiceImpl implements LeaveMessageService {

	public LeaveMessageVO getById(String id) throws Exception {
		try {
			LeaveMessage leaveMessage = leaveMessageDAO.getById(id);
			if(leaveMessage != null) {
				return LeaveMessageBeanCopierUtil.generateVO(leaveMessage);
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
	
	public List<LeaveMessageVO> getByIdeaId(String ideaId)
			throws Exception {
		try {
			List<LeaveMessage> propertyList = leaveMessageDAO.getByIdeaId(ideaId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<LeaveMessageVO> propertyVOList = new ArrayList<LeaveMessageVO>();
				for(LeaveMessage property : propertyList) {
					propertyVOList.add(LeaveMessageBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					ideaId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public String save(LeaveMessageVO leaveMessageVO) throws Exception {
		try {
			leaveMessageVO.setId(IDGeneratorUtils.uuid32());
			LeaveMessage leaveMessage = LeaveMessageBeanCopierUtil.generateEntity(leaveMessageVO);
			String u=leaveMessageDAO.save(leaveMessage);
			return u;
		} catch (Exception e) {
			LOGGER.error("LeaveMessageServiceImpl#save({}) : {}",
					leaveMessageVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(LeaveMessageVO leaveMessageVO) throws Exception {
		try {
			LeaveMessage leaveMessage = LeaveMessageBeanCopierUtil.generateEntity(leaveMessageVO);
			leaveMessageDAO.update(leaveMessage);
		} catch (Exception e) {
			LOGGER.error("LeaveMessageServiceImpl#update({}) : {}",
					leaveMessageVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void delete(LeaveMessageVO leaveMessageVO) throws Exception {
		try {
			LeaveMessage customProperty = LeaveMessageBeanCopierUtil.generateEntity(leaveMessageVO);
			leaveMessageDAO.delete(customProperty);
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#save({}) : {}",
					leaveMessageVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessageServiceImpl.class);
	@Autowired
	private LeaveMessageDAO leaveMessageDAO;

}
