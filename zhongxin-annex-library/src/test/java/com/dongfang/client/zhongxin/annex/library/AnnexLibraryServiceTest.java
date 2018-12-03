package com.dongfang.client.zhongxin.annex.library;

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

import com.dongfang.client.zhongxin.annex.library.service.AnnexLibraryService;
import com.dongfang.client.zhongxin.annex.library.vo.AnnexLibraryVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class AnnexLibraryServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
			annexLibraryVO.setId("123");
			annexLibraryVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			annexLibraryService.save(annexLibraryVO);
			LOGGER.info("员工添加成功,{}", annexLibraryVO.toString());
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
			AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
			annexLibraryVO.setId("4028101054e2355a0154e2355c260000");
			
			annexLibraryService.update(annexLibraryVO);
			LOGGER.info("员工修改成功,{}", annexLibraryVO.toString());
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
			List<AnnexLibraryVO> annexLibraryVO = new ArrayList<AnnexLibraryVO>();
			//annexLibraryVO.setId("4028ad8152b479d40152b479d6ec0001");
			//annexLibraryVO.setName("testUpdate");
			String telephone ="15201315375";
			String passWord ="fyf820912";
			annexLibraryVO =annexLibraryService.getList(telephone,passWord);
			
			//System.out.println("result ="+ annexLibraryVO);
			LOGGER.info("员工修改成功,{}", annexLibraryVO.toString());
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
			List<AnnexLibraryVO> annexLibraryVO = new ArrayList<AnnexLibraryVO>();
			String company ="duode";
		//	annexLibraryVO =annexLibraryService.getStaffList(company);
			
			LOGGER.info("员工修改成功,{}", annexLibraryVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberAnnexLibrary() {
		try {
			AnnexLibraryVO annexLibraryVO = null;
			String telephone ="15201315375";
	//		annexLibraryVO =annexLibraryService.getByTelephone(telephone);
			System.out.println("result ="+ annexLibraryVO);
			LOGGER.info("员工修改成功,{}", annexLibraryVO.toString());
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
				AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
				annexLibraryVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
				annexLibraryService.save(annexLibraryVO);
				LOGGER.info("员工{}添加成功,{}", i, annexLibraryVO.toString());
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
			AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
			annexLibraryVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			annexLibraryService.save(annexLibraryVO);
			LOGGER.info("员工添加成功,{}", annexLibraryVO.toString());
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
			AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
			annexLibraryVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			annexLibraryService.save(annexLibraryVO);
			LOGGER.info("员工添加成功,{}", annexLibraryVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankAnnexLibrary() {
		try {
			AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
			//annexLibraryVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//annexLibraryVO.setName("test");
		
		    List<AnnexLibraryVO> annexLibraryList=new ArrayList<AnnexLibraryVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", annexLibraryVO.toString());
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
			AnnexLibraryVO annexLibraryVO=new AnnexLibraryVO();
	
			
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
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnexLibraryServiceTest.class);
	@Autowired
	public AnnexLibraryService annexLibraryService;
	
}
