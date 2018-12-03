package com.dongfang.client.zhongxin.leave.message.person.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.leave.message.person.dao.entity.LeaveMessagePerson;
import com.dongfang.client.zhongxin.leave.message.person.vo.LeaveMessagePersonVO;



/**
  * @ClassName: LeaveMessagePersonBeanCopierUtil
  * @Description: LeaveMessagePersonBeanCopier工具
  * @author fyf820@163.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class LeaveMessagePersonBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param leaveMessagePerson
	  * @return 
	  */
	public static LeaveMessagePersonVO generateVO(LeaveMessagePerson leaveMessagePerson) {
		LeaveMessagePersonVO leaveMessagePersonVO = new LeaveMessagePersonVO();
		leaveMessagePersonEntity2VoCopier.copy(leaveMessagePerson, leaveMessagePersonVO, leaveMessagePersonEntity2VoConverter);
		return leaveMessagePersonVO;
	}
	
	public static LeaveMessagePerson generateEntity(LeaveMessagePersonVO leaveMessagePersonVO) {
		LeaveMessagePerson leaveMessagePerson = new LeaveMessagePerson();
		leaveMessagePersonVo2EntityCopier.copy(leaveMessagePersonVO, leaveMessagePerson, leaveMessagePersonVo2EntityConverter);
		return leaveMessagePerson;
	}
	
	/**
	  * @Fields leaveMessagePersonEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier leaveMessagePersonEntity2VoCopier = BeanCopier.create(LeaveMessagePerson.class, LeaveMessagePersonVO.class, true);
	/**
	  * @Fields leaveMessagePersonEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final LeaveMessagePersonEntity2VoConverter leaveMessagePersonEntity2VoConverter = new LeaveMessagePersonEntity2VoConverter();
	/**
	  * @Fields leaveMessagePersonVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier leaveMessagePersonVo2EntityCopier = BeanCopier.create(LeaveMessagePersonVO.class, LeaveMessagePerson.class, true);
	/**
	  * @Fields leaveMessagePersonVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final LeaveMessagePersonVo2EntityConverter leaveMessagePersonVo2EntityConverter = new LeaveMessagePersonVo2EntityConverter();
}
