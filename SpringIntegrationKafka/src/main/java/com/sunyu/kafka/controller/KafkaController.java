package com.sunyu.kafka.controller;

import com.sunyu.kafka.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yu on 2017/6/17.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    @Resource
    private KafkaService kafkaService;

    @RequestMapping("/test")
    public String test() {
        logger.info("-------KafkaController--------start-----");
        System.err.println("---------KafkaController--------start---------");
        kafkaService.sendUserInfo("mytopic", "kafka sendMessage test!");
        return "hello";
    }
}