/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 *  字符处理
 *
 * StringUtils 
 * @author fansensen
 * @create 2017/3/22 17:11
 * @since JDK 1.7
 * @description: <描述>
 */
public final class StringUtils {
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

	/**
	 * 判断str是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if ( str == null || "".equals(str) ){
			return true;
		}
		return false;
	}
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}
