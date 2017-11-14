package com.dongfang.client.zhongxin.project.client.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.project.client.dao.entity.ProjectClient;
import com.dongfang.client.zhongxin.project.client.vo.ProjectClientVO;

/**
  * @ClassName: ProjectClientBeanCopierUtil
  * @Description: ProjectClientBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class ProjectClientBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param projectClient
	  * @return 
	  */
	public static ProjectClientVO generateVO(ProjectClient projectClient) {
		ProjectClientVO projectClientVO = new ProjectClientVO();
		projectClientEntity2VoCopier.copy(projectClient, projectClientVO, projectClientEntity2VoConverter);
		return projectClientVO;
	}
	
	public static ProjectClient generateEntity(ProjectClientVO projectClientVO) {
		ProjectClient projectClient = new ProjectClient();
		projectClientVo2EntityCopier.copy(projectClientVO, projectClient, projectClientVo2EntityConverter);
		return projectClient;
	}
	
	/**
	  * @Fields projectClientEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier projectClientEntity2VoCopier = BeanCopier.create(ProjectClient.class, ProjectClientVO.class, true);
	/**
	  * @Fields projectClientEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final ProjectClientEntity2VoConverter projectClientEntity2VoConverter = new ProjectClientEntity2VoConverter();
	/**
	  * @Fields projectClientVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier projectClientVo2EntityCopier = BeanCopier.create(ProjectClientVO.class, ProjectClient.class, true);
	/**
	  * @Fields projectClientVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final ProjectClientVo2EntityConverter projectClientVo2EntityConverter = new ProjectClientVo2EntityConverter();
}
