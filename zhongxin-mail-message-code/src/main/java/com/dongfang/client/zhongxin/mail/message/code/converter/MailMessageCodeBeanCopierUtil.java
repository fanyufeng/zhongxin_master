package com.dongfang.client.zhongxin.mail.message.code.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.mail.message.code.dao.entity.MailMessageCode;
import com.dongfang.client.zhongxin.mail.message.code.vo.MailMessageCodeVO;





/**
  * @ClassName: MailMessageCodeBeanCopierUtil
  * @Description: MailMessageCodeBeanCopier工具
  * @author fyf820@163.com
  * @date 2016年5月3日 上午10:58:45
  *
*/
public class MailMessageCodeBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param mailMessageCode
	  * @return 
	  */
	public static MailMessageCodeVO generateVO(MailMessageCode mailMessageCode) {
		MailMessageCodeVO mailMessageCodeVO = new MailMessageCodeVO();
		mailMessageCodeEntity2VoCopier.copy(mailMessageCode, mailMessageCodeVO, mailMessageCodeEntity2VoConverter);
		return mailMessageCodeVO;
	}
	
	public static MailMessageCode generateEntity(MailMessageCodeVO mailMessageCodeVO) {
		MailMessageCode mailMessageCode = new MailMessageCode();
		mailMessageCodeVo2EntityCopier.copy(mailMessageCodeVO, mailMessageCode, mailMessageCodeVo2EntityConverter);
		return mailMessageCode;
	}
	
	/**
	  * @Fields mailMessageCodeEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier mailMessageCodeEntity2VoCopier = BeanCopier.create(MailMessageCode.class, MailMessageCodeVO.class, true);
	/**
	  * @Fields mailMessageCodeEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final MailMessageCodeEntity2VoConverter mailMessageCodeEntity2VoConverter = new MailMessageCodeEntity2VoConverter();
	/**
	  * @Fields mailMessageCodeVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier mailMessageCodeVo2EntityCopier = BeanCopier.create(MailMessageCodeVO.class, MailMessageCode.class, true);
	/**
	  * @Fields mailMessageCodeVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final MailMessageCodeVo2EntityConverter mailMessageCodeVo2EntityConverter = new MailMessageCodeVo2EntityConverter();
}
