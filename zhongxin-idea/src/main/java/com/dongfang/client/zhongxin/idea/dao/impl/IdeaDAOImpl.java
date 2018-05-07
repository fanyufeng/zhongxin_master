package com.dongfang.client.zhongxin.idea.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.dongfang.client.zhongxin.commons.hibernate.BaseDao;
import com.dongfang.client.zhongxin.idea.dao.IdeaDAO;
import com.dongfang.client.zhongxin.idea.dao.entity.Idea;


@Component
public class IdeaDAOImpl extends BaseDao<Idea> implements IdeaDAO {
	public Idea getById(String id) throws Exception {
		try {
			return getHibernateTemplate().get(Idea.class, id);
		} catch (Exception e) {
			LOGGER.error("IdeaDAOImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Idea> getByIdeaList() throws Exception{
		try {	
			String queryString = "from Idea idea";
			org.hibernate.Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString.toString());
			return query.list();
		} catch (Exception e) {
			LOGGER.error("IdeaDAOImpl#getListIdea({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(Idea idea) throws Exception {
		try {
			Date current = new Date();
			idea.setCreateDate(current);
			idea.setLastUpdateDate(current);
			String u=(String)getHibernateTemplate().save(idea);
			return u;
		} catch (Exception e) {
			LOGGER.error("IdeaDAOImpl#save({}) : {}",
					idea.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}

	public void update(Idea idea) throws Exception {
		try {
			Date current = new Date();
			idea.setLastUpdateDate(current);
			Idea dbIdea = this.getById(idea.getId());
			List<String> ignoreList = new ArrayList<String>();
			if(!ArrayUtils.isEmpty(ignoreProperties)) {
				ignoreList.addAll(Arrays.asList(ignoreProperties));
			}
			//更新商品数据
			updatePartly(idea, dbIdea,
					null, 
					ignoreList,
					true);
		} catch (Exception e) {
			LOGGER.error("IdeaDAOImpl#update({}) : {}",
					idea.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
}
