package com.dongfang.client.zhongxin.annex.library.service;

import java.util.List;

import com.dongfang.client.zhongxin.annex.library.vo.AnnexLibraryVO;

/**
  * @ClassName: AnnexLibraryService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface AnnexLibraryService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public AnnexLibraryVO getById(String id) throws Exception;
	
	/**
	  * 根据idNumber获取员工信息
	  * @param idNumber	员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibraryVO> getList(String telephone,String passWord) throws Exception;
	
	
	/**
	  * 根据idNumber获取员工信息，查找电话账号是否存在
	  * @param idNumber	员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibraryVO> getByPersonId(String personId) throws Exception;
	
	
	/**
	  * 标签信息
	  * @param 
	  * @return
	  * @throws Exception 
	  */;
	public List<AnnexLibraryVO>  getByAnnexLibraryList() throws Exception;
	

	
	/**
	  * 根据departmentId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibraryVO>  getByDepartment(String departmentId) throws Exception;
	
	/**
	  * 根据unionId获取员工信息列表
	  * @param unionId 员工微信登陆唯一标识
	  * @return
	  * @throws Exception 
	  */
	public AnnexLibraryVO getByUnionIdEncryption(String unionIdEncryption) throws Exception;
	/**
	  * 根据companyId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibraryVO>  getByideaIdEmployeeId(String ideaId,String annexLibraryatorId) throws Exception;
	/**
	  * 保存员工信息
	  * @param annexLibraryVO	员工
	  * @throws Exception 
	  */
	public String save(AnnexLibraryVO annexLibraryVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param annexLibraryVO
	  * @throws Exception 
	  */
	public void update(AnnexLibraryVO annexLibraryVO) throws Exception;
	
	/**
	  * 获取评论列表
	  * @param annexLibraryVO
	  * @throws Exception 
	  */
	public List<AnnexLibraryVO> getByAnnexLibraryatorId(String annexLibraryatorId) throws Exception;
}
