package com.dongfang.client.zhongxin.employee.service;

import java.util.List;

import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;

/**
  * @ClassName: EmployeeService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface EmployeeService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public EmployeeVO getById(String id) throws Exception;
	

	
	

	

	
	/**
	  * 根据company获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<EmployeeVO> getStaffList(String companyId)throws Exception;
	
	public EmployeeVO getByUnionId(String unionId) throws Exception;

	/**
	  * 根据companyId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<EmployeeVO>  getByCompanyId(String companyId) throws Exception;
	/**
	  * 保存员工信息
	  * @param employeeVO	员工
	  * @throws Exception 
	  */
	public String save(EmployeeVO employeeVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param employeeVO
	  * @throws Exception 
	  */
	public void update(EmployeeVO employeeVO) throws Exception;
	public EmployeeVO getByopenid(String openid) throws Exception;
}
