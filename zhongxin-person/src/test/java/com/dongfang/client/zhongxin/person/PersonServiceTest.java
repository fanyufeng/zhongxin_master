package com.dongfang.client.zhongxin.person;

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

import com.dongfang.client.zhongxin.person.service.PersonService;
import com.dongfang.client.zhongxin.person.vo.PersonVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class PersonServiceTest extends
		AbstractJUnit4SpringContextTests {
	
	/**
	  * save方法测试 
	  */
	
	@Test
	@Ignore
	public final void testSave() {
		try {
			PersonVO personVO = new PersonVO();
			personVO.setId("123");
			personVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			personService.save(personVO);
			LOGGER.info("员工添加成功,{}", personVO.toString());
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
			PersonVO personVO = new PersonVO();
			personVO.setId("4028101054e2355a0154e2355c260000");
			
			personService.update(personVO);
			LOGGER.info("员工修改成功,{}", personVO.toString());
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
			List<PersonVO> personVO = new ArrayList<PersonVO>();
			String company ="duode";
			
			LOGGER.info("员工修改成功,{}", personVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * 查询员工测试getByIdNumber方法测试 
	  */
	@Test
	@Ignore 
	public final void testByIdNumberPerson() {
		try {
			PersonVO personVO = null;
			String telephone ="15201315375";
			//personVO =personService.getByTelephone(telephone);
			System.out.println("result ="+ personVO);
			LOGGER.info("员工修改成功,{}", personVO.toString());
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
				PersonVO personVO = new PersonVO();
				personVO.setId(UUID.randomUUID().toString().replace("-", ""));
				
				personService.save(personVO);
				LOGGER.info("员工{}添加成功,{}", i, personVO.toString());
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
			PersonVO personVO = new PersonVO();
			personVO.setId(UUID.randomUUID().toString().replace("-", ""));
			
			personService.save(personVO);
			LOGGER.info("员工添加成功,{}", personVO.toString());
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
			PersonVO personVO = new PersonVO();
			personVO.setId(UUID.randomUUID().toString().replace("-", ""));
			

		
			personService.save(personVO);
			LOGGER.info("员工添加成功,{}", personVO.toString());
		} catch (Exception e) {
			LOGGER.error("员工添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	  * 根据点赞数量的排序操作
	  */
	@Test
	@Ignore
	public final void testRankPerson() {
		try {
			PersonVO personVO = new PersonVO();
			//personVO.setId(UUID.randomUUID().toString().replace("-", ""));
			//personVO.setName("test");
		
		    List<PersonVO> personList=new ArrayList<PersonVO>();
		   
		   
		    
			LOGGER.info("员工添加成功,{}", personVO.toString());
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
			PersonVO personVO=new PersonVO();
	
			
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
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceTest.class);
	@Autowired
	public PersonService personService;
}
