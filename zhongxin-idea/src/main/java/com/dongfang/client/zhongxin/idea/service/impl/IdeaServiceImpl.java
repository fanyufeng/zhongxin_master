package com.dongfang.client.zhongxin.idea.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongfang.client.zhongxin.commons.utils.IDGeneratorUtils;
import com.dongfang.client.zhongxin.idea.converter.IdeaBeanCopierUtil;
import com.dongfang.client.zhongxin.idea.dao.IdeaDAO;
import com.dongfang.client.zhongxin.idea.dao.entity.Idea;
import com.dongfang.client.zhongxin.idea.service.IdeaService;
import com.dongfang.client.zhongxin.idea.vo.IdeaVO;




@Service("ideaService")
@Transactional(rollbackFor={Exception.class})
public class IdeaServiceImpl implements IdeaService {

	public IdeaVO getById(String id) throws Exception {
		try {
			Idea idea = ideaDAO.getById(id);
			if(idea != null) {
				return IdeaBeanCopierUtil.generateVO(idea);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("IdeaServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<IdeaVO>  getByIdeaList(int currentPage,int pageSize) throws Exception{
		try {
			List<Idea> propertyList = ideaDAO.getByIdeaList(currentPage,pageSize);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<IdeaVO> propertyVOList = new ArrayList<IdeaVO>();
				for(Idea property : propertyList) {
					propertyVOList.add(IdeaBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	public List<IdeaVO>  getByStatus(int status) throws Exception{
		try {
			List<Idea> propertyList = ideaDAO.getByStatus(status);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<IdeaVO> propertyVOList = new ArrayList<IdeaVO>();
				for(Idea property : propertyList) {
					propertyVOList.add(IdeaBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	public List<IdeaVO>  getByCategory(String category, int currentPage, int pageSize) throws Exception{
		try {
			List<Idea> propertyList = ideaDAO.getByCategory(category, currentPage, pageSize);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<IdeaVO> propertyVOList = new ArrayList<IdeaVO>();
				for(Idea property : propertyList) {
					propertyVOList.add(IdeaBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public List<IdeaVO>  getByCreaterId(String createrId) throws Exception{
		try {
			List<Idea> propertyList = ideaDAO.getByCreaterId(createrId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<IdeaVO> propertyVOList = new ArrayList<IdeaVO>();
				for(Idea property : propertyList) {
					propertyVOList.add(IdeaBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public List<IdeaVO>  getByRecipientId(String recipientId) throws Exception{
		try {
			List<Idea> propertyList = ideaDAO.getByRecipientId(recipientId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<IdeaVO> propertyVOList = new ArrayList<IdeaVO>();
				for(Idea property : propertyList) {
					propertyVOList.add(IdeaBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(IdeaVO ideaVO) throws Exception {
		try {
			ideaVO.setId(IDGeneratorUtils.uuid32());
			Idea idea = IdeaBeanCopierUtil.generateEntity(ideaVO);
			String u=ideaDAO.save(idea);
			return u;
		} catch (Exception e) {
			LOGGER.error("IdeaServiceImpl#save({}) : {}",
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(IdeaVO ideaVO) throws Exception {
		try {
			Idea idea = IdeaBeanCopierUtil.generateEntity(ideaVO);
			ideaDAO.update(idea);
		} catch (Exception e) {
			LOGGER.error("IdeaServiceImpl#update({}) : {}",
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(IdeaServiceImpl.class);
	@Autowired
	private IdeaDAO ideaDAO;
}
