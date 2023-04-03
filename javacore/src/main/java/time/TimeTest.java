package time;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Java获取 ISO 8601格式时间
 * 时间函数使用joda-time更精准因为：https://www.cnblogs.com/lyh971134228/articles/6354319.html
 * joda-time
 * User: qidi
 * Date: 2018/9/19
 * Time: 下午7:35
 */
public class TimeTest {


    public static void main(String[] args) throws ParseException {
        //以 Joda 的方式向某一个瞬间加上 90 天并输出结果
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTime.plusDays(90).toString("yyyy/MM/dd HH:mm:ss.SSS"));

        //距离 2000年 45 天之后的某天在下一个月的当前周的最后一天的日期
        DateTime dateTime1 = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTime1.plusDays(45).plusMonths(1).dayOfWeek().withMaximumValue().toString("E yyyy/MM/dd HH:mm:ss.SSS"));

        //将 Joda 计算结果插入到 JDK 对象中
        Calendar calendar = Calendar.getInstance();
        DateTime dateTime2 = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTime2.plusDays(45).plusMonths(1).dayOfWeek().withMaximumValue().toString("E yyyy/MM/dd HH:mm:ss.SSS"));
        calendar.setTime(dateTime2.toDate());

        //增减天，月，计算
        DateTime dateTime3 = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        DateTime dateTime4 = dateTime3.minusMonths(1).minusWeeks(1).minusDays(1).minusHours(1).toDateTime();
        System.out.println(dateTime4.toString("yyyy/MM/dd HH:mm:ss.SSS"));


    }
}
