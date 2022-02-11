package guava.eventBus;

import guava.eventBus.event.CustomEvent;
import guava.eventBus.eventlistener.EventListenerOne;
import guava.eventBus.eventlistener.EventListenerTwo;
import guava.eventBus.util.EventBusUtil;

import java.time.Instant;

/**
 * 事件总线测试方法
 *
 * @author maqidi
 * @date 2021/11/24 2:37 下午
 */
public class TestMain {

    public static void main(String[] args) {
        EventListenerOne listener1 = new EventListenerOne();
        EventListenerTwo listener2 = new EventListenerTwo();
        CustomEvent customEvent = new CustomEvent(23);
        EventBusUtil.register(listener1);
        EventBusUtil.register(listener2);
        EventBusUtil.post(customEvent);
//        EventBusUtil.asyncPost(customEvent);
//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Instant.now() + ",主线程执行完毕：" + Thread.currentThread().getName());
    }


}
