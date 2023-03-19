package java8.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * java8 测试时间类
 *
 * @author maqidi
 * @date 2022/11/21 3:02 PM
 */
public class TimeTestDemo {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        //格林威治时间是从 0开始计时的
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

        int seconds = calendar.get(Calendar.SECOND);
        System.out.println(seconds);

        TimeTestDemo demo = new TimeTestDemo();
        System.out.println(demo.parseTag(8, 20));
    }


    public int parseTag(int startHour, int endHour) {
        //使用格林威治时间进行计时计算
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        if (startHour <= hour && hour <= endHour) {
            return 1;
        } else {
            return 2;
        }
    }
}
