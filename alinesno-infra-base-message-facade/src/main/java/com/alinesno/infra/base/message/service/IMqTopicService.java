package com.alinesno.infra.base.message.service;

import com.alinesno.infra.base.message.entity.MqTopicEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * IMqTopicService 接口定义了与消息主题相关的服务方法。
 * 该接口继承自 IBaseService 接口，提供了基本的 CRUD（创建、读取、更新、删除）操作。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IMqTopicService extends IBaseService<MqTopicEntity> {

}
