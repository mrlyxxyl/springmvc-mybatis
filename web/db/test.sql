/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-08-06 19:19:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT '',
  `age` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_age` (`age`) USING BTREE,
  KEY `index_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'q', '1');
INSERT INTO `person` VALUES ('2', 'a', '2');
INSERT INTO `person` VALUES ('3', 'z', '3');
INSERT INTO `person` VALUES ('4', 'w', '4');
INSERT INTO `person` VALUES ('5', 's', '5');
INSERT INTO `person` VALUES ('6', 'x', '6');
INSERT INTO `person` VALUES ('7', 'e', '7');
INSERT INTO `person` VALUES ('8', 'd', '8');
INSERT INTO `person` VALUES ('9', 'c', '9');
INSERT INTO `person` VALUES ('10', 'r', '10');
INSERT INTO `person` VALUES ('11', 'f', '11');
INSERT INTO `person` VALUES ('12', 'v', '12');
INSERT INTO `person` VALUES ('13', 't', '13');
INSERT INTO `person` VALUES ('14', 'g', '14');
INSERT INTO `person` VALUES ('15', 'b', '15');
INSERT INTO `person` VALUES ('16', 'y', '16');
INSERT INTO `person` VALUES ('17', 'h', '17');
INSERT INTO `person` VALUES ('18', 'n', '18');
INSERT INTO `person` VALUES ('19', 'u', '19');
INSERT INTO `person` VALUES ('20', 'j', '20');
INSERT INTO `person` VALUES ('21', 'm', '21');
INSERT INTO `person` VALUES ('22', 'i', '22');
INSERT INTO `person` VALUES ('23', 'k', '23');
INSERT INTO `person` VALUES ('24', 'o', '24');
INSERT INTO `person` VALUES ('25', 'l', '25');
INSERT INTO `person` VALUES ('26', 'p', '26');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(20) COLLATE utf8_bin DEFAULT '',
  `tid` int(11) DEFAULT '0',
  PRIMARY KEY (`sid`),
  KEY `teacher_id` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 's1', '1');
INSERT INTO `student` VALUES ('2', 's2', '1');
INSERT INTO `student` VALUES ('3', 's3', '2');
INSERT INTO `student` VALUES ('4', 's4', '2');
INSERT INTO `student` VALUES ('5', 's5', '3');
INSERT INTO `student` VALUES ('6', 's6', '3');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 't1');
INSERT INTO `teacher` VALUES ('2', 't2');
INSERT INTO `teacher` VALUES ('3', 't3');

-- ----------------------------
-- Procedure structure for `my_pro`
-- ----------------------------
DROP PROCEDURE IF EXISTS `my_pro`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `my_pro`()
BEGIN
	SELECT * FROM person;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `queryStudents`
-- ----------------------------
DROP PROCEDURE IF EXISTS `queryStudents`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `queryStudents`()
BEGIN

	SELECT s.sid,s.student_name,t.teacher_name FROM student s LEFT JOIN teacher t ON t.id = s.tid WHERE s.sid = 1;
END
;;
DELIMITER ;
