package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author maqidi
 * @date 2021/8/27 11:38 上午
 */
public class TestThread extends Thread {
    Thread thread;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我开始睡觉30s");
        try {
            Thread.sleep(30);
            System.out.println(Thread.currentThread().getName() + "睡醒了");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "我被打断了");
            e.printStackTrace();
        }
        System.out.println("主线程被打断");
        thread.interrupt();
    }

    public TestThread(Thread thread) {
        this.thread = thread;
    }

}
