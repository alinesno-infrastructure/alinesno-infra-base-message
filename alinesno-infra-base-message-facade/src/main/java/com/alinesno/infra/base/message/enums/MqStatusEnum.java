package com.alinesno.infra.base.message.enums;

/**
 * MqStatusEnum 枚举类定义了消息队列的状态。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public enum MqStatusEnum {

    PRE_COMMIT(1, "预提交"),

    HAS_COMMIT(2, "消息已提交发送"),

    HAS_SEND(3, "已发送消息"),

    FAILURE(4, "消息发送失败"),

    HAS_RECEIVE_SUCCESS(5, "已消费消息且成功"),

    HAS_RECEIVE_FAIL(6, "已消费消息但异常"),

    OUT_TIME(7, "消息存在已超时"),

    DEATH(9, "消息死亡");

    private int code;

    private String desc;

    MqStatusEnum(final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
