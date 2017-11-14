package com.dongfang.client.zhongxin.commons.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBeanUtils extends BeanUtils {
	/**
	  * 获取属性对象
	  * @param object
	  * @param propertyName
	  * @return
	  * @throws NoSuchFieldException 
	  */
	public static Field getDeclaredField(Object object, String propertyName) throws NoSuchFieldException {
		if(object == null ||
				StringUtils.isBlank(propertyName)) {
			LOGGER.error("MyBeanUtils#getDeclaredField({}, {}) : {}", 
					object == null?"null" : object.toString(),
					StringUtils.isBlank(propertyName)?"null" : propertyName,
					"参数不能为空");
		}
		return getDeclaredField(object.getClass(), propertyName);
	}
	
	/**
	  * 获取属性对象
	  * @param clazz
	  * @param propertyName
	  * @return
	  * @throws NoSuchFieldException 
	  */
	@SuppressWarnings("rawtypes")
	public static Field getDeclaredField(Class clazz, String propertyName) throws NoSuchFieldException {
		if(clazz == null ||
				StringUtils.isBlank(propertyName)) {
			LOGGER.error("MyBeanUtils#getDeclaredField({}, {}) : {}", 
					clazz == null?"null" : clazz.toString(),
					StringUtils.isBlank(propertyName)?"null" : propertyName,
					"参数不能为空");
		}
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(propertyName);
			} catch (NoSuchFieldException e) {
				LOGGER.error("MyBeanUtils#getDeclaredField({}, {}) : {}", 
						clazz == null?"null" : clazz.toString(),
						StringUtils.isBlank(propertyName)?"null" : propertyName,
						ExceptionUtils.getFullStackTrace(e));
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + propertyName);
	}
	
	/**
	  * 获取属性取值
	  * @param object
	  * @param propertyName
	  * @return
	  * @throws NoSuchFieldException 
	  */
	public static Object getPropertyValue(Object object, String propertyName) throws NoSuchFieldException {
		LOGGER.error("MyBeanUtils#getPropertyValue({}, {}) : {}", 
				object == null?"null" : object.toString(),
				StringUtils.isBlank(propertyName)?"null" : propertyName,
				"参数不能为空");
		Field field = getDeclaredField(object, propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			LOGGER.error("MyBeanUtils#getPropertyValue({}, {}) : {}", 
					object == null?"null" : object.toString(),
					StringUtils.isBlank(propertyName)?"null" : propertyName,
					ExceptionUtils.getFullStackTrace(e));
		}
		field.setAccessible(accessible);
		return result;
	}
	
	/**
	  * 获取取值为空的属性
	  * @param t
	  * @return
	  * @throws IllegalAccessException
	  * @throws InvocationTargetException
	  * @throws NoSuchMethodException
	  * @throws NoSuchFieldException 
	  */
	public static  <T> List<String> getNullProperty(T t) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, NoSuchFieldException {
		List<String> nullProperties = new ArrayList<String>();
		Field[] fs = t.getClass().getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			String propertyName = fs[i].getName();
			try {
				if(getPropertyValue(t, propertyName) == null){
					nullProperties.add(propertyName);
				}
			} catch (NoSuchFieldException e) {
				continue;
			}
		}
		return nullProperties;
	}
	
	/**
	  * 获取忽略更新的属性
	  * @param object
	  * @param updateProperties
	  * @param ignoreProperties
	  * @param isAllowReset
	  * @return
	  * @throws IllegalAccessException
	  * @throws InvocationTargetException
	  * @throws NoSuchMethodException
	  * @throws NoSuchFieldException 
	  */
	public static <T> List<String> ignoreProperties(T object,
													List<String> updateProperties, List<String> ignoreProperties,
													Boolean isAllowReset) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
		if(CollectionUtils.isEmpty(ignoreProperties)) {
			ignoreProperties = new ArrayList<String>();
		}
		if(isAllowReset == null || !isAllowReset) {
			ignoreProperties.addAll(getNullProperty(object));
			if(CollectionUtils.isNotEmpty(updateProperties)) {
				for (Iterator<String> it = ignoreProperties.iterator(); it.hasNext();) {
					String property = (String)it.next();
					if (updateProperties.contains(property)){
						it.remove();
					}
				}
			}
		}
		Field[] fs = object.getClass().getDeclaredFields();
		if(CollectionUtils.isNotEmpty(updateProperties)) {
			List<String> allProperties = new ArrayList<String>();
			for(Field field : fs) {
				if(!field.getName().equals("serialVersionUID"))
					allProperties.add(field.getName().toString());
			}
			for (Iterator<String> it = allProperties.iterator(); it.hasNext();) {
				String property = (String)it.next();
				if (updateProperties.contains(property)){
					it.remove();
				}
			}
			ignoreProperties.addAll(allProperties);
		}
		return ignoreProperties;
	}
	
	/**
	  * @Fields LOGGER : 日志记录器
	  */
	protected static final Logger LOGGER = LoggerFactory.getLogger(MyBeanUtils.class);
}
