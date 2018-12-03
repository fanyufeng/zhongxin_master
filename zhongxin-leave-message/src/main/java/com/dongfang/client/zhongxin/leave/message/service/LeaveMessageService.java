package com.dongfang.client.zhongxin.leave.message.service;

import java.util.List;

import com.dongfang.client.zhongxin.leave.message.vo.LeaveMessageVO;



/**
  * @ClassName: LeaveMessageService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface LeaveMessageService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public LeaveMessageVO getById(String id) throws Exception;
	
	public List<LeaveMessageVO> getByIdeaId(String ideaId)
			throws Exception;
	/**
	  * 保存员工信息
	  * @param leaveMessageVO	员工
	  * @throws Exception 
	  */
	public String save(LeaveMessageVO leaveMessageVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param leaveMessageVO
	  * @throws Exception 
	  */
	public void update(LeaveMessageVO leaveMessageVO) throws Exception;
	
	public void delete(LeaveMessageVO leaveMessageVO) throws Exception;

}
