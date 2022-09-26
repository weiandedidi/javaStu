package java8.lamada.grammer;

import com.google.common.collect.Lists;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 占位符测试
 *
 * @author maqidi
 * @date 2022/8/15 10:59 AM
 */
public class StringDemo {
    public static void main(String[] args) {
        List<String> a = Lists.newArrayList("a", "b");
        String collect = a.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("0%d", i));
        }
        System.out.println(String.format("总订单件数: %d; 机器拣货数量: %d", 10, 5));
    }
}
