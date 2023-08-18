/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : chicken

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2023-08-16 09:14:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users_course
-- ----------------------------
DROP TABLE IF EXISTS `users_course`;
CREATE TABLE `users_course` (
  `user_id` int NOT NULL,
  `course_id` int NOT NULL,
  `date_enrolled` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `users_course_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `users_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
