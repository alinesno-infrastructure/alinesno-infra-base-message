package com.alinesno.infra.base.message.service;

import com.alinesno.infra.base.message.api.dto.ConsumerDto;
import com.alinesno.infra.base.message.api.dto.MqMessageDto;
import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

public interface IMqMessageService extends IBaseService<MqMessageEntity> {

    List<MqMessageEntity> listAllByDeath();

    Boolean sendMessage(MqMessageEntity mq);

    List<MqMessageEntity> listAllByOutTime();

    List<MqMessageEntity> listAllByFail();

    void deleteMq(MqMessageEntity mq);

    /**
     *
     * @param mqMessageDto
     */
    void sendMessage(MqMessageDto mqMessageDto);

    void batchSendMessage(List<MqMessageDto> mqList);

    void messageReceiver(ConsumerDto consumerDto);
}
