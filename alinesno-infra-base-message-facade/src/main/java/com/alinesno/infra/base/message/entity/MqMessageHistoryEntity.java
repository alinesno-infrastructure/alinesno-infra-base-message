package com.alinesno.infra.base.message.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
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
@Data
public class MqMessageHistoryEntity extends InfraBaseEntity {

    /**
     * 主题
     */
    @TableField("topic")
	@ColumnType(length=255)
	@ColumnComment("主题")
    private String topic;

    /**
     * 消费组
     */
    @TableField("mq_group")
	@ColumnType(length=50)
	@ColumnComment("消费组")
    private String mqGroup;

    /**
     * 消息内容
     */
    @TableField("data")
	@ColumnType(length=255)
	@ColumnComment("消息内容")
    private String data;

    /**
     * 状态
     * 
     */
    @TableField("status")
	@ColumnType(length=1)
	@ColumnComment("状态")
    private String status;

    /**
     * 重试次数
     */
    @TableField("retryCount")
	@ColumnType(length=1)
	@ColumnComment("重试次数")
    private int retryCount;

    /**
     * 分片id
     */
    @TableField("shardingId")
	@ColumnType(length=10)
	@ColumnComment("分片id")
    private int shardingId;

    /**
     * 是否死亡
     */
    @TableField("has_dead")
	@ColumnType(length=1)
	@ColumnComment("是否死亡")
    private int hasDead;

    /**
     * 超时时间
     */
    @TableField("timeout")
	@ColumnType(length=2)
	@ColumnComment("超时时间")
    private Long timeout;

    /**
     * 生效时间
     */
    @TableField("effectTime")
	@ColumnType(length=8)
	@ColumnComment("生效时间")
    private Date effectTime;

    /**
     * 流转日志
     */
    @TableField("log")
	@ColumnType(length=255)
	@ColumnComment("流转日志")
    private String log;

    /**
     * 业务id
     */
    @TableField("business_id")
	@ColumnType(length=50)
	@ColumnComment("业务id")
    private String businessId;

    /**
     * 异常消息
     */
    @TableField("error_msg")
	@ColumnType(length=255)
	@ColumnComment("异常消息")
    private String errorMsg;
}
