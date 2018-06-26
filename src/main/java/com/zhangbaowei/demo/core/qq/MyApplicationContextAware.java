package com.zhangbaowei.demo.core.qq;

import com.zhangbaowei.demo.core.WebConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class MyApplicationContextAware implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public MyApplicationContextAware(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public MyApplicationContextAware() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        WebConfig bean = applicationContext.getBean(WebConfig.class);

        System.out.println(" setApplicationContext(ApplicationContext applicationContext) ");
    }

    private void init() {
        String a = "a";
    }

    private void destroy() {
        String a = "a";
    }
}
