package com.alinesno.infra.base.message.service;

import com.alinesno.infra.base.message.entity.MqBizEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

public interface IMqBizService extends IBaseService<MqBizEntity> {

    List<MqBizEntity> listAllByDelay();

    Boolean sendMessage(MqBizEntity mq);
}
