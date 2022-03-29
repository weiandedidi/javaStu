package java8.lamada.collection;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author qidi
 * @date 2020-03-25 21:04
 */
public class OptionalTest {
    public static void main(String[] args) {
//        List<Integer> list = null;
        List<Integer> list = new ArrayList<>();
        list.add(7);
        List<Integer> ab = Optional.ofNullable(list).orElse(Lists.newArrayList(5));

        System.out.println(ab);

    }
}
