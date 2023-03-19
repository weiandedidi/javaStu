package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 求list中某一属性加和,reduce 要求参数是非空的
 * <p>
 * 在0的基础上加和
 * Integer sum = integers.reduce(0, (a, b) -> a+b);
 * 加和一定写入0，否则会出现identity+结果。
 *
 * @author qidi
 * @date 2019-02-25 15:34
 */
public class ListSum {

    public static void main(String[] args) {


        //1.加和可以为空，空的时候返回3
        List<Aoo> aoos = Lists.newArrayList(new Aoo("1", 3), new Aoo("2", 4), new Aoo("3", 5));
        Optional<Integer> sum = Optional.ofNullable(aoos.stream().map(Aoo::getAge).reduce(0, Integer::sum));
        System.out.println(sum.orElse(3));

        //4. 加和操作
//        aoos = Lists.newArrayList(new Aoo("1", 3), new Aoo("2", 4), new Aoo("3", 5));
        aoos = Lists.newArrayList();
        int count = aoos.stream().mapToInt(Aoo::getAge).sum();
        System.out.println("加和操作" + count);

        Optional.ofNullable(aoos).orElse(Lists.newArrayList()).forEach(aoo -> {
//            System.out.println("xx" + aoo.getAge());
            System.out.println("xx");
        });


        //2.可以为空
        sum = Optional.ofNullable(null);
        System.out.println(sum.orElse(4));


        //reduce 要求参数是非空的
//        aoos = Lists.newArrayList(new Aoo("1", null), new Aoo("2", null), new Aoo("3", null));
//        //元素
//        System.out.println(aoos.stream().map(Aoo::getAge).collect(Collectors.toList()));
//
//        sum = Optional.ofNullable(aoos.stream().map(Aoo::getAge).reduce(0, Integer::sum));
//        System.out.println(sum);


        //3.reduce 要求参数是非空的
//        aoos = Lists.newArrayList(new Aoo("1", null), new Aoo("2", null), new Aoo("3", null));
//        sum = aoos.stream().map(Aoo::getAge).reduce(Integer::sum);
//        System.out.println(sum.orElse(5));


//        List<Aoo> aooXList = Lists.newArrayList();
        List<Aoo> aooXList = Lists.newArrayList(new Aoo("1", 1), new Aoo("1", 3), new Aoo("1", 8), new Aoo("2", 2));
//        List<Aoo> aooXList = Lists.newArrayList(new Aoo("1", 80));
        List<Aoo> aooXXList = aooXList.stream().collect(Collectors.groupingBy(Aoo::getName)).entrySet().stream().map(o -> {

            int countAgt = o.getValue().stream().mapToInt(Aoo::getAge).sum();
            return new Aoo(o.getKey(), countAgt);
        }).collect(Collectors.toList());
        System.out.println(aooXXList);

        List<Aoo> aooXXXList = aooXList.stream().collect(Collectors.groupingBy(Aoo::getName)).entrySet().stream().map(o -> {
            return o.getValue().stream().reduce((aoo, aoo2) -> {
                return new Aoo(aoo.getName(), aoo.getAge() + aoo2.getAge());
            }).orElse(null);
        }).collect(Collectors.toList());


        System.out.println(aooXXXList);


        List<Integer> integerList = aooXXList.stream().map(o -> {
            if (o.getAge() > 3) {
                return null;
            } else {
                return o.getAge();
            }
        }).collect(Collectors.toList());
        System.out.println(integerList);


//
//        //分类
//
//        Aoo xxo = new Aoo("1", 1);
//        Aoo xxoV1 = new Aoo();
//        BeanUtils.copyProperties(xxo, xxoV1);
//        System.out.println(xxoV1.getAge());
//        xxo.setAge(5);
//        System.out.println(xxoV1.getAge());
//        System.out.println(xxo.getAge());


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Aoo {
        private String name;
        private Integer age;
    }
}
