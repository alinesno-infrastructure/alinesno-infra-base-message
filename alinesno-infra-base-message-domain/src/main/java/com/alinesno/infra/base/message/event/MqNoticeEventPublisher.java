package com.alinesno.infra.base.message.event;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.EventTypeEnum;
import com.alinesno.infra.base.message.event.handle.MqEventHandle;
import com.alinesno.infra.base.message.event.handle.MqNoticeEventHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * MqNoticeEventPublisher 类用于发布消息通知事件。
 * 当 ContextRefreshedEvent 事件触发时，会调用 onApplicationEvent() 方法。
 * 该类通过注入 MqNoticeEventHandle，提供了发布通知事件的方法 publishNoticeEvent()。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class MqNoticeEventPublisher implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MqNoticeEventHandle mqHandle;

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
     * 发布消息通知事件。
     *
     * @param mq MqMessageEntity 对象
     */
    public void publishNoticeEvent(MqMessageEntity mq) {
        mqHandle.notices(mq);
    }
}
