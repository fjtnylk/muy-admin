drop schema if exists muy_admin;
create schema muy_admin default character set utf8 collate utf8_general_ci;

-- ----------------------------
-- Table structure for my_group_role
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_group_role`;
CREATE TABLE `muy_admin`.`my_group_role` (
  `pkey` varchar(7) NOT NULL DEFAULT '' COMMENT '主键(g_code|r_code)',
  `g_code` varchar(3) NOT NULL DEFAULT '' COMMENT '组织编码',
  `r_code` varchar(3) NOT NULL DEFAULT '' COMMENT '角色编码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`pkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织角色表';

-- ----------------------------
-- Table structure for my_master_group
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_master_group`;
CREATE TABLE `muy_admin`.`my_master_group` (
  `code` varchar(3) NOT NULL DEFAULT '' COMMENT '用户组编号',
  `name` varchar(20) DEFAULT '' COMMENT '用户组名称',
  `remark` varchar(50) DEFAULT '' COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';

-- ----------------------------
-- Table structure for my_master_menu
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_master_menu`;
CREATE TABLE `muy_admin`.`my_master_menu` (
  `id` int(5) NOT NULL COMMENT '编号',
  `bpid` int(5) DEFAULT '0' COMMENT '父编号',
  `mpid` int(5) DEFAULT '0',
  `icon` varchar(20) DEFAULT '' COMMENT '图标',
  `name` varchar(32) DEFAULT '' COMMENT '名称',
  `route` varchar(64) DEFAULT '' COMMENT '路由地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Table structure for my_master_role
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_master_role`;
CREATE TABLE `muy_admin`.`my_master_role` (
  `code` varchar(3) NOT NULL DEFAULT '' COMMENT '角色编码',
  `name` varchar(20) DEFAULT '' COMMENT '角色名称',
  `remark` varchar(50) DEFAULT '' COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for my_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_role_menu`;
CREATE TABLE `muy_admin`.`my_role_menu` (
  `pkey` varchar(9) NOT NULL DEFAULT '' COMMENT '主键(r_code|menu_id)',
  `r_code` varchar(3) DEFAULT '' COMMENT '角色编码',
  `menu_id` int(5) DEFAULT '0' COMMENT '菜单编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`pkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单角色表';

-- ----------------------------
-- Table structure for my_user
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_user`;
CREATE TABLE `muy_admin`.`my_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(32) DEFAULT '' COMMENT '用户名',
  `password` varchar(128) DEFAULT '' COMMENT '用户密码',
  `salt` varchar(64) DEFAULT '' COMMENT '盐',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `email` varchar(32) DEFAULT '' COMMENT '邮箱',
  `nick_name` varchar(32) DEFAULT '' COMMENT '昵称',
  `birthday` varchar(10) DEFAULT '' COMMENT '生日(yyyy-MM-dd)',
  `signature` varchar(50) DEFAULT '' COMMENT '个性签名',
  `sex` char(1) DEFAULT '' COMMENT '性别(F-女,M-男)',
  `avater` varchar(64) DEFAULT '' COMMENT '头像',
  `address` varchar(128) DEFAULT '{}' COMMENT '地址{''prov'':'''',''city'':'''', ''district'':'''', ''street'':''''}',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态(0-可用、1-禁用、2-冻结)',
  `user_source` varchar(4) DEFAULT '' COMMENT '用户来源',
  `last_login_ip` varchar(15) DEFAULT '' COMMENT '最后登录IP',
  `last_login_location` varchar(64) DEFAULT '{}' COMMENT '最后登录位置{''lat'':xxx.xxx,''lnt'':xxx.xxx}',
  `last_login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `is_changed_pwd_flg` bit(1) DEFAULT b'0' COMMENT '是否修改过密码',
  `pwd_error_count` tinyint(1) DEFAULT '0' COMMENT '连续输错密码次数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for my_user_group
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_user_group`;
CREATE TABLE `muy_admin`.`my_user_group` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` int(11) DEFAULT '0' COMMENT '用户编号',
  `g_code` varchar(3) DEFAULT '' COMMENT '组织编码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组织表';

-- ----------------------------
-- Table structure for my_user_role
-- ----------------------------
DROP TABLE IF EXISTS `muy_admin`.`my_user_role`;
CREATE TABLE `muy_admin`.`my_user_role` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` int(11) DEFAULT '0' COMMENT '用户编号',
  `r_code` varchar(3) DEFAULT '' COMMENT '角色编码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
