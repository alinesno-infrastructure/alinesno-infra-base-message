package com.alinesno.infra.base.message.enums;

/**
 * EventTypeEnum 枚举类定义了事件类型。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public enum EventTypeEnum {

    // 处理已死亡消息
    DEATH_EVENT(1, "已死亡消息") ,

    // 处理已超时消息
    OUT_TIME_EVENT(2, "已超时消息") ,

    // 处理发送失败消息
    FAILURE_EVENT(3, "发送失败消息") ;

    private int code;

    private String desc;

    EventTypeEnum(final int code, final String desc) {
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
