package com.alinesno.infra.base.message.service;

import com.alinesno.infra.base.message.api.dto.ConsumerDto;
import com.alinesno.infra.base.message.api.dto.MqMessageDto;
import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * IMqMessageService 接口定义了与消息发送和接收相关的服务方法。
 * 该接口继承自 IBaseService 接口，提供了基本的 CRUD（创建、读取、更新、删除）操作。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IMqMessageService extends IBaseService<MqMessageEntity> {

    /**
     * 获取所有过期消息。
     *
     * @return 所有过期消息的列表
     */
    List<MqMessageEntity> listAllByDeath();

    /**
     * 发送消息。
     *
     * @param mq 消息实体
     * @return 发送是否成功的布尔值
     */
    Boolean sendMessage(MqMessageEntity mq);

    /**
     * 获取所有超时消息。
     *
     * @return 所有超时消息的列表
     */
    List<MqMessageEntity> listAllByOutTime();

    /**
     * 获取所有发送失败的消息。
     *
     * @return 所有发送失败消息的列表
     */
    List<MqMessageEntity> listAllByFail();

    /**
     * 删除消息。
     *
     * @param mq 消息实体
     */
    void deleteMq(MqMessageEntity mq);

    /**
     * 发送消息。
     *
     * @param mqMessageDto 消息DTO
     */
    void sendMessage(MqMessageDto mqMessageDto);

    /**
     * 批量发送消息。
     *
     * @param mqList 消息DTO列表
     */
    void batchSendMessage(List<MqMessageDto> mqList);

    /**
     * 消息接收器。
     *
     * @param consumerDto 消费者DTO
     */
    void messageReceiver(ConsumerDto consumerDto);
}
