package com.alinesno.infra.base.message.event.handle;

import com.alinesno.infra.base.message.entity.MqMessageEntity;
import com.alinesno.infra.base.message.entity.MqTopicEntity;
import com.alinesno.infra.base.message.service.IMqTopicService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqNoticeEventHandle {

    private static final Logger log = LoggerFactory.getLogger(MqNoticeEventHandle.class) ;

    @Autowired
    private IMqTopicService mqTopicService ;

    public void notices(MqMessageEntity mq) {

        String topicName = mq.getTopic() ;
        MqTopicEntity topicEntity = mqTopicService.getOne(
                new LambdaQueryWrapper<MqTopicEntity>()
                .eq(MqTopicEntity::getTopic , topicName)) ;

        String email = topicEntity.getAlarmEmails() ;
        String author = topicEntity.getAuthor() ;

        log.debug("email = {} , author = {}" , email , author);
    }
}
