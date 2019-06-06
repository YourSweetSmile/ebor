/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db_ebor

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 06/06/2019 14:57:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_remark` varchar(100) NOT NULL,
  `jurisdiction` varchar(50) DEFAULT NULL COMMENT '权限参数，如：主页|商品管理|用户管理|后台管理',
  `create_time` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '普通用户', 'user', '主页|商品管理', '1559803939012');
INSERT INTO `sys_role` VALUES (2, '管理员', 'admin', '主页|用户管理|商品管理|后台管理', '1559803939012');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'jack', '123456', 1, '1559803939012');
INSERT INTO `sys_user` VALUES (2, 'admin', '123456', 2, '1559803939012');
COMMIT;

-- ----------------------------
-- Table structure for test_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `test_sys_user`;
CREATE TABLE `test_sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_no` varchar(50) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `create_time` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_no` (`login_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_sys_user
-- ----------------------------
BEGIN;
INSERT INTO `test_sys_user` VALUES (1, 'admin', 'admin', 102.20, '1559803939012');
INSERT INTO `test_sys_user` VALUES (2, 'root', 'root', 39.02, '1559803939012');
INSERT INTO `test_sys_user` VALUES (3, 'user1', 'user1', 10.00, '1559803939012');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
