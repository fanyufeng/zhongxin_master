package com.dongfang.client.zhongxin.leave.message.person.reply.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.leave.message.person.reply.dao.LeaveMessagePersonReplyDAO;
import com.dongfang.client.zhongxin.leave.message.person.reply.dao.entity.LeaveMessagePersonReply;



@Component
public class LeaveMessagePersonReplyDAOImpl extends BaseDao<LeaveMessagePersonReply> implements LeaveMessagePersonReplyDAO {
	public LeaveMessagePersonReply getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(LeaveMessagePersonReply.class, id);
		} catch (Exception e) {
			LOGGER.error("LeaveMessagePersonReplyDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LeaveMessagePersonReply> getByLeaveMessagePersonId(String leaveMessagePersonId) throws Exception{
		try {	
			String queryString = "from LeaveMessagePersonReply leaveMessagePersonReply where leaveMessagePersonReply.leaveMessagePersonId = :leaveMessagePersonId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("leaveMessagePersonId",leaveMessagePersonId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("IdeaDAOImpl#getListIdea({}, {}) : {}", 
					leaveMessagePersonId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	
	public String save(LeaveMessagePersonReply leaveMessagePersonReply) throws Exception {
		try {
			Date current = new Date();
			leaveMessagePersonReply.setCreateDate(current);
			leaveMessagePersonReply.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(leaveMessagePersonReply);
			return u;
		} catch (Exception e) {
			LOGGER.error("LeaveMessagePersonReplyDAOImpl#save({}) : {}",
					leaveMessagePersonReply.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(LeaveMessagePersonReply leaveMessagePersonReply) throws Exception {
		try {
			Date current = new Date();
			leaveMessagePersonReply.setLastUpdateDate(current);
			LeaveMessagePersonReply dbLeaveMessagePersonReply = this.getById(leaveMessagePersonReply.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(leaveMessagePersonReply, dbLeaveMessagePersonReply,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("LeaveMessagePersonReplyDAOImpl#update({}) : {}",
					leaveMessagePersonReply.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public  void delete(LeaveMessagePersonReply leaveMessagePersonReply) throws Exception {
		try {
			Date current = new Date();
			leaveMessagePersonReply.setCreateDate(current);
			leaveMessagePersonReply.setLastUpdateDate(current);
			getHibernateTemplate().delete(leaveMessagePersonReply);;
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#save({}) : {}",
					leaveMessagePersonReply.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
