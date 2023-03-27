package com.gw.mqttclient.connection;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import com.gw.mqttclient.connection.Pattern;

/**
 * @author bailing
 * @date 2023-03-23
 * 自定义注解
 */

@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Topic {
    /**
     * topic
     *
     */
    String topic() default "";

    /**
     * qos
     */
    int qos() default 0;

    /**
     * 订阅模式
     */
    String pattern() default ;

    /**
     * 共享订阅组
     */
    String group() default "group1";
}
