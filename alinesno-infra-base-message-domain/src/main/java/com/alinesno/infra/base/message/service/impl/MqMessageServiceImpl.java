package com.alinesno.infra.base.message.service.impl;

import com.alinesno.infra.base.message.adapter.kafka.KafkaProducer;
import com.alinesno.infra.base.message.api.dto.ConsumerDto;
import com.alinesno.infra.base.message.api.dto.MqMessageDto;
import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.entity.MqMessageFailEntity;
import com.alinesno.infra.base.message.enums.MqStatusEnum;
import com.alinesno.infra.base.message.event.MqNoticeEventPublisher;
import com.alinesno.infra.base.message.mapper.MqMessageMapper;
import com.alinesno.infra.base.message.service.IMqMessageFailService;
import com.alinesno.infra.base.message.service.IMqMessageService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class MqMessageServiceImpl extends IBaseServiceImpl<MqMessageEntity , MqMessageMapper> implements IMqMessageService {

    private static final Logger log = LoggerFactory.getLogger(MqMessageServiceImpl.class) ;

    @Autowired
    private IMqMessageFailService messageFailService ;

    @Autowired
    private KafkaProducer kafkaProducer ;

    @Autowired
    private MqNoticeEventPublisher mqNoticeEventPublisher ;

    @Override
    public List<MqMessageEntity> listAllByDeath() {
        return null;
    }

    @Override
    public Boolean sendMessage(MqMessageEntity mq) {

        String topicName = mq.getTopic() ;
        String message = mq.getData() ;

        ProducerRecord<String,byte[]> producerRecord = new ProducerRecord<>(topicName,1, "key1", message.getBytes());
        CompletableFuture<SendResult<String, byte[]>> result =  kafkaProducer.sendSyncMessage(producerRecord) ;

        result.whenComplete((res , ex) -> {
            if (ex == null) {
                log.debug("Sent message=[" + mq.getData() +  "] with offset=[" + res.getRecordMetadata().offset() + "]");

                mq.setStatus(MqStatusEnum.HAS_SEND.getCode());
                mq.setEffectTime(new Date());

                update(mq) ;
            } else {
                log.error("Unable to send message=[" +  message + "] due to : " + ex.getMessage());

                MqMessageFailEntity failMq = new MqMessageFailEntity() ;
                BeanUtils.copyProperties(mq , failMq);

                failMq.setId(0L);
                failMq.setMessageId(mq.getId());

                messageFailService.save(failMq) ;
                mqNoticeEventPublisher.publishNoticeEvent(mq);
            }
        });

        return true ;
    }

    @Override
    public List<MqMessageEntity> listAllByOutTime() {
        return null;
    }

    @Override
    public List<MqMessageEntity> listAllByFail() {
        return null;
    }

    @Override
    public void deleteMq(MqMessageEntity mq) {

    }

    @Override
    public void sendMessage(MqMessageDto mqMessageDto) {
        MqMessageEntity mq = new MqMessageEntity() ;
        BeanUtils.copyProperties(mqMessageDto , mq);
        this.sendMessage(mq) ;
    }

    @Override
    public void batchSendMessage(List<MqMessageDto> mqList) {
        for(MqMessageDto dto : mqList){
            this.sendMessage(dto) ;
        }
    }

    @Override
    public void messageReceiver(ConsumerDto consumerDto) {

    }
}
