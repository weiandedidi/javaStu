package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2020-03-26 16:54
 */
public class StreamList {


    public static void main(String[] args) {
//        List<Aoo> aooList = Lists.newArrayList(new Aoo(1, "1"), new Aoo(2, "2"));

//        System.out.println(aooList.stream().findAny());
        List<Aoo> aooList = Lists.newArrayList();


        List<String> xxList = Lists.transform(aooList, input -> input.getType().toString());
        System.out.println(xxList);

        Map<String, Aoo> map = aooList.stream().filter(aoo -> aoo.getType() == 3).collect(Collectors.toMap(Aoo::getName, a -> a, (k1, k2) -> k1));

        System.out.println(aooList.stream().filter(aoo -> aoo.getType() == 3).collect(Collectors.toList()).size());

        System.out.println(map);


//        aooList = null;

        List<String> skuIdList = Lists.transform(Optional.ofNullable(aooList).orElse(Lists.newArrayList()), input -> input.getType().toString());

        System.out.println(skuIdList);


        System.out.println(getAoos(aooList));

        Set<Integer> typeSet = aooList.stream().collect(Collectors.groupingBy(Aoo::getType)).keySet();
        System.out.println(typeSet.contains(1));

        //测试空 addAll
        List<String> yyList = Lists.newArrayList("a", "b");
        yyList.addAll(Lists.newArrayList());
        System.out.println(yyList);


    }


    @Data
    @AllArgsConstructor
    static
    class Aoo {
        private Integer type;
        private String name;
    }

    public static List<Aoo> getAoos(List<Aoo> aooList) {
        return Optional.ofNullable(aooList).orElse(Lists.newArrayList());
    }
}
