CREATE TABLE `mq_application` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `application_code` VARCHAR(255) COMMENT '应用代码',
  `token` VARCHAR(255) COMMENT '应用值',
  `max_file_size` INT COMMENT '最大文件长度',
  `file_type` VARCHAR(255) COMMENT '文件类型',
  `api_key` VARCHAR(255) COMMENT '接口密钥',
  `max_upload_count` INT COMMENT '最大上传次数',
  `max_download_count` INT COMMENT '最大下载次数',
  `banner` VARCHAR(255) COMMENT '应用logo标识',
  `company_name` VARCHAR(255) COMMENT '公司名称',
  `channel_ids` VARCHAR(255) COMMENT '所开通渠道',
  `app_code` VARCHAR(255) COMMENT '应用码',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存储应用实体类';


CREATE TABLE `mq_biz` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `biz_name` VARCHAR(255) COMMENT '业务线',
  `ex_order` BIGINT COMMENT '顺序',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mq_biz';


CREATE TABLE `mq_message` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `topic` VARCHAR(255) COMMENT '主题',
  `mq_group` VARCHAR(255) COMMENT '消费组',
  `data` VARCHAR(255) COMMENT '消息内容',
  `status` INT COMMENT '状态',
  `retryCount` INT COMMENT '重试次数',
  `shardingId` INT COMMENT '分片id',
  `has_dead` INT COMMENT '是否死亡',
  `timeout` BIGINT COMMENT '超时时间',
  `effectTime` DATETIME COMMENT '生效时间',
  `log` VARCHAR(255) COMMENT '流转日志',
  `business_id` VARCHAR(255) COMMENT '业务id',
  `error_msg` VARCHAR(255) COMMENT '异常消息',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mq_message';


CREATE TABLE `mq_message_fail` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `message_id` BIGINT COMMENT 'message_id',
  `topic` VARCHAR(255) COMMENT '主题',
  `mq_group` VARCHAR(255) COMMENT '消费组',
  `data` VARCHAR(255) COMMENT '消息内容',
  `status` VARCHAR(255) COMMENT '状态',
  `retryCount` INT COMMENT '重试次数',
  `shardingId` INT COMMENT '分片id',
  `has_dead` INT COMMENT '是否死亡',
  `timeout` BIGINT COMMENT '超时时间',
  `effectTime` DATETIME COMMENT '生效时间',
  `log` VARCHAR(255) COMMENT '流转日志',
  `business_id` VARCHAR(255) COMMENT '业务id',
  `error_msg` VARCHAR(255) COMMENT '异常消息',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mq_message_fail';


CREATE TABLE `mq_message_history` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `topic` VARCHAR(255) COMMENT '主题',
  `mq_group` VARCHAR(255) COMMENT '消费组',
  `data` VARCHAR(255) COMMENT '消息内容',
  `status` VARCHAR(255) COMMENT '状态',
  `retryCount` INT COMMENT '重试次数',
  `shardingId` INT COMMENT '分片id',
  `has_dead` INT COMMENT '是否死亡',
  `timeout` BIGINT COMMENT '超时时间',
  `effectTime` DATETIME COMMENT '生效时间',
  `log` VARCHAR(255) COMMENT '流转日志',
  `business_id` VARCHAR(255) COMMENT '业务id',
  `error_msg` VARCHAR(255) COMMENT '异常消息',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mq_message_history';


CREATE TABLE `mq_topic` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `topic` VARCHAR(255) COMMENT '消息主题',
  `bizId` VARCHAR(255) COMMENT '业务线',
  `author` VARCHAR(255) COMMENT '负责人',
  `alarmEmails` VARCHAR(255) COMMENT '告警邮箱',
  `biz_name` VARCHAR(255) COMMENT '业务线名称',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mq_topic';


CREATE TABLE `special_cause` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `message_id` BIGINT COMMENT '消息ID',
  `error_msg` VARCHAR(255) COMMENT '错误消息',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='special_cause';


CREATE TABLE `statistical_data` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` VARCHAR(255) COMMENT '用户id',
  `total` BIGINT COMMENT '总数',
  `prepared_send` BIGINT COMMENT '预发送',
  `has_send` BIGINT COMMENT '已发送',
  `has_receive` BIGINT COMMENT '已接收',
  `has_dead` BIGINT COMMENT '已死亡',
  `today_total` BIGINT COMMENT '今日总数',
  `today_prepared_send` BIGINT COMMENT '今日预发送',
  `today_has_send` BIGINT COMMENT '今日已发送',
  `today_has_receive` BIGINT COMMENT '今日已接收',
  `today_has_dead` BIGINT COMMENT '今日已死亡',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='statistical_data';
