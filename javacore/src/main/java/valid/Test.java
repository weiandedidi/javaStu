package valid;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.ObjectUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @author maqidi
 * @date 2020/11/5 下午5:26
 */
public class Test {
    public static void main(String[] args) {
        FailureHandleBo bo = FailureHandleBo.builder().boxIds("12").build();
        FailureHandle failureHandle = FailureHandleBo.build(bo);
        System.out.println(new Gson().toJson(failureHandle));

//        int a = 5;
//        Integer b = new Integer(5);
//        System.out.println(ObjectUtils.equals(a, b));
//
//        List<Aoo> aooList = Lists.newArrayList(new Aoo(1L, "1"), new Aoo(3L, "3"), new Aoo(2L, "2"), new Aoo(4L, "4"));
//        aooList.sort(Comparator.comparingLong(Aoo::getAge));
//        System.out.println(aooList);
//        aooList.removeIf(aoo -> {
//            return aoo.getAge() < 3L;
//        });
//        System.out.println("==========");
//        System.out.println(aooList);
//
//        List<Boo> booList = Lists.newArrayList(new Boo(0.0, "0"), new Boo(1.0, "1"), new Boo(-3.0, "3"), new Boo(2.0, "2"), new Boo(4.0, "4"));
//
//        booList.removeIf(boo -> {
//            return Double.compare(boo.getAge(), 0) <= 0;
//        });
//
//        System.out.println(booList);
//
//
//        Aoo testAoo = new Aoo(10, "你好");
//
//        if (null == testAoo || testAoo.getAge() > 10L) {
//            System.out.println("牛逼");
//        }


    }

    @Data
    @AllArgsConstructor
    static
    class Aoo {
        private long age;
        private String name;
    }

    @Data
    @AllArgsConstructor
    static
    class Boo {
        private Double age;
        private String name;
    }


}
