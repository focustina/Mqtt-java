package com.gw.mqttclient.connection;

import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.*;
import lombok.extern.slf4j.Slf4j;
import com.gw.mqttclient.connection.ClientConfig;

import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class MqttCallback implements MqttCallbackExtended {
    private List<SubsriptTopic> topicmap;

    public MqttCallback(List<SubsriptTopic> topicmap) {
        this.topicmap = topicmap;
    }

    /**
     * 连接emqx后触发
     *
     * @param b
     * @param s
     */
    @SneakyThrows
    @Override
    public void connectComplete(boolean b, String s) {
        MqttClient client = ApplicationContextUtil.getBean(MqttClient.class);
        if (client.isConnected()) {
            for (SubsriptTopic sub : topicmap) {
                client.subscribe(sub.getTopic(), sub.getQos(), sub.getImqttMessageListener());
                log.info("订阅主题：" + sub.getSubtopic());
            }
            log.info("共订阅：" + topicmap.size() + "个主题");
        }
    }

    /**
     * @param throwable
     */

    @SneakyThrows
    @Override
    public void connectionLost(Throwable throwable) {
        MqttClient client = ApplicationContextUtil.getBean(MqttClient.class);
        MqttConnectOptions options = ApplicationContextUtil.getBean(MqttConnectOptions.class);
        while (!client.isConnected()) {
            log.info("emqx重新连接----------------------------------");
            client.connect(options);
            Thread.sleep(1000);
        }


    }

    /**
     * 判断主题是否为一个通配符表示的自主题
     *
     * @param topicFilter
     * @param topic
     * @return
     */

    public boolean isMatched(String topicFilter, String topic) {
        return MqttTopic.isMatched(topicFilter, topic);
    }

    /**
     * 客户端收到消息触发
     *
     * @param topic
     * @param massage
     * @throws Exception
     */

    public


    @Override
    public void messageArrived(String topic, MqttMessage massage) throws Exception {
        for (SubsriptTopic subsriptTopic : topicmap){
            if (subsriptTopic.getPattern() !=  && isMatched(subsriptTopic.getTopic(),topic)){
                subsriptTopic.getImqttMessageListener().messageArrived(topic,massage);
                break;
            }
        }


    }

    /**
     * 成功发布消息
     * @param token
     */

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        String[] topics = token.getTopics();
        for (String topic : topics){
            log.info("向主题" + topic + "发送数据");
        }


    }
}




