package guava.eventBus.eventlistener;

import com.google.common.eventbus.Subscribe;
import guava.eventBus.event.CustomEvent;

import java.time.Instant;

/**
 * @author maqidi
 * @date 2021/11/24 2:34 下午
 */
public class EventListenerTwo {

    @Subscribe
    public void handleEvent(CustomEvent event) {
        System.out.println(Instant.now() + "监听者2,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
