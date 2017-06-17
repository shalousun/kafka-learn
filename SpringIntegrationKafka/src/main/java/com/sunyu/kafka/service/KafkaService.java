package com.sunyu.kafka.service;

/**
 * Created by yu on 2017/6/17.
 */
public interface KafkaService {

    /**
     * 发消息
     * @param topic 主题
     * @param obj 发送内容
     */
    boolean sendUserInfo(String topic, Object obj);
}
