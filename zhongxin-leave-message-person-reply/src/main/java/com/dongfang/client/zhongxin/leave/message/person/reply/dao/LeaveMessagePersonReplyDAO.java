package com.dongfang.client.zhongxin.leave.message.person.reply.dao;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.person.reply.dao.entity.LeaveMessagePersonReply;



/**
  * @ClassName: LeaveMessagePersonReplyDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface LeaveMessagePersonReplyDAO {
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
	public LeaveMessagePersonReply getById(String id) throws Exception;
	
	
	/**
	  * 保存员工信息
	  * @param leaveMessagePersonReply
	  * @throws Exception 
	  */
	
	public String save(LeaveMessagePersonReply leaveMessagePersonReply) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessagePersonReply
	  * @throws Exception 
	  */
	public void update(LeaveMessagePersonReply leaveMessagePersonReply) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessagePersonReply
	  * @throws Exception 
	  */
	public List<LeaveMessagePersonReply> getByLeaveMessagePersonId(String leaveMessagePersonId) throws Exception;
	
	
	public  void delete(LeaveMessagePersonReply leaveMessagePersonReply) throws Exception ;
}
