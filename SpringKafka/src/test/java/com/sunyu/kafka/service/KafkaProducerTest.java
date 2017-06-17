package com.sunyu.kafka.service;


import com.sunyu.kafka.producer.KafkaProducerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yu on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml"
})
public class KafkaProducerTest {

    @Resource
    KafkaProducerServer kafkaProducerServer;
    @Test
    public void testMe(){
        String topic = "orderTopic";
        String value = "kkkk";
        String ifPartition = "0";
        Integer partitionNum = 1;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducerServer.sndMesForTemplate
                (topic, value, ifPartition, partitionNum, role);

        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);
    }
}
