package assertdemo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Condition;
import org.junit.Test;
import sup.Aoo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

/**
 * 断言类型测试，测试assertj测试框架
 *
 * @author maqidi
 * @date 2022/2/11 8:26 下午
 */
public class AssetDemo {

    @Test
    public void testAssert() {
        Integer abc = 123;
        assertThat(abc).as("测试abc的值").isEqualTo(345);
    }

    @Test
    public void testAssertStream() {
        List<Aoo> aooList = Lists.newArrayList(new Aoo("123", 123), new Aoo("456", 456));
        assertThat(aooList).isNotEmpty().as("判断包含457的元素").anyMatch(o -> o.getAge() == 457);
    }


    /**
     * 首先预测
     */
    @Test
    public void testAssertPredicate() {
        List<Aoo> aooList = Lists.newArrayList(new Aoo("123", 123), new Aoo("456", 456));
        //自定义流式断言
        assertThat(aooList).is(new Condition<>(list -> list.stream().anyMatch(o -> o.getAge() == 123), "isMatch123", "check123"));
    }


    @Test
    public void testThen() {
        List<Aoo> aooList = Lists.newArrayList(new Aoo("123", 123), new Aoo("456", 456));
    }


    @Data
    @AllArgsConstructor
    public static class Aoo {
        private String name;
        private int age;
    }

}
