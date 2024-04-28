package algorithm.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程循环打印A B C 通过线程阻塞的方式，不是一直加锁释放锁。
 * 如果打印成功就阻塞，等待下一次打印，并唤醒下一个线程进行打印
 * 注意打印顺序和打印方式
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-04-23 17:58
 */
public class ThreadPrintV2 {
    static AtomicInteger count = new AtomicInteger(0);
    static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    //三个线程循环打印A B C
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyThreadA(0));
        Thread thread2 = new Thread(new MyThreadB(1));
        Thread thread3 = new Thread(new MyThreadC(2));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class MyThreadA implements Runnable {
        int no;

        public MyThreadA(int no) {
            this.no = no;
        }

        /**
         * 加锁解锁的解法，影响性能
         */
        @Override
        public void run() {
            //先锁定，如果不是自己的线程就阻塞自己
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "加锁");
                for (int i = 0; i < 10; i++) {
                    //不是自己的线程就阻塞
                    while (count.get() % 3 != 0) {
                        a.await();
                    }
                    //是自己的任务打印
                    System.out.println(Thread.currentThread().getName() + " " + "A");
                    count.getAndIncrement();
                    //打印完了唤醒下一个线程
                    b.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "解锁");
            }
        }
    }

    static class MyThreadB implements Runnable {
        int no;

        public MyThreadB(int no) {
            this.no = no;
        }

        /**
         * 加锁解锁的解法，影响性能
         */
        @Override
        public void run() {
            //先锁定，如果不是自己的线程就阻塞自己
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "加锁");
                for (int i = 0; i < 10; i++) {
                    //不是自己的线程就阻塞
                    while (count.get() % 3 != 1) {
                        b.await();
                    }
                    //是自己的任务打印
                    System.out.println(Thread.currentThread().getName() + " " + "B");
                    count.getAndIncrement();
                    //打印完了唤醒下一个线程
                    c.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "解锁");
            }
        }
    }

    static class MyThreadC implements Runnable {
        int no;

        public MyThreadC(int no) {
            this.no = no;
        }

        /**
         * 加锁解锁的解法，影响性能
         */
        @Override
        public void run() {
            //先锁定，如果不是自己的线程就阻塞自己
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "加锁");
                for (int i = 0; i < 10; i++) {
                    //不是自己的线程就阻塞
                    while (count.get() % 3 != 2) {
                        c.await();
                    }
                    //是自己的任务打印
                    System.out.println(Thread.currentThread().getName() + " " + "C");
                    count.getAndIncrement();
                    //打印完了唤醒下一个线程
                    a.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "解锁");
            }
        }
    }
}
