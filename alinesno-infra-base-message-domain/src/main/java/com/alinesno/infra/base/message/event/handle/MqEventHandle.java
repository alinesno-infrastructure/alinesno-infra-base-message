package com.alinesno.infra.base.message.event.handle;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.MqStatusEnum;
import com.alinesno.infra.base.message.properties.MqProperties;
import com.alinesno.infra.base.message.service.IMqMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MqEventHandle 类用于处理消息事件。
 * 该类通过注入 MqProperties 和 IMqMessageService，提供了处理消息事件的方法。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class MqEventHandle {

    @Autowired
    private MqProperties mqProperties;

    @Autowired
    private IMqMessageService mqMessageService;

    /**
     * 处理消息超时事件。
     *
     * @param mq     MqMessageEntity 对象
     * @param result 处理结果
     */
    public void handleMessageOutTime(MqMessageEntity mq, boolean result) {
        if (MqStatusEnum.PRE_COMMIT.getCode() == mq.getStatus()) {
            mqMessageService.deleteMq(mq);
        } else if (MqStatusEnum.HAS_COMMIT.getCode() == mq.getStatus()) {
            mqMessageService.deleteMq(mq);
        } else if (MqStatusEnum.HAS_RECEIVE_SUCCESS.getCode() == mq.getStatus()) {
            mqMessageService.deleteMq(mq);
        }
    }

    /**
     * 处理消息发送失败事件。
     *
     * @param mq     MqMessageEntity 对象
     * @param result 处理结果
     */
    public void handleMessageFail(MqMessageEntity mq, boolean result) {
        int maxRetryCount = mqProperties.getMaxRetryCount();

        if (!result && maxRetryCount <= mq.getRetryCount()) {
            mq.setStatus(MqStatusEnum.DEATH.getCode());
            mqMessageService.update(mq);
            return;
        }

        mq.setStatus(result ? MqStatusEnum.HAS_SEND.getCode() : MqStatusEnum.FAILURE.getCode());
        mqMessageService.update(mq);
    }
}
