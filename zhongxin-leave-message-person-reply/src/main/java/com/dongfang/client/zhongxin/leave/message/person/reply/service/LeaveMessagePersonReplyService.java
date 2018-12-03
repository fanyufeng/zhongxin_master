package com.dongfang.client.zhongxin.leave.message.person.reply.service;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.person.reply.vo.LeaveMessagePersonReplyVO;


/**
  * @ClassName: LeaveMessagePersonReplyService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface LeaveMessagePersonReplyService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public LeaveMessagePersonReplyVO getById(String id) throws Exception;
	
	
	/**
	  * 保存员工信息
	  * @param leaveMessagePersonReplyVO	员工
	  * @throws Exception 
	  */
	public String save(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessagePersonReplyVO
	  * @throws Exception 
	  */
	public void update(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception;
	public List<LeaveMessagePersonReplyVO> getLeaveMessagePersonId(String leaveMessagePersonId)
			throws Exception ;
	
	public void delete(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) throws Exception;
}
