package com.dongfang.client.zhongxin.leave.message.person.reply.service.impl;

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
import com.dongfang.client.zhongxin.leave.message.person.reply.converter.LeaveMessagePersonReplyBeanCopierUtil;
import com.dongfang.client.zhongxin.leave.message.person.reply.dao.LeaveMessagePersonReplyDAO;
import com.dongfang.client.zhongxin.leave.message.person.reply.dao.entity.LeaveMessagePersonReply;
import com.dongfang.client.zhongxin.leave.message.person.reply.service.LeaveMessagePersonReplyService;
import com.dongfang.client.zhongxin.leave.message.person.reply.vo.LeaveMessagePersonReplyVO;




@Service("leaveMessagePersonReplyService")
@Transactional(rollbackFor={Exception.class})
public class LeaveMessagePersonReplyServiceImpl implements LeaveMessagePersonReplyService {

	public LeaveMessagePersonReplyVO getById(String id) throws Exception {
		try {
			LeaveMessagePersonReply leaveMessagePersonReply = leaveMessagePersonReplyDAO.getById(id);
			if(leaveMessagePersonReply != null) {
				return LeaveMessagePersonReplyBeanCopierUtil.generateVO(leaveMessagePersonReply);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("LeaveMessagePersonReplyServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	public List<LeaveMessagePersonReplyVO> getLeaveMessagePersonId(String leaveMessagePersonId)
			throws Exception {
		try {
			List<LeaveMessagePersonReply> propertyList = leaveMessagePersonReplyDAO.getByLeaveMessagePersonId(leaveMessagePersonId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<LeaveMessagePersonReplyVO> propertyVOList = new ArrayList<LeaveMessagePersonReplyVO>();
				for(LeaveMessagePersonReply property : propertyList) {
					propertyVOList.add(LeaveMessagePersonReplyBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					leaveMessagePersonId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	

	

	
	
	
	
	
	
	public String save(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception {
		try {
			leaveMessagePersonReplyVO.setId(IDGeneratorUtils.uuid32());
			LeaveMessagePersonReply leaveMessagePersonReply = LeaveMessagePersonReplyBeanCopierUtil.generateEntity(leaveMessagePersonReplyVO);
			String u=leaveMessagePersonReplyDAO.save(leaveMessagePersonReply);
			return u;
		} catch (Exception e) {
			LOGGER.error("LeaveMessagePersonReplyServiceImpl#save({}) : {}",
					leaveMessagePersonReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception {
		try {
			LeaveMessagePersonReply leaveMessagePersonReply = LeaveMessagePersonReplyBeanCopierUtil.generateEntity(leaveMessagePersonReplyVO);
			leaveMessagePersonReplyDAO.update(leaveMessagePersonReply);
		} catch (Exception e) {
			LOGGER.error("LeaveMessagePersonReplyServiceImpl#update({}) : {}",
					leaveMessagePersonReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void delete(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception {
		try {
			LeaveMessagePersonReply customProperty = LeaveMessagePersonReplyBeanCopierUtil.generateEntity(leaveMessagePersonReplyVO);
			leaveMessagePersonReplyDAO.delete(customProperty);
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#save({}) : {}",
					leaveMessagePersonReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessagePersonReplyServiceImpl.class);
	@Autowired
	private LeaveMessagePersonReplyDAO leaveMessagePersonReplyDAO;
}
