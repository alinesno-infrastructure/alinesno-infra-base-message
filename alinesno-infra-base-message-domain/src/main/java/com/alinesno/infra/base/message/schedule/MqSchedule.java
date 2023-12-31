package com.alinesno.infra.base.message.schedule;

import com.alinesno.infra.base.message.event.MqEventPublisher;
import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.enums.EventTypeEnum;
import com.alinesno.infra.base.message.enums.MqStatusEnum;
import com.alinesno.infra.base.message.service.IMqMessageService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MqSchedule 类是一个定时任务调度器，用于处理已超时和发送失败的消息。
 * 当应用程序启动时，它会监听 ContextRefreshedEvent 事件，并在事件触发时执行定时任务。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class MqSchedule implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(MqSchedule.class);

    @Autowired
    private MqEventPublisher publisher;

    @Autowired
    private IMqMessageService mqMessageService;

    /**
     * 定时处理已超时的消息。
     */
    private void scheduledOuttimeMq() {
        new ScheduledThreadPoolExecutor(1)
                .scheduleWithFixedDelay(() -> {
                    try {
                        final List<MqMessageEntity> mqList = mqMessageService.listAllByOutTime();

                        if (CollectionUtils.isNotEmpty(mqList)) {
                            mqList.forEach(mq -> {
                                final boolean result = mqMessageService.sendMessage(mq);
                                publisher.publishEvent(mq, result, EventTypeEnum.OUT_TIME_EVENT.getCode());
                            });
                        }
                    } catch (Exception e) {
                        log.error("error: {}", e.getMessage());
                    }
                }, 30, 60 * 1000, TimeUnit.SECONDS);
    }

    /**
     * 定时处理发送失败的消息。
     */
    private void scheduledFailMq() {
        new ScheduledThreadPoolExecutor(1)
                .scheduleWithFixedDelay(() -> {
                    try {
                        final List<MqMessageEntity> mqList = mqMessageService.listAllByFail();

                        if (CollectionUtils.isNotEmpty(mqList)) {
                            mqList.forEach(mq -> {
                                final boolean result = mqMessageService.sendMessage(mq);
                                publisher.publishEvent(mq, result, EventTypeEnum.FAILURE_EVENT.getCode());
                            });
                        }
                    } catch (Exception e) {
                        log.error("error: {}", e.getMessage());
                    }
                }, 30, 60 * 1000, TimeUnit.SECONDS);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("contextRefreshedEvent = {}", contextRefreshedEvent);
        scheduledOuttimeMq();
        scheduledFailMq();
    }
}
