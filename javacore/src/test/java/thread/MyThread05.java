package thread;

import com.google.gson.Gson;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maqidi
 * @date 2021/8/27 3:26 下午
 */
public class MyThread05 extends Thread {

    @Test
    public void test3() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                lock.lock();
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        System.out.println(t1.getName() + "我开始了");
        Thread.sleep(3000);
        Thread.currentThread().interrupt();
        System.out.println("关闭前垂死挣扎1");
        System.out.println("关闭前垂死挣扎2");
        System.out.println("关闭前垂死挣扎3");
        System.out.println("关闭前垂死挣扎4");
        System.out.println("关闭前垂死挣扎5");
        System.out.println("关闭前垂死挣扎6");
        System.out.println("关闭前垂死挣扎7");
        System.out.println("关闭前垂死挣扎8");
        System.out.println("关闭前垂死挣扎9");
        System.out.println("关闭前垂死挣扎10");
        System.out.println("关闭前垂死挣扎11");
        System.out.println(Thread.currentThread().getName() + "中断：" + Thread.currentThread().isInterrupted());
        System.out.println(t1.getName() + "是否终端：" + t1.isInterrupted());
    }

    @Test
    public void test4() {
        System.out.println(true || false);
    }

    @Test
    public void testBoolean() {
        boolean status = false;
        if (BooleanUtils.isTrue(status)) {
            System.out.println("hehe");
        } else {
            System.out.println("xx");
        }

    }
}
