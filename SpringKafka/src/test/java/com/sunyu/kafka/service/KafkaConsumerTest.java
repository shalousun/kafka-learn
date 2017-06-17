package com.sunyu.kafka.service;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yu on 2017/6/17.
 */
public class KafkaConsumerTest {
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "classpath:kafkaConsumer.xml");
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }

        synchronized (KafkaConsumerTest.class) {
            while (true) {
                try {
                    KafkaConsumerTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
