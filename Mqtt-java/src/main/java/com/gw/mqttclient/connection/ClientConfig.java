package com.gw.mqttclient.connection;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



/**
 * @author bailing
 * @date 2023-03-22
 */

@Data
@Component
@ConfigurationProperties
public class ClientConfig {
    public static final String FREFIX="emqx";
    /**
     * emqx服务器地址
      */
    private String broker;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String passwd;
    /**
     * 设置是否清空session
     */
    private Boolean cleansession;
    /**
     * 是否断线重连
     */
    private Boolean reconnect;
    /**
     * 连接超时时间
     */
    private Integer timeout;
    /**
     * 设置心跳时间
     */
    private Integer keepAlive;


}
