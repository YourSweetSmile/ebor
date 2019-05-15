/*
 Navicat Premium Data Transfer
 测试用

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : ebor

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/05/2019 20:44:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `test_sys_user`;
CREATE TABLE `test_sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_no` varchar(50) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_no` (`login_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of test_sys_user
-- ----------------------------
BEGIN;
INSERT INTO `test_sys_user` VALUES (1, 'admin', 'admin', 102.20, '2019-05-15 20:42:39');
INSERT INTO `test_sys_user` VALUES (2, 'root', 'root', 39.02, '2019-05-15 20:43:00');
INSERT INTO `test_sys_user` VALUES (3, 'user1', 'user1', 10.00, '2019-05-15 20:43:29');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
