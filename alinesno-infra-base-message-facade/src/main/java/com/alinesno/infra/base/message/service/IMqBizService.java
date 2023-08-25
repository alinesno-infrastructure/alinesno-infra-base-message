package com.alinesno.infra.base.message.service;

import com.alinesno.infra.base.message.entity.MqBizEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * IMqBizService 接口定义了与消息业务相关的服务方法。
 * 该接口继承自 IBaseService 接口，提供了基本的 CRUD（创建、读取、更新、删除）操作。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IMqBizService extends IBaseService<MqBizEntity> {

    /**
     * 获取所有延迟消息。
     *
     * @return 所有延迟消息的列表
     */
    List<MqBizEntity> listAllByDelay();

    /**
     * 发送消息。
     *
     * @param mq 消息实体
     * @return 发送是否成功的布尔值
     */
    Boolean sendMessage(MqBizEntity mq);
}
