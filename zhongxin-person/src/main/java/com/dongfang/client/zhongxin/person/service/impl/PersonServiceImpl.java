package com.dongfang.client.zhongxin.person.service.impl;

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
import com.dongfang.client.zhongxin.person.converter.PersonBeanCopierUtil;
import com.dongfang.client.zhongxin.person.dao.PersonDAO;
import com.dongfang.client.zhongxin.person.dao.entity.Person;
import com.dongfang.client.zhongxin.person.service.PersonService;
import com.dongfang.client.zhongxin.person.vo.PersonVO;




@Service("personService")
@Transactional(rollbackFor={Exception.class})
public class PersonServiceImpl implements PersonService {

	public PersonVO getById(String id) throws Exception {
		try {
			Person person = personDAO.getById(id);
			if(person != null) {
				return PersonBeanCopierUtil.generateVO(person);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("PersonServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	public List<PersonVO>  getByPersonList(int currentPage, int pageSize) throws Exception{
		try {
			List<Person> propertyList = personDAO.getByPersonList(currentPage, pageSize);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<PersonVO> propertyVOList = new ArrayList<PersonVO>();
				for(Person property : propertyList) {
					propertyVOList.add(PersonBeanCopierUtil.generateVO(property));
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
	
	public List<PersonVO>  getByStatus(int status) throws Exception{
		try {
			List<Person> propertyList = personDAO.getByStatus(status);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<PersonVO> propertyVOList = new ArrayList<PersonVO>();
				for(Person property : propertyList) {
					propertyVOList.add(PersonBeanCopierUtil.generateVO(property));
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
	

	public List<PersonVO>  getByCategory(String category, int currentPage, int pageSize) throws Exception{
		try {
			List<Person> propertyList = personDAO.getByCategory(category, currentPage, pageSize);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<PersonVO> propertyVOList = new ArrayList<PersonVO>();
				for(Person property : propertyList) {
					propertyVOList.add(PersonBeanCopierUtil.generateVO(property));
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
	
	public List<PersonVO>  getByCreaterId(String createrId) throws Exception{
		try {
			List<Person> propertyList = personDAO.getByCreaterId(createrId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<PersonVO> propertyVOList = new ArrayList<PersonVO>();
				for(Person property : propertyList) {
					propertyVOList.add(PersonBeanCopierUtil.generateVO(property));
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

	


	

	
	
	public String save(PersonVO personVO) throws Exception {
		try {
			personVO.setId(IDGeneratorUtils.uuid32());
			Person person = PersonBeanCopierUtil.generateEntity(personVO);
			String u=personDAO.save(person);
			return u;
		} catch (Exception e) {
			LOGGER.error("PersonServiceImpl#save({}) : {}",
					personVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(PersonVO personVO) throws Exception {
		try {
			Person person = PersonBeanCopierUtil.generateEntity(personVO);
			personDAO.update(person);
		} catch (Exception e) {
			LOGGER.error("PersonServiceImpl#update({}) : {}",
					personVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
	@Autowired
	private PersonDAO personDAO;
}
