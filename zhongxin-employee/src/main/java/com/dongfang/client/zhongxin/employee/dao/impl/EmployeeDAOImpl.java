package com.dongfang.client.zhongxin.employee.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.employee.dao.EmployeeDAO;
import com.dongfang.client.zhongxin.employee.dao.entity.Employee;


@Component
public class EmployeeDAOImpl extends BaseDao<Employee> implements EmployeeDAO {
	public Employee getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(Employee.class, id);
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getByCompanyId(String companyId) throws Exception{
		try {	
			String queryString = "from Employee employee where employee.companyId = :companyId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("companyId",companyId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getByDepartmentId({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getByunionId(String unionId) throws Exception{
		try {	
			String queryString = "from Employee employee where employee.unionId = :unionId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("unionId",unionId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getListEmployee({}, {}) : {}", 
					unionId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getByopenid(String openid) throws Exception{
		try {	
			String queryString = "from Employee employee where employee.openid = :openid ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("openid",openid);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getListEmployee({}, {}) : {}", 
					openid,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(Employee employee) throws Exception {
		try {
			Date current = new Date();
			employee.setCreateDate(current);
			employee.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(employee);
			return u;
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#save({}) : {}",
					employee.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(Employee employee) throws Exception {
		try {
			Date current = new Date();
			employee.setLastUpdateDate(current);
			Employee dbEmployee = this.getById(employee.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(employee, dbEmployee,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#update({}) : {}",
					employee.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
