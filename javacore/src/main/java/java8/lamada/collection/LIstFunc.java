package java8.lamada.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author maqidi
 * @date 2022/1/21 11:08 上午
 */
public class LIstFunc {
    public static void main(String[] args) {
        //测试集合移除
        List<Integer> list = Lists.newArrayList(1, 3, 5, 7, 9);
        list.removeIf(o -> o > 5);
        System.out.println(list);

        //测试集合顾虑
        Integer result = list.stream().filter(o -> !o.equals(3)).findFirst().orElse(null);
        System.out.println(result);

        int smallestSide = Ordering.natural().min(Lists.newArrayList(-3, 2, 4, 5));
        System.out.println(smallestSide);

        //拼接
        List<String> integerList = Lists.newArrayList("1", "3", "5", "7", "9");
        String strList = integerList.stream().collect(Collectors.joining(","));
        System.out.println(strList);
        String strListV2 = String.join(",", integerList);
        System.out.println(strListV2);







    }
}
