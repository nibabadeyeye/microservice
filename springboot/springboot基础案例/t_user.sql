/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 18/10/2018 17:34:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'session', 11, '男');
INSERT INTO `t_user` VALUES (2, 'cooking', 11, '女');
INSERT INTO `t_user` VALUES (3, 'application', 22, '妖');
INSERT INTO `t_user` VALUES (4, 'config', 11, '男');
INSERT INTO `t_user` VALUES (5, 'page', 55, '男');
INSERT INTO `t_user` VALUES (6, 'execption', 55, '男');
INSERT INTO `t_user` VALUES (7, 'pageContext', 77, '男');
INSERT INTO `t_user` VALUES (11, 'kk', 6, NULL);
INSERT INTO `t_user` VALUES (21, 'QQ', 55, NULL);

SET FOREIGN_KEY_CHECKS = 1;
