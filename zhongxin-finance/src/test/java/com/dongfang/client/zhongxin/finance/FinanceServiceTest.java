package com.dongfang.client.zhongxin.finance;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongfang.client.zhongxin.finance.service.FinanceService;
import com.dongfang.client.zhongxin.finance.vo.FinanceVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class FinanceServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			FinanceVO financeVO = new FinanceVO();
			financeVO.setId("123");
			financeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			financeService.save(financeVO);
			LOGGER.info("员工添加成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
 	}
	
	/**
	  * update方法测试 
	  */
	@Ignore
	@Test
	public final void testUpdate() {
		try {
			FinanceVO financeVO = new FinanceVO();
			financeVO.setId("4028101054e2355a0154e2355c260000");
			
			financeService.update(financeVO);
			LOGGER.info("员工修改成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumber() {
		try {

		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	
	/**
	  * 根据公司名称查询员工列表方法测试 
	  */
	@Test
	@Ignore
	public final void testByCompany() {
		try {
			List<FinanceVO> financeVO = new ArrayList<FinanceVO>();
			String company ="duode";
			financeVO =financeService.getStaffList(company);
			
			LOGGER.info("员工修改成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberFinance() {
		try {
			FinanceVO financeVO = null;
			String telephone ="15201315375";
			//financeVO =financeService.getByTelephone(telephone);
			System.out.println("result ="+ financeVO);
			LOGGER.info("员工修改成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  *  添加员工
	  */
	@Ignore
	@Test
	public final void testCircleSave() {
		try {
			for(int i = 0; i < 10000; i++) {
				FinanceVO financeVO = new FinanceVO();
				financeVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
				financeService.save(financeVO);
				LOGGER.info("员工{}添加成功,{}", i, financeVO.toString());
			}
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 添加员工(含自定义属性) 
	  */
	@Test
	@Ignore
	public final void testSaveWithCustomProperty() {
		try {
			FinanceVO financeVO = new FinanceVO();
			financeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			financeService.save(financeVO);
			LOGGER.info("员工添加成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 添加员工(含自定义属性) 
	  */
	@Test
	@Ignore
	public final void testSaveWithChecker() {
		try {
			FinanceVO financeVO = new FinanceVO();
			financeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			financeService.save(financeVO);
			LOGGER.info("员工添加成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankFinance() {
		try {
			FinanceVO financeVO = new FinanceVO();
			//financeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//financeVO.setName("test");
		
		    List<FinanceVO> financeList=new ArrayList<FinanceVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", financeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 添加员工(含自定义属性) 
	  */
	@Test
	@Ignore
	public final void testGetByDepartmentIdWithCustomProperty() {
		try {
			FinanceVO financeVO=new FinanceVO();
	
			
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}

	
	
	@Test
	@Ignore
	public final void createTbl() {
		LOGGER.info("Table creates Successfully");
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceServiceTest.class);
	@Autowired
	public FinanceService financeService;
	
}
