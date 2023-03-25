package com.gw.mqttclient.connection;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubsriptTopic {
    private String topic;
    private String subtopic;
    private Pattern pattern;
    private int qos;
    private IMqttMessageListener imqttMessageListener;



}
