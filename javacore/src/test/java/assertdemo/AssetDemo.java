package assertdemo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 断言类型测试
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

}
