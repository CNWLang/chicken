/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : chicken

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2023-08-15 12:28:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `actions` int DEFAULT '0',
  `address_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address_province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `is_student` tinyint(1) DEFAULT '1',
  `online` tinyint(1) DEFAULT '0',
  `password` varchar(255) NOT NULL,
  `reg_time` varchar(255) DEFAULT NULL,
  `true_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `position` varchar(511) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
