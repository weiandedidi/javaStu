package algorithm.ratelimit;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 令牌桶限流器,令牌桶限流器是一种基于时间窗的限流器，它通过控制令牌桶的出令牌速度，来限制请求的速率。
 *
 * @author maqidi
 * @date 2024/3/22 5:42 PM
 */
public class TokenBucketRateLimiter {
    //使用ip和桶定义存储单位
    private final ConcurrentHashMap<String, TokenBucket> buckets = new ConcurrentHashMap<String, TokenBucket>();
    /**
     * 桶的大小
     */
    private final long maxBucketCapacity;
    /**
     * 桶的填充速率
     */
    private final long refillRate;

    public TokenBucketRateLimiter(long maxBucketCapacity, long refillRate) {
        this.maxBucketCapacity = maxBucketCapacity;
        this.refillRate = refillRate;
    }

    private class TokenBucket {
        /**
         * 容量
         */
        long capacity;
        /**
         * 用于记录上一次填充时间戳的变量
         */
        long lastRefillTimestamp;

        public TokenBucket(long capacity, long lastRefillTimestamp) {
            this.capacity = capacity;
            this.lastRefillTimestamp = lastRefillTimestamp;
        }
    }

    //算法开始
    public boolean tryAcquire(String ip) {
        long currentTime = System.currentTimeMillis();
        TokenBucket bucket = buckets.computeIfAbsent(ip, k -> new TokenBucket(maxBucketCapacity, currentTime));
        //同步填充令牌
        synchronized (bucket) {
            long tokensToAdd = (currentTime - bucket.lastRefillTimestamp) / 1000 * refillRate;
            bucket.capacity = Math.min(bucket.capacity + tokensToAdd, maxBucketCapacity);
            bucket.lastRefillTimestamp = currentTime;
            //判断令牌是否足够
            if (bucket.capacity > 0) {
                bucket.capacity--;
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(10, 1);
        // 模拟IP访问
        Runnable task = () -> {
            String ip = "192.168.1.1";
            for (int i = 0; i < 2000; i++) {
                if (rateLimiter.tryAcquire(ip)) {
                    System.out.println("Access allowed for IP: " + ip);
                } else {
                    System.out.println("Access denied for IP: " + ip);
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        try {
            //等待线程结束
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
