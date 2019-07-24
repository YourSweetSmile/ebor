/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.26-log : Database - db_ebor
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_ebor` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_ebor`;

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_remark` varchar(100) NOT NULL,
  `jurisdiction` varchar(50) DEFAULT NULL COMMENT '权限参数，如：主页|商品管理|用户管理|后台管理',
  `create_time` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

LOCK TABLES `sys_role` WRITE;

insert  into `sys_role`(`role_id`,`role_name`,`role_remark`,`jurisdiction`,`create_time`) values (1,'普通用户','user','主页|商品管理','1559803939012'),(2,'管理员','admin','主页|用户管理|商品管理|后台管理','1559803939012');

UNLOCK TABLES;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

LOCK TABLES `sys_user` WRITE;

insert  into `sys_user`(`user_id`,`user_name`,`password`,`role_id`,`create_time`) values (1,'jack','123456',1,'1559803939012'),(2,'admin','123456',2,'1559803939012');

UNLOCK TABLES;

/*Table structure for table `test_sys_user` */

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

/*Data for the table `test_sys_user` */

LOCK TABLES `test_sys_user` WRITE;

insert  into `test_sys_user`(`user_id`,`login_no`,`user_name`,`user_amount`,`create_time`) values (1,'admin','admin','102.20','1559803939012'),(2,'root','root','39.02','1559803939012'),(3,'user1','user1','10.00','1559803939012');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
