package com.dongfang.client.zhongxin.person.service;

import java.util.List;

import com.dongfang.client.zhongxin.person.vo.PersonVO;

/**
  * @ClassName: PersonService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface PersonService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public PersonVO getById(String id) throws Exception;
	

	
	

	

	
	/**
	  * 根据company获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<PersonVO> getStaffList(String companyId)throws Exception;
	
	public PersonVO getByUnionId(String unionId) throws Exception;

	/**
	  * 根据companyId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<PersonVO>  getByCompanyId(String companyId) throws Exception;
	/**
	  * 保存员工信息
	  * @param personVO	员工
	  * @throws Exception 
	  */
	public String save(PersonVO personVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param personVO
	  * @throws Exception 
	  */
	public void update(PersonVO personVO) throws Exception;
}
