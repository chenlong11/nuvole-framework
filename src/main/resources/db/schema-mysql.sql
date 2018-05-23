DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_module_role`;
CREATE TABLE `sys_module_role` (
  `rid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  KEY `rid` (`rid`),
  KEY `mid` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  KEY `u_fk` (`uid`),
  KEY `r_fk` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

