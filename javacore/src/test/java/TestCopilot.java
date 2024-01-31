import org.joda.time.DateTime;

/**
 * @author maqidi
 * @date 2024/1/31 17:14
 */
public class TestCopilot {
    public static void main(String[] args) {
        DateTime now = DateTime.now();
        DateTime nextYear = now.plusYears(1);
        DateTime targetDate = new DateTime(nextYear.getYear(), 2, 28, 0, 0);
        int dayOfWeek = targetDate.getDayOfWeek();
        System.out.println("明年的2月28日是星期" + dayOfWeek);
    }
}
