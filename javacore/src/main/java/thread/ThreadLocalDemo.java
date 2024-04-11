package thread;

/**
 * threadLocal关键字是 线程自有的，线程不会共享，线程隔离
 * @author qidi
 * @date 2019-12-18 21:01
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal;

    public static void main(String[] args) {

        threadLocal = new ThreadLocal<String>() {

            @Override
            protected String initialValue() {
                return "初始化值";
            }

        };

        for (int i = 0; i < 10; i++) {
            new Thread(new MyRunnable(), "线程" + i).start();
        }

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "的threadLocal" + ",设置为" + name);
            threadLocal.set(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(name + ":" + threadLocal.get());
        }

    }
}
