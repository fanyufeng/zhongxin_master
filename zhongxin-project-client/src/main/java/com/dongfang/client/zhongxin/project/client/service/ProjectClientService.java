package com.dongfang.client.zhongxin.project.client.service;

import java.util.List;

import com.dongfang.client.zhongxin.project.client.vo.ProjectClientVO;

/**
  * @ClassName: ProjectClientService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface ProjectClientService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public ProjectClientVO getById(String id) throws Exception;
	

	
	

	

	
	/**
	  * 根据company获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<ProjectClientVO> getStaffList(String companyId)throws Exception;
	

	

	/**
	  * 根据companyId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<ProjectClientVO>  getByCompanyId(String companyId) throws Exception;
	/**
	  * 保存员工信息
	  * @param projectClientVO	员工
	  * @throws Exception 
	  */
	public String save(ProjectClientVO projectClientVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param projectClientVO
	  * @throws Exception 
	  */
	public void update(ProjectClientVO projectClientVO) throws Exception;
}
