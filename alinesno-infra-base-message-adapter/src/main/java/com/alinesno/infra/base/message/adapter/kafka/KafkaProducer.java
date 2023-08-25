package com.alinesno.infra.base.message.adapter.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class KafkaProducer {

    private KafkaTemplate<String , byte[]> kafkaTemplate;

    public SendResult<String, byte[]> sendMessage(String topic, byte[] message) {
        try {
            return kafkaTemplate.send(topic, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<SendResult<String, byte[]>> sendSyncMessage(ProducerRecord<String, byte[]> producerRecord) {
        return kafkaTemplate.send(producerRecord);
    }

}
