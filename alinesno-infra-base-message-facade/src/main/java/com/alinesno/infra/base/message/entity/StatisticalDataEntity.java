package com.alinesno.infra.base.message.entity;

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
public class StatisticalDataEntity extends InfraBaseEntity {

    /**
     * 用户id
     */
    @TableField("user_id")
    @Excel(name = "用户id")
    private String userId;

    /**
     * 总数
     */
    @TableField("total")
    @Excel(name = "总数")
    private Long total;

    /**
     * 预发送
     */
    @TableField("prepared_send")
    @Excel(name = "预发送")
    private Long preparedSend;

    /**
     * 已发送
     */
    @TableField("has_send")
    @Excel(name = "已发送")
    private Long hasSend;

    /**
     * 已接收
     */
    @TableField("has_receive")
    @Excel(name = "已接收")
    private Long hasReceive;

    /**
     * 已死亡
     */
    @TableField("has_dead")
    @Excel(name = "已死亡")
    private Long hasDead;

    /**
     * 今日总数
     */
    @TableField("today_total")
    @Excel(name = "今日总数")
    private Long todayTotal;

    /**
     * 今日预发送
     */
    @TableField("today_prepared_send")
    @Excel(name = "今日预发送")
    private Long todayPreparedSend;

    /**
     * 今日已发送
     */
    @TableField("today_has_send")
    @Excel(name = "今日已发送")
    private Long todayHasSend;

    /**
     * 今日已接收
     */
    @TableField("today_has_receive")
    @Excel(name = "今日已接收")
    private Long todayHasReceive;

    /**
     * 今日已死亡
     */
    @TableField("today_has_dead")
    @Excel(name = "今日已死亡")
    private Long todayHasDead;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPreparedSend() {
        return preparedSend;
    }

    public void setPreparedSend(Long preparedSend) {
        this.preparedSend = preparedSend;
    }

    public Long getHasSend() {
        return hasSend;
    }

    public void setHasSend(Long hasSend) {
        this.hasSend = hasSend;
    }

    public Long getHasReceive() {
        return hasReceive;
    }

    public void setHasReceive(Long hasReceive) {
        this.hasReceive = hasReceive;
    }

    public Long getHasDead() {
        return hasDead;
    }

    public void setHasDead(Long hasDead) {
        this.hasDead = hasDead;
    }

    public Long getTodayTotal() {
        return todayTotal;
    }

    public void setTodayTotal(Long todayTotal) {
        this.todayTotal = todayTotal;
    }

    public Long getTodayPreparedSend() {
        return todayPreparedSend;
    }

    public void setTodayPreparedSend(Long todayPreparedSend) {
        this.todayPreparedSend = todayPreparedSend;
    }

    public Long getTodayHasSend() {
        return todayHasSend;
    }

    public void setTodayHasSend(Long todayHasSend) {
        this.todayHasSend = todayHasSend;
    }

    public Long getTodayHasReceive() {
        return todayHasReceive;
    }

    public void setTodayHasReceive(Long todayHasReceive) {
        this.todayHasReceive = todayHasReceive;
    }

    public Long getTodayHasDead() {
        return todayHasDead;
    }

    public void setTodayHasDead(Long todayHasDead) {
        this.todayHasDead = todayHasDead;
    }
}
