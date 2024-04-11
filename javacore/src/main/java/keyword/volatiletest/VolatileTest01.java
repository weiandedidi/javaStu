package keyword.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不能保证多操作的 原子化，存在读和写的操作
 * i++是三次操作
 * 1. i进行内存读
 * 2. i进行+1
 * 3. 将i的值会写内存
 * <p>
 * volatile是无法保证这三个操作是具有原子性的，我们可以通过AtomicInteger或者Synchronized来保证+1操作的原子性。 注：上面几段代码中多处执行了Thread.sleep()方法，目的是为了增加并发问题的产生几率，无其他作用。#
 *
 * @author maqidi
 * @date 2024/4/9 14:56
 */
public class VolatileTest01 {

    volatile int i;
//    AtomicInteger i = new AtomicInteger(0);    //原子化操作改造

    public void addI() {
        i++;
//        i.getAndIncrement(); //原子化操作改造


    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest01 test01 = new VolatileTest01();
        for (int n = 0; n < 1000; n++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test01.addI();
                }
            }).start();
        }
        Thread.sleep(10000);//等待10秒，保证上面程序执行完成
        System.out.println(test01.i);
    }
}
