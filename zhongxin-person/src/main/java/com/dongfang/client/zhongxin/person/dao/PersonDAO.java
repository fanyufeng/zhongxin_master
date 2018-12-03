package com.dongfang.client.zhongxin.person.dao;

import java.util.List;

import com.dongfang.client.zhongxin.person.dao.entity.Person;

/**
  * @ClassName: PersonDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface PersonDAO {
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
	public Person getById(String id) throws Exception;
	
	public List<Person> getByPersonList(int currentPage, int pageSize) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param person
	  * @throws Exception 
	  */
	
	public String save(Person person) throws Exception;
	public List<Person> getByStatus(int status) throws Exception;
	public List<Person> getByCategory(String category, int currentPage, int pageSize) throws Exception;
	public List<Person> getByCreaterId(String createrId) throws Exception;
	/**
	  * 修改员工信息
	  * @param person
	  * @throws Exception 
	  */
	public void update(Person person) throws Exception;
}
