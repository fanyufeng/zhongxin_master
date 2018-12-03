package com.dongfang.client.zhongxin.mail.message.code.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.mail.message.code.dao.MailMessageCodeDAO;
import com.dongfang.client.zhongxin.mail.message.code.dao.entity.MailMessageCode;





@Component
public class MailMessageCodeDAOImpl  extends BaseDao<MailMessageCode> implements MailMessageCodeDAO {
	public MailMessageCode getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(MailMessageCode.class, id);
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MailMessageCode> getList(String belong, String type) throws Exception {
		try {
			if(StringUtils.isBlank(belong) ||
					StringUtils.isBlank(type)) {
				return null;
			}
			String queryString = "from CustomProperty customProperty where customProperty.belong = :belong and customProperty.type = :type";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("belong", belong);
			query.setParameter("type", type);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#getList({}, {}) : {}", 
					belong,
					type,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MailMessageCode> getByFormId(String belongFormId,String mailMessageCodeId) throws Exception{
		try {	
			String queryString = "from MailMessageCode mailMessageCode where mailMessageCode.belongFormId = :belongFormId and mailMessageCode.mailMessageCodeId= :mailMessageCodeId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("belongFormId",belongFormId);
			query.setParameter("mailMessageCodeId",mailMessageCodeId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getListEmployee({}, {}) : {}", 
					belongFormId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<MailMessageCode> getByEmail(String email) throws Exception{
		try {	
			String queryString = "from MailMessageCode mailMessageCode where mailMessageCode.email = :email  ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("email",email);
			
			return query.list();
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getListEmployee({}, {}) : {}", 
					email,

					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MailMessageCode> getByMailMessageCodeId(String mailMessageCodeId) throws Exception{
		try {	
			String queryString = "from MailMessageCode mailMessageCode where mailMessageCode.mailMessageCodeId = :mailMessageCodeId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("mailMessageCodeId",mailMessageCodeId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("EmployeeDAOImpl#getListEmployee({}, {}) : {}", 
					mailMessageCodeId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}

	public  String  save(MailMessageCode customProperty) throws Exception {
		try {
			Date current = new Date();
			customProperty.setCreateDate(current);
			customProperty.setLastUpdateDate(current);
		    String u=(String)getHibernateTemplate().save(customProperty);
		    return u;
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#save({}) : {}",
					customProperty.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(MailMessageCode customProperty) throws Exception {
		try {
			Date current = new Date();
			customProperty.setLastUpdateDate(current);
			MailMessageCode dbCustomProperty = this.getById(customProperty.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(customProperty, dbCustomProperty,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("CustomPropertyDAOImpl#update({}) : {}",
					customProperty.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}

