package com.dongfang.client.zhongxin.leave.message.reply.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.leave.message.reply.dao.LeaveMessageReplyDAO;
import com.dongfang.client.zhongxin.leave.message.reply.dao.entity.LeaveMessageReply;



@Component
public class LeaveMessageReplyDAOImpl extends BaseDao<LeaveMessageReply> implements LeaveMessageReplyDAO {
	public LeaveMessageReply getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(LeaveMessageReply.class, id);
		} catch (Exception e) {
			LOGGER.error("LeaveMessageReplyDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveMessageReply> getByLeaveMessageId(String leaveMessageId) throws Exception{
		try {	
			String queryString = "from LeaveMessageReply leaveMessageReply where leaveMessageReply.leaveMessageId = :leaveMessageId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("leaveMessageId",leaveMessageId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("IdeaDAOImpl#getListIdea({}, {}) : {}", 
					leaveMessageId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	
	public String save(LeaveMessageReply leaveMessageReply) throws Exception {
		try {
			Date current = new Date();
			leaveMessageReply.setCreateDate(current);
			leaveMessageReply.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(leaveMessageReply);
			return u;
		} catch (Exception e) {
			LOGGER.error("LeaveMessageReplyDAOImpl#save({}) : {}",
					leaveMessageReply.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(LeaveMessageReply leaveMessageReply) throws Exception {
		try {
			Date current = new Date();
			leaveMessageReply.setLastUpdateDate(current);
			LeaveMessageReply dbLeaveMessageReply = this.getById(leaveMessageReply.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(leaveMessageReply, dbLeaveMessageReply,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("LeaveMessageReplyDAOImpl#update({}) : {}",
					leaveMessageReply.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public  void delete(LeaveMessageReply leaveMessageReply) throws Exception {
		try {
			Date current = new Date();
			leaveMessageReply.setCreateDate(current);
			leaveMessageReply.setLastUpdateDate(current);
			getHibernateTemplate().delete(leaveMessageReply);;
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#save({}) : {}",
					leaveMessageReply.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
