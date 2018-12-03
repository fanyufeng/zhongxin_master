package com.dongfang.client.zhongxin.leave.message.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.leave.message.dao.LeaveMessageDAO;
import com.dongfang.client.zhongxin.leave.message.dao.entity.LeaveMessage;



@Component
public class LeaveMessageDAOImpl extends BaseDao<LeaveMessage> implements LeaveMessageDAO {
	public LeaveMessage getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(LeaveMessage.class, id);
		} catch (Exception e) {
			LOGGER.error("CommentDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LeaveMessage> getByIdeaId(String ideaId) throws Exception {
		try {
			
			String queryString = "from LeaveMessage leaveMessage where leaveMessage.ideaId = :ideaId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("ideaId",ideaId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#getListCollege({}, {}) : {}", 
					ideaId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public String save(LeaveMessage leaveMessage) throws Exception {
		try {
			Date current = new Date();
			leaveMessage.setCreateDate(current);
			leaveMessage.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(leaveMessage);
			return u;
		} catch (Exception e) {
			LOGGER.error("CommentDAOImpl#save({}) : {}",
					leaveMessage.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(LeaveMessage leaveMessage) throws Exception {
		try {
			Date current = new Date();
			leaveMessage.setLastUpdateDate(current);
			LeaveMessage dbComment = this.getById(leaveMessage.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(leaveMessage, dbComment,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("CommentDAOImpl#update({}) : {}",
					leaveMessage.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public  void delete(LeaveMessage leaveMessage) throws Exception {
		try {
			Date current = new Date();
			leaveMessage.setCreateDate(current);
			leaveMessage.setLastUpdateDate(current);
			getHibernateTemplate().delete(leaveMessage);;
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#save({}) : {}",
					leaveMessage.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
