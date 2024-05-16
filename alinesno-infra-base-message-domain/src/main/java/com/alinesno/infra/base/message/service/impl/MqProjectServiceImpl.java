package com.alinesno.infra.base.message.service.impl;

import com.alinesno.infra.base.message.entity.MqProjectEntity;
import com.alinesno.infra.base.message.mapper.MqProjectMapper;
import com.alinesno.infra.base.message.service.IMqProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class MqProjectServiceImpl extends IBaseServiceImpl<MqProjectEntity , MqProjectMapper> implements IMqProjectService {

    private static final String DEFAULT_PROJECT_FIELD = "default" ;

    /**
     * 获取支持的类型
     * @param appCode
     * @return
     */
    @Override
    public List<String> getDocumentType(String appCode) {

        MqProjectEntity e = getOne(new LambdaQueryWrapper<MqProjectEntity>().eq(MqProjectEntity::getProjectCode , appCode)) ;

        if(e.getHasStatus() == HasStatusEnums.ILLEGAL.value){
            return List.of();
        }

        String documentStr = e.getDocumentType() ;

        return Arrays.asList(documentStr.split(","));
    }

    @Override
    public void saveDocumentType(String projectId, String documentStr) {

        MqProjectEntity e = getById(projectId) ;
        e.setDocumentType(documentStr);

    }

    @Override
    public void initDefaultApp(long userId) {

        Sqids sqids=Sqids.builder().build();
        String code = sqids.encode(Arrays.asList(1L,2L,3L)); // "86Rf07"

        MqProjectEntity project = new MqProjectEntity() ;

        project.setOperatorId(userId);
        project.setFieldProp(DEFAULT_PROJECT_FIELD);

        project.setProjectName("默认文档应用");
        project.setProjectDesc("包含所有的文档查看权限，用于开发和验证场景");
        project.setProjectCode(code);

        save(project) ;
    }

    @Override
    public MqProjectEntity getDefaultProject(long userId) {
        return getOne(new LambdaQueryWrapper<MqProjectEntity>()
                .eq(MqProjectEntity::getFieldProp , DEFAULT_PROJECT_FIELD)
                .eq(MqProjectEntity::getOperatorId , userId));
    }

}
