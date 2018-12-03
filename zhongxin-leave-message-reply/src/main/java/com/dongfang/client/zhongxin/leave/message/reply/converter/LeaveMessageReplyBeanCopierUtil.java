package com.dongfang.client.zhongxin.leave.message.reply.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.leave.message.reply.dao.entity.LeaveMessageReply;
import com.dongfang.client.zhongxin.leave.message.reply.vo.LeaveMessageReplyVO;



/**
  * @ClassName: LeaveMessageReplyBeanCopierUtil
  * @Description: LeaveMessageReplyBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class LeaveMessageReplyBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param leaveMessageReply
	  * @return 
	  */
	public static LeaveMessageReplyVO generateVO(LeaveMessageReply leaveMessageReply) {
		LeaveMessageReplyVO leaveMessageReplyVO = new LeaveMessageReplyVO();
		leaveMessageReplyEntity2VoCopier.copy(leaveMessageReply, leaveMessageReplyVO, leaveMessageReplyEntity2VoConverter);
		return leaveMessageReplyVO;
	}
	
	public static LeaveMessageReply generateEntity(LeaveMessageReplyVO leaveMessageReplyVO) {
		LeaveMessageReply leaveMessageReply = new LeaveMessageReply();
		leaveMessageReplyVo2EntityCopier.copy(leaveMessageReplyVO, leaveMessageReply, leaveMessageReplyVo2EntityConverter);
		return leaveMessageReply;
	}
	
	/**
	  * @Fields leaveMessageReplyEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier leaveMessageReplyEntity2VoCopier = BeanCopier.create(LeaveMessageReply.class, LeaveMessageReplyVO.class, true);
	/**
	  * @Fields leaveMessageReplyEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final LeaveMessageReplyEntity2VoConverter leaveMessageReplyEntity2VoConverter = new LeaveMessageReplyEntity2VoConverter();
	/**
	  * @Fields leaveMessageReplyVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier leaveMessageReplyVo2EntityCopier = BeanCopier.create(LeaveMessageReplyVO.class, LeaveMessageReply.class, true);
	/**
	  * @Fields leaveMessageReplyVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final LeaveMessageReplyVo2EntityConverter leaveMessageReplyVo2EntityConverter = new LeaveMessageReplyVo2EntityConverter();
}
