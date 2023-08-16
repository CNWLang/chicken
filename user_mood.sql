
CREATE TABLE `user_mood` (
  `user_email` int(11) NOT NULL AUTO_INCREMENT,
  `mood` varchar(255) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



