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
	

	
	

	

	
	
	
	public List<PersonVO>  getByStatus(int status) throws Exception;
	public List<PersonVO>  getByPersonList(int currentPage, int pageSize) throws Exception;
	public List<PersonVO>  getByCategory(String category, int currentPage, int pageSize) throws Exception;
	public List<PersonVO>  getByCreaterId(String createrId) throws Exception;
	
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
