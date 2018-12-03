package com.dongfang.client.zhongxin.leave.message;

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

import com.dongfang.client.zhongxin.leave.message.service.LeaveMessageService;
import com.dongfang.client.zhongxin.leave.message.vo.LeaveMessageVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class LeaveMessageServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
			leaveMessageVO.setId("123");
			leaveMessageVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			leaveMessageService.save(leaveMessageVO);
			LOGGER.info("员工添加成功,{}", leaveMessageVO.toString());
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
			LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
			leaveMessageVO.setId("4028101054e2355a0154e2355c260000");
			
			leaveMessageService.update(leaveMessageVO);
			LOGGER.info("员工修改成功,{}", leaveMessageVO.toString());
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
			List<LeaveMessageVO> leaveMessageVO = new ArrayList<LeaveMessageVO>();
			//leaveMessageVO.setId("4028ad8152b479d40152b479d6ec0001");
			//leaveMessageVO.setName("testUpdate");
			String telephone ="15201315375";
			String passWord ="fyf820912";
			//leaveMessageVO =leaveMessageService.getList(telephone,passWord);
			
			//System.out.println("result ="+ leaveMessageVO);
			LOGGER.info("员工修改成功,{}", leaveMessageVO.toString());
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
			List<LeaveMessageVO> leaveMessageVO = new ArrayList<LeaveMessageVO>();
			String company ="duode";
			//leaveMessageVO =leaveMessageService.getStaffList(company);
			
			LOGGER.info("员工修改成功,{}", leaveMessageVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberLeaveMessage() {
		try {
			LeaveMessageVO leaveMessageVO = null;
			String telephone ="15201315375";
			System.out.println("result ="+ leaveMessageVO);
			LOGGER.info("员工修改成功,{}", leaveMessageVO.toString());
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
				LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
				leaveMessageVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
			//	leaveMessageService.save(leaveMessageVO);
				LOGGER.info("员工{}添加成功,{}", i, leaveMessageVO.toString());
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
			LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
			leaveMessageVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			leaveMessageService.save(leaveMessageVO);
			LOGGER.info("员工添加成功,{}", leaveMessageVO.toString());
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
			LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
			leaveMessageVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			//leaveMessageService.save(leaveMessageVO);
			LOGGER.info("员工添加成功,{}", leaveMessageVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankLeaveMessage() {
		try {
			LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
			//leaveMessageVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//leaveMessageVO.setName("test");
		
		    List<LeaveMessageVO> leaveMessageList=new ArrayList<LeaveMessageVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", leaveMessageVO.toString());
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
			LeaveMessageVO leaveMessageVO=new LeaveMessageVO();
	
			
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
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessageServiceTest.class);
	@Autowired
	public LeaveMessageService leaveMessageService;
	
}
