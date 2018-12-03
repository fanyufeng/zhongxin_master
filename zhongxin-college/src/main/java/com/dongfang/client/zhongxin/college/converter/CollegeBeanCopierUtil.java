package com.dongfang.client.zhongxin.college.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.college.dao.entity.College;
import com.dongfang.client.zhongxin.college.vo.CollegeVO;

/**
  * @ClassName: CollegeBeanCopierUtil
  * @Description: CollegeBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class CollegeBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param college
	  * @return 
	  */
	public static CollegeVO generateVO(College college) {
		CollegeVO collegeVO = new CollegeVO();
		collegeEntity2VoCopier.copy(college, collegeVO, collegeEntity2VoConverter);
		return collegeVO;
	}
	
	public static College generateEntity(CollegeVO collegeVO) {
		College college = new College();
		collegeVo2EntityCopier.copy(collegeVO, college, collegeVo2EntityConverter);
		return college;
	}
	
	/**
	  * @Fields collegeEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier collegeEntity2VoCopier = BeanCopier.create(College.class, CollegeVO.class, true);
	/**
	  * @Fields collegeEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final CollegeEntity2VoConverter collegeEntity2VoConverter = new CollegeEntity2VoConverter();
	/**
	  * @Fields collegeVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier collegeVo2EntityCopier = BeanCopier.create(CollegeVO.class, College.class, true);
	/**
	  * @Fields collegeVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final CollegeVo2EntityConverter collegeVo2EntityConverter = new CollegeVo2EntityConverter();
}
