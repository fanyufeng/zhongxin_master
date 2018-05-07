package com.dongfang.client.zhongxin.employee;

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

import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class EmployeeServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setId("123");
			employeeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			employeeService.save(employeeVO);
			LOGGER.info("员工添加成功,{}", employeeVO.toString());
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
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setId("4028101054e2355a0154e2355c260000");
			
			employeeService.update(employeeVO);
			LOGGER.info("员工修改成功,{}", employeeVO.toString());
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
			List<EmployeeVO> employeeVO = new ArrayList<EmployeeVO>();
			String company ="duode";
			employeeVO =employeeService.getStaffList(company);
			
			LOGGER.info("员工修改成功,{}", employeeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberEmployee() {
		try {
			EmployeeVO employeeVO = null;
			String telephone ="15201315375";
			//employeeVO =employeeService.getByTelephone(telephone);
			System.out.println("result ="+ employeeVO);
			LOGGER.info("员工修改成功,{}", employeeVO.toString());
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
				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
				employeeService.save(employeeVO);
				LOGGER.info("员工{}添加成功,{}", i, employeeVO.toString());
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
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			employeeService.save(employeeVO);
			LOGGER.info("员工添加成功,{}", employeeVO.toString());
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
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			employeeService.save(employeeVO);
			LOGGER.info("员工添加成功,{}", employeeVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankEmployee() {
		try {
			EmployeeVO employeeVO = new EmployeeVO();
			//employeeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//employeeVO.setName("test");
		
		    List<EmployeeVO> employeeList=new ArrayList<EmployeeVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", employeeVO.toString());
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
			EmployeeVO employeeVO=new EmployeeVO();
	
			
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
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceTest.class);
	@Autowired
	public EmployeeService employeeService;
}
