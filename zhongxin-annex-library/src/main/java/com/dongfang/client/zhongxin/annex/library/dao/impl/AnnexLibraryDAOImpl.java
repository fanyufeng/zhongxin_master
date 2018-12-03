package com.dongfang.client.zhongxin.annex.library.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.annex.library.dao.AnnexLibraryDAO;
import com.dongfang.client.zhongxin.annex.library.dao.entity.AnnexLibrary;
import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;

@Component
public class AnnexLibraryDAOImpl extends BaseDao<AnnexLibrary> implements AnnexLibraryDAO {
	public AnnexLibrary getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(AnnexLibrary.class, id);
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getListAnnexLibrary(String telephone,String passWord) throws Exception {
		try {
			
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.telephone = :telephone and annexLibrary.passWord = :passWord";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("passWord",passWord);
			query.setParameter("telephone",telephone);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					telephone,
					passWord,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByPersonId(String personId) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.personId = :personId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("personId",personId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					personId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByAnnexLibraryatorId(String annexLibraryatorId) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.annexLibraryatorId = :annexLibraryatorId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("annexLibraryatorId",annexLibraryatorId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					annexLibraryatorId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByUinonIdEncryption(String unionIdEncryption) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.unionIdEncryption = :unionIdEncryption ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("unionIdEncryption",unionIdEncryption);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					unionIdEncryption,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByAnnexLibraryList() throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByCompany(String company) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.company = :company ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("company",company);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					company,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByDepartment(String departmentId) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.departmentId = :departmentId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("departmentId",departmentId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getListAnnexLibrary({}, {}) : {}", 
					departmentId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByDepartmentId(String departmentId) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.departmentId = :departmentId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("departmentId",departmentId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getByDepartmentId({}, {}) : {}", 
					departmentId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AnnexLibrary> getByideaIdEmployeeId(String ideaId,String annexLibraryatorId) throws Exception{
		try {	
			String queryString = "from AnnexLibrary annexLibrary where annexLibrary.ideaId = :ideaId and annexLibrary.annexLibraryatorId = :annexLibraryatorId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("ideaId",ideaId);
			query.setParameter("annexLibraryatorId",annexLibraryatorId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#getByDepartmentId({}, {}) : {}", 
					ideaId,
					annexLibraryatorId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(AnnexLibrary annexLibrary) throws Exception {
		try {
			Date current = new Date();
			annexLibrary.setCreateDate(current);
			annexLibrary.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(annexLibrary);
			return u;
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#save({}) : {}",
					annexLibrary.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(AnnexLibrary annexLibrary) throws Exception {
		try {
			Date current = new Date();
			annexLibrary.setLastUpdateDate(current);
			AnnexLibrary dbAnnexLibrary = this.getById(annexLibrary.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(annexLibrary, dbAnnexLibrary,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryDAOImpl#update({}) : {}",
					annexLibrary.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
