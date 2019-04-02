/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-02 22:19:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent
-- ----------------------------
INSERT INTO `agent` VALUES ('1', 'admin', 'admin', '112', null, '1', null, '2019-03-31 11:49:02', '2019-03-31 11:49:06');
INSERT INTO `agent` VALUES ('2', 'admin1', '123456', '12345654456', '1@1.com', null, null, '2019-03-31 15:17:54', '2019-03-31 15:17:54');
INSERT INTO `agent` VALUES ('3', 'haha', '1234567', '12345678911', '123@qq.com', null, null, '2019-03-31 15:22:34', '2019-03-31 16:03:28');

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `count` varchar(255) DEFAULT NULL,
  `bdate` varchar(255) DEFAULT NULL,
  `edate` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve
-- ----------------------------

-- ----------------------------
-- Table structure for jiudian
-- ----------------------------
DROP TABLE IF EXISTS `jiudian`;
CREATE TABLE `jiudian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '酒店名字',
  `dizhi` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jiudian
-- ----------------------------

-- ----------------------------
-- Table structure for kefang
-- ----------------------------
DROP TABLE IF EXISTS `kefang`;
CREATE TABLE `kefang` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `chuang` varchar(255) DEFAULT NULL,
  `ren` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kefang
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) DEFAULT NULL,
  `appuser` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `appuser` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for pingjia
-- ----------------------------
DROP TABLE IF EXISTS `pingjia`;
CREATE TABLE `pingjia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `adddate` varchar(255) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pingjia
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `person` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `comment` varchar(2048) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '大床房', '150', '2', '30', '无早', '2019-03-31 20:42:13', '2019-04-01 21:42:46');
INSERT INTO `room` VALUES ('2', '双人房', '200', '2', '20', '18楼', '2019-03-31 20:46:47', '2019-04-01 21:42:34');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '郑德涛', '123456', '男', '24', '13414876780', '湛江', '13414876780@163.com');

-- ----------------------------
-- Table structure for yuding
-- ----------------------------
DROP TABLE IF EXISTS `yuding`;
CREATE TABLE `yuding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `fang` varchar(255) DEFAULT NULL,
  `count` varchar(255) DEFAULT NULL,
  `bdate` varchar(255) DEFAULT NULL,
  `edate` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `fangkuan` varchar(255) DEFAULT NULL,
  `ism` varchar(255) DEFAULT NULL,
  `mtel` varchar(255) DEFAULT NULL,
  `tradeno` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yuding
-- ----------------------------
