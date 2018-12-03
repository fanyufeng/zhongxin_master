package com.dongfang.client.zhongxin.message.code.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.message.code.dao.entity.MessageCode;
import com.dongfang.client.zhongxin.message.code.vo.MessageCodeVO;

/**
  * @ClassName: MessageCodeBeanCopierUtil
  * @Description: MessageCodeBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class MessageCodeBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param messageCodeCode
	  * @return 
	  */
	public static MessageCodeVO generateVO(MessageCode messageCodeCode) {
		MessageCodeVO messageCodeCodeVO = new MessageCodeVO();
		messageCodeCodeEntity2VoCopier.copy(messageCodeCode, messageCodeCodeVO, messageCodeCodeEntity2VoConverter);
		return messageCodeCodeVO;
	}
	
	public static MessageCode generateEntity(MessageCodeVO messageCodeCodeVO) {
		MessageCode messageCodeCode = new MessageCode();
		messageCodeCodeVo2EntityCopier.copy(messageCodeCodeVO, messageCodeCode, messageCodeCodeVo2EntityConverter);
		return messageCodeCode;
	}
	
	/**
	  * @Fields messageCodeCodeEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier messageCodeCodeEntity2VoCopier = BeanCopier.create(MessageCode.class, MessageCodeVO.class, true);
	/**
	  * @Fields messageCodeCodeEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final MessageCodeEntity2VoConverter messageCodeCodeEntity2VoConverter = new MessageCodeEntity2VoConverter();
	/**
	  * @Fields messageCodeCodeVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier messageCodeCodeVo2EntityCopier = BeanCopier.create(MessageCodeVO.class, MessageCode.class, true);
	/**
	  * @Fields messageCodeCodeVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final MessageCodeVo2EntityConverter messageCodeCodeVo2EntityConverter = new MessageCodeVo2EntityConverter();
}
