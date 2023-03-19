package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2019-07-10 14:29
 */
public class FilterDemo {

    public static void main(String[] args) {
        List<SortDemo.Foo> foos = Lists.newArrayList(new SortDemo.Foo("b", 2, new SortDemo.Aoo("a1", 1), true), new SortDemo.Foo("a", 1, new SortDemo.Aoo("a2", 2), true));
        //过滤掉第一个
        List<SortDemo.Foo> filteredList = foos.stream().filter(foo -> foo.getId().equals(1)).collect(Collectors.toList());
        System.out.println(filteredList);

        //过滤掉a1
        filteredList = foos.stream().filter(foo -> foo.getAoo().getTitle().contains("a1")).collect(Collectors.toList());
        System.out.println(filteredList);
    }


    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    static
    class Foo {
        private String name;
        private Integer id;
        private SortDemo.Aoo aoo;

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
