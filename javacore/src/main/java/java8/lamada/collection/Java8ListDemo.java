package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 获取list中某属性
 * 方法一：
 * List<Integer> id = aoos.stream().map(Aoo::getId).collect(Collectors.toList());
 * 方法二：（list元素个数不会变化了，才能使用此方法）
 * List<Integer> ids = Lists.transform(aoos, Aoo::getId);
 *
 * @author qidi
 * @date 2019-01-29 14:07
 */
public class Java8ListDemo {

    public static void main(String[] args) {

        List<Aoo> aoos = Lists.newArrayList(new Aoo(1, 10), new Aoo(2, 11), new Aoo(3, 12));

        //list不明确的情况下，建议使用stream
        List<Integer> idList = aoos.stream().map(Aoo::getId).collect(Collectors.toList());
        System.out.println(idList);

        List<String> idStrList = aoos.stream().map(s -> s.getId().toString()).collect(Collectors.toList());
        System.out.println(idStrList.get(0).getClass() + "---" + idList);

        //切记，一单list中的元素发生变化的时候，使用transform会使用变化后的集合
        List<Integer> ids = Lists.transform(aoos, Aoo::getId);
        aoos.add(new Aoo(4, 15));
        System.out.println(ids);

        //测试聚合
        //List<Aoo> testSumList = Lists.newArrayList();
        List<Aoo> testSumList = null;
        int orderTotal = Optional.ofNullable(testSumList).orElse(new ArrayList<>()).stream().mapToInt(Aoo::getAge).sum();
        System.out.println(orderTotal);

    }

    @Data
    @AllArgsConstructor
    private static class Aoo {
        private Integer id;
        private Integer age;
    }
}
