package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author maqidi
 * @date 2023/2/27 5:46 PM
 */
public class ListDemo {


    public static void main(String[] args) {
        List<Aoo> aoos = Lists.newArrayList(new Aoo("12", 1));
        aoos.addAll(Lists.newArrayList());
        aoos.addAll(Lists.newArrayList());
        System.out.println(aoos);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Aoo {
        private String name;
        private Integer age;
    }
}
