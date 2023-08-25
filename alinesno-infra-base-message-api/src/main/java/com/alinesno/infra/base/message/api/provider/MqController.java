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

@Scope
@RestController
@RequestMapping("/v1/api/base/message")
public class MqController {

    private static final Logger log = LoggerFactory.getLogger(MqController.class) ;

    @Autowired
    private IMqMessageService messageService ;

    @PostMapping("/sendMessage")
    public AjaxResult sendMessage(@RequestBody MqMessageDto mqMessageDto){

        log.debug("message = {}" , mqMessageDto);
        messageService.sendMessage(mqMessageDto) ;

        return AjaxResult.success() ;
    }

    @PostMapping("/batchSendMessage")
    public AjaxResult batchSendMessage(@RequestBody List<MqMessageDto> mqList){

        log.debug("mqList = {}" , mqList );
        messageService.batchSendMessage(mqList) ;

        return AjaxResult.success() ;
    }

    @PostMapping("/messageReceiver")
    public AjaxResult messageReceiver(@RequestBody ConsumerDto consumerDto){

        log.debug("consumerDto = {}" , consumerDto );
        messageService.messageReceiver(consumerDto) ;

        return AjaxResult.success() ;
    }
}
