package com.dongfang.client.zhongxin.idea.dao;

import java.util.List;

import com.dongfang.client.zhongxin.idea.dao.entity.Idea;

/**
  * @ClassName: IdeaDAO
  * @Description: 员工数据访问层
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:13:53
  *
*/
public interface IdeaDAO {
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
	public Idea getById(String id) throws Exception;
	
	
	
	public List<Idea> getByIdeaList() throws Exception;
	
	/**
	  * 保存员工信息
	  * @param idea
	  * @throws Exception 
	  */
	
	public String save(Idea idea) throws Exception;
	
	/**
	  * 修改员工信息
	  * @param idea
	  * @throws Exception 
	  */
	public void update(Idea idea) throws Exception;
	

	
	
}
