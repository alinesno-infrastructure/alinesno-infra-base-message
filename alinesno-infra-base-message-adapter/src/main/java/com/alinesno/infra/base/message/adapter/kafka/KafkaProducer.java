package com.alinesno.infra.base.message.adapter.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * KafkaProducer 类用于发送消息到 Kafka。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class KafkaProducer {

    private KafkaTemplate<String, byte[]> kafkaTemplate;

    /**
     * 发送消息到指定的主题。
     *
     * @param topic   主题名称
     * @param message 消息内容
     * @return 发送结果
     */
    public SendResult<String, byte[]> sendMessage(String topic, byte[] message) {
        try {
            return kafkaTemplate.send(topic, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 同步发送消息。
     *
     * @param producerRecord 要发送的消息记录
     * @return 发送结果的 CompletableFuture
     */
    public CompletableFuture<SendResult<String, byte[]>> sendSyncMessage(ProducerRecord<String, byte[]> producerRecord) {
        return kafkaTemplate.send(producerRecord);
    }
}
