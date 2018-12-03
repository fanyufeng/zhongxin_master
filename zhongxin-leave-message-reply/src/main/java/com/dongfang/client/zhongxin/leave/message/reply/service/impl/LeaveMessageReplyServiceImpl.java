package com.dongfang.client.zhongxin.leave.message.reply.service.impl;

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
import com.dongfang.client.zhongxin.leave.message.reply.converter.LeaveMessageReplyBeanCopierUtil;
import com.dongfang.client.zhongxin.leave.message.reply.dao.LeaveMessageReplyDAO;
import com.dongfang.client.zhongxin.leave.message.reply.dao.entity.LeaveMessageReply;
import com.dongfang.client.zhongxin.leave.message.reply.service.LeaveMessageReplyService;
import com.dongfang.client.zhongxin.leave.message.reply.vo.LeaveMessageReplyVO;





@Service("leaveMessageReplyService")
@Transactional(rollbackFor={Exception.class})
public class LeaveMessageReplyServiceImpl implements LeaveMessageReplyService {

	public LeaveMessageReplyVO getById(String id) throws Exception {
		try {
			LeaveMessageReply leaveMessageReply = leaveMessageReplyDAO.getById(id);
			if(leaveMessageReply != null) {
				return LeaveMessageReplyBeanCopierUtil.generateVO(leaveMessageReply);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("LeaveMessageReplyServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	public List<LeaveMessageReplyVO> getLeaveMessageId(String leaveMessageId)
			throws Exception {
		try {
			List<LeaveMessageReply> propertyList = leaveMessageReplyDAO.getByLeaveMessageId(leaveMessageId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<LeaveMessageReplyVO> propertyVOList = new ArrayList<LeaveMessageReplyVO>();
				for(LeaveMessageReply property : propertyList) {
					propertyVOList.add(LeaveMessageReplyBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					leaveMessageId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	

	

	
	
	
	
	
	
	public String save(LeaveMessageReplyVO leaveMessageReplyVO) throws Exception {
		try {
			leaveMessageReplyVO.setId(IDGeneratorUtils.uuid32());
			LeaveMessageReply leaveMessageReply = LeaveMessageReplyBeanCopierUtil.generateEntity(leaveMessageReplyVO);
			String u=leaveMessageReplyDAO.save(leaveMessageReply);
			return u;
		} catch (Exception e) {
			LOGGER.error("LeaveMessageReplyServiceImpl#save({}) : {}",
					leaveMessageReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(LeaveMessageReplyVO leaveMessageReplyVO) throws Exception {
		try {
			LeaveMessageReply leaveMessageReply = LeaveMessageReplyBeanCopierUtil.generateEntity(leaveMessageReplyVO);
			leaveMessageReplyDAO.update(leaveMessageReply);
		} catch (Exception e) {
			LOGGER.error("LeaveMessageReplyServiceImpl#update({}) : {}",
					leaveMessageReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void delete(LeaveMessageReplyVO leaveMessageReplyVO) throws Exception {
		try {
			LeaveMessageReply customProperty = LeaveMessageReplyBeanCopierUtil.generateEntity(leaveMessageReplyVO);
			leaveMessageReplyDAO.delete(customProperty);
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#save({}) : {}",
					leaveMessageReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessageReplyServiceImpl.class);
	@Autowired
	private LeaveMessageReplyDAO leaveMessageReplyDAO;
}
