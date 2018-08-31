/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : nuvole_framework

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-31 09:32:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `id` varchar(32) NOT NULL,
  `menu_code` varchar(50) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `data_url` varchar(255) DEFAULT '',
  `pid` varchar(32) DEFAULT '',
  `level` char(2) NOT NULL,
  `menu_type` char(2) DEFAULT NULL,
  `sequence` bigint(20) DEFAULT '999',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_update` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('1014345450158952452', 'user:manager:list', '用户管理', '/user/manager/list', '', '3', '1', '1', '20180704', '20180704', '1');
INSERT INTO `sys_module` VALUES ('1014345450158952458', 'index', '首页', '/index', '', '3', '1', '1', '20180717', '20180717', '1');

-- ----------------------------
-- Table structure for sys_module_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_module_role`;
CREATE TABLE `sys_module_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `module_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_module_role
-- ----------------------------
INSERT INTO `sys_module_role` VALUES ('1014345450158952454', '1014345450158952449', '1014345450158952452');
INSERT INTO `sys_module_role` VALUES ('1014345450158952455', '1014345450158952449', '1014345450158952458');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  `sequence` bigint(20) DEFAULT '999',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_update` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1014345450158952449', '超级管理员', 'supper', '1', '20180704', '20180704', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL,
  `login_name` varchar(50) NOT NULL,
  `mobile` varchar(50) DEFAULT '',
  `user_name` varchar(50) NOT NULL,
  `user_code` varchar(50) DEFAULT '',
  `password` varchar(50) NOT NULL,
  `sequence` bigint(20) DEFAULT '999',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_update` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1014336629495697408', 'zhangsan', '15511111111', '张三', '473001', 'ae03ea455ef53c5a10d0e5cfb40ca555', '1', '20180704', '20180704', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1014345450158952457', '1014345450158952449', '1014336629495697408');
