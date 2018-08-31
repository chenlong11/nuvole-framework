DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `id` varchar(32) NOT NULL,
  `menu_code` varchar(50) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `data_url` varchar(255) DEFAULT '',
  `pid` varchar(32) DEFAULT '',
  `level` char(2) NOT NULL,
  `menu_type` char(2),
  `sequence` bigint DEFAULT 999,
  `gmt_create` bigint,
  `gmt_update` bigint,
  `status` tinyint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_module_role`;
CREATE TABLE `sys_module_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL ,
  `module_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  `sequence` bigint DEFAULT 999,
  `gmt_create` bigint,
  `gmt_update` bigint,
  `status` tinyint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL,
  `login_name` varchar(50) NOT NULL,
  `mobile` varchar(50) DEFAULT '',
  `user_name` varchar(50) NOT NULL,
  `user_code` varchar(50) DEFAULT '',
  `password` varchar(50) NOT NULL,
  `sequence` bigint DEFAULT 999,
  `gmt_create` bigint,
  `gmt_update` bigint,
  `status` tinyint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL ,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

