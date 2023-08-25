package com.alinesno.infra.base.message.api.dto;

/**
 * ConsumerDto 类是一个用于表示消费者的数据传输对象。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class ConsumerDto {

    /**
     * 消息ID
     */
    private String messageId ;

    /**
     * 错误信息
     */
    private String errorMsg ;

    /**
     * 状态
     */
    private int status ;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}