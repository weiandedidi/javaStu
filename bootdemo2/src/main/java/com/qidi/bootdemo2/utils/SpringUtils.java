package com.qidi.bootdemo2.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 通过监听器获取context后获取bean
 *
 * @author qidi
 * @date 2018/7/23
 */
@Component
public class SpringUtils implements ApplicationListener<ContextRefreshedEvent> {
    static ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            setApplicationContext(contextRefreshedEvent.getApplicationContext());
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 通过class获取bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    //通过name获取 Bean.
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}
