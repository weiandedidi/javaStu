package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

/**
 * @author qidi
 * @date 2019-07-10 11:35
 */
public class SortDemo {
    public static void main(String[] args) {
        List<Foo> foos = Lists.newArrayList(new Foo("b", 2, new Aoo("a1", 1), false), new Foo("b", 1, new Aoo("a1", 1), true), new Foo("a", 1, new Aoo("a2", 2), false));
        foos.sort(Comparator.comparing(Foo::getId));
        System.out.println(foos);
        //按照 name排序，name相同按照id大小排序
        foos.sort(Comparator.comparing(Foo::getFlag).reversed().thenComparing(Foo::getName).thenComparing(Foo::getId));
        System.out.println(foos);

        //按照元素内排序
        foos.sort(Comparator.comparing(o -> o.getAoo().getAId()));
        System.out.println(foos);
        //进行逆序
        foos.stream().sorted(Comparator.comparing(Foo::getId).reversed());
        System.out.println(foos);
    }

    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    static
    class Foo {
        private String name;
        private Integer id;
        private Aoo aoo;
        private Boolean flag;

    }

    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    static
    class Aoo {
        private String title;
        private Integer aId;
    }


}
