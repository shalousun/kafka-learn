package com.sunyu.kafka.service.impl;

import com.sunyu.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * 类KafkaServiceImpl.java的实现描述：发消息实现类
 * Created by yu on 2017/6/17.
 */

@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    //默认4个分区
    private static final int numPartitions = 1;
    @Autowired
    @Qualifier("kafkaTopicTest")
    MessageChannel channel;

    @Override
    public boolean sendUserInfo(String topic, Object obj) {
        // 获取messageKey
        String messageKey = String.valueOf(obj.hashCode());
        // 获取分区号
        int partitionId = partition(messageKey, numPartitions);
        return channel.send(MessageBuilder.withPayload(obj)
                .setHeader(KafkaHeaders.TOPIC, topic)
                // .setHeader(KafkaHeaders.MESSAGE_KEY, messageKey)
                .setHeader(KafkaHeaders.PARTITION_ID, partitionId).build());
    }

    /**
     * 获取分区号
     *
     * @param key           KEY
     * @param numPartitions 分区数
     * @return
     */
    private int partition(Object key, int numPartitions) {
        try {
            long partitionNum = Long.parseLong((String) key);
            return (int) Math.abs(partitionNum % numPartitions);
        } catch (Exception e) {
            return Math.abs(key.hashCode() % numPartitions);
        }
    }
}
