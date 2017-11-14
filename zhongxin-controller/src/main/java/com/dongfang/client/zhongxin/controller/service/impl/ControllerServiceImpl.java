package com.dongfang.client.zhongxin.controller.service.impl;

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
import com.dongfang.client.zhongxin.controller.converter.ControllerBeanCopierUtil;
import com.dongfang.client.zhongxin.controller.dao.ControllerDAO;
import com.dongfang.client.zhongxin.controller.dao.entity.Controller;
import com.dongfang.client.zhongxin.controller.service.ControllerService;
import com.dongfang.client.zhongxin.controller.vo.ControllerVO;




@Service("controllerService")
@Transactional(rollbackFor={Exception.class})
public class ControllerServiceImpl implements ControllerService {

	public ControllerVO getById(String id) throws Exception {
		try {
			Controller controller = controllerDAO.getById(id);
			if(controller != null) {
				return ControllerBeanCopierUtil.generateVO(controller);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("ControllerServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	
	public List<ControllerVO> getStaffList(String companyId)
			throws Exception{
		try {
			List<Controller> propertyList = controllerDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<ControllerVO> propertyVOList = new ArrayList<ControllerVO>();
				for(Controller property : propertyList) {
					propertyVOList.add(ControllerBeanCopierUtil.generateVO(property));
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
	



	


	

	
	public List<ControllerVO>  getByCompanyId(String companyId) throws Exception{
		try {
			List<Controller> propertyList=new ArrayList<Controller>();
			propertyList = controllerDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<ControllerVO> propertyVOList = new ArrayList<ControllerVO>();
				for(Controller property : propertyList) {
					propertyVOList.add(ControllerBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("ControllerServiceImpl#getByDepartment({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(ControllerVO controllerVO) throws Exception {
		try {
			controllerVO.setId(IDGeneratorUtils.uuid32());
			Controller controller = ControllerBeanCopierUtil.generateEntity(controllerVO);
			String u=controllerDAO.save(controller);
			return u;
		} catch (Exception e) {
			LOGGER.error("ControllerServiceImpl#save({}) : {}",
					controllerVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(ControllerVO controllerVO) throws Exception {
		try {
			Controller controller = ControllerBeanCopierUtil.generateEntity(controllerVO);
			controllerDAO.update(controller);
		} catch (Exception e) {
			LOGGER.error("ControllerServiceImpl#update({}) : {}",
					controllerVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerServiceImpl.class);
	@Autowired
	private ControllerDAO controllerDAO;
}
