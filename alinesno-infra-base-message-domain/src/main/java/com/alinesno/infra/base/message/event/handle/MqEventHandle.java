package com.alinesno.infra.base.message.event.handle;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.MqStatusEnum;
import com.alinesno.infra.base.message.properties.MqProperties;
import com.alinesno.infra.base.message.service.IMqMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MqEventHandle {

    @Autowired
    private MqProperties mqProperties ;

    @Autowired
    private IMqMessageService mqMessageService ;

    public void handleMessageOutTime(MqMessageEntity mq, boolean result) {

        if(MqStatusEnum.PRE_COMMIT.getCode() == mq.getStatus()){
           mqMessageService.deleteMq(mq) ;
        } else if(MqStatusEnum.HAS_COMMIT.getCode() == mq.getStatus()){
            mqMessageService.deleteMq(mq) ;
        } else if(MqStatusEnum.HAS_RECEIVE_SUCCESS.getCode() == mq.getStatus()){
            mqMessageService.deleteMq(mq) ;
        }

    }

    public void handleMessageFail(MqMessageEntity mq, boolean result) {

        int maxRetryCount = mqProperties.getMaxRetryCount();

        if(!result && maxRetryCount <= mq.getRetryCount()){
            mq.setStatus(MqStatusEnum.DEATH.getCode());
            mqMessageService.update(mq);
            return ;
        }

        mq.setStatus(result? MqStatusEnum.HAS_SEND.getCode(): MqStatusEnum.FAILURE.getCode());
        mqMessageService.update(mq);
    }
}
