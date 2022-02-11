package guavaStu.list;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


/**
 * 查找数据中最大和最小
 *
 * @author qidi
 * @date 2019-02-25 20:08
 */
public class FindDemo {
    public static void main(String[] args) {
        int a = Ints.max(1, 3, 4, 5);
        int b = Ints.min(1, 3, 4, 5);
        System.out.println(a);
        System.out.println(b);

        List<Integer> ids = Arrays.asList(1, 2, 12, 6);
        Optional<Integer> c = ids.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) > 0 ? 1 : (o1.compareTo(o2) == 0 ? 0 : -1);
            }
        });
        System.out.println(c);

        List<Integer> aooList = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> booList = Lists.newArrayList(1, 2, 3, 4, 6, 7);
        System.out.println(aooList.containsAll(booList));
        System.out.println(booList.containsAll(aooList));
    }
}
