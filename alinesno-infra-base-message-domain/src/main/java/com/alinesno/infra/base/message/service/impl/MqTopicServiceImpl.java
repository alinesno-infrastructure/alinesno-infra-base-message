package com.alinesno.infra.base.message.service.impl;

import com.alinesno.infra.base.message.entity.MqTopicEntity;
import com.alinesno.infra.base.message.mapper.MqTopicMapper;
import com.alinesno.infra.base.message.service.IMqMessageService;
import com.alinesno.infra.base.message.service.IMqTopicService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MqTopicServiceImpl extends IBaseServiceImpl<MqTopicEntity , MqTopicMapper> implements IMqTopicService {
}
