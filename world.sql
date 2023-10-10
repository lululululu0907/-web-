/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : world

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 10/10/2023 15:00:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `LessonName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `applicant` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sdata` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sdata2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `applyreason` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `reason1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `reason2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `conform` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`code`, `applicant`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('569b', 'cs2', 'zhangsan', 'pass', NULL, 'I want to go home2', '', NULL, NULL);
INSERT INTO `lesson` VALUES ('6509', 'english', 'zhangsan', 'pass', 'pass', 'I want to go home2', 'GO HOME NOW', NULL, NULL);
INSERT INTO `lesson` VALUES ('7012', 'mathe', 'wangwu', 'pass', 'pass', 'I want to go home2', 'GO HOME NOW', NULL, NULL);
INSERT INTO `lesson` VALUES ('7643', 'chinese', 'zhangsan', 'pass', 'pass', 'I want to go home2', 'GO HOME NOW', NULL, 'a');
INSERT INTO `lesson` VALUES ('8676', 'mathe', 'lbr', 'nopass', 'pass', 'I want to go home2', 'GO HOME NOW', NULL, NULL);
INSERT INTO `lesson` VALUES ('d36r', 'mathe', 'zhangsan', 'nopass', 'pass', 'I want to go home2', 'GO HOME NOW', NULL, NULL);
INSERT INTO `lesson` VALUES ('d443', 'chinese', 'lbr', 'pass', 'pass', 'I want to go home', 'GO HOME NOW', NULL, NULL);

-- ----------------------------
-- Table structure for lessonmanage
-- ----------------------------
DROP TABLE IF EXISTS `lessonmanage`;
CREATE TABLE `lessonmanage`  (
  `lessonname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `teacher` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `manager` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lessonmanage
-- ----------------------------
INSERT INTO `lessonmanage` VALUES ('chinese', 'lisi', 'liuhua');
INSERT INTO `lessonmanage` VALUES ('english', 'lisi', 'liuhua');
INSERT INTO `lessonmanage` VALUES ('mathe', 'lisi', 'liuhua');
INSERT INTO `lessonmanage` VALUES ('cs2', 'lisi', 'liuhua');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('lbr', '777', 'student');
INSERT INTO `user` VALUES ('lisa', '123', 'administrators');
INSERT INTO `user` VALUES ('lisi', '1234', 'teacher');
INSERT INTO `user` VALUES ('liuhua', '777', 'manager');
INSERT INTO `user` VALUES ('wangwu', '666', 'student');
INSERT INTO `user` VALUES ('zhangsan', '123', 'student');

SET FOREIGN_KEY_CHECKS = 1;
