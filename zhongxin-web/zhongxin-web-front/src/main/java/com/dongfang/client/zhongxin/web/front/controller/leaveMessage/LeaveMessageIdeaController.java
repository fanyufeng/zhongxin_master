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
import com.dongfang.client.zhongxin.idea.vo.IdeaVO;
import com.dongfang.client.zhongxin.leave.message.reply.service.LeaveMessageReplyService;
import com.dongfang.client.zhongxin.leave.message.reply.vo.LeaveMessageReplyVO;
import com.dongfang.client.zhongxin.leave.message.service.LeaveMessageService;
import com.dongfang.client.zhongxin.leave.message.vo.LeaveMessageVO;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.dongfang.client.zhongxin.web.front.response.leaveMessage.LeaveMessageReplyResponse;
import com.dongfang.client.zhongxin.web.front.response.leaveMessage.LeaveMessageSaveResponse;
import com.dongfang.client.zhongxin.web.front.response.leaveMessage.LeaveMessageShowIdeaResponse;


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
@RequestMapping("/leaveMessageIdea")
public class LeaveMessageIdeaController {
	
	/**
	 *  留言
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel showEmpolyee(@RequestBody LeaveMessageVO leaveMessageVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			String id =leaveMessageService.save(leaveMessageVO);
			IdeaVO ideaVO=ideaService.getById(leaveMessageVO.getIdeaId());
			
			LeaveMessageSaveResponse leaveMessageSaveResponse=new LeaveMessageSaveResponse();
			LeaveMessageVO leaveMessageVOx=leaveMessageService.getById(id);
			
			EmployeeVO employeeVO=employeeService.getById(leaveMessageVOx.getCommentatorId());
			if(employeeVO!=null){
				leaveMessageSaveResponse.setCollege(employeeVO.getCollege());	
				leaveMessageSaveResponse.setHeadUrl(employeeVO.getAvatarUrl());
				leaveMessageSaveResponse.setCreateDate(leaveMessageVOx.getCreateDate());
				
				leaveMessageSaveResponse.setCommentator(employeeVO.getNickName());
				leaveMessageSaveResponse.setCommentContent(leaveMessageVOx.getCommentContent());
				leaveMessageSaveResponse.setId(leaveMessageVOx.getId());
			}
			
			
			
			resDataModel.setData(leaveMessageSaveResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessageVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  留言删除
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel deleteMessage(@RequestBody LeaveMessageVO leaveMessageVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			LeaveMessageVO leaveMessageVOx =leaveMessageService.getById(leaveMessageVO.getId());
		
			if(leaveMessageVOx!=null){
				leaveMessageService.delete(leaveMessageVOx);
			}
			
			
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessageVO.toString(),
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
	@RequestMapping(value="/showLeaveMessageIdea",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel showleavemessage(@RequestBody LeaveMessageVO leaveMessageVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<LeaveMessageVO> leaveMessageVOList =leaveMessageService.getByIdeaId(leaveMessageVO.getIdeaId());

			List<LeaveMessageShowIdeaResponse> leaveMessageShowIdeaResponse=new ArrayList<LeaveMessageShowIdeaResponse>();
			for(LeaveMessageVO yt:leaveMessageVOList){
				LeaveMessageShowIdeaResponse elem=new LeaveMessageShowIdeaResponse();
				elem.setId(yt.getId());
				EmployeeVO employeeVO=employeeService.getById(yt.getCommentatorId());
				if(employeeVO!=null){
					elem.setCollege(employeeVO.getCollege());
					elem.setHeadUrl(employeeVO.getAvatarUrl());
					if(employeeVO.getGender()!=null){
						elem.setGender(employeeVO.getGender());
						if(elem.getGender().equals("0")){
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
				elem.setIdeaId(yt.getIdeaId());
				
				List<LeaveMessageReplyVO> leaveMessageReplyVOList=leaveMessageReplyService.getLeaveMessageId(yt.getId());
				
				List<LeaveMessageReplyResponse> LeaveMessageReplyResponseList = new ArrayList<LeaveMessageReplyResponse>();
				if(leaveMessageReplyVOList!=null){
					for(LeaveMessageReplyVO bt:leaveMessageReplyVOList){
						LeaveMessageReplyResponse leaveMessageReplyResponse=new LeaveMessageReplyResponse();
						leaveMessageReplyResponse.setCreateDate(bt.getCreateDate());
						leaveMessageReplyResponse.setId(bt.getId());
						leaveMessageReplyResponse.setLastUpdateDate(bt.getLastUpdateDate());
						leaveMessageReplyResponse.setLeaveMessageId(bt.getLeaveMessageId());
						leaveMessageReplyResponse.setReplyContent(bt.getReplyContent());
						leaveMessageReplyResponse.setReplyId(bt.getReplyId());
						leaveMessageReplyResponse.setReplyName(bt.getReplyName());
						leaveMessageReplyResponse.setSerialNumber(bt.getSerialNumber());
						leaveMessageReplyResponse.setSenderId(bt.getSenderId());
						leaveMessageReplyResponse.setSenderName(bt.getSenderName());
						LeaveMessageReplyResponseList.add(leaveMessageReplyResponse);
						
					}
					
					elem.setLeaveMessageReplyVOList(LeaveMessageReplyResponseList);;
				}
				leaveMessageShowIdeaResponse.add(elem);
				
			}
			resDataModel.setData(leaveMessageShowIdeaResponse);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessageVO.toString(),
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
	@RequestMapping(value="/leaveMessageReplySave",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel leaveMessageReplySave(@RequestBody LeaveMessageReplyVO leaveMessageReplyVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			List<LeaveMessageReplyVO> leaveMessageReplyVOList=leaveMessageReplyService.getLeaveMessageId(leaveMessageReplyVO.getLeaveMessageId());
			int count=0;
			
			if(leaveMessageReplyVOList!=null){
				for(LeaveMessageReplyVO xu:leaveMessageReplyVOList){
					count++;
				}
			}else{
				count=1;
			}
			leaveMessageReplyVO.setSerialNumber(count);
			
			LeaveMessageVO leaveMessageVOX =leaveMessageService.getById(leaveMessageReplyVO.getLeaveMessageId());
			IdeaVO ideaVO=ideaService.getById(leaveMessageVOX.getIdeaId());
			
			String id=leaveMessageReplyService.save(leaveMessageReplyVO);
			
			resDataModel.setData(id);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessageReplyVO.toString(),
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
	@RequestMapping(value="/leaveMessageReplyDelete",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel leaveMessageReplyDelete(@RequestBody LeaveMessageReplyVO leaveMessageReplyVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			LeaveMessageReplyVO leaveMessageReplyVOx=leaveMessageReplyService.getById(leaveMessageReplyVO.getId());
			if(leaveMessageReplyVOx!=null){
				leaveMessageReplyService.delete(leaveMessageReplyVOx);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessageReplyVO.toString(),
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
	@RequestMapping(value="/leaveMessageReplyShow",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel leaveMessageReplyShow(@RequestBody LeaveMessageReplyVO leaveMessageReplyVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			List<LeaveMessageReplyVO> leaveMessageReplyVOList=leaveMessageReplyService.getLeaveMessageId(leaveMessageReplyVO.getLeaveMessageId());
			
			
			if(leaveMessageReplyVOList!=null){
				resDataModel.setData(leaveMessageReplyVOList);
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					leaveMessageReplyVO.toString(),
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
	public LeaveMessageReplyService leaveMessageReplyService;
	
	

}
