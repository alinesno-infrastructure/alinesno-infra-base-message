package com.alinesno.infra.base.message.service;

import com.alinesno.infra.base.message.entity.MqProjectEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

public interface IMqProjectService extends IBaseService<MqProjectEntity> {

    /**
     * 获取当前应用支持的文档类型
     * @param appCode
     * @return
     */
    List<String> getDocumentType(String appCode);

    /**
     * 保存应用文档类型
     * @param documentStr
     */
    void saveDocumentType(String projectId , String documentStr) ;

    /**
     * 初始化默认应用
     * @param userId
     */
    void initDefaultApp(long userId);

    /**
     * 获取到默认应用标识
     * @return
     */
    MqProjectEntity getDefaultProject(long userId);

}
