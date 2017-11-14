package com.dongfang.client.zhongxin.finance.service;

import java.util.List;

import com.dongfang.client.zhongxin.finance.vo.FinanceVO;

/**
  * @ClassName: FinanceService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface FinanceService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public FinanceVO getById(String id) throws Exception;
	

	
	

	

	
	/**
	  * 根据company获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<FinanceVO> getStaffList(String companyId)throws Exception;
	

	

	/**
	  * 根据companyId获取员工信息列表
	  * @param company  员工所属公司
	  * @return
	  * @throws Exception 
	  */
	public List<FinanceVO>  getByCompanyId(String companyId) throws Exception;
	/**
	  * 保存员工信息
	  * @param financeVO	员工
	  * @throws Exception 
	  */
	public String save(FinanceVO financeVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param financeVO
	  * @throws Exception 
	  */
	public void update(FinanceVO financeVO) throws Exception;
}
