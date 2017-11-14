package com.dongfang.client.zhongxin.project.client.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.project.client.dao.ProjectClientDAO;
import com.dongfang.client.zhongxin.project.client.dao.entity.ProjectClient;


@Component
public class ProjectClientDAOImpl extends BaseDao<ProjectClient> implements ProjectClientDAO {
	public ProjectClient getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(ProjectClient.class, id);
		} catch (Exception e) {
			LOGGER.error("ProjectClientDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProjectClient> getByCompanyId(String companyId) throws Exception{
		try {	
			String queryString = "from ProjectClient projectClient where projectClient.companyId = :companyId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("companyId",companyId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("ProjectClientDAOImpl#getByDepartmentId({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(ProjectClient projectClient) throws Exception {
		try {
			Date current = new Date();
			projectClient.setCreateDate(current);
			projectClient.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(projectClient);
			return u;
		} catch (Exception e) {
			LOGGER.error("ProjectClientDAOImpl#save({}) : {}",
					projectClient.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(ProjectClient projectClient) throws Exception {
		try {
			Date current = new Date();
			projectClient.setLastUpdateDate(current);
			ProjectClient dbProjectClient = this.getById(projectClient.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(projectClient, dbProjectClient,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("ProjectClientDAOImpl#update({}) : {}",
					projectClient.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
