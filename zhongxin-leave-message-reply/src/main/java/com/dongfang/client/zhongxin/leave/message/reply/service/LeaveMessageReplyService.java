package com.dongfang.client.zhongxin.leave.message.reply.service;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.reply.vo.LeaveMessageReplyVO;



/**
  * @ClassName: LeaveMessageReplyService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface LeaveMessageReplyService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public LeaveMessageReplyVO getById(String id) throws Exception;
	
	
	/**
	  * 保存员工信息
	  * @param leaveMessageReplyVO	员工
	  * @throws Exception 
	  */
	public String save(LeaveMessageReplyVO leaveMessageReplyVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessageReplyVO
	  * @throws Exception 
	  */
	public void update(LeaveMessageReplyVO leaveMessageReplyVO) throws Exception;
	public List<LeaveMessageReplyVO> getLeaveMessageId(String leaveMessageId)
			throws Exception;
	
	public void delete(LeaveMessageReplyVO leaveMessageReplyVO) throws Exception;
	

}
