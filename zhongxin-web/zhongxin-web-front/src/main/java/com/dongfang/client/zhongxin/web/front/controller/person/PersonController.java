package com.dongfang.client.zhongxin.web.front.controller.person;

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

import com.dongfang.client.zhongxin.annex.library.service.AnnexLibraryService;
import com.dongfang.client.zhongxin.annex.library.vo.AnnexLibraryVO;
import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;
import com.dongfang.client.zhongxin.person.service.PersonService;
import com.dongfang.client.zhongxin.person.vo.PersonVO;
import com.dongfang.client.zhongxin.web.front.request.person.FilePathElem;
import com.dongfang.client.zhongxin.web.front.request.person.PersonRequest;
import com.dongfang.client.zhongxin.web.front.request.person.PersonSaveRequest;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.dongfang.client.zhongxin.web.front.response.person.PersonMainResponse;
import com.dongfang.client.zhongxin.web.front.response.person.PersonResponse;
import com.dongfang.client.zhongxin.web.front.response.person.ShowAnnexLibraryElem;

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
	public @ResponseBody ResponseDataModel save(@RequestBody PersonSaveRequest personSaveRequest) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			PersonVO personVO=new PersonVO();
			personVO.setCategory(personSaveRequest.getCategory());
			personVO.setContent(personSaveRequest.getContent());
			personVO.setCreater(personSaveRequest.getCreater());
			personVO.setCreaterId(personSaveRequest.getCreaterId());
			personVO.setStatus(personSaveRequest.getStatus());
			personVO.setTitle(personSaveRequest.getTitle());
			
			
			String personId=personService.save(personVO);
			
			if(personSaveRequest.getFilePathElemList()!=null){
				for(FilePathElem th:personSaveRequest.getFilePathElemList()){
					AnnexLibraryVO personAnnexLibraryVOModel=new AnnexLibraryVO();
					personAnnexLibraryVOModel.setPersonId(personId);
					personAnnexLibraryVOModel.setUserId(personSaveRequest.getCreaterId());
					personAnnexLibraryVOModel.setUserName(personSaveRequest.getCreater());
					personAnnexLibraryVOModel.setFilePath(th.getFilePath());
					personAnnexLibraryVOModel.setFileName(th.getFileName());
					personAnnexLibraryVOModel.setStatus(th.getStatus());
					annexLibraryService.save(personAnnexLibraryVOModel);
				}
			}
			resDataModel.setData(personId);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("PersonController#save({}) : {}", ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  得到说说列表
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getlist")
	public @ResponseBody ResponseDataModel getlist(@RequestBody PersonRequest personRequest) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			PersonMainResponse personMainResponse = new PersonMainResponse();
			List<PersonVO> personList=personService.getByPersonList(personRequest.getCurrentPage(), 8);
			List<PersonResponse> personResponseList = new ArrayList<PersonResponse>(); 
			if(personList!=null){
				for(PersonVO elem:personList){
					PersonResponse personResponse = new PersonResponse();
					personResponse.setId(elem.getId());
					personResponse.setCategory(elem.getCategory());
					personResponse.setContent(elem.getContent());
					personResponse.setCreateDate(elem.getCreateDate());
					personResponse.setCreater(elem.getCreater());
					personResponse.setCreaterId(elem.getCreaterId());
				
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						personResponse.setGender(employeeVO.getGender());
						personResponse.setHeadUrl(employeeVO.getAvatarUrl());
						personResponse.setCollege(employeeVO.getCollege());
					}
					List<ShowAnnexLibraryElem> showAnnexLibraryElemList = new ArrayList<ShowAnnexLibraryElem>();
					List<AnnexLibraryVO> AnnexLibraryVOList=annexLibraryService.getByPersonId(elem.getId());
					if(AnnexLibraryVOList!=null){
						for(AnnexLibraryVO rt:AnnexLibraryVOList){
							ShowAnnexLibraryElem yu= new ShowAnnexLibraryElem();
							yu.setAnnexUrl(rt.getFilePath());
							yu.setImagePath(rt.getImagePath());
							yu.setStatus(rt.getStatus());
							showAnnexLibraryElemList.add(yu);
						}
					}
					personResponse.setShowAnnexLibraryElemList(showAnnexLibraryElemList);
					personResponseList.add(personResponse);
				}
			}
			
			personMainResponse.setPersonResponseList(personResponseList);
			personMainResponse.setCurrentPage(personRequest.getCurrentPage()+1);
			resDataModel.setData(personResponseList);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					personRequest.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  得到说说列表
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getByStatus")
	public @ResponseBody ResponseDataModel getByStatus(@RequestBody PersonVO personVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<PersonVO> personList=personService.getByStatus(personVO.getStatus());
			if(personList!=null){
				resDataModel.setData(personList);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					personVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  得到说说列表
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getByCategory")
	public @ResponseBody ResponseDataModel getByCategory(@RequestBody PersonRequest personRequest) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			PersonMainResponse personMainResponse = new PersonMainResponse();
			List<PersonVO> personList=personService.getByCategory(personRequest.getCategory(), personRequest.getCurrentPage(), 8);
			List<PersonResponse> personResponseList = new ArrayList<PersonResponse>(); 
			if(personList!=null){
				for(PersonVO elem:personList){
					PersonResponse personResponse = new PersonResponse();
					personResponse.setId(elem.getId());
					personResponse.setCategory(elem.getCategory());
					personResponse.setContent(elem.getContent());
					personResponse.setCreateDate(elem.getCreateDate());
					personResponse.setCreater(elem.getCreater());
					personResponse.setCreaterId(elem.getCreaterId());
				
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						personResponse.setGender(employeeVO.getGender());
						personResponse.setHeadUrl(employeeVO.getAvatarUrl());
						personResponse.setCollege(employeeVO.getCollege());
					}
					List<ShowAnnexLibraryElem> showAnnexLibraryElemList = new ArrayList<ShowAnnexLibraryElem>();
					List<AnnexLibraryVO> AnnexLibraryVOList=annexLibraryService.getByPersonId(elem.getId());
					if(AnnexLibraryVOList!=null){
						for(AnnexLibraryVO rt:AnnexLibraryVOList){
							ShowAnnexLibraryElem yu= new ShowAnnexLibraryElem();
							yu.setAnnexUrl(rt.getFilePath());
							yu.setImagePath(rt.getImagePath());
							yu.setStatus(rt.getStatus());
							showAnnexLibraryElemList.add(yu);
						}
					}
					personResponse.setShowAnnexLibraryElemList(showAnnexLibraryElemList);
					personResponseList.add(personResponse);
				}
			}
			personMainResponse.setPersonResponseList(personResponseList);
			personMainResponse.setCurrentPage(personRequest.getCurrentPage() + 1);
			resDataModel.setData(personMainResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					personRequest.toString(),
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
	public @ResponseBody ResponseDataModel getDetail(@RequestBody PersonVO personVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			PersonVO personList=personService.getById(personVO.getId());
			if(personList!=null){
				
				PersonResponse personResponse = new PersonResponse();
				personResponse.setId(personList.getId());
				personResponse.setCategory(personList.getCategory());
				personResponse.setContent(personList.getContent());
				personResponse.setCreateDate(personList.getCreateDate());
				personResponse.setCreater(personList.getCreater());
				personResponse.setCreaterId(personList.getCreaterId());
			
				EmployeeVO employeeVO= employeeService.getById(personList.getCreaterId());
				if(employeeVO!=null){
					personResponse.setGender(employeeVO.getGender());
					personResponse.setHeadUrl(employeeVO.getAvatarUrl());
					personResponse.setCollege(employeeVO.getCollege());
				}
				List<ShowAnnexLibraryElem> showAnnexLibraryElemList = new ArrayList<ShowAnnexLibraryElem>();
				List<AnnexLibraryVO> AnnexLibraryVOList=annexLibraryService.getByPersonId(personList.getId());
				if(AnnexLibraryVOList!=null){
					for(AnnexLibraryVO rt:AnnexLibraryVOList){
						ShowAnnexLibraryElem yu= new ShowAnnexLibraryElem();
						yu.setAnnexUrl(rt.getFilePath());
						yu.setImagePath(rt.getImagePath());
						yu.setStatus(rt.getStatus());
						showAnnexLibraryElemList.add(yu);
					}
				}
				personResponse.setShowAnnexLibraryElemList(showAnnexLibraryElemList);
				resDataModel.setData(personResponse);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					personVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	/**
	 *  得到说说列表
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getByCreaterId")
	public @ResponseBody ResponseDataModel getByCreaterId(@RequestBody PersonVO personVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<PersonVO> personList=personService.getByCreaterId(personVO.getCreaterId());
			List<PersonResponse> personResponseList = new ArrayList<PersonResponse>(); 
			if(personList!=null){
				for(PersonVO elem:personList){
					PersonResponse personResponse = new PersonResponse();
					personResponse.setId(elem.getId());
					personResponse.setCategory(elem.getCategory());
					personResponse.setContent(elem.getContent());
					personResponse.setCreateDate(elem.getCreateDate());
					personResponse.setCreater(elem.getCreater());
					personResponse.setCreaterId(elem.getCreaterId());
				
					EmployeeVO employeeVO= employeeService.getById(elem.getCreaterId());
					if(employeeVO!=null){
						personResponse.setGender(employeeVO.getGender());
						personResponse.setHeadUrl(employeeVO.getAvatarUrl());
						personResponse.setCollege(employeeVO.getCollege());
					}
					List<ShowAnnexLibraryElem> showAnnexLibraryElemList = new ArrayList<ShowAnnexLibraryElem>();
					List<AnnexLibraryVO> AnnexLibraryVOList=annexLibraryService.getByPersonId(elem.getId());
					if(AnnexLibraryVOList!=null){
						for(AnnexLibraryVO rt:AnnexLibraryVOList){
							ShowAnnexLibraryElem yu= new ShowAnnexLibraryElem();
							yu.setAnnexUrl(rt.getFilePath());
							yu.setImagePath(rt.getImagePath());
							yu.setStatus(rt.getStatus());
							showAnnexLibraryElemList.add(yu);
						}
					}
					personResponse.setShowAnnexLibraryElemList(showAnnexLibraryElemList);
					personResponseList.add(personResponse);
				}
			}
			resDataModel.setData(personResponseList);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("IdeaController#save({}) : {}", 
					personVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	public PersonService personService;
	@Autowired
	public AnnexLibraryService annexLibraryService;
	@Autowired
	public EmployeeService employeeService;
	
}
