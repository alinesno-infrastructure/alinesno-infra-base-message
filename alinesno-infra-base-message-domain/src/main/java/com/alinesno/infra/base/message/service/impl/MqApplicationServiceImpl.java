package com.alinesno.infra.base.message.service.impl;

import com.alinesno.infra.base.message.entity.MqApplicationEntity;
import com.alinesno.infra.base.message.entity.MqMessageFailEntity;
import com.alinesno.infra.base.message.mapper.MqApplicationMapper;
import com.alinesno.infra.base.message.mapper.MqMessageFailMapper;
import com.alinesno.infra.base.message.service.IMqApplicationService;
import com.alinesno.infra.base.message.service.IMqMessageFailService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.services.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MqApplicationServiceImpl extends IBaseServiceImpl<MqApplicationEntity , MqApplicationMapper> implements IMqApplicationService {
}
