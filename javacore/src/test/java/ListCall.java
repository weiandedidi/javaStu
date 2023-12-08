import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 计算list方法
 *
 * @author qidi
 * @date 2019-10-15 12:58
 */
public class ListCall {

    public static void main(String[] args) {
//        List<Integer> list_1 = Lists.newArrayList(1, 2, 3, 4, 5);
//        List<Integer> list_2 = Lists.newArrayList(3, 4, 5);
//        list_1.addAll(list_2);
//        System.out.println(list_1);
//
//        list_1.removeAll(list_2);
//        System.out.println(list_1);
//        System.out.println(list_2);
        List<Aoo> aooList = Lists.newArrayList(new Aoo("1", 1), new Aoo("1", 12), new Aoo("2", 2));
//        List<Aoo> aooList = Lists.newArrayList();
        Map<String, List<Aoo>> map = aooList.stream().collect(Collectors.groupingBy(Aoo::getName));
        System.out.println(map);
        aooList.forEach(aoo -> {
            System.out.println(aoo.getAge());
        });
        Set<Integer> ageList = aooList.stream().map(Aoo::getAge).collect(Collectors.toSet());

        Integer abc = 1;
        System.out.println(Objects.equals(abc, 1));

        List<Aoo> axx = Lists.newArrayList();
        Integer xxa = axx.stream().filter(o -> o.getName().equals("xx")).findFirst().map(Aoo::getAge).orElse(null);
        System.out.println(xxa);


    }


    @Data
    @AllArgsConstructor
    static class Aoo {
        private String name;
        private int age;
    }
}

