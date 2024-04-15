package com.alinesno.infra.base.message.service.impl;

import com.alinesno.infra.base.message.entity.MqMessageHistoryEntity;
import com.alinesno.infra.base.message.mapper.MqMessageHistoryMapper;
import com.alinesno.infra.base.message.service.IMqMessageHistoryService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MqMessageHistoryServiceImpl extends IBaseServiceImpl<MqMessageHistoryEntity , MqMessageHistoryMapper> implements IMqMessageHistoryService {
}
