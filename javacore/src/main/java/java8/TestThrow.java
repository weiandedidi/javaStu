package java8;

/**
 * @author maqidi
 * @date 2022/12/6 12:05 PM
 */
public class TestThrow {

    public static void main(String[] args) {
        int num = 4;
        int result = TestThrow.testThrow(num);
        System.out.println(result);
    }

    public static int testThrow(int num) {
        try {
            if (num < 5) {
                throw new NullPointerException("小于五");
            }
        } catch (Exception e) {
            System.out.println("捕捉异常");
            throw e;
        } finally {

        }
        return num;
    }
}
