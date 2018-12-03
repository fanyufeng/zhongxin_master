package com.dongfang.client.zhongxin.leave.message.person.service;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.person.vo.LeaveMessagePersonVO;



/**
  * @ClassName: LeaveMessagePersonService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface LeaveMessagePersonService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public LeaveMessagePersonVO getById(String id) throws Exception;
	
	public List<LeaveMessagePersonVO> getByPersonId(String personId)
			throws Exception;
	/**
	  * 保存员工信息
	  * @param leaveMessagePersonVO	员工
	  * @throws Exception 
	  */
	public String save(LeaveMessagePersonVO leaveMessagePersonVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessagePersonVO
	  * @throws Exception 
	  */
	public void update(LeaveMessagePersonVO leaveMessagePersonVO) throws Exception;
	
	public void delete(LeaveMessagePersonVO leaveMessagePersonVO) throws Exception;

}
