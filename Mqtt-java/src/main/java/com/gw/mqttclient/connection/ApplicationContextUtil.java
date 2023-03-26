package com.gw.mqttclient.connection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    /**
     * 获取bean
     * @param name
     * @throws BeansException
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
    /**
     * 获取对应的bean对象
     * @param beanName
     * @return
     */
    public static <T> T getBean(String beanName){
        return (T)applicationContext.getBean(beanName);
    }
    public static <T> T getBean(Class<T> classname){
        return applicationContext.getBean(classname);
    }



}
