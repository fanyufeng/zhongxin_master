package com.dongfang.client.zhongxin.web.front.controller.idea;

import java.util.ArrayList;
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
import com.dongfang.client.zhongxin.idea.service.IdeaService;
import com.dongfang.client.zhongxin.idea.vo.IdeaVO;
import com.dongfang.client.zhongxin.web.front.request.idea.IdeaRequest;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.dongfang.client.zhongxin.web.front.response.idea.IdeaMainResponse;
import com.dongfang.client.zhongxin.web.front.response.idea.IdeaResponse;

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
	public @ResponseBody ResponseDataModel getlist(@RequestBody IdeaRequest ideaRequest) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<IdeaVO> ideaList=ideaService.getByIdeaList(ideaRequest.getCurrentPage(), 8);
			List<IdeaResponse> IdeaResponseList =new ArrayList<IdeaResponse>();
			if(ideaList!=null){
				for(IdeaVO elem :ideaList){
					IdeaResponse ideaResponse = new IdeaResponse();
					ideaResponse.setId(elem.getId());
					ideaResponse.setCategory(elem.getCategory());
					ideaResponse.setContent(elem.getContent());
					ideaResponse.setCreateDate(elem.getCreateDate());
					ideaResponse.setCreater(elem.getCreater());
					ideaResponse.setCreaterId(elem.getCreaterId());
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						ideaResponse.setGender(employeeVO.getGender());
						ideaResponse.setHeadUrl(employeeVO.getAvatarUrl());
						ideaResponse.setCollege(employeeVO.getCollege());
					}
					ideaResponse.setLastUpdateDate(elem.getLastUpdateDate());
					ideaResponse.setRecipient(elem.getRecipient());
					ideaResponse.setRecipientId(elem.getRecipientId());
					ideaResponse.setStatus(elem.getStatus());
					ideaResponse.setTitle(elem.getTitle());
					
					IdeaResponseList.add(ideaResponse);
				}
			}
			resDataModel.setData(IdeaResponseList);
			
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaRequest.toString(),
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
	@RequestMapping("/getByStatus")
	public @ResponseBody ResponseDataModel getByStatus(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<IdeaVO> ideaList=ideaService.getByStatus(ideaVO.getStatus());
			List<IdeaResponse> IdeaResponseList =new ArrayList<IdeaResponse>();
			if(ideaList!=null){
				for(IdeaVO elem :ideaList){
					IdeaResponse ideaResponse = new IdeaResponse();
					ideaResponse.setId(elem.getId());
					ideaResponse.setCategory(elem.getCategory());
					ideaResponse.setContent(elem.getContent());
					ideaResponse.setCreateDate(elem.getCreateDate());
					ideaResponse.setCreater(elem.getCreater());
					ideaResponse.setCreaterId(elem.getCreaterId());
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						ideaResponse.setGender(employeeVO.getGender());
						ideaResponse.setHeadUrl(employeeVO.getAvatarUrl());
						ideaResponse.setCollege(employeeVO.getCollege());
					}
					ideaResponse.setLastUpdateDate(elem.getLastUpdateDate());
					ideaResponse.setRecipient(elem.getRecipient());
					ideaResponse.setRecipientId(elem.getRecipientId());
					ideaResponse.setStatus(elem.getStatus());
					ideaResponse.setTitle(elem.getTitle());
					IdeaResponseList.add(ideaResponse);
				}
			}
			resDataModel.setData(IdeaResponseList);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  得到分类项目列表
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getByCategory")
	public @ResponseBody ResponseDataModel getByCategory(@RequestBody IdeaRequest ideaRequest) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			IdeaMainResponse ideaMainResponse = new IdeaMainResponse();
			List<IdeaVO> ideaList=ideaService.getByCategory(ideaRequest.getCategory(), ideaRequest.getCurrentPage(), 8);
			List<IdeaResponse> IdeaResponseList =new ArrayList<IdeaResponse>();
			if(ideaList!=null){
				for(IdeaVO elem :ideaList){
					IdeaResponse ideaResponse = new IdeaResponse();
					ideaResponse.setId(elem.getId());
					ideaResponse.setCategory(elem.getCategory());
					ideaResponse.setContent(elem.getContent());
					ideaResponse.setCreateDate(elem.getCreateDate());
					ideaResponse.setCreater(elem.getCreater());
					ideaResponse.setCreaterId(elem.getCreaterId());
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						ideaResponse.setGender(employeeVO.getGender());
						ideaResponse.setHeadUrl(employeeVO.getAvatarUrl());
						ideaResponse.setCollege(employeeVO.getCollege());
					}
					ideaResponse.setLastUpdateDate(elem.getLastUpdateDate());
					ideaResponse.setRecipient(elem.getRecipient());
					ideaResponse.setRecipientId(elem.getRecipientId());
					ideaResponse.setStatus(elem.getStatus());
					ideaResponse.setTitle(elem.getTitle());
					IdeaResponseList.add(ideaResponse);
				}
			}
			ideaMainResponse.setIdeaResponseList(IdeaResponseList);
			ideaMainResponse.setCurrentPage(ideaRequest.getCurrentPage() + 1);
			resDataModel.setData(ideaMainResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaRequest.toString(),
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
			IdeaResponse ideaResponse = new IdeaResponse();
			if (ideaList !=null){
				ideaResponse.setId(ideaList.getId());
				ideaResponse.setCategory(ideaList.getCategory());
				ideaResponse.setContent(ideaList.getContent());
				ideaResponse.setCreateDate(ideaList.getCreateDate());
				ideaResponse.setCreater(ideaList.getCreater());
				ideaResponse.setCreaterId(ideaList.getCreaterId());
				EmployeeVO employeeVO= employeeService.getById(ideaList.getCreaterId());
				if(employeeVO!=null){
					ideaResponse.setGender(employeeVO.getGender());
					ideaResponse.setHeadUrl(employeeVO.getAvatarUrl());
					ideaResponse.setCollege(employeeVO.getCollege());
				}
				ideaResponse.setLastUpdateDate(ideaList.getLastUpdateDate());
				ideaResponse.setRecipient(ideaList.getRecipient());
				ideaResponse.setRecipientId(ideaList.getRecipientId());
				ideaResponse.setStatus(ideaList.getStatus());
				ideaResponse.setTitle(ideaList.getTitle());
			}
			
			
	
			resDataModel.setData(ideaResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  抢单
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/recept")
	public @ResponseBody ResponseDataModel recept(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			IdeaVO ideaList=ideaService.getById(ideaVO.getId());
			if(ideaList != null){
				ideaList.setRecipient(ideaVO.getRecipient());
				ideaList.setRecipientId(ideaVO.getRecipientId());
				ideaList.setStatus(ideaVO.getStatus());
				ideaService.update(ideaList);
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
	 *  抢单
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getByCreaterId")
	public @ResponseBody ResponseDataModel getByCreaterId(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<IdeaVO> ideaList=ideaService.getByCreaterId(ideaVO.getCreaterId());
			List<IdeaResponse> IdeaResponseList =new ArrayList<IdeaResponse>();
			if(ideaList!=null){
				for(IdeaVO elem :ideaList){
					IdeaResponse ideaResponse = new IdeaResponse();
					ideaResponse.setId(elem.getId());
					ideaResponse.setCategory(elem.getCategory());
					ideaResponse.setContent(elem.getContent());
					ideaResponse.setCreateDate(elem.getCreateDate());
					ideaResponse.setCreater(elem.getCreater());
					ideaResponse.setCreaterId(elem.getCreaterId());
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						if (employeeVO.getTelephone() !=null){
							ideaResponse.setCreaterTelephone(employeeVO.getTelephone());
						}
						ideaResponse.setGender(employeeVO.getGender());
						ideaResponse.setHeadUrl(employeeVO.getAvatarUrl());
						ideaResponse.setCollege(employeeVO.getCollege());
					}
					ideaResponse.setLastUpdateDate(elem.getLastUpdateDate());
					ideaResponse.setRecipient(elem.getRecipient());
					ideaResponse.setRecipientId(elem.getRecipientId());
					if(elem.getStatus()==2 && elem.getRecipientId()!=null){
						EmployeeVO employeeVORecept= employeeService.getById(elem.getRecipientId());
						if(employeeVORecept!=null){
							ideaResponse.setRecipientTelephone(employeeVORecept.getTelephone());
							ideaResponse.setRecipientEmail(employeeVORecept.getEmail());
						}
						ideaResponse.setPickUp(elem.getPickUp());
						ideaResponse.setContact(elem.getContact());
					}
					ideaResponse.setStatus(elem.getStatus());
					ideaResponse.setTitle(elem.getTitle());
					IdeaResponseList.add(ideaResponse);
				}
			}
			resDataModel.setData(IdeaResponseList);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					ideaVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  抢单
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getByRecipientId")
	public @ResponseBody ResponseDataModel getByRecipientId(@RequestBody IdeaVO ideaVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<IdeaVO> ideaList=ideaService.getByRecipientId(ideaVO.getRecipientId());
			List<IdeaResponse> IdeaResponseList =new ArrayList<IdeaResponse>();
			if(ideaList!=null){
				for(IdeaVO elem :ideaList){
					IdeaResponse ideaResponse = new IdeaResponse();
					ideaResponse.setId(elem.getId());
					ideaResponse.setCategory(elem.getCategory());
					ideaResponse.setContent(elem.getContent());
					ideaResponse.setCreateDate(elem.getCreateDate());
					ideaResponse.setCreater(elem.getCreater());
					ideaResponse.setCreaterId(elem.getCreaterId());
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO !=null && elem.getStatus()==2 && elem.getRecipientId()!=null){
						ideaResponse.setGender(employeeVO.getGender());
						ideaResponse.setHeadUrl(employeeVO.getAvatarUrl());
						ideaResponse.setCollege(employeeVO.getCollege());
						if(employeeVO.getTelephone()!=null){
							ideaResponse.setCreaterTelephone(employeeVO.getTelephone());
						}
						if(employeeVO.getEmail()!=null){
							ideaResponse.setCreaterEmail(employeeVO.getEmail());
						}
						ideaResponse.setPickUp(elem.getPickUp());
						ideaResponse.setContact(elem.getContact());;
					}
					
				
					ideaResponse.setLastUpdateDate(elem.getLastUpdateDate());
					ideaResponse.setRecipient(elem.getRecipient());
					ideaResponse.setRecipientId(elem.getRecipientId());
					ideaResponse.setStatus(elem.getStatus());
					ideaResponse.setTitle(elem.getTitle());
					IdeaResponseList.add(ideaResponse);
				}
			}
			resDataModel.setData(IdeaResponseList);
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
	@Autowired
	public EmployeeService employeeService;
}
