package com.dongfang.client.zhongxin.finance.dao;

import java.util.List;

import com.dongfang.client.zhongxin.finance.dao.entity.Finance;

/**
  * @ClassName: FinanceDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface FinanceDAO {
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
	public Finance getById(String id) throws Exception;
	
	
	
	/**
	  * 根据companyId获取员工信息,查询账号是否重复
	  * @param email  员工邮箱
	  * @return
	  * @throws Exception 
	  */
	public List<Finance> getByCompanyId(String companyId) throws Exception;
	
	/**
	  * 保存员工信息
	  * @param finance
	  * @throws Exception 
	  */
	
	public String save(Finance finance) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param finance
	  * @throws Exception 
	  */
	public void update(Finance finance) throws Exception;
	
	
}
