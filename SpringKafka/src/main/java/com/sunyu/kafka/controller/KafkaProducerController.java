package com.sunyu.kafka.controller;

import com.sunyu.kafka.producer.KafkaProducerServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yu on 2017/6/17.
 */
@RestController
@RequestMapping("kafka")
public class KafkaProducerController {

    private static final String TOPIC = "orderTopic";
    @Resource
    private KafkaProducerServer kafkaProducerServer;

    @PostMapping(value = "send")
    public Map<String,Object> sendMsg(String message){
        return kafkaProducerServer.sndMesForTemplate(TOPIC,message);
    }
}
