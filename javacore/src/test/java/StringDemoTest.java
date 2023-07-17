import org.junit.Test;

import java.util.Date;
import java.util.Optional;

/**
 * @author maqidi
 * @date 2023/6/9 5:50 PM
 */
public class StringDemoTest {


    public static Date getDate(Long time) {
        return Optional.ofNullable(time)
                .map(Date::new)
                .orElse(new Date());
    }

    @Test
    public void test() {
        System.out.println(getDate(1687248949885L));
    }

}
