/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : chicken

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2023-08-15 17:43:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mood
-- ----------------------------
DROP TABLE IF EXISTS `mood`;
CREATE TABLE `mood` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mood` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
