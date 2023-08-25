package com.alinesno.infra.base.message.event;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.EventTypeEnum;
import com.alinesno.infra.base.message.event.handle.MqEventHandle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * MqEventPublisher 类用于发布消息事件。
 * 当 ContextRefreshedEvent 事件触发时，会调用 onApplicationEvent() 方法。
 * 该类通过注入 MqEventHandle，提供了发布事件的方法 publishEvent()。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class MqEventPublisher implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MqEventHandle mqHandle;

    /**
     * 当 ContextRefreshedEvent 事件触发时，会调用该方法。
     *
     * @param event ContextRefreshedEvent 事件对象
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 在此可以执行初始化操作或其他需要在应用程序上下文刷新时执行的逻辑
    }

    /**
     * 发布消息事件。
     *
     * @param mq     MqMessageEntity 对象
     * @param result 处理结果
     * @param code   事件类型代码
     */
    public void publishEvent(MqMessageEntity mq, boolean result, int code) {
        if (code == EventTypeEnum.OUT_TIME_EVENT.getCode()) {
            mqHandle.handleMessageOutTime(mq, result);
        } else if (code == EventTypeEnum.FAILURE_EVENT.getCode()) {
            mqHandle.handleMessageFail(mq, result);
        }
    }
}
