package com.alinesno.infra.base.message.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MqProperties 类用于读取消息队列的配置属性。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "alinesno.base.message")
public class MqProperties {

    /**
     * 最大重试次数。
     */
    private int maxRetryCount;

    /**
     * 最大失败次数。
     */
    private int maxFailCount;

    /**
     * 超时时间。
     */
    private int outTime;

    /**
     * 死亡次数。
     */
    private int deathCount;

    public int getMaxRetryCount() {
        return maxRetryCount;
    }

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    public int getMaxFailCount() {
        return maxFailCount;
    }

    public void setMaxFailCount(int maxFailCount) {
        this.maxFailCount = maxFailCount;
    }

    public int getOutTime() {
        return outTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }
}
