package com.dongfang.client.zhongxin.web.front.controller.leaveMessage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfang.client.zhongxin.annex.library.service.AnnexLibraryService;
import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.service.impl.EmployeeServiceImpl;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;
import com.dongfang.client.zhongxin.idea.service.IdeaService;
import com.dongfang.client.zhongxin.idea.service.impl.IdeaServiceImpl;
import com.dongfang.client.zhongxin.leave.message.person.reply.service.LeaveMessagePersonReplyService;
import com.dongfang.client.zhongxin.leave.message.person.reply.vo.LeaveMessagePersonReplyVO;
import com.dongfang.client.zhongxin.leave.message.person.service.LeaveMessagePersonService;
import com.dongfang.client.zhongxin.leave.message.person.vo.LeaveMessagePersonVO;
import com.dongfang.client.zhongxin.leave.message.service.LeaveMessageService;
import com.dongfang.client.zhongxin.person.service.PersonService;
import com.dongfang.client.zhongxin.person.vo.PersonVO;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.dongfang.client.zhongxin.web.front.response.leaveMessage.LeaveMessagePersonReplyResponse;
import com.dongfang.client.zhongxin.web.front.response.leaveMessage.LeaveMessageSaveResponse;
import com.dongfang.client.zhongxin.web.front.response.leaveMessage.LeaveMessageShowPersonResponse;


