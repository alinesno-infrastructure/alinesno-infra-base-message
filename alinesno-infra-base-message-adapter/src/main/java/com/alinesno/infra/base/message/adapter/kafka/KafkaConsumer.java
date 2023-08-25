package com.alinesno.infra.base.message.adapter.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = {"alinesno-infra-message-business-callback"})
    public void listen(ConsumerRecord<String, String> record) {

        log.debug("kafka的key: " + record.key());
        log.debug("kafka的value: " + record.value()) ;

    }
}