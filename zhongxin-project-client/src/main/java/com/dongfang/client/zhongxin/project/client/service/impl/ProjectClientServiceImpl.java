package com.dongfang.client.zhongxin.project.client.service.impl;

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
import com.dongfang.client.zhongxin.project.client.converter.ProjectClientBeanCopierUtil;
import com.dongfang.client.zhongxin.project.client.dao.ProjectClientDAO;
import com.dongfang.client.zhongxin.project.client.dao.entity.ProjectClient;
import com.dongfang.client.zhongxin.project.client.service.ProjectClientService;
import com.dongfang.client.zhongxin.project.client.vo.ProjectClientVO;




@Service("projectClientService")
@Transactional(rollbackFor={Exception.class})
public class ProjectClientServiceImpl implements ProjectClientService {

	public ProjectClientVO getById(String id) throws Exception {
		try {
			ProjectClient projectClient = projectClientDAO.getById(id);
			if(projectClient != null) {
				return ProjectClientBeanCopierUtil.generateVO(projectClient);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("ProjectClientServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	
	public List<ProjectClientVO> getStaffList(String companyId)
			throws Exception{
		try {
			List<ProjectClient> propertyList = projectClientDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<ProjectClientVO> propertyVOList = new ArrayList<ProjectClientVO>();
				for(ProjectClient property : propertyList) {
					propertyVOList.add(ProjectClientBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	



	


	

	
	public List<ProjectClientVO>  getByCompanyId(String companyId) throws Exception{
		try {
			List<ProjectClient> propertyList=new ArrayList<ProjectClient>();
			propertyList = projectClientDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<ProjectClientVO> propertyVOList = new ArrayList<ProjectClientVO>();
				for(ProjectClient property : propertyList) {
					propertyVOList.add(ProjectClientBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("ProjectClientServiceImpl#getByDepartment({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(ProjectClientVO projectClientVO) throws Exception {
		try {
			projectClientVO.setId(IDGeneratorUtils.uuid32());
			ProjectClient projectClient = ProjectClientBeanCopierUtil.generateEntity(projectClientVO);
			String u=projectClientDAO.save(projectClient);
			return u;
		} catch (Exception e) {
			LOGGER.error("ProjectClientServiceImpl#save({}) : {}",
					projectClientVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(ProjectClientVO projectClientVO) throws Exception {
		try {
			ProjectClient projectClient = ProjectClientBeanCopierUtil.generateEntity(projectClientVO);
			projectClientDAO.update(projectClient);
		} catch (Exception e) {
			LOGGER.error("ProjectClientServiceImpl#update({}) : {}",
					projectClientVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectClientServiceImpl.class);
	@Autowired
	private ProjectClientDAO projectClientDAO;
}
