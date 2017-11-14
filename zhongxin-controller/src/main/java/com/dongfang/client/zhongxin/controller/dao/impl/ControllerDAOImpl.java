package com.dongfang.client.zhongxin.controller.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.controller.dao.ControllerDAO;
import com.dongfang.client.zhongxin.controller.dao.entity.Controller;


@Component
public class ControllerDAOImpl extends BaseDao<Controller> implements ControllerDAO {
	public Controller getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(Controller.class, id);
		} catch (Exception e) {
			LOGGER.error("ControllerDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Controller> getByCompanyId(String companyId) throws Exception{
		try {	
			String queryString = "from Controller controller where controller.companyId = :companyId ";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			query.setParameter("companyId",companyId);
			return query.list();
		} catch (Exception e) {
			LOGGER.error("ControllerDAOImpl#getByDepartmentId({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	
	public String save(Controller controller) throws Exception {
		try {
			Date current = new Date();
			controller.setCreateDate(current);
			controller.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(controller);
			return u;
		} catch (Exception e) {
			LOGGER.error("ControllerDAOImpl#save({}) : {}",
					controller.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(Controller controller) throws Exception {
		try {
			Date current = new Date();
			controller.setLastUpdateDate(current);
			Controller dbController = this.getById(controller.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(controller, dbController,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("ControllerDAOImpl#update({}) : {}",
					controller.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
