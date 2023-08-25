package com.alinesno.infra.base.message.adapter.kafka.handle;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * KafkaDefaultListenerErrorHandler 类是 KafkaListenerErrorHandler 接口的默认实现类。
 * 该类用于处理 Kafka 消息监听器执行失败的情况。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
public class KafkaDefaultListenerErrorHandler implements KafkaListenerErrorHandler {

    /**
     * 处理监听器执行失败的情况。
     *
     * @param message   失败的消息
     * @param exception 异常信息
     * @return 处理结果
     */
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        return null;
    }

    /**
     * 处理监听器执行失败的情况。
     *
     * @param message   失败的消息
     * @param exception 异常信息
     * @param consumer  Kafka 消费者实例
     * @return 处理结果
     */
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        // 在这里添加处理逻辑
        return null;
    }
}
