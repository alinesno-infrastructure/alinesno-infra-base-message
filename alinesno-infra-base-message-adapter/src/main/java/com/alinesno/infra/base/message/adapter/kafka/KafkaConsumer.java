package com.alinesno.infra.base.message.adapter.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaConsumer 类用于监听 Kafka 主题并处理接收到的消息。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class KafkaConsumer {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 监听指定主题的消息，并进行相应的处理。
     *
     * @param record Kafka 消息记录
     */
    @KafkaListener(topics = {"alinesno-infra-message-business-callback"})
    public void listen(ConsumerRecord<String, String> record) {
        log.debug("kafka的key: " + record.key());
        log.debug("kafka的value: " + record.value());
    }
}
