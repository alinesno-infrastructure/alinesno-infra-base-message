package com.alinesno.infra.base.message.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 消息主题实体类
 * 
 * 表名：mq_topic
 * 
 * 字段说明：
 * - 消息主题
 * - 业务线
 * - 负责人
 * - 告警邮箱
 * - 业务线名称
 * 
 * 注解说明：
 * - 使用@TableName注解指定表名为mq_topic
 * - 使用@TableField注解指定字段名和属性名的映射关系
 * - 使用@Excel注解指定字段在Excel中的显示名
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("mq_topic")
public class MqTopicEntity extends InfraBaseEntity {

    /**
     * 消息主题
     */
    @TableField("topic")
    @Excel(name = "消息主题")
    private String topic;

    /**
     * 业务线
     */
    @TableField("bizId")
    @Excel(name = "业务线")
    private String bizId;

    /**
     * 负责人
     */
    @TableField("author")
    @Excel(name = "负责人")
    private String author;

    /**
     * 告警邮箱
     */
    @TableField("alarmEmails")
    @Excel(name = "告警邮箱")
    private String alarmEmails;

    /**
     * 业务线名称
     */
    @TableField("biz_name")
    @Excel(name = "业务线名称")
    private String bizName;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlarmEmails() {
        return alarmEmails;
    }

    public void setAlarmEmails(String alarmEmails) {
        this.alarmEmails = alarmEmails;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }
}
