package com.dongfang.client.zhongxin.annex.library.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Converter;

/**
  * @ClassName: AnnexLibraryVo2EntityConverter
  * @Description: 员工转换器，Vo->Entity
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:17:57
  *
*/
public class AnnexLibraryVo2EntityConverter implements Converter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object convert(Object value, Class target, Object context) {
		LOGGER.debug("参数value=({},{}),target={},context={}",
				value == null?"null":value.getClass(), value, target, context.toString());		
		return value;
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnexLibraryVo2EntityConverter.class);
	/**
	  * @Fields annexLibraryCustomPropertyEntity2VOCopier : 自定义属性信息Copier
	  */
	
}