/** 
 * 项目控制器
 * @author  fyf820@163.com: 
 * @date 创建时间：2017年4月25日 下午8:31:47 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Controller
@RequestMapping("/leaveMessagePerson")
public class LeaveMessagePersonController {
	
	/**
	 *  报名项目
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel showEmpolyee(@RequestBody LeaveMessagePersonVO leaveMessagePersonVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			String id=leaveMessagePersonService.save(leaveMessagePersonVO);
			
			PersonVO personVO=personService.getById(leaveMessagePersonVO.getPersonId());
			
			
			LeaveMessageSaveResponse leaveMessageSaveResponse=new LeaveMessageSaveResponse();
			LeaveMessagePersonVO leaveMessagePersonVOx=leaveMessagePersonService.getById(id);
			
			EmployeeVO employeeVO=employeeService.getById(leaveMessagePersonVOx.getCommentatorId());
			if(employeeVO!=null){
				leaveMessageSaveResponse.setCollege(employeeVO.getCollege());	
				leaveMessageSaveResponse.setHeadUrl(employeeVO.getAvatarUrl());
				leaveMessageSaveResponse.setCreateDate(leaveMessagePersonVOx.getCreateDate());
				
				leaveMessageSaveResponse.setCommentator(employeeVO.getNickName());
				leaveMessageSaveResponse.setCommentContent(leaveMessagePersonVOx.getCommentContent());
				leaveMessageSaveResponse.setId(leaveMessagePersonVOx.getId());
			}
			resDataModel.setData(leaveMessageSaveResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessagePersonVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	
	/**
	 *  报名项目
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel deletePerson(@RequestBody LeaveMessagePersonVO leaveMessagePersonVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			LeaveMessagePersonVO leaveMessagePersonVOx =leaveMessagePersonService.getById(leaveMessagePersonVO.getId());
			if(leaveMessagePersonVOx!=null){
				leaveMessagePersonService.delete(leaveMessagePersonVOx);
			}
			
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessagePersonVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	/**
	 *  留言信息显示
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/showLeaveMessagePerson",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel showLeaveMessagePerson(@RequestBody LeaveMessagePersonVO leaveMessagePersonVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<LeaveMessagePersonVO> leaveMessagePersonVOList =leaveMessagePersonService.getByPersonId(leaveMessagePersonVO.getPersonId());
			List<LeaveMessageShowPersonResponse> leaveMessageShowPersonResponse=new ArrayList<LeaveMessageShowPersonResponse>();
			for(LeaveMessagePersonVO yt:leaveMessagePersonVOList){
				LeaveMessageShowPersonResponse elem=new LeaveMessageShowPersonResponse();
				elem.setId(yt.getId());
				EmployeeVO employeeVO=employeeService.getById(yt.getCommentatorId());
				if(employeeVO!=null){
					elem.setCollege(employeeVO.getCollege());
					elem.setHeadUrl(employeeVO.getAvatarUrl());
					if(employeeVO.getGender()!=null){
						elem.setGender(employeeVO.getGender());
						if(employeeVO.getGender().equals("0")){
							elem.setGender("2");
						}
					}else{
						elem.setGender("2");
					}
					
					elem.setCommentator(employeeVO.getNickName());
				}
				elem.setCreateDate(yt.getCreateDate());
				
				elem.setCommentatorId(yt.getCommentatorId());
				elem.setCommentContent(yt.getCommentContent());
				elem.setPersonId(yt.getPersonId());
				
				List<LeaveMessagePersonReplyVO> leaveMessagePersonReplyVOList=leaveMessagePersonReplyService.getLeaveMessagePersonId(yt.getId());
				
				List<LeaveMessagePersonReplyResponse> LeaveMessageReplyResponseList = new ArrayList<LeaveMessagePersonReplyResponse>();
				if(leaveMessagePersonReplyVOList!=null){
					for(LeaveMessagePersonReplyVO bt:leaveMessagePersonReplyVOList){
						LeaveMessagePersonReplyResponse leaveMessageReplyResponse=new LeaveMessagePersonReplyResponse();
						leaveMessageReplyResponse.setCreateDate(bt.getCreateDate());
						leaveMessageReplyResponse.setId(bt.getId());
						leaveMessageReplyResponse.setLastUpdateDate(bt.getLastUpdateDate());
						leaveMessageReplyResponse.setLeaveMessagePersonId(bt.getLeaveMessagePersonId());;
						leaveMessageReplyResponse.setReplyContent(bt.getReplyContent());
						leaveMessageReplyResponse.setReplyId(bt.getReplyId());
						leaveMessageReplyResponse.setReplyName(bt.getReplyName());
						leaveMessageReplyResponse.setSerialNumber(bt.getSerialNumber());
						leaveMessageReplyResponse.setSenderId(bt.getSenderId());
						leaveMessageReplyResponse.setSenderName(bt.getSenderName());
						LeaveMessageReplyResponseList.add(leaveMessageReplyResponse);
						
					}
					
					elem.setLeaveMessagePersonReplyVOList(leaveMessagePersonReplyVOList);;
				}
				if(leaveMessagePersonReplyVOList!=null){
					elem.setLeaveMessagePersonReplyVOList(leaveMessagePersonReplyVOList);
				}
				
				leaveMessageShowPersonResponse.add(elem);
				
			}
			resDataModel.setData(leaveMessageShowPersonResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessagePersonVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  回复信息保存
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/leaveMessagePersonReplySave",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel leaveMessagePersonReplySave(@RequestBody LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			List<LeaveMessagePersonReplyVO> leaveMessagePersonReplyVOList=leaveMessagePersonReplyService.getLeaveMessagePersonId(leaveMessagePersonReplyVO.getLeaveMessagePersonId());
			int count=0;
			
			if(leaveMessagePersonReplyVOList!=null){
				for(LeaveMessagePersonReplyVO xu:leaveMessagePersonReplyVOList){
					count++;
				}
			}else{
				count=1;
			}
			leaveMessagePersonReplyVO.setSerialNumber(count);
			
			
			LeaveMessagePersonVO leaveMessagePersonVOX=leaveMessagePersonService.getById(leaveMessagePersonReplyVO.getLeaveMessagePersonId());
			
			PersonVO personVO=personService.getById(leaveMessagePersonVOX.getPersonId());
			
			
			String id=leaveMessagePersonReplyService.save(leaveMessagePersonReplyVO);
			
			resDataModel.setData(id);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessagePersonReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  回复信息删除
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/leaveMessagePersonReplyDelete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel leaveMessagePersonReplyDelete(@RequestBody LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			LeaveMessagePersonReplyVO leaveMessagePersonReplyVOx=leaveMessagePersonReplyService.getById(leaveMessagePersonReplyVO.getId());
			if(leaveMessagePersonReplyVOx!=null){
				leaveMessagePersonReplyService.delete(leaveMessagePersonReplyVOx);
			}
			
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessagePersonReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  回复信息显示
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/leaveMessagePersonReplyShow",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel leaveMessageReplyShow(@RequestBody LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			List<LeaveMessagePersonReplyVO> leaveMessagePersonReplyVOList=leaveMessagePersonReplyService.getLeaveMessagePersonId(leaveMessagePersonReplyVO.getLeaveMessagePersonId());
			
			
			if(leaveMessagePersonReplyVOList!=null){
				resDataModel.setData(leaveMessagePersonReplyVOList);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessagePersonReplyVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(LeaveMessageIdeaController.class);
	@Autowired
	public EmployeeService employeeService = new EmployeeServiceImpl();
	@Autowired
	public IdeaService ideaService = new IdeaServiceImpl();
	@Autowired
	public AnnexLibraryService annexLibraryService;
	@Autowired
	public LeaveMessageService leaveMessageService;
	@Autowired
	public LeaveMessagePersonService leaveMessagePersonService;
	@Autowired
	public PersonService personService;
	@Autowired
	public LeaveMessagePersonReplyService leaveMessagePersonReplyService;
	

}
