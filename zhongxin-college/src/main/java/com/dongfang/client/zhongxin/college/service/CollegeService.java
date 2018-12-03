package com.dongfang.client.zhongxin.college.service;

import java.util.List;

import com.dongfang.client.zhongxin.college.vo.CollegeVO;

/**
  * @ClassName: CollegeService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface CollegeService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public CollegeVO getById(String id) throws Exception;
	

	
	

	

	
	
	
	public List<CollegeVO>  getByStatus(int status) throws Exception;
	
	
	public List<CollegeVO>  getByCollegeList() throws Exception;
	
	/**
	  * 保存员工信息
	  * @param collegeVO	员工
	  * @throws Exception 
	  */
	public String save(CollegeVO collegeVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param collegeVO
	  * @throws Exception 
	  */
	public void update(CollegeVO collegeVO) throws Exception;
}
