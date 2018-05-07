package com.dongfang.client.zhongxin.idea.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.idea.dao.entity.Idea;
import com.dongfang.client.zhongxin.idea.vo.IdeaVO;

/**
  * @ClassName: IdeaBeanCopierUtil
  * @Description: IdeaBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class IdeaBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param idea
	  * @return 
	  */
	public static IdeaVO generateVO(Idea idea) {
		IdeaVO ideaVO = new IdeaVO();
		ideaEntity2VoCopier.copy(idea, ideaVO, ideaEntity2VoConverter);
		return ideaVO;
	}
	
	public static Idea generateEntity(IdeaVO ideaVO) {
		Idea idea = new Idea();
		ideaVo2EntityCopier.copy(ideaVO, idea, ideaVo2EntityConverter);
		return idea;
	}
	
	/**
	  * @Fields ideaEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier ideaEntity2VoCopier = BeanCopier.create(Idea.class, IdeaVO.class, true);
	/**
	  * @Fields ideaEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final IdeaEntity2VoConverter ideaEntity2VoConverter = new IdeaEntity2VoConverter();
	/**
	  * @Fields ideaVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier ideaVo2EntityCopier = BeanCopier.create(IdeaVO.class, Idea.class, true);
	/**
	  * @Fields ideaVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final IdeaVo2EntityConverter ideaVo2EntityConverter = new IdeaVo2EntityConverter();
}
