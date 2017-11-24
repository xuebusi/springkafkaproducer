package com.xuebusi.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * 生产者
 * 使用@EnableScheduling注解开启定时任务
 */
@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 定时任务1
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send1(){
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("app_log_1", message);
        future.addCallback(o -> System.out.println("send1-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
    }

    /**
     * 定时任务2
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send2(){
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("app_log_2", message);
        future.addCallback(o -> System.out.println("send2-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
    }

    /**
     * 定时任务3
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send3(){
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("app_log_3", message);
        future.addCallback(o -> System.out.println("send3-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
    }
}