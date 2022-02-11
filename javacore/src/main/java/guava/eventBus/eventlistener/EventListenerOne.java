package guava.eventBus.eventlistener;

import com.google.common.eventbus.Subscribe;
import guava.eventBus.event.CustomEvent;

import java.time.Instant;
import java.util.Date;

/**
 * 事件监听
 *
 * @author maqidi
 * @date 2021/11/24 2:28 下午
 */
public class EventListenerOne {

    @Subscribe
    public void handleEvent(CustomEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者1,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void handleEventV2(CustomEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者2,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
    }


}
