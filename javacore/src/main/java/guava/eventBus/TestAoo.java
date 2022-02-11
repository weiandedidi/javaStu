package guava.eventBus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maqidi
 * @date 2021/11/24 3:09 下午
 */
@Data
@AllArgsConstructor
public class TestAoo {
    private Integer age;
    private String name;
    private static TestAoo aoo = new TestAoo(6, "张三");

    public static void sayhi() {
        System.out.println(aoo.getName() + ":" + aoo.getAge());
    }

    public static void main(String[] args) {
        TestAoo.sayhi();
    }

}
