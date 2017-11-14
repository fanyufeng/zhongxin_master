package com.dongfang.client.zhongxin.controller.service;

import java.util.List;

import com.dongfang.client.zhongxin.controller.vo.ControllerVO;

/**
  * @ClassName: ControllerService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface ControllerService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public ControllerVO getById(String id) throws Exception;
	

	
	

	

	
	/**
	  * 根据company获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<ControllerVO> getStaffList(String companyId)throws Exception;
	

	

	/**
	  * 根据companyId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<ControllerVO>  getByCompanyId(String companyId) throws Exception;
	/**
	  * 保存员工信息
	  * @param controllerVO	员工
	  * @throws Exception 
	  */
	public String save(ControllerVO controllerVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param controllerVO
	  * @throws Exception 
	  */
	public void update(ControllerVO controllerVO) throws Exception;
}
