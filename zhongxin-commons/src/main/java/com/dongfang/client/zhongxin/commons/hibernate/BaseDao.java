package com.dongfang.client.zhongxin.commons.hibernate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dongfang.client.zhongxin.commons.utils.MyBeanUtils;


public abstract class BaseDao<T> {
	
	/**
	  * 部分更新
	  * @param object
	  * @param updatePropertyList
	  * @param ignorePropertyList
	  * @param isAllowReset
	  * @throws SOAServiceException 
	  */
	public void updatePartly(T updateObject, T dbObject,
			List<String> updatePropertyList, List<String> ignorePropertyList,
			Boolean isAllowReset) throws Exception {
		try{
			ignorePropertyList = MyBeanUtils.ignoreProperties(updateObject, updatePropertyList, ignorePropertyList, isAllowReset);
			BeanUtils.copyProperties(updateObject, dbObject, ignorePropertyList.toArray(new String[0]));
			this.getHibernateTemplate().update(dbObject);
		} catch (Exception e) {
			LOGGER.error("BaseDao#updatePartly({}, {}, {}, {}, {}) : {}", 
					updateObject != null?updateObject.toString() : "null", 
					dbObject != null?dbObject.toString():"null",
					CollectionUtils.isEmpty(updatePropertyList)?"null" : Arrays.toString(updatePropertyList.toArray(new String[0])) ,
					CollectionUtils.isEmpty(ignorePropertyList)?"null" : Arrays.toString(ignorePropertyList.toArray(new String[0])),
					BooleanUtils.toString(isAllowReset, "true", "false", "null"),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
