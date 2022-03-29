package java8;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author maqidi
 * @date 2020/8/24 下午7:35
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest.test(null);
        OptionalTest.test(StringUtils.EMPTY);
        OptionalTest.test("hah");
        System.out.println(UUID.randomUUID().toString());

        List<String> abd = Lists.newArrayList("123", null);
        String xx = abd.stream().filter(Objects::nonNull).findFirst().orElse(null);
        System.out.println(xx);
        long a = 100L;
        int b = 100;
        System.out.println(a == b);

        List<String> newList = Lists.newArrayList();
        System.out.println(abd.size());
        System.out.println(abd);

        System.out.println(Objects.equals(1, null));
        System.out.println(Objects.equals(1, 1));

    }

    public static void test(String arg) {
        System.out.println(Optional.ofNullable(arg).orElse(StringUtils.EMPTY));
    }
}
