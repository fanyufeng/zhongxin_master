package com.dongfang.client.zhongxin.annex.library.dao;

import java.util.List;

import com.dongfang.client.zhongxin.annex.library.dao.entity.AnnexLibrary;

/**
  * @ClassName: AnnexLibraryDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface AnnexLibraryDAO {
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
	public AnnexLibrary getById(String id) throws Exception;
	
	/**
	  * 根据idNumber和密码获取员工信息
	  * @param idNumber  员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getListAnnexLibrary(String telephone,String passWord) throws Exception;
	
	
	/**
	  * 根据unionId获取员工信息
	  * @param unionId  微信登陆标识
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByUinonIdEncryption(String unionIdEncryption) throws Exception;
	/**
	  * 根据idNumber获取员工信息,查询账号是否重复
	  * @param idNumber  员工电话号码
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByPersonId(String personId) throws Exception;
	
	/**
	  * 根据获取标签信息
	  * @param 
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByAnnexLibraryList() throws Exception;
	/**
	  * 根据departmentId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByDepartment(String departmentId) throws Exception;
	
	/**
	  * 根据departmentId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByDepartmentId(String departmentId) throws Exception;
	
	/**
	  * 根据ideaId 和 annexLibraryatorId获取员工信息,查询账号是否重复
	  * @param 
	  * @return
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByideaIdEmployeeId(String ideaId,String annexLibraryatorId) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param annexLibrary
	  * @throws Exception 
	  */
	
	public String save(AnnexLibrary annexLibrary) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param annexLibrary
	  * @throws Exception 
	  */
	public void update(AnnexLibrary annexLibrary) throws Exception;
	/**
	  * 获取公司员工列表
	  * @param annexLibrary
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByCompany(String company) throws Exception;
	
	/**
	  * 获取评论列表
	  * @param annexLibrary
	  * @throws Exception 
	  */
	public List<AnnexLibrary> getByAnnexLibraryatorId(String annexLibraryatorId) throws Exception;
	
}
