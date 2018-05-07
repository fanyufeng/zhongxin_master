package com.dongfang.client.zhongxin.person.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.person.dao.PersonDAO;
import com.dongfang.client.zhongxin.person.dao.entity.Person;


@Component
public class PersonDAOImpl extends BaseDao<Person> implements PersonDAO {
	public Person getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(Person.class, id);
		} catch (Exception e) {
			LOGGER.error("PersonDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Person> getByCompanyId(String companyId) throws Exception{
		try {	
			String queryString = "from Person person where person.companyId = :companyId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("companyId",companyId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("PersonDAOImpl#getByDepartmentId({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getByunionId(String unionId) throws Exception{
		try {	
			String queryString = "from Person person where person.unionId = :unionId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("unionId",unionId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("PersonDAOImpl#getListPerson({}, {}) : {}", 
					unionId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(Person person) throws Exception {
		try {
			Date current = new Date();
			person.setCreateDate(current);
			person.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(person);
			return u;
		} catch (Exception e) {
			LOGGER.error("PersonDAOImpl#save({}) : {}",
					person.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(Person person) throws Exception {
		try {
			Date current = new Date();
			person.setLastUpdateDate(current);
			Person dbPerson = this.getById(person.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(person, dbPerson,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("PersonDAOImpl#update({}) : {}",
					person.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
