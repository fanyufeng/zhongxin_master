package com.dongfang.client.zhongxin.leave.message.reply;

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

import com.dongfang.client.zhongxin.leave.message.reply.service.LeaveMessageReplyService;
import com.dongfang.client.zhongxin.leave.message.reply.vo.LeaveMessageReplyVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class LeaveMessageReplyServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
			leaveMessageReplyVO.setId("123");
			leaveMessageReplyVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			leaveMessageReplyService.save(leaveMessageReplyVO);
			LOGGER.info("员工添加成功,{}", leaveMessageReplyVO.toString());
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
			LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
			leaveMessageReplyVO.setId("4028101054e2355a0154e2355c260000");
			
			leaveMessageReplyService.update(leaveMessageReplyVO);
			LOGGER.info("员工修改成功,{}", leaveMessageReplyVO.toString());
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
			List<LeaveMessageReplyVO> leaveMessageReplyVO = new ArrayList<LeaveMessageReplyVO>();
			//leaveMessageReplyVO.setId("4028ad8152b479d40152b479d6ec0001");
			//leaveMessageReplyVO.setName("testUpdate");
			String telephone ="15201315375";
			String passWord ="fyf820912";
		//	leaveMessageReplyVO =leaveMessageReplyService.getList(telephone,passWord);
			
			//System.out.println("result ="+ leaveMessageReplyVO);
			LOGGER.info("员工修改成功,{}", leaveMessageReplyVO.toString());
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
			List<LeaveMessageReplyVO> leaveMessageReplyVO = new ArrayList<LeaveMessageReplyVO>();
			String company ="duode";
		//	leaveMessageReplyVO =leaveMessageReplyService.getStaffList(company);
			
			LOGGER.info("员工修改成功,{}", leaveMessageReplyVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberLeaveMessageReply() {
		try {
			LeaveMessageReplyVO leaveMessageReplyVO = null;
			String telephone ="15201315375";
	//		leaveMessageReplyVO =leaveMessageReplyService.getByTelephone(telephone);
			System.out.println("result ="+ leaveMessageReplyVO);
			LOGGER.info("员工修改成功,{}", leaveMessageReplyVO.toString());
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
				LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
				leaveMessageReplyVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
				leaveMessageReplyService.save(leaveMessageReplyVO);
				LOGGER.info("员工{}添加成功,{}", i, leaveMessageReplyVO.toString());
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
			LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
			leaveMessageReplyVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			leaveMessageReplyService.save(leaveMessageReplyVO);
			LOGGER.info("员工添加成功,{}", leaveMessageReplyVO.toString());
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
			LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
			leaveMessageReplyVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			leaveMessageReplyService.save(leaveMessageReplyVO);
			LOGGER.info("员工添加成功,{}", leaveMessageReplyVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankLeaveMessageReply() {
		try {
			LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
			//leaveMessageReplyVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//leaveMessageReplyVO.setName("test");
		
		    List<LeaveMessageReplyVO> leaveMessageReplyList=new ArrayList<LeaveMessageReplyVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", leaveMessageReplyVO.toString());
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
			LeaveMessageReplyVO leaveMessageReplyVO=new LeaveMessageReplyVO();
	
			
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
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMessageReplyServiceTest.class);
	@Autowired
	public LeaveMessageReplyService leaveMessageReplyService;
	
}
