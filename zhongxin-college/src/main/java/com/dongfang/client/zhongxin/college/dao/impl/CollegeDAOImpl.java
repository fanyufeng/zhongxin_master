package com.dongfang.client.zhongxin.college.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.college.dao.CollegeDAO;
import com.dongfang.client.zhongxin.college.dao.entity.College;


@Component
public class CollegeDAOImpl extends BaseDao<College> implements CollegeDAO {
	public College getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(College.class, id);
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<College> getByCollegeList() throws Exception{
		try {	
			String queryString = "from College college";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			return query.list();
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#getListIdea({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<College> getByStatus(int status) throws Exception{
		try {	
			String queryString = "from College college where college.status = :status ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("status",status);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#getListCollege({}, {}) : {}", 
					status,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(College college) throws Exception {
		try {
			Date current = new Date();
			college.setCreateDate(current);
			college.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(college);
			return u;
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#save({}) : {}",
					college.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(College college) throws Exception {
		try {
			Date current = new Date();
			college.setLastUpdateDate(current);
			College dbCollege = this.getById(college.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(college, dbCollege,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("CollegeDAOImpl#update({}) : {}",
					college.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
