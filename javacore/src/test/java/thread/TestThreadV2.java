package thread;

/**
 * @author maqidi
 * @date 2021/8/27 12:03 下午
 */
public class TestThreadV2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我开始睡觉50s");
        try {
            Thread.sleep(50);
            System.out.println(Thread.currentThread().getName() + "睡醒了");

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "我被打断了");
            e.printStackTrace();
        }
    }
}
