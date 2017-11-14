package com.dongfang.client.zhongxin.commons.utils;

import java.util.UUID;

public class IDGeneratorUtils {
	/**
	  * 32位大写UUID字符串（基于JAVA工具类生成）
	  * @return 
	  * @return String
	 */
	public static String uuid32(){
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
}
