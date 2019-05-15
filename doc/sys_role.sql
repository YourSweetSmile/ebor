/*
 Navicat Premium Data Transfer
 用来做权限和角色的持久化

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : ebor

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 09/04/2019 14:02:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_remark` varchar(100) NOT NULL,
  `jurisdiction` varchar(255) DEFAULT NULL COMMENT '权限参数，如：主页|商品管理|用户管理|后台管理',
  `create_time` timestamp NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '普通用户', 'user', '主页|商品管理', '2019-03-28 19:43:08');
INSERT INTO `sys_role` VALUES (2, '管理员', 'admin', '主页|用户管理|商品管理|后台管理', '2019-03-28 19:43:33');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
