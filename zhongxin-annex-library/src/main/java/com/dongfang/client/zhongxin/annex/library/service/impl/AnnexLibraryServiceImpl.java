package com.dongfang.client.zhongxin.annex.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongfang.client.zhongxin.annex.library.converter.AnnexLibraryBeanCopierUtil;
import com.dongfang.client.zhongxin.annex.library.dao.AnnexLibraryDAO;
import com.dongfang.client.zhongxin.annex.library.dao.entity.AnnexLibrary;
import com.dongfang.client.zhongxin.annex.library.service.AnnexLibraryService;
import com.dongfang.client.zhongxin.annex.library.vo.AnnexLibraryVO;
import com.dongfang.client.zhongxin.commons.utils.IDGeneratorUtils;


@Service("annexLibraryService")
@Transactional(rollbackFor={Exception.class})
public class AnnexLibraryServiceImpl implements AnnexLibraryService {

	public AnnexLibraryVO getById(String id) throws Exception {
		try {
			AnnexLibrary annexLibrary = annexLibraryDAO.getById(id);
			if(annexLibrary != null) {
				return AnnexLibraryBeanCopierUtil.generateVO(annexLibrary);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public List<AnnexLibraryVO> getList(String telephone,String passWord)
			throws Exception {
		try {
			List<AnnexLibrary> propertyList = annexLibraryDAO.getListAnnexLibrary(telephone,passWord);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					telephone,
					passWord,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	

	public List<AnnexLibraryVO> getByPersonId(String personId) throws Exception{
		try {
			List<AnnexLibrary> propertyList = annexLibraryDAO.getByPersonId(personId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#getList({}, {}) : {}", 
					personId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}

	public List<AnnexLibraryVO> getByAnnexLibraryatorId(String annexLibraryatorId) throws Exception{
		try {
			List<AnnexLibrary> propertyList = annexLibraryDAO.getByAnnexLibraryatorId(annexLibraryatorId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
				}
				
				return propertyVOList;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#getList({}, {}) : {}", 
					annexLibraryatorId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	public AnnexLibraryVO getByUnionIdEncryption(String unionIdEncryption) throws Exception{
		try {
			AnnexLibraryVO userTelephone=null;
			List<AnnexLibrary> propertyList = annexLibraryDAO.getByUinonIdEncryption(unionIdEncryption);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
				}
				for(AnnexLibraryVO u:propertyVOList){
					 userTelephone=u;
				}
				return userTelephone;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					unionIdEncryption,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public List<AnnexLibraryVO>  getByAnnexLibraryList() throws Exception{
		try {
			List<AnnexLibrary> propertyList = annexLibraryDAO.getByAnnexLibraryList();
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
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
	
	public List<AnnexLibraryVO>  getByDepartment(String departmentId) throws Exception{
		try {
			List<AnnexLibrary> propertyList=new ArrayList<AnnexLibrary>();
			propertyList = annexLibraryDAO.getByDepartmentId(departmentId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#getByDepartment({}, {}) : {}", 
					departmentId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	
	public List<AnnexLibraryVO>  getByideaIdEmployeeId(String ideaId,String annexLibraryatorId) throws Exception{
		try {
			List<AnnexLibrary> propertyList=new ArrayList<AnnexLibrary>();
			propertyList = annexLibraryDAO.getByideaIdEmployeeId(ideaId, annexLibraryatorId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<AnnexLibraryVO> propertyVOList = new ArrayList<AnnexLibraryVO>();
				for(AnnexLibrary property : propertyList) {
					propertyVOList.add(AnnexLibraryBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#getByDepartment({}, {}) : {}", 
					ideaId,
					annexLibraryatorId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(AnnexLibraryVO annexLibraryVO) throws Exception {
		try {
			annexLibraryVO.setId(IDGeneratorUtils.uuid32());
			AnnexLibrary annexLibrary = AnnexLibraryBeanCopierUtil.generateEntity(annexLibraryVO);
			String u=annexLibraryDAO.save(annexLibrary);
			return u;
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#save({}) : {}",
					annexLibraryVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(AnnexLibraryVO annexLibraryVO) throws Exception {
		try {
			AnnexLibrary annexLibrary = AnnexLibraryBeanCopierUtil.generateEntity(annexLibraryVO);
			annexLibraryDAO.update(annexLibrary);
		} catch (Exception e) {
			LOGGER.error("AnnexLibraryServiceImpl#update({}) : {}",
					annexLibraryVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnexLibraryServiceImpl.class);
	@Autowired
	private AnnexLibraryDAO annexLibraryDAO;
}
