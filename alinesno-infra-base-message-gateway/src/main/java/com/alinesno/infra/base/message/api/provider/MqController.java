package com.alinesno.infra.base.message.api.provider;

import com.alinesno.infra.base.message.api.dto.ConsumerDto;
import com.alinesno.infra.base.message.api.dto.MqMessageDto;
import com.alinesno.infra.base.message.service.IMqMessageService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MqController 类提供了消息相关的接口。
 * 该类包含了发送消息、批量发送消息和消息接收的方法。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Scope
@RestController
@RequestMapping("/v1/api/base/message")
public class MqController {

    private static final Logger log = LoggerFactory.getLogger(MqController.class);

    @Autowired
    private IMqMessageService messageService;

    /**
     * 发送消息接口。
     *
     * @param mqMessageDto MqMessageDto 对象
     * @return AjaxResult 对象
     */
    @PostMapping("/sendMessage")
    public AjaxResult sendMessage(@RequestBody MqMessageDto mqMessageDto) {
        log.debug("message = {}", mqMessageDto);
        messageService.sendMessage(mqMessageDto);
        return AjaxResult.success();
    }

    /**
     * 批量发送消息接口。
     *
     * @param mqList 包含多个 MqMessageDto 对象的列表
     * @return AjaxResult 对象
     */
    @PostMapping("/batchSendMessage")
    public AjaxResult batchSendMessage(@RequestBody List<MqMessageDto> mqList) {
        log.debug("mqList = {}", mqList);
        messageService.batchSendMessage(mqList);
        return AjaxResult.success();
    }

    /**
     * 消息接收接口。
     *
     * @param consumerDto ConsumerDto 对象
     * @return AjaxResult 对象
     */
    @PostMapping("/messageReceiver")
    public AjaxResult messageReceiver(@RequestBody ConsumerDto consumerDto) {
        log.debug("consumerDto = {}", consumerDto);
        messageService.messageReceiver(consumerDto);
        return AjaxResult.success();
    }
}
