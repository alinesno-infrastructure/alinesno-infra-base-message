package com.alinesno.infra.base.message.event;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.EventTypeEnum;
import com.alinesno.infra.base.message.event.handle.MqEventHandle;
import com.alinesno.infra.base.message.event.handle.MqNoticeEventHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MqNoticeEventPublisher implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MqNoticeEventHandle mqHandle ;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    }

    public void publishNoticeEvent(MqMessageEntity mq) {
        mqHandle.notices(mq) ;
    }
}
