import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 空和空字符串
 *
 * @author qidi
 * @date 2019-07-10 20:01
 */
public class StringUtilsTest {
    public static void main(String[] args) {

        String str = " ";
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.isBlank(str));

        String wmOrderId = "1234567890";
        String lastFourChars = StringUtils.substring(wmOrderId, wmOrderId.length() - 4);
        System.out.println(lastFourChars);

        List<String> abc = Lists.newArrayList("12345678901_123", "12345678901,123");
        List<String> result = abc.stream()
                .map(item -> item.replaceAll("[^\\d]", ""))
                .map(item -> item.substring(item.length() - 4))
                .distinct()
                .collect(Collectors.toList());


        System.out.println(result);
    }
}
