package com.dongfang.client.zhongxin.finance.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.finance.dao.FinanceDAO;
import com.dongfang.client.zhongxin.finance.dao.entity.Finance;


@Component
public class FinanceDAOImpl extends BaseDao<Finance> implements FinanceDAO {
	public Finance getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(Finance.class, id);
		} catch (Exception e) {
			LOGGER.error("FinanceDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Finance> getByCompanyId(String companyId) throws Exception{
		try {	
			String queryString = "from Finance finance where finance.companyId = :companyId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("companyId",companyId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("FinanceDAOImpl#getByDepartmentId({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(Finance finance) throws Exception {
		try {
			Date current = new Date();
			finance.setCreateDate(current);
			finance.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(finance);
			return u;
		} catch (Exception e) {
			LOGGER.error("FinanceDAOImpl#save({}) : {}",
					finance.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(Finance finance) throws Exception {
		try {
			Date current = new Date();
			finance.setLastUpdateDate(current);
			Finance dbFinance = this.getById(finance.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(finance, dbFinance,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("FinanceDAOImpl#update({}) : {}",
					finance.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
