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
	

	
	public List<PersonVO> getStaffList(String companyId)
			throws Exception{
		try {
			List<Person> propertyList = personDAO.getByCompanyId(companyId);
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
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	



	


	

	
	public List<PersonVO>  getByCompanyId(String companyId) throws Exception{
		try {
			List<Person> propertyList=new ArrayList<Person>();
			propertyList = personDAO.getByCompanyId(companyId);
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
			LOGGER.error("PersonServiceImpl#getByDepartment({}, {}) : {}", 
					companyId,
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
	
	
	public PersonVO getByUnionId(String unionId) throws Exception{
		try {
			PersonVO userTelephone=null;
			List<Person> propertyList = personDAO.getByunionId(unionId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<PersonVO> propertyVOList = new ArrayList<PersonVO>();
				for(Person property : propertyList) {
					propertyVOList.add(PersonBeanCopierUtil.generateVO(property));
				}
				for(PersonVO u:propertyVOList){
					 userTelephone=u;
				}
				return userTelephone;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					unionId,
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
