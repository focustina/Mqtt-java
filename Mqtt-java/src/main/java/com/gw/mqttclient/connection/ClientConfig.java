package com.gw.mqttclient.connection;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;




/**
 * @author bailing
 * @date 2023-03-22
 */

@Data
@Component
@Configuration
@ConfigurationProperties(prefix  = "emqx" )
public class ClientConfig {
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

    public String getBroker(){
        return broker;
    }
    public String getUserName(){
        return username;
    }
    public void setUserName(String username){
        this.username = username;
    }
    public String getPasswd(){
        return passwd;
    }
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
    public Boolean getCleansession(){
        return cleansession;
    }
    public void setCleansession(Boolean reconnect){
        this.cleansession = cleansession;
    }
    public Boolean getReconnect(){
        return reconnect;
    }
    public void setReconnect(Boolean reconnect){
        this.reconnect = reconnect;
    }
    public Integer getTimeout(){
        return timeout;
    }
    public void setTimeout(Integer timeout){
        this.timeout = timeout;
    }
    public Integer getKeepalive(){
        return keepAlive;
    }
    public void setKeepAlive(Integer keepAlive){
        this.keepAlive = keepAlive;
    }











}



