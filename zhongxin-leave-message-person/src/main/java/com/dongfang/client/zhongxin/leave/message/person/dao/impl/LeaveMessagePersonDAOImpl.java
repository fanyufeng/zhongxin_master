package com.dongfang.client.zhongxin.leave.message.person.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.leave.message.person.dao.LeaveMessagePersonDAO;
import com.dongfang.client.zhongxin.leave.message.person.dao.entity.LeaveMessagePerson;



@Component
public class LeaveMessagePersonDAOImpl extends BaseDao<LeaveMessagePerson> implements LeaveMessagePersonDAO {
	public LeaveMessagePerson getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(LeaveMessagePerson.class, id);
		} catch (Exception e) {
			LOGGER.error("CommentDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LeaveMessagePerson> getByPersonId(String personId) throws Exception {
		try {
			
			String queryString = "from LeaveMessagePerson leaveMessagePerson where leaveMessagePerson.personId = :personId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("personId",personId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#getListCollege({}, {}) : {}", 
					personId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public String save(LeaveMessagePerson leaveMessagePerson) throws Exception {
		try {
			Date current = new Date();
			leaveMessagePerson.setCreateDate(current);
			leaveMessagePerson.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(leaveMessagePerson);
			return u;
		} catch (Exception e) {
			LOGGER.error("CommentDAOImpl#save({}) : {}",
					leaveMessagePerson.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(LeaveMessagePerson leaveMessagePerson) throws Exception {
		try {
			Date current = new Date();
			leaveMessagePerson.setLastUpdateDate(current);
			LeaveMessagePerson dbComment = this.getById(leaveMessagePerson.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(leaveMessagePerson, dbComment,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("CommentDAOImpl#update({}) : {}",
					leaveMessagePerson.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public  void delete(LeaveMessagePerson leaveMessagePerson) throws Exception {
		try {
			Date current = new Date();
			leaveMessagePerson.setCreateDate(current);
			leaveMessagePerson.setLastUpdateDate(current);
			getHibernateTemplate().delete(leaveMessagePerson);;
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#save({}) : {}",
					leaveMessagePerson.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
