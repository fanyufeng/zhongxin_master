package com.dongfang.client.zhongxin.college.service.impl;

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
import com.dongfang.client.zhongxin.college.converter.CollegeBeanCopierUtil;
import com.dongfang.client.zhongxin.college.dao.CollegeDAO;
import com.dongfang.client.zhongxin.college.dao.entity.College;
import com.dongfang.client.zhongxin.college.service.CollegeService;
import com.dongfang.client.zhongxin.college.vo.CollegeVO;




@Service("collegeService")
@Transactional(rollbackFor={Exception.class})
public class CollegeServiceImpl implements CollegeService {

	public CollegeVO getById(String id) throws Exception {
		try {
			College college = collegeDAO.getById(id);
			if(college != null) {
				return CollegeBeanCopierUtil.generateVO(college);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CollegeServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	public List<CollegeVO>  getByCollegeList() throws Exception{
		try {
			List<College> propertyList = collegeDAO.getByCollegeList();
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<CollegeVO> propertyVOList = new ArrayList<CollegeVO>();
				for(College property : propertyList) {
					propertyVOList.add(CollegeBeanCopierUtil.generateVO(property));
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
	
	public List<CollegeVO>  getByStatus(int status) throws Exception{
		try {
			List<College> propertyList = collegeDAO.getByStatus(status);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<CollegeVO> propertyVOList = new ArrayList<CollegeVO>();
				for(College property : propertyList) {
					propertyVOList.add(CollegeBeanCopierUtil.generateVO(property));
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
	



	


	

	
	
	public String save(CollegeVO collegeVO) throws Exception {
		try {
			collegeVO.setId(IDGeneratorUtils.uuid32());
			College college = CollegeBeanCopierUtil.generateEntity(collegeVO);
			String u=collegeDAO.save(college);
			return u;
		} catch (Exception e) {
			LOGGER.error("CollegeServiceImpl#save({}) : {}",
					collegeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(CollegeVO collegeVO) throws Exception {
		try {
			College college = CollegeBeanCopierUtil.generateEntity(collegeVO);
			collegeDAO.update(college);
		} catch (Exception e) {
			LOGGER.error("CollegeServiceImpl#update({}) : {}",
					collegeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(CollegeServiceImpl.class);
	@Autowired
	private CollegeDAO collegeDAO;
}
