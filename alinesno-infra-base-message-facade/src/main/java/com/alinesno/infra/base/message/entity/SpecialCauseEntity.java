package com.alinesno.infra.base.message.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * SpecialCauseEntity 是一个表示特殊原因的实体类。
 * 该类继承自 InfraBaseEntity 类，表示它是一个基础实体类。
 * 使用 @TableName 注解指定了对应的数据库表名为 "special_cause"。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("special_cause")
public class SpecialCauseEntity extends InfraBaseEntity {

    /**
     * 消息ID
     */
    @TableField("message_id")
    private long messageId;

    /**
     * 错误消息
     */
    @TableField("error_msg")
    private String errorMsg;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
