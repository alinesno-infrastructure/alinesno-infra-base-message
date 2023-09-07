package com.alinesno.infra.base.message.service.impl;

import com.alinesno.infra.base.message.entity.MqMessageFailEntity;
import com.alinesno.infra.base.message.mapper.MqMessageFailMapper;
import com.alinesno.infra.base.message.service.IMqMessageFailService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MqMessageFailServiceImpl extends IBaseServiceImpl<MqMessageFailEntity , MqMessageFailMapper> implements IMqMessageFailService {
}
