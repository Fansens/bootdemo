package com.hoopoe.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * Created by wildcrab on 17-3-22.
 */
public class DateUtils {

    private static SimpleDateFormat dateFormat;
    private static final String DEFAULT_PATTERN = "yyyyMMddHHmmss";//默认日期解析格式



    /**
     * 根据格式解析日期
     * @param dateString 日期字符串
     * @param pattern 格式字符串
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateString, String pattern) throws ParseException {
        if (StringUtils.isEmpty(dateString)){
            return null;
        }
        if (StringUtils.isEmpty(pattern)){
            pattern = DEFAULT_PATTERN;
        }
        dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(dateString);
    }
}
