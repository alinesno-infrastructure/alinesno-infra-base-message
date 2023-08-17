package com.alinesno.infra.base.message.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 数据表：mq_message
 * 表备注：
 * 消息实体类
 * 
 * 表名：mq_message
 * 
 * 字段说明：
 * - 主题：消息的主题
 * - 消费组：消费消息的组
 * - 消息内容：消息的具体内容
 * - 状态：消息的状态
 * - 重试次数：消息的重试次数
 * - 分片id：消息的分片id
 * - 是否死亡：消息是否已经死亡
 * - 超时时间：消息的超时时间
 * - 生效时间：消息的生效时间
 * - 流转日志：消息的流转日志
 * - 业务id：消息关联的业务id
 * - 异常消息：异常消息的描述信息
 * 
 * 注解说明：
 * - 使用@TableName注解指定表名为mq_message
 * - 使用@TableField注解指定字段名和属性名的映射关系
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("mq_message_history")
public class MqMessageHistoryEntity extends InfraBaseEntity {

    /**
     * 主题
     */
    @TableField("topic")
    private String topic;

    /**
     * 消费组
     */
    @TableField("mq_group")
    private String mqGroup;

    /**
     * 消息内容
     */
    @TableField("data")
    private String data;

    /**
     * 状态
     * @see com.alinesno.cloud.base.message.enums.MessageStatusEnum
     */
    @TableField("status")
    private String status;

    /**
     * 重试次数
     */
    @TableField("retryCount")
    private int retryCount;

    /**
     * 分片id
     */
    @TableField("shardingId")
    private int shardingId;

    /**
     * 是否死亡
     */
    @TableField("has_dead")
    private int hasDead;

    /**
     * 超时时间
     */
    @TableField("timeout")
    private Long timeout;

    /**
     * 生效时间
     */
    @TableField("effectTime")
    private Date effectTime;

    /**
     * 流转日志
     */
    @TableField("log")
    private String log;

    /**
     * 业务id
     */
    @TableField("business_id")
    private String businessId;

    /**
     * 异常消息
     */
    @TableField("error_msg")
    private String errorMsg;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMqGroup() {
        return mqGroup;
    }

    public void setMqGroup(String mqGroup) {
        this.mqGroup = mqGroup;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getShardingId() {
        return shardingId;
    }

    public void setShardingId(int shardingId) {
        this.shardingId = shardingId;
    }

    public int getHasDead() {
        return hasDead;
    }

    public void setHasDead(int hasDead) {
        this.hasDead = hasDead;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
