package keyword.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * 测试Volatile关键字，是否可见，影响执行语句的排序
 * 以下的例子，如main函数已经修改stop为true，但是子线程不可见依然以为是false，所以就会一直执行下去。
 *
 * @author maqidi
 * @date 2024/4/9 14:49
 */
public class TestVolatile {
//    private static boolean stop = false;
    private volatile static boolean stop = false;

    public static void main(String[] args) {
        // Thread-A
        new Thread("Thread A") {
            @Override
            public void run() {
                while (!stop) {
                }
                System.out.println(Thread.currentThread() + " stopped");
            }
        }.start();

        // Thread-main
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread() + " after 1 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
    }


}
