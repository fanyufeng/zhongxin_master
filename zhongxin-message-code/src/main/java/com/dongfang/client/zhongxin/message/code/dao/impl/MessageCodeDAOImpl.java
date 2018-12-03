package com.dongfang.client.zhongxin.message.code.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.message.code.dao.MessageCodeDAO;
import com.dongfang.client.zhongxin.message.code.dao.entity.MessageCode;

@Component
public class MessageCodeDAOImpl extends BaseDao<MessageCode> implements MessageCodeDAO {
	public MessageCode getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(MessageCode.class, id);
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getListMessageCodeReceive(String userId) throws Exception {
		try {
			
			String queryString = "from MessageCode messageCode where messageCode.userId = :userId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("userId",userId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					userId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getListMessageCodeSend(String senderId) throws Exception {
		try {
			
			String queryString = "from MessageCode messageCode where messageCode.senderId = :senderId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("senderId",senderId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					senderId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getListMessageCodeDetail(String commonAttribute) throws Exception {
		try {
			
			String queryString = "from MessageCode messageCode where messageCode.commonAttribute = :commonAttribute ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("commonAttribute",commonAttribute);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					commonAttribute,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	public List<MessageCode> getListMessageCodeAll(String userId,String senderId) throws Exception {
		try {
			
			String queryString = "from MessageCode messageCode where messageCode.userId = :userId and messageCode.senderId= :senderId";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("userId",userId);
			query.setParameter("senderId",senderId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					userId,
					senderId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getByUinonIdEncryption(String unionIdEncryption) throws Exception{
		try {	
			String queryString = "from MessageCode messageCode where messageCode.unionIdEncryption = :unionIdEncryption ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("unionIdEncryption",unionIdEncryption);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					unionIdEncryption,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getByMessageCodeList() throws Exception{
		try {	
			String queryString = "from MessageCode messageCode";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getByTelephone(String telephone) throws Exception{
		try {	
			String queryString = "from MessageCode messageCode where messageCode.telephone = :telephone ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("telephone",telephone);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					telephone,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<MessageCode> getByDepartment(String departmentId) throws Exception{
		try {	
			String queryString = "from MessageCode messageCode where messageCode.departmentId = :departmentId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("departmentId",departmentId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getListMessageCode({}, {}) : {}", 
					departmentId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getByDepartmentId(String departmentId) throws Exception{
		try {	
			String queryString = "from MessageCode messageCode where messageCode.departmentId = :departmentId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("departmentId",departmentId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getByDepartmentId({}, {}) : {}", 
					departmentId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageCode> getByCompanyId(String companyId) throws Exception{
		try {	
			String queryString = "from MessageCode messageCode where messageCode.companyId = :companyId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("companyId",companyId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#getByDepartmentId({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(MessageCode messageCode) throws Exception {
		try {
			Date current = new Date();
			messageCode.setCreateDate(current);
			messageCode.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(messageCode);
			return u;
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#save({}) : {}",
					messageCode.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(MessageCode messageCode) throws Exception {
		try {
			Date current = new Date();
			messageCode.setLastUpdateDate(current);
			MessageCode dbMessageCode = this.getById(messageCode.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(messageCode, dbMessageCode,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("MessageCodeDAOImpl#update({}) : {}",
					messageCode.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
