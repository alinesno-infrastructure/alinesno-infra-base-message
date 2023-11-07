package com.alinesno.infra.base.message.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
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
@Data
public class SpecialCauseEntity extends InfraBaseEntity {

    /**
     * 消息ID
     */
    @TableField("message_id")
	@ColumnType(length=50)
	@ColumnComment("消息ID")
    private long messageId;

    /**
     * 错误消息
     */
    @TableField("error_msg")
	@ColumnType(length=255)
	@ColumnComment("错误消息")
    private String errorMsg;
}
