package com.dongfang.client.zhongxin.leave.message.person.dao;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.person.dao.entity.LeaveMessagePerson;



/**
  * @ClassName: CommentDAO
  * @Description: 员工数据访问层
  * @author fyf820@163.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface LeaveMessagePersonDAO {
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
	public LeaveMessagePerson getById(String id) throws Exception;
	
	public List<LeaveMessagePerson> getByPersonId(String personId) throws Exception;
	
	
	/**
	  * 保存员工信息
	  * @param comment
	  * @throws Exception 
	  */
	
	public String save(LeaveMessagePerson leaveMessagePerson) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param comment
	  * @throws Exception 
	  */
	public void update(LeaveMessagePerson leaveMessagePerson) throws Exception;
	
	public  void delete(LeaveMessagePerson leaveMessagePerson) throws Exception;

	
}
