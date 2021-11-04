package thread;

import org.junit.Test;
import thread.interrupt.BussinessClass;

/**
 * @author maqidi
 * @date 2021/8/25 8:10 下午
 */
public class TestInterruptibly {


    @Test
    public void testInterruptibly() throws Exception {

        BussinessClass bc = new BussinessClass();

        Thread t0 = new Thread() {
            @Override
            public void run() {
                bc.bFuction();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                bc.bFuction();
            }
        };

        Thread t1 = new Thread() {
            @Override
            public void run() {
                t2.start();
                bc.bFuction();
                System.out.println("启动 t2");
            }
        };


        String tName = Thread.currentThread().getName();

        System.out.println(tName + "-启动t0！");
        t0.start();
        System.out.println(tName + "-我等个5秒，再启动t1");
        Thread.sleep(5000);
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName() + "我主动打断自己");
//        System.out.println(tName + "-启动t1");
//        t1.start();
//        System.out.println(t1.getName() + "启动了");
//
//        System.out.println(tName + "-t1获取不到锁，t0这货睡觉了，没释放，我等个5秒！");
//        Thread.sleep(5000);
//        Thread.interrupted();
//        System.out.println(tName + "-等了5秒了，不等了，把t1中断了！");
//        System.out.println(t1.getName());
////        t1.interrupt();
        System.out.println("你好");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.currentTimeMillis();
        }

    }
}
