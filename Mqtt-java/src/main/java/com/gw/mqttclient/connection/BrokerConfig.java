package com.gw.mqttclient.connection;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gw.mqttclient.connection.ClientConfig;
import org.springframework.core.annotation.AnnotationUtils;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
@Configuration
@AutoConfigureAfter(ClientConfig.class)
public class BrokerConfig {

    @Value("${server.port}")
    private int port;

    @Bean
    public MqttConnectOptions getOption(ClientConfig clientConfig){
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(clientConfig.getUserName());
        options.setPassword(clientConfig.getPasswd().toCharArray());
        options.setCleanSession(clientConfig.getCleansession());
        options.setAutomaticReconnect(clientConfig.getReconnect());
        options.setConnectionTimeout(clientConfig.getTimeout());
        options.setKeepAliveInterval(clientConfig.getKeepalive());
        return options;

    }
    @Bean
    public MqttClient getClient(MqttConnectOptions options, ClientConfig clientConfig, ApplicationContext applicationContext) throws Exception{
        List<SubsriptTopic> topicmap = new ArrayList<SubsriptTopic>();
        MqttClient client = new MqttClient(clientConfig.getBroker(), Inet4Address.getLocalHost().getHostAddress() + ":" + port,new MemoryPersistence());
        //get使用@topic注解的类
        Map<String,Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Topic.class);
        for (String classname : beansWithAnnotation.keySet()){
            Class<?> classByteCode = beansWithAnnotation.get(classname).getClass();
            //获取类的注解属性
            Topic annotation = AnnotationUtils.findAnnotation(classByteCode, Topic.class);
            String topic = annotation.topic();
            int qos = annotation.qos();
            Pattern pattern = annotation.;

        }

    }




}
