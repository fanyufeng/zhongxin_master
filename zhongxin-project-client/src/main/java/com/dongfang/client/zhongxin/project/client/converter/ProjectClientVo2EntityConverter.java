package com.dongfang.client.zhongxin.project.client.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

/**
  * @ClassName: ProjectClientVo2EntityConverter
  * @Description: 员工转换器，Vo->Entity
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午11:17:57
  *
*/
public class ProjectClientVo2EntityConverter implements Converter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object convert(Object value, Class target, Object context) {
		LOGGER.debug("参数value=({},{}),target={},context={}",
				value == null?"null":value.getClass(), value, target, context.toString());		
		return value;
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectClientVo2EntityConverter.class);
	/**
	  * @Fields projectClientCustomPropertyEntity2VOCopier : 自定义属性信息Copier
	  */
	
}
