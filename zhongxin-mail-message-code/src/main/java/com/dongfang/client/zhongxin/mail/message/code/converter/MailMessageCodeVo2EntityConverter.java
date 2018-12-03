package com.dongfang.client.zhongxin.mail.message.code.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Converter;

/**
  * @ClassName: EmployeeVo2EntityConverter
  * @Description: 自定义属性转换器，Vo->Entity
  * @author fyf820@163.com
  * @date 2016年5月3日 上午11:17:57
  *
*/
public class MailMessageCodeVo2EntityConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public Object convert(Object value, Class target, Object context) {
		LOGGER.debug("参数value=({},{}),target={},context={}",
				value == null?"null":value.getClass(), value, target, context.toString());
		return value;
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(MailMessageCodeVo2EntityConverter.class);
}
