package com.dongfang.client.zhongxin.mail.message.code;

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

import com.dongfang.client.zhongxin.mail.message.code.service.MailMessageCodeService;
import com.dongfang.client.zhongxin.mail.message.code.vo.MailMessageCodeVO;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-base.xml","classpath:applicationContext-ds.xml"})
public class MailMessageCodeServiceTest extends AbstractJUnit4SpringContextTests
{
	/**
	  * save方法测试 
	  */
	@Test
	@Ignore
	public final void testSave() {
		try {
			MailMessageCodeVO mailMessageCodeVO = new MailMessageCodeVO();
			mailMessageCodeVO.setId(UUID.randomUUID().toString().replace("-", ""));
			mailMessageCodeVO.setCode("1234");
			List<String> mailMessageCodeer=new ArrayList<String>();
			mailMessageCodeer.add("fanyufeng");
			mailMessageCodeer.add("qiqi");
			mailMessageCodeVO.setCode("1234");
			mailMessageCodeService.save(mailMessageCodeVO);
			LOGGER.info("邮件添加成功,{}", mailMessageCodeVO.toString());
		} catch (Exception e) {
			LOGGER.error("邮件添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
	}
	/**
	  * update方法测试 
	  */
	@Ignore
	@Test
	public final void testUpdate() {
		try {
			MailMessageCodeVO mailMessageCodeVO = mailMessageCodeService.getById("40283f8153189c750153189c77ed0001");
			mailMessageCodeVO.setCode("1234");
			mailMessageCodeService.update(mailMessageCodeVO);
			LOGGER.info("邮件修改成功,{}", mailMessageCodeVO.toString());
		} catch (Exception e) {
			LOGGER.error("邮件修改失败,原因{}", ExceptionUtils.getFullStackTrace(e));
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
	private static final Logger LOGGER = LoggerFactory.getLogger(MailMessageCodeServiceTest.class);
	@Autowired
	public MailMessageCodeService mailMessageCodeService;
	
}
