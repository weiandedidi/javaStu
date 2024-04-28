package algorithm.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程循环打印A B C 加锁版本
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-04-23 17:58
 */
public class ThreadPrint {
    static AtomicInteger count = new AtomicInteger(0);
    static Lock lock = new ReentrantLock();

    //三个线程循环打印A B C
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyThread(0));
        Thread thread2 = new Thread(new MyThread(1));
        Thread thread3 = new Thread(new MyThread(2));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class MyThread implements Runnable {
        int no;

        public MyThread(int no) {
            this.no = no;
        }

        /**
         * 加锁解锁的解法，影响性能
         */
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "加锁");
                    //这里的no是0，1，2共用了三个线程
                    while (count.get() % 3 == no) {
                        if (no == 0) {
                            System.out.println(Thread.currentThread().getName() + " " + "A");
                        } else if (no == 1) {
                            System.out.println(Thread.currentThread().getName() + " " + "B");
                        } else {
                            System.out.println(Thread.currentThread().getName() + " " + "C");
                        }
                        count.getAndIncrement();
                        i++;
                    }
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "解锁");
                }
            }
        }
    }
}
