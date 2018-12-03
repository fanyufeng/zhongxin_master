package com.dongfang.client.zhongxin.annex.library.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.annex.library.dao.entity.AnnexLibrary;
import com.dongfang.client.zhongxin.annex.library.vo.AnnexLibraryVO;

/**
  * @ClassName: AnnexLibraryBeanCopierUtil
  * @Description: AnnexLibraryBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class AnnexLibraryBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param annexLibrary
	  * @return 
	  */
	public static AnnexLibraryVO generateVO(AnnexLibrary annexLibrary) {
		AnnexLibraryVO annexLibraryVO = new AnnexLibraryVO();
		annexLibraryEntity2VoCopier.copy(annexLibrary, annexLibraryVO, annexLibraryEntity2VoConverter);
		return annexLibraryVO;
	}
	
	public static AnnexLibrary generateEntity(AnnexLibraryVO annexLibraryVO) {
		AnnexLibrary annexLibrary = new AnnexLibrary();
		annexLibraryVo2EntityCopier.copy(annexLibraryVO, annexLibrary, annexLibraryVo2EntityConverter);
		return annexLibrary;
	}
	
	/**
	  * @Fields annexLibraryEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier annexLibraryEntity2VoCopier = BeanCopier.create(AnnexLibrary.class, AnnexLibraryVO.class, true);
	/**
	  * @Fields annexLibraryEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final AnnexLibraryEntity2VoConverter annexLibraryEntity2VoConverter = new AnnexLibraryEntity2VoConverter();
	/**
	  * @Fields annexLibraryVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier annexLibraryVo2EntityCopier = BeanCopier.create(AnnexLibraryVO.class, AnnexLibrary.class, true);
	/**
	  * @Fields annexLibraryVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final AnnexLibraryVo2EntityConverter annexLibraryVo2EntityConverter = new AnnexLibraryVo2EntityConverter();
}
