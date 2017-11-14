package com.dongfang.client.zhongxin.controller.dao;

import java.util.List;

import com.dongfang.client.zhongxin.controller.dao.entity.Controller;

/**
  * @ClassName: ControllerDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface ControllerDAO {
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
	public Controller getById(String id) throws Exception;
	
	
	
	/**
	  * 根据companyId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<Controller> getByCompanyId(String companyId) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param controller
	  * @throws Exception 
	  */
	
	public String save(Controller controller) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param controller
	  * @throws Exception 
	  */
	public void update(Controller controller) throws Exception;
	
	
}
