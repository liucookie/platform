package sqlscript

CREATE TABLE role
(
    `id`             int(11)            NOT NULL AUTO_INCREMENT,
    `rolename`        varchar(128)       COMMENT '机构名称',
    `createtime`       datetime         COMMENT '创建时间',
    `updatetime`        datetime         COMMENT '更新时间',
    `createperson`      varchar(255)      COMMENT '创建人',
    `updateperson`       varchar(255)     COMMENT '更新人',
	`department`     	 int(11)     	    COMMENT '部门编号' ,
  	`orgid`     	 	  varchar(255)    	    COMMENT '机构id' ,
	`remarks`          varchar(255)      	  COMMENT '存储前端菜单样式' ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色表';

//菜单表
CREATE TABLE menu
(
    `id`             int(11)            NOT NULL AUTO_INCREMENT,
    `menuname`        varchar(128)       COMMENT '机构名称',
    `createtime`       datetime         COMMENT '创建时间',
    `updatetime`        datetime         COMMENT '更新时间',
    `createperson`      varchar(255)      COMMENT '创建人',
    `updateperson`       varchar(255)     COMMENT '更新人',
    `status`        	 varchar(255)     	COMMENT '状态' ,
	`parentid`     		 int(11)     	    COMMENT '父级id' ,
  	`orgid`     	 	  varchar(255)    	    COMMENT '机构id' ,
	`level`     	 	  int(4)    	       COMMENT '菜单的级别(1----1级，在·2---2级，3---3级)' ,
	`menuorder`              int(4)          COMMENT '顺序',
	`url`              varchar(255)      COMMENT 'url' ,
	`type`            int4              COMMENT '0表示前端菜单,1表示后台菜单，2代表按钮)',
	`params`          varchar(255)      	  COMMENT '存储前端菜单样式' ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/菜单角色表
CREATE TABLE menuRole
(
    `id`               int(11)            NOT NULL AUTO_INCREMENT,
	`menuid`     		 int(11)     	    COMMENT '菜单id' ,
  	`roleid`     	 	  int(11)    	    COMMENT '机构id' ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';


//用户角色表
CREATE TABLE userRole
(
    `id`               int(11)            NOT NULL AUTO_INCREMENT,
	`userid`     		 varchar(128)      	    COMMENT '用户id' ,
  	`roleid`     	 	  int(11)    	    COMMENT '角色id' ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

log_info增加表字段

alter table loginfo add status varchar(32) COMMENT '操作状态'

alter table loginfo add module varchar(64) COMMENT '操作模块'

alter table loginfo add username varchar(64) COMMENT '用户名字'

alter table loginfo add ip varchar(64) COMMENT '远程访问地址'



