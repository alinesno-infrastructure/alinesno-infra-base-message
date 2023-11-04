package com.alinesno.infra.base.message.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 统计数据实体类
 * 
 * 表名：statistical_data
 * 
 * 字段说明：
 * - 用户id
 * - 总数
 * - 预发送
 * - 已发送
 * - 已接收
 * - 已死亡
 * - 今日总数
 * - 今日预发送
 * - 今日已发送
 * - 今日已接收
 * - 今日已死亡
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("statistical_data")
@Data
public class StatisticalDataEntity extends InfraBaseEntity {

    /**
     * 用户id
     */
    @TableField("user_id")
    @Excel(name = "用户id")
	@ColumnType(length=50)
	@ColumnComment("用户id")
    private String userId;

    /**
     * 总数
     */
    @TableField("total")
    @Excel(name = "总数")
	@ColumnType(length=10)
	@ColumnComment("总数")
    private Long total;

    /**
     * 预发送
     */
    @TableField("prepared_send")
    @Excel(name = "预发送")
	@ColumnType(length=255)
	@ColumnComment("预发送")
    private Long preparedSend;

    /**
     * 已发送
     */
    @TableField("has_send")
    @Excel(name = "已发送")
	@ColumnType(length=1)
	@ColumnComment("已发送")
    private Long hasSend;

    /**
     * 已接收
     */
    @TableField("has_receive")
    @Excel(name = "已接收")
	@ColumnType(length=1)
	@ColumnComment("已接收")
    private Long hasReceive;

    /**
     * 已死亡
     */
    @TableField("has_dead")
    @Excel(name = "已死亡")
	@ColumnType(length=1)
	@ColumnComment("已死亡")
    private Long hasDead;

    /**
     * 今日总数
     */
    @TableField("today_total")
    @Excel(name = "今日总数")
	@ColumnType(length=10)
	@ColumnComment("今日总数")
    private Long todayTotal;

    /**
     * 今日预发送
     */
    @TableField("today_prepared_send")
    @Excel(name = "今日预发送")
	@ColumnType(length=10)
	@ColumnComment("今日预发送")
    private Long todayPreparedSend;

    /**
     * 今日已发送
     */
    @TableField("today_has_send")
    @Excel(name = "今日已发送")
	@ColumnType(length=1)
	@ColumnComment("今日已发送")
    private Long todayHasSend;

    /**
     * 今日已接收
     */
    @TableField("today_has_receive")
    @Excel(name = "今日已接收")
	@ColumnType(length=255)
	@ColumnComment("今日已接收")
    private Long todayHasReceive;

    /**
     * 今日已死亡
     */
    @TableField("today_has_dead")
    @Excel(name = "今日已死亡")
	@ColumnType(length=1)
	@ColumnComment("今日已死亡")
    private Long todayHasDead;
}
