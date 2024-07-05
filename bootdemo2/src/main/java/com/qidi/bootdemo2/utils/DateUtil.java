package com.qidi.bootdemo2.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 封装joda的时间工具，不用java自己的
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-07-05 19:52
 */
public class DateUtil {

    // 时间常量
    public static final int DAYS_IN_WEEK = 7;
    public static final int HOURS_IN_DAY = 24;
    public static final int SECONDS_IN_HOUR = 3600;
    public static final int SECONDS_IN_DAY = HOURS_IN_DAY * SECONDS_IN_HOUR;

    // 日期格式
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(DATE_TIME_FORMAT);

    /**
     * 获取当前10位时间戳
     *
     * @return 当前10位时间戳
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取当前时间加上指定天数的日期
     *
     * @param days 天数
     * @return 当前时间加上指定天数的日期
     */
    public static Date getDateAfterDays(int days) {
        return DateTime.now().plusDays(days).toDate();
    }

    /**
     * 获取当前时间加上指定天数后的10位时间戳
     *
     * @param days 天数
     * @return 当前时间加上指定天数后的10位时间戳
     */
    public static long getTimestampAfterDays(int days) {
        return getDateAfterDays(days).getTime() / 1000;
    }

    /**
     * 获取当前时间减去指定天数的日期
     *
     * @param days 天数
     * @return 当前时间减去指定天数的日期
     */
    public static Date getDateBeforeDays(int days) {
        return DateTime.now().minusDays(days).toDate();
    }

    /**
     * 获取当前时间减去指定天数后的10位时间戳
     *
     * @param days 天数
     * @return 当前时间减去指定天数后的10位时间戳
     */
    public static long getTimestampBeforeDays(int days) {
        return getDateBeforeDays(days).getTime() / 1000;
    }

    /**
     * 将 DateTime 格式化为字符串
     *
     * @param date 日期时间
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(Date date) {
        DateTime dateTime = new DateTime(date);
        return DATE_TIME_FORMATTER.print(dateTime);
    }

}