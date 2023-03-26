package com.gw.mqttclient.connection;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AutoConfigureAfter(ClientConfig.class)
public class BrokerConfig {

    @Value("${server.port}")
    private int port;


    public MqttConnectOptions getOption(ClientConfig clientConfig){
        MqttConnectOptions options = new MqttConnectOptions();
        options.(ClientConfig);
    }




}
