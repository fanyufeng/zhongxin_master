package com.dongfang.client.zhongxin.finance.service.impl;

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
import com.dongfang.client.zhongxin.finance.converter.FinanceBeanCopierUtil;
import com.dongfang.client.zhongxin.finance.dao.FinanceDAO;
import com.dongfang.client.zhongxin.finance.dao.entity.Finance;
import com.dongfang.client.zhongxin.finance.service.FinanceService;
import com.dongfang.client.zhongxin.finance.vo.FinanceVO;




@Service("financeService")
@Transactional(rollbackFor={Exception.class})
public class FinanceServiceImpl implements FinanceService {

	public FinanceVO getById(String id) throws Exception {
		try {
			Finance finance = financeDAO.getById(id);
			if(finance != null) {
				return FinanceBeanCopierUtil.generateVO(finance);
			} else {
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("FinanceServiceImpl#getById({}) : {}",
					id,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	
	public List<FinanceVO> getStaffList(String companyId)
			throws Exception{
		try {
			List<Finance> propertyList = financeDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<FinanceVO> propertyVOList = new ArrayList<FinanceVO>();
				for(Finance property : propertyList) {
					propertyVOList.add(FinanceBeanCopierUtil.generateVO(property));
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
	



	


	

	
	public List<FinanceVO>  getByCompanyId(String companyId) throws Exception{
		try {
			List<Finance> propertyList=new ArrayList<Finance>();
			propertyList = financeDAO.getByCompanyId(companyId);
			if(CollectionUtils.isNotEmpty(propertyList)) {
				List<FinanceVO> propertyVOList = new ArrayList<FinanceVO>();
				for(Finance property : propertyList) {
					propertyVOList.add(FinanceBeanCopierUtil.generateVO(property));
				}
				return propertyVOList;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("FinanceServiceImpl#getByDepartment({}, {}) : {}", 
					companyId,
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
		
	}
	public String save(FinanceVO financeVO) throws Exception {
		try {
			financeVO.setId(IDGeneratorUtils.uuid32());
			Finance finance = FinanceBeanCopierUtil.generateEntity(financeVO);
			String u=financeDAO.save(finance);
			return u;
		} catch (Exception e) {
			LOGGER.error("FinanceServiceImpl#save({}) : {}",
					financeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	
	public void update(FinanceVO financeVO) throws Exception {
		try {
			Finance finance = FinanceBeanCopierUtil.generateEntity(financeVO);
			financeDAO.update(finance);
		} catch (Exception e) {
			LOGGER.error("FinanceServiceImpl#update({}) : {}",
					financeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
			throw e;
		}
	}
	

	/**
	  * @Fields LOGGER : 日志记录工具
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceServiceImpl.class);
	@Autowired
	private FinanceDAO financeDAO;
}
