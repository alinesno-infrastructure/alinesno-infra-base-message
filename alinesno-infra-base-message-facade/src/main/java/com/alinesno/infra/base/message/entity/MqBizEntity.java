package com.alinesno.infra.base.message.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 数据表：mq_biz
 * 表备注：
 * 【请填写表备注】
 * 
 * 表名：mq_biz
 * 
 * 字段说明：
 * - 业务线：业务线名称
 * - 顺序：顺序值
 * 
 * 注解说明：
 * - 使用@TableName注解指定表名为mq_biz
 * - 使用@TableField注解指定字段名和属性名的映射关系
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("mq_biz")
public class MqBizEntity extends InfraBaseEntity {

    /**
     * 业务线
     */
    @TableField("biz_name")
    private String bizName;

    /**
     * 顺序
     */
    @TableField("ex_order")
    private Long exOrder;

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Long getExOrder() {
        return exOrder;
    }

    public void setExOrder(Long exOrder) {
        this.exOrder = exOrder;
    }
}
