package com.dongfang.client.zhongxin.leave.message.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.leave.message.dao.entity.LeaveMessage;
import com.dongfang.client.zhongxin.leave.message.vo.LeaveMessageVO;



/**
  * @ClassName: LeaveMessageBeanCopierUtil
  * @Description: LeaveMessageBeanCopier工具
  * @author fyf820@163.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class LeaveMessageBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param leaveMessage
	  * @return 
	  */
	public static LeaveMessageVO generateVO(LeaveMessage leaveMessage) {
		LeaveMessageVO leaveMessageVO = new LeaveMessageVO();
		leaveMessageEntity2VoCopier.copy(leaveMessage, leaveMessageVO, leaveMessageEntity2VoConverter);
		return leaveMessageVO;
	}
	
	public static LeaveMessage generateEntity(LeaveMessageVO leaveMessageVO) {
		LeaveMessage leaveMessage = new LeaveMessage();
		leaveMessageVo2EntityCopier.copy(leaveMessageVO, leaveMessage, leaveMessageVo2EntityConverter);
		return leaveMessage;
	}
	
	/**
	  * @Fields leaveMessageEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier leaveMessageEntity2VoCopier = BeanCopier.create(LeaveMessage.class, LeaveMessageVO.class, true);
	/**
	  * @Fields leaveMessageEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final LeaveMessageEntity2VoConverter leaveMessageEntity2VoConverter = new LeaveMessageEntity2VoConverter();
	/**
	  * @Fields leaveMessageVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier leaveMessageVo2EntityCopier = BeanCopier.create(LeaveMessageVO.class, LeaveMessage.class, true);
	/**
	  * @Fields leaveMessageVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final LeaveMessageVo2EntityConverter leaveMessageVo2EntityConverter = new LeaveMessageVo2EntityConverter();
}
