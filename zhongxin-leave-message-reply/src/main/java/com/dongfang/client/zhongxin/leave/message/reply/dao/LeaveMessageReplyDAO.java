package com.dongfang.client.zhongxin.leave.message.reply.dao;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.reply.dao.entity.LeaveMessageReply;



/**
  * @ClassName: LeaveMessageReplyDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface LeaveMessageReplyDAO {
	/**
	  * @Fields ignoreProperties : 不可编辑属性
	  */
	public static final String[] ignoreProperties = new String[]{"createDate"};
	
	
	
	/**
	  * 根据id获取员工信息
	  * @param id
	  * @return
	  * @throws Exception 
	  */
	public LeaveMessageReply getById(String id) throws Exception;
	
	
	/**
	  * 保存员工信息
	  * @param leaveMessageReply
	  * @throws Exception 
	  */
	
	public String save(LeaveMessageReply leaveMessageReply) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessageReply
	  * @throws Exception 
	  */
	public void update(LeaveMessageReply leaveMessageReply) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessageReply
	  * @throws Exception 
	  */
	public List<LeaveMessageReply> getByLeaveMessageId(String leaveMessageId) throws Exception;
	
	
	public  void delete(LeaveMessageReply leaveMessageReply) throws Exception;

	
	
}
