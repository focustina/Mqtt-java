package com.gw.mqttclient.connection;

import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import lombok.extern.slf4j.Slf4j;
import com.gw.mqttclient.connection.ApplicationContextUtil;
import java.util.List;

@Slf4j
public class MqttCallback implements MqttCallbackExtended {
    private List<SubsriptTopic> topicmap;
    public MqttCallback(List<SubsriptTopic> topicmap){
        this.topicmap = topicmap;
    }
    @SneakyThrows
    @Override
    public void connectComplete(boolean b, String s) {
        MqttCallback client = ApplicationContextUtil.getBean(MqttCallback.class);
        if(client.topicmap.is)




    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
