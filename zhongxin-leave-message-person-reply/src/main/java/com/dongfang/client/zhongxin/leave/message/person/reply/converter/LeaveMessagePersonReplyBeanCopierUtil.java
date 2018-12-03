package com.dongfang.client.zhongxin.leave.message.person.reply.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.leave.message.person.reply.dao.entity.LeaveMessagePersonReply;
import com.dongfang.client.zhongxin.leave.message.person.reply.vo.LeaveMessagePersonReplyVO;



/**
  * @ClassName: LeaveMessagePersonReplyBeanCopierUtil
  * @Description: LeaveMessagePersonReplyBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class LeaveMessagePersonReplyBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param leaveMessagePersonReply
	  * @return 
	  */
	public static LeaveMessagePersonReplyVO generateVO(LeaveMessagePersonReply leaveMessagePersonReply) {
		LeaveMessagePersonReplyVO leaveMessagePersonReplyVO = new LeaveMessagePersonReplyVO();
		leaveMessagePersonReplyEntity2VoCopier.copy(leaveMessagePersonReply, leaveMessagePersonReplyVO, leaveMessagePersonReplyEntity2VoConverter);
		return leaveMessagePersonReplyVO;
	}
	
	public static LeaveMessagePersonReply generateEntity(LeaveMessagePersonReplyVO leaveMessagePersonReplyVO) {
		LeaveMessagePersonReply leaveMessagePersonReply = new LeaveMessagePersonReply();
		leaveMessagePersonReplyVo2EntityCopier.copy(leaveMessagePersonReplyVO, leaveMessagePersonReply, leaveMessagePersonReplyVo2EntityConverter);
		return leaveMessagePersonReply;
	}
	
	/**
	  * @Fields leaveMessagePersonReplyEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier leaveMessagePersonReplyEntity2VoCopier = BeanCopier.create(LeaveMessagePersonReply.class, LeaveMessagePersonReplyVO.class, true);
	/**
	  * @Fields leaveMessagePersonReplyEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final LeaveMessagePersonReplyEntity2VoConverter leaveMessagePersonReplyEntity2VoConverter = new LeaveMessagePersonReplyEntity2VoConverter();
	/**
	  * @Fields leaveMessagePersonReplyVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier leaveMessagePersonReplyVo2EntityCopier = BeanCopier.create(LeaveMessagePersonReplyVO.class, LeaveMessagePersonReply.class, true);
	/**
	  * @Fields leaveMessagePersonReplyVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final LeaveMessagePersonReplyVo2EntityConverter leaveMessagePersonReplyVo2EntityConverter = new LeaveMessagePersonReplyVo2EntityConverter();
}
