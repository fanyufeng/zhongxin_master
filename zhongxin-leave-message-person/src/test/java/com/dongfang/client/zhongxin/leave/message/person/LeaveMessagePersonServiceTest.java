package com.dongfang.client.zhongxin.leave.message.person;

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

import com.dongfang.client.zhongxin.leave.message.person.service.LeaveMessagePersonService;
import com.dongfang.client.zhongxin.leave.message.person.vo.LeaveMessagePersonVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class LeaveMessagePersonServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
			leaveMessagePersonVO.setId("123");
			leaveMessagePersonVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			leaveMessagePersonService.save(leaveMessagePersonVO);
			LOGGER.info("员工添加成功,{}", leaveMessagePersonVO.toString());
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
			LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
			leaveMessagePersonVO.setId("4028101054e2355a0154e2355c260000");
			
			leaveMessagePersonService.update(leaveMessagePersonVO);
			LOGGER.info("员工修改成功,{}", leaveMessagePersonVO.toString());
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
			List<LeaveMessagePersonVO> leaveMessagePersonVO = new ArrayList<LeaveMessagePersonVO>();
			//leaveMessagePersonVO.setId("4028ad8152b479d40152b479d6ec0001");
			//leaveMessagePersonVO.setName("testUpdate");
			String telephone ="15201315375";
			String passWord ="fyf820912";
			//leaveMessagePersonVO =leaveMessagePersonService.getList(telephone,passWord);
			
			//System.out.println("result ="+ leaveMessagePersonVO);
			LOGGER.info("员工修改成功,{}", leaveMessagePersonVO.toString());
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
			List<LeaveMessagePersonVO> leaveMessagePersonVO = new ArrayList<LeaveMessagePersonVO>();
			String company ="duode";
			//leaveMessagePersonVO =leaveMessagePersonService.getStaffList(company);
			
			LOGGER.info("员工修改成功,{}", leaveMessagePersonVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberLeaveMessagePerson() {
		try {
			LeaveMessagePersonVO leaveMessagePersonVO = null;
			String telephone ="15201315375";
			System.out.println("result ="+ leaveMessagePersonVO);
			LOGGER.info("员工修改成功,{}", leaveMessagePersonVO.toString());
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
				LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
				leaveMessagePersonVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
			//	leaveMessagePersonService.save(leaveMessagePersonVO);
				LOGGER.info("员工{}添加成功,{}", i, leaveMessagePersonVO.toString());
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
			LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
			leaveMessagePersonVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			leaveMessagePersonService.save(leaveMessagePersonVO);
			LOGGER.info("员工添加成功,{}", leaveMessagePersonVO.toString());
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
			LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
			leaveMessagePersonVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			//leaveMessagePersonService.save(leaveMessagePersonVO);
			LOGGER.info("员工添加成功,{}", leaveMessagePersonVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankLeaveMessagePerson() {
		try {
			LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
			//leaveMessagePersonVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//leaveMessagePersonVO.setName("test");
		
		    List<LeaveMessagePersonVO> leaveMessagePersonList=new ArrayList<LeaveMessagePersonVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", leaveMessagePersonVO.toString());
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
			LeaveMessagePersonVO leaveMessagePersonVO=new LeaveMessagePersonVO();
	
			
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
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessagePersonServiceTest.class);
	@Autowired
	public LeaveMessagePersonService leaveMessagePersonService;
	
}
