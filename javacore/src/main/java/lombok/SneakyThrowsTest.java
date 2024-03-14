package lombok;

/**
 * 测试SneakyThrows的作用，
 * 异常 ->转为 非受检查异常
 *
 * @author maqidi
 * @date 2024/2/29 3:10 PM
 */
public class SneakyThrowsTest {


    public static void main(String[] args) {
        SneakyThrowsDto throwsTest = new SneakyThrowsDto();
        throwsTest.readFile("/xxaa");
    }


}
