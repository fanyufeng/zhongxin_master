package com.dongfang.client.zhongxin.employee.service.impl;

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
import com.dongfang.client.zhongxin.employee.converter.EmployeeBeanCopierUtil;
import com.dongfang.client.zhongxin.employee.dao.EmployeeDAO;
import com.dongfang.client.zhongxin.employee.dao.entity.Employee;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;




@Service("employeeService")
@Transactional(rollbackFor={Exception.class})
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeVO getById(String id) throws Exception {
		try {
			Employee employee = employeeDAO.getById(id);
			if(employee != null) {
				return EmployeeBeanCopierUtil.generateVO(employee);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("EmployeeServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	
	public List<EmployeeVO> getStaffList(String companyId)
			throws Exception{
		try {
			List<Employee> propertyList = employeeDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<EmployeeVO> propertyVOList = new ArrayList<EmployeeVO>();
				for(Employee property : propertyList) {
					propertyVOList.add(EmployeeBeanCopierUtil.generateVO(property));
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
	



	


	

	
	public List<EmployeeVO>  getByCompanyId(String companyId) throws Exception{
		try {
			List<Employee> propertyList=new ArrayList<Employee>();
			propertyList = employeeDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<EmployeeVO> propertyVOList = new ArrayList<EmployeeVO>();
				for(Employee property : propertyList) {
					propertyVOList.add(EmployeeBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("EmployeeServiceImpl#getByDepartment({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(EmployeeVO employeeVO) throws Exception {
		try {
			employeeVO.setId(IDGeneratorUtils.uuid32());
			Employee employee = EmployeeBeanCopierUtil.generateEntity(employeeVO);
			String u=employeeDAO.save(employee);
			return u;
		} catch (Exception e) {
			LOGGER.error("EmployeeServiceImpl#save({}) : {}",
					employeeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(EmployeeVO employeeVO) throws Exception {
		try {
			Employee employee = EmployeeBeanCopierUtil.generateEntity(employeeVO);
			employeeDAO.update(employee);
		} catch (Exception e) {
			LOGGER.error("EmployeeServiceImpl#update({}) : {}",
					employeeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	
	public EmployeeVO getByUnionId(String unionId) throws Exception{
		try {
			EmployeeVO userTelephone=null;
			List<Employee> propertyList = employeeDAO.getByunionId(unionId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<EmployeeVO> propertyVOList = new ArrayList<EmployeeVO>();
				for(Employee property : propertyList) {
					propertyVOList.add(EmployeeBeanCopierUtil.generateVO(property));
				}
				for(EmployeeVO u:propertyVOList){
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
	
	public EmployeeVO getByopenid(String openid) throws Exception{
		try {
			EmployeeVO userTelephone=null;
			List<Employee> propertyList = employeeDAO.getByopenid(openid);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<EmployeeVO> propertyVOList = new ArrayList<EmployeeVO>();
				for(Employee property : propertyList) {
					propertyVOList.add(EmployeeBeanCopierUtil.generateVO(property));
				}
				for(EmployeeVO u:propertyVOList){
					 userTelephone=u;
				}
				return userTelephone;
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("CustomPropertyServiceImpl#getList({}, {}) : {}", 
					openid,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeDAO employeeDAO;
}
