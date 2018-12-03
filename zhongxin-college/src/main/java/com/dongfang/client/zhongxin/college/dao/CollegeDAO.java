package com.dongfang.client.zhongxin.college.dao;

import java.util.List;

import com.dongfang.client.zhongxin.college.dao.entity.College;

/**
  * @ClassName: CollegeDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface CollegeDAO {
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
	public College getById(String id) throws Exception;
	
	public List<College> getByCollegeList() throws Exception;
	
	/**
	  * 保存员工信息
	  * @param college
	  * @throws Exception 
	  */
	
	public String save(College college) throws Exception;
	public List<College> getByStatus(int status) throws Exception;
	/**
	  * 修改员工信息
	  * @param college
	  * @throws Exception 
	  */
	public void update(College college) throws Exception;
}
