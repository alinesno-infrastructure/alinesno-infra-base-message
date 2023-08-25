package com.alinesno.infra.base.message.event;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.EventTypeEnum;
import com.alinesno.infra.base.message.event.handle.MqEventHandle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MqEventPublisher implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MqEventHandle mqHandle ;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    }

    public void publishEvent(MqMessageEntity mq, boolean result, int code) {
        if(code == EventTypeEnum.OUT_TIME_EVENT.getCode()){
            mqHandle.handleMessageOutTime(mq , result) ;
        }else if(code == EventTypeEnum.FAILURE_EVENT.getCode()){
            mqHandle.handleMessageFail(mq , result) ;
        }

    }
}