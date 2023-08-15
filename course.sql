/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : chicken

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2023-08-15 12:28:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_no` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `course_state` int NOT NULL,
  `course_money` double DEFAULT NULL,
  `course_teacher_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `course_teacher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
