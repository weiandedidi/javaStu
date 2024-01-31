import org.junit.Test;

/**
 * 测试try return 和finally return
 * <p>
 * 如果finally也返回，那么返回使用finally的
 *
 * @author maqidi
 * @date 2023/8/29 16:34
 */
public class TestTryV2 {


    public int testTry(int input) {

        try {
            int result = input + 1;
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            return 0;
        }
    }

    @Test
    public void test() {
        System.out.println(testTry(5));
    }
}
