package collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * list的测试remove
 *
 * @author qidi
 * @date 2020-02-07 11:32
 */
public class ListRemove {
    public static void main(String[] args) {
        List<Aoo> aoos = Lists.newArrayList(new Aoo("张三", 3), new Aoo("李四", 4));
        List<Aoo> subAoos = Lists.newArrayList(new Aoo("张三", 3), new Aoo("李四", 4), new Aoo("王五", 5));

//        aoos.removeAll(subAoos);
//        System.out.println(aoos.size());
//        subAoos.removeAll(aoos);
//        System.out.println(subAoos.size());

        //过滤测试
        List<Aoo> resultList = aoos.stream().filter(item -> "张三".equalsIgnoreCase(item.getName())).collect(Collectors.toList());
        System.out.println(resultList.size());
    }

    @Data
    @AllArgsConstructor
    static class Aoo {
        private String name;
        private int age;
    }
}
