package com.dongfang.client.zhongxin.employee.dao;

import java.util.List;

import com.dongfang.client.zhongxin.employee.dao.entity.Employee;

/**
  * @ClassName: EmployeeDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface EmployeeDAO {
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
	public Employee getById(String id) throws Exception;
	
	
	
	/**
	  * 根据companyId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<Employee> getByCompanyId(String companyId) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param employee
	  * @throws Exception 
	  */
	
	public String save(Employee employee) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param employee
	  * @throws Exception 
	  */
	public void update(Employee employee) throws Exception;
	
	public List<Employee> getByunionId(String unionId) throws Exception;
	
	public List<Employee> getByopenid(String openid) throws Exception;
	
	
}
