package com.dongfang.client.zhongxin.employee.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Converter;

/**
  * @ClassName: EmployeeEntity2VoConverter
  * @Description: 员工转换器，Entity->Vo
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:17:01
  *
*/
public class EmployeeEntity2VoConverter implements Converter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object convert(Object value, Class target, Object context) {
		LOGGER.debug("参数value=({},{}),target={},context={}",
				value == null?"null":value.getClass(), value, target, context.toString());
		return value;
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeEntity2VoConverter.class);
	/**
	  * @Fields employeeCustomPropertyEntity2VOCopier : 自定义属性信息Copier
	  */
	
}
