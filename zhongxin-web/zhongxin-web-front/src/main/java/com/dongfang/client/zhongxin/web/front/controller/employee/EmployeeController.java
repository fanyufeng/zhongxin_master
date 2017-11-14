package com.dongfang.client.zhongxin.web.front.controller.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;



/**
 * @author 员工控制器
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	/**
	 *  员工自定义表单创建
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/save")
	public @ResponseBody ResponseDataModel save(@RequestBody EmployeeVO employeeVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			employeeService.save(employeeVO);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					employeeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	public EmployeeService employeeService;
}
