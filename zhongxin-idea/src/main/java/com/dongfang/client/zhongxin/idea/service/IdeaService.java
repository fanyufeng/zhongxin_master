package com.dongfang.client.zhongxin.idea.service;

import java.util.List;

import com.dongfang.client.zhongxin.idea.vo.IdeaVO;

/**
  * @ClassName: IdeaService
  * @Description: 员工业务层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:10:03
  *
*/
public interface IdeaService {
	/**
	  * 根据id获取员工信息
	  * @param id	员工id
	  * @return
	  * @throws Exception 
	  */
	public IdeaVO getById(String id) throws Exception;

	public List<IdeaVO>  getByIdeaList(int currentPage, int pageSize) throws Exception;
	public List<IdeaVO>  getByStatus(int status) throws Exception;
	public List<IdeaVO>  getByCategory(String category, int currentPage, int pageSize) throws Exception;
	public List<IdeaVO>  getByCreaterId(String createrId) throws Exception;
	public List<IdeaVO>  getByRecipientId(String recipientId) throws Exception;


	/**
	  * 保存员工信息
	  * @param ideaVO	员工
	  * @throws Exception 
	  */
	public String save(IdeaVO ideaVO) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param ideaVO
	  * @throws Exception 
	  */
	public void update(IdeaVO ideaVO) throws Exception;
}
