package thread;

/**
 * @author maqidi
 * @date 2021/8/27 12:05 下午
 */
public class Test {
    public static void main(String[] args) {
        Thread mainT = Thread.currentThread();
        TestThread testThread = new TestThread(mainT);
        testThread.start();
        TestThreadV2 testThreadV2 = new TestThreadV2();
        testThreadV2.start();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.currentTimeMillis();
        }
    }
}
