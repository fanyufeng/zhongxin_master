package com.dongfang.client.zhongxin.leave.message.dao;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.dao.entity.LeaveMessage;



/**
  * @ClassName: CommentDAO
  * @Description: 员工数据访问层
  * @author fyf820@163.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface LeaveMessageDAO {
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
	public LeaveMessage getById(String id) throws Exception;
	
	public List<LeaveMessage> getByIdeaId(String ideaId) throws Exception;
	
	
	/**
	  * 保存员工信息
	  * @param comment
	  * @throws Exception 
	  */
	
	public String save(LeaveMessage leaveMessage) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param comment
	  * @throws Exception 
	  */
	public void update(LeaveMessage leaveMessage) throws Exception;
	
	/**
	  * 删除留言信息
	  * @param comment
	  * @throws Exception 
	  */
	public  void delete(LeaveMessage leaveMessage) throws Exception;

	
}
