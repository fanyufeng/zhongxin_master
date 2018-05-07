package com.dongfang.client.zhongxin.web.front.controller.person;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.person.service.PersonService;
import com.dongfang.client.zhongxin.person.vo.PersonVO;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;

/**
 * @author 员工控制器
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	/**
	 *  注册
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/save")
	public @ResponseBody ResponseDataModel save(@RequestBody PersonVO personVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			String ideaId=personService.save(personVO);
			resDataModel.setData(ideaId);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("PersonController#save({}) : {}", 
					personVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	public PersonService personService;
}
