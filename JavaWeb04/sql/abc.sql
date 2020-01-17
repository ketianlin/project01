/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : abc

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-01-17 13:41:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', 'java从入门到放弃', '80.00', '国哥', '9999', '9', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('2', '数据结构与算法', '78.50', '严敏君', '7', '12', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('3', '怎样拐跑别人的媳妇', '68.00', '龙伍', '100000', '51', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('4', '木虚肉盖饭', '16.00', '小胖', '1001', '49', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('5', 'C++编程思想', '45.50', '刚哥', '14', '95', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('6', '蛋炒饭', '9.90', '周星星', '12', '53', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('7', '赌神', '66.50', '龙伍', '125', '535', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('8', 'Java编程思想', '99.50', '阳哥', '47', '36', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('9', 'JavaScript从入门到精通', '9.90', '婷姐', '85', '95', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('10', 'cocos2d-x游戏编程入门', '49.00', '国哥', '52', '62', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('11', 'C语言程序设计', '28.00', '谭浩强', '52', '74', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('12', 'Lua语言程序设计', '51.50', '雷丰阳', '48', '82', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('13', '西游记', '12.00', '罗贯中', '19', '9999', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('14', '水浒传', '33.05', '华仔', '22', '88', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('15', '操作系统原理', '133.05', '刘优', '122', '188', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('16', '数据结构 java版', '173.15', '封大神', '21', '81', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('17', 'UNIX高级环境编程', '99.15', '乐天', '210', '810', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('18', 'javaScript高级编程', '69.15', '国哥', '210', '810', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('19', '大话设计模式', '89.15', '国哥', '20', '10', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('20', '人月神话', '88.15', '刚哥', '20', '80', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('22', '时间简史456', '30.00', '霍金12', '20012', '30022', 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', 'admin@atguigu.com');
INSERT INTO `t_user` VALUES ('2', '张三', '123456', 'zhangsan@qq.com');
INSERT INTO `t_user` VALUES ('34', 'abcabc123', '111111', 'abcabc123@qq.com');
INSERT INTO `t_user` VALUES ('35', 'zhangsan', '111111', 'zhangsan@qq.com');

