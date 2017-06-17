package com.sunyu.kafka.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 类KafkaConsumerService.java的实现描述：消费接收类
 * Created by yu on 2017/6/17.
 */
@Component
public class KafkaConsumerService {

    static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        logger.info("===============processMessage===============");
        for (Map.Entry<String, Map<Integer, String>> entry : msgs.entrySet()) {
            logger.info("============Topic:" + entry.getKey());
            LinkedHashMap<Integer, String> messages = (LinkedHashMap<Integer, String>) entry.getValue();
            Set<Integer> keys = messages.keySet();
            for (Integer i : keys) {
                logger.info("======Partition:" + i);
            }
            Collection<String> values = messages.values();
            for (Iterator<String> iterator = values.iterator(); iterator.hasNext(); ) {
                String message = "[" + iterator.next() + "]";
                logger.info("=====message:" + message);
              //  List<UserDto> userList = JSON.parseArray(message, UserDto.class);
               // logger.info("=====userList.size:" + userList.size());

            }

        }
    }
}
