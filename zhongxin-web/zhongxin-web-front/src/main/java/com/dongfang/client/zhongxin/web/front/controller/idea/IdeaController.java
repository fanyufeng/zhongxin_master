package com.dongfang.client.zhongxin.web.front.controller.idea;

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
import com.dongfang.client.zhongxin.idea.service.IdeaService;
import com.dongfang.client.zhongxin.idea.vo.IdeaVO;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;

/**
 * @author 员工控制器
 *
 */
@Controller
@RequestMapping("/idea")
public class IdeaController {
	/**
	 *  保存项目
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/save")
	public @ResponseBody ResponseDataModel save(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			logger.info("=========fanyufeng============");
			String ideaId=ideaService.save(ideaVO);
			resDataModel.setData(ideaId);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaVO.toString(),
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
	public @ResponseBody ResponseDataModel getlist(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<IdeaVO> ideaList=ideaService.getByIdeaList();
			if(ideaList!=null){
				resDataModel.setData(ideaList);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  得到项目详情
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getDetail")
	public @ResponseBody ResponseDataModel getDetail(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			IdeaVO ideaList=ideaService.getById(ideaVO.getId());
			if(ideaList!=null){
				resDataModel.setData(ideaList);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(IdeaController.class);
	@Autowired
	public IdeaService ideaService;
}