-- ----------------------------
-- Table structure for x
-- ----------------------------
DROP TABLE IF EXISTS `x`;
CREATE TABLE `x` (
  `套餐ID` varchar(255) DEFAULT NULL,
  `原价` varchar(255) DEFAULT NULL,
  `挂网` varchar(255) DEFAULT NULL,
  `套餐名称` varchar(255) DEFAULT NULL,
  `别名` varchar(255) DEFAULT NULL,
  `订单量` varchar(255) DEFAULT NULL,
  `短名称` varchar(255) DEFAULT NULL,
  `结算` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x
-- ----------------------------
INSERT INTO `x` VALUES ('60792', '2786', '930', '爱康体检套餐40岁以下（男）', null, '56', '体检套餐40岁以下（男）', '835.8');
INSERT INTO `x` VALUES ('60793', '2723', '930', '爱康体检套餐40岁以下（未婚女）', null, '38', '体检套餐40岁以下（未婚女）', '816.9');
INSERT INTO `x` VALUES ('60794', '2681', '930', '爱康体检套餐40岁以下（已婚女）', null, '49', '体检套餐40岁以下（已婚女）', '804.3');
INSERT INTO `x` VALUES ('60795', '3447', '930', '爱康VIP体检套餐40岁以下（男）', null, '57', 'VIP体检套餐40岁以下（男）', '1034.1');
INSERT INTO `x` VALUES ('60796', '3368', '930', '爱康VIP体检套餐40岁以下（未婚女）', null, '67', 'VIP体检套餐40岁以下（未婚女）', '1010.4');
INSERT INTO `x` VALUES ('60797', '3317', '930', '爱康VIP体检套餐40岁以下（已婚女）', null, '81', 'VIP体检套餐40岁以下（已婚女）', '995.1');
INSERT INTO `x` VALUES ('60798', '3539', '1400', '爱康体检套餐40岁以上（男）', null, '45', '体检套餐40岁以上（男）', '1061.7');
INSERT INTO `x` VALUES ('60799', '3665', '1400', '爱康体检套餐40岁以上（未婚女）', null, '67', '体检套餐40岁以上（未婚女）', '1099.5');
INSERT INTO `x` VALUES ('60801', '3896', '1400', '爱康体检套餐40岁以上（已婚女）', null, '82', '体检套餐40岁以上（已婚女）', '1168.8');
INSERT INTO `x` VALUES ('60803', '4178', '1400', '爱康VIP体检套餐40岁以上（男）', null, '55', 'VIP体检套餐40岁以上（男）', '1253.4');
INSERT INTO `x` VALUES ('60804', '4334', '1400', '爱康VIP体检套餐40岁以上（未婚女）', null, '85', 'VIP体检套餐40岁以上（未婚女）', '1300.2');
INSERT INTO `x` VALUES ('60805', '4621', '1400', '爱康VIP体检套餐40岁以上（已婚女）', null, '91', 'VIP体检套餐40岁以上（已婚女）', '1386.3');
INSERT INTO `x` VALUES ('60806', '2249', '930', '美年大体检套餐40岁以下（男）', null, '33', '体检套餐40岁以下（男）', '670');
INSERT INTO `x` VALUES ('60807', '2189', '930', '美年大体检套餐40岁以下（未婚女）', null, '68', '体检套餐40岁以下（未婚女）', '650');
INSERT INTO `x` VALUES ('60808', '2299', '930', '美年大体检套餐40岁以下（已婚女）', null, '93', '体检套餐40岁以下（已婚女）', '770');
INSERT INTO `x` VALUES ('60809', '2449', '1400', '美年大体检套餐40岁以上（男）', null, '48', '体检套餐40岁以上（男）', '760');
INSERT INTO `x` VALUES ('60810', '2579', '1400', '美年大体检套餐40岁以上（未婚女）', null, '61', '体检套餐40岁以上（未婚女）', '800');
INSERT INTO `x` VALUES ('60811', '2809', '1400', '美年大体检套餐40岁以上（已婚女）', null, '92', '体检套餐40岁以上（已婚女）', '950');
INSERT INTO `x` VALUES ('60813', '2882', '930', '慈铭体检套餐40岁以下（男）', null, '35', '体检套餐40岁以下（男）', '778');
INSERT INTO `x` VALUES ('60815', '2846', '930', '慈铭体检套餐40岁以下（未婚女）', null, '64', '体检套餐40岁以下（未婚女）', '769');
INSERT INTO `x` VALUES ('60816', '2826', '930', '慈铭体检套餐40岁以下（已婚女）', null, '79', '体检套餐40岁以下（已婚女）', '763');
INSERT INTO `x` VALUES ('60818', '3763', '1400', '慈铭体检套餐40岁以上（男）', null, '61', '体检套餐40岁以上（男）', '1017');
INSERT INTO `x` VALUES ('60819', '3913', '1400', '慈铭体检套餐40岁以上（未婚女）', null, '85', '体检套餐40岁以上（未婚女）', '1057');
INSERT INTO `x` VALUES ('60820', '4153', '1400', '慈铭体检套餐40岁以上（已婚女）', null, '47', '体检套餐40岁以上（已婚女）', '1122');
INSERT INTO `x` VALUES ('60822', '3722', '930', '慈铭VIP体检套餐40岁以下（男）', null, '66', 'VIP体检套餐40岁以下（男）', '1005');
INSERT INTO `x` VALUES ('60826', '3742', '930', '慈铭VIP体检套餐40岁以下（未婚女）', null, '82', 'VIP体检套餐40岁以下（未婚女）', '1010');
INSERT INTO `x` VALUES ('60828', '3722', '930', '慈铭VIP体检套餐40岁以下（已婚女）', null, '95', 'VIP体检套餐40岁以下（已婚女）', '1005');
INSERT INTO `x` VALUES ('60829', '4514', '1400', '慈铭VIP体检套餐40岁以上（男）', null, '77', 'VIP体检套餐40岁以上（男）', '1219');
INSERT INTO `x` VALUES ('60830', '4664', '1400', '慈铭VIP体检套餐40岁以上（未婚女）', null, '85', 'VIP体检套餐40岁以上（未婚女）', '1259');
INSERT INTO `x` VALUES ('60831', '4904', '1400', '慈铭VIP体检套餐40岁以上（已婚女）', null, '96', 'VIP体检套餐40岁以上（已婚女）', '1324');
INSERT INTO `x` VALUES ('60832', '2249', '930', '美年大VIP体检套餐40岁以下（男）', null, '75', 'VIP体检套餐40岁以下（男）', '870');
INSERT INTO `x` VALUES ('60833', '2189', '930', '美年大VIP体检套餐40岁以下（未婚女）', null, '85', 'VIP体检套餐40岁以下（未婚女）', '850');
INSERT INTO `x` VALUES ('60834', '2299', '930', '美年大VIP体检套餐40岁以下（已婚女）', null, '91', 'VIP体检套餐40岁以下（已婚女）', '970');
INSERT INTO `x` VALUES ('60835', '2449', '1400', '美年大VIP体检套餐40岁以上（男）', null, '67', 'VIP体检套餐40岁以上（男）', '960');
INSERT INTO `x` VALUES ('60836', '2579', '1400', '美年大VIP体检套餐40岁以上（未婚女）', null, '85', 'VIP体检套餐40岁以上（未婚女）', '1000');
INSERT INTO `x` VALUES ('60837', '2809', '1400', '美年大VIP体检套餐40岁以上（已婚女）', null, '99', 'VIP体检套餐40岁以上（已婚女）', '1150');
INSERT INTO `x` VALUES ('60879', '2786', '930', '爱康体检套餐40岁以下（未婚男）', null, '62', '体检套餐40岁以下（未婚男）', '835.8');
INSERT INTO `x` VALUES ('60880', '3447', '930', '爱康VIP体检套餐40岁以下（未婚男）', null, '69', 'VIP体检套餐40岁以下（未婚男）', '1034.1');
INSERT INTO `x` VALUES ('60881', '2249', '930', '美年大体检套餐40岁以下（未婚男）', null, '68', '体检套餐40岁以下（未婚男）', '670');
INSERT INTO `x` VALUES ('60882', '2249', '930', '美年大VIP体检套餐40岁以下（未婚男）', null, '71', 'VIP体检套餐40岁以下（未婚男）', '870');
INSERT INTO `x` VALUES ('60883', '2882', '930', '慈铭体检套餐40岁以下（未婚男）', null, '75', '体检套餐40岁以下（未婚男）', '778');
INSERT INTO `x` VALUES ('60884', '3752', '930', '慈铭VIP体检套餐40岁以下（未婚男）', null, '79', 'VIP体检套餐40岁以下（未婚男）', '1005');
