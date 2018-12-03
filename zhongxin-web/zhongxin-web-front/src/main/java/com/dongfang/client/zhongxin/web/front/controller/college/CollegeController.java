package com.dongfang.client.zhongxin.web.front.controller.college;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfang.client.zhongxin.college.service.CollegeService;
import com.dongfang.client.zhongxin.college.vo.CollegeVO;
import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.idea.service.IdeaService;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;

/**
 * @author 员工控制器
 *
 */
@Controller
@RequestMapping("/college")
public class CollegeController {
	/**
	 *  保存项目
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/save")
	public @ResponseBody ResponseDataModel save(@RequestBody CollegeVO collegeVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			String id = collegeService.save(collegeVO);
			resDataModel.setData(id);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					collegeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	
	/**
	 *  得到项目列表
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getlist")
	public @ResponseBody ResponseDataModel getlist(@RequestBody CollegeVO collegeVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<CollegeVO> collegeList=collegeService.getByCollegeList();
			if(collegeList!=null){
				resDataModel.setData(collegeList);
			}
			
			
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("CollegeController#getlist({}) : {}", 
					collegeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(CollegeController.class);
	@Autowired
	public IdeaService ideaService;
	@Autowired
	public EmployeeService employeeService;
	@Autowired
	public CollegeService collegeService;
}
